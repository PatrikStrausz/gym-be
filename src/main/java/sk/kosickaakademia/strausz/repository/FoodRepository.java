package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Food;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT a from food a  INNER JOIN a.foodSet b WHERE b.id = :userDetailsId")
    List<Food> findAllByFoodSet(int userDetailsId);


    @Query(value = "SELECT * from food   INNER JOIN user_details_food ON food.id = user_details_food.food_id INNER JOIN user_details ON user_details_food.user_details_id = user_details.id  WHERE user_details_food.time_of_the_day = ?1 AND user_details.id = ?2 ", nativeQuery = true)
    List<Food> findAllFoodsByTimeOfTheDay(String timeOfTheDay, Integer userDetailsId);
}
