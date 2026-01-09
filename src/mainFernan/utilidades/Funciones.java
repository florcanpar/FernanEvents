package mainFernan.utilidades;

import java.sql.SQLOutput;
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

    /**
     * Esta función recorre los eventos creados por el organizador y muestra sus nombres para que
     * el organizador pueda elegir cuál quiere ver.
     * @param evento
     * @param usuario
     * @param fila
     */

    public static void verEventosCreadosOrganizador(String[][] evento, String[][] usuario, int fila) {
        int contador = 0;
        System.out.println("¿Qué proyecto quiere ver?");
        for (int i = 0; i < evento.length; i++) {
            for (int j = 0; j < evento[i].length; j++) {
                if (!evento[i][0].isEmpty() && evento[i][20].equals(usuario[fila][6])) {
                    contador++;
                    System.out.println(contador + evento[i][0]);
                } else {
                    System.out.println("0. Salir.");
                }
            }
        }
    }

    public static void verEventoVersionNoDetallada(String[][] evento, int fila) {
        System.out.println("Nombre: " + evento[fila][0]);
        System.out.println("Descripción: " + evento[fila][1]);
        System.out.println("Categoría: " + evento[fila][2]);
        System.out.println("Fecha y Hora: " + evento[fila][3]);
        System.out.println("Aforo: " + evento[fila][4]);
        System.out.println("Número de inscritos: " + evento[fila][5]);
        if (evento[fila][6].isEmpty() && evento[fila][14].isEmpty()) {
            System.out.println("Tipo de entradas: " + evento[fila][6]);
        } else if (evento[fila][10].isEmpty() && (!evento[fila][14].isEmpty())) {
            System.out.println("Tipo de entradas: " + evento[fila][6] + " y " + evento[fila][14]);
        } else if ((!evento[fila][10].isEmpty()) && evento[fila][14].isEmpty()) {
            System.out.println("Tipo de entradas: " + evento[fila][6] + " y " + evento[fila][10]);
        } else if ((!evento[fila][10].isEmpty()) && (!evento[fila][14].isEmpty())) {
            System.out.println("Tipo de entradas: " + evento[fila][6] + ", " + evento[fila][10] + " y " + evento[fila][14]);
        }
    }

    //ESTO ES DEL LOGIN

    public static int iniciarSesion(String[][] usuarios) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Usuario: ");
        String usuario = sc.nextLine().toLowerCase();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        for (int i = 0; i < usuarios.length; i++) {

            if (usuarios[i][0] != null && usuarios[i][0].equals(usuario)) {

                if (!usuarios[i][1].equals(pass)) {
                    System.out.println("Contraseña incorrecta");
                    return -1;
                }

                if (usuarios[i][3].equals("true")) {
                    System.out.println("El usuario está BLOQUEADO");
                    return -1;
                }
                if (usuarios[i][4].equals("false")) {
                    System.out.println("Usuario no validado, iniciando validación...");
                    usuarioValidado(usuarios, i, sc);

                    if (usuarios[i][3].equals("true")) {
                        System.out.println("Acceso denegado");
                        return -1;
                    }
                }
                System.out.println("Inicio de sesión correcto");
                return i;
            }
        }

        System.out.println("El usuario no existe");
        return -1;
    }


    public static boolean usuarioBloqueado(String[][] usuarios, int posicionUsuario){
        return usuarios[posicionUsuario][3].equals("true");
    }

    public static void usuarioValidado(String[][] usuarios, int pos) {
        Scanner sc = new Scanner(System.in);

        String codigo = String.valueOf(TokenAleatorio.tokenAleatorio());
        int intentos = 3;

        DobleFactorCorreo.enviarGMail(
                "jgarlaz583@g.educaand.es",
                "FernanEvents: Código de verificación",
                "<h2>Inserte el siguiente código en el programa: <strong>" + codigo + "</strong></h2>"
        );

        while (intentos > 0) {
            System.out.print("Introduce el código enviado por Gmail: ");
            String codigoUsuario = sc.nextLine();

            if (codigoUsuario.equals(codigo)) {
                usuarios[pos][4] = "true";
                System.out.println("Usuario validado con éxito");
                return;
            } else {
                intentos--;
                System.out.println("Código incorrecto. Intentos restantes: " + intentos);
            }
        }

        usuarios[pos][3] = "true";
        System.out.println("Usuario bloqueado por seguridad");
    }

    public static void carteraUsuario(String[][] usuarios, int pos) {
        Scanner sc = new Scanner(System.in);
        double cartera = Double.parseDouble(usuarios[pos][5]);
        int opcion;

        do {
            System.out.println("-_-_-_-CARTERA-_-_-_-");
            System.out.println("Saldo: " + cartera + "€");
            System.out.println("1. Ingresar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Cantidad: ");
                    double ingresar = Double.parseDouble(sc.nextLine());
                    if (ingresar > 0) cartera += ingresar;
                    break;

                case 2:
                    System.out.print("Cantidad: ");
                    double retirar = Double.parseDouble(sc.nextLine());
                    if (retirar > 0 && cartera >= retirar) cartera -= retirar;
                    break;
            }

        } while (opcion != 3);

        usuarios[pos][5] = String.valueOf(cartera);
    }

    public static void crearUsuario(String[][] usuarios) {
        Scanner sc = new Scanner(System.in);
        int posLibre = -1;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] == null) {
                posLibre = i;
                break;
            }
        }

        if (posLibre == -1) {
            System.out.println("No se pueden crear más usuarios");
            return;
        }

        System.out.print("Nuevo usuario: ");
        String usuario = sc.nextLine().toLowerCase();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] != null && usuarios[i][0].equals(usuario)) {
                System.out.println("Ese usuario ya existe");
                return;
            }
        }

        System.out.print("Contraseña: ");
        String pass1 = sc.nextLine();

        System.out.print("Repite contraseña: ");
        String pass2 = sc.nextLine();

        if (!pass1.equals(pass2)) {
            System.out.println("Las contraseñas no coinciden");
            return;
        }

        String rol;
        do {
            System.out.print("Rol (ASISTENTE / ORGANIZADOR): ");
            rol = sc.nextLine().toUpperCase();
        } while (!rol.equals("ASISTENTE") && !rol.equals("ORGANIZADOR"));

        usuarios[posLibre][0] = usuario;
        usuarios[posLibre][1] = pass1;
        usuarios[posLibre][2] = rol;
        usuarios[posLibre][3] = "false";
        usuarios[posLibre][4] = "false";
        usuarios[posLibre][5] = "0";
        usuarios[posLibre][6] = String.valueOf(100 + posLibre);

        System.out.println("Usuario creado correctamente. Debe validarse al iniciar sesión.");
    }



    //EVENTOS
    public static void graficoBarras(String inscritosProyectos, String aforoProyecto, String porcentajeLleno, String porcentajeVacio){
        int formulaGrafico = (100 * Integer.parseInt(inscritosProyectos)) / Integer.parseInt(aforoProyecto);
        final String RESET_COLOR = "\u001B[0m";
        System.out.print(formulaGrafico + "% [");
        for (int i = 0; i < 100; i++) {
            if (i <= formulaGrafico){
                System.out.print(porcentajeLleno);
            } else {
                System.out.print(porcentajeVacio);
            }
        }
        System.out.print("]" + RESET_COLOR);
    }

    public static void entradasDetalladas(String tipo, String descripcion, String numeroEntrada, String precioEntrada){
        System.out.println("Tipo de entrada " + tipo + ": ");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Número de entradas: " + numeroEntrada);
        System.out.println("Precio: " + precioEntrada + "€.");
    }

    public static void crearEditarEvento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte un nombre para su evento: ");
        String nombre = sc.nextLine();
        if (nombre.isEmpty()){
            System.out.println("Debe insertar un nombre de evento obligatoriamente.");
        } else {
            System.out.println("Inserte una descripción para su evento: ");
            String descripcion = sc.nextLine();
            System.out.println("Inserte una categoría para su evento: ");
            String categoria = sc.nextLine();
            System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
            String fechaYHora = sc.nextLine();
            System.out.println("Inserte un aforo máximo para su evento: ");
            String aforo = sc.nextLine();
            System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1, 2 o 3)");
            int opcionEntradas = Integer.parseInt(sc.nextLine());
        }
    }

    public static void crearEntradas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte un tipo de entrada: ");
        String tipo = sc.nextLine();
        while (tipo.isEmpty()) {
            System.out.println("La entrada tiene que tener un nombre.");
            System.out.println("Inserte un tipo de entrada: ");
            tipo = sc.nextLine();
        }
        System.out.println("Inserte una descripción para este tipo de entrada:");
        String descripcion = sc.nextLine();
        System.out.println("Inserte un número de entradas para las entradas: ");
        String existencias = sc.nextLine();
        System.out.println("Inserte un precio para este tipo de entrada: ");
        String precio = sc.nextLine();
    }

    public static void eliminarEvento(String nombre, String descripcion, String categoria, String fechaYHora, String aforo, String inscritos, String idEvento){
        nombre = "";
        descripcion = "";
        categoria = "";
        fechaYHora = "";
        aforo = "";
        inscritos = "";
        idEvento = "";
    }

    public static void eliminarEntradas(String tipo, String descripcion, String existencias, String precio){
        tipo = "";
        descripcion = "";
        existencias = "";
        precio = "";
    }

}
