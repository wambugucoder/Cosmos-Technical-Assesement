package com.assignment.cosmos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@AllArgsConstructor
public class DecisionRequest {

   @NotNull(message = "Decision cannot be null")
    private String text;
   @NotNull(message = "Meeting Id is required")
    private String meetingId;
}