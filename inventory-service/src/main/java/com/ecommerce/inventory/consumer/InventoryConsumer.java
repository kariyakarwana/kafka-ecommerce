package com.ecommerce.inventory.consumer;

import com.ecommerce.inventory.event.InventoryUpdatedEvent;
import com.ecommerce.inventory.event.PaymentProcessedEvent;
import com.ecommerce.inventory.producer.InventoryProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {
    private final InventoryProducer inventoryProducer;

    public InventoryConsumer(InventoryProducer inventoryProducer) {
        this.inventoryProducer = inventoryProducer;
    }

    @KafkaListener(topics = "payment_processed", groupId = "inventory-service-group")
    public void consumePaymentProcessed(PaymentProcessedEvent event) {
        System.out.println("INVENTORY SERVICE: Received payment_processed event: " + event.getOrderId());

        InventoryUpdatedEvent inventoryEvent = new InventoryUpdatedEvent(
                event.getOrderId(),
                event.getProductId(),
                event.getQuantity(),
                "INVENTORY_UPDATED"
        );

        inventoryProducer.publishInventoryUpdated(inventoryEvent);
    }
}
