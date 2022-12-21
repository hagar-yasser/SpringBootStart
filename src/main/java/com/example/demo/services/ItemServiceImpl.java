package com.example.demo.services;

import com.example.demo.models.Item;

import com.example.demo.repositories.ItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository=itemRepository;

    }
    @Override
    public List<Item> getAllItems() throws Exception {
        List<Item> allItems=new ArrayList<>();
        try{
            allItems=itemRepository.findAll();
            return allItems;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items from the database");
        }

    }
    @Override
    public Item getItemById(int itemId) throws Exception {
        try{
            Item item=itemRepository.findById(itemId).orElse(null);

            return item;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items By Id from the database");
        }
    }
    @Override
    public List<Item> getItemsByName(String name) throws Exception {
        List<Item> itemsByName=new ArrayList<>();
        try{
            itemsByName=itemRepository.findByName(name);

            return itemsByName;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items By Name from the database");
        }


    }
    @Override
    public List<Item> getItemsByCategory(String category) throws Exception {
        List<Item> itemsByCategory=new ArrayList<>();
        try{
            itemsByCategory=itemRepository.findByCategory(category);
            return itemsByCategory;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items By Category from the database");
        }

    }
    @Override
    public List<Item> getItemsByRating(int rating) throws Exception {
        List<Item> itemsByRating=new ArrayList<>();
        try{
            itemsByRating=itemRepository.findByRating(rating);

            return itemsByRating;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items By Rating from the database");
        }

    }
    @Override
    public List<Item> getItemsByPrice(double price) throws Exception {
        List<Item> itemsByPrice=new ArrayList<>();
        try{
            itemsByPrice=itemRepository.findByPrice(price);

            return itemsByPrice;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items By Price from the database");
        }

    }

    @Override
    public List<Item> getItemsByNameCategoryRatingPrice
            (String name, String category, int rating, double price) throws Exception {
        List<Item> itemsByNameCategoryRatingPrice;
        try{
            itemsByNameCategoryRatingPrice=itemRepository.findByNameAndCategoryAndRatingAndPrice(name,category,rating,price);
            return itemsByNameCategoryRatingPrice;
        }
        catch (Exception e){
            throw new Exception("Couldn't get Items through conjunction of search critereas from the database");
        }

    }



    @Override
    public Item addItem(Item item) throws Exception {
        try{
            itemRepository.save(item);
            return item;
        }
        catch (Exception e){
            throw new Exception("Couldn't add Item to database");
        }
    }
    @Override
    public void deleteItem(int itemId) throws Exception {
        try{
            Item item=itemRepository.findById(itemId).orElse(null);
            if(item!=null) {
                itemRepository.delete(item);
            }

        }
        catch (Exception e){
            throw new Exception("Couldn't remove Item from database");
        }
    }
    @Override
    public Item updateItem(Item item) throws Exception {
        try {
            return itemRepository.save(item);

        }
        catch (Exception e){
            throw new Exception("Couldn't remove Item from database");
        }
    }
}
