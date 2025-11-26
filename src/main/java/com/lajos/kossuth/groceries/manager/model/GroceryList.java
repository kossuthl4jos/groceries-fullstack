package com.lajos.kossuth.groceries.manager.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public @Data class GroceryList {
    private String id;
    @NotEmpty
    private String name;
    private GroceryListItem[] groceryListItems;

    public GroceryList(String id, String name, GroceryListItem[] groceryListItems) {
        this.id = id;
        this.name = name;
        this.groceryListItems = groceryListItems;
    }
}



