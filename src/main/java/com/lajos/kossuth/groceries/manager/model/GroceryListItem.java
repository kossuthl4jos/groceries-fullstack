package com.lajos.kossuth.groceries.manager.model;

import lombok.Data;

public @Data class GroceryListItem {
    private String id;
    private String name;
    private int quantity;
    private boolean completed;
    private int completedBy;

    public GroceryListItem(String id, String name, int quantity, boolean completed) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.completed = completed;
    }
}
