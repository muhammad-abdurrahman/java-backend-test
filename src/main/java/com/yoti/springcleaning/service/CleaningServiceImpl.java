package com.yoti.springcleaning.service;

import com.yoti.springcleaning.command.InputPayloadCmd;
import com.yoti.springcleaning.dto.ExecutionResultDto;
import org.springframework.stereotype.Service;

@Service
public class CleaningServiceImpl implements CleaningService {
    @Override
    public ExecutionResultDto executeCleaningInstructions(InputPayloadCmd inputPayloadCmd) {
        return null;
    }
}
