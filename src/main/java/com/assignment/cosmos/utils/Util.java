package com.assignment.cosmos.utils;


import com.assignment.cosmos.model.DecisionDto;
import com.assignment.cosmos.model.MeetingDto;
import com.assignment.cosmos.request.MeetingRequest;
import com.assignment.cosmos.response.ApiResponse;
import java.util.UUID;
import java.util.function.Function;


public class Util {

    public static MeetingDto toMeetingDto(MeetingRequest meetingRequest) {
        MeetingDto meetingDto= new MeetingDto();
        meetingDto.setDuration(meetingRequest.getDuration());
        meetingDto.setTitle(meetingRequest.getTitle());
        return meetingDto;
    }

    public static ApiResponse toSuccessExecution(String message){
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setError(false);
        return response;
    }

    public static ApiResponse toFailureExecution(String message){
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setError(true);
        return response;
    }
    
}