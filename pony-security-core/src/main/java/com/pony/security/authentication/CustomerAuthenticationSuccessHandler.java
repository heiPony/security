package com.pony.security.authentication;

import com.pony.utils.ReturnResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 认真成功处理器
 * 决定 响应Json 还是页面跳转 或者认证成功后进行其他处理
 */
@Component
public class CustomerAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //认证成功后响应 json字符串
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(ReturnResult.ok("认证成功").toJsonString());
    }
}
