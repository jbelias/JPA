package Persistencia;

import Entidades.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial>{
    
    @Override
    public void guardar(Editorial editorial){
        super.guardar(editorial);
    }
    
    public Editorial buscarPorId(Integer id){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarTodos(){
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;        
    }
    
    public Editorial buscarPorNombre(String nombre){
        conectar();
        Editorial editoriales = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
        desconectar();
        return editoriales;
    }
    
    public void modificarEditorial(Editorial editorial){
        try {
            if (editorial == null) {
                throw new Exception("El proceso de modificación de la editorial falló");
            }
            super.editar(editorial);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
        }
    }
}
