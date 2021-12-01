package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Preservative;

@Repository
public interface PreservativeRepository extends JpaRepository<Preservative, Integer> {
}
