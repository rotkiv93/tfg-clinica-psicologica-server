package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.lbd.tfg.clinica.model.domain.User;
import es.udc.lbd.tfg.clinica.model.repository.util.GenericDAOHibernate;

@Repository
	public class UserDAOHibernate extends GenericDAOHibernate implements UserDAO {

	    @Override
	    public List<User> findAll() {
	        return getSession().createQuery("from User").list();
	    }

	    @Override
	    public void save(User user) {
	        getSession().saveOrUpdate(user);
	    }

	    @Override
	    public User findByLogin(String login) {
	        return (User) getSession().createQuery("from User where login = :login").setParameter("login", login)
	                .uniqueResult();
	    }

	    @Override
	    public User findById(Long id) {
	        return (User) getSession().createQuery("from User where id = :id").setParameter("id", id).uniqueResult();
	    }

}
