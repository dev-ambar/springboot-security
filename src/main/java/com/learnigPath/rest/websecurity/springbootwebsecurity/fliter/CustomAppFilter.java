package com.learnigPath.rest.websecurity.springbootwebsecurity.fliter;

import javax.servlet.*;
import java.io.IOException;

public class CustomAppFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before the filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After the filter");
    }
}
