package com.example.demo.services;

import com.example.demo.models.Club;
import com.example.demo.models.Country;
import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
  }

    public Optional<Player> getOnePlayer(long id){
      return playerRepository.findById(id);
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional =
        playerRepository.findById(player.getId());
        if(playerOptional.isPresent()){
            throw new IllegalStateException("taken");
        }
        playerRepository.save(player);

        //System.out.println(player);
    }

    public void deletePlayer(Long playerid) {
      try {
          boolean exists = playerRepository.existsById(playerid);
          this.getOnePlayer(playerid);
          System.out.println("player with id " + playerid.toString() + " does not exists");
          if (!exists) {
              throw new IllegalStateException(
                      "player with id " + playerid.toString() + " does not exists");
          }
          playerRepository.deleteById(playerid);
      }catch(Exception exception) {System.out.println("slovil\n" + exception);}
    }

    @Transactional
    public void updatePlayer(Long playerId, String surname, Club idclub, Country idcountry){
        Player player= playerRepository.findById(playerId)
                .orElseThrow(()-> new IllegalStateException("Player with id:"+playerId+" does not exists"));
        if(surname!=null&&
                surname.length()>0&&
                !Objects.equals(player.getSurname(), surname)
        ){
            player.setSurname(surname);
        }
        if(idclub!=null
        ){
            player.setIdclub(idclub);
        }
        if(idcountry!=null
        ){
            player.setIdcountry(idcountry);
        }
    }
}
