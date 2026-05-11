package dam.code.galeria_overwatch.model;

public class Habilidad {

    private String tipo;
    private String titulo;
    private String icono;
    private String descripcion;

    public Habilidad(String tipo, String titulo, String icono, String descripcion) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.icono = icono;
        this.descripcion = descripcion;
    }

    public String getTipo() { return tipo; }
    public String getTitulo() { return titulo; }
    public String getIcono() { return icono; }
    public String getDescripcion() { return descripcion; }

}