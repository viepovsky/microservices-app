package com.viepovsky.barber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(
        scanBasePackages = {
        "com.viepovsky.barber",
        "com.viepovsky.amqp"
})
@EnableFeignClients(basePackages = "com.viepovsky.clients")
public class BarberApplication {
    public static void main(String[] args) {
        SpringApplication.run(BarberApplication.class, args);
    }
// If using restTemplate instead of OpenFeign it is needed to add @LoadBalancer in order to work with multiples containers
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

}
