package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {
}
