package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.LugarEspacio;
import ec.edu.epn.infraestructura.entities.PisoInfra;

@Local
public interface PisoDAO extends DaoGenerico<PisoInfra> {
	public int maxPiso();

	public List<PisoInfra> buscarPisoXEdificio(int fkEdifico);

	int consultarId();

	List<LugarEspacio> listLugarEspacioxPiso(PisoInfra piso);

	List<PisoInfra> listarPisos();

	List<PisoInfra> buscarPiso(int piso);

	List<PisoInfra> buscarPisoXNombre(String nombrePiso, int idEdificio);

	List<PisoInfra> buscarPisoXNombre(String nombrePiso);

	List<PisoInfra> listarPisosxEdificio(int idEdificio);

	List<PisoInfra> buscarPisoXLugarEspacio(PisoInfra piso);

	// Para poder tomar los pisos de un edificio
	List<PisoInfra> buscarLugarEspacioXEdificio(EdificioInfra edif);
}
