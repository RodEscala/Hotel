package com.example.hotel;

import java.util.List;

public class Hotel {
    private int idHotel;
    private String nombre;
    private List<Reservas> reservas;
    // private Map<Integer,List<String>> hotelReservas;

    public Hotel(int idHotel,String nombre,List<Reservas> reservas)
    {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.reservas = reservas;
        // this.hotelReservas = hotelReservas;
    }


    public int getIdHotel(){
        return idHotel;
    }

    public String getNombre(){
        return nombre;
    }

    public List<Reservas> getReserva(){
        return reservas;
    }


    
}
