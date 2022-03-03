package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.UserDetailsTraining;

import java.util.List;

@Repository
public interface UserDetailsTrainingRepository extends JpaRepository<UserDetailsTraining, Integer> {

    @Query(value = "SELECT DISTINCT * from user_details_training INNER JOIN user_details on user_details_training.user_details_id = ?1", nativeQuery = true)
    List<UserDetailsTraining> findAllByUserDetailsId(int userDetailsId);
}
