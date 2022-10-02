package com.assignment.cosmos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
@Component
public class TraceRequestConfig implements Filter {


    private final Tracer tracer;
    @Autowired
    public TraceRequestConfig(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Span span = tracer.currentSpan();
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if(span!=null){
            httpServletResponse.setHeader("traceId", span.context().traceId());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}