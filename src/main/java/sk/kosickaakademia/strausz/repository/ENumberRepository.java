package sk.kosickaakademia.strausz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.kosickaakademia.strausz.entity.ENumber;

@Repository
public interface ENumberRepository extends JpaRepository<ENumber, Integer> {
}
