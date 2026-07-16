package com.peajesistema.peaje_api.models;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private double monto;
    private String estado;
    private String tipo;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "vehiculo_tag_id")
    private Vehiculo vehiculo;

    // * constructores
    public Transaccion(){

    }

    public Transaccion(long id, double monto, String estado, String tipo, LocalDateTime fecha, Vehiculo vehiculo){
        this.id = id;
        this.monto = monto;
        this.estado = estado;
        this.tipo = tipo;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setFecha(LocalDateTime fecha){
        this.fecha = fecha;
    }

    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }


    public long getId(){
        return id;
    }

    public double getMonto(){
        return monto;
    }

    public String getEstado(){
        return estado;
    }

    public String getTipo(){
        return tipo;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

}
