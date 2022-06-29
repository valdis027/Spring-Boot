package com.example.demo.repositories;

import com.example.demo.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long > {

    @Override
    Optional<Country> findById(Long aLong);
}