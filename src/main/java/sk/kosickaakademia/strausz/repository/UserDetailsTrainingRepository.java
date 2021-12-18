package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.UserDetailsTraining;

@Repository
public interface UserDetailsTrainingRepository extends JpaRepository<UserDetailsTraining, Integer> {
}
