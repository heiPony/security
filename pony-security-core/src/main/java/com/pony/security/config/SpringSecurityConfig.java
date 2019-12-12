package com.pony.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //开启springSecurity 过滤器连
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //当认证成功后，springSecurity会重定向到你上一次请求上如 localhost/user -->localhost/login/page --->localhost/user
    //ctrl+o 覆盖方法
    Logger logger= LoggerFactory.getLogger(SpringSecurityConfig.class);
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 认证管理器：
     * 1：认证信息(用户名，密码)
     * @Author huangzhanping
     * @param [auth]
     * @return 2019/12/7 13:54
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //数据库存储的密码必须是加密得；
        String encode = passwordEncoder().encode("123456");
        logger.info("========"+encode);
        auth.inMemoryAuthentication().withUser("pony").password(encode).authorities("ADMIN");
    }

    /**
     * 资源权限配置
     * @Author huangzhanping
     * @param [http]
     * @return 2019/12/7 13:54
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()                                  //采用httpBasic 认证方式
        http.formLogin()                                   //表单认证
                .loginPage("/login/page")                   //登录页路径
                .loginProcessingUrl("/login/form")          //默认登陆请求路径("/login")
                .usernameParameter("name")                  //表单提交的账号name(默认username)
                .passwordParameter("pwd")                   //表单提交的密码name(默认password)
                .and().authorizeRequests()                  //认证请求
                .antMatchers("/login/page").permitAll()//可在这里放行静态资源(一般在configure()方法)
                .anyRequest().authenticated();              //所有访问该应用的http请求都要通过身份认证
    }

    /**
     * 针对静态资源放行
     * @Author huangzhanping
     * @param [web]
     * @return 2019/12/12 20:16
     */
    @Override
    public void configure(WebSecurity web) {
       web.ignoring().mvcMatchers("/dist/**","/modules/**","/plugins/**");
    }
}

