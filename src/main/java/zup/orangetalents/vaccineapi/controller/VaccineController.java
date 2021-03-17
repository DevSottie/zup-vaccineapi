package zup.orangetalents.vaccineapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.vaccineapi.model.Vaccine;
import zup.orangetalents.vaccineapi.repository.VaccineRepository;
import zup.orangetalents.vaccineapi.service.VaccineService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{vaccineId}")
    public ResponseEntity<Vaccine> buscaVacinas(@PathVariable Long vaccineId){
        Optional<Vaccine> vaccine =  vaccineRepository.findById(vaccineId);

        if (vaccine.isPresent()){
            return ResponseEntity.ok(vaccine.get());
        }

        return ResponseEntity.notFound().build();
    }
}
