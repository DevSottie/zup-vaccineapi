package zup.orangetalents.vaccineapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.vaccineapi.model.Vaccine;
import zup.orangetalents.vaccineapi.repository.VaccineRepository;
import zup.orangetalents.vaccineapi.service.VaccineService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private VaccineRepository vaccineRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine criar(@Valid @RequestBody Vaccine vaccine){
        return vaccineService.adicionaVacina(vaccine);
    }

    @GetMapping
    public List<Vaccine> listaVacinas(){
        return vaccineRepository.findAll();
    }
}
