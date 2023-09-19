package edu.lingnan.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class StockApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =  SpringApplication.run(StockApplication.class,args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String port = applicationContext.getEnvironment().getProperty("server.port");
        System.out.println(userName+":::"+port);
    }
}
