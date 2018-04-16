package com.yoti.springcleaning.service;

import com.yoti.springcleaning.dto.ExecutionResultDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CleaningServiceImplTest {

    @InjectMocks
    private CleaningServiceImpl cleaningService;

    @Test
    public void when_executeCleaningInstructions_then_correct_executionResult_is_returned() {
        // Given
        List<Integer> roomSize = Arrays.asList(5,5);
        List<Integer> coords = Arrays.asList(1,2);
        List<List<Integer>> patches = Arrays.asList(Arrays.asList(1, 0), Arrays.asList(2, 2), Arrays.asList(2, 3));
        String instructions = "NNESEESWNWW";

        // When
        ExecutionResultDto actual = cleaningService.executeCleaningInstructions(roomSize, coords, patches, instructions);

        // Then
        assertThat(actual.getCoords(), is(equalTo(Arrays.asList(1,3))));
        assertThat(actual.getPatches(), is(equalTo(1)));
    }
}