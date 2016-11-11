package com.example.repository;

import com.example.domain.Jugador;
import com.example.domain.Equipo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dam on 4/11/16.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador>findByNombreContaining(String name);
    List<Jugador>findByNumcanastastotGreaterThanEqual(int canastas);
    List<Jugador>findByNumassistenciastotBetween(int min, int max);
    List<Jugador>findByPosicion(String posicion);
    List<Jugador>findByFechanaciminetoBefore(LocalDate date);

    @Query("SELECT jugador.posicion, AVG(jugador.numcanastastot), MIN(jugador.numassistenciastot), MAX(jugador.numrebotestot) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> mediaporposicionrebotescanastasassistencias();

    @Query("SELECT jugador.posicion, AVG(jugador.numcanastastot), MIN(jugador.numcanastastot),MAX(jugador.numcanastastot)," +
            " AVG(jugador.numassistenciastot), MIN(jugador.numassistenciastot), MAX(jugador.numassistenciastot), AVG(jugador.numrebotestot), MIN(jugador.numrebotestot), " +
            "MAX(jugador.numrebotestot) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> mediamaxminporposicionrebotescanastasassistencias();

    List<Jugador>findByOwnerNombre(String name);

    List<Jugador>findByOwnerNombreAndPosicion(String name, String posicion);

    @Query("SELECT jugador  FROM Jugador jugador  WHERE jugador.owner.nombre = :nombre ORDER BY jugador.numcanastastot desc")
    List<Object[]> jugadormascanastasequipo(@Param("nombre") String nombre, Pageable pageable);

}
