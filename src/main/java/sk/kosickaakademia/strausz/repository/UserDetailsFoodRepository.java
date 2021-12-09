package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.kosickaakademia.strausz.entity.UserDetailsFood;

import java.util.List;

public interface UserDetailsFoodRepository extends JpaRepository<UserDetailsFood, Integer> {
    @Query(value = "SELECT * from user_details_food INNER JOIN user_details on user_details_food.user_details_id = ?1", nativeQuery = true)
    List<UserDetailsFood> findAllByUserDetailsId(int userDetailsId);


}
