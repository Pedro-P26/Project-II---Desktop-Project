package projeto2java.basedados.bll;

import projeto2java.basedados.entity.LotefinalEntity;
import projeto2java.basedados.entity.LoterecebidoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class lotefinalbll {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criarlotefinal(LoterecebidoEntity lotfinal){
        transaction.begin();
        em.persist(lotfinal);
        transaction.commit();
    }

    public static void apagarlotefinal (LotefinalEntity lotef){
        transaction.begin();
        em.remove(lotef);
        transaction.commit();
    }

    public static void updatelotefi(LotefinalEntity lotef){

        em.getTransaction().begin();
        em.merge(lotef);
        em.getTransaction().commit();
    }

    public static List<LotefinalEntity> listarlotefinal(){
        return DBconnection.getEntityManager().createQuery("from LotefinalEntity ").getResultList();
    }
}
