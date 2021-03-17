package zup.orangetalents.vaccineapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.vaccineapi.dto.VaccineModel;
import zup.orangetalents.vaccineapi.model.Vaccine;
import zup.orangetalents.vaccineapi.repository.VaccineRepository;
import zup.orangetalents.vaccineapi.service.VaccineService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineModel criar(@Valid @RequestBody Vaccine vaccine){
        return toModel(vaccineService.adicionaVacina(vaccine));
    }

    @GetMapping
    public List<VaccineModel> listaVacinas(){
        return toCollectionModel(vaccineRepository.findAll());
    }

    @GetMapping("/{vaccineId}")
    public ResponseEntity<VaccineModel> buscaVacinas(@PathVariable Long vaccineId){
        Optional<Vaccine> vaccine =  vaccineRepository.findById(vaccineId);

        if (vaccine.isPresent()){
            VaccineModel vaccineModel = toModel(vaccine.get());
            return ResponseEntity.ok(vaccineModel);
        }
        return ResponseEntity.notFound().build();
    }

    private VaccineModel toModel(Vaccine vaccine){
        return modelMapper.map(vaccine, VaccineModel.class);
    }
    private List<VaccineModel> toCollectionModel(List<Vaccine> vaccines){
        return vaccines.stream()
                .map(vaccine -> toModel(vaccine))
                .collect(Collectors.toList());
    }
}
