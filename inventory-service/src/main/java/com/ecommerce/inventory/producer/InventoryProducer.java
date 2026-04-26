package com.ecommerce.inventory.producer;

import com.ecommerce.inventory.event.InventoryUpdatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryProducer {
    private final KafkaTemplate<String, InventoryUpdatedEvent> kafkaTemplate;

    public InventoryProducer(KafkaTemplate<String, InventoryUpdatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishInventoryUpdated(InventoryUpdatedEvent event) {
        kafkaTemplate.send("inventory_updated", event.getOrderId(), event);
        System.out.println("INVENTORY SERVICE: Published inventory_updated event: " + event.getOrderId());
    }
}
