package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Metodo;

@Stateless
@LocalBean
public class MetodoDAOImplement extends DaoGenericoImplement<Metodo> implements MetodoDAO {

    public MetodoDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
