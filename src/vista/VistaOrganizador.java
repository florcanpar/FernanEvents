package vista;

import controlador.GestionSistema;
import modelo.*;

import java.util.Scanner;

public class VistaOrganizador {

    public static void menu(Organizador organizador, Scanner sc) {
        final String MORADO = "\u001B[35m";
        final String AMARILLO = "\u001B[33m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";

        int opcion = 0;
        while (opcion != 5) {
            System.out.println(MORADO + "╭───────────── " + AMARILLO + "◈" + MORADO + " ─────────────╮");
            System.out.println("  " + AMARILLO + "《" + BLANCO + "  MENÚ ORGANIZADOR  " + AMARILLO + "》");
            System.out.println(MORADO + "╰───────────── " + AMARILLO + "◈" + MORADO + " ─────────────╯" + RESET);
            System.out.println("Bienvenid@, " + MORADO + organizador.getNombre() + RESET + ".");
            System.out.println("Saldo: " + organizador.getCartera() + "€");
            System.out.println(MORADO + "《1》" + RESET + " Crear nuevo evento");
            System.out.println(MORADO + "《2》" + RESET + " Mis eventos");
            System.out.println(MORADO + "《3》" + RESET + " Retirar dinero");
            System.out.println(MORADO + "《4》" + RESET + " Configuración");
            System.out.println(MORADO + "《5》" + RESET + " Cerrar sesión");
            System.out.print("Seleccione: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> VistaEvento.crearEvento(organizador);
                    case 2 -> gestionarMisEventos(organizador, sc);
                    case 3 -> gestionarRetiro(organizador, sc);
                    case 4 -> configurarCuenta(organizador, sc);
                    case -1 -> System.out.println("Cerrando sesión...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Inserte un número válido.");
                opcion = 0;
            }
        }
    }

    private static void gestionarMisEventos(Organizador organizador, Scanner sc) {
        final String MORADO = "\u001B[35m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";

        System.out.println(MORADO + " ┌───────────────────────┐");
        System.out.println(MORADO + " │      " + BLANCO + "MIS EVENTOS" + MORADO + "      │");
        System.out.println(MORADO + " └───────────────────────┘" + RESET);

        GestionSistema.listarEventos();
        System.out.print("ID del evento para gestionar (o -1 para volver): ");

        try {
            int id = Integer.parseInt(sc.nextLine());
            if (id != -1) {
                Evento evento = GestionSistema.getEvento(id);
                if (evento != null && evento.getIdOrganizador().equals(organizador.getId())) {
                    evento.mostrarGraficoBarras();
                    System.out.println(MORADO + "《1》" + RESET + " Modificar.");
                    System.out.println(MORADO + "《-1》" + RESET + " Volver.");
                    if (sc.nextLine().equals("1")) {
                        VistaEvento.modificarEvento(evento);
                    }
                } else {
                    System.out.println("Evento no encontrado o no tiene permisos.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la selección.");
        }
    }

    private static void gestionarRetiro(Organizador organizador, Scanner sc) {
        System.out.println("\nSaldo disponible: " + organizador.getCartera() + "€");
        System.out.print("Cantidad a retirar (o -1 para cancelar): ");
        try {
            double cant = Double.parseDouble(sc.nextLine());
            if (cant > 0 && cant <= organizador.getCartera()) {
                organizador.setCartera(organizador.getCartera() - cant);
                System.out.println("✅ Retiro realizado correctamente.");
            } else if (cant != -1) {
                System.out.println("❌ Cantidad no válida o saldo insuficiente.");
            }
        } catch (Exception e) {
            System.out.println("Operación cancelada.");
        }
    }

    private static void configurarCuenta(Organizador organizador, Scanner sc) {
        final String MORADO = "\u001B[35m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";

        System.out.println(MORADO + " ┌───────────────────────┐");
        System.out.println(MORADO + " │   " + BLANCO + "CONFIGURAR CUENTA" + MORADO + "   │");
        System.out.println(MORADO + " └───────────────────────┘" + RESET);

        System.out.print("Nuevo nombre de usuario: ");
        organizador.setNombre(sc.nextLine());
        System.out.print("Nueva contraseña: ");
        organizador.setContrasenia(sc.nextLine());
        System.out.println("✅ Datos actualizados.");
    }
}