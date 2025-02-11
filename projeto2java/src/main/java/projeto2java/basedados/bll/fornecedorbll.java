package projeto2java.basedados.bll;

import projeto2java.basedados.entity.FornecedorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class fornecedorbll {


    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criarfornecedor (FornecedorEntity forn){
        transaction.begin();
        em.persist(forn);
        transaction.commit();
    }

    public static void apagarfornecedor (int forn){
        transaction.begin();
        em.remove(forn);
        transaction.commit();
    }

    public static List<FornecedorEntity> listarforn(){
        return DBconnection.getEntityManager().createQuery("from FornecedorEntity ").getResultList();
    }

    public static void updateforn(FornecedorEntity forn){


        em.getTransaction().begin();
        em.merge(forn);
        em.getTransaction().commit();
    }


}
