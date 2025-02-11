package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "faseproducao", schema = "public", catalog = "databaseprojeto2")
public class FaseproducaoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fase")
    private int idFase;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "faseproducaoByIdFase")
    private Collection<LoteinputEntity> loteinputsByIdFase;
    @OneToMany(mappedBy = "faseproducaoByIdFase")
    private Collection<LoteintermedioEntity> loteintermediosByIdFase;
    @OneToMany(mappedBy = "faseproducaoByIdFase")
    private Collection<ProducaoEntity> producaosByIdFase;

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaseproducaoEntity that = (FaseproducaoEntity) o;

        if (idFase != that.idFase) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFase;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    public Collection<LoteinputEntity> getLoteinputsByIdFase() {
        return loteinputsByIdFase;
    }

    public void setLoteinputsByIdFase(Collection<LoteinputEntity> loteinputsByIdFase) {
        this.loteinputsByIdFase = loteinputsByIdFase;
    }

    public Collection<LoteintermedioEntity> getLoteintermediosByIdFase() {
        return loteintermediosByIdFase;
    }

    public void setLoteintermediosByIdFase(Collection<LoteintermedioEntity> loteintermediosByIdFase) {
        this.loteintermediosByIdFase = loteintermediosByIdFase;
    }

    public Collection<ProducaoEntity> getProducaosByIdFase() {
        return producaosByIdFase;
    }

    public void setProducaosByIdFase(Collection<ProducaoEntity> producaosByIdFase) {
        this.producaosByIdFase = producaosByIdFase;
    }
}
