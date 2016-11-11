package com.example.service;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;


    public void testJugador(){

        Jugador messi = new Jugador("Lionel Andres Messi", LocalDate.of(1988, 1, 1), 50, 50, 50, "Delantero");
        Equipo barça = equipoRepository.findOne(1L);
        messi.setOwner(barça);
        jugadorRepository.save(messi);

        Jugador ronaldinho = new Jugador("Ronaldinho", LocalDate.of(1980, 1, 1), 45, 2, 20, "Delantero");
        ronaldinho.setOwner(barça);
        jugadorRepository.save(ronaldinho);

        Jugador neymar = new Jugador("Neymar Jr", LocalDate.of(1993, 1, 1), 3, 5, 7, "Delantero");
        neymar.setOwner(barça);
        jugadorRepository.save(neymar);

        Jugador xavi = new Jugador("Xavi", LocalDate.of(1993, 1, 1), 25, 9, 15, "Mediocentro");
        xavi.setOwner(barça);
        jugadorRepository.save(xavi);

        Jugador cruyff = new Jugador("Cruyff", LocalDate.of(1960, 1, 1), 32, 42, 33, "Mediocentro");
        cruyff.setOwner(barça);
        jugadorRepository.save(cruyff);



        Jugador vardy = new Jugador("Vardy", LocalDate.of(1982, 1, 1), 5, 1, 0, "Delantero");
        Equipo leicester = equipoRepository.findOne(2L);
        vardy.setOwner(leicester);
        jugadorRepository.save(vardy);

        Jugador mahrez = new Jugador("Mahrez", LocalDate.of(1990, 1, 1), 49, 6, 3, "Mediocentro");
        mahrez.setOwner(leicester);
        jugadorRepository.save(mahrez);

        Jugador dreamwater = new Jugador("Dreamwater", LocalDate.of(1983, 1, 1), 26, 24, 27, "Mediocentro");
        dreamwater.setOwner(leicester);
        jugadorRepository.save(dreamwater);

        Jugador okazaki = new Jugador("Okazaki", LocalDate.of(1983, 1, 1), 14, 16, 37, "Mediocentro");
        okazaki.setOwner(leicester);
        jugadorRepository.save(okazaki);

        Jugador morgan = new Jugador("Morgan", LocalDate.of(1988, 1, 1), 4, 44, 28, "Defensa");
        morgan.setOwner(leicester);
        jugadorRepository.save(morgan);



        Jugador josep = new Jugador("Josep", LocalDate.of(1996, 1, 1), 50, 50, 50, "Delantero");
        Equipo cornella = equipoRepository.findOne(3L);
        josep.setOwner(cornella);
        jugadorRepository.save(josep);

        Jugador quim = new Jugador("Quim", LocalDate.of(1994, 1, 1), 50, 0, 0, "Mediocentro");
        quim.setOwner(cornella);
        jugadorRepository.save(quim);

        Jugador adrian = new Jugador("Adrian", LocalDate.of(1997, 1, 1), 0, 0, 50, "Portero");
        adrian.setOwner(cornella);
        jugadorRepository.save(adrian);

        Jugador billy = new Jugador("Billy", LocalDate.of(1994, 10, 25), 1, 1, 1, "Defensa");
        billy.setOwner(cornella);
        jugadorRepository.save(billy);

        Jugador sheila = new Jugador("Sheila", LocalDate.of(1993, 05, 14), 2, 2, 2, "Defensa");
        sheila.setOwner(cornella);
        jugadorRepository.save(sheila);

        System.out.println("Jugadores con nombre que contiene Jo: ");
        System.out.println(jugadorRepository.findByNombreContaining("Jo"));
        System.out.println("Jugadores con Numero de canastas total mayor que: ");
        System.out.println(jugadorRepository.findByNumcanastastotGreaterThanEqual(25));
        System.out.println("Jugadores con numero de assistencias entre rangos 45 y 50: ");
        System.out.println(jugadorRepository.findByNumassistenciastotBetween(45, 50));
        System.out.println("Jugadores que son Porteros: ");
        System.out.println(jugadorRepository.findByPosicion("Portero"));
        System.out.println("Jugadores nacidos antes del 1990: ");
        System.out.println(jugadorRepository.findByFechanaciminetoBefore(LocalDate.of(1990, 1, 1)));
        System.out.println("Jugadores ordenados por posicion: ");

        List<Object[]> jugadorList = jugadorRepository.mediaporposicionrebotescanastasassistencias();
        for (Object[] jugador : jugadorList)
        {
            System.out.println("Posicion : " + jugador[0]);
            System.out.println("Media de Canastas : " + jugador[1]);
            System.out.println("Media de Assistencias : " + jugador[2]);
            System.out.println("Media de Rebotes : " + jugador[3] + System.lineSeparator());
        }
        List<Object[]> jugadorList2 = jugadorRepository.mediamaxminporposicionrebotescanastasassistencias();
        for (Object[] jugador2 : jugadorList2)
        {
            System.out.println("Posicion : " + jugador2[0]);
            System.out.println("Media de Canastas : " + jugador2[1]);
            System.out.println("Min de Canastas : " + jugador2[2]);
            System.out.println("Max de Canastas : " + jugador2[3] + System.lineSeparator());
            System.out.println("Media de Assistencias : " + jugador2[4]);
            System.out.println("Min de Assistencias : " + jugador2[5]);
            System.out.println("Max de Assistencias : " + jugador2[6] + System.lineSeparator());
            System.out.println("Media de Rebotes : " + jugador2[7]);
            System.out.println("Min de Rebotes : " + jugador2[8]);
            System.out.println("Max de Rebotes : " + jugador2[9] + System.lineSeparator());
        }

        System.out.println("Jugadores del equipo FCB: ");
        System.out.println(jugadorRepository.findByOwnerNombre("FCB"));

        System.out.println("Jugadores del equipo FCB y de la posicion delantero: ");
        System.out.println(jugadorRepository.findByOwnerNombreAndPosicion("FCB", "delantero"));

        System.out.println("Jugador del Leicester con mas canastas: ");
        System.out.println(jugadorRepository.jugadormascanastasequipo("Leicester", new PageRequest(0,1)));



    }

}
