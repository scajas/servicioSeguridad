package ec.edu.epn.proyectos.beans;

import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;

import ec.edu.epn.proyectos.entities.Objetivo;
import ec.edu.epn.proyectos.entities.ProyectoObjetivo;

/**
 * Session Bean implementation class ObjetivoDAOImplement
 */
@Stateless
public class ObjetivoDAOImplement extends DaoGenericoImplement<Objetivo>  implements ObjetivoDAO {

    /**
     * Default constructor. 
     */
    public ObjetivoDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
