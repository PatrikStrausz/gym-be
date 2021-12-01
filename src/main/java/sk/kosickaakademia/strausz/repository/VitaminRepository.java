package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Vitamin;

@Repository
public interface VitaminRepository extends JpaRepository<Vitamin, Integer> {
}
