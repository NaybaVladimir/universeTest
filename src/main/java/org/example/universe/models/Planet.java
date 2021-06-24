package org.example.universe.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Planet {
    @Id
    private String name;
    @ManyToOne
    @JoinColumn(name = "rulerName")
    private Ruler ruler;

    public void removeRuler(){
        this.ruler=null;
    }
    public Planet() {
    }
}
