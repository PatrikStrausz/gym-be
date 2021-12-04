package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Mineral;

import java.util.List;

@Repository
public interface MineralRepository extends JpaRepository<Mineral, Integer> {

    @Query("SELECT a from mineral a  INNER JOIN a.foodSet b WHERE b.id = :foodId")
    List<Mineral> findAllByMineralSet(long foodId);
}
