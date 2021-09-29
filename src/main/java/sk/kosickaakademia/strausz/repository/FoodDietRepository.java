package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.kosickaakademia.strausz.entity.FoodDiet;

public interface FoodDietRepository extends JpaRepository<FoodDiet, Integer> {
}
