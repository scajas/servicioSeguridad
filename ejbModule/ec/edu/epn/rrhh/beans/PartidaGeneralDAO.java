package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.PartidaGeneral;

@Remote
public interface PartidaGeneralDAO extends DaoGenerico<PartidaGeneral>{

	public List<PartidaGeneral> getAllPartidasGenerales();
	
	public List<PartidaGeneral> getPartidasGeneralesActivas();
	
	public int getMaxIDPartidasGenerales();
	
	public boolean isPartidaAntigua(String numeroPartida);
}
