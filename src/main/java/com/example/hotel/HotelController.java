package com.example.hotel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HotelController {
    
    private List<Hotel> hoteles = new ArrayList<>();

    

    public HotelController(){
        //Inicializa la lista de los hoteles
        hoteles.add(new Hotel(1, "Hotel She Raton", 
                    Arrays.asList(new Reservas(1, "1FF Basica", "No Disponible"),
                    new Reservas(2, "2SF", "No Disponible"),
                    new Reservas(3, "3TF", "No Disponible"),
                    new Reservas(4, "4FL", "No Disponible"),
                    new Reservas(5, "5FV", "Disponible"))));
        
        hoteles.add(new Hotel(2,"Hotel Perro Bravo",
                    Arrays.asList(new Reservas(1,"32FA","Disponible"),
                    new Reservas(2,"4FS","No Disponible"))));
      
        hoteles.add(new Hotel(3,"Hotel mi Choza", 
                    Arrays.asList(new Reservas(1,"3GA","Disponible"),
                    new Reservas(2,"5GS","No Disponible"))));
        
        hoteles.add(new Hotel(4,"Hotel Mira El Mar",
                    Arrays.asList(new Reservas(1,"3FH","No Disponible"),
                    new Reservas(2,"7FS","No Disponible"))));
       
        hoteles.add(new Hotel(5,"Hotel Anda palla", 
                    Arrays.asList(new Reservas(1,"2CA","Disponible"),
                    new Reservas(2,"6CS","No Disponible"))));

    }   

    @GetMapping("/hoteles")
    public List<Hotel> getHoteles() {
        return hoteles;
    }

    @GetMapping("/hoteles/{idHotel}")
    public Hotel getHotel(@PathVariable int idHotel) {
        for(Hotel elemento : hoteles){
            if(elemento.getIdHotel() == idHotel){
                return elemento;
            }
            
        }
        return null;
    }

    @GetMapping("hoteles/{idHotel}/disponibilidad/{disponibilidad}")
    public List<Hotel> getDisponibilidad(@PathVariable ("idHotel") Integer idHotel,@PathVariable("disponibilidad") String disponibilidad) 
    {
        List<Hotel> listaHotel = new ArrayList<>();
        List<Reservas> listaReserva = new ArrayList<>();

        for(Hotel itemHotel: hoteles){
            if(idHotel == itemHotel.getIdHotel()){

                //Recorre cada reserva del hotel seleccionado 
                for(Reservas itemReserva: itemHotel.getReserva()){
                    //si item reserva.get disponibilidad es igual a la diponibilidad
                    // entra al if 
                    if (itemReserva.getDisponibilidad().equals(disponibilidad)){

                        //Cada vez que se ejecuta este codigo a lista reserva se le agrega un
                        // nuevo objeto de tipo reserva
                        listaReserva.add(new Reservas(itemReserva.getIdHabitacion(),
                        itemReserva.getNombre(), 
                        itemReserva.getDisponibilidad()));
                    }
                }
                //luego nuestros objetos de tipo reserva se agregar a la lista de hotel
                // sin haber duplicidad al momento de imprimir el json
                listaHotel.add(new Hotel( itemHotel.getIdHotel(),itemHotel.getNombre(), listaReserva));

            }
        }
        return listaHotel;

    }
        
}