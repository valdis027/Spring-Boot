package com.example.demo.controllers;

import com.example.demo.models.Championship;
import com.example.demo.models.Club;
import com.example.demo.models.Coach;
import com.example.demo.models.Country;
import com.example.demo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/club")
public class ClubController {
        private final ClubService clubService;

        @Autowired public ClubController(ClubService clubService) {
            this.clubService = clubService;
        }

        @GetMapping
        public List<Club> getClub(){
            return clubService.getClub();
        }

        @PostMapping
        public void addNewClub(@RequestBody Club club){
            clubService.addNewClub(club);
        }

        @DeleteMapping(path="{clubid}")
        public void deleteClub(@PathVariable ("clubid")Long clubid){
            clubService.deleteClub(clubid);
        }

    @PutMapping(path = "{id}")
    public void updateClub(
            @PathVariable("id") Long clubId,
            @RequestParam(required = false) String nameClub,
            @RequestParam(required = false) Championship idchamp,
            @RequestParam(required = false) Coach idcoach
    )
    {
        clubService.updateClub(clubId, nameClub,idchamp,idcoach);
    }
}

