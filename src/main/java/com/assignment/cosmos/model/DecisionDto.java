package com.assignment.cosmos.model;



import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Table(name = "decision")
@Entity
public class DecisionDto {

    @Id
    @Column(name = "decision_id",unique = true)
    private String id = UUID.randomUUID().toString();

    @Column(name = "text",unique = true)
    private String text;

    @Column(name = "timestamp")
    private Timestamp timestamp= Timestamp.from(Instant.now());

    @ManyToOne
    @JoinColumn(name="meeting_id",referencedColumnName = "id")
    private MeetingDto meeting;

    public DecisionDto() {
    }

    public DecisionDto(String text,MeetingDto meeting) {
        id = getId();
        this.text=text;
       this.meeting = meeting;
    }

    public DecisionDto(String id, String text, Timestamp timestamp, MeetingDto meeting) {
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
        this.meeting = meeting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public MeetingDto getMeeting() {
        return meeting;
    }

    public void setMeeting(MeetingDto meetingDto) {
        meeting = meetingDto;
    }
}