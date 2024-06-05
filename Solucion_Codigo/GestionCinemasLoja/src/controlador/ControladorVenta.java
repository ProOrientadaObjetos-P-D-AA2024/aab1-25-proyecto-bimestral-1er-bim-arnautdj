package controlador;

import modelo.*;
import java.io.*;
import java.util.ArrayList;

public class ControladorVenta {

    private String archivoVentas = "ventas.txt";

    public void registrarVenta(Venta venta) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoVentas, true))) {
            escribir.write("Cliente: " + venta.getCliente() + "\n");
            for (Boleto boleto : venta.getBoletos()) {
                escribir.write("Pelicula:\n" + boleto.getPelicula().getNombre() 
                        + ", Horario: " + boleto.getHorario().getDia() + " " + 
                        boleto.getHorario().getHora() + ", Boletos: " + boleto.getCantidad() + "\n");
            }
            if (!venta.getSnacks().isEmpty()) {
                escribir.write("Snacks: \n");
                for (Snack snack : venta.getSnacks()) {
                    escribir.write(snack.getNombre() + ", Precio: " + snack.getPrecio() 
                            + ", Cantidad: " + snack.getCantidad() + "\n");
                }
            }
            escribir.write("Total: $" + venta.getTotal() + "\n");
            escribir.write("----------------------------------------------\n");
        } catch (IOException e) {
        }
    }

    public void mostrarVentas() {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoVentas))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
        }
    }
}
