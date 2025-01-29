package com.sam.repository;

import com.sam.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByRestaurantId(Long restaurantId);

    @Query("Select f from food f where f.name LIKE %:keyword% OR f.foodCategory LIKE %:keyword%")
    List<Food> searchFood(@Param("keyword") String keyword);
}
