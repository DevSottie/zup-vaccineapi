package zup.orangetalents.vaccineapi.model;

import org.hibernate.validator.constraints.br.CPF;
import zup.orangetalents.vaccineapi.ValidationGroups;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class User {
    @NotNull(groups = ValidationGroups.UserId.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Size(max = 60)
    @Column(name = "user_nome")
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    @Column(name = "user_email")
    private String email;

    @NotBlank
    @CPF
    @Size(max = 14)
    @Column(name = "user_cpf")
    private String cpf;

    @NotBlank
    @Column(name = "user_birthdate")
    private String birthDate;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
