package com.peajesistema.peaje_api.Models;

public class Vehiculo {
    private String tagId;
    private String propietario;
    private double balance;

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
