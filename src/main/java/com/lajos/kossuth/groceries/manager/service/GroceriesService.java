package com.lajos.kossuth.groceries.manager.service;

import com.lajos.kossuth.groceries.manager.model.GroceryList;
import com.lajos.kossuth.groceries.manager.model.GroceryListItem;
import com.lajos.kossuth.groceries.manager.repository.GroceryListItemRepository;
import com.lajos.kossuth.groceries.manager.repository.GroceryListRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GroceriesService {
    private final GroceryListRepository groceryListRepository;

    public GroceriesService(GroceryListRepository groceryListRepository, GroceryListItemRepository groceryListItemRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public Iterable<GroceryList> getGroceriesLists() {
        return groceryListRepository.findAll();
    }
    public GroceryList getGroceriesList(Integer id) {
        return groceryListRepository.findById(id).orElse(null);
    }
    public void deleteGroceriesList(Integer id) {
        groceryListRepository.deleteById(id);
    }
    public GroceryList createGroceriesList(GroceryList groceryListInput) {
        GroceryList groceryList = new GroceryList();
        groceryList.setName(groceryList.getName());
        groceryList.setGroceryListItems(groceryListInput.getGroceryListItems());
        return groceryListRepository.save(groceryList);
    }

}
