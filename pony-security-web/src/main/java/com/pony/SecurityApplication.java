package com.pony;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SecurityApplication.class);
//        SpringApplication.run(SecurityApplication.class,args);
//        String cmd = "cmd /c start http://localhost/login/page";
//        Runtime run = Runtime.getRuntime();
//        try{
//            run.exec(cmd);
//            int i=1/0;
//            logger.info("默认启动浏览器成功");
//        }catch (Exception e){
//            logger.info("默认启动浏览器失败："+e.getMessage(),e);
//        }
    }
}
