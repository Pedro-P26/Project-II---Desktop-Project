package projeto2java.basedados.bll;

import projeto2java.basedados.entity.TipofuncionarioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class tipofuncionariobll {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public static void criartipofun (TipofuncionarioEntity tipo){
        transaction.begin();
        em.persist(tipo);
        transaction.commit();
    }

    public static void apagartipofun (TipofuncionarioEntity tipofun){
        transaction.begin();
        em.remove(tipofun);
        transaction.commit();
    }

    public static void updatetipofun(TipofuncionarioEntity tipofun){

        em.getTransaction().begin();
        em.merge(tipofun);
        em.getTransaction().commit();
    }
}
