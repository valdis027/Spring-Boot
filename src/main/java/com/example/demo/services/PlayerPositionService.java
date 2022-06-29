package com.example.demo.services;

import com.example.demo.models.Country;
import com.example.demo.models.Player;
import com.example.demo.models.Playerposition;
import com.example.demo.models.Position;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.PlayerpositionRepository;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/playerpos")

public class PlayerPositionService {
    private final PlayerpositionRepository playerpositionRepository;

    @Autowired
    public PlayerPositionService(PlayerpositionRepository playerpositionRepository) {
        this.playerpositionRepository =playerpositionRepository ;
    }
    public List<Playerposition> getPlayerPos(){
        return playerpositionRepository.findAll();
    }

    public void addNewPlayerPos(Playerposition playerposition) {
//        Optional<Playerposition> playerpositionOptional =
//                playerpositionRepository.findById(playerposition.getId());
//        if(playerpositionOptional.isPresent()){
//            throw new IllegalStateException("taken");
//        }
        playerpositionRepository.save(playerposition);

        //System.out.println(player);
    }

    public void deleteCountry(Long id) {
        boolean exists = playerpositionRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "country with id " +id +" does not exists");
        }
        playerpositionRepository.deleteById(id);
    }
}
