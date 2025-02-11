package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "fornecedor", schema = "public", catalog = "databaseprojeto2")
public class FornecedorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fornecedor")
    private int idFornecedor;
    @Basic
    @Column(name = "localidade")
    private String localidade;
    @Basic
    @Column(name = "telefone")
    private int telefone;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "fornecedorByIdFornecedor")
    private Collection<EncomendaEntity> encomendasByIdFornecedor;

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FornecedorEntity that = (FornecedorEntity) o;

        if (idFornecedor != that.idFornecedor) return false;
        if (telefone != that.telefone) return false;
        if (localidade != null ? !localidade.equals(that.localidade) : that.localidade != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFornecedor;
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        result = 31 * result + telefone;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<EncomendaEntity> getEncomendasByIdFornecedor() {
        return encomendasByIdFornecedor;
    }

    public void setEncomendasByIdFornecedor(Collection<EncomendaEntity> encomendasByIdFornecedor) {
        this.encomendasByIdFornecedor = encomendasByIdFornecedor;
    }



}
