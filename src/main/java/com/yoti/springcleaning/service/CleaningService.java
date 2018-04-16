package com.yoti.springcleaning.service;

import com.yoti.springcleaning.command.InputPayloadCmd;
import com.yoti.springcleaning.dto.ExecutionResultDto;

public interface CleaningService {
    ExecutionResultDto executeCleaningInstructions(InputPayloadCmd inputPayloadCmd);
}
