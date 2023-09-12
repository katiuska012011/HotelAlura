package main.controller;

import main.DAO.ReservaDAO;
import main.factory.ConnectionFactory;
import main.modelo.Reserva;

import java.util.Date;
import java.util.List;

public class ReservaController {

    private ReservaDAO reservaDAO;

    public ReservaController(){
        var factory = new ConnectionFactory();
        this.reservaDAO= new ReservaDAO(factory.recuperarConexion());
    }


    public Reserva guardar(Reserva reserva){
        reservaDAO.guardar(reserva);
        return reserva;
    }

    public List<Reserva> lista(){
        return reservaDAO.lista();
    }

    public int eliminar (Long id){
        return reservaDAO.eliminar(id);
    }

    public int modificar( String formaPago, Long id){
        return  reservaDAO.modificar(formaPago, id);
    }

}
