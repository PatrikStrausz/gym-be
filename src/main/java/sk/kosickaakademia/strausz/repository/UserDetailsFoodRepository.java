package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.kosickaakademia.strausz.entity.UserDetailsFood;

public interface UserDetailsFoodRepository extends JpaRepository<UserDetailsFood, Integer> {
}
