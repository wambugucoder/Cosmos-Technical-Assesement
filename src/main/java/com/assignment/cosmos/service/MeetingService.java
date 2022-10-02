package com.assignment.cosmos.service;


import com.assignment.cosmos.model.DecisionDto;
import com.assignment.cosmos.model.MeetingDto;
import com.assignment.cosmos.repository.DecisionRepository;
import com.assignment.cosmos.repository.MeetingRepository;
import com.assignment.cosmos.request.MeetingRequest;
import com.assignment.cosmos.response.ApiResponse;
import com.assignment.cosmos.utils.Util;
import lombok.experimental.ExtensionMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@ExtensionMethod({Util.class})
@Slf4j
public class MeetingService {

    private final MeetingRepository meetingRepository;


    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;

    }

    public ResponseEntity<ApiResponse> createMeeting(MeetingRequest meetingRequest){
        MeetingDto meetingDto = meetingRequest.toMeetingDto();
        List<String> decisions = meetingRequest.getDecisions();
        List<DecisionDto> decisionDtos = new ArrayList<>();
        for (String decision:decisions) {
            DecisionDto singleDecision = new DecisionDto(decision, meetingDto);
            decisionDtos.add(singleDecision);
        }
        meetingDto.setDecisionDto(decisionDtos);

        meetingRepository.save(meetingDto);
        log.info("Meeting created with title:"+meetingRequest.getTitle());
        ApiResponse response = new ApiResponse();
        response.setMessage("Meeting Created");
        response.setError(false);
        return ResponseEntity.ok(response);
    }

}