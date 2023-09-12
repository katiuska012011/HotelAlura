package main.DAO;

import main.modelo.Huesped;
import main.modelo.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private Connection con;

    public ReservaDAO (Connection con){
        this.con = con;
    }

    public void guardar(Reserva reserva){
        try {
            final PreparedStatement statement = con.prepareStatement("INSERT INTO reserva(fechaEntrada, fechaSalida, valor, formaPago, numeroReserva)"
                    + "VALUES(?, ? ,?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                int numero = generarNumeroReserva();
                statement.setDate(1, new java.sql.Date(reserva.getFechaEntrada().getTime()));
                statement.setDate(2,  new java.sql.Date(reserva.getFechaSalida().getTime()));
                statement.setDouble(3, reserva.getValor());
                statement.setString(4, reserva.getFormaPago());
                statement.setInt(5, numero);
                statement.execute();
                final ResultSet resultSet = statement.getGeneratedKeys() ;
                try (resultSet) {
                    while (resultSet.next()) {
                        reserva.setId(Long.valueOf(resultSet.getInt(1)));
                        reserva.setNumeroReserva(numero);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public int generarNumeroReserva(){
        int min = 1;
        int max = 9000;
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public List<Reserva> lista() {
        List<Reserva> reservaList = new ArrayList<>();

        try {
            StringBuilder pst = new StringBuilder("SELECT id, fechaEntrada, fechaSalida, valor, formaPago ");
            pst.append("FROM reserva");

            final PreparedStatement statement = con.prepareStatement(pst.toString());

            try (statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet() ;
                try (resultSet) {
                    while (resultSet.next()) {
                        Reserva reserva = new Reserva( Long.valueOf(resultSet.getInt(1)), resultSet.getDate(2)
                                , resultSet.getDate(3), resultSet.getDouble(4), resultSet.getString(5));

                        reservaList.add(reserva);
                    }
                }
            }
            return reservaList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
