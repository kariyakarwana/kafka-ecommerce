package com.ecommerce.payment.consumer;

import com.ecommerce.payment.event.OrderCreatedEvent;
import com.ecommerce.payment.event.PaymentProcessedEvent;
import com.ecommerce.payment.producer.PaymentProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    private final PaymentProducer paymentProducer;

    public PaymentConsumer(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @KafkaListener(topics = "order_created", groupId = "payment-service-group")
    public void consumeOrderCreated(OrderCreatedEvent event) {
        System.out.println("PAYMENT SERVICE: Received order_created event: " + event.getOrderId());

        PaymentProcessedEvent paymentEvent = new PaymentProcessedEvent(
                event.getOrderId(),
                event.getCustomerId(),
                event.getProductId(),
                event.getQuantity(),
                event.getAmount(),
                "PAYMENT_SUCCESS"
        );

        paymentProducer.publishPaymentProcessed(paymentEvent);
    }
}
