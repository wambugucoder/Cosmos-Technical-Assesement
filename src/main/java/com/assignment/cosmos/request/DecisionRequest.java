package com.assignment.cosmos.request;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
public class DecisionRequest {

    @NotNull(message = "Decision cannot be null")
    @NotEmpty(message = "Decision Cannot be Empty")
    private List<String> text;
    @NotNull(message = "Meeting Id is required")
    @NotEmpty(message = "Meeting Id cannot be empty")
    private String meetingId;
}