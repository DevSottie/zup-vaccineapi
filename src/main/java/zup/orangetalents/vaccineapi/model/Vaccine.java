package zup.orangetalents.vaccineapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import zup.orangetalents.vaccineapi.ValidationGroups;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.Objects;

@Entity
public class Vaccine {

    @Id
    @Column(name = "vaccine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "vaccine_name")
    private String nome;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.UserId.class)
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_user")
    private User user;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "vaccine_dataaplicacao")
    private String dataAplicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return id.equals(vaccine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
