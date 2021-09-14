package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Nutrient;

@Repository
public interface NutrientRepository extends JpaRepository<Nutrient,Integer> {
}
