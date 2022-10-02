package com.assignment.cosmos.service;


import com.assignment.cosmos.model.MeetingDto;
import com.assignment.cosmos.repository.DecisionRepository;
import com.assignment.cosmos.repository.MeetingRepository;
import com.assignment.cosmos.response.ApiResponse;
import com.assignment.cosmos.utils.Util;
import lombok.experimental.ExtensionMethod;
import org.junit.jupiter.api.Test;




import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;


import static com.assignment.cosmos.CommonFixtures.*;
import static org.mockito.Mockito.*;



@SpringBootTest
@AutoConfigureMockMvc
@ExtensionMethod({Util.class})
class DecisionServiceTest {



    @Test
    void createDecision() {
        MeetingRepository meetingRepository = mock(MeetingRepository.class);
        DecisionRepository decisionRepository= mock(DecisionRepository.class);
        DecisionService decisionService= new DecisionService(decisionRepository, meetingRepository);

        when (meetingRepository.getById(any(String.class))).thenReturn(new MeetingDto());
        ResponseEntity<ApiResponse> actual = decisionService.createDecision(decisionRequest);
        verify(decisionRepository).save(any());
        assert(actual.equals(ResponseEntity.ok("Decision Created Successfully".toSuccessExecution())));
    }

    @Test
    void listMeeting() {
        MeetingRepository meetingRepository = mock(MeetingRepository.class);
        DecisionRepository decisionRepository= mock(DecisionRepository.class);
        DecisionService decisionService= new DecisionService(decisionRepository, meetingRepository);

        decisionService.listMeetingwithDecisions(RANDOM_ID);
        verify(decisionRepository).findByText(RANDOM_ID);
    }
}