package com.ecommerce.payment.producer;

import com.ecommerce.payment.event.PaymentProcessedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {
    private final KafkaTemplate<String, PaymentProcessedEvent> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, PaymentProcessedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPaymentProcessed(PaymentProcessedEvent event) {
        kafkaTemplate.send("payment_processed", event.getOrderId(), event);
        System.out.println("PAYMENT SERVICE: Published payment_processed event: " + event.getOrderId());
    }
}
