package mainFernan;
import java.util.Scanner;

import mainFernan.utilidades.*;

public class fernanEvents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [i][0] -> nombre
        // [i][1] -> contraseña
        // [i][2] -> rol (ORGANIZADOR / ASISTENTE)
        // [i][3] -> bloqueado (true / false)
        // [i][4] -> validado por el correo (true / false)
        // [i][5] -> cartera
        // [i][6] -> ID

        String[][] usuarios = new String[9][7];

        usuarios[0][0] = "admin";
        usuarios[0][1] = "1234a";
        usuarios[0][2] = "ADMIN";
        usuarios[0][3] = "false";
        usuarios[0][4] = "true";
        usuarios[0][5] = "0";
        usuarios[0][6] = "100";

        usuarios[1][0] = "organizador";
        usuarios[1][1] = "1234o";
        usuarios[1][2] = "ORGANIZADOR";
        usuarios[1][3] = "false";
        usuarios[1][4] = "true";
        usuarios[1][5] = "101";

        usuarios[2][0] = "asistente1";
        usuarios[2][1] = "1234a1";
        usuarios[2][2] = "ASISTENTE";
        usuarios[2][3] = "false";
        usuarios[2][4] = "true";
        usuarios[2][5] = "102";

        // [i][0] -> nombre
        // [i][1] -> descripción breve
        // [i][2] -> categoría
        // [i][3] -> fecha y hora
        // [i][4] -> aforo
        // [i][5] -> inscritos
        // [i][6] -> id entrada 1 (6)
        // [i][7] -> nombre de entrada 1
        // [i][8] -> entrada 1 descripción
        // [i][9] -> entrada 1 existencias
        // [i][10] -> entrada 1 precio
        // [i][11] -> id entrada 2 (11)
        // [i][12] -> tipo de entrada 2
        // [i][13] -> entrada 2 descripción
        // [i][14] -> entrada 2 existencias
        // [i][15] -> entrada 2 precio
        // [i][16] -> id entrada 3 (16)
        // [i][17] -> tipo de entrada 3
        // [i][18] -> entrada 3 descripción
        // [i][19] -> entrada 3 existencias
        // [i][20] -> entrada 3 precio
        // [i][21] -> id evento que pone automáticamente el programa
        // [i][22] -> id del organizador que ha creado el evento

        // [0][j] -> evento 1
        // [1][j] -> evento 2
        // [2][j] -> evento 3
        // etc...

        String[][] eventos = new String[19][22];
        eventos[0][0] = "Prueba";
        eventos[0][1] = "Una prueba para comprobar que todo funciona correctamente.";
        eventos[0][2] = "Arte.";
        eventos[0][3] = "18/11/2025 a las 16:00.";
        eventos[0][4] = "20";
        eventos[0][5] = "5";
        eventos[0][6] = "6";
        eventos[0][7] = "Pista";
        eventos[0][8] = "La pista para los pobres.";
        eventos[0][9] = "200";
        eventos[0][10] = "70";
        eventos[0][11] = "11";
        eventos[0][12] = "Asientos";
        eventos[0][13] = "Asientos para la clase media.";
        eventos[0][14] = "100";
        eventos[0][15] = "100";
        eventos[0][16] = "16";
        eventos[0][17] = "VIP";
        eventos[0][18] = "VIP pa los chulos.";
        eventos[0][19] = "20";
        eventos[0][20] = "200";
        eventos[0][21] = "0";
        eventos[0][22] = "101";



        int eleccionUsuario;
        int usuarioRegistrado = -1;

        //LOGIN


        do{
            mainFernan.utilidades.Funciones.logoFernan();
            eleccionUsuario = Integer.parseInt(sc.nextLine());

            switch (eleccionUsuario){
                case 1:
                    usuarioRegistrado = mainFernan.utilidades.Funciones.iniciarSesion(usuarios);

                if (usuarioRegistrado != -1){
                    System.out.println("Bienvenido " + usuarios[usuarioRegistrado][0]);
                    System.out.println("Con rol: " + usuarios[usuarioRegistrado][0]);
                }
                break;

                case 2:
                    mainFernan.utilidades.Funciones.crearUsuario(usuarios);
                break;

                case 3:
                    System.out.println("Gracias por tu visiata....");
                    break;

            }

        }while (eleccionUsuario != 3);








        //USUARIOS
        String usuario = "";

        String administrador = "admin";
        String contraAdmin = "1234a";
        double carteraAdministrador = 0;

        String organizador = "organizador";
        String contraOrganizador = "1234o";
        double carteraOrganizador = 0;
        double comisionAdministrador = 0;

        String asistente1 = "asistente1";
        String contraAsistente1 = "1234a1";
        double carteraAsistente1 = 10000;
        String amigosReferidosA1 = "";
        String nombreEntradaAsistente1 = "";
        double precioEntradaSeleccionada = 0;
        boolean asistente1InscritoProyecto1 = false;
        boolean asistente1InscritoProyecto2 = false;
        boolean asistente1InscritoProyecto3 = false;

        String asistente2 = "asistente2";
        String contraAsistente2 = "1234a2";
        double carteraAsistente2 = 0;
        String amigosReferidosA2 = "";
        String nombreEntradaAsistente2 = "";
        double precioEntradaSeleccionada2 = 0;
        boolean asistente2InscritoProyecto1 = false;
        boolean asistente2InscritoProyecto2 = false;
        boolean asistente2InscritoProyecto3 = false;

        String contrasenia = "";

        int intentosLoginOrganizador = 3;
        int intentosLoginAsistente1 = 3;
        int intentosLoginAsistente2 = 3;
        boolean organizadorBloqueado = false;
        boolean asistente1Bloqueado = false;
        boolean asistente2Bloqueado = false;
        boolean contraseniaCorrecta = false;
        boolean seguirComprando = true;

        int opcion = 0;
        int opcion2 = 0;
        int opcion3;
        int opcionEntrada;

        //CARTERA
        double aniadir;
        double retirar;

        //COLORES
        final String VERDE = "\u001B[32m";
        final String BLANCO = "\u001B[37m";
        final String ROJO = "\u001B[31m";
        final String AMARILLO = "\u001B[33m";
        final String AZUL = "\u001B[34m";
        final String MORADO = "\u001B[35m";
        final String CYAN = "\u001B[36m";
        final String RESET_COLOR = "\u001B[0m";

        //EVENTOS
        String porcentajeLleno = "█" + VERDE;
        String porcentajeVacio = "█" + BLANCO;

        //variables proyecto 1
        String nombreProyecto1 = "Prueba";
        String descripcionProyecto1 = "Una prueba para comprobar que todo funciona correctamente.";
        String categoriaProyecto1 = "Arte.";
        String fechaYHoraProyecto1 = "18/11/2025 a las 16:00.";
        int aforoProyecto1 = 20;
        int inscritosProyecto1 = 5;
        //tipos de entradas del proyecto 1.
        String tipoEntrada1Proyecto1 = "Pista";
        String tipoEntrada1DescripcionProyecto1 = "La pista para los pobres.";
        int tipoEntrada1ExistenciasProyecto1 = 200;
        float tipoEntrada1PrecioProyecto1 = 70f;
        String tipoEntrada2Proyecto1 = "Asiento";
        String tipoEntrada2DescripcionProyecto1 = "Los asientos para la clase media.";
        int tipoEntrada2ExistenciasProyecto1 = 100;
        float tipoEntrada2PrecioProyecto1 = 100f;
        String tipoEntrada3Proyecto1 = "VIP";
        String tipoEntrada3DescripcionProyecto1 = "Vip pa los chulos.";
        int tipoEntrada3ExistenciasProyecto1 = 20;
        float tipoEntrada3PrecioProyecto1 = 200f;

        String versionDetallada = "";

        //variables proyecto 2
        String nombreProyecto2 = "";
        String descripcionProyecto2 = "";
        String categoriaProyecto2 = "";
        String fechaYHoraProyecto2 = "";
        int aforoProyecto2 = 1;
        int inscritosProyecto2 = 0;
        //tipos de entradas del proyecto 2.
        String tipoEntrada1Proyecto2 = "";
        String tipoEntrada1DescripcionProyecto2 = "";
        int tipoEntrada1ExistenciasProyecto2 = 0;
        float tipoEntrada1PrecioProyecto2 = 0f;
        String tipoEntrada2Proyecto2 = "";
        String tipoEntrada2DescripcionProyecto2 = "";
        int tipoEntrada2ExistenciasProyecto2 = 0;
        float tipoEntrada2PrecioProyecto2 = 0f;
        String tipoEntrada3Proyecto2 = "";
        String tipoEntrada3DescripcionProyecto2 = "";
        int tipoEntrada3ExistenciasProyecto2 = 0;
        float tipoEntrada3PrecioProyecto2 = 0f;

        //variables proyecto 3
        String nombreProyecto3 = "";
        String descripcionProyecto3 = "";
        String categoriaProyecto3 = "";
        String fechaYHoraProyecto3 = "";
        int aforoProyecto3 = 1;
        int inscritosProyecto3 = 0;
        //tipos de entradas del proyecto 3.
        String tipoEntrada1Proyecto3 = "";
        String tipoEntrada1DescripcionProyecto3 = "";
        int tipoEntrada1ExistenciasProyecto3 = 0;
        float tipoEntrada1PrecioProyecto3 = 0f;
        String tipoEntrada2Proyecto3 = "";
        String tipoEntrada2DescripcionProyecto3 = "";
        int tipoEntrada2ExistenciasProyecto3 = 0;
        float tipoEntrada2PrecioProyecto3 = 0f;
        String tipoEntrada3Proyecto3 = "";
        String tipoEntrada3DescripcionProyecto3 = "";
        int tipoEntrada3ExistenciasProyecto3 = 0;
        float tipoEntrada3PrecioProyecto3 = 0f;

        boolean entrada = true;

        int formulaGraficoBarrasProyecto1 = (100 * inscritosProyecto1) / aforoProyecto1;
        int formulaGraficoBarrasProyecto2 = (100 * inscritosProyecto2) / aforoProyecto2;
        int formulaGraficoBarrasProyecto3 = (100 * inscritosProyecto3) / aforoProyecto3;

        do {
            mainFernan.utilidades.Funciones.logoFernan();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    //login
                    do {
                        contraseniaCorrecta = false;
                        System.out.println("Bienvenid@ a Fernan Events.");

                        System.out.print("Inserte su usuario: ");
                        usuario = sc.nextLine().toLowerCase();
                        if (usuario.equals(asistente1) && asistente1Bloqueado == true) System.out.println("El asistente1 está bloqueado, llame al admin");
                        else if (usuario.equals(asistente2) && asistente2Bloqueado == true) {
                            System.out.println("El asistente 2 está bloqueado, llame al admin");
                        } else if (usuario.equals(organizador) && organizadorBloqueado == true) {
                            System.out.println("El organizador está bloqueado, llame al admin");
                        }else if (usuario.equals(administrador)) {
                            System.out.print("Inserte su contraseña: ");
                            contrasenia = sc.nextLine();


                            if (contrasenia.equals(contraAdmin)) {
                                System.out.println("Bienvenido.");
                                contraseniaCorrecta = true;
                            } else {
                                System.out.println("Contraseña incorrecta, inténtelo de nuevo.");
                            }
                        } else if (usuario.equals(organizador) || usuario.equals(asistente1) || usuario.equals(asistente2)) {
                            System.out.print("Inserte su contraseña: ");
                            contrasenia = sc.nextLine();

                            if (usuario.equals(organizador)) {
                                if (contrasenia.equals(contraOrganizador)) {
                                    System.out.println("Bienvenido.");
                                    contraseniaCorrecta = true;
                                } else {
                                    intentosLoginOrganizador--;
                                    System.out.println("Te quedan " + intentosLoginOrganizador + " intentos.");
                                    if (intentosLoginOrganizador <= 0) {
                                        System.out.println("Has fallado 3 veces, tu usuario ha sido bloqueado.");
                                        organizadorBloqueado = true;
                                    } else {
                                        System.out.println("Contraseña incorrecta, inténtelo de nuevo.");
                                    }
                                }
                            } else if (usuario.equals(asistente1)) {
                                if (contrasenia.equals(contraAsistente1)) {
                                    System.out.println("Bienvenido.");
                                    contraseniaCorrecta = true;
                                } else {
                                    intentosLoginAsistente1--;
                                    System.out.println("Te quedan " + intentosLoginAsistente1 + " intentos.");
                                    if (intentosLoginAsistente1 <= 0) {
                                        System.out.println("Has fallado 3 veces, tu usuario ha sido bloqueado.");
                                        asistente1Bloqueado = true;
                                    } else {
                                        System.out.println("Contraseña incorrecta, inténtelo de nuevo.");
                                    }
                                }
                            } else if (usuario.equals(asistente2)) {
                                if (contrasenia.equals(contraAsistente2)) {
                                    System.out.println("Bienvenido.");
                                    contraseniaCorrecta = true;
                                } else {
                                    intentosLoginAsistente2--;
                                    System.out.println("Te quedan " + intentosLoginAsistente2 + " intentos.");
                                    if (intentosLoginAsistente2 <= 0) {
                                        System.out.println("Has fallado 3 veces, tu usuario ha sido bloqueado.");
                                        asistente2Bloqueado = true;
                                    } else {
                                        System.out.println("Contraseña incorrecta, inténtelo de nuevo.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Usuario incorrecto, inténtelo de nuevo.");
                        }
                    } while (!contraseniaCorrecta);

                    //menu organizador
                    if (usuario.equals(organizador) && contrasenia.equals(contraOrganizador) && contraseniaCorrecta){
                        do {
                            mainFernan.utilidades.Funciones.menuOrganizador();
                            opcion = Integer.parseInt(sc.nextLine());

                            switch (opcion){
                                case 1:
                                    System.out.println("----Mis eventos----");
                                    do {
                                        mainFernan.utilidades.Funciones.menuOrganizadorEventos();
                                        opcion2 = Integer.parseInt(sc.nextLine());
                                        switch (opcion2){
                                            case 1:
                                                System.out.println("Tus eventos");
                                                do {
                                                    System.out.println("¿Qué proyecto quiere ver?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());
                                                    switch (opcion3){
                                                        case 1:

                                                            break;
                                                        case 2:

                                                            break;
                                                        case 3:

                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
                                                }while (opcion3 != 4);
                                            break;
                                            case 2:
                                                System.out.println("Crear nuevo evento");
                                                do {
                                                    System.out.println("¿Qué proyecto quiere crear?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());
                                                }while (opcion3 != 4);
                                            break;
                                            case 3:
                                                System.out.println("Editar eventos.");
                                                do {
                                                    System.out.println("¿Qué proyecto quiere editar?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());
                                                }while (opcion3 != 4);
                                            break;
                                            case 4:
                                                System.out.println("Eliminar eventos.");
                                                do {
                                                    System.out.println("¿Qué evento quiere eliminar?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());

                                                }while (opcion3 != 4);
                                            break;
                                            case 5:
                                                System.out.println("Saliendo...");
                                            break;
                                            default:
                                                System.out.println("Opción inválida, inserte una opción válida (1-5).");
                                            break;
                                        }
                                    }while(opcion2 != 5);
                                    break;
                                case 2:
                                    do {
                                        aniadir = 0;
                                        retirar = 0;
                                        System.out.println("Bienvenido a tu cartera digital");
                                        System.out.println("Tu saldo actual es de: " + carteraOrganizador);
                                        System.out.println("1. Añadir");
                                        System.out.println("2. Retirar");
                                        System.out.println("3. Salir");
                                        opcion2 = Integer.parseInt(sc.nextLine());
                                        switch (opcion2) {
                                            case 1:
                                                System.out.println("¿Cúanto dinero deseas añadir a tu cartera digital?");
                                                aniadir = Integer.parseInt(sc.nextLine());
                                                carteraOrganizador += aniadir;
                                                break;
                                            case 2:
                                                if (carteraOrganizador == 0) System.out.println("No puedes retirar dinero si está a 0");
                                                else{
                                                    System.out.println("¿Cúanto dinero deseas retirar de tu cartera digital?");
                                                    retirar = Integer.parseInt(sc.nextLine());
                                                    if ((carteraOrganizador - retirar) < 0) System.out.println("No tienes suficiente dinero para retirar");
                                                    else carteraOrganizador -= retirar;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Saliendo de la cartera digital");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta. Introduce una opción válida (1-3).");
                                                break;
                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 3:
                                    System.out.println("----Configuración----");
                                    do {
                                        System.out.println("1. Cambiar usuario.");
                                        System.out.println("2. Cambiar contraseña.");
                                        System.out.println("3. Salir.");
                                        opcion2 = Integer.parseInt(sc.nextLine());

                                        switch(opcion2){
                                            case 1:
                                                System.out.println("Inserte su nuevo nombre de usuario: ");
                                                String nuevoUsuario = sc.nextLine();
                                                organizador = nuevoUsuario;
                                                break;
                                            case 2:
                                                System.out.println("Inserte su nueva contraseña: ");
                                                String nuevaContrasenia = sc.nextLine();
                                                contraOrganizador = nuevaContrasenia;
                                                break;
                                            case 3:
                                                System.out.println("Salir.");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta, inténtelo de nuevo.");
                                                break;
                                        }
                                    }while(opcion2 != 3);
                                    break;
                                case 4:
                                    System.out.println("----Cerrar sesión----");
                                    break;
                                default:
                                    System.out.println("Ha seleccionado una opción incorrecta, seleccione (1-4).");
                                    break;
                            }
                        }while (opcion != 4);
                    }

                    //menu administrador
                    if (usuario.equals(administrador)) {
                        do {
                            mainFernan.utilidades.Funciones.menuAdministrador();
                            opcion = Integer.parseInt(sc.nextLine());
                            switch (opcion) {
                                case 1:
                                    do {
                                        System.out.println("----Bienvenido al panel de control----");
                                        System.out.println("1. Bloquear");
                                        System.out.println("2. Desbloquear");
                                        System.out.println("3. Salir");
                                        opcion2 = Integer.parseInt(sc.nextLine());

                                        switch (opcion2) {
                                            case 1:
                                                System.out.println("¿A quién deseas bloquear?");
                                                System.out.println(organizador + ", " + asistente1 + ", " + asistente2);
                                                usuario = sc.nextLine();
                                                if (usuario.equals(organizador)) organizadorBloqueado = true;
                                                if (usuario.equals(asistente1)) asistente1Bloqueado = true;
                                                if (usuario.equals(asistente2)) asistente2Bloqueado = true;
                                                break;
                                            case 2:
                                                System.out.println("¿A quién deseas desbloquear?");
                                                System.out.println(organizador + ", " + asistente1 + ", " + asistente2);
                                                usuario = sc.nextLine();
                                                if (usuario.equals(organizador)) organizadorBloqueado = false;
                                                if (usuario.equals(asistente1)) asistente1Bloqueado = false;
                                                if (usuario.equals(asistente2)) asistente2Bloqueado = false;
                                                break;
                                            case 3:
                                                System.out.println("Saliendo del panel de control");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta. Introduce una opción válida (1-3).");
                                                break;
                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 2:
                                    do {
                                        System.out.println("Bienvenido a tus eventos");
                                        System.out.println("1. Ver eventos.");
                                        System.out.println("2. Editar eventos.");
                                        System.out.println("3. Eliminar eventos.");
                                        System.out.println("4. Salir.");
                                        opcion2 = Integer.parseInt(sc.nextLine());

                                        switch (opcion2){
                                            case 1:
                                                System.out.println("Tus eventos");
                                            break;
                                            case 2:
                                                System.out.println("Editar eventos.");

                                            break;
                                            case 3:
                                                System.out.println("Eliminar eventos.");

                                            break;
                                            case 4:
                                                System.out.println("Saliendo...");
                                            break;
                                            default:
                                                System.out.println("Opción inválida, inserte una opción válida (1-5).");
                                            break;
                                        }
                                    } while (opcion2 != 4);
                                    break;
                                case 3:
                                    do {
                                        aniadir = 0;
                                        retirar = 0;
                                        System.out.println("Bienvenido a tu cartera digital");
                                        System.out.println("Tu saldo actual es de: " + carteraAdministrador);
                                        System.out.println("1. Añadir");
                                        System.out.println("2. Retirar");
                                        System.out.println("3. Salir");
                                        opcion2 = Integer.parseInt(sc.nextLine());
                                        switch (opcion2) {
                                            case 1:
                                                System.out.println("¿Cúanto dinero deseas añadir a tu cartera digital?");
                                                aniadir = Integer.parseInt(sc.nextLine());
                                                carteraAdministrador += aniadir;
                                                break;
                                            case 2:
                                                if (carteraAdministrador == 0) System.out.println("No puedes retirar dinero si está a 0");
                                                else{
                                                    System.out.println("¿Cúanto dinero deseas retirar de tu cartera digital?");
                                                    retirar = Integer.parseInt(sc.nextLine());
                                                    if ((carteraAdministrador - retirar) < 0) System.out.println("No tienes suficiente dinero para retirar");
                                                    else carteraAdministrador -= retirar;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Saliendo de la cartera digital");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta. Introduce una opción válida (1-3).");
                                                break;
                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 4:
                                    do {
                                        System.out.println("Bienvenido a la configuración");
                                        System.out.println("1. Cambiar usuario.");
                                        System.out.println("2. Cambiar contraseña.");
                                        System.out.println("3. Salir.");
                                        opcion2 = Integer.parseInt(sc.nextLine());

                                        switch (opcion2) {
                                            case 1:
                                                System.out.println("Inserte su nuevo nombre de usuario: ");
                                                String nuevoUsuario = sc.nextLine();
                                                administrador = nuevoUsuario;
                                                break;
                                            case 2:
                                                System.out.println("Inserte su nueva contraseña: ");
                                                String nuevaContrasenia = sc.nextLine();
                                                contraAdmin = nuevaContrasenia;
                                                break;
                                            case 3:
                                                System.out.println("Salir.");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta, inténtelo de nuevo.");
                                                break;
                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 5:
                                    System.out.println("Cerrando sesión");
                                    break;
                                default:
                                    System.out.println("Opción incorrecta. Introduce una opción válida (1-5).");
                                    break;
                            }
                        } while (opcion != 5);
                    }

                    //menu asistente1
                    if (usuario.equals(asistente1) && contrasenia.equals(contraAsistente1) && contraseniaCorrecta) {
                        do {
                            mainFernan.utilidades.Funciones.menuAsistente();
                            opcion = Integer.parseInt(sc.nextLine());
                            switch (opcion) {
                                case 1:
                                    System.out.println("Bienvenido a los eventos a los que está inscrito.");
                                break;
                                case 2:

                                    break;
                                case 3:
                                    do {
                                        aniadir = 0;
                                        retirar = 0;
                                        System.out.println("Bienvenido a tu cartera digital");
                                        System.out.println("Tu saldo actual es de: " + carteraAsistente1);
                                        System.out.println("1. Añadir");
                                        System.out.println("2. Retirar");
                                        System.out.println("3. Salir");
                                        opcion2 = Integer.parseInt(sc.nextLine());
                                        switch (opcion2) {
                                            case 1:
                                                System.out.println("¿Cúanto dinero deseas añadir a tu cartera digital?");
                                                aniadir = Integer.parseInt(sc.nextLine());
                                                carteraAsistente1 += aniadir;
                                                break;
                                            case 2:
                                                if (carteraAsistente1 == 0) System.out.println("No puedes retirar dinero si está a 0");
                                                else{
                                                    System.out.println("¿Cúanto dinero deseas retirar de tu cartera digital?");
                                                    retirar = Integer.parseInt(sc.nextLine());
                                                    if ((carteraAsistente1 - retirar) < 0) System.out.println("No tienes suficiente dinero para retirar");
                                                    else carteraAsistente1 -= retirar;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Saliendo de la cartera digital");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta. Introduce una opción válida (1-3).");
                                                break;
                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 4:
                                    do {
                                        System.out.println("Bienvenido a invita a un amigo");
                                        System.out.println("1. Mostrar amigos referidos");
                                        System.out.println("2. Añadir nuevos amigos");
                                        System.out.println("3. Salir");
                                        opcion2 = Integer.parseInt(sc.nextLine());

                                        switch (opcion2) {
                                            case 1:
                                                if (amigosReferidosA1.isEmpty())
                                                    System.out.println("No tienes amigos referidos aún");
                                                else {
                                                    System.out.println("Amigos referidos: ");
                                                    System.out.println(amigosReferidosA1);
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Pon el correo de tu amigo: ");
                                                String correoAmigoA1 = sc.nextLine();
                                                amigosReferidosA1 += correoAmigoA1 + "\n";
                                                System.out.println("Amigo añadido: " + correoAmigoA1);
                                                break;
                                            case 3:
                                                System.out.println("Saliendo de invita a un amigo");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta. Introduce una opción válida (1-3).");
                                                break;

                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 5:
                                    do {
                                        System.out.println("Bienvenido a la configuración");
                                        System.out.println("1. Cambiar usuario.");
                                        System.out.println("2. Cambiar contraseña.");
                                        System.out.println("3. Salir.");
                                        opcion2 = Integer.parseInt(sc.nextLine());

                                        switch (opcion2) {
                                            case 1:
                                                System.out.println("Inserte su nuevo nombre de usuario: ");
                                                String nuevoUsuario = sc.nextLine();
                                                asistente1 = nuevoUsuario;
                                                break;
                                            case 2:
                                                System.out.println("Inserte su nueva contraseña: ");
                                                String nuevaContrasenia = sc.nextLine();
                                                contraAsistente1 = nuevaContrasenia;
                                                break;
                                            case 3:
                                                System.out.println("Salir.");
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta, inténtelo de nuevo.");
                                                break;
                                        }
                                    } while (opcion2 != 3);
                                    break;
                                case 6:
                                    System.out.println("Cerrando sesión");
                                    break;
                            }
                        } while (opcion != 6);
                    }
                    //menu asistente2
                    break;
                case 2:
                    System.out.println("Saliendo de fernanEvents");
                    break;
                default:
                    System.out.println("Opción incorrecta, inténtelo de nuevo.");
                    break;
            }
        }while (opcion != 2);
    }
}