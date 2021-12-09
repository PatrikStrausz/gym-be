package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.kosickaakademia.strausz.entity.UserDetailsMacros;

import java.util.List;

public interface UserDetailsMacrosRepository extends JpaRepository<UserDetailsMacros, Integer> {

    @Query(value = "SELECT * from user_details_macros INNER JOIN user_details ON user_details_macros.user_details_id = ?1", nativeQuery = true)
    List<UserDetailsMacros> findAllByUserDetailsId(int userDetailsId);
}
