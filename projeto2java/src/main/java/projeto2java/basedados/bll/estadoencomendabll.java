package projeto2java.basedados.bll;

import projeto2java.basedados.entity.EncomendaEntity;
import projeto2java.basedados.entity.EstadoencomendaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class estadoencomendabll {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public static void criarestadoenco(EstadoencomendaEntity estado){
        transaction.begin();
        em.persist(estado);
        transaction.commit();
    }

    public static List<EstadoencomendaEntity> listarestados(){
        return DBconnection.getEntityManager().createQuery("from EstadoencomendaEntity").getResultList();
    }

}
