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

    public static boolean tieneMinuscula(String contrasenia){
        for (int i = 0; i < contrasenia.length(); i++)
            if (contrasenia.charAt(i) >= 'a' && contrasenia.charAt(i) <= 'z')
                return true;
        return false;
    }

    public static boolean tieneMayuscula(String contrasenia){
        for (int i = 0; i < contrasenia.length(); i++)
            if (contrasenia.charAt(i) >= 'A' && contrasenia.charAt(i) <= 'Z')
                return true;
        return false;
    }

    public static boolean tieneNumero(String contrasenia){
        for (int i = 0; i < contrasenia.length(); i++)
            if (contrasenia.charAt(i) >= 1 && contrasenia.charAt(i) <= 9)
                return true;
        return false;
    }

    public static boolean tieneSimbolo(String contrasenia){
        for (int i = 0; i < contrasenia.length(); i++)
            if (contrasenia.charAt(i) == ',' || contrasenia.charAt(i) == '.' || contrasenia.charAt(i) == '@' ||
                    contrasenia.charAt(i) == '-' || contrasenia.charAt(i) == '_' || contrasenia.charAt(i) == '*' ||
                    contrasenia.charAt(i) == '+' || contrasenia.charAt(i) == '/')
                return true;
        return false;
    }

}
