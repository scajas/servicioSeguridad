package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;

/**
 * Session Bean implementation class SaldoExistenciaDAOImplement
 */
@Stateless
@LocalBean
public class SaldoExistenciaDAOImplement extends DaoGenericoImplement<SaldoExistencia> implements SaldoExistenciaDAO {

    /**
     * Default constructor. 
     */
    public SaldoExistenciaDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
