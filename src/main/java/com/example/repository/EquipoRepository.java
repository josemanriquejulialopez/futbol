package com.example.repository;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dam on 4/11/16.
 */
public interface EquipoRepository extends JpaRepository<Equipo,Long> {

    List<Equipo>findByLocalidad(String localidad);

}
