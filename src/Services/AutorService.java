package Services;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.List;

public class AutorService {

    private final AutorDAO DAO;

    public AutorService() {
        this.DAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();

        try {
            autor.setNombre(nombre);
            autor.setAlta(Boolean.TRUE);

            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Autor> listarAutores() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor buscarPorNombre(String nombre){
        try {
            Autor autor = DAO.buscarPorNombre(nombre);
            System.out.println("Se encontró el autor: " + autor.getNombre());
            return autor;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
            System.out.println("No se devolvió ninguna entrada para este autor.");
            
            return null;
        }
    }

}
