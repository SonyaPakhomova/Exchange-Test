package com.example.overonix.core.repository;

import com.example.overonix.core.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<List<Currency>> getAllByBaseCode(String baseCode);

    Optional<List<Currency>> getByTimeBetween(LocalDate from, LocalDate to);

    @Query("FROM Currency c WHERE c.time BETWEEN :from AND :to AND c.baseCode = :baseCode")
    Optional<List<Currency>> getAllByByTimeBetweenAndBaseCode(LocalDate from,
                                                             LocalDate to, String baseCode);

    Optional<Currency> getByTimeAndBaseCode(LocalDate date, String baseCode);
}
