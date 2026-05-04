package modelo;

public class Administrador extends Usuario {
    private static final long serialVersionUID = 1L; // Recomendado para Serializable

    public Administrador(String nombre, String contrasenia, String id, String email) {
        super(nombre, contrasenia, id, email);
    }
}