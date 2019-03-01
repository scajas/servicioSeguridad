package ec.edu.epn.proyectos.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Convocatoria;
import ec.edu.epn.proyectos.entities.ProyectoP;

import java.util.List;

@Local
public interface ProyectoPDAO extends DaoGenerico<ProyectoP> {

	Long countProyectosXNced(String nced);

	List<ProyectoP> findproyectosReporte(Integer idtipo, String area, String codigo, Integer idlinea, String coddep,
			String cedula, String estado, Integer anio);

	List<ProyectoP> findproyectos(String coddep, String nombre, String cedula);

	List<ProyectoP> buscarProyectoExiste(String codigo) throws Exception;

	Convocatoria finconv(String idconv) throws Exception;

	int consultarNumeroSerial(int anio, int idtipo);

	ProyectoP buscarProyecto(Integer idProy) throws Exception;
	
	
}
