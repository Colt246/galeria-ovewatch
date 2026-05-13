package dam.code.galeria_overwatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Heroe {

    @Id
    private String id;
    private String nombre;
    private String rol;

    @Column(length = 1000)
    private String descripcion;

    private String portada;
    private int vida;

    @OneToMany(mappedBy = "heroe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Habilidad> habilidades;

}