package modelo;

import java.util.ArrayList;

public class Asistente extends Usuario {
    private static final long serialVersionUID = 1L;

    private String amigos = "";

    private ArrayList<Entrada> misEntradas;

    public Asistente(String usuario, String contrasenia, String id, String email) {
        super(usuario, contrasenia, id, email);
        this.misEntradas = new ArrayList<>();
    }

    public void añadirEntrada(Entrada nuevaEntrada) {
        this.misEntradas.add(nuevaEntrada);
    }

    public ArrayList<Entrada> getMisEntradas() {
        return misEntradas;
    }

    public int getContadorEntradas() {
        return misEntradas.size();
    }

    public String getAmigos() {
        return (amigos.isEmpty()) ? "No ha añadido ningún amigo aún." : amigos;
    }

    public void setAmigos(String amigos) {
        this.amigos = amigos;
    }

    public void añadirAmigo(String emailAmigo) {
        if (this.amigos.isEmpty()) {
            this.amigos = emailAmigo;
        } else {
            this.amigos += ", " + emailAmigo;
        }
    }
}