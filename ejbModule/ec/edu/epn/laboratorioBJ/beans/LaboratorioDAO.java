package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;

@Local
public interface LaboratorioDAO extends DaoGenerico<LaboratorioLab>{

	List<LaboratorioLab> listaLaboratorioUnidad(int id);

}

