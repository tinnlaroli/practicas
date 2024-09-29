import java.util.Scanner;
public class nNumeros {
    
    public static void main(String[] args) {
        //de manera iterativa
        Scanner teclado = new Scanner(System.in);
        System.out.println("input the number: ");
        int n = teclado.nextInt();
        int sumatoria = 0;
        int i = 0;
        while (i <= n) {
            sumatoria += i;
            i++;
        }
        System.out.println("in a iterative way "+sumatoria);


        //de manera recursiva
        nNumeros obj = new nNumeros();
        System.out.println("in a recursive function "+obj.sumatoria(n));
//        obj.sumatoria(n);
    }

        //de manera recursiva
    public int sumatoria(int n){
        //caso base
        if (n == 0) {
            return 0;
        //caso recursivo
        } else {
            //llamar recursivamente con el número anterior
            return (n + sumatoria(n-1));
        }
        
        }
}