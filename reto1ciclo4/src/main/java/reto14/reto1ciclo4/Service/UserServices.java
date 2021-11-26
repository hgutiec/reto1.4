package reto14.reto1ciclo4.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto14.reto1ciclo4.model.user;
import reto14.reto1ciclo4.repositorio.UserRepository;
import java.util.Optional;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<user> getAll() {
        return userRepository.getAll();
    }

    public Optional<user> getUser(int id) {
        return userRepository.getUser(id);
    }

    public user registrar(user user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public user autenticarUsuario(String email, String password) {
        Optional<user> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new user(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }


}
