package com.example.demo.repositories;

import com.example.demo.models.Playerposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerpositionRepository extends JpaRepository<Playerposition, Long > {

    @Override
    Optional<Playerposition> findById(Long aLong);
}