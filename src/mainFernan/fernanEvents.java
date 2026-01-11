package mainFernan;
import java.util.Scanner;

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
        usuarios[1][5] = "0";
        usuarios[1][6] = "101";

        usuarios[2][0] = "asistente1";
        usuarios[2][1] = "1234a1";
        usuarios[2][2] = "ASISTENTE";
        usuarios[2][3] = "false";
        usuarios[2][4] = "true";
        usuarios[2][5] = "0";
        usuarios[2][6] = "102";

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

        String[][] eventos = new String[19][23];
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


        String[] invitados = new String[10];
        String[] eventosCompradosAsistente = new String[eventos.length];

        int eleccionUsuario;
        int usuarioRegistrado = -1;

        //LOGIN

        int opcion;
        int idEvento = 22;
        int idUsuario = 0;


        do {
            System.out.println("1. Crear usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    mainFernan.utilidades.Funciones.crearUsuario(usuarios);
                    break;

                case 2:
                    idUsuario = mainFernan.utilidades.Funciones.iniciarSesion(usuarios);

                    if (idUsuario != -1) {
                        String rol = usuarios[idUsuario][2];

                        switch (rol) {
                            case "ASISTENTE":
                                mainFernan.utilidades.Funciones.menuAsistenteUsuario(usuarios, eventos, invitados, eventosCompradosAsistente, idUsuario, idEvento);
                                break;

                            case "ORGANIZADOR":
                                mainFernan.utilidades.Funciones.menuOrganizadorUsuario(usuarios, eventos, idUsuario, idEvento);
                                break;

                            case "ADMIN":
                                mainFernan.utilidades.Funciones.menuAdministradorUsuario(usuarios, eventos, idUsuario, idEvento);
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 3);
    }
}