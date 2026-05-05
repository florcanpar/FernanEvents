package controlador;

import modelo.*;
import java.util.ArrayList;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionSistema {

    public static Usuario[] usuarios = new Usuario[20];
    public static ArrayList<Evento> eventos = new ArrayList<>();

    private static Administrador adminPrincipal;
    private static final String ARCHIVO_EVENTOS = "eventos.dat";
    private static final String ARCHIVO_LOG = "actividad.log";

    public static void setAdminPrincipal(Administrador administrador) {
        adminPrincipal = administrador;
    }

    public static Usuario autenticar(String usuario1, String contrasenia) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getNombre().equals(usuario1) && usuario.validarAcceso(contrasenia)) {
                registrarLog("Login exitoso: " + usuario1);
                return usuario;
            }
        }
        registrarLog("Intento de login fallido: " + usuario1);
        return null;
    }

    public static void guardarEvento(Evento nuevoEvento) {
        eventos.add(nuevoEvento);
        guardarDatosFisicos();
    }

    public static boolean tramitarCompra(Asistente asistente, Evento evento, int i, int cantidad) {
        TipoEntrada tipoEntrada = evento.getTiposEntradas().get(i);
        double coste = tipoEntrada.getPrecio() * cantidad;

        if (asistente.getCartera() >= coste && tipoEntrada.getStockDisponible() >= cantidad) {
            asistente.setCartera(asistente.getCartera() - coste);

            if (adminPrincipal != null) {
                adminPrincipal.setCartera(adminPrincipal.getCartera() + (coste * 0.10));
            }

            Organizador creador = buscarOrganizadorPorId(evento.getIdOrganizador());
            if (creador != null) {
                creador.setCartera(creador.getCartera() + (coste * 0.90));
            }

            tipoEntrada.registrarVenta(cantidad);
            asistente.añadirEntrada(new Entrada(evento, tipoEntrada, cantidad));

            registrarLog("COMPRA: " + asistente.getNombre() + " compró " + cantidad + " de " + evento.getNombre());
            guardarDatosFisicos();
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

    public static void listarEventos() {
        System.out.println(" ┌───────────────────────┐");
        System.out.println(" │      LOS EVENTOS      │");
        System.out.println(" └───────────────────────┘");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + ". " + eventos.get(i));
        }
    }

    public static Evento getEvento(int i) {
        if (i >= 0 && i < eventos.size()) {
            return eventos.get(i);
        }
        return null;
    }

    public static void guardarDatosFisicos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EVENTOS))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void cargarDatosFisicos() {
        File file = new File(ARCHIVO_EVENTOS);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                eventos = (ArrayList<Evento>) ois.readObject();
            } catch (Exception e) {
                System.err.println("Error al cargar datos: " + e.getMessage());
            }
        }
    }

    public static void registrarLog(String mensaje) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_LOG, true)))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            out.println("[" + dtf.format(LocalDateTime.now()) + "] " + mensaje);
        } catch (IOException e) {
            System.err.println("Error en el log: " + e.getMessage());
        }
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
                registrarLog("ESTADO: Usuario " + id + (desbloqueado ? " desbloqueado" : " bloqueado"));
                return true;
            }
        }
        return false;
    }
}