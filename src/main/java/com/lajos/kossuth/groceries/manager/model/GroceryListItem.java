package com.lajos.kossuth.groceries.manager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("GROCERY_LIST_ITEMS")
public @Data class GroceryListItem {
    @Id
    private Integer id;
    private String name;
    private int quantity;
    private boolean completed;
    private int completedBy;

    public GroceryListItem(Integer id, String name, int quantity, boolean completed) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.completed = completed;
    }
}
