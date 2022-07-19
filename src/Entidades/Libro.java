package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBROS")
public class Libro implements Serializable {
    
    
    @Column(name = "ISBN")
    @Id
    private Long isbn;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "EJEMPLARES")
    private Integer ejemplares;
    @Column(name = "EJEMPLARES_PRESTADOS")
    private Integer ejemplaresPrestados;
    @Column(name = "EJEMPLARES_RESTANTES")
    private Integer ejemplaresRestantes;
    @Column(name = "ALTA")
    private Boolean alta;

    @ManyToOne(fetch = FetchType.LAZY)
    private Editorial editorial;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

    public Libro() {
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Editorial editorial, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", anio=" + anio 
                + ", ejemplares=" + ejemplares + ", ejemplaresPrestados=" + ejemplaresPrestados 
                + ", ejemplaresRestantes=" + ejemplaresRestantes + ", alta=" + alta + ", editorial=" + editorial 
                + ", autor=" + autor + '}';
    }
    
    
 
}
