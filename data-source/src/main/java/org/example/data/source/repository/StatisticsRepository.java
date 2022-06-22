package org.example.data.source.repository;

import org.example.data.source.entity.Country;
import org.example.data.source.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    boolean existsByCountryAndDateGreaterThanEqual(Country country, Instant date);
}
