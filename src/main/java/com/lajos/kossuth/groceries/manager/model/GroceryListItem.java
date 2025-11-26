package com.lajos.kossuth.groceries.manager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("GROCERY_LIST_ITEMS")
@Data
public class GroceryListItem {
    @Id
    private Long id;

    private Long groceryListId;
    private String name;
    private Integer quantity;
    private Boolean completed;
    private String completedBy;
}
