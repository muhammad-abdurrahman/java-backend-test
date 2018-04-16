package com.yoti.springcleaning.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class ExecutionResultDto {
    @Size(min = 2, max = 2)
    private List<Integer> coords;
    private int patches;
}
