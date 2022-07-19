package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPAPU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected T eliminar(T objeto) throws Exception {
        try {
            conectar();
            T objeto1 = em.merge(objeto);
            em.getTransaction().begin();
            em.remove(objeto1);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            desconectar();
            throw new Exception("La entidad de tipo " + objeto.getClass()
                    .getSimpleName() + "No se ha podido eliminar");
        }
        return objeto;
    }

}
