package zup.orangetalents.vaccineapi.dto;

import javax.validation.constraints.NotNull;

public class UserIdDTO {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
