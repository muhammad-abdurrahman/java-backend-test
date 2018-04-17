package com.yoti.springcleaning.service;

import com.yoti.springcleaning.dto.ExecutionResultDto;
import com.yoti.springcleaning.entity.Coordinate;
import com.yoti.springcleaning.entity.DirtCollector;
import com.yoti.springcleaning.entity.Room;
import com.yoti.springcleaning.enums.CardinalDirections;
import com.yoti.springcleaning.persistence.Input;
import com.yoti.springcleaning.persistence.InputPatches;
import com.yoti.springcleaning.persistence.Output;
import com.yoti.springcleaning.persistence.SpringClean;
import com.yoti.springcleaning.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CleaningServiceImpl implements CleaningService {

    private final SpringCleanRepository springCleanRepo;
    private final CoordinateRepository coordinateRepo;
    private final InputPatchesRepository inputPatchesRepo;
    private final InputRepository inputRepo;
    private final OutputRepository outputRepo;

    @Autowired
    public CleaningServiceImpl(SpringCleanRepository springCleanRepo,
                               CoordinateRepository coordinateRepo,
                               InputPatchesRepository inputPatchesRepo,
                               InputRepository inputRepo,
                               OutputRepository outputRepo) {
        this.springCleanRepo = springCleanRepo;
        this.coordinateRepo = coordinateRepo;
        this.inputPatchesRepo = inputPatchesRepo;
        this.inputRepo = inputRepo;
        this.outputRepo = outputRepo;
    }

    @Override
    public ExecutionResultDto executeCleaningInstructions(List<Integer> roomSize, List<Integer> coords,
                                                          List<List<Integer>> patches, String instructions) {
        HashSet<Coordinate> dirtPatches = getDirtyPatchesCoordinateSetFromList(patches);
        int initialDirtPatchesSize = dirtPatches.size();
        Room room = new Room(listToCoord(roomSize), dirtPatches);

        DirtCollector dirtCollector = new DirtCollector(room, listToCoord(coords));

        Arrays.stream(instructions.split("")).forEach(direction ->
                dirtCollector.moveInDirection(CardinalDirections.valueOf(direction)));

        ExecutionResultDto executionResult = ExecutionResultDto
                .builder()
                .coords(coordToList(dirtCollector.getCurrentLocationInRoom()))
                .patches(initialDirtPatchesSize - dirtCollector.getRoom().getDirtPatchSize())
                .build();

        persistToDb(roomSize, coords, patches, instructions, executionResult);

        return executionResult;
    }

    private void persistToDb(List<Integer> roomSize, List<Integer> coords, List<List<Integer>> patches, String instructions, ExecutionResultDto executionResult) {
        Input input = inputRepo.save(Input.builder()
                .roomSize(coordinateRepo.save(com.yoti.springcleaning.persistence.Coordinate
                        .builder()
                        .x(roomSize.get(0))
                        .y(roomSize.get(1))
                        .build()))
                .instructions(instructions)
                .build());

        Collection<InputPatches> inputPatches = new ArrayList<>();
        patches.forEach(inputPatchList -> inputPatches
                .add(inputPatchesRepo.save(InputPatches
                        .builder()
                        .idCoordinate(
                                coordinateRepo.save(com.yoti.springcleaning.persistence.Coordinate
                                        .builder()
                                        .x(inputPatchList.get(0))
                                        .y(inputPatchList.get(1))
                                        .build()))
                        .idInput(input)
                        .build())
                )
        );

        Output output = outputRepo.save(Output
                .builder()
                .coords(coordinateRepo.save(com.yoti.springcleaning.persistence.Coordinate
                    .builder()
                    .x(executionResult.getCoords().get(0))
                    .y(executionResult.getCoords().get(1))
                    .build()))
                .patches(executionResult.getPatches())
                .build());

        SpringClean springClean = SpringClean.builder().idInput(input).idOutput(output).build();

        springCleanRepo.save(springClean);
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
