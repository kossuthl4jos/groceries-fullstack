package com.lajos.kossuth.groceries.manager.repository;

import com.lajos.kossuth.groceries.manager.model.GroceryListItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroceryListItemRepository extends CrudRepository<GroceryListItem, Integer> {
    List<GroceryListItem> findByGroceryListId(Integer groceryListId);
}
