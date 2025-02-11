open module projeto2java.basedados {

    requires jakarta.persistence;
    requires jakarta.transaction;
    requires org.hibernate.orm.core;
    exports projeto2java.basedados.bll;
    exports projeto2java.basedados.entity;
    exports projeto2java.basedados;



    //exports projeto2java;


}