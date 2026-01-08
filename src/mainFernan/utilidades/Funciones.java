package mainFernan.utilidades;

import java.util.Scanner;

public class Funciones {

    public static void logoFernan(){
        final String CYAN = "\u001B[36m";
        final String RESET_COLOR = "\u001B[0m";
        final String AZUL = "\u001B[34m";
        System.out.println(AZUL + """
                          :   :   :   :   :     \s
                       ***:***:***:***:***:***  \s
                       ***********************  \s
                    
                         :: ::  :: :: .:: ::    \s
                    
                         ::  :  :: ==  :  ::    \s
                         :: ::. :: :: .:: ::    \s
                             .         .        \s
                         ::  :  :. .:  :  ::    \s
                       :                     :  \s
                       
                    """ + RESET_COLOR);
        System.out.println(CYAN + """
                       ______                         \s
                       |  ___|                        \s
                       | |_ ___ _ __ _ __   __ _ _ __ \s
                       |  _/ _ \\ '__| '_ \\ / _` | '_ \\\s
                       | ||  __/ |  | | | | (_| | | | |
                       \\_| \\___|_|  |_| |_|\\__,_|_| |_|
                    """ + RESET_COLOR);
        System.out.println(CYAN + """
                        _____                _      \s
                       |  ___|              | |     \s
                       | |____   _____ _ __ | |_ ___\s
                       |  __\\ \\ / / _ \\ '_ \\| __/ __|
                       | |___\\ V /  __/ | | | |_\\__ \\
                       \\____/ \\_/ \\___|_| |_|\\__|___/
                    
                    """ + RESET_COLOR);
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Salir");
    }

    public static void menuAsistente(){
        final String MORADO = "\u001B[35m";
        final String RESET_COLOR = "\u001B[0m";

        System.out.println(MORADO + "----Menú Asistente----" + RESET_COLOR);
        System.out.println("1. Mis Eventos.");
        System.out.println("2. Eventos.");
        System.out.println("3. Cartera Digital.");
        System.out.println("4. Invita a un amigo");
        System.out.println("5. Configuración.");
        System.out.println("6. Cerrar Sesión");
    }

    public static void menuOrganizador(){
        final String AZUL = "\u001B[34m";
        final String RESET_COLOR = "\u001B[0m";

        System.out.println(AZUL + "----Menú Organizador----" + RESET_COLOR);
        System.out.println("1. Mis Eventos.");
        System.out.println("2. Cartera Digital.");
        System.out.println("3. Configuración.");
        System.out.println("4. Cerrar Sesión");
    }

    public static void menuOrganizadorEventos(){
        System.out.println("Bienvenido a tus eventos");
        System.out.println("1. Ver eventos.");
        System.out.println("2. Crear eventos.");
        System.out.println("3. Editar eventos.");
        System.out.println("4. Eliminar eventos.");
        System.out.println("5. Salir.");
    }

    public static void menuAdministrador(){
        final String VERDE = "\u001B[32m";
        final String RESET_COLOR = "\u001B[0m";

        System.out.println(VERDE + "----Menú Administrador----" + RESET_COLOR);
        System.out.println("1. Panel de control.");
        System.out.println("2. Eventos.");
        System.out.println("3. Cartera Digital.");
        System.out.println("4. Configuración.");
        System.out.println("5. Cerrar Sesión");
    }


    //ESTO ES DEL LOGIN
    public static int iniciarSesion(String[][] usuarios, Scanner sc) {

        System.out.print("Usuario: ");
        String nombreUsuario = sc.nextLine().toLowerCase();

        System.out.print("Contraseña: ");
        String contrasenia = sc.nextLine();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] != null && usuarios[i][0].equals(nombreUsuario)) {
                if (usuarios[i][1].equals(contrasenia)) {
                    System.out.println("Inicio de sesión correcto");
                    return i;
                } else {
                    System.out.println("Contraseña incorrecta");
                    return -1;
                }
            }
        }

        System.out.println("El usuario no existe");
        return -1;
    }

    public static void crearUsuario(String[][] usuarios, Scanner sc){

        int posicionLibre = -1;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] != null){
                posicionLibre = i;
                break;
            }
        }

        if (posicionLibre == -1){
            System.out.println("No se pueden crear más usuarios.");
            return;
        }

        System.out.print("Nuevo usuario = ");
        String nombreUsuario = sc.nextLine().toLowerCase();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] != null && usuarios[i][0].equals(nombreUsuario)){
                System.out.println("Ese usuario ya existe");
                return;
            }
        }

        System.out.print("Contraseña: ");
        String contraseniaUsuario = sc.nextLine();

        System.out.print("Repite contraseña: ");
        String contraseniaUsuarioRepetida = sc.nextLine();

        if (!Cadenas.contraseniaSonIguales(contraseniaUsuario, contraseniaUsuarioRepetida)){
            System.out.println("Las contraseñas no coinciden.");
            return;
        }

        if (!Cadenas.contraseniaFuerte(contraseniaUsuario)){
            System.out.println("La contrasenia es debil");
            return;
        }

        String tipoDeUsuario;

        do {
            System.out.print("Tipo de usuario ASISTENTE/GESTOR: ");
            tipoDeUsuario = sc.nextLine().toUpperCase();

            if (!tipoDeUsuario.equals("ASISTENTE") && !tipoDeUsuario.equals("GESTOR")){
                System.out.println("El rol que haselegido es inválido");
            }
        }while (!tipoDeUsuario.equals("ASISTENTE") && !tipoDeUsuario.equals("GESTOR"));

    }

}
