package sk.kosickaakademia.strausz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet,Integer> {
}
