package projeto2java.basedados;

//import bll.*;
//import entity.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.transaction.Transaction;

import java.util.List;

//import static bll.Funcionariobll.listarfun;


public class Main {

    public static void main(String [] arg) {

        /*FuncionarioEntity fun = new FuncionarioEntity();
        fun.setIdTipofuncionario(2);
        fun.setNome("Manuel");
        //fun.setIdFuncionario(1);
        fun.setEmail("manuel@gmail.com");
        fun.setLocalidade("Lisbon");
        fun.setSalario(4555);
        fun.setUsername("oo44");
        fun.setPassword("svfc");
        fun.setTelefone(234543);
        */

        /*TipofuncionarioEntity tipo = new TipofuncionarioEntity();
        tipo.setTipo("GestorProducao");
        tipofuncionariobll.criar(tipo);
        */
         /*EstadoencomendaEntity estado = new EstadoencomendaEntity();
         estado.setTipoestado("Entregue");
         estadoencomendabll.criar(estado);
            */


        //Funcionariobll.criar(fun);

        //Funcionariobll.apagar(fun);

        //System.out.println(Funcionariobll.listarfun());
        /*TipoprodutoEntity tipo = new TipoprodutoEntity();
        tipo.setNome("Cevada");
        tipo.setUnidademedida("kg");
        tipoprodutobll.criar(tipo);

        TipoprodutoEntity tipo1 = new TipoprodutoEntity();
        tipo1.setNome("Cevada_Muida");
        tipo1.setUnidademedida("kg");
        tipoprodutobll.criar(tipo1);

        TipoprodutoEntity tipo2 = new TipoprodutoEntity();
        tipo2.setNome("Whisky_Envelhecer");
        tipo2.setUnidademedida("litros");
        tipoprodutobll.criar(tipo2);
*/
        /*TipoprodutoEntity tipo3 = new TipoprodutoEntity();
        tipo3.setNome("Whisky_engarrafado");
        tipo3.setUnidademedida("Unidades");
        tipoprodutobll.criar(tipo3);
*/

    }
}
