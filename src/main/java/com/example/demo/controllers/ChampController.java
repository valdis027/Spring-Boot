package com.example.demo.controllers;

import com.example.demo.models.Championship;
import com.example.demo.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/champ")
public class ChampController {
    private final ChampionshipService championshipService;

    @Autowired
    public ChampController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }


    @GetMapping
    public List<Championship> getChamp(){
        return championshipService.getChampioship();
    }

    @PostMapping
    public void addNewChamp(@RequestBody Championship championship){
        championshipService.addNewChampionship(championship);
    }

    @DeleteMapping(path="{id}")
    public void deleteChamp(@PathVariable ("id")Long id){
        championshipService.deleteChampionship(id);
    }
}
