package ec.edu.epn.acreditacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.DTO.EquipoDocenteDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistributivoAcademicoDTO;

/**
 * Session Bean implementation class EquiposDocenteDAOImplement
 */
@Stateless
@LocalBean
public class EquiposDocenteDAOImplement implements EquiposDocenteDAO {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Default constructor.
	 */
	public EquiposDocenteDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	// public List<DocenteDistributivoDTO> reporteDocenteDistributivoDTO(String
	// var01, Integer identificador01) {
	public List<EquipoDocenteDTO> reporteDocenteDistributivoDTO(String var01) {

		EquipoDocenteDTO dto = new EquipoDocenteDTO();
		List<EquipoDocenteDTO> reporteDocenteDistributivoDTO = new ArrayList<EquipoDocenteDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {
			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporteDocentesEquipos(?)");
			query.setParameter(1, var01);
			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new EquipoDocenteDTO();
					dto.setCedula(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setRelacion(fila[2] == null ? "" : fila[2].toString());
					dto.setDedicacion(fila[3] == null ? "" : fila[3].toString());
					dto.setCargo(fila[4] == null ? "" : fila[4].toString());
					dto.setDepartamento(fila[5] == null ? "" : fila[5].toString());
					dto.setFacultad(fila[6] == null ? "" : fila[6].toString());
					dto.setTipo(fila[7] == null ? "" : fila[7].toString());
					dto.setEquipo(fila[8] == null ? "" : fila[8].toString());
					dto.setFasiganacion(fila[9] == null ? "" : fila[9].toString());
					dto.setAnio(fila[10] == null ? "" : fila[10].toString());
					dto.setBienes(fila[11] == null ? "" : fila[11].toString());
					reporteDocenteDistributivoDTO.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDTO;
	}

}
