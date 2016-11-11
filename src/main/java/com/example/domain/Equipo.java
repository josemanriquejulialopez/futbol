package com.example.domain;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dam on 3/11/16.
 */
@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String localidad;
    private LocalDate fechacreacion;


    public Equipo(String nombre, String localidad, LocalDate fechacreacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechacreacion = fechacreacion;
    }
    public Equipo(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (id != equipo.id) return false;
        if (!nombre.equals(equipo.nombre)) return false;
        if (!localidad.equals(equipo.localidad)) return false;
        return fechacreacion.equals(equipo.fechacreacion);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + nombre.hashCode();
        result = 31 * result + localidad.hashCode();
        result = 31 * result + fechacreacion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechacreacion=" + fechacreacion +
                '}'+ System.lineSeparator();
    }
}
