package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "lotefinal", schema = "public", catalog = "databaseprojeto2")
public class LotefinalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_lotefinal")
    private int idLotefinal;
    @Basic
    @Column(name = "qtd")
    private int qtd;
    @Basic
    @Column(name = "datahoraemissao")
    private Date datahoraemissao;
    /*@OneToMany(mappedBy = "lotefinalByIdLotefinal")
    private Collection<ProducaoEntity> producaosByIdLotefinal;
*/
    public int getIdLotefinal() {
        return idLotefinal;
    }

    public void setIdLotefinal(int idLotefinal) {
        this.idLotefinal = idLotefinal;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Date getDatahoraemissao() {
        return datahoraemissao;
    }

    public void setDatahoraemissao(Date datahoraemissao) {
        this.datahoraemissao = datahoraemissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotefinalEntity that = (LotefinalEntity) o;

        if (idLotefinal != that.idLotefinal) return false;
        if (qtd != that.qtd) return false;
        if (datahoraemissao != null ? !datahoraemissao.equals(that.datahoraemissao) : that.datahoraemissao != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLotefinal;
        result = 31 * result + qtd;
        result = 31 * result + (datahoraemissao != null ? datahoraemissao.hashCode() : 0);
        return result;
    }

   /* public Collection<ProducaoEntity> getProducaosByIdLotefinal() {
        return producaosByIdLotefinal;
    }*/

   /* public void setProducaosByIdLotefinal(Collection<ProducaoEntity> producaosByIdLotefinal) {
        this.producaosByIdLotefinal = producaosByIdLotefinal;
    }*/
}
