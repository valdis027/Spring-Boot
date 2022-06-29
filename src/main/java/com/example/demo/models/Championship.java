package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "championship")
public class Championship {
    private Long id;

    private String nameChamp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchampionship", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name_champ", nullable = false, length = 45)
    public String getNameChamp() {
        return nameChamp;
    }

    public void setNameChamp(String nameChamp) {
        this.nameChamp = nameChamp;
    }

}