package com.yoti.springcleaning.service;

import com.yoti.springcleaning.dto.ExecutionResultDto;
import com.yoti.springcleaning.entity.Coordinate;
import com.yoti.springcleaning.entity.DirtCollector;
import com.yoti.springcleaning.entity.Room;
import com.yoti.springcleaning.enums.CardinalDirections;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class CleaningServiceImpl implements CleaningService {

    @Override
    public ExecutionResultDto executeCleaningInstructions(List<Integer> roomSize, List<Integer> coords,
                                                          List<List<Integer>> patches, String instructions) {
        HashSet<Coordinate> dirtPatches = getDirtyPatchesCoordinateSetFromList(patches);
        Room room = new Room(listToCoord(roomSize), dirtPatches);

        DirtCollector dirtCollector = new DirtCollector(room, listToCoord(coords));

        Arrays.stream(instructions.split("")).forEach(direction ->
                dirtCollector.moveInDirection(CardinalDirections.valueOf(direction)));

        return ExecutionResultDto
                .builder()
                .coords(coordToList(dirtCollector.getCurrentLocationInRoom()))
                .patches(dirtPatches.size() - dirtCollector.getRoom().getDirtPatchSize())
                .build();
    }

    private Coordinate listToCoord(List<Integer> list){
        return new Coordinate(list.get(0), list.get(1));
    }

    private List<Integer> coordToList(Coordinate coordinate){
        return Arrays.asList(coordinate.getX(), coordinate.getY());
    }

    private HashSet<Coordinate> getDirtyPatchesCoordinateSetFromList(List<List<Integer>> dirtyPatchesList){
        HashSet<Coordinate> dirtyPatches = new HashSet<>();
        dirtyPatchesList.forEach(list -> dirtyPatches.add(new Coordinate(list.get(0), list.get(1))));
        return dirtyPatches;
    }
}
