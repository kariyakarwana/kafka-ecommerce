package com.ecommerce.notification.consumer;

import com.ecommerce.notification.event.InventoryUpdatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    @KafkaListener(topics = "inventory_updated", groupId = "notification-service-group")
    public void consumeInventoryUpdated(InventoryUpdatedEvent event) {
        System.out.println("NOTIFICATION SERVICE: Notification sent for order: " + event.getOrderId());
        System.out.println("Product: " + event.getProductId());
        System.out.println("Quantity: " + event.getQuantity());
        System.out.println("Status: " + event.getInventoryStatus());
    }
}
