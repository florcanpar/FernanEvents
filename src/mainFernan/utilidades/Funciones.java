package mainFernan.utilidades;

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



}
