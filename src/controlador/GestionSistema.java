package controlador;

import modelo.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

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
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos disponibles.");
        } else {
            for (Evento e : eventos) {
                System.out.println(e.toString());
            }
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

    public static void menuVerEventos(Scanner sc) {
        System.out.println("\n--- OPCIONES DE VISUALIZACIÓN ---");
        System.out.println("1. Ordenar por Fecha");
        System.out.println("2. Ordenar por Categoría");
        System.out.println("3. Ordenar por Número de Asistentes");
        System.out.println("4. Ordenar por Importe (precio mínimo)");
        System.out.println("5. Ver sin orden específico");
        System.out.print("Seleccione una opción: ");

        int opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1 -> ordenarPorFecha();
            case 2 -> ordenarPorCategoria();
            case 3 -> ordenarPorAsistentes();
            case 4 -> ordenarPorImporte();
            default -> {
            }
        }
        listarEventos(); // Método que ya tienes para mostrar la lista
    }

    public static void ordenarPorFecha() {
        Collections.sort(eventos, Comparator.comparing(Evento::getFecha));
    }

    public static void ordenarPorCategoria() {
        Collections.sort(eventos, Comparator.comparing(e -> e.getCategoria().toString()));
    }

    public static void ordenarPorAsistentes() {
        Collections.sort(eventos, (e1, e2) -> Integer.compare(e2.getInscritosTotales(), e1.getInscritosTotales()));
    }

    public static void ordenarPorImporte() {
        Collections.sort(eventos, (e1, e2) -> {
            double p1 = e1.getTiposEntradas().isEmpty() ? 0 : e1.getTiposEntradas().get(0).getPrecio();
            double p2 = e2.getTiposEntradas().isEmpty() ? 0 : e2.getTiposEntradas().get(0).getPrecio();
            return Double.compare(p1, p2);
        });
    }
}