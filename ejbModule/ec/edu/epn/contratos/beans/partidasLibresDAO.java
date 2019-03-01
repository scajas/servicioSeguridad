package ec.edu.epn.contratos.beans;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.PartidasLibre;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface partidasLibresDAO extends DaoGenerico<PartidasLibre> {

	List<PartidasLibre> buscarPartidaActiva();
	
	List<PartidasLibre> buscarPartidaContrato(int idCont);
	
	void updatePartidaLibre(PartidasLibre part);
	List<PartidasLibre> buscaPartidaXTipoContarto(int idtipoContrato);
	 
	
	public List<PartidasLibre> buscarReportePartidas(Integer idTipoContrato, String estado, String numeroPartida) throws Exception;
	
	
}
