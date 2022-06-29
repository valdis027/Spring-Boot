package com.example.demo.services;

import com.example.demo.models.Position;
import com.example.demo.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

    public void addNewPosition(Position position) {
        Optional<Position> positionOptional =
                positionRepository.findById(position.getId());
        if(positionOptional.isPresent()){
            throw new IllegalStateException("taken");
        }
        positionRepository.save(position);

        //System.out.println(player);
    }

    public void deletePosition(Long id) {
        boolean exists = positionRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "country with id " +id +" does not exists");
        }
        positionRepository.deleteById(id);
    }
}
