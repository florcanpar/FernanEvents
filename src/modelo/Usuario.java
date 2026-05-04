package modelo;

import utilidades.Bloqueable;
import java.io.Serializable;

public abstract class Usuario implements Bloqueable, Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String contrasenia;
    private String id;
    private String email;
    private double cartera;
    private int intentos;
    private boolean bloqueado;

    public Usuario(String nombre, String contrasenia, String id, String email) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.email = email;
        this.cartera = 0.0;
        this.intentos = 0;
        this.bloqueado = false;
    }

    public boolean validarAcceso(String password) {
        if (this.bloqueado) return false;

        if (this.contrasenia.equals(password)) {
            this.intentos = 0;
            return true;
        } else {
            this.intentos++;
            if (this.intentos >= 3) {
                bloquear();
            }
            return false;
        }
    }

    @Override
    public void bloquear() {
        this.bloqueado = true;
    }

    @Override
    public void desbloquear() {
        this.bloqueado = false;
        this.intentos = 0;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getCartera() { return cartera; }

    public void setCartera(double cartera) {
        if (cartera >= 0) {
            this.cartera = cartera;
        }
    }

    public int getIntentos() { return intentos; }

    public boolean isBloqueado() { return bloqueado; }

    @Override
    public String toString() {
        String estado = bloqueado ? " [BLOQUEADO]" : "";
        return "ID: " + id + " | Nombre: " + nombre + " | Email: " + email + " | Saldo: " + cartera + "€" + estado;
    }
}