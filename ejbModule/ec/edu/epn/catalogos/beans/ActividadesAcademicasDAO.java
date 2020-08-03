package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.ActividadesAcademica;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.PlanifDocente;

@Local
public interface ActividadesAcademicasDAO extends DaoGenerico<ActividadesAcademica> {
	int consultarId();

	List<ActividadesAcademica> actividadesByTipo(String actividad);
	
	List<ActividadesAcademica> buscarActivdiadesDocentes(String docencia);

	List<ActividadesAcademica> buscarActivdiadesInvestigacion(
			String investigacion);

	List<ActividadesAcademica> buscarActivdiadesGestion(String gestion);

	List<ActividadesAcademica> buscarActivdiadesActualizacion(
			String actualizacion);

	List<PlanifDocente> verificarEvaluacionRegistrada(String cedula,
			String periodo);

	List<PlanifDocente> verificarEvaluacionRegistradaXcedula(String cedula);


}
