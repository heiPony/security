package com.pony.security.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pony.security")
public class SecurityProperties {
    //会将pony.security.authentication 注入到 AuthenticationProperties；
    //authentication 这个名字必须个yml中的名字一样
    AuthenticationProperties authentication;

    public AuthenticationProperties getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationProperties authentication) {
        this.authentication = authentication;
    }
}
