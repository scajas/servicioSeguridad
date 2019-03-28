package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Grado;


@Stateless
@LocalBean
public class GradoDAOImplement extends DaoGenericoImplement<Grado> implements GradoDAO {

    
    public GradoDAOImplement() {
        
    }

    
}
