package ec.edu.epn.rrhh.beans;



import java.util.List;

import javax.ejb.Remote;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.RiesgosLaborale;
import ec.edu.epn.rrhh.movimientos.AccionP;

@Remote
public interface RiesgosLaboraleDAO extends DaoGenerico<RiesgosLaborale> {

	public Integer getMaxId();

	public List<RiesgosLaborale> findRiesgoxEmp(String nombreAccion);

	

}
