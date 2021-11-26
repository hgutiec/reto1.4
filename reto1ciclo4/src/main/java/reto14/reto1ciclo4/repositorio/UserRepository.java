package reto14.reto1ciclo4.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto14.reto1ciclo4.model.user;
import reto14.reto1ciclo4.repositorio.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<user> getAll() {
        return (List<user>) userCrudRepository.findAll();
    }

    public Optional<user> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public user save(user user) {
        return userCrudRepository.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<user> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<user> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}