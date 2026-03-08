package utilidades;

public class Cadenas {

    /**
     * Función que sirve para comprobar si dos contraseñas son iguales.
     * @param contrasenia1
     * @param contrasenia2
     * @return
     */


    public static boolean contraseniaSonIguales (String contrasenia1, String contrasenia2){
        return contrasenia1.equals(contrasenia2);
    }

    /**
     * Comprobar si la contraseña contiene los requisitos adecuados.
     * @param contrasenia
     * @return
     */

    public static boolean contraseniaFuerte(String contrasenia){
        if (contrasenia.length() < 8) return false;
        if (!tieneMinuscula(contrasenia)) return false;
        if (!tieneMayuscula(contrasenia)) return false;
        if (!tieneNumero(contrasenia)) return false;
        if (!tieneSimbolo(contrasenia)) return false;

        return true;
    }

    /**
     * Recorre la cadena entera y la divide en caracteres comprobando si tiene alguno
     * de lo simbolos expeciales.
     * @param cadena
     * @return
     */
    public static boolean tieneSimbolo(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (!(caracter >= 'a' && caracter <= 'z') && !(caracter >= 'A' && caracter <= 'Z') && !(caracter >= '0' && caracter <= '9')) {
                return true;
            }
        }
        return false;
    }


    /**
     * Comprueba la si la cadena proporcionada tiene minúsculas
     * @param cadena
     * @return
     */
    public static boolean tieneMinuscula(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= 'a' && caracter <= 'z') return true;
        }
        return false;
    }

    /**
     * Comprueba si la cadena proporcionada tiene mayúsculas
     * @param cadena
     * @return
     */
    public static boolean tieneMayuscula(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= 'A' && caracter <= 'Z') return true;
        }
        return false;
    }

    /**
     * Comprueba si la cadena proporcionada tiene algun número
     * @param cadena
     * @return
     */
    public static boolean tieneNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter >= '0' && caracter <= '9') return true;
        }
        return false;
    }
}
