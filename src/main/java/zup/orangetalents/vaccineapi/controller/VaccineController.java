package zup.orangetalents.vaccineapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.vaccineapi.model.Vaccine;
import zup.orangetalents.vaccineapi.service.VaccineService;

@RestController
@RequestMapping("/api/v1/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine criar(@RequestBody Vaccine vaccine){
        return vaccineService.adicionaVacina(vaccine);
    }
}
