package org.example.app;

import org.example.service.OnePieceService;
//Encuentra los piratas con una recompensa superior a 100.000.000 berries Muestra sus nombre
//apodos recompensas , si el rango esta vacio muestra "sin rango"
public class Main {
    public static void main(String[] args) {
        /**
         * JDBC --> ApI librerias que nos permiten conectar con bd
         * PreparedStatement. DriverManager , Connection
         *
         * Hibernate --> Herramiento DRM
         * @TABLE , @Entity --> Anotaciones
         * -entity(model)
         * -dao
         * -service
         * -app
         * -util
         */

        OnePieceService onePieceService = new OnePieceService();
        System.out.println(onePieceService.getTripulacionByName("Kuja Pirates"));
    }
}
