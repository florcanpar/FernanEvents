import controlador.GestionSistema;
import modelo.*;
import vista.*;
import utilidades.Cadenas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Administrador admin = new Administrador("admin", "Admin123!", "A01", "admin@tk.com");
        Organizador org1 = new Organizador("juan_eventos", "Juan123!", "O01", "juan@eventos.com");
        Asistente asis1 = new Asistente("pedro_fan", "Pedro123!", "U01", "pedro@gmail.com");
        asis1.setCartera(100.0);

        // Registro de usuarios iniciales
        GestionSistema.usuarios[0] = admin;
        GestionSistema.usuarios[1] = org1;
        GestionSistema.usuarios[2] = asis1;

        GestionSistema.setAdminPrincipal(admin);
        GestionSistema.setOrganizadorPrincipal(org1);

        ArrayList<TipoEntrada> listaTipos = new ArrayList<>();
        listaTipos.add(new TipoEntrada("General", "Entrada normal", 20.0, 50));

        Evento evento = new Evento("Concierto Rock", "Musica en vivo", Categoria.MUSICA,
                LocalDateTime.of(2026, 5, 20, 21, 0), 50, listaTipos, "O01");

        GestionSistema.eventos.add(evento);

        // -------------------------------------------------------------

        int opcionPrincipal = 0;
        int erroresLogin = 0;

        while (opcionPrincipal != 3) {
            final String CYAN = "\u001B[36m";
            final String RESET = "\u001B[0m";
            final String MORADO = "\u001B[35m";
            final String ROJO = "\u001B[31m";
            final String BLANCO = "\u001B[37m";

            System.out.println(CYAN + "... LOGO FERNAN EVENTS ..." + RESET);
            System.out.println(MORADO +"《1》 " + RESET + "Iniciar sesión.");
            System.out.println(MORADO +"《2》 " + RESET + "Crear usuario.");
            System.out.println(MORADO +"《3》 " + RESET + "Salir.");
            System.out.print("Seleccione: ");
            opcionPrincipal = Integer.parseInt(sc.nextLine());

            if (opcionPrincipal == 1) {
                System.out.print("Usuario: ");
                String usuario = sc.nextLine();
                System.out.print("Contraseña: ");
                String contrasenia = sc.nextLine();

                Usuario logIn = GestionSistema.autenticar(usuario, contrasenia);

                if (logIn != null) {
                    if (logIn.isBloqueado()) {
                        System.out.println("Usuario bloqueado. Contacte con el Admin.");
                    } else {
                        erroresLogin = 0;
                        System.out.println("Acceso concedido. Bienvenido " + logIn.getNombre() + ".");

                        if (logIn instanceof Administrador) VistaAdmin.menu((Administrador)logIn, sc);
                        else if (logIn instanceof Organizador) VistaOrganizador.menu((Organizador)logIn, sc);
                        else if (logIn instanceof Asistente) VistaAsistente.menu((Asistente)logIn);
                    }
                } else {
                    erroresLogin++;
                    System.out.println("Usuario o contraseña incorrecto (" + erroresLogin + "/3)");

                    if (erroresLogin >= 3) {
                        for (Usuario u : GestionSistema.usuarios) {
                            if (u != null && u.getNombre().equals(usuario) && !(u instanceof Administrador)) {
                                u.bloquear();
                                System.out.println("El usuario '" + usuario + "' ha sido bloqueado.");
                            }
                        }
                        erroresLogin = 0;
                    }
                }

            } else if (opcionPrincipal == 2) {
                System.out.print("Nombre de usuario: ");
                String nombre = sc.nextLine();

                String contraseniaNuevoUsuario = "";
                boolean fuerte = false;
                while (!fuerte) {
                    System.out.print("Contraseña: ");
                    contraseniaNuevoUsuario = sc.nextLine();
                    if (Cadenas.contraseniaFuerte(contraseniaNuevoUsuario)) fuerte = true;
                    else System.out.println("La contraseña es débil.");
                }

                System.out.print("ID único: ");
                String id = sc.nextLine();
                System.out.println("1. ASISTENTE | 2. ORGANIZADOR");
                int opcion = Integer.parseInt(sc.nextLine());

                Usuario nuevoUsuario;
                if (opcion == 2) {
                    nuevoUsuario = new Organizador(nombre, contraseniaNuevoUsuario, id, nombre + "@empresa.com");
                } else {
                    nuevoUsuario = new Asistente(nombre, contraseniaNuevoUsuario, id, nombre + "@correo.com");
                    ((Asistente)nuevoUsuario).setCartera(50.0);
                }

                for (int i = 0; i < GestionSistema.usuarios.length; i++) {
                    if (GestionSistema.usuarios[i] == null) {
                        GestionSistema.usuarios[i] = nuevoUsuario;
                        break;
                    }
                }
                System.out.println("Usuario creado con éxito.");
            }
        }
        System.out.println("Saliendo . . .");
    }
}