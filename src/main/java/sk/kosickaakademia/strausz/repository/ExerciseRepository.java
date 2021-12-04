package sk.kosickaakademia.strausz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    @Query("SELECT a from Exercise a  INNER JOIN a.muscleSet b WHERE b.id = :muscleId")
    Page<Exercise> findAllByMuscleSet(Pageable page, int muscleId);
    

}