package edu.lingnan.luckycloud.luckycore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"edu.lingnan.luckycloud.luckycore"})
@MapperScan({"edu.lingnan.luckycloud.luckycore.**.mapper"})
public class LuckyCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(LuckyCoreApplication.class,args);
    }
}
