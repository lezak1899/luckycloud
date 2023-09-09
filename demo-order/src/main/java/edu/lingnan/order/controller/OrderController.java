package edu.lingnan.order.controller;

import edu.lingnan.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StockFeignService stockFeignService;

    // 方式1
    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功!");
        String msg = restTemplate.getForObject("http://demo-stock/stock/reduct", String.class);
        return "Hello World"+msg;
    }

    // 方式2 推荐
    @RequestMapping("/add/action/feign")
    public String addActionFeign() throws InterruptedException {
        System.out.println("下单成功!");
        String msg = stockFeignService.reduct();
        return "Hello Feign"+msg;
    }
}
