package com.assignment.cosmos.repository;


import com.assignment.cosmos.model.MeetingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MeetingRepository extends JpaRepository<MeetingDto, String> {

}