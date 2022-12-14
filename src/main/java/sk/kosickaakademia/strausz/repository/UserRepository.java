package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

@Modifying
    @Query(value = "Delete from users  WHERE users.id = ?1",nativeQuery = true)
    void deleteWithId(Integer id);

}
