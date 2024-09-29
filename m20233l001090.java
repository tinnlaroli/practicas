public class m20233l001090 {

    public static void main(String[] marlene) {

        // Datos de las 6 mascotas
        String[][] mascotas = {
            {"Dobby", "raza", "color", "tamanio", "perro", String.valueOf(10)},
            {"Darla", "raza", "color", "tamanio", "gato", String.valueOf(19)},
            {"ningui", "raza", "color", "tamanio", "gato", String.valueOf(18)},
            {"aslan", "raza", "color", "tamanio", "gato", String.valueOf(17)},
            {"blacky", "raza", "color", "tamanio", "perro", String.valueOf(16)},
            {"chata", "raza", "color", "tamanio", "perro", String.valueOf(15)},
            {"bolita", "raza", "color", "tamanio", "coenjo", String.valueOf(14)},
            {"blanquito", "raza", "color", "tamanio", "coenjo", String.valueOf(13)},
            {"juan", "juan", "juan", "juan", "juan", String.valueOf(12)},
            {"pinto", "raza", "color", "tamanio", "perro", String.valueOf(11)}
        };

        // Llenar el array mascoteria con los 6 datos de las 10 mascotas
        String[][] mascoteria = new String[10][6];
        for (int i = 0; i < mascotas.length; i++) {
            mascoteria[i] = mascotas[i];
        }

        // Imprimir todos los arreglos
        for (int i = 0; i < mascoteria.length; i++) {
        
        System.out.println("Mascota " + (i + 1) + ": " + String.join(", ", mascoteria[i]));
        
        }

        // Imprimir la cantidad de mascotas por cada especie
        String[] especies = new String[mascotas.length];
        int[] conteos = new int[mascotas.length];
        int especiesCount = 0;

        for (int i = 0; i < mascotas.length; i++) {
            String especie = mascotas[i][4];
            boolean found = false;

            // Buscar si la especie ya está en el array de especies
            for (int j = 0; j < especiesCount; j++) {
                if (especies[j].equals(especie)) {
                    conteos[j]++;
                    found = true;
                    break;
                }
            }

            // Si la especie no está en el array, agregarla
            if (!found) {
                especies[especiesCount] = especie;
                conteos[especiesCount] = 1;
                especiesCount++;
            }
        }

        // Imprimir los resultados
        for (int i = 0; i < especiesCount; i++) {
            System.out.println("Especie: " + especies[i] + ", combien: " + conteos[i]);
        }

    }
}
