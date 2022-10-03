package com.assignment.cosmos.controller;

import com.assignment.cosmos.request.DecisionRequest;
import com.assignment.cosmos.request.MeetingRequest;
import com.assignment.cosmos.response.ApiResponse;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface AssignmentResource {

    @PostMapping (value = "/api/meeting/create-meeting",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Timed(value = "api.create.meeting", description = "Execution time for Creating new meetings")
    ResponseEntity<ApiResponse> createMeeting(@RequestBody @Valid MeetingRequest meetingRequest, BindingResult bindingResult);


    @PostMapping (value = "/api/decision/create-decision",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Timed(value = "api.create.decision", description = "Execution time for Creating new decisions")
    ResponseEntity<ApiResponse> createDecision(@RequestBody @Valid DecisionRequest decisionRequest,BindingResult bindingResult);

    @GetMapping(value = "/api/meeting/all")
    @Timed(value = "api.fetch.meeting", description = "Execution time for fetching meetings")
    ResponseEntity<?> getMeetingWithDecisions();



}