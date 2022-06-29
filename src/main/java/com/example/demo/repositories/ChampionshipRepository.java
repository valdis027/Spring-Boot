package com.example.demo.repositories;

import com.example.demo.models.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Long > {

    @Override
    Optional<Championship> findById(Long aLong);
}