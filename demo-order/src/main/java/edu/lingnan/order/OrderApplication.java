package edu.lingnan.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderApplication {

    public static void main(String[] args) throws InterruptedException {

        // applicationContext 可以活动说有的参数信息
        ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("demo.username");
        String port = applicationContext.getEnvironment().getProperty("server.port");
        System.out.println(userName+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+port);
    }


    @Bean
    //@LoadBalanced 表示 restTemplate会通过负载均衡器去调用.如果不加无法通过调用nacos里面的服务
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}
