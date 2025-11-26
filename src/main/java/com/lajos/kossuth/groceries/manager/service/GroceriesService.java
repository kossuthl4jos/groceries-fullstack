package com.lajos.kossuth.groceries.manager.service;

import com.lajos.kossuth.groceries.manager.model.GroceryList;
import com.lajos.kossuth.groceries.manager.model.GroceryListItem;
import com.lajos.kossuth.groceries.manager.repository.GroceryListItemRepository;
import com.lajos.kossuth.groceries.manager.repository.GroceryListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroceriesService {
    private final GroceryListRepository groceryListRepository;
    private final GroceryListItemRepository groceryListItemRepository;

    public GroceriesService(GroceryListRepository groceryListRepository, GroceryListItemRepository groceryListItemRepository) {
        this.groceryListRepository = groceryListRepository;
        this.groceryListItemRepository = groceryListItemRepository;
    }

    public List<GroceryList> getGroceriesLists() {
        List<GroceryList> groceryLists = new ArrayList<>();
        groceryListRepository.findAll().forEach(groceryList -> {
            groceryList.setGroceryListItems(groceryListItemRepository.findByGroceryListId(groceryList.getId()));
            groceryLists.add(groceryList);
        });
        return groceryLists;
    }

    public GroceryList getGroceriesList(Long id) {
        GroceryList groceryList = groceryListRepository.findById(id).orElse(null);
        if (groceryList != null) {
            groceryList.setGroceryListItems(groceryListItemRepository.findByGroceryListId(id));
        }
        return groceryList;
    }

    public void deleteGroceriesList(Long id) {
        groceryListRepository.deleteById(id);
    }

    public GroceryList createGroceriesList(GroceryList groceryListInput) {
        GroceryList groceryList = new GroceryList();
        groceryList.setName(groceryListInput.getName());
        GroceryList savedGroceryList = groceryListRepository.save(groceryList);

        if (groceryListInput.getGroceryListItems() != null) {
            for (GroceryListItem groceryListItem : groceryListInput.getGroceryListItems()) {
                groceryListItem.setGroceryListId(savedGroceryList.getId());
                groceryListItemRepository.save(groceryListItem);
            }
            savedGroceryList.setGroceryListItems(groceryListItemRepository.findByGroceryListId(savedGroceryList.getId()));
        }
        return savedGroceryList;
    }

}
