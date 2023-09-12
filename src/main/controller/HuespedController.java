package main.controller;

import main.DAO.HuespedDao;
import main.factory.ConnectionFactory;
import main.modelo.Huesped;

import java.util.List;

public class HuespedController {

    private HuespedDao huespedDao;
    public  HuespedController(){
        var factory = new ConnectionFactory();
        this.huespedDao = new HuespedDao(factory.recuperarConexion());
    }


    public void guardar(Huesped huesped){
        this.huespedDao.guardar(huesped);
    }

    public List<Huesped> lista(){
       return this.huespedDao.listaHuespedes();
    }

    public List<Huesped> getHuespedesPorApellido(String value){
        return this.huespedDao.getHuespedPorApellido(value);
    }
}
