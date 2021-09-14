package sk.kosickaakademia.strausz.api.rest;

import sk.kosickaakademia.strausz.entity.Food;

import java.util.List;

public class FoodListDto {

   List<Food> foodList;

    public FoodListDto(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
