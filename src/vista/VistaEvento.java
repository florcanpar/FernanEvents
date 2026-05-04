package vista;

import modelo.*;
import controlador.GestionSistema;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VistaEvento {

    public static void crearEvento(Organizador organizador) {
        Scanner sc = new Scanner(System.in);
        final String MORADO = "\u001B[35m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(MORADO + " ┌───────────────────────┐\n │     "+BLANCO+"CREAR EVENTO"+MORADO+"      │\n └───────────────────────┘"+RESET);

        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Descripción: "); String desc = sc.nextLine();

        Categoria[] cats = Categoria.values();
        for (int i = 0; i < cats.length; i++) System.out.println((i+1) + ". " + cats[i]);
        System.out.print("Categoría: "); Categoria cat = cats[Integer.parseInt(sc.nextLine()) - 1];

        System.out.print("Fecha (dd/MM/yyyy HH:mm): ");
        LocalDateTime fecha = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.print("Aforo: "); int aforo = Integer.parseInt(sc.nextLine());
        System.out.print("Número de tipos de entrada (1-3): ");
        int n = Math.min(Integer.parseInt(sc.nextLine()), 3);

        TipoEntrada[] tipos = new TipoEntrada[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre tipo " + (i+1) + ": "); String nt = sc.nextLine();
            System.out.print("Precio: "); double p = Double.parseDouble(sc.nextLine());
            System.out.print("Stock: "); int s = Integer.parseInt(sc.nextLine());
            tipos[i] = new TipoEntrada(nt, desc + " " + nt, p, s);
        }

        GestionSistema.guardarEvento(new Evento(nombre, desc, cat, fecha, aforo, tipos, organizador.getId()));
        System.out.println("Evento creado.");
    }

    public static void modificarEvento(Evento e) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nuevo nombre: "); e.setNombre(sc.nextLine());
        System.out.print("Nuevo aforo: "); e.setAforo(Integer.parseInt(sc.nextLine()));
    }
}