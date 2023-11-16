package com.viepovsky.clients.notification;

public record NotificationRequest(
         String textMessage,
         String whoSend,
         String barberEmail,
         Long barberId
) {
}
