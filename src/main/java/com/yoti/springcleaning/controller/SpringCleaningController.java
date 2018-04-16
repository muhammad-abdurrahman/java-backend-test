package com.yoti.springcleaning.controller;

import com.yoti.springcleaning.command.InputPayloadCmd;
import com.yoti.springcleaning.dto.ExecutionResultDto;
import com.yoti.springcleaning.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/spring-cleaner")
public class SpringCleaningController {

    private final CleaningService cleaningService;

    @Autowired
    public SpringCleaningController(CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }

    @PostMapping("/execute")
    public ExecutionResultDto execute(@Valid @RequestBody InputPayloadCmd inputPayloadCmd){
        return this.cleaningService.executeCleaningInstructions(inputPayloadCmd.getRoomSize(),
                inputPayloadCmd.getCoords(), inputPayloadCmd.getPatches(), inputPayloadCmd.getInstructions());
    }
}
