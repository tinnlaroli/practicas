import java.util.Random;

public class Ordenamiento {

    // Bubble Sort: Compara e intercambia elementos adyacentes repetidamente.
    // Insertion Sort: Inserta elementos en su posición correcta en una lista
    // ordenada.
    // Selection Sort: Selecciona el elemento mínimo y lo coloca en su posición
    // correcta.
    // Merge Sort: Divide y conquista para combinar subarrays ordenados.
    // Quick Sort: Utiliza un pivote para dividir y ordenar subarrays.
    // Heap Sort: Utiliza una estructura de montículo (heap) para ordenar los
    // elementos.
    public static void main(String[] args) {

        int[] numeros = milDesordenado(1000);

        Ordenamiento obj = new Ordenamiento();

        System.out.println("Original: ");
        printArray(numeros);

        System.out.println("Bubble Sort: ");
        obj.bubbleSort(numeros.clone());

        System.out.println("Insertion Sort: ");
        obj.insertion(numeros.clone());

        System.out.println("Selection Sort: ");
        obj.selection(numeros.clone());

        System.out.println("Merge Sort: ");

        int[] mergeSortedArray = numeros.clone();
        obj.mergeSort(mergeSortedArray, 0, mergeSortedArray.length - 1);

        printArray(mergeSortedArray);

        System.out.println("Quick Sort: ");
        int[] quickSortedArray = numeros.clone();
        obj.quickSort(quickSortedArray, 0, quickSortedArray.length - 1);
        printArray(quickSortedArray);

        System.out.println("Heap Sort: ");
        obj.heapSort(numeros.clone());
    }

    public static int[] milDesordenado(int n) {
        int[] arr = new int[n];

        // Llenar el array con números del 1 al n
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // Desordenar el array
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Obtener un índice aleatorio
            // Intercambiar arr[i] y arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr; // Array desordenado
    }   

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    // metodos de ordenamiento

    // Implementación del algoritmo Bubble Sort (Ordenamiento burbuja)
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        // Se recorre el array y se comparan elementos adyacentes
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArray(arr); // Se muestra el array ordenado
    }

    // Implementación del algoritmo Insertion Sort (Ordenamiento por inserción)
    public void insertion(int[] arr) {
        int n = arr.length;
        // Se recorre el array comenzando desde el segundo elemento
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Desplaza los elementos mayores que 'key' una posición hacia adelante
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Coloca el valor de 'key' en su posición correcta
            arr[j + 1] = key;
        }
        printArray(arr); // Se muestra el array ordenado
    }

    // Implementación del algoritmo Selection Sort (Ordenamiento por selección)
    public void selection(int[] arr) {
        int n = arr.length;
        // Recorre el array para encontrar el elemento mínimo en cada iteración
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i; // Índice del elemento mínimo
            for (int j = i + 1; j < n; j++) {
                // Encuentra el índice del elemento más pequeño
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Intercambia el elemento mínimo con el primero de la sublista
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        printArray(arr); // Se muestra el array ordenado
    }

    // Implementación del algoritmo Merge Sort (Ordenamiento por mezcla)
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Encuentra el punto medio del array

            // Divide el array en dos subarrays y aplica recursivamente Merge Sort
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Combina las dos mitades ordenadas
            merge(arr, left, mid, right);
        }
    }

    // Función auxiliar que combina (mezcla) dos subarrays en un array ordenado
    public void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Tamaño del subarray izquierdo
        int n2 = right - mid; // Tamaño del subarray derecho

        // Arrays temporales para almacenar las mitades
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos en los arrays temporales L[] y R[]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        // Variables para recorrer L[], R[] y arr[]
        int i = 0, j = 0;
        int k = left;

        // Combina los dos subarrays L y R en arr[]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de L[], si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de R[], si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Implementación del algoritmo Quick Sort (Ordenamiento rápido)
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el pivote y lo coloca en la posición correcta
            int pi = partition(arr, low, high);

            // Aplica recursivamente Quick Sort en las sublistas izquierda y derecha
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Función auxiliar para particionar el array en torno a un pivote
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivote (último elemento)
        int i = (low - 1); // Índice del elemento más pequeño

        // Recorre el array y coloca los elementos más pequeños a la izquierda del
        // pivote
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Coloca el pivote en su posición correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Retorna el índice del pivote
    }

    // Implementación del algoritmo Heap Sort (Ordenamiento por montículos)
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Construye el montículo (heap)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extrae elementos del montículo de uno en uno
        for (int i = n - 1; i > 0; i--) {
            // Mueve la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Aplica heapify en el subárbol reducido
            heapify(arr, i, 0);
        }
        printArray(arr); // Se muestra el array ordenado
    }

    // Función auxiliar para ajustar el montículo (heapify)
    public void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializa el nodo más grande como la raíz
        int left = 2 * i + 1; // Hijo izquierdo
        int right = 2 * i + 2; // Hijo derecho

        // Si el hijo izquierdo es mayor que la raíz
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Si el hijo derecho es mayor que el nodo más grande hasta ahora
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Si el nodo más grande no es la raíz
        if (largest != i) {
            // Intercambia la raíz con el nodo más grande
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Aplica recursivamente heapify en el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}