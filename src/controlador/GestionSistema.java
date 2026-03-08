package controlador;

import modelo.*;

public class GestionSistema {
    public static Usuario[] usuarios = new Usuario[20];
    public static Evento[] eventos = new Evento[10];

    private static Administrador adminPrincipal;
    private static Organizador organizadorPrincipal;

    public static void setAdminPrincipal(Administrador administrador) { adminPrincipal = administrador; }
    public static void setOrganizadorPrincipal(Organizador organizador) { organizadorPrincipal = organizador; }

    public static Usuario autenticar(String usuario1, String contrasenia) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getNombre().equals(usuario1) && usuario.validarAcceso(contrasenia)) return usuario;
        }
        return null;
    }

    /**
     * Guarda un nuevo evento en el array.
     * @param nuevoEvento
     */

    public static void guardarEvento(Evento nuevoEvento) {
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] == null) {
                eventos[i] = nuevoEvento;
                return;
            }
        }
    }

    /**
     * Una función que sirve para listar los eventos.
     */
    public static void listarEventos() {
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(" ┌───────────────────────┐");
        System.out.println(" │      "+BLANCO+"LOS EVENTOS"+RESET+"      │");
        System.out.println(" └───────────────────────┘");
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null) System.out.println(i + ". " + eventos[i]);
        }
    }

    public static Evento getEvento(int i) {
        return (i >= 0 && i < eventos.length) ? eventos[i] : null;
    }

    public static void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            if (usuario != null) System.out.println(usuario.getId() + " - " + usuario.getNombre() + " [" + usuario.getClass().getSimpleName() + "]");
        }
    }

    public static boolean cambiarEstadoBloqueo(String id, boolean desbloqueado) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getId().equals(id)) {
                if (desbloqueado) usuario.bloquear(); else usuario.desbloquear();
                return true;
            }
        }
        return false;
    }
}
