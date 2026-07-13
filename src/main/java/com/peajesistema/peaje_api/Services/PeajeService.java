package com.peajesistema.peaje_api.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peajesistema.peaje_api.models.Vehiculo;
import com.peajesistema.peaje_api.repository.VehiculoRepository;

@Service
public class PeajeService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    private final Map<String, Vehiculo> mapaVehiculos = new HashMap<>();

    public PeajeService(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;

        vehiculoRepository.save( new Vehiculo("toyota-centra", "Joel Montero", 350.45));
        vehiculoRepository.save( new Vehiculo("honda-civic", "Sawuel Montero", 500.15));
    }

    public String procesarPasoPeaje(String tagId, double costo){

        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(tagId.toLowerCase());

        // ! verificar que exista el vehiculo
        if(vehiculoOptional.isEmpty()) {
            return "El vehiculo no registrado. Barrera Cerrada";
        }
        
        Vehiculo v = vehiculoOptional.get();

        if(v.getBalance() < costo){
            return "Rechazado: Saldo insuficiente para " + v.getPropietario() + ". Balance: RD$" + v.getBalance();
        }

        v.setBalance(v.getBalance() - costo);
        vehiculoRepository.save(v);
        return "¡Paso APROBADO! Buen viaje " + v.getPropietario() + ". Nuevo balance: RD$" + v.getBalance();

    }


}
