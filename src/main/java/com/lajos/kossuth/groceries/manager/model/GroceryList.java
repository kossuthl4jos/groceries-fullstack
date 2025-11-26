package com.lajos.kossuth.groceries.manager.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("GROCERY_LISTS")
public @Data class GroceryList {
    @Id
    private Integer id;
    @NotEmpty
    private String name;
    private GroceryListItem[] groceryListItems;

    public GroceryList() {
    }

    public GroceryList(Integer id, String name, GroceryListItem[] groceryListItems) {
        this.id = id;
        this.name = name;
        this.groceryListItems = groceryListItems;
    }
}



