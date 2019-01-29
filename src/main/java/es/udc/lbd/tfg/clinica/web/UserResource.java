package es.udc.lbd.tfg.clinica.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.udc.lbd.tfg.clinica.model.service.UserService;
import es.udc.lbd.tfg.clinica.model.service.dto.UserDTOPublic;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTOPublic> findAll() {
        return userService.findAll();
    }
}
