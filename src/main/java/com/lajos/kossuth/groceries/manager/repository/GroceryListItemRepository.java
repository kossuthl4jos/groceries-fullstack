package com.lajos.kossuth.groceries.manager.repository;

import com.lajos.kossuth.groceries.manager.model.GroceryListItem;
import org.springframework.data.repository.CrudRepository;

public interface GroceryListItemRepository extends CrudRepository<GroceryListItem, Integer> {
}
