package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Fecha")
    private int fecha;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Paginas")
    private int paginas;
    @Column(name = "Autor")
    private String autor;


    //Relacion unidireccional con Autor
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autors = new ArrayList<Autor>();
}
