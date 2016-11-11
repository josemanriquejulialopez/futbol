package com.example.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private LocalDate fechanacimineto;
    private int numcanastastot;
    private int numassistenciastot;
    private int numrebotestot;
    private String posicion;
    @ManyToOne  //un Jugador sólo puede pertenecer a un Equipo
    private Equipo owner;

    public Jugador(String nombre, LocalDate fechanacimineto, int numcanastastot,
                   int numassistenciastot, int numrebotestot, String posicion) {
        this.nombre = nombre;
        this.fechanacimineto = fechanacimineto;
        this.numcanastastot = numcanastastot;
        this.numassistenciastot = numassistenciastot;
        this.numrebotestot = numrebotestot;
        this.posicion = posicion;
    }
    public Jugador(){
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechanacimineto() {
        return fechanacimineto;
    }

    public void setFechanacimineto(LocalDate fechanacimineto) {
        this.fechanacimineto = fechanacimineto;
    }

    public int getNumcanastastot() {
        return numcanastastot;
    }

    public void setNumcanastastot(int numcanastastot) {
        this.numcanastastot = numcanastastot;
    }

    public int getNumassistenciastot() {
        return numassistenciastot;
    }

    public void setNumassistenciastot(int numassistenciastot) {
        this.numassistenciastot = numassistenciastot;
    }

    public int getNumrebotestot() {
        return numrebotestot;
    }

    public Equipo getOwner() {
        return owner;
    }

    public void setOwner(Equipo owner) {
        this.owner = owner;
    }

    public void setNumrebotestot(int numrebotestot) {
        this.numrebotestot = numrebotestot;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechanacimineto=" + fechanacimineto +
                ", numcanastastot=" + numcanastastot +
                ", numassistenciastot=" + numassistenciastot +
                ", numrebotestot=" + numrebotestot +
                ", posicion='" + posicion + '\'' +
                '}'+ System.lineSeparator();
    }



}
