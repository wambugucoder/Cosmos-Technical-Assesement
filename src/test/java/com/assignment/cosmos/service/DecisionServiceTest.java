package com.assignment.cosmos.service;


import com.assignment.cosmos.model.MeetingDto;
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
@ExtensionMethod({Util.class})
class DecisionServiceTest {



    @Test
    void createDecision() {
        MeetingRepository meetingRepository = mock(MeetingRepository.class);

        DecisionService decisionService = new DecisionService(meetingRepository);

        when(meetingRepository.getById(any(String.class))).thenReturn(meetingDto);
        ResponseEntity<ApiResponse> actual = decisionService.createDecision(decisionRequest);
        verify(meetingRepository).save(any(MeetingDto.class));
        assert (actual.equals(ResponseEntity.ok("Decision Created Successfully".toSuccessExecution())));
    }


}