/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.*;
import java.net.*;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class Cliente {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        Recursividad sc = new Recursividad();
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        log.info("Inicializando la conexion con el servidor...");
        Socket clt = new Socket("localhost", 9995);
        log.info("Conexion Establecida!");
        BufferedReader input = new BufferedReader(new InputStreamReader(clt.getInputStream()));
        PrintWriter output = new PrintWriter(clt.getOutputStream());
        log.debug("Enviando datos al servidor...");
        output.println("Quiero hacer una inversion");
        output.flush();
        System.out.println(input.readLine());
        log.debug("Enviando datos al servidor...");
        output.println(sc.invertir(array, array.length - 1));
        output.flush();
        System.out.println(input.readLine());
        output.println("Fin");
        output.flush();
        log.info("Conexion con el servidor finalizada");
    }
}
