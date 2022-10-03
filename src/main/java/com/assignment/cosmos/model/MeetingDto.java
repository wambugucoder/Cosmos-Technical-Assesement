package com.assignment.cosmos.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "meeting")
@Entity
public class MeetingDto {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "title")
    private String title;

    @Column(name = "timestamp")
    private Timestamp timestamp=Timestamp.from(Instant.now());

    @Column(name = "duration")
    private Long duration;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DecisionDto> decisionDto = new ArrayList<>();

    public MeetingDto(String id, String title, Timestamp timestamp, Long duration, List<DecisionDto> decisionDto) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.duration = duration;
        this.decisionDto = decisionDto;
    }

    public MeetingDto(String title, Long duration, List<DecisionDto> decisionDto) {
        this.duration=duration;
        this.title=title;
        id = getId();
        this.decisionDto=decisionDto;
    }

    public MeetingDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<DecisionDto> getDecisionDto() {
        return decisionDto;
    }

    public void setDecisionDto(List<DecisionDto> decisionDto) {
        this.decisionDto = decisionDto;
    }
}