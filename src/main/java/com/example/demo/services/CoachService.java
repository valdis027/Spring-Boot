package com.example.demo.services;

import com.example.demo.models.Coach;
import com.example.demo.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {
    private final CoachRepository coachRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getCoach(){
        return coachRepository.findAll();
    }

    public void addNewCoach(Coach coach) {
        Optional<Coach> coachOptional =
                coachRepository.findById(coach.getId());
        if(coachOptional.isPresent()){
            throw new IllegalStateException("taken");
        }
        coachRepository.save(coach);
    }

    public void deleteCoach(Long coachid) {
        boolean exists = coachRepository.existsById(coachid);
        if(!exists){
            throw new IllegalStateException(
                    "player with id " +coachid +" does not exists");
        }
        coachRepository.deleteById(coachid);
    }
}
