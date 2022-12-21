package com.example.demo.repositories;

import com.example.demo.models.Item;

import java.util.List;

public interface CustomizedItemRepository {
    List<Item> findByNameAndCategoryAndRatingAndPrice(String name, String category, int rating, double price);
}
