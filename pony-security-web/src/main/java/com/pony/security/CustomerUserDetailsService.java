package com.pony.security;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserDetailsService implements UserDetailsService {
    Logger logger= LoggerFactory.getLogger(CustomerUserDetailsService.class);
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        logger.info("请求认证用户名：{}",username);
        //1、用用户名去数据库查询改用户数据
        if(StringUtils.isBlank(username)){
            throw new UsernameNotFoundException("");
        }
        if(!username.equals("pony")){
            throw new UsernameNotFoundException("");
        }

        //2、查询用户的权限

        //3、封装用户信息和权限
        String password = passwordEncoder.encode("123456");
        //两个构造器根据需求选择:1.用户名, 2.密码(加密/数据库的密码)，3.权限标识
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
    }
}




