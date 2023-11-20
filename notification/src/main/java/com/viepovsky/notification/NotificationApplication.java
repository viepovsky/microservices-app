package com.viepovsky.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
        "com.viepovsky.notification",
        "com.viepovsky.amqp"
})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

// Uncomment to check connection with the RabbitMQ
//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//        return args -> {
//                    producer.publish("foo",
//                            notificationConfig.getInternalExchange(),
//                            notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
}
