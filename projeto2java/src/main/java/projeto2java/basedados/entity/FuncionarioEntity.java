package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity

@Table(name = "funcionario", schema = "public", catalog = "databaseprojeto2")
public class FuncionarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_funcionario")
    private int idFuncionario;
    @Basic
    @Column(name = "id_tipofuncionario")
    private int idTipofuncionario;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "localidade")
    private String localidade;
    @Basic
    @Column(name = "telefone")
    private int telefone;
    @Basic
    @Column(name = "salario")
    private int salario;
    @OneToMany(mappedBy = "funcionarioByIdFuncionario", cascade = CascadeType.ALL)
    private Collection<EncomendaEntity> encomendasByIdFuncionario;
    @ManyToOne
    @JoinColumn(name = "id_tipofuncionario", referencedColumnName = "id_tipofuncionario", nullable = false, updatable = false, insertable = false)
    private TipofuncionarioEntity tipofuncionarioByIdTipofuncionario;
    @OneToMany(mappedBy = "funcionarioByIdFuncionario",cascade = CascadeType.ALL)
    private Collection<LoterecebidoEntity> loterecebidosByIdFuncionario;
    @OneToMany(mappedBy = "funcionarioByIdFuncionario",cascade = CascadeType.ALL)
    private Collection<ProducaoEntity> producaosByIdFuncionario;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdTipofuncionario() {
        return idTipofuncionario;
    }

    public void setIdTipofuncionario(int idTipofuncionario) {
        this.idTipofuncionario = idTipofuncionario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuncionarioEntity that = (FuncionarioEntity) o;

        if (idFuncionario != that.idFuncionario) return false;
        if (idTipofuncionario != that.idTipofuncionario) return false;
        if (telefone != that.telefone) return false;
        if (salario != that.salario) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (localidade != null ? !localidade.equals(that.localidade) : that.localidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFuncionario;
        result = 31 * result + idTipofuncionario;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        result = 31 * result + telefone;
        result = 31 * result + salario;
        return result;
    }

    public Collection<EncomendaEntity> getEncomendasByIdFuncionario() {
        return encomendasByIdFuncionario;
    }

    public void setEncomendasByIdFuncionario(Collection<EncomendaEntity> encomendasByIdFuncionario) {
        this.encomendasByIdFuncionario = encomendasByIdFuncionario;
    }

    public TipofuncionarioEntity getTipofuncionarioByIdTipofuncionario() {
        return tipofuncionarioByIdTipofuncionario;
    }

    public void setTipofuncionarioByIdTipofuncionario(TipofuncionarioEntity tipofuncionarioByIdTipofuncionario) {
        this.tipofuncionarioByIdTipofuncionario = tipofuncionarioByIdTipofuncionario;
    }

    public Collection<LoterecebidoEntity> getLoterecebidosByIdFuncionario() {
        return loterecebidosByIdFuncionario;
    }

    public void setLoterecebidosByIdFuncionario(Collection<LoterecebidoEntity> loterecebidosByIdFuncionario) {
        this.loterecebidosByIdFuncionario = loterecebidosByIdFuncionario;
    }

    public Collection<ProducaoEntity> getProducaosByIdFuncionario() {
        return producaosByIdFuncionario;
    }

    public void setProducaosByIdFuncionario(Collection<ProducaoEntity> producaosByIdFuncionario) {
        this.producaosByIdFuncionario = producaosByIdFuncionario;
    }

    @Override
    public String toString() {
        return "FuncionarioEntity{" +
                "idFuncionario=" + idFuncionario +
                ", idTipofuncionario=" + idTipofuncionario +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", localidade='" + localidade + '\'' +
                ", telefone=" + telefone +
                ", salario=" + salario +
                '}';
    }
}
