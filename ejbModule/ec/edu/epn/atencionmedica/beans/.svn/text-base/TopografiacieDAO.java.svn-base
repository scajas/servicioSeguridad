package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Topografiacie;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TopografiacieDAO extends DaoGenerico<Topografiacie>{
	
	public List<Topografiacie> obtenerListaTopografias(String criterio, String busquedaPor);
	public Topografiacie obtenerTopografiaGrupo(String criterio);
	public Topografiacie obtenerTopografiaDiag(Integer idDiagDef);

}
