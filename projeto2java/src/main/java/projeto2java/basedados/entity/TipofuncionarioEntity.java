package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tipofuncionario", schema = "public", catalog = "databaseprojeto2")
public class TipofuncionarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipofuncionario")
    private int idTipofuncionario;
    @Basic
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "tipofuncionarioByIdTipofuncionario")
    private Collection<FuncionarioEntity> funcionariosByIdTipofuncionario;

    public int getIdTipofuncionario() {
        return idTipofuncionario;
    }

    public void setIdTipofuncionario(int idTipofuncionario) {
        this.idTipofuncionario = idTipofuncionario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipofuncionarioEntity that = (TipofuncionarioEntity) o;

        if (idTipofuncionario != that.idTipofuncionario) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipofuncionario;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public Collection<FuncionarioEntity> getFuncionariosByIdTipofuncionario() {
        return funcionariosByIdTipofuncionario;
    }

    public void setFuncionariosByIdTipofuncionario(Collection<FuncionarioEntity> funcionariosByIdTipofuncionario) {
        this.funcionariosByIdTipofuncionario = funcionariosByIdTipofuncionario;
    }
}
