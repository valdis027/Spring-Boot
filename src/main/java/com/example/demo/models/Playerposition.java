package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "playerposition")
public class Playerposition {
    private PlayerpositionId id;

    private Player idplayer;

    private Position idposition;

    @EmbeddedId
    public PlayerpositionId getId() {
        return id;
    }

    public void setId(PlayerpositionId id) {
        this.id = id;
    }

    @MapsId("idplayer")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idplayer", nullable = false)
    public Player getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(Player idplayer) {
        this.idplayer = idplayer;
    }

    @MapsId("idposition")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idposition", nullable = false)
    public Position getIdposition() {
        return idposition;
    }



    public void setIdposition(Position idposition) {
        this.idposition = idposition;
    }

}