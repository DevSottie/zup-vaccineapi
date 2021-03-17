package zup.orangetalents.vaccineapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zup.orangetalents.vaccineapi.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class UserController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/api/v1/user")
    public List<User> listUsers(){
        return manager.createQuery("from User", User.class)// createNamedQuery é do JPA(JPQL ao invés de sql)
                .getResultList();
    }
}
