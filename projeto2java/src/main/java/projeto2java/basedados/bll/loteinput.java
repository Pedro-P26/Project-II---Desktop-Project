package projeto2java.basedados.bll;

import projeto2java.basedados.entity.LoteinputEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class loteinput {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criarloteinput (LoteinputEntity lotinput){
        transaction.begin();
        em.persist(lotinput);
        transaction.commit();
    }

    public static void apagarloteinput (LoteinputEntity lotein){
        transaction.begin();
        em.remove(lotein);
        transaction.commit();
    }

    public static void updateloteinput (LoteinputEntity lotein){

        em.getTransaction().begin();
        em.merge(lotein);
        em.getTransaction().commit();
    }
    public static List<LoteinputEntity> listarloteinput(){
        return DBconnection.getEntityManager().createQuery("from LoteinputEntity ").getResultList();
    }
}
