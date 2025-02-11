package projeto2java.basedados.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loteinput", schema = "public", catalog = "databaseprojeto2")
public class LoteinputEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_loteinput")
    private int idLoteinput;
    @Basic
    @Column(name = "id_loteintermedio")
    private int idLoteintermedio;
    @Basic
    @Column(name = "id_fase")
    private int idFase;
    @Basic
    @Column(name = "id_loterecebido")
    private int idLoterecebido;
    @Basic
    @Column(name = "qtd")
    private int qtd;
    @ManyToOne
    @JoinColumn(name = "id_loteintermedio", referencedColumnName = "id_loteintermedio",nullable = false, updatable = false, insertable = false)
    private LoteintermedioEntity loteintermedioByIdLoteintermedio;
    @ManyToOne
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase", nullable = false, updatable = false, insertable = false)
    private FaseproducaoEntity faseproducaoByIdFase;
    @ManyToOne
    @JoinColumn(name = "id_loterecebido", referencedColumnName = "id_loterecebido",nullable = false, updatable = false, insertable = false)
    private LoterecebidoEntity loterecebidoByIdLoterecebido;

    public int getIdLoteinput() {
        return idLoteinput;
    }

    public void setIdLoteinput(int idLoteinput) {
        this.idLoteinput = idLoteinput;
    }

    public int getIdLoteintermedio() {
        return idLoteintermedio;
    }

    public void setIdLoteintermedio(int idLoteintermedio) {
        this.idLoteintermedio = idLoteintermedio;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public int getIdLoterecebido() {
        return idLoterecebido;
    }

    public void setIdLoterecebido(int idLoterecebido) {
        this.idLoterecebido = idLoterecebido;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoteinputEntity that = (LoteinputEntity) o;

        if (idLoteinput != that.idLoteinput) return false;
        if (idLoteintermedio != that.idLoteintermedio) return false;
        if (idFase != that.idFase) return false;
        if (idLoterecebido != that.idLoterecebido) return false;
        if (qtd != that.qtd) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLoteinput;
        result = 31 * result + idLoteintermedio;
        result = 31 * result + idFase;
        result = 31 * result + idLoterecebido;
        result = 31 * result + qtd;
        return result;
    }

    public LoteintermedioEntity getLoteintermedioByIdLoteintermedio() {
        return loteintermedioByIdLoteintermedio;
    }

    public void setLoteintermedioByIdLoteintermedio(LoteintermedioEntity loteintermedioByIdLoteintermedio) {
        this.loteintermedioByIdLoteintermedio = loteintermedioByIdLoteintermedio;
    }

    public FaseproducaoEntity getFaseproducaoByIdFase() {
        return faseproducaoByIdFase;
    }

    public void setFaseproducaoByIdFase(FaseproducaoEntity faseproducaoByIdFase) {
        this.faseproducaoByIdFase = faseproducaoByIdFase;
    }

    public LoterecebidoEntity getLoterecebidoByIdLoterecebido() {
        return loterecebidoByIdLoterecebido;
    }

    public void setLoterecebidoByIdLoterecebido(LoterecebidoEntity loterecebidoByIdLoterecebido) {
        this.loterecebidoByIdLoterecebido = loterecebidoByIdLoterecebido;
    }
}
