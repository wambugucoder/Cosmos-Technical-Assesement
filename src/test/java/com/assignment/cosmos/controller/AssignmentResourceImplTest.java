package com.assignment.cosmos.controller;

import com.assignment.cosmos.service.DecisionService;
import com.assignment.cosmos.service.MeetingService;
import com.assignment.cosmos.utils.Util;
import lombok.experimental.ExtensionMethod;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import static com.assignment.cosmos.CommonFixtures.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@SpringBootTest
@AutoConfigureMockMvc
@ExtensionMethod({Util.class})
class AssignmentResourceImplTest {

    @Test
    void createMeeting() {
         MeetingService meetingService = mock(MeetingService.class);
         DecisionService decisionService= mock(DecisionService.class);
         AssignmentResourceImpl assignmentResource= new AssignmentResourceImpl(meetingService,decisionService);
         BindingResult bindingResult = mock(BindingResult.class);

         assignmentResource.createMeeting(meetingRequest, bindingResult);
         verify(meetingService).createMeeting(meetingRequest);
    }

    @Test
    void createDecision() {
        MeetingService meetingService = mock(MeetingService.class);
        DecisionService decisionService= mock(DecisionService.class);
        AssignmentResourceImpl assignmentResource= new AssignmentResourceImpl(meetingService,decisionService);
        BindingResult bindingResult = mock(BindingResult.class);

        assignmentResource.createDecision(decisionRequest, bindingResult);
        verify(decisionService).createDecision(decisionRequest);
    }

    @Test
    void getDecisionByAssociation() {
        MeetingService meetingService = mock(MeetingService.class);
        DecisionService decisionService= mock(DecisionService.class);
        AssignmentResourceImpl assignmentResource= new AssignmentResourceImpl(meetingService,decisionService);


        assignmentResource.getMeetingWithDecisions(RANDOM_ID);
        verify(decisionService).listMeetingwithDecisions(RANDOM_ID);
    }

}