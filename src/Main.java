import controlador.GestionSistema;
import modelo.*;
import vista.*;
import utilidades.Cadenas;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Administrador admin = new Administrador("admin", "Admin123!", "A01", "admin@tk.com");
        Organizador organizador1 = new Organizador("flor", "Flor123!", "O01", "flor@eventos.com");
        Asistente asistente1 = new Asistente("jesus", "Jesus123!", "U01", "jesus@gmail.com");
        asistente1.setCartera(100.0);

        GestionSistema.usuarios[0] = admin;
        GestionSistema.usuarios[1] = organizador1;
        GestionSistema.usuarios[2] = asistente1;

        GestionSistema.setAdminPrincipal(admin);
        GestionSistema.setOrganizadorPrincipal(organizador1);

        TipoEntrada[] tipoEntradas = new TipoEntrada[1];
        tipoEntradas[0] = new TipoEntrada("General", "Entrada normal", 20.0, 50);
        Evento evento = new Evento("Concierto Rock", "Musica en vivo", Categoria.MUSICA,
                LocalDateTime.of(2026, 5, 20, 21, 0), 50, tipoEntradas, "O01");
        GestionSistema.eventos[0] = evento;

        int opcionPrincipal = 0;
        int erroresLogin = 0;

        while (opcionPrincipal != 3) {
            final String CYAN = "\u001B[36m";
            final String RESET = "\u001B[0m";
            final String MORADO = "\u001B[35m";
            final String ROJO = "\u001B[31m";
            final String BLANCO = "\u001B[37m";
            System.out.println(CYAN + """
                    
                       ███████╗███████╗██████╗░███╗░░██╗░█████╗░███╗░░██╗
                       ██╔════╝██╔════╝██╔══██╗████╗░██║██╔══██╗████╗░██║
                       █████╗░░█████╗░░██████╔╝██╔██╗██║███████║██╔██╗██║
                       ██╔══╝░░██╔══╝░░██╔══██╗██║╚████║██╔══██║██║╚████║
                       ██║░░░░░███████╗██║░░██║██║░╚███║██║░░██║██║░╚███║
                       ╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═╝░░╚══╝
                    
                    """ + RESET);
            System.out.println(CYAN + """
                       ███████╗██╗░░░██╗███████╗███╗░░██╗████████╗░██████╗
                       ██╔════╝██║░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
                       █████╗░░╚██╗░██╔╝█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
                       ██╔══╝░░░╚████╔╝░██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
                       ███████╗░░╚██╔╝░░███████╗██║░╚███║░░░██║░░░██████╔╝
                       ╚══════╝░░░╚═╝░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░

                    """ + RESET);
            System.out.println(MORADO +"《1》 " + RESET + "Iniciar sesión.");
            System.out.println(MORADO +"《2》 " + RESET + "Crear usuario.");
            System.out.println(MORADO +"《3》 " + RESET + "Salir.");
            System.out.print("Seleccione: ");
            opcionPrincipal = Integer.parseInt(sc.nextLine());

            if (opcionPrincipal == 1) {
                System.out.println(ROJO + " ┌───────────────────────┐");
                System.out.println(ROJO + " │         "+BLANCO+"LOGIN"+ROJO+"         │");
                System.out.println(ROJO + " └───────────────────────┘"+RESET);
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
                        else if (logIn instanceof Asistente) VistaAsistente.menu((Asistente)logIn, sc);
                    }
                } else {
                    erroresLogin++;
                    System.out.println("Usuario o contraseña incorrecto.");
                    System.out.println("Intentos fallidos: " + erroresLogin + "/3");

                    if (erroresLogin >= 3) {
                        for (Usuario usuario1 : GestionSistema.usuarios) {
                            if (usuario1 != null && usuario1.getNombre().equals(usuario) && !(usuario1 instanceof Administrador)) {
                                usuario1.bloquear();
                                System.out.println("El usuario '" + usuario + "' ha sido bloqueado.");
                            }
                        }
                        erroresLogin = 0;
                    }
                }

            } else if (opcionPrincipal == 2) {
                System.out.println(ROJO + " ┌───────────────────────┐");
                System.out.println(ROJO + " │        "+BLANCO+"REGISTRO"+ROJO+"       │");
                System.out.println(ROJO + " └───────────────────────┘"+RESET);
                System.out.print("Nombre de usuario: ");
                String nombre = sc.nextLine();

                String contraseniaNuevoUsuario = "";
                boolean fuerte = false;

                while (!fuerte) {
                    System.out.print("Contraseña: ");
                    System.out.println("Debe contener: Más de 8 caracteres, mayúsculas, minúsculas, dígitos y caracteres especiales.");
                    contraseniaNuevoUsuario = sc.nextLine();

                    if (Cadenas.contraseniaFuerte(contraseniaNuevoUsuario)) {
                        fuerte = true;
                    } else {
                        System.out.println("La contraseña es débil. Inténtelo de nuevo.");
                    }
                }

                System.out.print("ID único: ");
                String id = sc.nextLine();
                System.out.println("Tipo de perfil:");
                System.out.println("1. ASISTENTE");
                System.out.println("2. ORGANIZADOR");
                System.out.print("Seleccione: ");
                int opcion = Integer.parseInt(sc.nextLine());

                Usuario nuevoUsuario;
                if (opcion == 2) {
                    nuevoUsuario = new Organizador(nombre, contraseniaNuevoUsuario, id, nombre + "@empresa.com");
                    System.out.println("Cuenta de Organizador creada.");
                } else {
                    nuevoUsuario = new Asistente(nombre, contraseniaNuevoUsuario, id, nombre + "@correo.com");
                    ((Asistente)nuevoUsuario).setCartera(50.0); // Regalo inicial
                    System.out.println("Cuenta de Asistente creada (+50 saldo).");
                }

                for (int i = 0; i < GestionSistema.usuarios.length; i++) {
                    if (GestionSistema.usuarios[i] == null) {
                        GestionSistema.usuarios[i] = nuevoUsuario;
                        break;
                    }
                }
            }
        }
        System.out.println("Saliendo . . .");
    }
}