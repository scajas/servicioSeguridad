package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.DesignacionCatalogo;

@Remote
public interface DesignacionCatalogoDAO extends DaoGenerico<DesignacionCatalogo>{
	
	public int getMaxIDDesignacionCatalogo();
	
	public List<DesignacionCatalogo> findAllDesignacionesActivas();

	
	public List<DesignacionCatalogo> findAllDesignaciones();
	
	public List<DesignacionCatalogo> findDesignacionActivasByGrupo(String grupoDesignacion);	
	
	
	

}
