package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.domain.Paciente;
import es.udc.lbd.tfg.clinica.model.domain.Sesion;
import es.udc.lbd.tfg.clinica.model.repository.util.GenericDAOHibernate;

@Repository
public class SesionDAOHibernate extends GenericDAOHibernate implements SesionDAO {

	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	@Override
	public List<Sesion> findAll() {
		return getSession().createQuery("from Sesion").list();
	}

	@Override
	public Sesion findById(Long id) {
		return (Sesion) getSession().createQuery("from Sesion p where p.id = :id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public void save(Sesion sesion) {
		getSession().saveOrUpdate(sesion);

	}

	@Override
	public void deleteById(Long id) {
		getSession().delete(findById(id));
	}

	@Override
	public List<Sesion> findAllSesionsOfPacientAndMedic(Paciente paciente, Medico medico) {
		Paciente pac = pacienteDAO.findById(paciente.getId());
		Medico med = medicoDAO.findById(medico.getId());
		return getSession().createQuery("from Sesion p where (p.paciente = :paciente) and (p.medico = :medico)")
				.setParameter("paciente", pac).setParameter("medico", med).list();
	}

	@Override
	public List<Sesion> findAllSesionsOfPacient(Paciente paciente) {
		Paciente pac = pacienteDAO.findById(paciente.getId());
		return getSession().createQuery("from Sesion p where p.paciente = :paciente")
				.setParameter("paciente", pac).list();
	}
	@Override
	public List<Sesion> findAllSesionsOfMedic(Medico medico) {
		Medico med = medicoDAO.findById(medico.getId());
		return getSession().createQuery("from Sesion p where p.medico = :medico")
				.setParameter("medico", med).list();
	}
}
