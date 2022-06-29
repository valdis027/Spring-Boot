package com.example.demo.controllers;

import com.example.demo.models.Coach;
import com.example.demo.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coach")
public class CoachController {
    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }


    @GetMapping
    public List<Coach> getCoaches(){
        return coachService.getCoach();
    }

    @PostMapping
    public void addNewPlayer(@RequestBody Coach coach){
        coachService.addNewCoach(coach);
    }

    @DeleteMapping(path="{id}")
    public void deletePlayer(@PathVariable ("id")Long id){
        coachService.deleteCoach(id);
    }
}
