package com.yoti.springcleaning.service;

import com.yoti.springcleaning.dto.ExecutionResultDto;
import com.yoti.springcleaning.persistence.*;
import com.yoti.springcleaning.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CleaningServiceImplTest {

    @Mock
    SpringCleanRepository springCleanRepo;

    @Mock
    CoordinateRepository coordinateRepo;

    @Mock
    InputPatchesRepository inputPatchesRepo;

    @Mock
    InputRepository inputRepo;

    @Mock
    OutputRepository outputRepo;

    @InjectMocks
    private CleaningServiceImpl cleaningService;

    @Test
    public void when_executeCleaningInstructions_then_correct_executionResult_is_returned() {
        // Given
        List<Integer> roomSize = Arrays.asList(5, 5);
        List<Integer> coords = Arrays.asList(1, 2);
        List<List<Integer>> patches = Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 2), Arrays.asList(2, 3));
        String instructions = "NNESEESWNWW";

        when(springCleanRepo.save(any(SpringClean.class))).thenReturn(new SpringClean());
        when(coordinateRepo.save(any(Coordinate.class))).thenReturn(new Coordinate());
        when(inputPatchesRepo.save(any(InputPatches.class))).thenReturn(new InputPatches());
        when(inputRepo.save(any(Input.class))).thenReturn(new Input());
        when(outputRepo.save(any(Output.class))).thenReturn(new Output());

        // When
        ExecutionResultDto actual = cleaningService.executeCleaningInstructions(roomSize, coords, patches, instructions);

        // Then
        assertThat(actual.getCoords(), is(equalTo(Arrays.asList(1, 3))));
        assertThat(actual.getPatches(), is(equalTo(1)));
    }
}