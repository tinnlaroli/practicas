

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private double precio;

    public Libro(String titulo, String autor, int anioPublicacion, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor +
                ", Año de publicación: " + anioPublicacion +
                ", Precio: $" + precio;
    }
}
