package modelo;
import utilidades.Aumentable;

public class Entrada implements Aumentable {
    private Evento evento;
    private TipoEntrada tipo;
    private int cantidad;

    public Entrada(Evento evento, TipoEntrada tipoEntrada, int cantidad) {
        this.evento = evento;
        this.tipo = tipoEntrada;
        this.cantidad = cantidad;
    }

    @Override
    public void aumentaCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    @Override
    public void disminuyeCantidad(int cantidad) {
        if (this.cantidad - cantidad >= 0) {
            this.cantidad -= cantidad;
        }
    }

    public int getCantidad() { return cantidad; }
    public TipoEntrada getTipo() { return tipo; }
}
