package mainFernan.utilidades;

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

    public static boolean tieneSimbolo(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '0' && c <= '9')) {
                return true;
            }
        }
        return false;
    }
    public static boolean tieneMinuscula(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') return true;
        }
        return false;
    }

    public static boolean tieneMayuscula(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') return true;
        }
        return false;
    }

    public static boolean tieneNumero(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') return true;
        }
        return false;
    }
}
