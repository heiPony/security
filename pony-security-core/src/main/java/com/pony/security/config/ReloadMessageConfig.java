package com.pony.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 加载认证信息
 * @Author huangzhanping
 * @param
 * @return 2019/12/12 21:20
 */
@Configuration
public class ReloadMessageConfig {

    //家在中文认证信息
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        //不用加文件名.properties
        messageSource.setBasename("classpath:/org/springframework/security/messages_zh_CN");
        return messageSource;
    }
}
