package model;

import excepciones.CodigoInvalidoException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected static final Set<String> codigosServicios = new HashSet<>();


    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws CodigoInvalidoException{
        if (codServicio == null || codServicio.length() != 6 || !codigosServicios.add(codServicio)){
            throw new CodigoInvalidoException("El codigo es invalido");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);
}
