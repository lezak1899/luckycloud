package edu.lingnan.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/reduct")
    public String reduct() throws InterruptedException {
//        测试fegin 的超时
//        Thread.sleep(4000);
        System.out.println("扣减库存");
        return "扣减库存:"+port+"::id::";
    }


    @RequestMapping("/reduct2")
    public String reduct2() {
        int a=1/0;
        System.out.println("扣减库存");
        return "扣减库存:"+port;
    }

}
