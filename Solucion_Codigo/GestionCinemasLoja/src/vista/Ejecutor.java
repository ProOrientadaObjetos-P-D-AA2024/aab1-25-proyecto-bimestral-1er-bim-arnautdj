package vista;

import modelo.*;
import controlador.ControladorCartelera;
import controlador.ControladorVenta;
import controlador.ControladorHorario;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ControladorVenta controladorVenta = new ControladorVenta();
        ControladorCartelera controladorCartelera = new ControladorCartelera();
        ControladorHorario controladorHorario = new ControladorHorario();

        ArrayList<Pelicula> peliculas = controladorCartelera.leerPeliculas();
        ArrayList<Horario> horarios = controladorHorario.leerHorarios();

        double total = 0;
        double totalBoletos = 0;
        double totalSnacks = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Gestionar cartelera");
            System.out.println("2. Gestionar horarios");
            System.out.println("3. Facturar boletos");
            System.out.println("4. Venta de snacks");
            System.out.println("5. Mostrar ventas");
            System.out.println("6. Salir");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    // Gestión de cartelera
                    System.out.println("1. Agregar nueva pelicula");
                    System.out.println("2. Eliminar pelicula");
                    int opcionGestion = entrada.nextInt();
                    entrada.nextLine();

                    if (opcionGestion == 1) {
                        System.out.println("Agregar nueva película:");
                        System.out.print("Nombre: ");
                        String nombrePelicula = entrada.nextLine();
                        System.out.print("Género: ");
                        String genero = entrada.nextLine();
                        System.out.print("Duración (en formato HH:MM): ");
                        String duracion = entrada.nextLine();
                        Pelicula nuevaPelicula = new Pelicula(nombrePelicula, genero, duracion);
                        controladorCartelera.agregarPelicula(nuevaPelicula);
                        peliculas = controladorCartelera.leerPeliculas();
                        System.out.println("Película agregada.");
                    } else if (opcionGestion == 2) {
                        System.out.println("Eliminar pelicula:");
                        for (int i = 0; i < peliculas.size(); i++) {
                            System.out.println((i + 1) + ". " + peliculas.get(i).getNombre());
                        }
                        int iPeliculaEliminar = entrada.nextInt() - 1;
                        entrada.nextLine();
                        controladorCartelera.eliminarPelicula(iPeliculaEliminar);
                        peliculas = controladorCartelera.leerPeliculas();
                        System.out.println("Pelicula eliminada.");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 2:
                    // Gestionar horarios
                    System.out.println("1. Agregar nuevo horario");
                    System.out.println("2. Eliminar horario");
                    int opcionHorario = entrada.nextInt();
                    entrada.nextLine();

                    if (opcionHorario == 1) {
                        System.out.println("Agregar nuevo horario:");
                        System.out.print("Día: ");
                        String dia = entrada.nextLine();
                        System.out.print("Hora: ");
                        String hora = entrada.nextLine();
                        Horario nuevoHorario = new Horario(dia, hora);
                        controladorHorario.agregarHorario(nuevoHorario);
                        horarios = controladorHorario.leerHorarios();
                        System.out.println("Horario agregado.");
                    } else if (opcionHorario == 2) {
                        System.out.println("Eliminar horario:");
                        for (int i = 0; i < horarios.size(); i++) {
                            System.out.println((i + 1) + ". " + horarios.get(i).getDia() + " " + horarios.get(i).getHora());
                        }
                        int iHorarioEliminar = entrada.nextInt() - 1;
                        entrada.nextLine();
                        controladorHorario.eliminarHorario(iHorarioEliminar);
                        horarios = controladorHorario.leerHorarios();
                        System.out.println("Horario eliminado exitosamente.");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3:
                    // Facturación de boletos
                    System.out.println("Seleccione una pelicula:");
                    for (int i = 0; i < peliculas.size(); i++) {
                        System.out.println((i + 1) + ". " + peliculas.get(i).getNombre());
                    }
                    int iPelicula = entrada.nextInt() - 1;
                    entrada.nextLine();

                    System.out.println("Seleccione un horario:");
                    for (int i = 0; i < horarios.size(); i++) {
                        System.out.println((i + 1) + ". " + horarios.get(i).getDia() + " " + horarios.get(i).getHora());
                    }
                    int iHorario = entrada.nextInt() - 1;
                    entrada.nextLine();

                    System.out.print("Cantidad de boletos ($8): ");
                    int cantidadBoletos = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nombre del cliente: ");
                    String cliente = entrada.nextLine();

                    ArrayList<Boleto> boletos = new ArrayList<>();
                    boletos.add(new Boleto(peliculas.get(iPelicula), horarios.get(iHorario), cantidadBoletos));

                    totalBoletos = cantidadBoletos * 8;

                    System.out.print("Desea agregar snacks? (s/n): ");
                    String agregarSnacks = entrada.nextLine();

                    ArrayList<Snack> snacks = new ArrayList<>();

                    if (agregarSnacks.equalsIgnoreCase("s")) {
                        System.out.println("Seleccione un snack:");
                        System.out.println("1. Canguil pequeño ($2)");
                        System.out.println("2. Canguil mediano ($5)");
                        System.out.println("3. Canguil grande ($8)");
                        System.out.println("4. Hot Dog ($3)");
                        System.out.println("5. Gaseosa personal ($2)");
                        int iSnack = entrada.nextInt();
                        entrada.nextLine();

                        System.out.print("Cantidad: ");
                        int cantidadSnack = entrada.nextInt();
                        entrada.nextLine();

                        switch (iSnack) {
                            case 1:
                                snacks.add(new Snack("Canguil pequeño", 2, cantidadSnack));
                                break;
                            case 2:
                                snacks.add(new Snack("Canguil mediano", 5, cantidadSnack));
                                break;
                            case 3:
                                snacks.add(new Snack("Canguil grande", 8, cantidadSnack));
                                break;
                            case 4:
                                snacks.add(new Snack("Hot Dog", 3, cantidadSnack));
                                break;
                            case 5:
                                snacks.add(new Snack("Gaseosa personal", 2, cantidadSnack));
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                continue;
                        }

                        for (int i = 0; i < snacks.size(); i++) {
                            Snack snack = snacks.get(i);
                            totalSnacks += snack.getPrecio() * snack.getCantidad();
                        }

                    }

                    total = totalBoletos + totalSnacks;

                    // Preguntar si se desea aplicar un descuento
                    System.out.print("Desea aplicar algún descuento? (s/n): ");
                    String aplicarDescuento = entrada.nextLine();
                    if (aplicarDescuento.equalsIgnoreCase("s")) {
                        System.out.print("Porcentaje de descuento: ");
                        double porcentajeDescuento = entrada.nextDouble();
                        entrada.nextLine();

                        if (porcentajeDescuento > 0 && porcentajeDescuento <= 100) {
                            double descuento = total * (porcentajeDescuento / 100);
                            total -= descuento;
                            System.out.printf("Descuento de %.2f%% aplicado.\n", porcentajeDescuento);
                        } else {
                            System.out.println("Porcentaje de descuento no válido.");
                        }
                    }

                    Venta venta = new Venta(cliente, boletos, snacks, total);
                    controladorVenta.registrarVenta(venta);

                    System.out.println("Facturación completada exitosamente.");
                    break;

                case 4:
                    // Venta de snacks
                    snacks = new ArrayList<>();
                    System.out.println("Seleccione un snack:");
                    System.out.println("1. Canguil pequeño ($2)");
                    System.out.println("2. Canguil mediano ($5)");
                    System.out.println("3. Canguil grande ($8)");
                    System.out.println("4. Hot Dog ($3)");
                    System.out.println("5. Gaseosa personal ($2)");
                    int iSnack = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidadSnack = entrada.nextInt();
                    entrada.nextLine(); // Consumir nueva línea

                    switch (iSnack) {
                        case 1:
                            snacks.add(new Snack("Canguil pequeño", 2, cantidadSnack));
                            break;
                        case 2:
                            snacks.add(new Snack("Canguil mediano", 5, cantidadSnack));
                            break;
                        case 3:
                            snacks.add(new Snack("Canguil grande", 8, cantidadSnack));
                            break;
                        case 4:
                            snacks.add(new Snack("Hot Dog", 3, cantidadSnack));
                            break;
                        case 5:
                            snacks.add(new Snack("Gaseosa personal", 2, cantidadSnack));
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }

                    for (int i = 0; i < snacks.size(); i++) {
                        Snack snack = snacks.get(i);
                        totalSnacks += snack.getPrecio() * snack.getCantidad();
                    }

                    // Preguntar si se desea aplicar un descuento
                    System.out.print("Desea aplicar algún descuento? (s/n): ");
                    String aplicarDescuentoSnacks = entrada.nextLine();
                    if (aplicarDescuentoSnacks.equalsIgnoreCase("s")) {
                        System.out.print("Porcentaje de descuento: ");
                        double porcentajeDescuento = entrada.nextDouble();
                        entrada.nextLine();

                        if (porcentajeDescuento > 0 && porcentajeDescuento <= 100) {
                            double descuento = totalSnacks * (porcentajeDescuento / 100);
                            totalSnacks -= descuento;
                            System.out.printf("Descuento de %.2f%% aplicado.\n", porcentajeDescuento);
                        } else {
                            System.out.println("Porcentaje de descuento no válido.");
                        }
                    }

                    System.out.print("Nombre del cliente: ");
                    String clienteSnacks = entrada.nextLine();

                    Venta ventaSnacks = new Venta(clienteSnacks, new ArrayList<>(), snacks, totalSnacks);
                    controladorVenta.registrarVenta(ventaSnacks);

                    System.out.println("Venta de snacks completada.");
                    break;

                case 5:
                    // Mostrar ventas
                    controladorVenta.mostrarVentas();
                    break;

                case 6:
                    // Salir
                    System.out.println("Ejecución finalizada");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
