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
        System.out.println("1. Crear usuario");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir");
    }

    //MENU ASISTENTE
    public static void menuAsistenteUsuario(String[][] usuarios, String[][] eventos, String[] invitados, String[] eventosComprados,int idAsistente, int idEvento){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            menuAsistente();
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    misEventos(eventosComprados, idAsistente);
                    break;

                case 2:
                    menuEventosAsistente(usuarios, eventos, eventosComprados, idAsistente, idEvento);
                    break;

                case 3:
                    carteraUsuario(usuarios, idAsistente);
                    break;

                case 4:
                    invitarAmigos(invitados, idAsistente);
                    break;

                case 5:
                    configuracionUsuario(usuarios, idAsistente);
                    break;

                case 0:
                    System.out.println("Cerrando sesión");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while (opcion != 0);

    }

    public static void misEventos(String[] eventosComprados, int idUsuario) {

        if (eventosComprados[idUsuario] == null) {
            System.out.println("No has comprado entradas aún");
        } else {
            System.out.println("--- MIS EVENTOS ---");
            System.out.println(eventosComprados[idUsuario]);
        }
    }

    public static void menuEventosAsistente(String[][] usuarios, String[][] eventos, String[] eventosComprados, int posAsistente, int idEvento) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        String porcentajeLleno = "█" + VERDE;
        String porcentajeVacio = "█" + BLANCO;

        do {
            System.out.println("--- EVENTOS ---");
            System.out.println("1. Ver eventos");
            System.out.println("2. Comprar entrada");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("--- EVENTOS DISPONIBLES ---");
                    for (int i = 0; i < eventos.length; i++) {
                        if (eventos[i][0] != null) {
                            System.out.println(i + ". " + eventos[i][0]);
                        }
                    }
                    System.out.println("Si desea salir escriba 'S'.");
                    System.out.println("Elija una opción: ");
                    String opcionEvento = sc.nextLine().toLowerCase();

                    if (opcionEvento.equals("s")) {
                        System.out.println("Saliendo. . .");
                    } else {
                        int idSeleccionado = Integer.parseInt(opcionEvento);

                        if (idSeleccionado >= 0 && idSeleccionado < eventos.length && eventos[idSeleccionado][0] != null) {
                            verEventoVersionNoDetallada(eventos, idSeleccionado);

                            System.out.println("¿Quiere ver la versión detallada? (S/N)");
                            String opcionVersionDetallada = sc.nextLine().toLowerCase();

                            if (opcionVersionDetallada.equals("s")) {
                                graficoBarras(eventos, idSeleccionado, porcentajeLleno, porcentajeVacio);
                                verEntradasEventos(eventos, idSeleccionado);
                            } else {
                                System.out.println("Saliendo . . .");
                            }
                        } else {
                            System.out.println("Inválido.");
                        }
                    }
                    break;

                case 2:
                    comprarEntrada(usuarios, eventos, eventosComprados, posAsistente);
                    break;

                case 0:
                    System.out.println("Saliendo de eventos...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    public static void comprarEntrada(String[][] usuarios, String[][] eventos, String[] eventosComprados, int posAsistente) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Desea comprar una entrada? (s/n): ");
        String confirmar = sc.nextLine().toLowerCase();

        if (!confirmar.equals("s")) {
            System.out.println("Compra cancelada");
            return;
        }

        System.out.print("ID del evento: ");
        int idEvento = Integer.parseInt(sc.nextLine());

        if (idEvento == -1 || idEvento < 0 || idEvento >= eventos.length || eventos[idEvento][0] == null) {
            System.out.println("Saliendo...");
            return;
        }

        System.out.print("ID de la entrada: ");
        int idEntrada = Integer.parseInt(sc.nextLine());

        System.out.print("Cantidad de entradas: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        double precio = Double.parseDouble(eventos[idEvento][idEntrada + 4]);
        double total = precio * cantidad;

        double saldo = Double.parseDouble(usuarios[posAsistente][5]);

        if (saldo < total) {
            System.out.println("Saldo insuficiente");
            return;
        }

        usuarios[posAsistente][5] = String.valueOf(saldo - total);
        double organizadorParte = total * 0.90;
        double adminParte = total * 0.10;
        int posOrganizador = Integer.parseInt(eventos[idEvento][1]);

        usuarios[posOrganizador][5] =
                String.valueOf(Double.parseDouble(usuarios[posOrganizador][5]) + organizadorParte);

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] != null && usuarios[i][2].equals("ADMIN")) {
                usuarios[i][5] =
                        String.valueOf(Double.parseDouble(usuarios[i][5]) + adminParte);
                break;
            }
        }

        if (eventosComprados[posAsistente] == null) {
            eventosComprados[posAsistente] = "";
        }
        eventosComprados[posAsistente] += eventos[idEvento][0] + "\n";

        System.out.println("Compra realizada");
    }


    public static void invitarAmigos(String[] invitados, int posicionUsuario){
        Scanner sc = new Scanner(System.in);
        String nombre, opcion;

        if (invitados[posicionUsuario] == null){
            invitados[posicionUsuario] = "";
        }

        do {
            System.out.println("A q amigo quieres invitar?");
            nombre = sc.nextLine();

            invitados[posicionUsuario] += nombre + "\n";

            System.out.println("Quieres invitar a otro amigo?");
            opcion = sc.nextLine().toLowerCase();
        }while (opcion.equals("si"));

        System.out.println("--- LISTA DE AMIGOS ---");
        System.out.println(invitados[posicionUsuario]);
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
        System.out.println("0. Cerrar Sesión");
    }

    public static void menuOrganizadorUsuario(String[][] usuarios, String[][] eventos, int posicionOrganizador, int idEvento){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            menuOrganizador();
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    menuOrganizadorMisEventos(eventos, usuarios, idEvento, posicionOrganizador);
                break;
                case 2:
                    carteraUsuario(usuarios, posicionOrganizador);
                break;
                case 3:
                    configuracionUsuario(usuarios, posicionOrganizador);
                break;
                case 0:
                    System.out.println("Cerrando sesión");
                break;
                default:
                    System.out.println("Opcion no valida");
                break;
            }

        }while (opcion != 0);

    }

        public static void menuOrganizador(){
        final String AZUL = "\u001B[34m";
        final String RESET_COLOR = "\u001B[0m";

        System.out.println(AZUL + "----Menú Organizador----" + RESET_COLOR);
        System.out.println("1. Mis Eventos.");
        System.out.println("2. Cartera Digital.");
        System.out.println("3. Configuración.");
        System.out.println("0. Cerrar Sesión");
    }

    public static void menuOrganizadorEventos(){
        System.out.println("Bienvenido a tus eventos");
        System.out.println("1. Ver eventos.");
        System.out.println("2. Crear eventos.");
        System.out.println("3. Editar eventos.");
        System.out.println("4. Eliminar eventos.");
        System.out.println("0. Salir.");
    }

    public static void menuAdministradorUsuario(String[][] usuarios, String[][] eventos, int posicionAdmin, int idEvento){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            menuAdministrador();
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    panelDeControl(usuarios);
                break;

                case 2:
                    menuEventosAdmin(eventos, idEvento);
                break;

                case 3:
                    carteraUsuario(usuarios, posicionAdmin);
                break;

                case 4:
                    configuracionUsuario(usuarios, posicionAdmin);
                break;

                case 0:
                    System.out.println("Cerrando sesión");
                break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion != 0);
    }

    public static void panelDeControl(String[][] usuarios) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- PANEL DE CONTROL ADMIN ---");
            System.out.println("1. Bloquear usuario");
            System.out.println("2. Desbloquear usuario");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la id del usuario a BLOQUEAR: ");
                    int posBloquearUsuario = Integer.parseInt(sc.nextLine());

                    if (posBloquearUsuario < 0 || posBloquearUsuario >= usuarios.length || usuarios[posBloquearUsuario][0] == null) {
                        System.out.println("Usuario no valido");
                    } else {
                        usuarios[posBloquearUsuario][3] = "true";
                        System.out.println("Usuario bloqueado");
                    }
                    break;

                case 2:
                    System.out.print("Introduce la posición del usuario a DESBLOQUEAR: ");
                    int posDesbloquearUsuario = Integer.parseInt(sc.nextLine());

                    if (posDesbloquearUsuario < 0 || posDesbloquearUsuario >= usuarios.length || usuarios[posDesbloquearUsuario][0] == null) {
                        System.out.println("Usuario no valido");
                    } else {
                        usuarios[posDesbloquearUsuario][3] = "false";
                        System.out.println("Usuario desbloqueado");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del panel de control...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    public static void configuracionUsuario(String[][] usuarios, int posicionUsuario) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("--- CONFIGURACIÓN ---");
            System.out.println("1. Cambiar nombre de usuario");
            System.out.println("2. Cambiar contraseña");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("Nuevo nombre de usuario: ");
                    String nuevoNombre = sc.nextLine().toLowerCase();

                    boolean existe = false;
                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuarios[i][0] != null && usuarios[i][0].equals(nuevoNombre)) {
                            existe = true;
                        }
                    }

                    if (existe) {
                        System.out.println("Ese nombre de usuario ya existe");
                    } else {
                        usuarios[posicionUsuario][0] = nuevoNombre;
                        System.out.println("Nombre de usuario cambiado correctamente");
                    }
                    break;

                case 2:
                    System.out.print("Contraseña actual: ");
                    String passActual = sc.nextLine();

                    if (!Cadenas.contraseniaSonIguales(passActual, usuarios[posicionUsuario][1])) {
                        System.out.println("Contraseña incorrecta");
                        break;
                    }

                    System.out.print("Nueva contraseña: ");
                    String nuevaContrasenia = sc.nextLine();

                    System.out.print("Repite nueva contraseña: ");
                    String nuevaContrasenia2 = sc.nextLine();

                    if (!Cadenas.contraseniaSonIguales(nuevaContrasenia, nuevaContrasenia2)) {
                        System.out.println("Las contraseñas no coinciden");
                        break;
                    }

                    if (!Cadenas.contraseniaFuerte(nuevaContrasenia)) {
                        System.out.println("La contraseña no es segura");
                        break;
                    }

                    usuarios[posicionUsuario][1] = nuevaContrasenia;
                    System.out.println("Contraseña cambiada correctamente");
                    break;

                case 0:
                    System.out.println("Saliendo de configuración...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 3);
    }

    public static void menuEventosAdmin(String[][] eventos, int idEvento){
        Scanner sc = new Scanner(System.in);
        int opcion;
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        String porcentajeLleno = "█" + VERDE;
        String porcentajeVacio = "█" + BLANCO;

        do {
            System.out.println("--- EVENTOS ---");
            System.out.println("1. Ver eventos");
            System.out.println("2. Editar evento");
            System.out.println("3. Eliminar evento");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("--- EVENTOS DISPONIBLES ---");
                    for (int i = 0; i < eventos.length; i++) {
                        if (eventos[i][0] != null) {
                            System.out.println(i + ". " + eventos[i][0]);
                        }
                    }
                    System.out.println("Si desea salir escriba 'S'.");
                    System.out.println("Elija una opción: ");
                    String opcionEvento = sc.nextLine().toLowerCase();

                    if (opcionEvento.equals("s")) {
                        System.out.println("Saliendo. . .");
                    } else {
                        int idSeleccionado = Integer.parseInt(opcionEvento);

                        if (idSeleccionado >= 0 && idSeleccionado < eventos.length && eventos[idSeleccionado][0] != null) {
                            verEventoVersionNoDetallada(eventos, idSeleccionado);

                            System.out.println("¿Quiere ver la versión detallada? (S/N)");
                            String opcionVersionDetallada = sc.nextLine().toLowerCase();

                            if (opcionVersionDetallada.equals("s")) {
                                graficoBarras(eventos, idSeleccionado, porcentajeLleno, porcentajeVacio);
                                verEntradasEventos(eventos, idSeleccionado);
                            } else {
                                System.out.println("Saliendo . . .");
                            }
                        } else {
                            System.out.println("Inválido.");
                        }
                    }
                break;
                case 2:
                    System.out.print("Introduce la id del evento que deseas editar: ");
                    idEvento = Integer.parseInt(sc.nextLine());
                    crearEditarEvento(eventos, idEvento);
                    crearEntradas(eventos, idEvento, 7);
                    crearEntradas(eventos, idEvento, 12);
                    crearEntradas(eventos, idEvento, 17);
                break;
                case 3:
                    System.out.print("Introduce la id del evento que deseas eliminar: ");
                    idEvento = Integer.parseInt(sc.nextLine());
                    eliminarEvento(eventos, idEvento);
                break;
                case 0:
                    System.out.println("Saliendo de eventos...");
                break;
                default:
                    System.out.println("Opción no válida");
                break;
            }

        } while (opcion != 0);
    }

    public static void menuAdministrador(){
        final String VERDE = "\u001B[32m";
        final String RESET_COLOR = "\u001B[0m";

        System.out.println(VERDE + "----Menú Administrador----" + RESET_COLOR);
        System.out.println("1. Panel de control.");
        System.out.println("2. Eventos.");
        System.out.println("3. Cartera Digital.");
        System.out.println("4. Configuración.");
        System.out.println("0. Cerrar Sesión");
    }

    /**
     * Esta función recorre los eventos creados por el organizador y muestra sus nombres para que
     * el organizador pueda elegir cuál quiere ver.
     * @param evento
     * @param usuario
     * @param idEvento
     */

    public static void verEventosCreadosOrganizador(String[][] evento, String[][] usuario, int idEvento) {
        int contador = 0;

    }

    public static void verEventoVersionNoDetallada(String[][] evento, int idEvento) {
        System.out.println("Nombre: " + evento[idEvento][0]);
        System.out.println("Descripción: " + evento[idEvento][1]);
        System.out.println("Categoría: " + evento[idEvento][2]);
        System.out.println("Fecha y Hora: " + evento[idEvento][3]);
        System.out.println("Aforo: " + evento[idEvento][4]);
        System.out.println("Número de inscritos: " + evento[idEvento][5]);
        if (evento[idEvento][7].isEmpty() && evento[idEvento][12].isEmpty()) {
            System.out.println("Tipo de entradas: " + evento[idEvento][7]);
        } else if (evento[idEvento][12].isEmpty() && (!evento[idEvento][17].isEmpty())) {
            System.out.println("Tipo de entradas: " + evento[idEvento][7] + " y " + evento[idEvento][12]);
        } else if ((!evento[idEvento][12].isEmpty()) && evento[idEvento][17].isEmpty()) {
            System.out.println("Tipo de entradas: " + evento[idEvento][7] + " y " + evento[idEvento][12]);
        } else if ((!evento[idEvento][12].isEmpty()) && (!evento[idEvento][17].isEmpty())) {
            System.out.println("Tipo de entradas: " + evento[idEvento][7] + ", " + evento[idEvento][12] + " y " + evento[idEvento][12]);
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
                    usuarioValidado(usuarios, i);

                    if (usuarios[i][3].equals("true")) {
                        System.out.println("Acceso denegado");
                        return -1;
                    }
                }
                System.out.println("Inicio de sesión correcto");
                System.out.println("Tu id es " + usuarios[i][6]);
                return i;
            }
        }
        System.out.println("El usuario no existe");
        return -1;
    }


    public static boolean usuarioBloqueado(String[][] usuarios, int posicionUsuario){
        return usuarios[posicionUsuario][3].equals("true");
    }

    public static void usuarioValidado(String[][] usuarios, int posicion) {
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
                usuarios[posicion][4] = "true";
                System.out.println("Usuario validado con éxito");
                return;
            } else {
                intentos--;
                System.out.println("Código incorrecto. Intentos restantes: " + intentos);
            }
        }

        usuarios[posicion][3] = "true";
        System.out.println("Usuario bloqueado por seguridad");
    }

    public static void carteraUsuario(String[][] usuarios, int posicion) {
        Scanner sc = new Scanner(System.in);
        double cartera = Double.parseDouble(usuarios[posicion][5]);
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

        usuarios[posicion][5] = String.valueOf(cartera);
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
        String contrasenia1 = sc.nextLine();

        System.out.print("Repite contraseña: ");
        String contrasenia2 = sc.nextLine();

        if (!contrasenia1.equals(contrasenia2)) {
            System.out.println("Las contraseñas no coinciden");
            return;
        }

        String rol;
        do {
            System.out.print("Rol (ASISTENTE / ORGANIZADOR): ");
            rol = sc.nextLine().toUpperCase();
        } while (!rol.equals("ASISTENTE") && !rol.equals("ORGANIZADOR"));

        usuarios[posLibre][0] = usuario;
        usuarios[posLibre][1] = contrasenia1;
        usuarios[posLibre][2] = rol;
        usuarios[posLibre][3] = "false";
        usuarios[posLibre][4] = "false";
        usuarios[posLibre][5] = "0";
        usuarios[posLibre][6] = String.valueOf(100 + posLibre);

        System.out.println("Usuario creado correctamente. Debe validarse al iniciar sesión.");
    }


    //EVENTOS
    public static void graficoBarras(String[][] eventos, int idEvento, String porcentajeLleno, String porcentajeVacio){
        int formulaGrafico = (100 * Integer.parseInt(eventos[idEvento][5])) / Integer.parseInt(eventos[idEvento][4]);
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

    public static void entradasDetalladas(String[][] eventos, int idEvento, int idEntrada){
        System.out.println("Nombre de entrada " + eventos[idEvento][idEntrada+1] + ": ");
        System.out.println("Descripción: " + eventos[idEvento][idEntrada+2]);
        System.out.println("Número de entradas: " + eventos[idEvento][idEntrada+3]);
        System.out.println("Precio: " + eventos[idEvento][idEntrada+4] + "€.");
    }

    public static void crearEditarEvento(String[][] eventos, int idEvento){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte un nombre para su evento: ");
        eventos[idEvento][0] = sc.nextLine();
        if (eventos[idEvento][0].isEmpty()){
            System.out.println("Debe insertar un nombre de evento obligatoriamente.");
        } else {
            System.out.println("Inserte una descripción para su evento: ");
            eventos[idEvento][1] = sc.nextLine();
            System.out.println("Inserte una categoría para su evento: ");
            eventos[idEvento][2] = sc.nextLine();
            System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
            eventos[idEvento][3] = sc.nextLine();
            System.out.println("Inserte un aforo máximo para su evento: ");
            eventos[idEvento][4] = sc.nextLine();
            eventos[idEvento][5] = "0";
        }
    }

    public static void crearEntradas(String[][] eventos, int idEvento, int idEntrada){
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Inserte el nombre de la entrada: ");
            eventos[idEvento][idEntrada+1] = sc.nextLine();
            if (eventos[idEvento][idEntrada+1].isEmpty()) System.out.println("La entrada tiene que tener un nombre.");
        } while (eventos[idEvento][idEntrada+1].isEmpty());

        System.out.println("Inserte una descripción para este tipo de entrada:");
        eventos[idEvento][idEntrada+2] = sc.nextLine();
        System.out.println("Inserte el número de entradas existentes: ");
        eventos[idEvento][idEntrada+3] = sc.nextLine();
        System.out.println("Inserte un precio para este tipo de entrada: ");
        eventos[idEvento][idEntrada+4] = sc.nextLine();
    }

    public static void eliminarEvento(String[][] eventos, int idEvento){
        if (eventos[idEvento][0].isEmpty()) {
            System.out.println("Evento no válido");
        } else {
            for (int j = 0; j < eventos[idEvento].length; j++) {
                eventos[idEvento][j] = null;
            }
            System.out.println("Su evento ha sido eliminado correctamente.");
        }
    }
    //MENU ORGANIZADOR
    public static void menuOrganizadorMisEventos(String[][] eventos, String[][] usuarios, int idEvento, int idUsuario){
        Scanner sc = new Scanner(System.in);
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        String porcentajeLleno = "█" + VERDE;
        String porcentajeVacio = "█" + BLANCO;
        int opcion;
        do {
            menuOrganizadorEventos();
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Indique su ID de usuario: ");
                    idUsuario = Integer.parseInt(sc.nextLine());

                    System.out.println("¿Qué proyecto quiere ver?");

                    for (int i = 0; i < eventos.length; i++) {
                        if (eventos[i] != null && eventos[i][0] != null) {
                            if (eventos[i][22].equals(String.valueOf(idUsuario))) {
                                System.out.println(eventos[i][21] + ". " + eventos[i][0]);
                            }
                        }
                    }
                    System.out.println("Si desea salir escriba 'S'.");
                    System.out.print("Elija una opción: ");
                    String opcionEvento = sc.nextLine().toLowerCase();

                    if (opcionEvento.equals("s")) {
                        System.out.println("Saliendo. . .");
                    } else {
                        int indiceEncontrado = -1;

                        for (int i = 0; i < eventos.length; i++) {
                            if (eventos[i] != null && eventos[i][0] != null) {
                                if (eventos[i][21].equals(opcionEvento)) {
                                    if (eventos[i][22].equals(String.valueOf(idUsuario))) {
                                        indiceEncontrado = i;
                                    }
                                }
                            }
                        }

                        if (indiceEncontrado != -1) {
                            verEventoVersionNoDetallada(eventos, indiceEncontrado);

                            System.out.println("¿Quiere ver la versión detallada? (S/N)");
                            String opcionVersionDetallada = sc.nextLine();

                            if (opcionVersionDetallada.equals("S") || opcionVersionDetallada.equals("s")) {
                                graficoBarras(eventos, indiceEncontrado, porcentajeLleno, porcentajeVacio);
                                verEntradasEventos(eventos, indiceEncontrado);
                            } else {
                                System.out.println("Saliendo . . .");
                            }
                        } else {
                            System.out.println("Inválido.");
                        }
                    }
                break;
                case 2:
                    int id = -1;
                    for (int i = 0; i < eventos.length; i++) {
                        if (eventos[i][0] == null) {
                            id = i;
                            break;
                        }
                    }
                    if (id == -1) {
                        System.out.println("No se pueden crear más eventos.");
                    } else {
                        System.out.println("Indique su ID de usuario: ");
                        idUsuario = Integer.parseInt(sc.nextLine());

                        crearEditarEvento(eventos, id);

                        if (eventos[id][0] != null && !eventos[id][0].isEmpty()) {

                            System.out.println("¿Cuántas entradas quiere crear? (1, 2 o 3)");
                            int opcionEntradas = Integer.parseInt(sc.nextLine());
                            switch (opcionEntradas){
                                case 1:
                                    crearEntradas(eventos, id, 7);
                                break;
                                case 2:
                                    crearEntradas(eventos, id, 7);
                                    crearEntradas(eventos, id, 12);
                                break;
                                case 3:
                                    crearEntradas(eventos, id, 7);
                                    crearEntradas(eventos, id, 12);
                                    crearEntradas(eventos, id, 17);
                                break;
                                default:
                                    System.out.println("Inválido.");
                                break;
                            }
                            eventos[id][21] = String.valueOf(id);
                            eventos[id][22] = String.valueOf(idUsuario);
                            System.out.println("Su evento ha sido creado.");
                        }
                    }
                break;
                case 3:
                    System.out.print("Introduce la id del evento que deseas editar: ");
                    idEvento = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < eventos.length; i++) {
                        for (int j = 0; j < eventos[i].length; j++) {
                            if (!eventos[i][0].isEmpty() && eventos[i][22].equals(usuarios[i][6]));
                            crearEditarEvento(eventos, idEvento);
                        }
                    }
                break;
                case 4:
                    System.out.print("Introduce la id del evento que deseas eliminar: ");
                    idEvento = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < eventos.length; i++) {
                        for (int j = 0; j < eventos[i].length; j++) {
                            if (!eventos[i][0].isEmpty() && eventos[i][22].equals(usuarios[i][6]));
                            eliminarEvento(eventos, idEvento);
                        }
                    }
                break;
            }
        }while(opcion != 0);
    }

    public static void verEntradasEventos(String[][] eventos, int idEvento){
        if (!(eventos[idEvento][7] == null)){
            entradasDetalladas(eventos, idEvento, Integer.parseInt(eventos[idEvento][7]));
        }else if (!(eventos[idEvento][12] == null)){
            entradasDetalladas(eventos, idEvento, Integer.parseInt(eventos[idEvento][12]));
        } else if (!(eventos[idEvento][17] == null)) {
            entradasDetalladas(eventos, idEvento, Integer.parseInt(eventos[idEvento][17]));
        }
    }



}
