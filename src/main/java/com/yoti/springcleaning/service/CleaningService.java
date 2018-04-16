package com.yoti.springcleaning.service;

import com.yoti.springcleaning.dto.ExecutionResultDto;

import java.util.List;

public interface CleaningService {
    ExecutionResultDto executeCleaningInstructions(List<Integer> roomSize, List<Integer> coords, List<List<Integer>> patches, String instructions);
}
