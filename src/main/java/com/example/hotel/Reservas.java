package com.example.hotel;

public class Reservas {

    private int idHabitacion;
    private String nombre;
    private String disponibilidad;


    public Reservas(int idHabitacion,String nombre,String disponibilidad){
        this.idHabitacion = idHabitacion;
        this.disponibilidad = disponibilidad; 
        this.nombre = nombre;
    }

    public int getIdHabitacion(){
        return idHabitacion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDisponibilidad(){
        return disponibilidad;
    }
}
