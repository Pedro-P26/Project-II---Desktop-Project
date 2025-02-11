package projeto2java.basedados.bll;
import projeto2java.basedados.entity.FuncionarioEntity;
import jakarta.persistence.*;

import java.util.List;

public class Funcionariobll {


    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();


    public static void criarfuncionario (FuncionarioEntity fun){
        transaction.begin();
        em.persist(fun);
        transaction.commit();
    }
    public static void apagarfuncioanrio (FuncionarioEntity fun){
        transaction.begin();
        em.remove(fun);
        transaction.commit();
    }

    public static void updatefun (FuncionarioEntity fun){


        em.getTransaction().begin();
        em.merge(fun);
        em.getTransaction().commit();
    }
    public static List<FuncionarioEntity> listarfun(){
        return DBconnection.getEntityManager().createQuery("from FuncionarioEntity ").getResultList();
    }

    public FuncionarioEntity getbyusername(String username){
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT f FROM FuncionarioEntity f where f.username = :username");
        query.setParameter("username",username);

        FuncionarioEntity funcionario = (FuncionarioEntity) query.getSingleResult();
        em.close();

        return funcionario;
    }










}
