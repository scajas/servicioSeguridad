package ec.edu.epn.proyectos.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.AuditoriaProy;

/**
 * Session Bean implementation class AuditoriaProyDAOImplement
 */
@Stateless
@LocalBean
public class AuditoriaProyDAOImplement extends DaoGenericoImplement<AuditoriaProy> implements AuditoriaProyDAO {

	
}
