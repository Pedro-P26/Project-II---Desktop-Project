package projeto2java.basedados.bll;

import projeto2java.basedados.entity.FaseproducaoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import projeto2java.basedados.entity.FornecedorEntity;

import java.util.List;

public class faseproducaobll {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public static void criarfaseprod (FaseproducaoEntity tipo){
        transaction.begin();
        em.persist(tipo);
        transaction.commit();
    }

    public static List<FaseproducaoEntity> listarfase(){
        return DBconnection.getEntityManager().createQuery("from FaseproducaoEntity ").getResultList();
    }




}
