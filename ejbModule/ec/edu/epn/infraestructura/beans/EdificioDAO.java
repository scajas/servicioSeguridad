package ec.edu.epn.infraestructura.beans;

import java.util.List;


import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.LugarEspacio;
import ec.edu.epn.infraestructura.entities.TipoInfraestructura;

@Remote
public interface EdificioDAO extends DaoGenerico<EdificioInfra> {
	public int maxEdifico();

	public List<EdificioInfra> buscarEdificioXNombre(String NombreEd);

	public List<EdificioInfra> buscarEdificioXCodigo(String CodigoEd);

	int consultarId();

	List<EdificioInfra> listarEdificio();

	List<EdificioInfra> buscarEdificio(int edif);

	List<LugarEspacio> buscarEdificioXLugarEspacio(EdificioInfra EdificioInfra);

	public List<EdificioInfra> buscarEdificioXTipoInfra(TipoInfraestructura tipoInfra);


}
