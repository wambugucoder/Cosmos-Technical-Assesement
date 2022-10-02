package com.assignment.cosmos.request;


import com.assignment.cosmos.model.DecisionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class MeetingRequest {
    @NotNull(message = "Meeting title cannot be null")
    private String title;
    @NotNull(message = "Duration is required")
    private Long duration;

    private List<String> decisions;
}