package vista;

import controlador.GestionSistema;
import modelo.*;
import java.util.ArrayList; // Importante para manejar las nuevas listas
import java.util.Scanner;

public class VistaAsistente {

    public static void menu(Asistente asistente) {
        Scanner sc = new Scanner(System.in);
        // ... (colores y lógica de menú igual)
        int opcion = 0;
        while (opcion != 6) {
            // ... (impresión de menú igual)
            try {
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion == 1) mostrarMisEventos(asistente);
                else if (opcion == 2) mostrarEventosPlataforma(asistente);
                else if (opcion == 3) gestionarCartera(asistente, sc);
                else if (opcion == 4) invitarAmigo(asistente, sc);
                else if (opcion == 5) configurarCuenta(asistente, sc);
            } catch (Exception e) { System.out.println("Entrada inválida."); }
        }
    }

    private static void gestionarCartera(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";
        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      "+BLANCO+"MI CARTERA"+AZUL+"       │");
        System.out.println(AZUL + " └───────────────────────┘"+RESET);
        System.out.println("Saldo actual: " + asistente.getCartera() + "€.");
        System.out.println(AZUL +"《1》" + RESET + " Añadir saldo.");
        System.out.println(AZUL +"《2》" + RESET + " Retirar saldo.");
        System.out.println(AZUL +"《3》" + RESET + " Volver.");
        int accion = Integer.parseInt(sc.nextLine());
        if (accion == 1) {
            System.out.print("Cantidad a añadir: ");
            asistente.setCartera(asistente.getCartera() + Double.parseDouble(sc.nextLine()));
        } else if (accion == 2) {
            System.out.print("Cantidad a retirar: ");
            asistente.setCartera(asistente.getCartera() - Double.parseDouble(sc.nextLine()));
        }
    }

    private static void configurarCuenta(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";
        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │   "+BLANCO+"CONFIGURAR CUENTA"+AZUL+"   │");
        System.out.println(AZUL + " └───────────────────────┘"+RESET);
        System.out.print("Nuevo nombre: "); asistente.setNombre(sc.nextLine());
        System.out.print("Nueva contraseña: "); asistente.setContrasenia(sc.nextLine());
    }

    private static void invitarAmigo(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";
        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      "+BLANCO+"INVITAR AMIGOS"+AZUL+"   │");
        System.out.println(AZUL + " └───────────────────────┘"+RESET);
        System.out.println("Amigos referidos: " + asistente.getAmigos());
        System.out.print("Introduce email del amigo: ");
        String email = sc.nextLine();
        asistente.setAmigos(asistente.getAmigos() + email + ", ");
    }

    private static void mostrarMisEventos(Asistente asistente) {
        Scanner sc = new Scanner(System.in);
        // ... (colores e interfaz igual)

        // CORRECCIÓN LÍNEA 43: Ahora obtenemos un ArrayList<Entrada> del asistente[cite: 1]
        ArrayList<Entrada> entradas = asistente.getMisEntradas();

        if (entradas.isEmpty()) { // Uso de .isEmpty() en lugar de contador manual
            System.out.println("No tienes inscripciones aún.");
        } else {
            System.out.println("Listado de tus compras:");
            for (int i = 0; i < entradas.size(); i++) { // .size() en lugar de .length[cite: 1]
                // Acceso con .get(i) en lugar de corchetes[cite: 1]
                String nombreEvento = entradas.get(i).getEvento().getNombre();
                String nombreTicket = entradas.get(i).getTipo().getNombre();
                int cant = entradas.get(i).getCantidad();

                System.out.println("《" + i + "》 Evento: " + nombreEvento +
                        " | Tipo: " + nombreTicket + " | Cant: " + cant);
            }

            System.out.print("\nInserte el índice para ver detalles o -1 para volver: ");
            int id = Integer.parseInt(sc.nextLine());
            if (id >= 0 && id < entradas.size()) {
                System.out.println("\n--- DETALLES DEL EVENTO ---");
                System.out.println(entradas.get(id).getEvento().toString());
            }
        }
    }

    private static void mostrarEventosPlataforma(Asistente asistente) {
        Scanner sc = new Scanner(System.in);
        // ... (interfaz igual)

        GestionSistema.listarEventos(); // Este método ya usa el ArrayList interno[cite: 2]
        System.out.print("\nInserte la ID del evento para ver detalles o -1 para salir: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id != -1) {
            Evento e = GestionSistema.getEvento(id);
            if (e != null) {
                System.out.println(e.toString());

                System.out.print("\n¿Desea comprar entradas? (S/N): ");
                if (sc.nextLine().equalsIgnoreCase("S")) {

                    // CORRECCIÓN LÍNEA 94: e.getTiposEntradas() ahora devuelve un ArrayList[cite: 1]
                    ArrayList<TipoEntrada> tipos = e.getTiposEntradas();

                    System.out.println("\nTipos de entrada disponibles:");
                    for (int i = 0; i < tipos.size(); i++) { // .size() en lugar de .length[cite: 1]
                        // Acceso con .get(i) para obtener el objeto TipoEntrada[cite: 1]
                        System.out.println(i + ". " + tipos.get(i).getNombre() +
                                " | " + tipos.get(i).getPrecio() + "€ | Stock: " +
                                tipos.get(i).getStockDisponible());
                    }

                    System.out.print("Seleccione tipo (índice): ");
                    int selTipo = Integer.parseInt(sc.nextLine());

                    System.out.print("¿Cuántas entradas desea?: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    // El controlador ya está preparado para recibir el índice del ArrayList[cite: 2]
                    boolean exito = GestionSistema.tramitarCompra(asistente, e, selTipo, cantidad);

                    if (exito) {
                        double total = tipos.get(selTipo).getPrecio() * cantidad;
                        System.out.println("✅ Compra exitosa.");
                    } else {
                        System.out.println("❌ Error: Saldo insuficiente o no hay suficiente stock.");
                    }
                }
            } else {
                System.out.println("Evento no encontrado.");
            }
        }
    }

    // ... (El resto de métodos no tocan eventos ni entradas, se quedan igual)
}