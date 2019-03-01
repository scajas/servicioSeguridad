package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Publicacione;

@Local
public interface PublicacionesDAO extends DaoGenerico<Publicacione>{

	List<Publicacione> listaPublicacionesXCedula(String cedula, 
			String validarecategoriza, String validarevaloriza,String clase, String tipoPublicacion
			,String medio, String titulo, String idperiodo, boolean ordenPeriodo);

	int countPublicacionXCedula(String cedula, String tituloPub, String medio, String idPeriodo,
			Publicacione publicaciones) throws Exception;

	List<Publicacione> findPublicacionVIPS(String vips, String idtipoPub);

	int consultarNumeroSerial(int anio, String idtipo, String coddep);

	List<String> findCodigosSinRepetir(String idtipoPub, Integer año, String coddep, String autores, String calalog);

	List<Publicacione> findPublicacionesReporte(String codigoPublicacion);

	List<Publicacione> listPublicacionesTipo(String nced, List<String> tipo, String idPeriodo) throws Exception;

	List<Publicacione> listaPublicacionesXProyectoAC(String cedula, String tipoPublic, Integer idpensum,
			Integer idproyecto, String titulo);

	List<Publicacione> listaPublicacionesXProyectoPonencia(String cedula, String tipoPublic, Integer idpensum,
			Integer idproyecto, String titulo);

	List<Publicacione> listaPublicacionesXProyectoACReporte(String tipoPublic, Integer idpensum, Integer idproyecto);

}
