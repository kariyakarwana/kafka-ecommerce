package com.ecommerce.payment.event;

public class PaymentProcessedEvent {
    private String orderId;
    private String customerId;
    private String productId;
    private int quantity;
    private double amount;
    private String paymentStatus;

    public PaymentProcessedEvent() {}

    public PaymentProcessedEvent(String orderId, String customerId, String productId, int quantity, double amount, String paymentStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }
}
