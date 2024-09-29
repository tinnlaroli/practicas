public class cuboMagico {
    public static void main(String[] args) {
        int[][] matriz = {
            { 4, 9, 2 },
            { 3, 5, 7 },
            { 8, 1, 6 },
        };
        boolean esCuboMagico = true;
        int n = matriz.length;

        if (n != matriz[0].length) {
            esCuboMagico = false;
            System.out.println("La matriz no es cuadrada");
            return;
        }

        // Calcular la suma de la primera fila pa saber cuanto debe darnos
        int sumaComprobar = 0;
        for (int j = 0; j < n; j++) {
            sumaComprobar += matriz[0][j];
        }

        // Verificar las sumas de las filas y columnas
        for (int i = 0; i < n; i++) {
            int sumaF = 0;
            int sumaC = 0;
            for (int j = 0; j < n; j++) {
                sumaF += matriz[i][j];
                sumaC += matriz[j][i];
            }
            if (sumaF != sumaComprobar || sumaC != sumaComprobar) {
                esCuboMagico = false;
                break;
            }
        }

        // Verificar las sumas de las diagonales
        int sumaD1 = 0;
        int sumaD2 = 0;
        for (int i = 0; i < n; i++) {
            sumaD1 += matriz[i][i];
            sumaD2 += matriz[i][n - 1 - i];
        }
        if (sumaD1 != sumaComprobar || sumaD2 != sumaComprobar) {
            esCuboMagico = false;
        }

        if (esCuboMagico)
            System.out.println("Es un cubo mágico");
        else 
            System.out.println("No es un cubo mágico");
        
    }
}