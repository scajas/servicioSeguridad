package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.DatosSaewAula;

@Local
public interface DatosSaewAulasDAO extends DaoGenerico<DatosSaewAula> {

	int consultarId();

	List<DatosSaewAula> listadeFacultades(int codfacu);

	List<DatosSaewAula> listaDatosAulas(int codcarrera, String codmateria,
			String paralelo);

}
