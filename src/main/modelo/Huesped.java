package main.modelo;

import java.util.Date;

public class Huesped {

    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;

    private String telefono;
    private int numeroReserva;


    public Huesped( String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, int numeroReserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.numeroReserva = numeroReserva;
    }

    public Huesped(Long id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, int numeroReserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.numeroReserva = numeroReserva;
    }

    public Huesped() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numeroReserva=" + numeroReserva +
                '}';
    }
}
