package com.pony.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //开启springSecurity 过滤器连
public class StringSecurityConfig extends WebSecurityConfigurerAdapter {
    //ctrl+o 覆盖方法
    Logger logger= LoggerFactory.getLogger(StringSecurityConfig.class);
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
//        http.httpBasic()                        //采用httpBasic 认证方式
        http.formLogin()                        //表单认证
                .and().authorizeRequests()      //认证请求
                .anyRequest().authenticated();  //所有访问该应用的http请求都要通过身份认证
    }
}

