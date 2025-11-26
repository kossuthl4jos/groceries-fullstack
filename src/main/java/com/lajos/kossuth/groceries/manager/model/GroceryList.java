package com.lajos.kossuth.groceries.manager.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("GROCERY_LISTS")
@Data
public class GroceryList {
    @Id
    private Integer id;
    @NotEmpty
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Transient
    private List<GroceryListItem> groceryListItems;
}



