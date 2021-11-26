package reto14.reto1ciclo4.repositorio.crud;
import org.springframework.data.repository.CrudRepository;
import reto14.reto1ciclo4.model.user;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<user, Integer> {

    Optional<user> findByEmail(String email);
    Optional<user> findByEmailAndPassword(String email, String password);
}
