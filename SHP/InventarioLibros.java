

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InventarioLibros {
    private ArrayList<Libro> libros;

    public InventarioLibros() {
        libros = new ArrayList<>();
        // Inventario estático de al menos 10 libros
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", 1605, 30.50));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, 45.99));
        libros.add(new Libro("1984", "George Orwell", 1949, 22.99));
        libros.add(new Libro("El Hobbit", "J.R.R. Tolkien", 1937, 28.75));
        libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 1953, 19.99));
        libros.add(new Libro("Don Juan Tenorio", "José Zorrilla", 1844, 25.30));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, 15.75));
        libros.add(new Libro("La Odisea", "Homero", -800, 50.00));
        libros.add(new Libro("Hamlet", "William Shakespeare", 1603, 27.40));
        libros.add(new Libro("Moby-Dick", "Herman Melville", 1851, 35.99));
    }

    // Registrar nuevo libro
    public void registrarLibro(String titulo, String autor, int anio, double precio) {
        libros.add(new Libro(titulo, autor, anio, precio));
        System.out.println("El libro ha sido registrado exitosamente.");
    }

    // Mostrar libros ordenados por año de publicación
    public void ordenarPorAnio() {
        Collections.sort(libros, Comparator.comparingInt(Libro::getAnioPublicacion));
        mostrarLibros();
    }

    // Buscar libros por autor
    public void buscarPorAutor(String autor) {
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay libros registrados del autor: " + autor);
        }
    }

    // Calcular el valor total del inventario
    public void calcularValorInventario() {
        double total = 0;
        for (Libro libro : libros) {
            total += libro.getPrecio();
        }
        System.out.println("El valor total del inventario es: $" + total);
    }

    // Mostrar todos los libros
    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
