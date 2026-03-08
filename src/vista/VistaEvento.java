package vista;

import modelo.*;
import controlador.GestionSistema;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VistaEvento {

    public static void crearEvento(Organizador organizador, Scanner sc) {
        final String MORADO = "\u001B[35m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(MORADO + " ┌───────────────────────┐");
        System.out.println(MORADO + " │     "+BLANCO+"CREAR EVENTO"+MORADO+"      │");
        System.out.println(MORADO + " └───────────────────────┘"+RESET);
        System.out.print("Inserte el nombre del evento: ");
        String nombre = sc.nextLine();
        System.out.print("Inserte la descripción: ");
        String descripcion = sc.nextLine();

        System.out.println("Categorías:");
        Categoria[] categorias = Categoria.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }
        System.out.print("Seleccione (1-7): ");
        int opcionCategoria = Integer.parseInt(sc.nextLine());
        Categoria categoriaElegida = categorias[opcionCategoria - 1];

        System.out.print("Fecha (dd/MM/yyyy HH:mm): ");
        String fechaElegida = sc.nextLine();
        DateTimeFormatter formatoFechaYHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fecha = LocalDateTime.parse(fechaElegida, formatoFechaYHora);

        System.out.print("Aforo: ");
        int aforo = Integer.parseInt(sc.nextLine());

        System.out.print("¿Cuantos tipos de entrada? (1-3): ");
        int numeroEntradas = Integer.parseInt(sc.nextLine());
        if (numeroEntradas > 3) numeroEntradas = 3;

        TipoEntrada[] tipos = new TipoEntrada[numeroEntradas];
        for (int i = 0; i < numeroEntradas; i++) {
            System.out.println("Tipo " + (i+1) + ":");
            System.out.print("Inserte el nombre: ");
            String nombreTipoEntrada = sc.nextLine();
            System.out.print("Inserte el precio: ");
            double precioTipoEntrada = Double.parseDouble(sc.nextLine());
            System.out.print("Inserte el stock: ");
            int stockTipoEntrada = Integer.parseInt(sc.nextLine());
            System.out.println("Inserte la descripción: ");
            String descripcionTipoEntrada = sc.nextLine();
            tipos[i] = new TipoEntrada(nombreTipoEntrada, descripcionTipoEntrada + nombreTipoEntrada, precioTipoEntrada, stockTipoEntrada);
        }

        Evento nuevoEvento = new Evento(nombre, descripcion, categoriaElegida, fecha, aforo, tipos, organizador.getId());
        GestionSistema.guardarEvento(nuevoEvento);
        System.out.println("Evento creado con éxito.");
    }

    public static void modificarEvento(Evento e, Scanner sc) {
        System.out.print("Nuevo nombre: ");
        e.setNombre(sc.nextLine());
        System.out.print("Nuevo aforo: ");
        e.setAforo(Integer.parseInt(sc.nextLine()));
        System.out.println("Evento actualizado con éxito.");
    }
}