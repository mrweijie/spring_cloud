package com.zwj.order.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients(basePackages ="com.zwj.order.feign")
@ComponentScan(basePackages = {"com.zwj.order.controller","com.zwj.order.service","com.zwj.order.fallback"})
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class,args);
    }

    /**
     * 向Spring容器中定义RestTemplate对象
     * @return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
//        return new RestTemplate(); //使用默认的jdk的标准实现
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory()); //使用okhttp来实现
    }
}
