package com.viepovsky.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
class Notification {
    @Id
    private String id;
    private String textMessage;
    private String whoSend;
    private LocalDateTime sendTime;
    private String barberEmail;
    private Long barberId;
}
