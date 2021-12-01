package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Mineral;

@Repository
public interface MineralRepository extends JpaRepository<Mineral, Integer> {
}
