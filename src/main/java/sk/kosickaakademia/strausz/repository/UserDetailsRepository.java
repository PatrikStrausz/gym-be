package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

    @Query("SELECT a from user_details a  INNER JOIN a.user b WHERE b.id = :userId")
    UserDetails findAllByUser(int userId);
}
