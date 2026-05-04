package controlador;

import modelo.*;
import java.util.ArrayList; // Importación necesaria para ArrayList

public class GestionSistema {
    // CAMBIO TEMA 7: De arrays fijos a ArrayList dinámico
    public static Usuario[] usuarios = new Usuario[20]; // Este lo cambiaremos a HashMap más adelante
    public static ArrayList<Evento> eventos = new ArrayList<>(); // Ahora es dinámico

    private static Administrador adminPrincipal;
    private static Organizador organizadorPrincipal;

    public static void setAdminPrincipal(Administrador administrador) {
        adminPrincipal = administrador;
    }

    public static void setOrganizadorPrincipal(Organizador organizador) {
        organizadorPrincipal = organizador;
    }

    public static Usuario autenticar(String usuario1, String contrasenia) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getNombre().equals(usuario1) && usuario.validarAcceso(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

    // REFACTORIZADO: Ya no necesitamos buscar huecos, solo añadir[cite: 1]
    public static void guardarEvento(Evento nuevoEvento) {
        eventos.add(nuevoEvento);
    }

    public static boolean tramitarCompra(Asistente asistente, Evento evento, int i, int cantidad) {
        // Accedemos al ArrayList de tipos de entrada del evento[cite: 1]
        TipoEntrada tipoEntrada = evento.getTiposEntradas().get(i);
        double coste = tipoEntrada.getPrecio() * cantidad;

        if (asistente.getCartera() >= coste && tipoEntrada.getStockDisponible() >= cantidad) {
            asistente.setCartera(asistente.getCartera() - coste);

            if (adminPrincipal != null) {
                double comisionAdmin = coste * 0.10;
                adminPrincipal.setCartera(adminPrincipal.getCartera() + comisionAdmin);
            }

            Organizador creador = buscarOrganizadorPorId(evento.getIdOrganizador());
            if (creador != null) {
                double pagoOrganizador = coste * 0.90;
                creador.setCartera(creador.getCartera() + pagoOrganizador);
            }

            tipoEntrada.registrarVenta(cantidad);
            Entrada nuevaEntrada = new Entrada(evento, tipoEntrada, cantidad);
            asistente.añadirEntrada(nuevaEntrada);

            return true;
        }
        return false;
    }

    private static Organizador buscarOrganizadorPorId(String id) {
        for (Usuario u : usuarios) {
            if (u instanceof Organizador && u.getId().equals(id)) {
                return (Organizador) u;
            }
        }
        return null;
    }

    // REFACTORIZADO: Uso de for-each para el ArrayList[cite: 1]
    public static void listarEventos() {
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        System.out.println(" ┌───────────────────────┐");
        System.out.println(" │      "+BLANCO+"LOS EVENTOS"+RESET+"      │");
        System.out.println(" └───────────────────────┘");

        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + ". " + eventos.get(i));
        }
    }

    // REFACTORIZADO: Uso de .get() en lugar de corchetes[cite: 1]
    public static Evento getEvento(int i) {
        if (i >= 0 && i < eventos.size()) {
            return eventos.get(i);
        }
        return null;
    }

    public static void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                System.out.println(usuario.getId() + " - " + usuario.getNombre() +
                        " [" + usuario.getClass().getSimpleName() + "]");
            }
        }
    }

    public static boolean cambiarEstadoBloqueo(String id, boolean desbloqueado) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getId().equals(id)) {
                if (desbloqueado) usuario.desbloquear(); else usuario.bloquear();
                return true;
            }
        }
        return false;
    }
}