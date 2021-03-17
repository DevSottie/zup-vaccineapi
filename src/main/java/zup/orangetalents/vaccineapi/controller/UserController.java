package zup.orangetalents.vaccineapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zup.orangetalents.vaccineapi.model.User;
import zup.orangetalents.vaccineapi.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/user")
    public List<User> listUsers(){
        return userRepository.findAll();
    }
}
