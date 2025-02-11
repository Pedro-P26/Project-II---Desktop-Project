package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "loteintermedio", schema = "public", catalog = "databaseprojeto2")
public class LoteintermedioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_loteintermedio")
    private int idLoteintermedio;
    @Basic
    @Column(name = "id_tipoproduto")
    private int idTipoproduto;
    @Basic
    @Column(name = "id_fase")
    private int idFase;
    @Basic
    @Column(name = "qtd")
    private int qtd;
    @Basic
    @Column(name = "datahoraemissao")
    private int datahoraemissao;
    @OneToMany(mappedBy = "loteintermedioByIdLoteintermedio")
    private Collection<LoteinputEntity> loteinputsByIdLoteintermedio;
    @ManyToOne
    @JoinColumn(name = "id_tipoproduto", referencedColumnName = "id_tipoproduto", nullable = false, updatable = false, insertable = false)
    private TipoprodutoEntity tipoprodutoByIdTipoproduto;
    @ManyToOne
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase",nullable = false, updatable = false, insertable = false)
    private FaseproducaoEntity faseproducaoByIdFase;

    public int getIdLoteintermedio() {
        return idLoteintermedio;
    }

    public void setIdLoteintermedio(int idLoteintermedio) {
        this.idLoteintermedio = idLoteintermedio;
    }

    public int getIdTipoproduto() {
        return idTipoproduto;
    }

    public void setIdTipoproduto(int idTipoproduto) {
        this.idTipoproduto = idTipoproduto;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getDatahoraemissao() {
        return datahoraemissao;
    }

    public void setDatahoraemissao(int datahoraemissao) {
        this.datahoraemissao = datahoraemissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoteintermedioEntity that = (LoteintermedioEntity) o;

        if (idLoteintermedio != that.idLoteintermedio) return false;
        if (idTipoproduto != that.idTipoproduto) return false;
        if (idFase != that.idFase) return false;
        if (qtd != that.qtd) return false;
        if (datahoraemissao != that.datahoraemissao) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLoteintermedio;
        result = 31 * result + idTipoproduto;
        result = 31 * result + idFase;
        result = 31 * result + qtd;
        result = 31 * result + datahoraemissao;
        return result;
    }

    public Collection<LoteinputEntity> getLoteinputsByIdLoteintermedio() {
        return loteinputsByIdLoteintermedio;
    }

    public void setLoteinputsByIdLoteintermedio(Collection<LoteinputEntity> loteinputsByIdLoteintermedio) {
        this.loteinputsByIdLoteintermedio = loteinputsByIdLoteintermedio;
    }

    public TipoprodutoEntity getTipoprodutoByIdTipoproduto() {
        return tipoprodutoByIdTipoproduto;
    }

    public void setTipoprodutoByIdTipoproduto(TipoprodutoEntity tipoprodutoByIdTipoproduto) {
        this.tipoprodutoByIdTipoproduto = tipoprodutoByIdTipoproduto;
    }

    public FaseproducaoEntity getFaseproducaoByIdFase() {
        return faseproducaoByIdFase;
    }

    public void setFaseproducaoByIdFase(FaseproducaoEntity faseproducaoByIdFase) {
        this.faseproducaoByIdFase = faseproducaoByIdFase;
    }
}
