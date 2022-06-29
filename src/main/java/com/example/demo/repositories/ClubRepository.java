package com.example.demo.repositories;

import com.example.demo.models.Club;
import com.example.demo.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long > {

    @Override
    Optional<Club> findById(Long aLong);
}