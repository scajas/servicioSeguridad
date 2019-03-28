package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Presentacion;


@Stateless
@LocalBean
public class PresentacionDAOImplement extends DaoGenericoImplement<Presentacion> implements PresentacionDAO {

   
    public PresentacionDAOImplement() {
        
    }

}
