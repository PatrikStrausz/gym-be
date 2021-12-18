package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    
}
