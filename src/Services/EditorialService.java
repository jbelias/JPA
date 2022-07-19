package Services;

import Entidades.Editorial;
import static Entidades.Libro_.editorial;
import Persistencia.EditorialDAO;
import java.util.List;
import java.util.Scanner;

public class EditorialService {

    private final EditorialDAO DAO;
    private EditorialService editorialService;
    private final Scanner sc;

    public EditorialService() {
        this.DAO = new EditorialDAO();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Editorial crearEditorial(String nombre) {

        Editorial editorial = new Editorial();
        //Validar editorial si existe

        if (!existeEditorial(nombre)) {
            editorial.setNombre(nombre);
            editorial.setAlta(Boolean.TRUE);

            DAO.guardar(editorial);
            return editorial;
        }
        return editorial;
    }
    
        public boolean existeEditorial(String nombre){
        try {
            Editorial resultado = DAO.buscarPorNombre(nombre);
            
            if (resultado != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Sale del método existeEditorial con resultado null");
            e.printStackTrace();
            System.out.println(e.toString());
            return false;
        }
    }

    public List<Editorial> listarEdiroriales() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Editorial buscarPorNombre(String nombre){
        try {
            Editorial editorial = DAO.buscarPorNombre(nombre);
            System.out.println("Se encontró el Editorial: " + editorial.getNombre());
            return editorial;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
            System.out.println("No se devolvió ninguna entrada para este Editorial.");
            
            return null;
        }
    }
    
    public Editorial buscarPorID(Integer id) throws Exception{
        try {
            if (id == null || id == 0) {
                throw new Exception("Debe ingresar un ID válido"); 
            }
            Editorial editorial = DAO.buscarPorId(id);
            
            if (editorial == null) {
                throw new Exception("El ID buscado no se encuentra en la base de datos"); 
            }
            
            return editorial;
        
        } catch (Exception e) {
            e.printStackTrace();
            throw(e);
        }
    }

    public void modificarNombre() throws Exception{
        try {
            System.out.println("Ingrese el ID del Editorial que desee modificar: ");
            Editorial editorial = buscarPorID(ingresarID());
            System.out.println("Ingrese el nuevo nombre que desee");
            String nombre = sc.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del editorial."); 
            }
            editorial.setNombre(nombre);
            DAO.modificarEditorial(editorial);
            System.out.println("El nombre de la editorial ha cambiado exitosamente a '" + nombre + "'. ");
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer ingresarID() {
        try {
            System.out.println("Ingrese el ID");
            
            Integer id = sc.nextInt();
            
            if(id == 0 ){
                throw new Exception("El ID no puede ser 0");
            }
            
            return id;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void darAlta(){
        try {
            System.out.println("Indique la editorial que desee reactivar: ");
            Editorial editorial = buscarPorID(ingresarID());
            System.out.println("La editorial es: " + editorial.getNombre());
            
            if (editorial.getAlta() == true) {
                System.out.println("La editorial ya está activa.");
            }else {
                editorial.setAlta(Boolean.TRUE);
                DAO.modificarEditorial(editorial);
                System.out.println("Se ha reactivado correctamente");
            }
        } catch (Exception e) {
            System.out.println("No se ha logrado dar de alta.");
            e.printStackTrace();
        }
    }
    
     public void darBaja(){
        try {
            System.out.println("Indique la editorial que desee desactivar: ");
            Editorial editorial = buscarPorID(ingresarID());
            System.out.println("La editorial es: " + editorial.getNombre());
            
            if (editorial.getAlta() == false) {
                System.out.println("La editorial ya está desactivada.");
            }else {
                editorial.setAlta(Boolean.FALSE);
                DAO.modificarEditorial(editorial);
                System.out.println("Se ha desactivado correctamente");
            }
        } catch (Exception e) {
            System.out.println("No se ha logrado dar de baja.");
            e.printStackTrace();
        }
    }
}
