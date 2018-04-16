package com.yoti.springcleaning.service;

import com.yoti.springcleaning.command.InputPayloadCmd;
import com.yoti.springcleaning.dto.ExecutionResultDto;
import com.yoti.springcleaning.entity.Coordinate;
import com.yoti.springcleaning.entity.DirtCollector;
import com.yoti.springcleaning.entity.Room;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CleaningServiceImpl implements CleaningService {

    @Override
    public ExecutionResultDto executeCleaningInstructions(List<Integer> roomSize, List<Integer> coords, List<List<Integer>> patches, String instructions) {
        Room room = new Room(listToCoord(roomSize),
                getDirtyPatchesCoordinateSetFromList(patches));

        DirtCollector dirtCollector = new DirtCollector(room, listToCoord(coords));

        return null;
    }

    private Coordinate listToCoord(List<Integer> list){
        return new Coordinate(list.get(0), list.get(1));
    }

    private HashSet<Coordinate> getDirtyPatchesCoordinateSetFromList(List<List<Integer>> dirtyPatchesList){
        HashSet<Coordinate> dirtyPatches = new HashSet<>();
        dirtyPatchesList.forEach(list -> dirtyPatches.add(new Coordinate(list.get(0), list.get(1))));
        return dirtyPatches;
    }
}
