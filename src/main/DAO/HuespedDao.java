package main.DAO;

import main.modelo.Huesped;
import main.modelo.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuespedDao {

    private Connection connection;
    public HuespedDao(Connection connection){
        this.connection = connection;
    }
    public void guardar(Huesped huesped){
        try {
            StringBuilder pst = new StringBuilder(200);
            pst.append("INSERT INTO huesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, numeroReserva) ");
            pst.append("VALUES (?, ?, ?, ?, ?, ?)");

            final PreparedStatement statement = connection.prepareStatement(pst.toString(), Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setString(1,huesped.getNombre());
                statement.setString(2, huesped.getApellido());
                statement.setDate(3,  new java.sql.Date(huesped.getFechaNacimiento().getTime()));
                statement.setString(4,huesped.getNacionalidad());
                statement.setString(5, huesped.getTelefono());
                statement.setInt(6, huesped.getNumeroReserva());
                statement.execute();
                final ResultSet resultSet = statement.getGeneratedKeys() ;
                try (resultSet) {
                    while (resultSet.next()) {
                        huesped.setId(Long.valueOf(resultSet.getInt(1)));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    public List<Huesped> listaHuespedes(){

        List<Huesped> huespedList = new ArrayList<>();

        try {
            StringBuilder pst = new StringBuilder("SELECT id, nombre, apellido, fechaNacimiento, nacionalidad, ");
            pst.append("telefono, numeroReserva  FROM huesped");

            final PreparedStatement statement = connection.prepareStatement(pst.toString());

            try (statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet() ;
                try (resultSet) {
                    while (resultSet.next()) {
                        Huesped huesped = new Huesped( Long.valueOf(resultSet.getInt(1)), resultSet.getString(2)
                        , resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5)
                        , resultSet.getString(6), resultSet.getInt(7));

                        huespedList.add(huesped);
                    }
                }
            }
            return huespedList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Huesped> getHuespedPorApellido(String value){

        List<Huesped> huespedList = new ArrayList<>();

        try {
            StringBuilder pst = new StringBuilder("SELECT id, nombre, apellido, fechaNacimiento, nacionalidad, ");
            pst.append("telefono, numeroReserva  FROM huesped  WHERE  apellido  LIKE '%").append(value).append("%'")
                    .append(" OR numeroReserva LIKE '%").append(value).append("%'");

            final PreparedStatement statement = connection.prepareStatement(pst.toString());

            try (statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet() ;
                try (resultSet) {
                    while (resultSet.next()) {
                        Huesped huesped = new Huesped( Long.valueOf(resultSet.getInt(1)), resultSet.getString(2)
                                , resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5)
                                , resultSet.getString(6), resultSet.getInt(7));
                        huespedList.add(huesped);
                    }
                }
                if(huespedList.isEmpty()){
                    return Collections.emptyList();
                }else{
                    return huespedList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
