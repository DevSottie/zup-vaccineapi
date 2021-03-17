package zup.orangetalents.vaccineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zup.orangetalents.vaccineapi.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNome(String nome);
    List<User> findByNomeContaining(String nome);
}
