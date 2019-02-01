package es.udc.lbd.tfg.clinica.config;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.tfg.clinica.model.domain.EstadoSesion;
import es.udc.lbd.tfg.clinica.model.domain.GeneroEnum;
import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.domain.Paciente;
import es.udc.lbd.tfg.clinica.model.domain.Sesion;
import es.udc.lbd.tfg.clinica.model.exception.UserLoginExistsException;
import es.udc.lbd.tfg.clinica.model.repository.MedicoDAO;
import es.udc.lbd.tfg.clinica.model.repository.PacienteDAO;
import es.udc.lbd.tfg.clinica.model.repository.SesionDAO;
import es.udc.lbd.tfg.clinica.model.repository.UserDAO;
import es.udc.lbd.tfg.clinica.model.service.UserService;

@Configuration
public class DatabaseLoader {
    private final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;
    
    @Autowired
    private MedicoDAO medicoDAO;
    
    @Autowired 
    private PacienteDAO pacienteDAO;

    @Autowired
    private SesionDAO sesionDAO;

    @Autowired
    private DatabaseLoader databaseLoader;

    /*
     * Para hacer que la carga de datos sea transacional, hay que cargar el propio
     * objeto como un bean y lanzar el método una vez cargado, ya que en el
     * PostConstruct (ni similares) se tienen en cuenta las anotaciones de
     * transaciones.
     */
    @PostConstruct
    public void init() {
        try {
            databaseLoader.loadData();
        } catch (UserLoginExistsException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void loadData() throws UserLoginExistsException {
        userService.registerUser("pepe", "pepe", true);
        userService.registerUser("maria", "maria", true);
        userService.registerUser("laura", "laura");
        userService.registerUser("pedro", "pedro");

        
        Medico medico = new Medico("Medico1", "Apellido1", "Apellido2", 3434434);
        medicoDAO.save(medico);
        
        Medico medico2 = new Medico("Medico2", "Apellido1_2", "Apellido2_2", 32432647);
        medicoDAO.save(medico2);
        
        Paciente paciente = new Paciente("Paciente1", "Apellido1", "Apellido2", "54131159S", GeneroEnum.Hombre, "victorlamas93@gmail.com",
        		LocalDate.of(2015, 02, 20), "Paseo de los puentes", 645355363);
        pacienteDAO.save(paciente);
        
        Sesion sesion1 = new Sesion(LocalDate.of(2019, 01, 12), EstadoSesion.Pendiente, medicoDAO.findById(1L), pacienteDAO.findById(1L));
        sesionDAO.save(sesion1);
        
    }
}
