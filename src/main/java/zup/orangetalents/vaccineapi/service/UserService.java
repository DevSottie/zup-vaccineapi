package zup.orangetalents.vaccineapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.orangetalents.vaccineapi.exception.UserException;
import zup.orangetalents.vaccineapi.model.User;
import zup.orangetalents.vaccineapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User salvar(User user){
        User userExists = userRepository.findByEmail(user.getEmail());

        if (userExists != null && !userExists.equals(user)){
            throw new UserException("E-mail já cadastrado.");
        }

        return userRepository.save(user);
    }

    public void excluir(Long userId){
        userRepository.deleteById(userId);
    }
}
