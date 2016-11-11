package com.example;

import com.example.service.EquipoService;
import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@EntityScan(
		basePackageClasses = { FutbolApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
public class FutbolApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(FutbolApplication.class, args);

		context.getBean(EquipoService.class).testEquipo();
		context.getBean(JugadorService.class).testJugador();

	}
}
