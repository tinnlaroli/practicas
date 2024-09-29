/**
 * contar de 100 a 0
 */
public class cienCero {
    public static void main(String[] args) {
        //de manera iterativa
        for (int i = 100; i >= 0; i--) {
            System.out.println(i);
        }
        
        //de manera recursiva
        cienCero obj = new cienCero();
        obj.conteo(100);
    }
    
    //de manera recursiva
    public int conteo(int n){
        //caso base
        if (n <= 0) {
            return 0;
        } else {
            //imprimir el número
            System.out.println(n);
            //llamar recursivamente con el número anterior
            return conteo(n-1);
        }
    }
}