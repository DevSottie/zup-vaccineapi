package zup.orangetalents.vaccineapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.vaccineapi.model.User;
import zup.orangetalents.vaccineapi.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listUsers(){
        return userRepository.findAll();
//        return userRepository.findByNome("Beatriz Daniela Laís Martins");
//        return userRepository.findByNomeContaining("Beatriz");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> buscar(@PathVariable Long userId){
        Optional<User> user =  userRepository.findById(userId);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
//            return new ResponseEntity<User>(user.get(), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User adiciona(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> atualizar(@Valid @PathVariable Long userId, @RequestBody User user){
        if(!userRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }

        user.setId(userId);
        user = userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> remover(@PathVariable Long userId){
        if (!userRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
