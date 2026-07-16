package com.peajesistema.peaje_api.Services;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peajesistema.peaje_api.models.Transaccion;
import com.peajesistema.peaje_api.models.Vehiculo;
import com.peajesistema.peaje_api.repository.TransaccionRepository;
import com.peajesistema.peaje_api.repository.VehiculoRepository;

@Service
public class PeajeService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    public PeajeService(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    public String procesarPasoPeaje(String tagId){

        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(tagId.toLowerCase());
        double costo = 0.0;

        // ! verificar que exista el vehiculo
        if(vehiculoOptional.isEmpty()) {
            return "El vehiculo no registrado. Barrera Cerrada";
        }
        
        Vehiculo v = vehiculoOptional.get();
        String tipoVehiculo = v.getTipo().toLowerCase(); // ? obtengo el tipo de vehiculo

        switch (tipoVehiculo) {
            case "carro":
                costo = 60.0;
                break;
            
            case "minibus":
                costo = 120.0;
                break;

            case "camion":
                costo = 250.0;
                break;

            default:
                costo = 50.0;
        }

        Transaccion t = new Transaccion();
        t.setMonto(costo);
        t.setTipo("COBRO");
        t.setFecha(LocalDateTime.now());
        t.setVehiculo(v);

        if(v.getBalance() < costo){
            t.setEstado("RECHAZADO");
            transaccionRepository.save(t);
            return "Rechazado: Saldo insuficiente para " + v.getPropietario() + ". Balance: RD$" + v.getBalance();
        }

        v.setBalance(v.getBalance() - costo);

        t.setEstado("APROBADO");
        transaccionRepository.save(t);
        vehiculoRepository.save(v);
        return "¡Paso APROBADO! Buen viaje " + v.getPropietario() + ". Nuevo balance: RD$" + v.getBalance();

    }

    // ! metodo para recargar balance
    public String recargarCredito(String tagId, double monto){
        Optional<Vehiculo> vehiculoRecargar = vehiculoRepository.findById(tagId.toLowerCase());

        if(vehiculoRecargar.isEmpty()){
            return "Vehículo no registrado. No se pudo realizar la recarga";
        }

        Vehiculo vActual = vehiculoRecargar.get();

        vActual.setBalance(vActual.getBalance() + monto);
        vehiculoRepository.save(vActual);

        return "Vehículo : " + vActual.getTagId() + " Recargado nuevo balance : " + vActual.getBalance();
    }
    // ! Metodos para el administrador (Realizar consultas)

    public String buscarVehiculo(String tagId){
        
        Optional<Vehiculo> consultarVehiculo = vehiculoRepository.findById(tagId.toLowerCase());

         if(consultarVehiculo.isEmpty()){
            return "Vehículo no registrado. No se pudo realizar el filtro";
        }

        Vehiculo vBuscado = consultarVehiculo.get();

        return "Vehiculo buscado : " + vBuscado.getTagId() + " Pertenece a : " + vBuscado.getPropietario();
    }


    public List<Vehiculo> buscarVehiculos(){
        return vehiculoRepository.findAll();
    }
}
