package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> getClub(){
        return clubRepository.findAll();
    }

    public void addNewClub(Club club) {
        Optional<Club> clubOptional =
                clubRepository.findById(club.getId());
        if(clubOptional.isPresent()){
            throw new IllegalStateException("taken");
        }
        clubRepository.save(club);

        //System.out.println(player);
    }

    public void deleteClub(Long idclub) {
        boolean exists = clubRepository.existsById(idclub);
        if(!exists){
            throw new IllegalStateException(
                    "club with id " +idclub +" does not exists");
        }
        clubRepository.deleteById(idclub);
    }
    @Transactional
    public void updateClub(Long idclub, String nameClub, Championship idchamp, Coach idcoach){
        Club club= clubRepository.findById(idclub)
                .orElseThrow(()-> new IllegalStateException("Player with id:"+idclub+" does not exists"));
        if(nameClub!=null&&
                nameClub.length()>0&&
                !Objects.equals(club.getNameClub(), nameClub)
        ){
            club.setNameClub(nameClub);
        }
        if(idchamp!=null
        ){
            club.setIdchampionship(idchamp);
        }
        if(idcoach!=null
        ){
            club.setIdcoach(idcoach);
        }
    }
}
