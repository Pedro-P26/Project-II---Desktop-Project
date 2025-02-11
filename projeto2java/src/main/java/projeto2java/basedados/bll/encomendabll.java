package projeto2java.basedados.bll;

import projeto2java.basedados.entity.EncomendaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class encomendabll {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public static void criarencomenda(EncomendaEntity enc){
        transaction.begin();
        em.persist(enc);
        transaction.commit();
    }

    public static void apagarencomenda (EncomendaEntity enc){
        transaction.begin();
        em.remove(enc);
        transaction.commit();
    }

    public static void updateprodencomend (EncomendaEntity enc){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(enc);
        em.getTransaction().commit();
        em.close();
    }

    public static EncomendaEntity getById(int idEncomenda) {

        EncomendaEntity idencomenda = em.find(EncomendaEntity.class, idEncomenda);
        em.close();
        return idencomenda;
    }

    public static List<EncomendaEntity> listarencomenda(){
        return DBconnection.getEntityManager().createQuery("from EncomendaEntity ").getResultList();
    }


}
