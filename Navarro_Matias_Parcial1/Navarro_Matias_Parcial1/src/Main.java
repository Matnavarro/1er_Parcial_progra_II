import excepciones.CodigoInvalidoException;
import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;
import model.Sistema;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CodigoInvalidoException {

        try {
            System.out.println("-----------------1-1-------------------\n");
            Servicio gastronomia1 = new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println(gastronomia1);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("-----------------1-2-------------------\n");
            Servicio gastronomia2 = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println(gastronomia2);
            System.out.println("-----------------2-1-------------------\n");
            System.out.println(gastronomia2.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("-----------------1-3-------------------\n");
            Servicio hospedaje1 = new Hospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println(hospedaje1);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("-----------------1-4-------------------\n");
            Servicio hospedaje2 = new Hospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println(hospedaje2);

            System.out.println("-----------------2-2-------------------\n");
            System.out.println(hospedaje2.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("----------------- 3 -------------------\n");
        Sistema sistema = new Sistema();
        try {
            //Servicio gastronomia1 = new Gastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            //Servicio hospedaje1 = new Hospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            //Servicio gastronomia2 = new Gastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            //Servicio hospedaje2 = new Hospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);

            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);

        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("-----------------4-1-------------------\n");
            System.out.println(sistema.traerServicio(true));
            System.out.println("-----------------4-2-------------------\n");
            System.out.println(sistema.traerServicio(true, LocalDate.of(2020, 10, 28)));

        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}