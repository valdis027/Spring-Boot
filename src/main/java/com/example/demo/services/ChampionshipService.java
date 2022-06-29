package com.example.demo.services;

import com.example.demo.models.Championship;
import com.example.demo.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionshipService {
    private final ChampionshipRepository championshipRepository;

    @Autowired
    public ChampionshipService(ChampionshipRepository championshipRepository) {
        this.championshipRepository = championshipRepository;
    }

    public List<Championship> getChampioship(){
        return championshipRepository.findAll();
    }

    public void addNewChampionship(Championship championship) {
        Optional<Championship> championshipOptional =
                championshipRepository.findById(championship.getId());
        if(championshipOptional.isPresent()){
            throw new IllegalStateException("taken");
        }
        championshipRepository.save(championship);
    }

    public void deleteChampionship(Long champ_id) {
        boolean exists = championshipRepository.existsById(champ_id);
        if(!exists){
            throw new IllegalStateException(
                    "championship with id " +champ_id +" does not exists");
        }
        championshipRepository.deleteById(champ_id);
    }
}
