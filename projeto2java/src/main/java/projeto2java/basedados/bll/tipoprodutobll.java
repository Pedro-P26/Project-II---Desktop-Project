package projeto2java.basedados.bll;

import projeto2java.basedados.entity.TipoprodutoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class tipoprodutobll {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public static void criartipoprod (TipoprodutoEntity tipo){
        transaction.begin();
        em.persist(tipo);
        transaction.commit();
    }

    public static void apagartipoprod (TipoprodutoEntity tipopro){
        transaction.begin();
        em.remove(tipopro);
        transaction.commit();
    }

    public static void updatetipoprod(TipoprodutoEntity tipopro){

        em.getTransaction().begin();
        em.merge(tipopro);
        em.getTransaction().commit();
    }



}
