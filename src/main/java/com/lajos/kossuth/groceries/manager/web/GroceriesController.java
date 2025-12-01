package com.lajos.kossuth.groceries.manager.web;

import com.lajos.kossuth.groceries.manager.service.GroceriesService;
import com.lajos.kossuth.groceries.manager.model.GroceryList;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController // when booting up, Spring checks all classes for these annotations
public class GroceriesController {
    private final GroceriesService groceriesService;

    public GroceriesController(GroceriesService groceriesService) {
        this.groceriesService = groceriesService;
    }
    // the above is the same as the following:
    //    @Autowired
    //    private GroceriesService groceriesService;

    //    public GroceriesController() {
    //        this.groceriesService = new GroceriesService(); // this is NOT GOOD practice
    //    }


    @GetMapping("/hello") // get method to /hello
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/groceries-lists")
    public List<GroceryList> getGroceriesLists() {
        return groceriesService.getGroceriesLists();
    }

    @GetMapping("/groceries-lists/{id}")
    public GroceryList getGroceriesList(@PathVariable Long id) {
        GroceryList groceryList = groceriesService.getGroceriesList(id);
        if (groceryList == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery list not found");
        return groceryList;
    }

    @DeleteMapping("/groceries-lists/{id}")
    public void delete(@PathVariable Long id) {
        try {
            groceriesService.deleteGroceriesList(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery list could not be deleted");
        }
    }

    @PostMapping("/groceries-lists")
    public GroceryList create(@RequestBody @Valid GroceryList groceryList) {
        GroceryList createdGroceryList = groceriesService.createGroceriesList(groceryList);
        return createdGroceryList;
    }
}

