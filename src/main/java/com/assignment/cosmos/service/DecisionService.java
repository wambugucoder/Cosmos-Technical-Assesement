package com.assignment.cosmos.service;

import com.assignment.cosmos.model.DecisionDto;
import com.assignment.cosmos.model.MeetingDto;
import com.assignment.cosmos.repository.DecisionRepository;
import com.assignment.cosmos.repository.MeetingRepository;
import com.assignment.cosmos.request.DecisionRequest;
import com.assignment.cosmos.response.ApiResponse;
import com.assignment.cosmos.utils.Util;
import lombok.experimental.ExtensionMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@ExtensionMethod({Util.class})
public class DecisionService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public DecisionService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public ResponseEntity<ApiResponse> createDecision(DecisionRequest decisionRequest) {
        MeetingDto meetingDto = meetingRepository.getById(decisionRequest.getMeetingId());
        // Create copy of mutable list to avoid UnsupportedOperationException
        List<DecisionDto> decisionDtoList = meetingDto.getDecisionDto();
        List<DecisionDto> decisionToUpdate = new ArrayList<>(decisionDtoList);
        
        for (String eachDecision : decisionRequest.getText()) {
            DecisionDto decisionDto = new DecisionDto();
            decisionDto.setMeeting(meetingDto);
            decisionDto.setText(eachDecision);
            decisionToUpdate.add(decisionDto);
        }
        meetingDto.setDecisionDto(decisionToUpdate);
        meetingRepository.save(meetingDto);
        return ResponseEntity.ok("Decision Created Successfully".toSuccessExecution());
    }

}