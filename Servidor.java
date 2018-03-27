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

public class Servidor {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        try (ServerSocket srv = new ServerSocket(9995)) {
            log.info("Servidor listo, esperando cliente");
            Socket clt = srv.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(clt.getInputStream()));
            PrintWriter output = new PrintWriter(clt.getOutputStream());
            String linea = input.readLine();
            while (!linea.equals("Fin")) {
                log.debug("Datos recibidos:");
                System.out.println(linea);
                output.println("El servidor recibió " + linea.length() + " caracteres");
                output.flush();
                log.debug("Confirmando datos recibidos...");
                System.out.println("Éxito.");
                linea = input.readLine();
            }
            log.info("Conexion finalizada por el cliente");
            clt.close();
            srv.close();
        } catch (Exception e) {
            log.error("Ocurrió un error con el socket");
        }
        log.info("Fin de la Aplicación.");
    }
}
