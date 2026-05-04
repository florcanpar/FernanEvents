package utilidades;

public class Cadenas {

    public static boolean contraseniaSonIguales (String contrasenia1, String contrasenia2){
        return contrasenia1.equals(contrasenia2);
    }

    public static boolean contraseniaFuerte(String contrasenia){
        if (contrasenia.length() < 8) return false;
        if (!tieneMinuscula(contrasenia)) return false;
        if (!tieneMayuscula(contrasenia)) return false;
        if (!tieneNumero(contrasenia)) return false;
        if (!tieneSimbolo(contrasenia)) return false;

        return true;
    }

    public static boolean tieneSimbolo(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (!(caracter >= 'a' && caracter <= 'z') && !(caracter >= 'A' && caracter <= 'Z') && !(caracter >= '0' && caracter <= '9')) {
                return true;
            }
        }
        return false;
    }
    public static boolean tieneMinuscula(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= 'a' && caracter <= 'z') return true;
        }
        return false;
    }

    public static boolean tieneMayuscula(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= 'A' && caracter <= 'Z') return true;
        }
        return false;
    }

    public static boolean tieneNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= '0' && caracter <= '9') return true;
        }
        return false;
    }
}
