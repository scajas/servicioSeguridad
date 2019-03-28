package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Hidratacion;


@Stateless
@LocalBean

public class HidratacionDAOImplement extends DaoGenericoImplement<Hidratacion> implements HidratacionDAO {
    
    public HidratacionDAOImplement() {
        
    }

}
