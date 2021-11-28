package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Muscle;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Integer> {
}
