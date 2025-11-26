package com.lajos.kossuth.groceries.manager.repository;

import com.lajos.kossuth.groceries.manager.model.GroceryList;
import org.springframework.data.repository.CrudRepository;

public interface GroceryListRepository extends CrudRepository<GroceryList, Long> {
}
