package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tipoproduto", schema = "public", catalog = "databaseprojeto2")
public class TipoprodutoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipoproduto")
    private int idTipoproduto;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "unidademedida")
    private String unidademedida;
    @OneToMany(mappedBy = "tipoprodutoByIdTipoproduto")
    private Collection<LoteintermedioEntity> loteintermediosByIdTipoproduto;

    public int getIdTipoproduto() {
        return idTipoproduto;
    }

    public void setIdTipoproduto(int idTipoproduto) {
        this.idTipoproduto = idTipoproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidademedida() {
        return unidademedida;
    }

    public void setUnidademedida(String unidademedida) {
        this.unidademedida = unidademedida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoprodutoEntity that = (TipoprodutoEntity) o;

        if (idTipoproduto != that.idTipoproduto) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (unidademedida != null ? !unidademedida.equals(that.unidademedida) : that.unidademedida != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoproduto;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (unidademedida != null ? unidademedida.hashCode() : 0);
        return result;
    }

    public Collection<LoteintermedioEntity> getLoteintermediosByIdTipoproduto() {
        return loteintermediosByIdTipoproduto;
    }

    public void setLoteintermediosByIdTipoproduto(Collection<LoteintermedioEntity> loteintermediosByIdTipoproduto) {
        this.loteintermediosByIdTipoproduto = loteintermediosByIdTipoproduto;
    }
}
