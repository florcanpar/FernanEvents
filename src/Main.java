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

        GestionSistema.cargarDatosFisicos();

        Administrador admin = new Administrador("admin", "Admin123!", "A01", "admin@tk.com");
        Organizador org1 = new Organizador("juan_eventos", "Juan123!", "O01", "juan@eventos.com");
        Asistente asis1 = new Asistente("pedro_fan", "Pedro123!", "U01", "pedro@gmail.com");
        asis1.setCartera(100.0);

        ArrayList<TipoEntrada> tiposEvento = new ArrayList<>();
        tiposEvento.add(new TipoEntrada("General", "Acceso estándar", 25.0, 100));
        tiposEvento.add(new TipoEntrada("VIP", "Acceso preferente y bebida", 60.0, 20));

        Evento eventoPrueba = new Evento(
                "Final Champions League",
                "El partido del año en pantalla gigante",
                Categoria.CINE,
                LocalDateTime.of(2026, 5, 30, 21, 0),
                120,
                tiposEvento,
                "O01"
        );

        GestionSistema.guardarEvento(eventoPrueba);

        if (GestionSistema.usuarios[0] == null) {
            GestionSistema.usuarios[0] = admin;
            GestionSistema.usuarios[1] = org1;
            GestionSistema.usuarios[2] = asis1;
        }

        GestionSistema.setAdminPrincipal(admin);

        int opcionPrincipal = 0;
        int erroresLogin = 0;

        while (opcionPrincipal != 3) {
            final String CYAN = "\u001B[36m";
            final String RESET = "\u001B[0m";
            final String MORADO = "\u001B[35m";
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
            System.out.println(MORADO + "《1》" + RESET + " Iniciar sesión");
            System.out.println(MORADO + "《2》" + RESET + " Crear cuenta");
            System.out.println(MORADO + "《3》" + RESET + " Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcionPrincipal = Integer.parseInt(sc.nextLine());

                if (opcionPrincipal == 1) {
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenia = sc.nextLine();

                    Usuario logIn = GestionSistema.autenticar(usuario, contrasenia);

                    if (logIn != null) {
                        if (logIn.isBloqueado()) {
                            System.out.println("❌ Cuenta bloqueada. Contacte con el administrador.");
                        } else {
                            erroresLogin = 0;
                            if (logIn instanceof Administrador) VistaAdmin.menu((Administrador)logIn, sc);
                            else if (logIn instanceof Organizador) VistaOrganizador.menu((Organizador)logIn, sc);
                            else if (logIn instanceof Asistente) VistaAsistente.menu((Asistente)logIn, sc);
                        }
                    } else {
                        erroresLogin++;
                        System.out.println("❌ Credenciales incorrectas (" + erroresLogin + "/3)");

                        if (erroresLogin >= 3) {
                            for (Usuario u : GestionSistema.usuarios) {
                                if (u != null && u.getNombre().equals(usuario) && !(u instanceof Administrador)) {
                                    u.bloquear();
                                    GestionSistema.registrarLog("SEGURIDAD: Usuario " + usuario + " bloqueado por reintentos.");
                                    System.out.println("⚠️ El usuario '" + usuario + "' ha sido bloqueado por seguridad.");
                                }
                            }
                            erroresLogin = 0;
                        }
                    }

                } else if (opcionPrincipal == 2) {
                    crearNuevoUsuario(sc);
                }

            } catch (Exception e) {
                System.out.println("⚠️ Error de entrada: Por favor, use los números indicados.");
            }
        }

        GestionSistema.guardarDatosFisicos();
        System.out.println("Cerrando sistema y guardando cambios...");
    }

    private static void crearNuevoUsuario(Scanner sc) {
        System.out.print("Nombre de usuario: ");
        String nombre = sc.nextLine();

        String pass = "";
        boolean fuerte = false;
        while (!fuerte) {
            System.out.print("Contraseña segura: ");
            pass = sc.nextLine();
            if (Cadenas.contraseniaFuerte(pass)) fuerte = true;
            else System.out.println("⚠️ La contraseña debe tener mayúsculas, números y símbolos.");
        }

        System.out.print("ID único: ");
        String id = sc.nextLine();
        System.out.println("Tipo de cuenta: 1. ASISTENTE | 2. ORGANIZADOR");
        int tipo = Integer.parseInt(sc.nextLine());

        Usuario nuevo;
        if (tipo == 2) {
            nuevo = new Organizador(nombre, pass, id, nombre + "@eventos.com");
        } else {
            nuevo = new Asistente(nombre, pass, id, nombre + "@correo.com");
            ((Asistente)nuevo).setCartera(50.0);
        }

        for (int i = 0; i < GestionSistema.usuarios.length; i++) {
            if (GestionSistema.usuarios[i] == null) {
                GestionSistema.usuarios[i] = nuevo;
                GestionSistema.registrarLog("REGISTRO: Nuevo usuario creado: " + nombre);
                System.out.println("✅ Registro completado con éxito.");
                break;
            }
        }
    }
}