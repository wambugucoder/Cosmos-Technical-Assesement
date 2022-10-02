package com.assignment.cosmos.repository;

import com.assignment.cosmos.model.DecisionDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<DecisionDto,String> {

    DecisionDto findByText(String text);
}