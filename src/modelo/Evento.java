package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private LocalDateTime fecha;
    private int aforo;
    private ArrayList<TipoEntrada> tiposEntradas;
    private String idOrganizador;

    public Evento(String nombre, String descripcion, Categoria categoria, LocalDateTime fecha,
                  int aforo, ArrayList<TipoEntrada> tiposEntradas, String idOrganizador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.aforo = aforo;
        this.tiposEntradas = tiposEntradas;
        this.idOrganizador = idOrganizador;
    }

    public int getInscritosTotales() {
        int total = 0;
        if (tiposEntradas != null) {
            for (TipoEntrada tipo : tiposEntradas) {
                total += tipo.getVendidos();
            }
        }
        return total;
    }

    public void mostrarGraficoBarras() {
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        double graficoBarrasTotal = (aforo > 0) ? ((double) getInscritosTotales() / aforo) * 100 : 0;
        int porcentajeRelleno = (int) graficoBarrasTotal / 10;
        System.out.print(nombre + " [");
        for (int i = 0; i < 10; i++) {
            System.out.print(i < porcentajeRelleno ? VERDE + "▓" : BLANCO + "░" + RESET);
        }
        System.out.println("] " + String.format("%.2f", graficoBarrasTotal) + "%");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFechaYHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaFormateada = (fecha != null) ? fecha.format(formatoFechaYHora) : "Fecha no disponible";

        return nombre + ", [" + categoria + "].\nFecha y Hora: " + fechaFormateada +
                "\nInscritos: " + getInscritosTotales() + "/" + aforo;
    }

    public ArrayList<TipoEntrada> getTiposEntradas() {
        return tiposEntradas;
    }

    public void setTiposEntradas(ArrayList<TipoEntrada> tiposEntradas) {
        this.tiposEntradas = tiposEntradas;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public LocalDateTime getFecha() { return fecha; }

    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public int getAforo() { return aforo; }

    public void setAforo(int aforo) { this.aforo = aforo; }

    public String getIdOrganizador() { return idOrganizador; }

    public void setIdOrganizador(String idOrganizador) { this.idOrganizador = idOrganizador; }
}