package com.example.demo.services;



import com.example.demo.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems() throws Exception;

    Item getItemById(int itemId) throws Exception;

    List<Item> getItemsByName(String name) throws Exception;

    List<Item> getItemsByCategory(String category) throws Exception;

    List<Item> getItemsByRating(int rating) throws Exception;

    List<Item> getItemsByPrice(double price) throws Exception;
    List<Item>getItemsByNameCategoryRatingPrice(String name,String category,int rating,double price) throws Exception;

    Item addItem(Item item) throws Exception;

    void deleteItem(int itemId) throws Exception;

    Item updateItem(Item item) throws Exception;

}
