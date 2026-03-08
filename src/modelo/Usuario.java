package modelo;

public abstract class Usuario {
    protected String nombre;
    protected String contrasenia;
    protected String id;
    protected String email;
    protected double cartera;
    protected int intentos;
    protected boolean bloqueado;

    public Usuario(String nombre, String contrasenia, String id, String email) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.email = email;
        this.cartera = 0.0;
        this.intentos = 0;
        this.bloqueado = false;
    }

    public boolean validarAcceso(String contrasenia) {
        if (this.contrasenia.equals(contrasenia)) {
            this.intentos = 0;
            return true;
        }
        this.intentos++;
        if (this.intentos >= 3) this.bloqueado = true;
        return false;
    }


    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
    public double getCartera() { return cartera; }
    public void setCartera(double cartera) { this.cartera = cartera; }
    public boolean isBloqueado() { return bloqueado; }
    public void bloquear() { this.bloqueado = true; }
    public void desbloquear() { this.bloqueado = false; this.intentos = 0; }
}