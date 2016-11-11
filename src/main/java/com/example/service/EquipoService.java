package com.example.service;

import com.example.domain.Equipo;
import com.example.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;


@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public void testEquipo(){

        Equipo equipo1 = new Equipo("FCB", "Barcelona", LocalDate.of(1899, 1, 1));
        equipoRepository.save(equipo1);

        Equipo equipo2 = new Equipo("Leicester", "Leicester", LocalDate.of(1884, 1, 1));
        equipoRepository.save(equipo2);

        Equipo equipo3 = new Equipo("Cornella", "Cornella", LocalDate.of(1920, 1, 1));
        equipoRepository.save(equipo3);


        System.out.println("Equipos de la localidad Cornella: ");
        System.out.println(equipoRepository.findByLocalidad("Cornella"));

    }

}
