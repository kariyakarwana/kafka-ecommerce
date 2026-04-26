package com.ecommerce.notification.event;

public class InventoryUpdatedEvent {
    private String orderId;
    private String productId;
    private int quantity;
    private String inventoryStatus;

    public InventoryUpdatedEvent() {}

    public String getOrderId() { return orderId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public String getInventoryStatus() { return inventoryStatus; }
}
