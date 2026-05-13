package dam.code.galeria_overwatch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String titulo;
    private String icono;

    @Column(length = 1000)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "heroe_id")
    @JsonIgnore
    private Heroe heroe;

    public Habilidad(String tipo, String titulo, String icono, String descripcion) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.icono = icono;
        this.descripcion = descripcion;
    }

}