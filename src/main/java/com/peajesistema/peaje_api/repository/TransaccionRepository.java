package com.peajesistema.peaje_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peajesistema.peaje_api.models.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    
}
