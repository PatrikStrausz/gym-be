package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Muscle;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Integer> {

    @Query(value = "SELECT * from muscle INNER JOIN exercise_muscle on muscle.id = exercise_muscle.muscle_id INNER JOIN exercise on exercise_muscle.exercise_id = ?1", nativeQuery = true)
    Muscle getMuscleByExerciseId(int exerciseId);


}
