package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.Docadjunto;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboralPK;

@Remote
public interface DocAdjuntoDAO extends DaoGenerico<Docadjunto>{
	
	public Integer getMaxID();

	public Docadjunto getDocHist(Integer numhistoria);

	public Docadjunto getDocHistbyId(HistoriaLaboralPK id);

	public List<Docadjunto> getListDocHistbyId(HistoriaLaboralPK id);


}
