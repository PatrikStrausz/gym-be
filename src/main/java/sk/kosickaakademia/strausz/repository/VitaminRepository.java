package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.Vitamin;

import java.util.List;

@Repository
public interface VitaminRepository extends JpaRepository<Vitamin, Integer> {

    @Query("SELECT a from vitamin a  INNER JOIN a.foodSet b WHERE b.id = :foodId")
    List<Vitamin> findAllByVitaminSet(long foodId);

}
