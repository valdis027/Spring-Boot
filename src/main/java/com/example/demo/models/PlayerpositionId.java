package com.example.demo.models;

import org.hibernate.Hibernate;

import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerpositionId implements Serializable {
    private static final long serialVersionUID = -489985593115623195L;
    private Integer idplayer;

    private Integer idposition;

    @Column(name = "idplayer", nullable = false)
    public Integer getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(Integer idplayer) {
        this.idplayer = idplayer;
    }

    @Column(name = "idposition", nullable = false)
    public Integer getIdposition() {
        return idposition;
    }

    public void setIdposition(Integer idposition) {
        this.idposition = idposition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlayerpositionId entity = (PlayerpositionId) o;
        return Objects.equals(this.idplayer, entity.idplayer) &&
                Objects.equals(this.idposition, entity.idposition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idplayer, idposition);
    }

}