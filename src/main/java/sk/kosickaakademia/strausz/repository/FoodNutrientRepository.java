package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.FoodNutrients;

@Repository
public interface FoodNutrientRepository extends JpaRepository<FoodNutrients,Integer> {
}
