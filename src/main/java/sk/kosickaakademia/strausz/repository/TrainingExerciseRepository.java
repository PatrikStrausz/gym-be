package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.kosickaakademia.strausz.entity.TrainingExercise;

public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Integer> {
}
