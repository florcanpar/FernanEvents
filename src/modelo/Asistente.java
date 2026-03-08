package modelo;

public class Asistente extends Usuario {
    private String amigos = "";

    public Asistente(String usuario, String contrasenia, String id, String email) {
        super(usuario, contrasenia, id, email);
    }

    public String getAmigos() {
        if (amigos.equals("")) return "No ha añadido ningún amigo aún.";
        return amigos;
    }

    public void setAmigos(String amigos) {
        this.amigos = amigos;
    }

    public void añadirAmigo(String emailAmigo) {
        this.amigos += emailAmigo + ", ";
    }
}
