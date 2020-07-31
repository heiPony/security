package com.pony.security.authentication;

import com.pony.utils.ReturnResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认真失败处理器
 * 决定 响应Json 还是页面跳转
 */
@Component
public class CustomerAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ReturnResult build = ReturnResult.build(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(build.toJsonString());
    }
}
