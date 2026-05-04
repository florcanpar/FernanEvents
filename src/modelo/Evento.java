package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Evento {
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
        for (TipoEntrada tipo : tiposEntradas) {
            total += tipo.getVendidos();
        }
        return total;
    }

    public ArrayList<TipoEntrada> getTiposEntradas() {
        return tiposEntradas;
    }

    public void setTiposEntradas(ArrayList<TipoEntrada> tiposEntradas) {
        this.tiposEntradas = tiposEntradas;
    }

    public String getNombre() { return nombre; }
    public String getIdOrganizador() { return idOrganizador; }


    @Override
    public String toString() {
        DateTimeFormatter formatoFechaYHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return nombre + ", [" + categoria + "].\nFecha y Hora:" + fecha.format(formatoFechaYHora) + "\nInscritos: " + getInscritosTotales() + "/" + aforo;
    }
}
