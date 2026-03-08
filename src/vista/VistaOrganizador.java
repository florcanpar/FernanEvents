package vista;

import controlador.GestionSistema;
import modelo.*;
import java.util.Scanner;

public class VistaOrganizador {
    public static void menu(Organizador organizador, Scanner sc) {
        final String MORADO = "\u001B[35m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        final String AMARILLO = "\u001B[33m";
        int opcion = 0;
        while (opcion != 5) {
            System.out.println(MORADO + "╭───────────── " + AMARILLO + "◈" + MORADO + " ─────────────╮");
            System.out.println("     " + AMARILLO + "《" + BLANCO + " MENÚ ORGANIZADOR " + AMARILLO + "》");
            System.out.println(MORADO + "╰───────────── " + AMARILLO + "◈" + MORADO + " ─────────────╯" + RESET);
            System.out.println("Bienvenid@, " + MORADO + organizador.getNombre() + RESET + ".");
            System.out.println("Saldo: " + organizador.getCartera() + "€");
            System.out.println(MORADO +"《1》" + RESET + " Crear nuevo evento");
            System.out.println(MORADO +"《2》" + RESET + " Mis eventos");
            System.out.println(MORADO +"《3》" + RESET + " Cartera Digital");
            System.out.println(MORADO +"《4》" + RESET + " Configuración");
            System.out.println(MORADO +"《5》" + RESET + " Salir");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) VistaEvento.crearEvento(organizador, sc);
            else if (opcion == 2) gestionarMisEventos(organizador, sc);
            else if (opcion == 3) System.out.println("Comisiones 90%: " + organizador.getCartera() + "€");
            else if (opcion == 4) {

                System.out.print("Inserte nuevo usuario: "); organizador.setNombre(sc.nextLine());
                System.out.print("Inserte nueva contraseña: "); organizador.setContrasenia(sc.nextLine());
            }
        }
    }

    private static void gestionarMisEventos(Organizador organizador, Scanner sc) {
        final String MORADO = "\u001B[35m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(MORADO + " ┌───────────────────────┐");
        System.out.println(MORADO + " │      "+BLANCO+"MIS EVENTOS"+MORADO+"      │");
        System.out.println(MORADO + " └───────────────────────┘"+RESET);
        System.out.println("Listado de eventos creados.");
        GestionSistema.listarEventos();
        System.out.print("ID del evento (o -1): ");
        int id = Integer.parseInt(sc.nextLine());
        Evento evento = GestionSistema.getEvento(id);
        if (evento != null && evento.getIdOrganizador().equals(organizador.getId())) {
            evento.mostrarGraficoBarras();
            System.out.println(MORADO +"《1》" + RESET + "Modificar.");
            System.out.println(MORADO +"《2》" + RESET + "Volver.");
            if (sc.nextLine().equals("1")) VistaEvento.modificarEvento(evento, sc);
        }
    }
}
