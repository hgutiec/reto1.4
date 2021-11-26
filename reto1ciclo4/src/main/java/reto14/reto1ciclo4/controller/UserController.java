package reto14.reto1ciclo4.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reto14.reto1ciclo4.model.user;
import reto14.reto1ciclo4.Service.UserServices;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServices userService;

    @GetMapping("/all")
    public List<user> getAll() {
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public user registrar(@RequestBody user user) {
        return userService.registrar(user);
    }

    @GetMapping("/{email}/{password}")
    public user autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
}