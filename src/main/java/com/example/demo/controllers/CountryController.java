package com.example.demo.controllers;

import com.example.demo.models.Country;
import com.example.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<Country> getCountry(){
        return countryService.getCountry();
    }

    @PostMapping
    public void addNewPlayer(@RequestBody Country country){
        countryService.addNewCountry(country);
    }

    @DeleteMapping(path="{countryid}")
    public void deletePlayer(@PathVariable ("countryid")Long countryid){
        countryService.deleteCountry(countryid);
    }
}
