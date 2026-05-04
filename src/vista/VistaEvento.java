package vista;

import modelo.*;
import controlador.GestionSistema;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; // 1. IMPORTACIÓN NECESARIA
import java.util.Scanner;

public class VistaEvento {

    public static void crearEvento(Organizador organizador) {
        Scanner sc = new Scanner(System.in);
        // ... (Colores se mantienen igual)
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
        System.out.print("Número de tipos de entrada (sin límite ahora): ");
        int n = Integer.parseInt(sc.nextLine());

        // 2. CAMBIO CLAVE: De array fijo [] a ArrayList dinámico
        ArrayList<TipoEntrada> tipos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Configurando tipo " + (i+1) + " ---");
            System.out.print("Nombre tipo: "); String nt = sc.nextLine();
            System.out.print("Precio: "); double p = Double.parseDouble(sc.nextLine());
            System.out.print("Stock: "); int s = Integer.parseInt(sc.nextLine());

            // 3. Usamos .add() en lugar de índices[cite: 5]
            tipos.add(new TipoEntrada(nt, desc + " " + nt, p, s));
        }

        // 4. Ahora el constructor de Evento recibirá el ArrayList correctamente[cite: 5]
        GestionSistema.guardarEvento(new Evento(nombre, desc, cat, fecha, aforo, tipos, organizador.getId()));
        System.out.println("✅ Evento creado correctamente con " + tipos.size() + " tipos de entrada.");
    }

    public static void modificarEvento(Evento e) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nuevo nombre: "); e.setNombre(sc.nextLine());
        System.out.print("Nuevo aforo: "); e.setAforo(Integer.parseInt(sc.nextLine()));
    }
}