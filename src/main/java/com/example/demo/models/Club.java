package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "club")
public class Club {
    private Long id;

    private Championship idchampionship;

    private Coach idcoach;

    private String nameClub;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclub", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idchampionship")
    public Championship getIdchampionship() {
        return idchampionship;
    }

    public void setIdchampionship(Championship idchampionship) {
        this.idchampionship = idchampionship;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcoach")
    public Coach getIdcoach() {
        return idcoach;
    }

    public void setIdcoach(Coach idcoach) {
        this.idcoach = idcoach;
    }

    @Column(name = "name_club", nullable = false, length = 45)
    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }

}