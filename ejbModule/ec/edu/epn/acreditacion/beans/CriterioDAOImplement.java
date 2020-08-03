package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.entities.Criterio;
import ec.edu.epn.catalogos.entities.Carrera;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class CriterioDAOImplement
 */
@Stateless
@LocalBean
public class CriterioDAOImplement extends DaoGenericoImplement<Criterio> implements CriterioDAO {

	

}
