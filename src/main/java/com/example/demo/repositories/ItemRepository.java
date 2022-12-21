package com.example.demo.repositories;


import com.example.demo.models.Item;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>,CustomizedItemRepository {
    public List<Item>findByName(String name);
    public List<Item>findByCategory(String category);

    public List<Item>findByRating(int rating);
    public List<Item>findByPrice(double price);
//    public boolean decrementItemQuantity(int itemId,int decrementCounter,Session session);


}
