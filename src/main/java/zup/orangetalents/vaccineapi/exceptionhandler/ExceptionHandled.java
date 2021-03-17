package zup.orangetalents.vaccineapi.exceptionhandler;

import java.time.LocalDateTime;

public class ExceptionHandled {
    private Integer status;
    private LocalDateTime dataHora;
    private String title;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
