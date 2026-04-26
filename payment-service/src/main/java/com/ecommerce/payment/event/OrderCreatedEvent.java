package com.ecommerce.payment.event;

public class OrderCreatedEvent {
    private String orderId;
    private String customerId;
    private String productId;
    private int quantity;
    private double amount;
    private String status;

    public OrderCreatedEvent() {}

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
