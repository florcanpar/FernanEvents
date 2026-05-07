package vista;

import controlador.GestionSistema;
import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaAsistente {

    public static void menu(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String AMARILLO = "\u001B[33m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";

        int opcion = 0;
        while (opcion != 6) {
            System.out.println(AZUL + "╭───────────── " + AMARILLO + "◈" + AZUL + " ─────────────╮");
            System.out.println("  " + AMARILLO + "《" + BLANCO + "  MENÚ DE ASISTENTE   " + AMARILLO + "》");
            System.out.println(AZUL + "╰───────────── " + AMARILLO + "◈" + AZUL + " ─────────────╯" + RESET);
            System.out.println(AZUL + "《1》" + RESET + " Mis eventos");
            System.out.println(AZUL + "《2》" + RESET + " Ver todos los Eventos");
            System.out.println(AZUL + "《3》" + RESET + " Cartera digital");
            System.out.println(AZUL + "《4》" + RESET + " Invita a un amigo");
            System.out.println(AZUL + "《5》" + RESET + " Configuración");
            System.out.println(AZUL + "《6》" + RESET + " Cerrar sesión");
            System.out.print("Seleccione: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> mostrarMisEventos(asistente, sc);
                    case 2 -> mostrarEventosPlataforma(asistente, sc);
                    case 3 -> gestionarCartera(asistente, sc);
                    case 4 -> invitarAmigo(asistente, sc);
                    case 5 -> configurarCuenta(asistente, sc);
                    case -1 -> System.out.println("Cerrando sesión...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Inserte un número válido.");
                opcion = 0;
            }
        }
    }

    private static void mostrarMisEventos(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";

        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      " + BLANCO + "MIS EVENTOS" + AZUL + "      │");
        System.out.println(AZUL + " └───────────────────────┘" + RESET);

        ArrayList<Entrada> entradas = asistente.getMisEntradas();

        if (entradas.isEmpty()) {
            System.out.println("No tienes inscripciones aún.");
        } else {
            System.out.println("Listado de tus compras:");
            for (int i = 0; i < entradas.size(); i++) {
                Entrada e = entradas.get(i);
                System.out.println(AZUL + "《" + i + "》" + RESET + " Evento: " + e.getEvento().getNombre() +
                        " | Tipo: " + e.getTipo().getNombre() + " | Cant: " + e.getCantidad());
            }

            System.out.print("\nInserte el índice para ver detalles o -1 para volver: ");
            try {
                int id = Integer.parseInt(sc.nextLine());
                if (id >= 0 && id < entradas.size()) {
                    System.out.println("\n--- DETALLES DEL EVENTO ---");
                    System.out.println(entradas.get(id).getEvento().toString());
                }
            } catch (Exception e) {
                System.out.println("Volviendo al menú...");
            }
        }
    }

    private static void mostrarEventosPlataforma(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";

        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      " + BLANCO + "LOS EVENTOS" + AZUL + "      │");
        System.out.println(AZUL + " └───────────────────────┘" + RESET);

        GestionSistema.menuVerEventos(sc);
        System.out.print("\nInserte el índice del evento para comprar o -1 para salir: ");

        try {
            int id = Integer.parseInt(sc.nextLine());
            if (id != -1) {
                Evento e = GestionSistema.getEvento(id);
                if (e != null) {
                    System.out.println(e.toString());
                    System.out.print("\n¿Desea comprar entradas? (S/N): ");
                    if (sc.nextLine().equalsIgnoreCase("S")) {

                        ArrayList<TipoEntrada> tipos = e.getTiposEntradas();

                        System.out.println("\nTipos de entrada disponibles:");
                        for (int i = 0; i < tipos.size(); i++) {
                            System.out.println(i + ". " + tipos.get(i).getNombre() +
                                    " | " + tipos.get(i).getPrecio() + "€ | Stock: " +
                                    tipos.get(i).getStockDisponible());
                        }

                        System.out.print("Seleccione tipo (índice): ");
                        int selTipo = Integer.parseInt(sc.nextLine());

                        System.out.print("¿Cuántas entradas desea?: ");
                        int cantidad = Integer.parseInt(sc.nextLine());

                        boolean exito = GestionSistema.tramitarCompra(asistente, e, selTipo, cantidad);

                        if (exito) {
                            System.out.println("✅ Compra exitosa.");
                        } else {
                            System.out.println("❌ Error: Saldo insuficiente o stock agotado.");
                        }
                    }
                } else {
                    System.out.println("Evento no encontrado.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la compra.");
        }
    }

    private static void gestionarCartera(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";

        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      " + BLANCO + "MI CARTERA" + AZUL + "       │");
        System.out.println(AZUL + " └───────────────────────┘" + RESET);
        System.out.println("Saldo actual: " + asistente.getCartera() + "€.");
        System.out.println(AZUL + "《1》" + RESET + " Añadir saldo.");
        System.out.println(AZUL + "《2》" + RESET + " Retirar saldo.");
        System.out.println(AZUL + "《-1》" + RESET + " Volver.");

        try {
            int accion = Integer.parseInt(sc.nextLine());
            if (accion == 1) {
                System.out.print("Cantidad a añadir: ");
                double cant = Double.parseDouble(sc.nextLine());
                asistente.setCartera(asistente.getCartera() + cant);
                System.out.println("✅ Saldo añadido.");
            } else if (accion == 2) {
                System.out.print("Cantidad a retirar: ");
                double cant = Double.parseDouble(sc.nextLine());
                if (asistente.getCartera() >= cant) {
                    asistente.setCartera(asistente.getCartera() - cant);
                    System.out.println("✅ Saldo retirado.");
                } else {
                    System.out.println("❌ Saldo insuficiente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Operación cancelada.");
        }
    }

    private static void invitarAmigo(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";

        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      " + BLANCO + "INVITAR AMIGOS" + AZUL + "   │");
        System.out.println(AZUL + " └───────────────────────┘" + RESET);
        System.out.println("Amigos referidos: " + asistente.getAmigos());
        System.out.print("Introduce email del amigo (o -1 para cancelar): ");
        String email = sc.nextLine();

        if (!email.equals("-1")) {
            asistente.añadirAmigo(email);
            System.out.println("✅ Amigo invitado.");
        }
    }

    private static void configurarCuenta(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        final String BLANCO = "\u001B[37m";

        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │   " + BLANCO + "CONFIGURAR CUENTA" + AZUL + "   │");
        System.out.println(AZUL + " └───────────────────────┘" + RESET);

        System.out.print("Nuevo nombre: ");
        asistente.setNombre(sc.nextLine());
        System.out.print("Nueva contraseña: ");
        asistente.setContrasenia(sc.nextLine());
        System.out.println("✅ Perfil actualizado.");
    }
}