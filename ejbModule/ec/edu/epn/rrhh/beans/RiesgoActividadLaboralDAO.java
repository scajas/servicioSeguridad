package ec.edu.epn.rrhh.beans;



import javax.ejb.Remote;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.CatalogoRiesgoLaboral;
import ec.edu.epn.rrhh.entities.RiesgoActividad;
import ec.edu.epn.rrhh.entities.RiesgosLaborale;
import ec.edu.epn.rrhh.movimientos.AccionP;

@Remote
public interface RiesgoActividadLaboralDAO extends DaoGenerico<RiesgoActividad> {

	public Integer getMaxId();



	

}
