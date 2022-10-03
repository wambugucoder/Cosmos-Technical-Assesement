package com.assignment.cosmos;

import com.assignment.cosmos.model.DecisionDto;
import com.assignment.cosmos.model.MeetingDto;
import com.assignment.cosmos.request.DecisionRequest;
import com.assignment.cosmos.request.MeetingRequest;
import lombok.Data;
import org.springframework.cloud.sleuth.*;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Map;



@Data
public  class CommonFixtures {

    public static String RANDOM_ID = "randomUUID";
    public static String RANDOM_ID2 = "randomUUID2";

    public static String POSTGRES_DOCKER_IMAGE = "postgres:10.3";

    static Instant instant = Instant.parse("2022-08-19T16:02:42.00Z");
    
    static ZoneId zoneId = ZoneId.of("Africa/Nairobi");


    public static Timestamp fixedTimeStamp = Timestamp.from(Instant.now(Clock.fixed(instant, zoneId)));

    public static Span SPAN = getTestTrace().currentSpan();

    public static DecisionDto createDecision() {
        DecisionDto decisionDto = new DecisionDto();
        MeetingDto meetingDto1 = new MeetingDto();
        meetingDto1.setId(RANDOM_ID);
        meetingDto1.setDuration(1L);
        meetingDto1.setDecisionDto((List.of(decisionDto)));
        decisionDto.setId(RANDOM_ID);
        decisionDto.setText("Text");
        decisionDto.setTimestamp(fixedTimeStamp);
        decisionDto.setMeeting(meetingDto1);
        return decisionDto;
    }

    public static DecisionRequest decisionRequest = new DecisionRequest(List.of("DECISION1", "DECISION2"), RANDOM_ID);

    public static MeetingRequest meetingRequest = new MeetingRequest("test", 2L);
    public static MeetingDto meetingDto = new MeetingDto(RANDOM_ID, "Title1", fixedTimeStamp, 1L, Collections.emptyList());
    public static MeetingDto meetingDto2 = new MeetingDto("Title2", 2L, List.of(createDecision()));
    public static DecisionDto decisionDto = new DecisionDto(RANDOM_ID, "DECISION", fixedTimeStamp, new MeetingDto());


    public static Tracer getTestTrace() {
        return new Tracer() {


            @Override
            public Map<String, String> getAllBaggage() {
                return null;
            }

            @Override
            public BaggageInScope getBaggage(String name) {
                return null;
            }

            @Override
            public BaggageInScope getBaggage(TraceContext traceContext, String name) {
                return null;
            }

            @Override
            public BaggageInScope createBaggage(String name) {
                return null;
            }

            @Override
            public BaggageInScope createBaggage(String name, String value) {
                return null;
            }

            @Override
            public Span nextSpan() {
                return null;
            }

            @Override
            public Span nextSpan(Span parent) {
                return null;
            }

            @Override
            public SpanInScope withSpan(Span span) {
                return null;
            }

            @Override
            public ScopedSpan startScopedSpan(String name) {
                return null;
            }

            @Override
            public Span.Builder spanBuilder() {
                return null;
            }

            @Override
            public TraceContext.Builder traceContextBuilder() {
                return null;
            }

            @Override
            public SpanCustomizer currentSpanCustomizer() {
                return null;
            }

            @Override
            public Span currentSpan() {
                return new Span() {
                    @Override
                    public boolean isNoop() {
                        return true;
                    }

                    @Override
                    public TraceContext context() {
                        return new TraceContext() {
                            @Override
                            public String traceId() {
                                return CommonFixtures.RANDOM_ID;
                            }

                            @Override
                            public String parentId() {
                                return CommonFixtures.RANDOM_ID;
                            }

                            @Override
                            public String spanId() {
                                return CommonFixtures.RANDOM_ID;
                            }

                            @Override
                            public Boolean sampled() {
                                return true;
                            }
                        };
                    }

                    @Override
                    public Span start() {
                        return null;
                    }

                    @Override
                    public Span name(String name) {
                        return null;
                    }

                    @Override
                    public Span event(String value) {
                        return null;
                    }

                    @Override
                    public Span tag(String key, String value) {
                        return null;
                    }

                    @Override
                    public Span error(Throwable throwable) {
                        return null;
                    }

                    @Override
                    public void end() {

                    }

                    @Override
                    public void abandon() {

                    }
                };
            }


        };
    }
}