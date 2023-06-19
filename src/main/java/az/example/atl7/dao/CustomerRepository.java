package az.example.atl7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

//    @Query(value = "select c from CustomerEntity c where c.birthDate = :id", nativeQuery = false)
//    CustomerEntity myFindByName(Long id);
//
//    Optional<CustomerEntity> findBySurnameAndName(String surname);
}
