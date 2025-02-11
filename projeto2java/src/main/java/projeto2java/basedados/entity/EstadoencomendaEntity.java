package projeto2java.basedados.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "estadoencomenda", schema = "public", catalog = "databaseprojeto2")
public class EstadoencomendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_estadoencomenda")
    private int idEstadoencomenda;
    @Basic
    @Column(name = "tipoestado")
    private String tipoestado;
    @OneToMany(mappedBy = "estadoencomendaByIdEstadoencomenda")
    private Collection<EncomendaEntity> encomendasByIdEstadoencomenda;

    public int getIdEstadoencomenda() {
        return idEstadoencomenda;
    }

    public void setIdEstadoencomenda(int idEstadoencomenda) {
        this.idEstadoencomenda = idEstadoencomenda;
    }

    public String getTipoestado() {
        return tipoestado;
    }

    public void setTipoestado(String tipoestado) {
        this.tipoestado = tipoestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoencomendaEntity that = (EstadoencomendaEntity) o;

        if (idEstadoencomenda != that.idEstadoencomenda) return false;
        if (tipoestado != null ? !tipoestado.equals(that.tipoestado) : that.tipoestado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstadoencomenda;
        result = 31 * result + (tipoestado != null ? tipoestado.hashCode() : 0);
        return result;
    }

    public Collection<EncomendaEntity> getEncomendasByIdEstadoencomenda() {
        return encomendasByIdEstadoencomenda;
    }

    public void setEncomendasByIdEstadoencomenda(Collection<EncomendaEntity> encomendasByIdEstadoencomenda) {
        this.encomendasByIdEstadoencomenda = encomendasByIdEstadoencomenda;
    }
}
