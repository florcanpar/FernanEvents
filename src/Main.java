import controlador.GestionSistema;
import modelo.*;
import vista.*;
import utilidades.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GestionSistema.cargarDatosFisicos();

        Administrador admin = new Administrador("admin", "Admin123!", "D01", "jgarlaz583@g.educaand.es");
        Organizador org1 = new Organizador("juan_eventos", "Juan123!", "O01", "jgarlaz583@g.educaand.es");
        Asistente asis1 = new Asistente("pedro_fan", "Pedro123!", "A01", "jgarlaz583@g.educaand.es");
        asis1.setCartera(100.0);

        GestionSistema.añadirUsuario(admin);
        GestionSistema.añadirUsuario(org1);
        GestionSistema.añadirUsuario(asis1);
        GestionSistema.setAdminPrincipal(admin);

        int opcionPrincipal = 0;
        int erroresLogin = 0;

        while (opcionPrincipal != 3) {
            final String CYAN = "\u001B[36m";
            final String RESET = "\u001B[0m";
            final String MORADO = "\u001B[35m";

            System.out.println(CYAN + """
                    
                       ███████╗███████╗██████╗░███╗░░██╗░█████╗░███╗░░██╗
                       ██╔════╝██╔════╝██╔══██╗████╗░██║██╔══██╗████╗░██║
                       █████╗░░█████╗░░██████╔╝██╔██╗██║███████║██╔██╗██║
                       ██╔══╝░░██╔══╝░░██╔══██╗██║╚████║██╔══██║██║╚████║
                       ██║░░░░░███████╗██║░░██║██║░╚███║██║░░██║██║░╚███║
                       ╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═╝░░╚══╝
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
                            System.out.println("Cuenta bloqueada.");
                        } else {

                            int tokenGenerado = TokenAleatorio.tokenAleatorio();
                            System.out.println("Enviando código de verificación a: " + logIn.getEmail());

                            DobleFactorCorreo.enviarGMail(
                                    logIn.getEmail(),
                                    "FernanEvents: Código de seguridad",
                                    "<h2>Su código es: <strong>" + tokenGenerado + "</strong></h2>"
                            );

                            System.out.print("Introduzca el código recibido: ");
                            int tokenUser = Integer.parseInt(sc.nextLine());

                            if (tokenUser == tokenGenerado) {
                                erroresLogin = 0;
                                System.out.println("Verificación exitosa.");
                                if (logIn instanceof Administrador) VistaAdmin.menu((Administrador)logIn, sc);
                                else if (logIn instanceof Organizador) VistaOrganizador.menu((Organizador)logIn, sc);
                                else if (logIn instanceof Asistente) VistaAsistente.menu((Asistente)logIn, sc);
                            } else {
                                System.out.println("Código incorrecto. Acceso denegado.");
                            }
                        }
                    } else {
                        erroresLogin++;
                        System.out.println("Credenciales incorrectas (" + erroresLogin + "/3)");

                        if (erroresLogin >= 3) {
                            Usuario uABloquear = GestionSistema.buscarUsuarioPorNombre(usuario);
                            if (uABloquear != null && !(uABloquear instanceof Administrador)) {
                                uABloquear.bloquear();
                                GestionSistema.registrarLog("SEGURIDAD: Usuario " + usuario + " bloqueado.");
                                System.out.println("Usuario bloqueado por seguridad.");
                            }
                            erroresLogin = 0;
                        }
                    }
                } else if (opcionPrincipal == 2) {
                    crearNuevoUsuario(sc);
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida.");
            }
        }

        GestionSistema.guardarDatosFisicos();
        System.out.println("Cerrando sistema...");
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
            else System.out.println("La contraseña debe tener minúsculas, mayúsculas, números y símbolos.");
        }

        System.out.print("ID único (Primera inical O organizador/ A asistente) después el número de Usuario que seas: ");
        String id = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.println("Tipo: 1. ASISTENTE | 2. ORGANIZADOR");
        int tipo = Integer.parseInt(sc.nextLine());

        Usuario nuevo;
        if (tipo == 2) {
            nuevo = new Organizador(nombre, pass, id, email);
        } else {
            nuevo = new Asistente(nombre, pass, id, email);
            ((Asistente)nuevo).setCartera(50.0);
        }

        GestionSistema.añadirUsuario(nuevo);
        GestionSistema.registrarLog("REGISTRO: " + nombre);
        System.out.println("Registro completado.");
    }
}