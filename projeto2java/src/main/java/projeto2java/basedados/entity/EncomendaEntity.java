package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "encomenda", schema = "public", catalog = "databaseprojeto2")
public class EncomendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_encomenda")
    private int idEncomenda;
    @Basic
    @Column(name = "id_fornecedor")
    private int idFornecedor;
    @Basic
    @Column(name = "id_estadoencomenda")
    private int  idEstadoencomenda;
    @Basic
    @Column(name = "id_funcionario")
    private int idFuncionario;
    @Basic
    @Column(name = "dataemissao")
    private Date dataemissao;
    @Basic
    @Column(name = "datachegada")
    private Date datachegada;
    @Basic
    @Column(name = "n_envio")
    private int nEnvio;
    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor", nullable = false, updatable = false, insertable = false)
    private FornecedorEntity fornecedorByIdFornecedor;
    @ManyToOne
    @JoinColumn(name = "id_estadoencomenda", referencedColumnName = "id_estadoencomenda", nullable = false, updatable = false, insertable = false)
    private EstadoencomendaEntity estadoencomendaByIdEstadoencomenda;
    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario", nullable = false, updatable = false, insertable = false)
    private FuncionarioEntity funcionarioByIdFuncionario;
    @OneToMany(mappedBy = "encomendaByIdEncomenda")
    private Collection<LoterecebidoEntity> loterecebidosByIdEncomenda;

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdEstadoencomenda() {
        return idEstadoencomenda;
    }

    public void setIdEstadoencomenda(int idEstadoencomenda) {
        this.idEstadoencomenda = idEstadoencomenda;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getDatachegada() {
        return datachegada;
    }

    public void setDatachegada(Date datachegada) {
        this.datachegada = datachegada;
    }

    public int getnEnvio() {
        return nEnvio;
    }

    public void setnEnvio(int nEnvio) {
        this.nEnvio = nEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncomendaEntity that = (EncomendaEntity) o;

        if (idEncomenda != that.idEncomenda) return false;
        if (idFornecedor != that.idFornecedor) return false;
        if (idEstadoencomenda != that.idEstadoencomenda) return false;
        if (idFuncionario != that.idFuncionario) return false;
        if (nEnvio != that.nEnvio) return false;
        if (dataemissao != null ? !dataemissao.equals(that.dataemissao) : that.dataemissao != null) return false;
        if (datachegada != null ? !datachegada.equals(that.datachegada) : that.datachegada != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEncomenda;
        result = 31 * result + idFornecedor;
        result = 31 * result + idEstadoencomenda;
        result = 31 * result + idFuncionario;
        result = 31 * result + (dataemissao != null ? dataemissao.hashCode() : 0);
        result = 31 * result + (datachegada != null ? datachegada.hashCode() : 0);
        result = 31 * result + nEnvio;
        return result;
    }

    public FornecedorEntity getFornecedorByIdFornecedor() {
        return fornecedorByIdFornecedor;
    }

    public void setFornecedorByIdFornecedor(FornecedorEntity fornecedorByIdFornecedor) {
        this.fornecedorByIdFornecedor = fornecedorByIdFornecedor;
    }

    public EstadoencomendaEntity getEstadoencomendaByIdEstadoencomenda() {
        return estadoencomendaByIdEstadoencomenda;
    }

    public void setEstadoencomendaByIdEstadoencomenda(EstadoencomendaEntity estadoencomendaByIdEstadoencomenda) {
        this.estadoencomendaByIdEstadoencomenda = estadoencomendaByIdEstadoencomenda;
    }

    public FuncionarioEntity getFuncionarioByIdFuncionario() {
        return funcionarioByIdFuncionario;
    }

    public void setFuncionarioByIdFuncionario(FuncionarioEntity funcionarioByIdFuncionario) {
        this.funcionarioByIdFuncionario = funcionarioByIdFuncionario;
    }

    public Collection<LoterecebidoEntity> getLoterecebidosByIdEncomenda() {
        return loterecebidosByIdEncomenda;
    }

    public void setLoterecebidosByIdEncomenda(Collection<LoterecebidoEntity> loterecebidosByIdEncomenda) {
        this.loterecebidosByIdEncomenda = loterecebidosByIdEncomenda;
    }
}
