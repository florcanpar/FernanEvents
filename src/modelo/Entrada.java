package modelo;
import utilidades.Aumentable;

public class Entrada implements Aumentable {
    private Evento evento;
    private TipoEntrada tipo;
    private int cantidad;

    public Entrada(Evento evento, TipoEntrada tipo, int cantidad) {
        this.evento = evento;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Implementación de la interfaz Aumentable
    @Override
    public double getPrecioTotal() {
        return tipo.getPrecio() * cantidad;
    }

    public Evento getEvento() {
        return evento;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Ticket para: " + evento.getNombre() +
                " | Tipo: " + tipo.getNombre() +
                " | Cantidad: " + cantidad +
                " | Total: " + getPrecioTotal() + "€";
    }

    @Override
    public void aumentaCantidad(int cantidad) {

    }

    @Override
    public void disminuyeCantidad(int cantidad) {

    }
}