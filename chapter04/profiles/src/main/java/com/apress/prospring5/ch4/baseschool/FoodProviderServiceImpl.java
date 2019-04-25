package com.apress.prospring5.ch4.baseschool;

import com.apress.prospring5.ch4.Food;
import com.apress.prospring5.ch4.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
  @Override
  public List<Food> provideLunchSet() {
    List<Food> foods = new ArrayList<>();
    
    foods.add(new Food("Alcohol"));
    foods.add(new Food("Pasta"));
    
    return foods;
  }
}
