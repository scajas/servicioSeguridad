package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Estadoproducto;


@Stateless
@LocalBean
public class EstadoProductoDAOImplement extends DaoGenericoImplement<Estadoproducto> implements EstadoProductoDAO {

  
    public EstadoProductoDAOImplement() {
       
    }

}
