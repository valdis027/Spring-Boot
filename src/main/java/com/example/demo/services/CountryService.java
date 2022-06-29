package com.example.demo.services;


import com.example.demo.models.Country;
import com.example.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountry(){
        return countryRepository.findAll();
    }

    public void addNewCountry(Country country) {
        Optional<Country> countryOptional =
                countryRepository.findById(country.getId());
        if(countryOptional.isPresent()){
            throw new IllegalStateException("taken");
        }
        countryRepository.save(country);

        //System.out.println(player);
    }

    public void deleteCountry(Long countryid) {
        boolean exists = countryRepository.existsById(countryid);
        if(!exists){
            throw new IllegalStateException(
                    "country with id " +countryid +" does not exists");
        }
        countryRepository.deleteById(countryid);
    }
}
