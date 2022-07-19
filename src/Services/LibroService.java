package Services;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.LibroDAO;
import java.util.List;
import java.util.Scanner;

public class LibroService {

    private final LibroDAO DAO;
    private EditorialService editorialService;
    private final Scanner sc;

    public LibroService() {
        this.DAO = new LibroDAO();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Editorial editorial, Autor autor) {

        Libro libro = new Libro();

        try {
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);

            libro.setEditorial(editorial);

            libro.setAlta(Boolean.TRUE);

            DAO.guardar(libro);
            //VIDEO DRIVE MIN 35'
            return libro;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error creando Libros");
            System.out.println(e.toString());
            return null;
        }  
    }
    
    public List<Libro> listarLibros() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Libro> buscarPorEditorial(String nombreEditorial) {
        try {
            return (List<Libro>) DAO.buscarPorEditorial(nombreEditorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void eliminarLibro(Long isbn){
        try {
            DAO.eliminarLibro(isbn);
        } catch (Exception e) {
            System.out.println("No se ha logrado eliminar");
            e.printStackTrace();
        }
    }
    
    public Libro buscarLibroPorISBN(Long isbn){
        
        return DAO.buscarPorISBN(isbn);
    }
}
