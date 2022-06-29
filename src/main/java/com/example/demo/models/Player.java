package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    private Long id;

    private String surname;

    private Club idclub;

    private Country idcountry;

    public Player(String surname, Club id_club, Country id_country) {
        this.surname = surname;
        this.idclub = id_club;
        this.idcountry = id_country;
    }

    public Player(Long id_player, String surname, Club id_club, Country id_country) {
        this.id = id_player;
        this.surname = surname;
        this.idclub = id_club;
        this.idcountry = id_country;
    }

    public Player() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplayer", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idclub")
    public Club getIdclub() {
        return idclub;
    }

    public void setIdclub(Club idclub) {
        this.idclub = idclub;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcountry")
    public Country getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(Country idcountry) {
        this.idcountry = idcountry;
    }

    public String toString() {
        return "player{" +
                "id_player=" + id +
                ", surname='" + surname + '\'' +
                ", id_club=" + idclub +
                ", id_country=" + idcountry +
                '}';
    }
}