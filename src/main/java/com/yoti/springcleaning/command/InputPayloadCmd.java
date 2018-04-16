package com.yoti.springcleaning.command;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class InputPayloadCmd {
    @Size(min = 2, max = 2)
    private List<Integer> roomSize;
    @Size(min = 2, max = 2)
    private List<Integer> coords;
    private List<List<Integer>> patches;
    private String instructions;
}
