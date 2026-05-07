package controlador;

import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionSistema {

    private static HashMap<String, Usuario> usuarios = new HashMap<>();
    public static ArrayList<Evento> eventos = new ArrayList<>();

    private static Administrador adminPrincipal;
    private static final String ARCHIVO_EVENTOS = "eventos.dat";
    private static final String ARCHIVO_LOG = "actividad.log";

    public static void setAdminPrincipal(Administrador administrador) {
        adminPrincipal = administrador;
        añadirUsuario(administrador);
    }

    public static void añadirUsuario(Usuario u) {
        usuarios.put(u.getId(), u);
    }

    public static void eliminarUsuario(String id) {
        usuarios.remove(id);
    }

    public static Usuario buscarUsuarioPorId(String id) {
        return usuarios.get(id);
    }

    public static Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getNombre().equals(nombre)) return usuario;
        }
        return null;
    }

    public static Usuario autenticar(String nombre, String contrasenia) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null && usuario.validarAcceso(contrasenia)) {
            registrarLog("Login exitoso: " + nombre);
            return usuario;
        }
        registrarLog("Intento de login fallido: " + nombre);
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
            if (adminPrincipal != null) adminPrincipal.setCartera(adminPrincipal.getCartera() + (coste * 0.10));

            Usuario creador = buscarUsuarioPorId(evento.getIdOrganizador());
            if (creador instanceof Organizador) {
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

    public static void listarEventos() {
        System.out.println(" ┌───────────────────────┐");
        System.out.println(" │      LOS EVENTOS      │");
        System.out.println(" └───────────────────────┘");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + ". " + eventos.get(i));
        }
    }

    public static Evento getEvento(int i) {
        return (i >= 0 && i < eventos.size()) ? eventos.get(i) : null;
    }

    public static void guardarDatosFisicos() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EVENTOS))) {
            objectOutputStream.writeObject(eventos);
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
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(ARCHIVO_LOG, true)))) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            printWriter.println("[" + dateTimeFormatter.format(LocalDateTime.now()) + "] " + mensaje);
        } catch (IOException e) {
            System.err.println("Error en el log: " + e.getMessage());
        }
    }

    public static void listarUsuarios() {
        for (Usuario u : usuarios.values()) {
            System.out.println(u.toString());
        }
    }

    public static boolean cambiarEstadoBloqueo(String id, boolean desbloqueado) {
        Usuario u = buscarUsuarioPorId(id);
        if (u != null) {
            if (desbloqueado) u.desbloquear();
            else u.bloquear();
            registrarLog("ESTADO: Usuario " + id + (desbloqueado ? " desbloqueado" : " bloqueado"));
            return true;
        }
        return false;
    }
}