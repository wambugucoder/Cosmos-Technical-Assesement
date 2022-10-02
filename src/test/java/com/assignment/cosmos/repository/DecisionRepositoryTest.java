package com.assignment.cosmos.repository;

import com.assignment.cosmos.TestContainer;
import com.assignment.cosmos.model.DecisionDto;
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
class DecisionRepositoryTest {

    private final DecisionRepository decisionRepository;

    @Autowired
    public DecisionRepositoryTest(DecisionRepository decisionRepository){
        this.decisionRepository=decisionRepository;
    }

    @Test
    @Transactional
    public void create_decision() {
        insertDecision();
        assertEquals(1, decisionRepository.findAll().size());
    }

    @Test
    @Transactional
    public void find_by_decision(){
        DecisionDto decisionDto = new DecisionDto(RANDOM_ID,"TBD",fixedTimeStamp,null);
        decisionRepository.save(decisionDto);
        decisionRepository.flush();

        assertEquals(decisionRepository.findByText("TBD").getId(),decisionDto.getId());
    }

    private void insertDecision() {
        decisionRepository.save(new DecisionDto());
        decisionRepository.flush();
    }
}