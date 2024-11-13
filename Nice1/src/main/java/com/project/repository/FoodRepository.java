package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Food;


public interface FoodRepository extends JpaRepository<Food, Long>{

}
