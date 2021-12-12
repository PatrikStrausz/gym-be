package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.api.rest.FoodNutrientsDto;
import sk.kosickaakademia.strausz.api.rest.UserFoodDetailsDto;
import sk.kosickaakademia.strausz.entity.Food;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT a from food a  INNER JOIN a.foodSet b WHERE b.id = :userDetailsId")
    List<Food> findAllByFoodSet(int userDetailsId);


    @Query(value = "SELECT DISTINCT food.energy_value, food.protein, food.carbohydrates, food.fats, food.fiber, user_details_food.amount  from food  INNER JOIN user_details_food ON food.id = user_details_food.food_id INNER JOIN user_details ON user_details_food.user_details_id=?1 WHERE  user_details_food.date = ?2", nativeQuery = true)
    List<FoodNutrientsDto> findAllFoodsByDay(int userDetailsId, String date);


    @Query(value = "SELECT DISTINCT food.energy_value, food.protein, food.carbohydrates, food.fats, food.fiber, user_details_food.amount, user_details_food.date  from food  INNER JOIN user_details_food ON food.id = user_details_food.food_id INNER JOIN user_details ON user_details_food.user_details_id=?1 ", nativeQuery = true)
    List<UserFoodDetailsDto> findAllFoodsByUserDetailsId(int userDetailsId);
}
