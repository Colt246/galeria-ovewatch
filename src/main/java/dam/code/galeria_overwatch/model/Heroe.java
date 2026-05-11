package dam.code.galeria_overwatch.model;

import java.util.List;

public class Heroe {

    private String id;
    private String nombre;
    private String rol;
    private String descripcion;
    private String portada;
    private int vida;
    private List<Habilidad> habilidades;

    public Heroe(String id, String nombre, String rol, String descripcion, String portada, int vida, List<Habilidad> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.descripcion = descripcion;
        this.portada = portada;
        this.vida = vida;
        this.habilidades = habilidades;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    public String getDescripcion() { return descripcion; }
    public String getPortada() { return portada; }
    public int getVida() { return vida; }
    public List<Habilidad> getHabilidades() { return habilidades; }

}