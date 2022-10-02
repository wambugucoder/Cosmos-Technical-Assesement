package com.assignment.cosmos.repository;

import com.assignment.cosmos.TestContainer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;


import static com.assignment.cosmos.CommonFixtures.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = TestContainer.class)
class MeetingRepositoryTest {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingRepositoryTest(MeetingRepository meetingRepository){
        this.meetingRepository=meetingRepository;
    }

    @Test
    @Transactional
    public void find_by_Id() {
        insertMeetings();
        assertEquals(meetingDto.getId(), meetingRepository.findById(RANDOM_ID).get().getId());
    }
    @Test
    @Transactional
    public void get_all_meeting() {
        insertMeetings();
        assertEquals(1, meetingRepository.findAll().size());
    }

    private void insertMeetings() {
        meetingRepository.save(meetingDto);
        meetingRepository.flush();
    }
}