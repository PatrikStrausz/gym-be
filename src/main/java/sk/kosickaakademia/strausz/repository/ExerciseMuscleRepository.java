package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.ExerciseMuscle;

@Repository
public interface ExerciseMuscleRepository extends JpaRepository<ExerciseMuscle, Integer> {
}
