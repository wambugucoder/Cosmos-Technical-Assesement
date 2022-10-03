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

import java.util.Collections;
import java.util.List;

import static com.assignment.cosmos.CommonFixtures.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtensionMethod({Util.class})
class MeetingServiceTest {

    @Test
    void createMeeting() {
        MeetingRepository meetingRepository = mock(MeetingRepository.class);

        MeetingService meetingService= new MeetingService(meetingRepository);

        when(meetingRepository.save(any(MeetingDto.class))).thenReturn(meetingDto);

        ApiResponse response = new ApiResponse();
        response.setMessage("Meeting Created");
        response.setError(false);

        assertEquals(meetingService.createMeeting(meetingRequest), ResponseEntity.ok(response));

    }

    @Test
    void getMeeting() {
        MeetingRepository meetingRepository = mock(MeetingRepository.class);

        MeetingService meetingService = new MeetingService(meetingRepository);

        when(meetingRepository.findAll()).thenReturn(List.of(meetingDto));

        assertEquals(meetingService.getMeetings(), ResponseEntity.ok(List.of(meetingDto)));
    }

    @Test
    void getMeeting_EmptyList() {
        MeetingRepository meetingRepository = mock(MeetingRepository.class);

        MeetingService meetingService = new MeetingService(meetingRepository);

        when(meetingRepository.findAll()).thenReturn(Collections.emptyList());

        assertEquals(meetingService.getMeetings(), ResponseEntity.badRequest().body("No results found".toFailureExecution()));
    }


}