package vista;

import controlador.GestionSistema;
import modelo.*;
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
            System.out.println("  " + AMARILLO + "《" + BLANCO + " MENÚ ASISTENTE " + AMARILLO + "》");
            System.out.println(AZUL + "╰───────────── " + AMARILLO + "◈" + AZUL + " ─────────────╯" + RESET);
            System.out.println(AZUL +"《1》" + RESET + " Mis eventos");
            System.out.println(AZUL +"《2》" + RESET + " Ver todos los Eventos");
            System.out.println(AZUL +"《3》" + RESET + " Cartera digital");
            System.out.println(AZUL +"《4》" + RESET + " Invita a un amigo");
            System.out.println(AZUL +"《5》" + RESET + " Configuración");
            System.out.println(AZUL +"《6》" + RESET + " Cerrar sesión");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) mostrarMisEventos(asistente, sc);
            else if (opcion == 2) mostrarEventosPlataforma(asistente, sc);
            else if (opcion == 3) gestionarCartera(asistente, sc);
            else if (opcion == 4) invitarAmigo(asistente, sc);
            else if (opcion == 5) configurarCuenta(asistente, sc);
        }
    }

    private static void mostrarMisEventos(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      "+BLANCO+"MIS EVENTOS"+AZUL+"      │");
        System.out.println(AZUL + " └───────────────────────┘"+RESET);
        System.out.println("Listado de eventos inscritos.");
    }

    private static void mostrarEventosPlataforma(Asistente asistente, Scanner sc) {
        final String AZUL = "\u001B[34m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(AZUL + " ┌───────────────────────┐");
        System.out.println(AZUL + " │      "+BLANCO+"LOS EVENTOS"+AZUL+"      │");
        System.out.println(AZUL + " └───────────────────────┘"+RESET);
        System.out.println("Todos los eventos creados.");
        GestionSistema.listarEventos();
        System.out.print("Inserte la ID del evento para ver detalles o -1 para salir: ");
        int id = Integer.parseInt(sc.nextLine());
        if (id != -1) {
            Evento e = GestionSistema.getEvento(id);
            System.out.println(e.toString());
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
}
