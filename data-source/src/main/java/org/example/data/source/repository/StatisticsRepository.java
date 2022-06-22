package org.example.data.source.repository;

import org.example.data.source.entity.Country;
import org.example.data.source.entity.Statistics;
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
            " AND s.date = ( SELECT MAX(in.date) FROM Statistics in WHERE in.country.id = :countryId ) ")
    Optional<Statistics> findByCountryIdAndMaxDate(@Param("countryId") Long countryId);
}
