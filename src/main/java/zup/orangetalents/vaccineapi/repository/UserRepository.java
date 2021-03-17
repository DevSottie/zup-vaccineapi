package zup.orangetalents.vaccineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zup.orangetalents.vaccineapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
