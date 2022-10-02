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



@Service
@Slf4j
@ExtensionMethod({Util.class})
public class DecisionService {

    private final DecisionRepository decisionRepository;
    private final MeetingRepository meetingRepository;
    @Autowired
    public DecisionService(DecisionRepository decisionRepository, MeetingRepository meetingRepository) {
        this.decisionRepository = decisionRepository;
        this.meetingRepository = meetingRepository;
    }

    public ResponseEntity<ApiResponse> createDecision(DecisionRequest decisionRequest){
        MeetingDto meetingDto = meetingRepository.getById(decisionRequest.getMeetingId());
        DecisionDto decisionDto = new DecisionDto();
        decisionDto.setMeeting(meetingDto);
        decisionDto.setText(decisionRequest.getText());


        decisionRepository.save(decisionDto);
        log.info("Decision has Been Created for meeting with title:"+meetingDto.getTitle());
        return ResponseEntity.ok("Decision Created Successfully".toSuccessExecution());
    }

    public DecisionDto listMeetingwithDecisions(String decision) {
       return decisionRepository.findByText(decision);
    }
}