package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "loterecebido", schema = "public", catalog = "databaseprojeto2")
public class LoterecebidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_loterecebido")
    private int idLoterecebido;
    @Basic
    @Column(name = "id_funcionario")
    private int idFuncionario;
    @Basic
    @Column(name = "id_encomenda")
    private int idEncomenda;
    @Basic
    @Column(name = "qtdrecebida")
    private int qtdrecebida;
    @OneToMany(mappedBy = "loterecebidoByIdLoterecebido")
    private Collection<LoteinputEntity> loteinputsByIdLoterecebido;
    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario",nullable = false, updatable = false, insertable = false)
    private FuncionarioEntity funcionarioByIdFuncionario;
    @ManyToOne
    @JoinColumn(name = "id_encomenda", referencedColumnName = "id_encomenda", nullable = false, updatable = false, insertable = false)
    private EncomendaEntity encomendaByIdEncomenda;

    public int getIdLoterecebido() {
        return idLoterecebido;
    }

    public void setIdLoterecebido(int idLoterecebido) {
        this.idLoterecebido = idLoterecebido;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public int getQtdrecebida() {
        return qtdrecebida;
    }

    public void setQtdrecebida(int qtdrecebida) {
        this.qtdrecebida = qtdrecebida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoterecebidoEntity that = (LoterecebidoEntity) o;

        if (idLoterecebido != that.idLoterecebido) return false;
        if (idFuncionario != that.idFuncionario) return false;
        if (idEncomenda != that.idEncomenda) return false;
        if (qtdrecebida != that.qtdrecebida) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLoterecebido;
        result = 31 * result + idFuncionario;
        result = 31 * result + idEncomenda;
        result = 31 * result + qtdrecebida;
        return result;
    }

    public Collection<LoteinputEntity> getLoteinputsByIdLoterecebido() {
        return loteinputsByIdLoterecebido;
    }

    public void setLoteinputsByIdLoterecebido(Collection<LoteinputEntity> loteinputsByIdLoterecebido) {
        this.loteinputsByIdLoterecebido = loteinputsByIdLoterecebido;
    }

    public FuncionarioEntity getFuncionarioByIdFuncionario() {
        return funcionarioByIdFuncionario;
    }

    public void setFuncionarioByIdFuncionario(FuncionarioEntity funcionarioByIdFuncionario) {
        this.funcionarioByIdFuncionario = funcionarioByIdFuncionario;
    }

    public EncomendaEntity getEncomendaByIdEncomenda() {
        return encomendaByIdEncomenda;
    }

    public void setEncomendaByIdEncomenda(EncomendaEntity encomendaByIdEncomenda) {
        this.encomendaByIdEncomenda = encomendaByIdEncomenda;
    }
}
