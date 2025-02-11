package projeto2java.basedados.bll;

import projeto2java.basedados.entity.ProducaoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class producaobll {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criarproducao (ProducaoEntity prod){
        transaction.begin();
        em.persist(prod);
        transaction.commit();
    }

    public static void apagarproducao (ProducaoEntity prod){
        transaction.begin();
        em.remove(prod);
        transaction.commit();
    }

    public static void updateprod(ProducaoEntity prod){

        em.getTransaction().begin();
        em.merge(prod);
        em.getTransaction().commit();
    }

    public static List<ProducaoEntity> listarproducao(){
        return DBconnection.getEntityManager().createQuery("from ProducaoEntity ").getResultList();
    }




}
