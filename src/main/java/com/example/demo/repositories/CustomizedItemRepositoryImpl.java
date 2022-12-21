package com.example.demo.repositories;

import com.example.demo.models.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomizedItemRepositoryImpl implements CustomizedItemRepository{
    @PersistenceContext
    private EntityManager entityManager;
    public CustomizedItemRepositoryImpl(EntityManager em){
        entityManager=em;
    }
    @Override
    public List<Item> findByNameAndCategoryAndRatingAndPrice(String name, String category, int rating, double price) {
       Query query=createQueryStringForSearchConjunction(name,category,rating,price);
        return (List<Item>) query.getResultList();
    }
    private  Query createQueryStringForSearchConjunction(String name,String category,int rating,double price){
        String queryConjunctionString="from Item";
        boolean queryHasWhereClause=false;
        if(price!=-1){
            if(!queryHasWhereClause){
                queryHasWhereClause=true;
                queryConjunctionString+=" where";
            }
            queryConjunctionString+=" price = :price";
        }
        if(rating!=-1){
            if(!queryHasWhereClause){
                queryHasWhereClause=true;
                queryConjunctionString+=" where";
            }
            else {
                queryConjunctionString+=" and";
            }
            queryConjunctionString+=" rating = :rating";
        }
        if(!name.equals("")){
            if(!queryHasWhereClause){
                queryHasWhereClause=true;
                queryConjunctionString+=" where";
            }
            else {
                queryConjunctionString+=" and";
            }
            queryConjunctionString+=" name like :name";
        }
        if(!category.equals("")){
            if(!queryHasWhereClause){
                queryHasWhereClause=true;
                queryConjunctionString+=" where";
            }
            else {
                queryConjunctionString+=" and";
            }
            queryConjunctionString+=" category like :category";
        }
        Query itemsByNameCategoryRatingPriceQuery= entityManager.createQuery(queryConjunctionString,Item.class);
        if(price!=-1){
            itemsByNameCategoryRatingPriceQuery.setParameter("price",price);
        }
        if(rating!=-1){
            itemsByNameCategoryRatingPriceQuery.setParameter("rating",rating);
        }
        if(!name.equals("")){
            itemsByNameCategoryRatingPriceQuery.setParameter("name","%"+name+"%");
        }
        if(!category.equals("")){
            itemsByNameCategoryRatingPriceQuery.setParameter("category","%"+category+"%");
        }
        return itemsByNameCategoryRatingPriceQuery;
    }
}
