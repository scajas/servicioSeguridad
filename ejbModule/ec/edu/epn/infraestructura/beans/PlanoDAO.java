package ec.edu.epn.infraestructura.beans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.PisoInfra;
import ec.edu.epn.infraestructura.entities.Plano;

@Local
public interface PlanoDAO extends DaoGenerico<Plano> {

	int consultarId();

	List<Plano> listarPlanos();

	List<Plano> buscarPlanos(int plano);

	List<Plano> buscarPlanoXNombre(String nombrePlano);

	List<Plano> buscarPlanoXEstado(String estadoPlano);

	List<Plano> buscarPlanoXEdificio(EdificioInfra nombreEdificio);

	List<PisoInfra> buscarPlanoXPiso(Plano plano);

	List<Plano> buscarPlanoXPiso(PisoInfra codPiso);

	boolean ingresarImagen(String pathImagen, int id_plano);

	byte[] obtenerImagen(int id_plano) throws SQLException;

}
