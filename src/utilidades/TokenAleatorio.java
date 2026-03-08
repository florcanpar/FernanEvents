package utilidades;

public class TokenAleatorio {
    public static int tokenAleatorio(){
        int numeroAleatorio = (int) (Math.random()* 9000) + 1000;
        return numeroAleatorio;
    }
}
