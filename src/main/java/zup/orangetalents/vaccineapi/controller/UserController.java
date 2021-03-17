package zup.orangetalents.vaccineapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.orangetalents.vaccineapi.dto.UserDTO;
import zup.orangetalents.vaccineapi.dto.UserModel;
import zup.orangetalents.vaccineapi.dto.VaccineDTO;
import zup.orangetalents.vaccineapi.model.User;
import zup.orangetalents.vaccineapi.repository.UserRepository;
import zup.orangetalents.vaccineapi.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<UserModel> listUsers(){
        return toCollectionModel(userRepository.findAll());
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
    public UserModel adiciona(@Valid @RequestBody UserDTO userDTO){
        User user = toEntity(userDTO);
        return toModel(userService.salvar(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> atualizar(@Valid @PathVariable Long userId, @RequestBody User user){
        if(!userRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }

        user.setId(userId);
        user = userService.salvar(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> remover(@PathVariable Long userId){
        if (!userRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }
        userService.excluir(userId);
        return ResponseEntity.noContent().build();
    }

    private UserModel toModel(User user){
        return modelMapper.map(user, UserModel.class);
    }

    private List<UserModel> toCollectionModel(List<User> users){
        return users.stream()
                .map(user -> toModel(user))
                .collect(Collectors.toList());
    }

    private User toEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}
