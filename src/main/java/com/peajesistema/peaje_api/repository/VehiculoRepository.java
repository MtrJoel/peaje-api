package com.peajesistema.peaje_api.repository;

import com.peajesistema.peaje_api.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Le dice a Spring: "Este componente maneja la base de datos"
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    // ¡NO ESCRIBES CÓDIGO! 
    // Al heredar de JpaRepository<Clase, TipoDeLlavePrimaria>,
    // Spring Boot te regala métodos como: .findById(), .save(), .delete(), .findAll()
}