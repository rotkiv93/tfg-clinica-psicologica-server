package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import es.udc.lbd.tfg.clinica.model.domain.User;

public interface UserDAO {
	    List<User> findAll();

	    void save(User user);

	    User findByLogin(String login);

	    User findById(Long id);
}
