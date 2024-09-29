public class matrices {
    public static void main(String[] args) {
        // int[][] matriz = new int[3][3];

        // matriz[0][0] = 1; matriz[0][1] = 2; matriz[0][2] = 3;

        // matriz[1][0] = 4; matriz[1][1] = 5; matriz[1][2] = 6;

        // matriz[2][0] = 7; matriz[2][1] = 8; matriz[2][2] = 9;

        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        
        //sumar cada fila
        for (int i = 0; i < matriz.length; i++) {
            int sumaF = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaF += matriz[i][j];
            }
            System.out.println("Suma de la fila " + i + ": " + sumaF);
        }
        //sumar cada columna
        for (int i = 0; i < matriz.length; i++) {
            int sumaC = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaC += matriz[j][i];
            }
            System.out.println("Suma de la columna " + i + ": " + sumaC);
        }
        
        //suma total 
        int sumaT = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaT += matriz[i][j];
            }
        }
        System.out.println("Suma total: " + sumaT);

        //par o impar de la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    System.out.println("El número " + matriz[i][j] + " es par");
                } else {
                    System.out.println("El número " + matriz[i][j] + " es impar");
                }
            }
        }
        
        int x = matriz.length;
        int y = matriz[0].length;

        System.out.println("m: " + x);
        System.out.println("n: " + y);
    }
}
