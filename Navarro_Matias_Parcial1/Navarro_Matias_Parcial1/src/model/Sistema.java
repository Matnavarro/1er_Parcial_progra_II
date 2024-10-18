package model;

import excepciones.CodigoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public Servicio traerServicio(String codServicio) throws CodigoInvalidoException {
        for (Servicio servicio : lstServicio) {
            if (servicio.codServicio.equals(codServicio)) {
                return servicio;
            }
        }
        throw new CodigoInvalidoException("El codigo no está en el sistema");
    }

    public ArrayList<Servicio> traerServicio(boolean enOferta) throws CodigoInvalidoException {
        ArrayList<Servicio> serviciosDcto = new ArrayList<>();
        if (lstServicio == null) {
            throw new CodigoInvalidoException("No hay Servicios en la lista");
        }
        for (Servicio servicio : lstServicio) {
            if (servicio.enPromocion == enOferta) {
                serviciosDcto.add(servicio);
            }
        }
        return serviciosDcto;
    }

    public ArrayList<Servicio> traerServicio(boolean enOferta, LocalDate dia) throws CodigoInvalidoException {
        ArrayList<Servicio> serviciosEnOferta = new ArrayList<>();
        if (lstServicio == null) {
            throw new CodigoInvalidoException("No hay Servicios en la lista");
        }
        for (Servicio servicio : lstServicio) {
            if (servicio instanceof Hospedaje hospedaje) {
                if (hospedaje.enPromocion == enOferta && !(dia.getDayOfWeek().name().equals("SATURDAY") || dia.getDayOfWeek().name().equals("SUNDAY"))) {
                    serviciosEnOferta.add(hospedaje);
                }
            } else if (servicio instanceof Gastronomia gastronomia) {
                if (gastronomia.enPromocion == enOferta && dia.getDayOfWeek().getValue() == gastronomia.getDiaSemDesc()) {
                    serviciosEnOferta.add(gastronomia);
                }
            }
        }

        return serviciosEnOferta;
    }


    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws CodigoInvalidoException {
        Servicio gastro = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        return lstServicio.add(gastro);
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws CodigoInvalidoException {
        Servicio hosp = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        return lstServicio.add(hosp);
    }


}

