package mainFernan;
import java.util.Scanner;

public class fernanEvents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // probando si funciona github y estamos conectados

        String versionDetallada = "";

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
                            menuOrganizador();
                            opcion = Integer.parseInt(sc.nextLine());

                            switch (opcion){
                                case 1:
                                    System.out.println("----Mis eventos----");
                                    do {
                                        System.out.println("Bienvenido a tus eventos");
                                        System.out.println("1. Ver eventos.");
                                        System.out.println("2. Crear eventos.");
                                        System.out.println("3. Editar eventos.");
                                        System.out.println("4. Eliminar eventos.");
                                        System.out.println("5. Salir.");
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
                                                            if (nombreProyecto1.isEmpty()){
                                                                System.out.println("No has creado un proyecto aún.");
                                                            } else {
                                                                System.out.println("Nombre: " + nombreProyecto1);
                                                                System.out.println("Descripción: " + descripcionProyecto1);
                                                                System.out.println("Categoría: " + categoriaProyecto1);
                                                                System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                                                System.out.println("Aforo: " + aforoProyecto1);
                                                                System.out.println("Número de inscritos: " + inscritosProyecto1);
                                                                if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                                                } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                                                } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                                                } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                                                }
                                                                System.out.println("************************************************");
                                                                System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                                                versionDetallada = sc.nextLine().toLowerCase();
                                                                if (versionDetallada.equals("s")){
                                                                    System.out.println("Nombre: " + nombreProyecto1);
                                                                    System.out.println("Descripción: " + descripcionProyecto1);
                                                                    System.out.println("Categoría: " + categoriaProyecto1);
                                                                    System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                                                    System.out.println("Aforo: " + aforoProyecto1);
                                                                    System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                                                    for (int i = 0; i < 100; i++) {
                                                                        if (i <= formulaGraficoBarrasProyecto1){
                                                                            System.out.print(porcentajeLleno);
                                                                        } else {
                                                                            System.out.print(porcentajeVacio);
                                                                        }
                                                                    }
                                                                    System.out.print("]" + RESET_COLOR);
                                                                    System.out.println("Número de inscritos: " + inscritosProyecto1);
                                                                    System.out.println("Entradas:");
                                                                    System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                                                    System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                                                    System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                                                    System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                                                    if (!tipoEntrada2Proyecto1.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                                                    } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                                                    }
                                                                    if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                                                    }
                                                                } else if (versionDetallada.equals("n")) {
                                                                    System.out.println("Saliendo...");
                                                                } else {
                                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto2.isEmpty()){
                                                                System.out.println("No has creado un proyecto aún.");
                                                            }else {
                                                                System.out.println("Nombre: " + nombreProyecto2);
                                                                System.out.println("Descripción: " + descripcionProyecto2);
                                                                System.out.println("Categoría: " + categoriaProyecto2);
                                                                System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                                                System.out.println("Aforo: " + aforoProyecto2);
                                                                System.out.println("Número de inscritos: " + inscritosProyecto2);
                                                                if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                                                } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                                                } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                                                } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                                                }
                                                                System.out.println("************************************************");
                                                                System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                                                versionDetallada = sc.nextLine().toLowerCase();
                                                                if (versionDetallada.equals("s")){
                                                                    System.out.println("Nombre: " + nombreProyecto2);
                                                                    System.out.println("Descripción: " + descripcionProyecto2);
                                                                    System.out.println("Categoría: " + categoriaProyecto2);
                                                                    System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                                                    System.out.println("Aforo: " + aforoProyecto2);
                                                                    System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                                                    for (int i = 0; i < 100; i++) {
                                                                        if (i <= formulaGraficoBarrasProyecto2){
                                                                            System.out.print(porcentajeLleno);
                                                                        } else {
                                                                            System.out.print(porcentajeVacio);
                                                                        }
                                                                    }
                                                                    System.out.print("]" + RESET_COLOR);
                                                                    System.out.println("Número de inscritos: " + inscritosProyecto2);
                                                                    System.out.println("Entradas:");
                                                                    System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                                                    System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                                                    System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                                                    System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                                                    if (!tipoEntrada2Proyecto2.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                                                    } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                                                    }
                                                                    if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                                                    }
                                                                } else if (versionDetallada.equals("n")) {
                                                                    System.out.println("Saliendo...");
                                                                } else {
                                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto3.isEmpty()){
                                                                System.out.println("No has creado un proyecto aún.");
                                                            }else {
                                                                System.out.println("Nombre: " + nombreProyecto3);
                                                                System.out.println("Descripción: " + descripcionProyecto3);
                                                                System.out.println("Categoría: " + categoriaProyecto3);
                                                                System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                                                System.out.println("Aforo: " + aforoProyecto3);
                                                                System.out.println("Número de inscritos: " + inscritosProyecto3);
                                                                if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                                                } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                                                } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                                                } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                                                }
                                                                System.out.println("************************************************");
                                                                System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                                                versionDetallada = sc.nextLine().toLowerCase();
                                                                if (versionDetallada.equals("s")){
                                                                    System.out.println("Nombre: " + nombreProyecto3);
                                                                    System.out.println("Descripción: " + descripcionProyecto3);
                                                                    System.out.println("Categoría: " + categoriaProyecto3);
                                                                    System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                                                    System.out.println("Aforo: " + aforoProyecto3);
                                                                    System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                                                    for (int i = 0; i < 100; i++) {
                                                                        if (i <= formulaGraficoBarrasProyecto3){
                                                                            System.out.print(porcentajeLleno);
                                                                        } else {
                                                                            System.out.print(porcentajeVacio);
                                                                        }
                                                                    }
                                                                    System.out.print("]" + RESET_COLOR);
                                                                    System.out.println("Número de inscritos: " + inscritosProyecto3);
                                                                    System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                                                    System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                                                    System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                                                    System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                                                    if (!tipoEntrada2Proyecto3.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                                                    } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                                                    }
                                                                    if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                                                    }
                                                                } else if (versionDetallada.equals("n")) {
                                                                    System.out.println("Saliendo...");
                                                                } else {
                                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                }
                                                            }
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
                                                    switch (opcion3){
                                                        case 1:
                                                            if (nombreProyecto1.isEmpty()){
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto1 = sc.nextLine();
                                                                if (nombreProyecto1.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto1 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println("Este proyecto ya está siendo utilizado.");
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto2.isEmpty()){
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto2 = sc.nextLine();
                                                                if (nombreProyecto2.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto2 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }else {
                                                                System.out.println("Este proyecto ya está siendo utilizado.");
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto3.isEmpty()){
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto1 = sc.nextLine();
                                                                if (nombreProyecto1.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto1 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }else {
                                                                System.out.println("Este proyecto ya está siendo utilizado.");
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo . . .");
                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
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
                                                    switch (opcion3){
                                                        case 1:
                                                            if (nombreProyecto1.isEmpty()){
                                                                System.out.println("Para editar un proyecto primero debe crearlo.");
                                                            } else {
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto1 = sc.nextLine();
                                                                if (nombreProyecto1.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto1 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto2.isEmpty()){
                                                                System.out.println("Para editar un proyecto primero debe crearlo.");
                                                            }else {
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto2 = sc.nextLine();
                                                                if (nombreProyecto2.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto2 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto3.isEmpty()){
                                                                System.out.println("Para editar un proyecto primero debe crearlo.");
                                                            }else {
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto1 = sc.nextLine();
                                                                if (nombreProyecto1.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto1 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo . . .");
                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
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

                                                    switch (opcion3){
                                                        case 1:
                                                            if (!nombreProyecto1.isEmpty()){
                                                                nombreProyecto1 = "";
                                                                descripcionProyecto1 = "";
                                                                categoriaProyecto1 = "";
                                                                fechaYHoraProyecto1 = "";
                                                                aforoProyecto1 = 0;
                                                                inscritosProyecto1 = 0;
                                                                tipoEntrada1Proyecto1 = "";
                                                                tipoEntrada1DescripcionProyecto1 = "";
                                                                tipoEntrada1ExistenciasProyecto1 = 0;
                                                                tipoEntrada1PrecioProyecto1 = 0f;
                                                                tipoEntrada2Proyecto1 = "";
                                                                tipoEntrada2DescripcionProyecto1 = "";
                                                                tipoEntrada2ExistenciasProyecto1 = 0;
                                                                tipoEntrada2PrecioProyecto1 = 0f;
                                                                tipoEntrada3Proyecto1 = "";
                                                                tipoEntrada3DescripcionProyecto1 = "";
                                                                tipoEntrada3ExistenciasProyecto1 = 0;
                                                                tipoEntrada3PrecioProyecto1 = 0f;

                                                                System.out.println("Proyecto eliminado.");
                                                            } else {
                                                                System.out.println("Cree un proyecto para eliminarlo.");
                                                            }
                                                            break;
                                                        case 2:
                                                            if (!nombreProyecto2.isEmpty()){
                                                                nombreProyecto2 = "";
                                                                descripcionProyecto2 = "";
                                                                categoriaProyecto2 = "";
                                                                fechaYHoraProyecto2 = "";
                                                                aforoProyecto2 = 0;
                                                                inscritosProyecto2 = 0;
                                                                tipoEntrada1Proyecto2 = "";
                                                                tipoEntrada1DescripcionProyecto2 = "";
                                                                tipoEntrada1ExistenciasProyecto2 = 0;
                                                                tipoEntrada1PrecioProyecto2 = 0f;
                                                                tipoEntrada2Proyecto2 = "";
                                                                tipoEntrada2DescripcionProyecto2 = "";
                                                                tipoEntrada2ExistenciasProyecto2 = 0;
                                                                tipoEntrada2PrecioProyecto2 = 0f;
                                                                tipoEntrada3Proyecto2 = "";
                                                                tipoEntrada3DescripcionProyecto2 = "";
                                                                tipoEntrada3ExistenciasProyecto2 = 0;
                                                                tipoEntrada3PrecioProyecto2 = 0f;

                                                                System.out.println("Proyecto eliminado.");
                                                            } else {
                                                                System.out.println("Cree un proyecto para eliminarlo.");
                                                            }
                                                            break;
                                                        case 3:
                                                            if (!nombreProyecto3.isEmpty()){
                                                                nombreProyecto3 = "";
                                                                descripcionProyecto3 = "";
                                                                categoriaProyecto3 = "";
                                                                fechaYHoraProyecto3 = "";
                                                                aforoProyecto3 = 0;
                                                                inscritosProyecto3 = 0;
                                                                tipoEntrada1Proyecto3 = "";
                                                                tipoEntrada1DescripcionProyecto3 = "";
                                                                tipoEntrada1ExistenciasProyecto3 = 0;
                                                                tipoEntrada1PrecioProyecto3 = 0f;
                                                                tipoEntrada2Proyecto3 = "";
                                                                tipoEntrada2DescripcionProyecto3 = "";
                                                                tipoEntrada2ExistenciasProyecto3 = 0;
                                                                tipoEntrada2PrecioProyecto3 = 0f;
                                                                tipoEntrada3Proyecto3 = "";
                                                                tipoEntrada3DescripcionProyecto3 = "";
                                                                tipoEntrada3ExistenciasProyecto3 = 0;
                                                                tipoEntrada3PrecioProyecto3 = 0f;

                                                                System.out.println("Proyecto eliminado.");
                                                            } else {
                                                                System.out.println("Cree un proyecto para eliminarlo.");
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo . . .");
                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
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
                            menuAdministrador();
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
                                                do {
                                                    System.out.println("¿Qué proyecto quiere ver?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());
                                                    switch (opcion3){
                                                        case 1:
                                                            if (nombreProyecto1.isEmpty()){
                                                                System.out.println("No has creado un proyecto aún.");
                                                            } else {
                                                                System.out.println("Nombre: " + nombreProyecto1);
                                                                System.out.println("Descripción: " + descripcionProyecto1);
                                                                System.out.println("Categoría: " + categoriaProyecto1);
                                                                System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                                                System.out.println("Aforo: " + aforoProyecto1);
                                                                System.out.println("Número de inscritos: " + inscritosProyecto1);
                                                                if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                                                } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                                                } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                                                } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                                                }
                                                                System.out.println("************************************************");
                                                                System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                                                versionDetallada = sc.nextLine().toLowerCase();
                                                                if (versionDetallada.equals("s")){
                                                                    System.out.println("Nombre: " + nombreProyecto1);
                                                                    System.out.println("Descripción: " + descripcionProyecto1);
                                                                    System.out.println("Categoría: " + categoriaProyecto1);
                                                                    System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                                                    System.out.println("Aforo: " + aforoProyecto1);
                                                                    System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                                                    for (int i = 0; i < 100; i++) {
                                                                        if (i <= formulaGraficoBarrasProyecto1){
                                                                            System.out.print(porcentajeLleno);
                                                                        } else {
                                                                            System.out.print(porcentajeVacio);
                                                                        }
                                                                    }
                                                                    System.out.print("]" + RESET_COLOR);
                                                                    System.out.println("Número de inscritos: " + inscritosProyecto1);
                                                                    System.out.println("Entradas:");
                                                                    System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                                                    System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                                                    System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                                                    System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                                                    if (!tipoEntrada2Proyecto1.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                                                    } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                                                    }
                                                                    if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                                                    }
                                                                } else if (versionDetallada.equals("n")) {
                                                                    System.out.println("Saliendo...");
                                                                } else {
                                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto2.isEmpty()){
                                                                System.out.println("No has creado un proyecto aún.");
                                                            }else {
                                                                System.out.println("Nombre: " + nombreProyecto2);
                                                                System.out.println("Descripción: " + descripcionProyecto2);
                                                                System.out.println("Categoría: " + categoriaProyecto2);
                                                                System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                                                System.out.println("Aforo: " + aforoProyecto2);
                                                                System.out.println("Número de inscritos: " + inscritosProyecto2);
                                                                if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                                                } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                                                } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                                                } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                                                }
                                                                System.out.println("************************************************");
                                                                System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                                                versionDetallada = sc.nextLine().toLowerCase();
                                                                if (versionDetallada.equals("s")){
                                                                    System.out.println("Nombre: " + nombreProyecto2);
                                                                    System.out.println("Descripción: " + descripcionProyecto2);
                                                                    System.out.println("Categoría: " + categoriaProyecto2);
                                                                    System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                                                    System.out.println("Aforo: " + aforoProyecto2);
                                                                    System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                                                    for (int i = 0; i < 100; i++) {
                                                                        if (i <= formulaGraficoBarrasProyecto2){
                                                                            System.out.print(porcentajeLleno);
                                                                        } else {
                                                                            System.out.print(porcentajeVacio);
                                                                        }
                                                                    }
                                                                    System.out.print("]" + RESET_COLOR);
                                                                    System.out.println("Número de inscritos: " + inscritosProyecto2);
                                                                    System.out.println("Entradas:");
                                                                    System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                                                    System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                                                    System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                                                    System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                                                    if (!tipoEntrada2Proyecto2.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                                                    } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                                                    }
                                                                    if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                                                    }
                                                                } else if (versionDetallada.equals("n")) {
                                                                    System.out.println("Saliendo...");
                                                                } else {
                                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto3.isEmpty()){
                                                                System.out.println("No has creado un proyecto aún.");
                                                            }else {
                                                                System.out.println("Nombre: " + nombreProyecto3);
                                                                System.out.println("Descripción: " + descripcionProyecto3);
                                                                System.out.println("Categoría: " + categoriaProyecto3);
                                                                System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                                                System.out.println("Aforo: " + aforoProyecto3);
                                                                System.out.println("Número de inscritos: " + inscritosProyecto3);
                                                                if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                                                } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                                                } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                                                } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                                                    System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                                                }
                                                                System.out.println("************************************************");
                                                                System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                                                versionDetallada = sc.nextLine().toLowerCase();
                                                                if (versionDetallada.equals("s")){
                                                                    System.out.println("Nombre: " + nombreProyecto3);
                                                                    System.out.println("Descripción: " + descripcionProyecto3);
                                                                    System.out.println("Categoría: " + categoriaProyecto3);
                                                                    System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                                                    System.out.println("Aforo: " + aforoProyecto3);
                                                                    System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                                                    for (int i = 0; i < 100; i++) {
                                                                        if (i <= formulaGraficoBarrasProyecto3){
                                                                            System.out.print(porcentajeLleno);
                                                                        } else {
                                                                            System.out.print(porcentajeVacio);
                                                                        }
                                                                    }
                                                                    System.out.print("]" + RESET_COLOR);
                                                                    System.out.println("Número de inscritos: " + inscritosProyecto3);
                                                                    System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                                                    System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                                                    System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                                                    System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                                                    if (!tipoEntrada2Proyecto3.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                                                    } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                                                    }
                                                                    if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                                        System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                                        System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                                        System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                                        System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                                        System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                                                    }
                                                                } else if (versionDetallada.equals("n")) {
                                                                    System.out.println("Saliendo...");
                                                                } else {
                                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                }
                                                            }
                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
                                                }while (opcion3 != 4);
                                                break;
                                            case 2:
                                                System.out.println("Editar eventos.");
                                                do {
                                                    System.out.println("¿Qué proyecto quiere editar?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());
                                                    switch (opcion3){
                                                        case 1:
                                                            if (nombreProyecto1.isEmpty()){
                                                                System.out.println("Para editar un proyecto primero debe crearlo.");
                                                            } else {
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto1 = sc.nextLine();
                                                                if (nombreProyecto1.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto1 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto1.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto1 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto1 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto1 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto1 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto1 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto2.isEmpty()){
                                                                System.out.println("Para editar un proyecto primero debe crearlo.");
                                                            }else {
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto2 = sc.nextLine();
                                                                if (nombreProyecto2.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto2 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto2 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto2.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto2 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto2 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto2 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto2 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto2 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto3.isEmpty()){
                                                                System.out.println("Para editar un proyecto primero debe crearlo.");
                                                            }else {
                                                                System.out.println("Inserte un nombre para su evento: ");
                                                                nombreProyecto1 = sc.nextLine();
                                                                if (nombreProyecto1.isEmpty()){
                                                                    System.out.println("Debe insertar un nombre de evento obligatoriamente.");
                                                                } else {
                                                                    System.out.println("Inserte una descripción para su evento: ");
                                                                    descripcionProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una categoría para su evento: ");
                                                                    categoriaProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte una fecha (DD/MM/AAAA) y hora (HH:MM) para su evento: ");
                                                                    fechaYHoraProyecto1 = sc.nextLine();
                                                                    System.out.println("Inserte un aforo máximo para su evento: ");
                                                                    aforoProyecto1 = Integer.parseInt(sc.nextLine());
                                                                    System.out.println("¿Cuántos tipos de entradas vas a ofrecer? (1,2 o 3)");
                                                                    int opcionEntradas = Integer.parseInt(sc.nextLine());
                                                                    switch (opcionEntradas){
                                                                        case 1:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            while (tipoEntrada1Proyecto3.isEmpty()){
                                                                                System.out.println("Debe haber al menos un tipo de entrada.");
                                                                                System.out.println("Inserte un tipo de entrada: ");
                                                                                tipoEntrada1Proyecto3 = sc.nextLine();
                                                                            }
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada1DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada1ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada1PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada2Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada2DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada2ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada2PrecioProyecto3 = Float.parseFloat(sc.nextLine());

                                                                            System.out.println("Inserte un tipo de entrada: ");
                                                                            tipoEntrada3Proyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte una descripción para este tipo de entrada:");
                                                                            tipoEntrada3DescripcionProyecto3 = sc.nextLine();
                                                                            System.out.println("Inserte un número de entradas para las entradas: ");
                                                                            tipoEntrada3ExistenciasProyecto3 = Integer.parseInt(sc.nextLine());
                                                                            System.out.println("Inserte un precio para este tipo de entrada: ");
                                                                            tipoEntrada3PrecioProyecto3 = Float.parseFloat(sc.nextLine());
                                                                            break;
                                                                        default:
                                                                            System.out.println("Inválido, inténtelo de nuevo (1-3).");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo . . .");
                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
                                                }while (opcion3 != 4);
                                                break;
                                            case 3:
                                                System.out.println("Eliminar eventos.");
                                                do {
                                                    System.out.println("¿Qué evento quiere eliminar?");
                                                    System.out.println("1. Proyecto 1 " + nombreProyecto1 + ".");
                                                    System.out.println("2. Proyecto 2 " + nombreProyecto2 + ".");
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto3 + ".");
                                                    System.out.println("4. Salir.");
                                                    opcion3 = Integer.parseInt(sc.nextLine());

                                                    switch (opcion3){
                                                        case 1:
                                                            if (!nombreProyecto1.isEmpty()){
                                                                nombreProyecto1 = "";
                                                                descripcionProyecto1 = "";
                                                                categoriaProyecto1 = "";
                                                                fechaYHoraProyecto1 = "";
                                                                aforoProyecto1 = 0;
                                                                inscritosProyecto1 = 0;
                                                                tipoEntrada1Proyecto1 = "";
                                                                tipoEntrada1DescripcionProyecto1 = "";
                                                                tipoEntrada1ExistenciasProyecto1 = 0;
                                                                tipoEntrada1PrecioProyecto1 = 0f;
                                                                tipoEntrada2Proyecto1 = "";
                                                                tipoEntrada2DescripcionProyecto1 = "";
                                                                tipoEntrada2ExistenciasProyecto1 = 0;
                                                                tipoEntrada2PrecioProyecto1 = 0f;
                                                                tipoEntrada3Proyecto1 = "";
                                                                tipoEntrada3DescripcionProyecto1 = "";
                                                                tipoEntrada3ExistenciasProyecto1 = 0;
                                                                tipoEntrada3PrecioProyecto1 = 0f;

                                                                System.out.println("Proyecto eliminado.");
                                                            } else {
                                                                System.out.println("Cree un proyecto para eliminarlo.");
                                                            }
                                                            break;
                                                        case 2:
                                                            if (!nombreProyecto2.isEmpty()){
                                                                nombreProyecto2 = "";
                                                                descripcionProyecto2 = "";
                                                                categoriaProyecto2 = "";
                                                                fechaYHoraProyecto2 = "";
                                                                aforoProyecto2 = 0;
                                                                inscritosProyecto2 = 0;
                                                                tipoEntrada1Proyecto2 = "";
                                                                tipoEntrada1DescripcionProyecto2 = "";
                                                                tipoEntrada1ExistenciasProyecto2 = 0;
                                                                tipoEntrada1PrecioProyecto2 = 0f;
                                                                tipoEntrada2Proyecto2 = "";
                                                                tipoEntrada2DescripcionProyecto2 = "";
                                                                tipoEntrada2ExistenciasProyecto2 = 0;
                                                                tipoEntrada2PrecioProyecto2 = 0f;
                                                                tipoEntrada3Proyecto2 = "";
                                                                tipoEntrada3DescripcionProyecto2 = "";
                                                                tipoEntrada3ExistenciasProyecto2 = 0;
                                                                tipoEntrada3PrecioProyecto2 = 0f;

                                                                System.out.println("Proyecto eliminado.");
                                                            } else {
                                                                System.out.println("Cree un proyecto para eliminarlo.");
                                                            }
                                                            break;
                                                        case 3:
                                                            if (!nombreProyecto3.isEmpty()){
                                                                nombreProyecto3 = "";
                                                                descripcionProyecto3 = "";
                                                                categoriaProyecto3 = "";
                                                                fechaYHoraProyecto3 = "";
                                                                aforoProyecto3 = 0;
                                                                inscritosProyecto3 = 0;
                                                                tipoEntrada1Proyecto3 = "";
                                                                tipoEntrada1DescripcionProyecto3 = "";
                                                                tipoEntrada1ExistenciasProyecto3 = 0;
                                                                tipoEntrada1PrecioProyecto3 = 0f;
                                                                tipoEntrada2Proyecto3 = "";
                                                                tipoEntrada2DescripcionProyecto3 = "";
                                                                tipoEntrada2ExistenciasProyecto3 = 0;
                                                                tipoEntrada2PrecioProyecto3 = 0f;
                                                                tipoEntrada3Proyecto3 = "";
                                                                tipoEntrada3DescripcionProyecto3 = "";
                                                                tipoEntrada3ExistenciasProyecto3 = 0;
                                                                tipoEntrada3PrecioProyecto3 = 0f;

                                                                System.out.println("Proyecto eliminado.");
                                                            } else {
                                                                System.out.println("Cree un proyecto para eliminarlo.");
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo . . .");
                                                            break;
                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            break;
                                                    }
                                                }while (opcion3 != 4);
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
                            menuAsistente();
                            opcion = Integer.parseInt(sc.nextLine());

                            switch (opcion) {
                                case 1:
                                    System.out.println("Bienvenido a los eventos a los que está inscrito.");
                                    if (asistente1InscritoProyecto1 && !asistente1InscritoProyecto2 && !asistente1InscritoProyecto3){
                                        // solo inscrito en proyecto 1
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (!asistente1InscritoProyecto1 && asistente1InscritoProyecto2 && !asistente1InscritoProyecto3) {
                                        // solo inscrito en proyecto 2
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (!asistente1InscritoProyecto1 && !asistente1InscritoProyecto2 && asistente1InscritoProyecto3) {
                                        // solo inscrito en proyecto 3
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (asistente1InscritoProyecto1 && asistente1InscritoProyecto2 && !asistente1InscritoProyecto3) {
                                        // inscrito en proyecto 1 y 2
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (asistente1InscritoProyecto1 && !asistente1InscritoProyecto2 && asistente1InscritoProyecto3) {
                                        // inscrito en proyecto 1 y 3
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (!asistente1InscritoProyecto1 && asistente1InscritoProyecto2 && asistente1InscritoProyecto3) {
                                        // inscrito en proyecto 2 y 3
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Bienvenido a los eventos");
                                    System.out.println("Estos son los eventos creados hasta el momento: ");
                                    if (!nombreProyecto1.isEmpty() && nombreProyecto2.isEmpty() && nombreProyecto3.isEmpty()){
                                        //solo proyecto 1
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                        String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                        if (asistenteInscribeEnProyecto.equals("s")){
                                            System.out.println("Se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = true;
                                            entrada = false;
                                            seguirComprando = true;

                                            do {
                                                System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                System.out.println("1. " + tipoEntrada1Proyecto1 + " - " + tipoEntrada1PrecioProyecto1 + "€ (" + tipoEntrada1ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("2. " + tipoEntrada2Proyecto1 + " - " + tipoEntrada2PrecioProyecto1 + "€ (" + tipoEntrada2ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("3. " + tipoEntrada3Proyecto1 + " - " + tipoEntrada3PrecioProyecto1 + "€ (" + tipoEntrada3ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("4. Terminar compras");

                                                opcionEntrada = Integer.parseInt(sc.nextLine());
                                                entrada = true;

                                                switch (opcionEntrada) {
                                                    case 1:
                                                        nombreEntradaAsistente1 = tipoEntrada1Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada1PrecioProyecto1;
                                                        if (tipoEntrada1ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad1 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad1 > tipoEntrada1ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                        double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago1) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago1;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada1ExistenciasProyecto1 -= cantidad1;
                                                        inscritosProyecto1 += cantidad1;

                                                        System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago1 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 2:
                                                        nombreEntradaAsistente1 = tipoEntrada2Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada2PrecioProyecto1;
                                                        if (tipoEntrada2ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad2 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad2 > tipoEntrada2ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                        double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago2) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago2;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada2ExistenciasProyecto1 -= cantidad2;
                                                        inscritosProyecto1 += cantidad2;

                                                        System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago2 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 3:
                                                        nombreEntradaAsistente1 = tipoEntrada3Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada3PrecioProyecto1;
                                                        if (tipoEntrada3ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad3 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad3 > tipoEntrada3ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                        double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago3) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago3;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada3ExistenciasProyecto1 -= cantidad3;
                                                        inscritosProyecto1 += cantidad3;

                                                        System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago3 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 4:
                                                        System.out.println("Has terminado de comprar entradas.");
                                                        seguirComprando = false;
                                                        break;

                                                    default:
                                                        System.out.println("Opción inválida.");
                                                        entrada = false;
                                                        break;
                                                }

                                            } while (seguirComprando);
                                        }else{
                                            System.out.println("No se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = false;
                                        }
                                    } else if (!nombreProyecto1.isEmpty() && !nombreProyecto2.isEmpty() && nombreProyecto3.isEmpty()){
                                        //proyecto 1 y 2
                                        //proyecto 1
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                        String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                        if (asistenteInscribeEnProyecto.equals("s")){
                                            System.out.println("Se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = true;
                                            entrada = false;
                                            seguirComprando = true;

                                            do {
                                                System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                System.out.println("1. " + tipoEntrada1Proyecto1 + " - " + tipoEntrada1PrecioProyecto1 + "€ (" + tipoEntrada1ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("2. " + tipoEntrada2Proyecto1 + " - " + tipoEntrada2PrecioProyecto1 + "€ (" + tipoEntrada2ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("3. " + tipoEntrada3Proyecto1 + " - " + tipoEntrada3PrecioProyecto1 + "€ (" + tipoEntrada3ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("4. Terminar compras");

                                                opcionEntrada = Integer.parseInt(sc.nextLine());
                                                entrada = true;

                                                switch (opcionEntrada) {
                                                    case 1:
                                                        nombreEntradaAsistente1 = tipoEntrada1Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada1PrecioProyecto1;
                                                        if (tipoEntrada1ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad1 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad1 > tipoEntrada1ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                        double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago1) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago1;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada1ExistenciasProyecto1 -= cantidad1;
                                                        inscritosProyecto1 += cantidad1;

                                                        System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago1 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 2:
                                                        nombreEntradaAsistente1 = tipoEntrada2Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada2PrecioProyecto1;
                                                        if (tipoEntrada2ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad2 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad2 > tipoEntrada2ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                        double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago2) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago2;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada2ExistenciasProyecto1 -= cantidad2;
                                                        inscritosProyecto1 += cantidad2;

                                                        System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago2 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 3:
                                                        nombreEntradaAsistente1 = tipoEntrada3Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada3PrecioProyecto1;
                                                        if (tipoEntrada3ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad3 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad3 > tipoEntrada3ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                        double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago3) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago3;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada3ExistenciasProyecto1 -= cantidad3;
                                                        inscritosProyecto1 += cantidad3;

                                                        System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago3 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 4:
                                                        System.out.println("Has terminado de comprar entradas.");
                                                        seguirComprando = false;
                                                        break;

                                                    default:
                                                        System.out.println("Opción inválida.");
                                                        entrada = false;
                                                        break;
                                                }

                                            } while (seguirComprando);
                                        }else{
                                            System.out.println("No se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = false;
                                        }
                                        //proyecto 2
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto2 + " - " + tipoEntrada1PrecioProyecto2 + "€ (" + tipoEntrada1ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto2 + " - " + tipoEntrada2PrecioProyecto2 + "€ (" + tipoEntrada2ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto2 + " - " + tipoEntrada3PrecioProyecto2 + "€ (" + tipoEntrada3ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto2;
                                                            if (tipoEntrada1ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto2 -= cantidad1;
                                                            inscritosProyecto2 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto2;
                                                            if (tipoEntrada2ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto2 -= cantidad2;
                                                            inscritosProyecto2 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto2;
                                                            if (tipoEntrada3ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto2 -= cantidad3;
                                                            inscritosProyecto2 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (!nombreProyecto1.isEmpty() && !nombreProyecto2.isEmpty() && !nombreProyecto3.isEmpty()) {
                                        // proyecto 1 2 y 3
                                        // proyecto 1
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                        String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                        if (asistenteInscribeEnProyecto.equals("s")){
                                            System.out.println("Se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = true;
                                            entrada = false;
                                            seguirComprando = true;

                                            do {
                                                System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                System.out.println("1. " + tipoEntrada1Proyecto1 + " - " + tipoEntrada1PrecioProyecto1 + "€ (" + tipoEntrada1ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("2. " + tipoEntrada2Proyecto1 + " - " + tipoEntrada2PrecioProyecto1 + "€ (" + tipoEntrada2ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("3. " + tipoEntrada3Proyecto1 + " - " + tipoEntrada3PrecioProyecto1 + "€ (" + tipoEntrada3ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("4. Terminar compras");

                                                opcionEntrada = Integer.parseInt(sc.nextLine());
                                                entrada = true;

                                                switch (opcionEntrada) {
                                                    case 1:
                                                        nombreEntradaAsistente1 = tipoEntrada1Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada1PrecioProyecto1;
                                                        if (tipoEntrada1ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad1 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad1 > tipoEntrada1ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                        double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago1) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago1;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada1ExistenciasProyecto1 -= cantidad1;
                                                        inscritosProyecto1 += cantidad1;

                                                        System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago1 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 2:
                                                        nombreEntradaAsistente1 = tipoEntrada2Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada2PrecioProyecto1;
                                                        if (tipoEntrada2ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad2 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad2 > tipoEntrada2ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                        double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago2) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago2;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada2ExistenciasProyecto1 -= cantidad2;
                                                        inscritosProyecto1 += cantidad2;

                                                        System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago2 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 3:
                                                        nombreEntradaAsistente1 = tipoEntrada3Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada3PrecioProyecto1;
                                                        if (tipoEntrada3ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad3 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad3 > tipoEntrada3ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                        double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago3) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago3;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada3ExistenciasProyecto1 -= cantidad3;
                                                        inscritosProyecto1 += cantidad3;

                                                        System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago3 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 4:
                                                        System.out.println("Has terminado de comprar entradas.");
                                                        seguirComprando = false;
                                                        break;

                                                    default:
                                                        System.out.println("Opción inválida.");
                                                        entrada = false;
                                                        break;
                                                }

                                            } while (seguirComprando);
                                        }else{
                                            System.out.println("No se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = false;
                                        }
                                        // proyecto 2
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto2 + " - " + tipoEntrada1PrecioProyecto2 + "€ (" + tipoEntrada1ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto2 + " - " + tipoEntrada2PrecioProyecto2 + "€ (" + tipoEntrada2ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto2 + " - " + tipoEntrada3PrecioProyecto2 + "€ (" + tipoEntrada3ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto2;
                                                            if (tipoEntrada1ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto2 -= cantidad1;
                                                            inscritosProyecto2 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto2;
                                                            if (tipoEntrada2ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto2 -= cantidad2;
                                                            inscritosProyecto2 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto2;
                                                            if (tipoEntrada3ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto2 -= cantidad3;
                                                            inscritosProyecto2 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        // proyecto 3
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto3 + " - " + tipoEntrada1PrecioProyecto3 + "€ (" + tipoEntrada1ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto3 + " - " + tipoEntrada2PrecioProyecto3 + "€ (" + tipoEntrada2ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto3 + " - " + tipoEntrada3PrecioProyecto3 + "€ (" + tipoEntrada3ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto3;
                                                            if (tipoEntrada1ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto3 -= cantidad1;
                                                            inscritosProyecto3 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto3;
                                                            if (tipoEntrada2ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto3 -= cantidad2;
                                                            inscritosProyecto3 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto3;
                                                            if (tipoEntrada3ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto3 -= cantidad3;
                                                            inscritosProyecto3 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (nombreProyecto1.isEmpty() && !nombreProyecto2.isEmpty() && nombreProyecto3.isEmpty()) {
                                        // solo proyecto 2
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto2 + " - " + tipoEntrada1PrecioProyecto2 + "€ (" + tipoEntrada1ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto2 + " - " + tipoEntrada2PrecioProyecto2 + "€ (" + tipoEntrada2ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto2 + " - " + tipoEntrada3PrecioProyecto2 + "€ (" + tipoEntrada3ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto2;
                                                            if (tipoEntrada1ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto2 -= cantidad1;
                                                            inscritosProyecto2 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto2;
                                                            if (tipoEntrada2ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto2 -= cantidad2;
                                                            inscritosProyecto2 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto2;
                                                            if (tipoEntrada3ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto2 -= cantidad3;
                                                            inscritosProyecto2 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (nombreProyecto1.isEmpty() && nombreProyecto2.isEmpty() && !nombreProyecto3.isEmpty()){
                                        // solo proyecto 3
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto3 + " - " + tipoEntrada1PrecioProyecto3 + "€ (" + tipoEntrada1ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto3 + " - " + tipoEntrada2PrecioProyecto3 + "€ (" + tipoEntrada2ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto3 + " - " + tipoEntrada3PrecioProyecto3 + "€ (" + tipoEntrada3ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto3;
                                                            if (tipoEntrada1ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto3 -= cantidad1;
                                                            inscritosProyecto3 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto3;
                                                            if (tipoEntrada2ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto3 -= cantidad2;
                                                            inscritosProyecto3 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto3;
                                                            if (tipoEntrada3ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto3 -= cantidad3;
                                                            inscritosProyecto3 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (!nombreProyecto1.isEmpty() && nombreProyecto2.isEmpty() && !nombreProyecto3.isEmpty()) {
                                        // proyecto 1 y 3
                                        // proyecto 1
                                        System.out.println("Evento " + "''" + nombreProyecto1 + "''");
                                        System.out.println("Nombre: " + nombreProyecto1);
                                        System.out.println("Descripción: " + descripcionProyecto1);
                                        System.out.println("Categoría: " + categoriaProyecto1);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                        System.out.println("Aforo: " + aforoProyecto1);
                                        System.out.println("Número de inscritos: " + inscritosProyecto1);
                                        if (tipoEntrada2Proyecto1.isEmpty() && tipoEntrada3Proyecto1.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1);
                                        } else if (tipoEntrada2Proyecto1.isEmpty() && (!tipoEntrada3Proyecto1.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && tipoEntrada3Proyecto1.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + " y " + tipoEntrada2Proyecto1);
                                        } else if ((!tipoEntrada2Proyecto1.isEmpty()) && (!tipoEntrada3Proyecto1.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto1 + ", " + tipoEntrada2Proyecto1 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto1);
                                            System.out.println("Descripción: " + descripcionProyecto1);
                                            System.out.println("Categoría: " + categoriaProyecto1);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto1);
                                            System.out.println("Aforo: " + aforoProyecto1);
                                            System.out.print(formulaGraficoBarrasProyecto1 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto1){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto1);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto1 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto1);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto1);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto1 + "€.");
                                            if (!tipoEntrada2Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");
                                            } else if (!tipoEntrada3Proyecto1.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto1.isEmpty() && !tipoEntrada3Proyecto1.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto1 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto1 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto1);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto1);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto1 + "€.");
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                        String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                        if (asistenteInscribeEnProyecto.equals("s")){
                                            System.out.println("Se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = true;
                                            entrada = false;
                                            seguirComprando = true;

                                            do {
                                                System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                System.out.println("1. " + tipoEntrada1Proyecto1 + " - " + tipoEntrada1PrecioProyecto1 + "€ (" + tipoEntrada1ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("2. " + tipoEntrada2Proyecto1 + " - " + tipoEntrada2PrecioProyecto1 + "€ (" + tipoEntrada2ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("3. " + tipoEntrada3Proyecto1 + " - " + tipoEntrada3PrecioProyecto1 + "€ (" + tipoEntrada3ExistenciasProyecto1 + " disponibles)");
                                                System.out.println("4. Terminar compras");

                                                opcionEntrada = Integer.parseInt(sc.nextLine());
                                                entrada = true;

                                                switch (opcionEntrada) {
                                                    case 1:
                                                        nombreEntradaAsistente1 = tipoEntrada1Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada1PrecioProyecto1;
                                                        if (tipoEntrada1ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad1 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad1 > tipoEntrada1ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                        double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago1) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago1;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada1ExistenciasProyecto1 -= cantidad1;
                                                        inscritosProyecto1 += cantidad1;

                                                        System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago1 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 2:
                                                        nombreEntradaAsistente1 = tipoEntrada2Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada2PrecioProyecto1;
                                                        if (tipoEntrada2ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad2 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad2 > tipoEntrada2ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                        double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago2) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago2;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada2ExistenciasProyecto1 -= cantidad2;
                                                        inscritosProyecto1 += cantidad2;

                                                        System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago2 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 3:
                                                        nombreEntradaAsistente1 = tipoEntrada3Proyecto1;
                                                        precioEntradaSeleccionada = tipoEntrada3PrecioProyecto1;
                                                        if (tipoEntrada3ExistenciasProyecto1 <= 0) {
                                                            System.out.println("No quedan entradas de este tipo.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        System.out.print("¿Cuántas entradas desea comprar? ");
                                                        int cantidad3 = Integer.parseInt(sc.nextLine());
                                                        if (cantidad3 > tipoEntrada3ExistenciasProyecto1) {
                                                            System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto1);
                                                            entrada = false;
                                                            break;
                                                        }

                                                        comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                        double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                        if (carteraAsistente1 < totalPago3) {
                                                            System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                            entrada = false;
                                                            break;
                                                        }

                                                        carteraAsistente1 -= totalPago3;
                                                        carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                        carteraAdministrador += comisionAdministrador;
                                                        tipoEntrada3ExistenciasProyecto1 -= cantidad3;
                                                        inscritosProyecto1 += cantidad3;

                                                        System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                        System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                        System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                        System.out.println("Total pagado: " + totalPago3 + "€");
                                                        System.out.println("¡Gracias por tu compra!");
                                                        break;

                                                    case 4:
                                                        System.out.println("Has terminado de comprar entradas.");
                                                        seguirComprando = false;
                                                        break;

                                                    default:
                                                        System.out.println("Opción inválida.");
                                                        entrada = false;
                                                        break;
                                                }

                                            } while (seguirComprando);
                                        }else{
                                            System.out.println("No se ha inscrito en este evento.");
                                            asistente1InscritoProyecto1 = false;
                                        }
                                        // proyecto 3
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto3 + " - " + tipoEntrada1PrecioProyecto3 + "€ (" + tipoEntrada1ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto3 + " - " + tipoEntrada2PrecioProyecto3 + "€ (" + tipoEntrada2ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto3 + " - " + tipoEntrada3PrecioProyecto3 + "€ (" + tipoEntrada3ExistenciasProyecto3 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto3;
                                                            if (tipoEntrada1ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto3 -= cantidad1;
                                                            inscritosProyecto3 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto3;
                                                            if (tipoEntrada2ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto3 -= cantidad2;
                                                            inscritosProyecto3 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto3;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto3;
                                                            if (tipoEntrada3ExistenciasProyecto3 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto3) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto3);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto3 -= cantidad3;
                                                            inscritosProyecto3 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else if (nombreProyecto1.isEmpty() && !nombreProyecto2.isEmpty() && !nombreProyecto3.isEmpty()) {
                                        //proyecto 2 y 3
                                        // proyecto 2
                                        System.out.println("Nombre: " + nombreProyecto2);
                                        System.out.println("Descripción: " + descripcionProyecto2);
                                        System.out.println("Categoría: " + categoriaProyecto2);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                        System.out.println("Aforo: " + aforoProyecto2);
                                        System.out.println("Número de inscritos: " + inscritosProyecto2);
                                        if (tipoEntrada2Proyecto2.isEmpty() && tipoEntrada3Proyecto2.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2);
                                        } else if (tipoEntrada2Proyecto2.isEmpty() && (!tipoEntrada3Proyecto2.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada3Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && tipoEntrada3Proyecto2.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + " y " + tipoEntrada2Proyecto2);
                                        } else if ((!tipoEntrada2Proyecto2.isEmpty()) && (!tipoEntrada3Proyecto2.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto2 + ", " + tipoEntrada2Proyecto2 + " y " + tipoEntrada3Proyecto1);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto2);
                                            System.out.println("Descripción: " + descripcionProyecto2);
                                            System.out.println("Categoría: " + categoriaProyecto2);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto2);
                                            System.out.println("Aforo: " + aforoProyecto2);
                                            System.out.print(formulaGraficoBarrasProyecto2 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto2){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto2);
                                            System.out.println("Entradas:");
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto2 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto2);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto2);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto2 + "€.");
                                            if (!tipoEntrada2Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");
                                            } else if (!tipoEntrada3Proyecto2.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto2.isEmpty() && !tipoEntrada3Proyecto2.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto2 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto2 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto2);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto2);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto2 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = true;
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto2 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                        //proyecto 3
                                        System.out.println("Nombre: " + nombreProyecto3);
                                        System.out.println("Descripción: " + descripcionProyecto3);
                                        System.out.println("Categoría: " + categoriaProyecto3);
                                        System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                        System.out.println("Aforo: " + aforoProyecto3);
                                        System.out.println("Número de inscritos: " + inscritosProyecto3);
                                        if (tipoEntrada2Proyecto3.isEmpty() && tipoEntrada3Proyecto3.isEmpty()){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3);
                                        } else if (tipoEntrada2Proyecto3.isEmpty() && (!tipoEntrada3Proyecto3.isEmpty())){
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && tipoEntrada3Proyecto3.isEmpty()) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + " y " + tipoEntrada2Proyecto3);
                                        } else if ((!tipoEntrada2Proyecto3.isEmpty()) && (!tipoEntrada3Proyecto3.isEmpty())) {
                                            System.out.println("Tipo de entradas: " + tipoEntrada1Proyecto3 + ", " + tipoEntrada2Proyecto3 + " y " + tipoEntrada3Proyecto3);
                                        }
                                        System.out.println("************************************************");
                                        System.out.println("¿Quiere ver la versión detallada? (S/N)");
                                        versionDetallada = sc.nextLine().toLowerCase();
                                        if (versionDetallada.equals("s")){
                                            System.out.println("Nombre: " + nombreProyecto3);
                                            System.out.println("Descripción: " + descripcionProyecto3);
                                            System.out.println("Categoría: " + categoriaProyecto3);
                                            System.out.println("Fecha y Hora: " + fechaYHoraProyecto3);
                                            System.out.println("Aforo: " + aforoProyecto3);
                                            System.out.print(formulaGraficoBarrasProyecto3 + "% [");
                                            for (int i = 0; i < 100; i++) {
                                                if (i <= formulaGraficoBarrasProyecto3){
                                                    System.out.print(porcentajeLleno);
                                                } else {
                                                    System.out.print(porcentajeVacio);
                                                }
                                            }
                                            System.out.print("]" + RESET_COLOR);
                                            System.out.println("Número de inscritos: " + inscritosProyecto3);
                                            System.out.println("Tipo de entrada " + tipoEntrada1Proyecto3 + ": ");
                                            System.out.println("Descripción: " + tipoEntrada1DescripcionProyecto3);
                                            System.out.println("Número de entradas: " + tipoEntrada1ExistenciasProyecto3);
                                            System.out.println("Precio: " + tipoEntrada1PrecioProyecto3 + "€.");
                                            if (!tipoEntrada2Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");
                                            } else if (!tipoEntrada3Proyecto3.isEmpty()) {
                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            if (!tipoEntrada2Proyecto3.isEmpty() && !tipoEntrada3Proyecto3.isEmpty()){
                                                System.out.println("Tipo de entrada " + tipoEntrada2Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada2DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada2ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada2PrecioProyecto3 + "€.");

                                                System.out.println("Tipo de entrada " + tipoEntrada3Proyecto3 + ": ");
                                                System.out.println("Descripción: " + tipoEntrada3DescripcionProyecto3);
                                                System.out.println("Número de entradas: " + tipoEntrada3ExistenciasProyecto3);
                                                System.out.println("Precio: " + tipoEntrada3PrecioProyecto3 + "€.");
                                            }
                                            System.out.println("¿Quiere inscribirse en este evento? (S/N)");
                                            String asistenteInscribeEnProyecto = sc.nextLine().toLowerCase();
                                            if (asistenteInscribeEnProyecto.equals("s")){
                                                System.out.println("Se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = true;
                                                entrada = false;
                                                seguirComprando = true;

                                                do {
                                                    System.out.println("\nSeleccione el tipo de entrada que desea comprar:");
                                                    System.out.println("1. " + tipoEntrada1Proyecto2 + " - " + tipoEntrada1PrecioProyecto2 + "€ (" + tipoEntrada1ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("2. " + tipoEntrada2Proyecto2 + " - " + tipoEntrada2PrecioProyecto2 + "€ (" + tipoEntrada2ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("3. " + tipoEntrada3Proyecto2 + " - " + tipoEntrada3PrecioProyecto2 + "€ (" + tipoEntrada3ExistenciasProyecto2 + " disponibles)");
                                                    System.out.println("4. Terminar compras");

                                                    opcionEntrada = Integer.parseInt(sc.nextLine());
                                                    entrada = true;

                                                    switch (opcionEntrada) {
                                                        case 1:
                                                            nombreEntradaAsistente1 = tipoEntrada1Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada1PrecioProyecto2;
                                                            if (tipoEntrada1ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad1 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad1 > tipoEntrada1ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada1ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad1;
                                                            double totalPago1 = (precioEntradaSeleccionada * cantidad1) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago1) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago1 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago1;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad1;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada1ExistenciasProyecto2 -= cantidad1;
                                                            inscritosProyecto2 += cantidad1;

                                                            System.out.println("Entradas adquiridas: " + cantidad1 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad1) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago1 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 2:
                                                            nombreEntradaAsistente1 = tipoEntrada2Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada2PrecioProyecto2;
                                                            if (tipoEntrada2ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad2 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad2 > tipoEntrada2ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada2ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad2;
                                                            double totalPago2 = (precioEntradaSeleccionada * cantidad2) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago2) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago2 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago2;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad2;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada2ExistenciasProyecto2 -= cantidad2;
                                                            inscritosProyecto2 += cantidad2;

                                                            System.out.println("Entradas adquiridas: " + cantidad2 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad2) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago2 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 3:
                                                            nombreEntradaAsistente1 = tipoEntrada3Proyecto2;
                                                            precioEntradaSeleccionada = tipoEntrada3PrecioProyecto2;
                                                            if (tipoEntrada3ExistenciasProyecto2 <= 0) {
                                                                System.out.println("No quedan entradas de este tipo.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            System.out.print("¿Cuántas entradas desea comprar? ");
                                                            int cantidad3 = Integer.parseInt(sc.nextLine());
                                                            if (cantidad3 > tipoEntrada3ExistenciasProyecto2) {
                                                                System.out.println("No hay suficientes entradas disponibles. Solo quedan " + tipoEntrada3ExistenciasProyecto2);
                                                                entrada = false;
                                                                break;
                                                            }

                                                            comisionAdministrador = precioEntradaSeleccionada * 0.10f * cantidad3;
                                                            double totalPago3 = (precioEntradaSeleccionada * cantidad3) + comisionAdministrador;

                                                            if (carteraAsistente1 < totalPago3) {
                                                                System.out.println("Saldo insuficiente. Necesitas " + totalPago3 + "€.");
                                                                entrada = false;
                                                                break;
                                                            }

                                                            carteraAsistente1 -= totalPago3;
                                                            carteraOrganizador += precioEntradaSeleccionada * cantidad3;
                                                            carteraAdministrador += comisionAdministrador;
                                                            tipoEntrada3ExistenciasProyecto2 -= cantidad3;
                                                            inscritosProyecto2 += cantidad3;

                                                            System.out.println("Entradas adquiridas: " + cantidad3 + " x " + nombreEntradaAsistente1);
                                                            System.out.println("Precio base: " + (precioEntradaSeleccionada * cantidad3) + "€");
                                                            System.out.println("Comisión del 10%: " + comisionAdministrador + "€");
                                                            System.out.println("Total pagado: " + totalPago3 + "€");
                                                            System.out.println("¡Gracias por tu compra!");
                                                            break;

                                                        case 4:
                                                            System.out.println("Has terminado de comprar entradas.");
                                                            seguirComprando = false;
                                                            break;

                                                        default:
                                                            System.out.println("Opción inválida.");
                                                            entrada = false;
                                                            break;
                                                    }

                                                } while (seguirComprando);
                                            }else{
                                                System.out.println("No se ha inscrito en este evento.");
                                                asistente1InscritoProyecto3 = false;
                                            }
                                        } else if (versionDetallada.equals("n")) {
                                            System.out.println("Saliendo...");
                                        } else {
                                            System.out.println("Opción inválida, inténtelo de nuevo.");
                                        }
                                    } else {
                                        System.out.println("No hay ningún evento creado aún.");
                                    }
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

    public static void menuOrganizador(){
        final String AZUL = "\u001B[34m";
        final String RESET_COLOR = "\u001B[0m";

        System.out.println(AZUL + "----Menú Organizador----" + RESET_COLOR);
        System.out.println("1. Mis Eventos.");
        System.out.println("2. Cartera Digital.");
        System.out.println("3. Configuración.");
        System.out.println("4. Cerrar Sesión");
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

}