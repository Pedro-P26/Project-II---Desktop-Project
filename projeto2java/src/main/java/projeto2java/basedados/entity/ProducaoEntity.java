package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "producao", schema = "public", catalog = "databaseprojeto2")
public class ProducaoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producao")
    private int idProducao;
    /*@Basic
    @Column(name = "id_lotefinal")
    private int idLotefinal;*/
    @Basic
    @Column(name = "id_funcionario")
    private int idFuncionario;
    @Basic
    @Column(name = "id_fase")
    private int idFase;
    @Basic
    @Column(name = "datainicio")
    private Date datainicio;
    @Basic
    @Column(name = "datafim")
    private Date datafim;
    @Basic
    @Column(name = "qtdproducao")
    private int qtdproducao;
    @Basic
    @Column(name = "qtdmateriaprima")
    private int qtdmateriaprima;
    //@ManyToOne
    //@JoinColumn(name = "id_lotefinal", referencedColumnName = "id_lotefinal", nullable = false, updatable = false, insertable = false)
    //private LotefinalEntity lotefinalByIdLotefinal;
    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario",nullable = false, updatable = false, insertable = false)
    private FuncionarioEntity funcionarioByIdFuncionario;
    @ManyToOne
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase", nullable = false, updatable = false, insertable = false)
    private FaseproducaoEntity faseproducaoByIdFase;


    public int getQtdmateriaprima() {
        return qtdmateriaprima;
    }

    public void setQtdmateriaprima(int qtdmateriaprima) {
        this.qtdmateriaprima = qtdmateriaprima;
    }

    public int getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(int idProducao) {
        this.idProducao = idProducao;
    }

    /*public int getIdLotefinal() {
        return idLotefinal;
    }

    public void setIdLotefinal(int idLotefinal) {
        this.idLotefinal = idLotefinal;
    }*/

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public int getQtdproducao() {
        return qtdproducao;
    }

    public void setQtdproducao(int qtdproducao) {
        this.qtdproducao = qtdproducao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProducaoEntity that = (ProducaoEntity) o;

        if (idProducao != that.idProducao) return false;
        if (idFuncionario != that.idFuncionario) return false;
        if (idFase != that.idFase) return false;
        if (qtdproducao != that.qtdproducao) return false;
        if(qtdmateriaprima != that.qtdmateriaprima) return false;
        if (datainicio != null ? !datainicio.equals(that.datainicio) : that.datainicio != null) return false;
        if (datafim != null ? !datafim.equals(that.datafim) : that.datafim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProducao;
        result = 31 * result + idFuncionario;
        result = 31 * result + idFase;
        result = 31 * result + (datainicio != null ? datainicio.hashCode() : 0);
        result = 31 * result + (datafim != null ? datafim.hashCode() : 0);
        result = 31 * result + qtdproducao;
        result = 31 * result + qtdmateriaprima;
        return result;
    }

    /*public LotefinalEntity getLotefinalByIdLotefinal() {
        return lotefinalByIdLotefinal;
    }

    public void setLotefinalByIdLotefinal(LotefinalEntity lotefinalByIdLotefinal) {
        this.lotefinalByIdLotefinal = lotefinalByIdLotefinal;
    }*/

    public FuncionarioEntity getFuncionarioByIdFuncionario() {
        return funcionarioByIdFuncionario;
    }

    public void setFuncionarioByIdFuncionario(FuncionarioEntity funcionarioByIdFuncionario) {
        this.funcionarioByIdFuncionario = funcionarioByIdFuncionario;
    }

    public FaseproducaoEntity getFaseproducaoByIdFase() {
        return faseproducaoByIdFase;
    }

    public void setFaseproducaoByIdFase(FaseproducaoEntity faseproducaoByIdFase) {
        this.faseproducaoByIdFase = faseproducaoByIdFase;
    }
}
