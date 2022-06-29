package com.example.demo.controllers;

import com.example.demo.models.Position;
import com.example.demo.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/position")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {this.positionService = positionService;}


    @GetMapping
    public List<Position> getPlayers(){
        return positionService.getPositions();
    }

    @PostMapping
    public void addNewPosition(@RequestBody Position position){
        positionService.addNewPosition(position);
    }

    @DeleteMapping(path="{id}")
    public void deletePlayer(@PathVariable ("id")Long id){
        positionService.deletePosition(id);
    }
}
