package com.ecommerce.inventory.event;

public class InventoryUpdatedEvent {
    private String orderId;
    private String productId;
    private int quantity;
    private String inventoryStatus;

    public InventoryUpdatedEvent() {}

    public InventoryUpdatedEvent(String orderId, String productId, int quantity, String inventoryStatus) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.inventoryStatus = inventoryStatus;
    }

    public String getOrderId() { return orderId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public String getInventoryStatus() { return inventoryStatus; }
}
