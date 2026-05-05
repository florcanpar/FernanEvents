package vista;
import controlador.GestionSistema;
import modelo.*;
import java.util.Scanner;

public class VistaAdmin {
    public static void menu(Administrador admin, Scanner sc) {
        final String VERDE = "\u001B[32m";
        final String AMARILLO = "\u001B[33m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";

        int opcion = 0;
        while (opcion != 5) {
            System.out.println(VERDE + "╭───────────── " + AMARILLO + "◈" + VERDE + " ─────────────╮");
            System.out.println("  " + AMARILLO + "《" + BLANCO + " PANEL DE ADMINISTRADOR " + AMARILLO + "》");
            System.out.println(VERDE + "╰───────────── " + AMARILLO + "◈" + VERDE + " ─────────────╯" + RESET);
            System.out.println(VERDE +"《1》" + RESET + " Panel de Control (Usuarios)");
            System.out.println(VERDE +"《2》" + RESET + " Ver Eventos");
            System.out.println(VERDE +"《3》" + RESET + " Cartera digital");
            System.out.println(VERDE +"《4》" + RESET + " Configuración");
            System.out.println(VERDE +"《5》" + RESET + " Cerrar sesión");
            System.out.print("Seleccione: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> gestionarBloqueos(sc);
                    case 2 -> GestionSistema.listarEventos();
                    case 3 -> System.out.println("Comisiones (10%): " + admin.getCartera() + "€");
                    case 4 -> {
                        System.out.print("Nuevo usuario: "); admin.setNombre(sc.nextLine());
                        System.out.print("Nueva contraseña: "); admin.setContrasenia(sc.nextLine());
                    }
                }
            } catch (Exception e) { opcion = 0; }
        }
    }

    private static void gestionarBloqueos(Scanner sc) {
        GestionSistema.listarUsuarios();
        System.out.print("ID del usuario para bloquear/desbloquear: ");
        String id = sc.nextLine();
        System.out.println("1. Bloquear | 2. Desbloquear");
        int op = Integer.parseInt(sc.nextLine());
        GestionSistema.cambiarEstadoBloqueo(id, (op == 1));
    }
}