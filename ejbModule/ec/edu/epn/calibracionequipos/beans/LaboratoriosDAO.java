package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Laboratorioscalibracionequipo;
import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.Dependencia;

@Local
public interface LaboratoriosDAO extends DaoGenerico<Laboratorioscalibracionequipo> {
	int consultarId();

	List<Laboratorioscalibracionequipo> findByParametros(FacultadCatalogos facultad, Dependencia departamento,
			Laboratorioscalibracionequipo laboratorio);
}
