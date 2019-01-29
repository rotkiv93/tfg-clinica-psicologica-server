package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.repository.util.GenericDAOHibernate;

@Repository
public class MedicoDAOHibernate extends GenericDAOHibernate  implements MedicoDAO {

	@Override
	public List<Medico> findAll() {
		return getSession().createQuery("from Medico").list();
	}

	@Override
	public Medico findById(Long id) {
		 return (Medico) getSession().createQuery("from Medico p where p.id = :id").setParameter("id", id).uniqueResult();
	}

	@Override
	public void save(Medico medico) {
	    getSession().saveOrUpdate(medico);
	}

	@Override
	public void deleteById(Long id) {
	     getSession().delete(findById(id));
	}

}
