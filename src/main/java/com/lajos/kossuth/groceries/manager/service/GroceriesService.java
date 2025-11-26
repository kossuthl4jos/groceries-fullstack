package com.lajos.kossuth.groceries.manager.service;

import com.lajos.kossuth.groceries.manager.model.GroceryList;
import com.lajos.kossuth.groceries.manager.model.GroceryListItem;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GroceriesService {
    private Map<String, GroceryList> db = new HashMap<>() {{
        put("1", new GroceryList("1", "Grocery List 1", new GroceryListItem[] {
                new GroceryListItem("1", "Milk", 1, false),
                new GroceryListItem("2", "Bread", 1, false),
                new GroceryListItem("3", "Eggs", 1, false)
        }));
        put("2", new GroceryList("2", "Grocery List 2", new GroceryListItem[] {
                new GroceryListItem("4", "Cheese", 1, false),
                new GroceryListItem("5", "Pasta", 1, false),
                new GroceryListItem("6", "Tomato", 1, false)
        }));
    }};

    public Collection<GroceryList> getGroceriesLists() {
        return db.values();
    }
    public GroceryList getGroceriesList(String id) {
        return db.get(id);
    }
    public GroceryList deleteGroceriesList(String id) {
        return db.remove(id);
    }
    public GroceryList createGroceriesList(GroceryList groceryList) {
        return db.put(groceryList.getId(), groceryList);
    }

}
