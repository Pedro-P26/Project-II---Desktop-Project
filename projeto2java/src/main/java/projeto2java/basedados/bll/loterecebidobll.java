package projeto2java.basedados.bll;

import projeto2java.basedados.entity.LoterecebidoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class loterecebidobll {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criarloterecebi (LoterecebidoEntity lotreceb){
        transaction.begin();
        em.persist(lotreceb);
        transaction.commit();
    }

    public static void apagarloterecebi (LoterecebidoEntity loterece){
        transaction.begin();
        em.remove(loterece);
        transaction.commit();
    }

    public static void updateloterecebe(LoterecebidoEntity loterece){

        em.getTransaction().begin();
        em.merge(loterece);
        em.getTransaction().commit();
    }
    public static List<LoterecebidoEntity> listarloterecebido(){
        return DBconnection.getEntityManager().createQuery("from LoterecebidoEntity ").getResultList();
    }
}
