package org.example.data.store.repository;

import org.example.data.store.entity.Country;
import org.example.data.store.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    boolean existsByCountryAndDateGreaterThanEqual(Country country, Instant date);

    @Query(value = "SELECT s FROM Statistics s" +
            " WHERE s.country.id = :countryId" +
            " AND s.date = (SELECT MAX(ss.date) FROM Statistics ss WHERE ss.country.id = :countryId)")
    Optional<Statistics> findByCountryIdAndMaxDate(@Param("countryId") Long countryId);
}
