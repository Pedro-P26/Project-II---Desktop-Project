package projeto2java.basedados.bll;

import projeto2java.basedados.entity.LoteintermedioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class loteintermediobll {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criarloteinter (LoteintermedioEntity lotinter){
        transaction.begin();
        em.persist(lotinter);
        transaction.commit();
    }

    public static void apagarloteinter (LoteintermedioEntity loteinter){
        transaction.begin();
        em.remove(loteinter);
        transaction.commit();
    }

    public static void updateloteinter(LoteintermedioEntity loteinter){

        em.getTransaction().begin();
        em.merge(loteinter);
        em.getTransaction().commit();
    }

    public static List<LoteintermedioEntity> listaloteintermedio(){
        return DBconnection.getEntityManager().createQuery("from LoteintermedioEntity ").getResultList();
    }
}
