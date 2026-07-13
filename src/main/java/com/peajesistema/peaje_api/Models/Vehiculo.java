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
    private double balance;

    public Vehiculo(){

    }

    // * contructor
    public Vehiculo(String tagId, String propietario, double balance){
        this.tagId = tagId;
        this.propietario = propietario;
        this.balance =  balance;
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


}
