package com.ecommerce.inventory.event;

public class PaymentProcessedEvent {
    private String orderId;
    private String customerId;
    private String productId;
    private int quantity;
    private double amount;
    private String paymentStatus;

    public PaymentProcessedEvent() {}

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }
}
