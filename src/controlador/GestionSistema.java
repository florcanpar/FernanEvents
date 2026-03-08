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

    public static void guardarEvento(Evento nuevoEvento) {
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] == null) {
                eventos[i] = nuevoEvento;
                return;
            }
        }
    }

    public static boolean tramitarCompra(Asistente asistente, Evento evento, int i, int cantidad) {
        TipoEntrada tipoEntrada = evento.getTiposEntradas()[i];
        double coste = tipoEntrada.getPrecio() * cantidad;

        if (asistente.getCartera() >= coste && tipoEntrada.getStockDisponible() >= cantidad) {
            asistente.setCartera(asistente.getCartera() - coste);
            if (adminPrincipal != null) adminPrincipal.setCartera(adminPrincipal.getCartera() + (coste * 0.1));
            if (organizadorPrincipal != null) organizadorPrincipal.setCartera(organizadorPrincipal.getCartera() + (coste * 0.9));

            tipoEntrada.registrarVenta(cantidad);
            return true;
        }
        return false;
    }

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
