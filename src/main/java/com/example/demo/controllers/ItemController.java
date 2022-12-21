package com.example.demo.controllers;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/all")
    public List<Item> getAllItems() throws Exception {


            List<Item> allItems = itemService.getAllItems();
            return allItems;
    }
    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item) throws Exception {
        return itemService.addItem(item);
    }
    @PutMapping("/updateItem")
    public Item updateItem(@RequestBody Item item) throws Exception {
        return itemService.updateItem(item);
    }
    @DeleteMapping("/deleteItem/{id}")
    public void deleteItem(@PathVariable("id") int id) throws Exception {
        itemService.deleteItem(id);
    }

    @GetMapping("/searchConjunction")
    public List<Item> getItemsByNameCategoryRatingPrice
            (@RequestParam(value = "price",required = false,defaultValue = "") String priceString,@RequestParam(value = "name",required = false,defaultValue = "") String name,@RequestParam(value = "category",required = false,defaultValue = "") String category,
             @RequestParam(value = "rating",required = false,defaultValue = "") String ratingString) throws Exception {
            double price =-1;
            int rating =-1;
            if(!priceString.equals("")){
                price= Double.parseDouble(priceString);
            }
            if(!ratingString.equals("")){
                rating= Integer.parseInt(ratingString);
            }
            List<Item> itemsByNameCategoryRatingPrice =
                    itemService.getItemsByNameCategoryRatingPrice(name,category,rating,price);

            return itemsByNameCategoryRatingPrice;


    }

}
