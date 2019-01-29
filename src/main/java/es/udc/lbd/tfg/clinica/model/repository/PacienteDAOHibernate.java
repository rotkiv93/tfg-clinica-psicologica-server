package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.domain.Paciente;
import es.udc.lbd.tfg.clinica.model.repository.util.GenericDAOHibernate;

@Repository
public class PacienteDAOHibernate extends GenericDAOHibernate  implements PacienteDAO {

	@Override
	public List<Paciente> findAll() {
		return getSession().createQuery("from Paciente").list();
	}

	@Override
	public Paciente findById(Long id) {
		 return (Paciente) getSession().createQuery("from Paciente p where p.id = :id").setParameter("id", id).uniqueResult();
	}

	@Override
	public Paciente findByDNI(String DNI) {
		 return (Paciente) getSession().createQuery("from Paciente p where p.DNI = :DNI").setParameter("DNI",DNI).uniqueResult();
	}

	
	@Override
	public void save(Paciente paciente) {
		 getSession().saveOrUpdate(paciente);
	}

	@Override
	public void deleteById(Long id) {
	    getSession().delete(findById(id));
	}

}
