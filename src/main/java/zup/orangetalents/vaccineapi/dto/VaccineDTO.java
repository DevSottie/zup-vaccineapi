package zup.orangetalents.vaccineapi.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VaccineDTO {

    @NotBlank
    private String nome;

    @Valid
    @NotNull
    private UserIdDTO User;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UserIdDTO getUser() {
        return User;
    }

    public void setUser(UserIdDTO user) {
        User = user;
    }
}
