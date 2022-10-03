package com.assignment.cosmos.request;



import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class MeetingRequest {

    @NotNull(message = "Meeting title cannot be null")
    @NotEmpty(message = "Meeting title Cannot be Empty")
    private String title;

    @NotNull(message = "Duration is required")
    private Long duration;

}