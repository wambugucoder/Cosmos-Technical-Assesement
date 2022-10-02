package com.assignment.cosmos.config;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static com.assignment.cosmos.CommonFixtures.SPAN;
import static com.assignment.cosmos.CommonFixtures.getTestTrace;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class TraceRequestConfigTest {


    private final Tracer tracer = getTestTrace();


    @InjectMocks
    private final TraceRequestConfig traceRequestConfig = new TraceRequestConfig(tracer);

    @Before
    @SneakyThrows
    public void initialize() {
        doReturn(SPAN).when(tracer).currentSpan();

    }

    @Test
    void init() {
        MockFilterConfig mockFilterConfig = new MockFilterConfig();
        traceRequestConfig.init(mockFilterConfig);
    }

    @Test
    void doFilter() throws ServletException, IOException {
        HttpServletRequest req = new MockHttpServletRequest();
        HttpServletResponse res = new MockHttpServletResponse();
        FilterChain chain = new MockFilterChain();
        traceRequestConfig.doFilter(req, res, chain);
        assertEquals(SPAN.context().traceId(), res.getHeader("traceId"));


    }

    @Test
    void destroy() {
        traceRequestConfig.destroy();
    }

}