package com.peajesistema.peaje_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.peajesistema.peaje_api.models.Vehiculo;
import com.peajesistema.peaje_api.repository.VehiculoRepository;

@Configuration
public class DataLoader {
    
    @Bean
    CommandLineRunner initDatabase(VehiculoRepository repository){
        return args -> {
            System.out.println("🌱 Sembrando datos de prueba en la base de datos H2...");

            repository.save(new Vehiculo("honda-civic", "Joel Montero", 254.54, "Carro"));
            repository.save(new Vehiculo("crv-lexus", "Sawuel Montero", 500.54, "Camion"));

            System.out.println("✅ ¡Datos de prueba cargados exitosamente!");
        };
    }
}
