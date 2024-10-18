package model;

import excepciones.CodigoInvalidoException;

import java.time.LocalDate;

public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws CodigoInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }


    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (super.enPromocion) {
            if (!(dia.getDayOfWeek().name().equals("SATURDAY") || dia.getDayOfWeek().name().equals("SUNDAY"))) {
                precioPorNoche -= precioPorNoche * porcentajeDescuento / 100;
                return precioPorNoche;
            }
        }

        return precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hospedaje{" +
                "hospedaje='" + hospedaje + '\'' +
                ", precioPorNoche=" + precioPorNoche +
                ", codServicio='" + codServicio + '\'' +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", enPromocion=" + enPromocion +
                '}';
    }
}
