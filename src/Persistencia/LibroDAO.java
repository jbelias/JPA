package Persistencia;

import Entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO<Libro>{
    
    @Override
    public void guardar(Libro libro){
        super.guardar(libro);
    }
    
    public Libro buscarPorISBN(Long isbn){
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn)
                .getSingleResult();
        desconectar();
        return libro;
    }
    
    public Libro buscarPorID(Long isbn){
        conectar();
        
        Libro libro = em.find(Libro.class, isbn);
        desconectar();
        
        return libro;
    }
    
    public List<Libro> listarTodos(){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;        
    }
    
    public Libro buscarPorNombre(String nombre){
        conectar();
        Libro libros = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.nombre LIKE :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
        desconectar();
        return libros;
    }
   
    public Libro buscarPorEditorial(String editorial){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial LIKE :editorial").setParameter("editorial", editorial).getResultList();
        desconectar();
        return (Libro) libros;
    }
    
    public void eliminarLibro(Long isbn){
        try {
            Libro libro = buscarPorISBN(isbn);
            if (libro == null) {
                throw new Exception("El error fue: "+ toString());                
            }
            super.eliminar(libro);
            System.out.println("Se ha eliminado el libro: '" + libro.getTitulo() + "'.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
        }
    }
}
