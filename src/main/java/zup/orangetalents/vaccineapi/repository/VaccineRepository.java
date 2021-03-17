package zup.orangetalents.vaccineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zup.orangetalents.vaccineapi.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
