package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String nombre, descripcion;
    private Categoria categoria;
    private LocalDateTime fecha;
    private int aforo;
    private TipoEntrada[] tiposEntradas;
    private String idOrganizador;

    public Evento(String nombre, String descripcion, Categoria categoria, LocalDateTime fecha,
                  int aforo, TipoEntrada[] tipoEntradas, String idOrganizador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.aforo = aforo;
        this.tiposEntradas = tipoEntradas;
        this.idOrganizador = idOrganizador;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setAforo(int aforo) { this.aforo = aforo; }
    public String getIdOrganizador() { return idOrganizador; }
    public TipoEntrada[] getTiposEntradas() { return tiposEntradas; }

    public int getInscritosTotales() {
        int total = 0;
        for (TipoEntrada tipoEntrada : tiposEntradas) {
            if (tipoEntrada != null) total += tipoEntrada.getVendidos();
        }
        return total;
    }

    public void mostrarGraficoBarras() {
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        final String RESET = "\u001B[0m";
        double graficoBarrasTotal= (aforo > 0) ? ((double) getInscritosTotales() / aforo) * 100 : 0;
        int porcentajeRelleno = (int) graficoBarrasTotal / 10;
        System.out.print(nombre + " [");
        for (int i = 0; i < 10; i++) {
            System.out.print(i < porcentajeRelleno ? VERDE+"▓" : BLANCO+"░"+RESET);
        }
        System.out.println("] " + String.format("%.2f", graficoBarrasTotal) + "%");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFechaYHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return nombre + ", [" + categoria + "].\nFecha y Hora:" + fecha.format(formatoFechaYHora) + "\nInscritos: " + getInscritosTotales() + "/" + aforo;
    }
}
