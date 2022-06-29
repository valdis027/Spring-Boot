package com.example.demo.controllers;

import com.example.demo.models.Club;
import com.example.demo.models.Country;
import com.example.demo.models.Player;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public List<Player> getPlayers(){
            return playerService.getPlayers();
    }

    @PostMapping
    public void addNewPlayer(@RequestBody Player player){
         playerService.addNewPlayer(player);
    }

    @DeleteMapping(path="{id}")
    public void deletePlayer(@PathVariable ("id")Long id){
        playerService.deletePlayer(id);
    }

    @PutMapping(path = "{id}")
    public void updatePlayer(
            @PathVariable("id") Long playerId,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Club idclub,
            @RequestParam(required = false) Country idcountry
            )
    {
        playerService.updatePlayer(playerId, surname,idclub,idcountry);
    }
}
