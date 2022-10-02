package com.assignment.cosmos.controller;


import com.assignment.cosmos.model.DecisionDto;
import com.assignment.cosmos.request.DecisionRequest;
import com.assignment.cosmos.request.MeetingRequest;
import com.assignment.cosmos.response.ApiResponse;
import com.assignment.cosmos.service.DecisionService;
import com.assignment.cosmos.service.MeetingService;
import com.assignment.cosmos.utils.Util;
import lombok.experimental.ExtensionMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;



@RestController
@ExtensionMethod({Util.class})
public class AssignmentResourceImpl implements AssignmentResource {
    private final MeetingService meetingService;
     private final DecisionService decisionService;

     @Autowired
    public AssignmentResourceImpl(MeetingService meetingService, DecisionService decisionService) {
        this.meetingService = meetingService;
        this.decisionService = decisionService;
    }

    @Override
    public ResponseEntity<ApiResponse> createMeeting(MeetingRequest meetingRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ApiResponse response = "Please check if any of the Meeting details provided are null".toFailureExecution();
            return ResponseEntity.badRequest().body(response);
        }
        return meetingService.createMeeting(meetingRequest);
    }

    @Override
    public ResponseEntity<ApiResponse> createDecision(DecisionRequest decisionRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ApiResponse response = "Please check if any of the Decision details provided are null".toFailureExecution();
            return ResponseEntity.badRequest().body(response);
        }
        return decisionService.createDecision(decisionRequest);
    }

    @Override
    public ResponseEntity<DecisionDto> getMeetingWithDecisions(String decision) {
        return ResponseEntity.ok(decisionService.listMeetingwithDecisions(decision));
    }
}