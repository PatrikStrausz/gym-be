package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
