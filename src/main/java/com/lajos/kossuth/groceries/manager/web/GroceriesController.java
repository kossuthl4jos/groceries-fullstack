package com.lajos.kossuth.groceries.manager.web;

import com.lajos.kossuth.groceries.manager.service.GroceriesService;
import com.lajos.kossuth.groceries.manager.model.GroceryList;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController // when booting up, Spring checks all classes for these
public class GroceriesController {
    private final GroceriesService groceriesService;

    public GroceriesController(GroceriesService groceriesService) {
        this.groceriesService = groceriesService;
    }

    // the above is the same as the following:
    //    @Autowired
    //    private GroceriesService groceriesService;

    @GetMapping("/hello") // get method to /hello
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/groceries-lists")
    public Collection<GroceryList> getGroceriesLists() {
        return groceriesService.getGroceriesLists();
    }

    @GetMapping("/groceries-lists/{id}")
    public GroceryList getGroceriesList(@PathVariable String id) {
        GroceryList groceryList = getGroceriesList(id);
        if (groceryList == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery list not found");
        return groceryList;
    };

    @DeleteMapping("/groceries-lists/{id}")
    public void delete(@PathVariable String id) {
        GroceryList groceryList = groceriesService.deleteGroceriesList(id);
        if (groceryList == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery list to remove was not found");
    }

    @PostMapping("/groceries-lists")
    public GroceryList create(@RequestBody @Valid GroceryList groceryList) {
        groceryList.setId(UUID.randomUUID().toString());
        groceriesService.createGroceriesList(groceryList);
        return groceryList;
    }
}

