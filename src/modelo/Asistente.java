package modelo;

import java.util.ArrayList;

public class Asistente extends Usuario {
    // Cambiamos el atributo a ArrayList
    private ArrayList<Entrada> misEntradas = new ArrayList<>();

    public Asistente(String usuario, String contrasenia, String id, String email) {
        super(usuario, contrasenia, id, email);
    }

    // El método ahora devuelve la colección dinámica
    public ArrayList<Entrada> getMisEntradas() {
        return misEntradas;
    }

    public void añadirEntrada(Entrada nuevaEntrada) {
        this.misEntradas.add(nuevaEntrada);
    }

}