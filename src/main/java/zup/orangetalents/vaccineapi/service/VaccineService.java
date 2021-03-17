package zup.orangetalents.vaccineapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.orangetalents.vaccineapi.exception.UserException;
import zup.orangetalents.vaccineapi.model.User;
import zup.orangetalents.vaccineapi.model.Vaccine;
import zup.orangetalents.vaccineapi.repository.UserRepository;
import zup.orangetalents.vaccineapi.repository.VaccineRepository;

import java.time.LocalDateTime;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private UserRepository userRepository;

    public Vaccine adicionaVacina(Vaccine vaccine){
        User user = userRepository.findById(vaccine.getUser().getId())
                .orElseThrow(() -> new UserException("Usuário não encontrado"));

        vaccine.setUser(user);
        vaccine.setDataAplicacao(LocalDateTime.now().toString());
        return vaccineRepository.save(vaccine);
    }
}
