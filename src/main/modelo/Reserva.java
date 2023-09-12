package main.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Reserva {

    private Long id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Double valor;
    private String formaPago;
    private int numeroReserva;

    public Reserva(Date fechaEntrada, Date fechaSalida, Double valor, String formaPago) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public Reserva(Long id, Date fechaEntrada, Date fechaSalida, Double valor, String formaPago) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", valor=" + valor +
                ", formaPago='" + formaPago + '\'' +
                ", numeroReserva=" + numeroReserva +
                '}';
    }
}
