package controlador;

import modelo.Horario;

import java.io.*;
import java.util.ArrayList;

public class ControladorHorario {

    private String archivoHorarios = "horarios.txt";

    public void agregarHorario(Horario horario) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoHorarios, true))) {
            escribir.write(horario.getDia() + "," + horario.getHora() + "\n");
        } catch (IOException e) {
        }
    }

    public ArrayList<Horario> leerHorarios() {
        ArrayList<Horario> horarios = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoHorarios))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                horarios.add(new Horario(partes[0], partes[1]));
            }
        } catch (IOException e) {
        }
        return horarios;
    }

    public void eliminarHorario(int index) {
        ArrayList<Horario> horarios = leerHorarios();
        if (index >= 0 && index < horarios.size()) {
            horarios.remove(index);
            try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoHorarios))) {
                for (int i = 0; i < horarios.size(); i++) {
                    Horario horario = horarios.get(i);
                    escribir.write(horario.getDia() + "," + horario.getHora() + "\n");
                }
            } catch (IOException e) {;
            }
        }
    }
}
