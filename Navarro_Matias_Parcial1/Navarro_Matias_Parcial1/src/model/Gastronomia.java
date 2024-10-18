package model;

import excepciones.CodigoInvalidoException;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc;


    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gatronomia, double precio, int diaSemDesc) throws CodigoInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gatronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion) {
            if (dia.getDayOfWeek().getValue() == diaSemDesc) {
                precio -= precio * porcentajeDescuento / 100;
                return precio;
            }

        }
        return precio;
    }

    @Override
    public String toString() {
        return "Gastronomia{" +
                "gastronomia='" + gastronomia + '\'' +
                ", precio=" + precio +
                ", diaSemDesc=" + diaSemDesc +
                ", codServicio='" + codServicio + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", enPromocion=" + enPromocion +
                '}';
    }
}
