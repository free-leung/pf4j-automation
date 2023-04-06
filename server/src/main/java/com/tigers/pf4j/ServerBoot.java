package com.tigers.pf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@code ServerBoot}
 * Server 启动入口类
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
@SpringBootApplication
public class ServerBoot {

    public static void main (String[] args)
    {
        var app = new SpringApplication(ServerBoot.class) ;
        app.run(args) ;
    }
}
