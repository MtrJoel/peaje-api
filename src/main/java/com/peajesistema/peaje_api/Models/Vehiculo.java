package com.peajesistema.peaje_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    private String tagId;
    
    private String propietario;
    private String tipo;
    private double balance;

    public Vehiculo(){

    }

    // * contructor
    public Vehiculo(String tagId, String propietario, double balance, String tipo){
        this.tagId = tagId;
        this.propietario = propietario;
        this.balance =  balance;
        this.tipo = tipo;
    }

    // * getter y setters
    public String getTagId(){
        return tagId;
    }

    public String getPropietario(){
        return propietario;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }


}
