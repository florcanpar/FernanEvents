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
            System.out.println(VERDE +"《1》" + RESET + " Panel de Control");
            System.out.println(VERDE +"《2》" + RESET + " Eventos");
            System.out.println(VERDE +"《3》" + RESET + " Cartera digital");
            System.out.println(VERDE +"《4》" + RESET + " Configuración");
            System.out.println(VERDE +"《5》" + RESET + " Cerrar sesión");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> gestionarBloqueos(sc);
                case 2 -> GestionSistema.listarEventos();
                case 3 -> System.out.println("Comisiones (10%): " + admin.getCartera() + "€");
                case 4 -> {
                    System.out.print("Inserte su nuevo usuario: "); admin.setNombre(sc.nextLine());
                    System.out.print("Inserte su nueva contraseña: "); admin.setContrasenia(sc.nextLine());
                }
            }
        }
    }

    private static void gestionarBloqueos(Scanner sc) {
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(VERDE + " ┌───────────────────────┐");
        System.out.println(VERDE + " │   "+BLANCO+"PANEL DE CONTROL"+VERDE+"    │");
        System.out.println(VERDE + " └───────────────────────┘"+RESET);
        GestionSistema.listarUsuarios();
        System.out.print("Inserte el ID del usuario que quiera bloquear o desbloquear: ");
        String idUsuario = sc.nextLine();
        System.out.println(VERDE +"《1》" + RESET + " Bloquear.");
        System.out.println(VERDE +"《2》" + RESET + " Desbloquear.");
        int opcion = Integer.parseInt(sc.nextLine());
        GestionSistema.cambiarEstadoBloqueo(idUsuario, (opcion == 1));
    }
}