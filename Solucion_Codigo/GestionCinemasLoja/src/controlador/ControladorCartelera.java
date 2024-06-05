package controlador;

import modelo.Pelicula;

import java.io.*;
import java.util.ArrayList;

public class ControladorCartelera {

    private String archivoCartelera = "cartelera.txt";

    public void agregarPelicula(Pelicula pelicula) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoCartelera, true))) {
            escribir.write(pelicula.getNombre() + "," + pelicula.getGenero() + "," + pelicula.getDuracion() + "\n");
        } catch (IOException e) {
        }
    }

    public ArrayList<Pelicula> leerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoCartelera))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                peliculas.add(new Pelicula(partes[0], partes[1], partes[2]));
            }
        } catch (IOException e) {
        }
        return peliculas;
    }

    public void eliminarPelicula(int index) {
        ArrayList<Pelicula> peliculas = leerPeliculas();
        if (index >= 0 && index < peliculas.size()) {
            peliculas.remove(index);
            try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoCartelera))) {
                for (int i = 0; i < peliculas.size(); i++) {
                    Pelicula pelicula = peliculas.get(i);
                    escribir.write(pelicula.getNombre() + "," + pelicula.getGenero() + "," + pelicula.getDuracion() + "\n");
                }

            } catch (IOException e) {
            }
        }
    }
}
