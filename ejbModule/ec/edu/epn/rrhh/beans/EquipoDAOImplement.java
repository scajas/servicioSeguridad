package ec.edu.epn.rrhh.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.DTO.EquipoDTO;
import ec.edu.epn.rrhh.entities.Equipo;
import ec.edu.epn.rrhh.entities.TipoEquipo;

/**
 * Session Bean implementation class EmpleadosServiceBean
 */
@Stateless
public class EquipoDAOImplement extends DaoGenericoImplement<Equipo> implements EquipoDAO {

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/TipoEquipoDAOImplement!ec.edu.epn.rrhh.beans.TipoEquipoDAO")
	private TipoEquipoDAO tipoEquipoDAO;

	@Override
	public List<EquipoDTO> listaEquiposAsignados(String idFacultad, String idLaboratorio, String numCedula,
			String nombreEmp, String tipoAsignacion, Date fechaInicio, Date fechaFin) throws Exception {
		Query query = null;
		List<EquipoDTO> listEquiposDTO = new ArrayList<EquipoDTO>();
		StringBuilder queryString = new StringBuilder(
				"SELECT CONCAT(COALESCE(apel, ' '), ' ', COALESCE(nom, ' ')) AS var01, COALESCE(nombre_l, ' ') AS var02, COALESCE(nom_facultad, ' ') AS var03, COALESCE(teq.nombre, ' ') AS var04, COALESCE(eq.equipo, ' ') AS var05, "
						+ "COALESCE(eq.modelo, ' ') AS var06, COALESCE(eq.numero_serie, ' ') AS var07, to_char(eq.fecha_asignacion, 'dd/MM/yyyy') AS var08, COALESCE(eq.cod_bienes, ' ') AS var09 "
						+ "FROM \"Rrhh\".equipo eq ,\"Rrhh\".tipo_equipo teq, \"Rrhh\".emp emp ,\"Catalogos\".facultad fac, \"Catalogos\".laboratorio lab "
						+ "WHERE eq.nced= emp.nced " + "AND eq.id_tipo= teq.id_tipo "
						+ "AND eq.id_facultad= fac.id_facultad " + "AND eq.id_laboratorio= lab.id_lab "
						+ "AND emp.nced LIKE ? AND (CONCAT(apel, ' ', nom) LIKE ? OR CONCAT(nom, ' ', apel) LIKE ?) "
						+ "AND eq.tipo_asignacion =? " + "AND eq.fecha_asignacion between ? AND ?");

		if (tipoAsignacion.equals("L")) {
			queryString.append(" AND fac.id_facultad LIKE ? AND lab.id_lab LIKE ? ");
		}

		queryString.append(" ORDER BY CONCAT(apel, ' ', nom)");

		query = getEntityManager().createNativeQuery(queryString.toString());
		query.setParameter(1, "%" + numCedula + "%");
		query.setParameter(2, "%" + nombreEmp + "%");
		query.setParameter(3, "%" + nombreEmp + "%");
		query.setParameter(4, tipoAsignacion);
		query.setParameter(5, fechaInicio);
		query.setParameter(6, fechaFin);

		if (tipoAsignacion.equals("L")) {

			query.setParameter(7, "%" + idFacultad + "%");
			query.setParameter(8, "%" + idLaboratorio + "%");
		}

		List<?> listEquipos = query.getResultList();

		if (!listEquipos.isEmpty()) {
			for (Object list : listEquipos) {
				EquipoDTO dto = new EquipoDTO();
				Object[] fila = (Object[]) list;
				dto.setNombreCustodio(fila[0].toString());
				dto.setNombreLaboratorio(fila[1].toString());
				dto.setNombreFacultad(fila[2].toString());
				dto.setNombreTipo(fila[3].toString());
				dto.setEquipo(fila[4].toString());
				dto.setModelo(fila[5].toString());
				dto.setNumSerie(fila[6].toString());
				dto.setFechaAsignacion(fila[7].toString());
				dto.setCodBienes(fila[8].toString());

				listEquiposDTO.add(dto);
			}
		}

		return listEquiposDTO;

	}

	@Override
	public List<EquipoDTO> listaEquiposAsignadosGeneral(String numCedula, String nombreEmp, Integer idTipoEquipo,
			Date fechaInicio, Date fechaFin, String nroContrato) throws Exception {
		Query query = null;
		List<EquipoDTO> listEquiposDTO = new ArrayList<EquipoDTO>();
		StringBuilder queryString = new StringBuilder(
				"SELECT CONCAT(COALESCE(e.apel,' '),' ',COALESCE(e.nom,' ')) AS var01, COALESCE(teq.nombre,' ') AS var02, COALESCE(eq.equipo, ' ') AS var03, "
						+ "COALESCE(eq.nro_contrato, ' ') AS var04, eq.anio_adquisicion AS var05, COALESCE(eq.modelo,' ') AS var06, COALESCE(eq.numero_serie,' ') AS var07, "
						+ "to_char(eq.fecha_asignacion,'dd/MM/yyyy') AS var08, COALESCE(eq.cod_bienes,' ') AS var09, eq.id_equipo AS var10, eq.nced AS var11, eq.id_tipo AS var12, "
						+ "d.nom_dep AS var13, cemp.desc_clase AS var14, CASE e.cod_tiporelacionLab WHEN '1' THEN 'NOMBRAMIENTO' ELSE 'CONTRATO' END AS var15, "
						+ "CASE e.\"COD_DEDICACION\" WHEN 'TC' THEN 'TIEMPO COMPLETO' WHEN 'TP' THEN 'TIEMPO PARCIAL' END AS var16, "
						+ "COALESCE((SELECT f.nom_dep FROM \"Rrhh\".dep f WHERE f.cod_dep = substring(d.cod_dep from 0 for 5) AND f.id_Facultad is not null),'NINGUNO') AS var17 "
						+ "FROM \"Rrhh\".equipo eq,\"Rrhh\".tipo_equipo teq,\"Rrhh\".emp e,\"Rrhh\".dep d,\"Rrhh\".clasemp cemp "
						+ "WHERE eq.nced= e.nced AND eq.id_tipo= teq.id_tipo "
						+ "AND e.cod_dep = d.cod_dep AND e.nced LIKE ? " + "AND e.cod_clase= cemp.cod_clase "
						+ "AND (CONCAT(UPPER(apel),' ',UPPER(nom)) LIKE ? OR CONCAT(UPPER(nom),' ',UPPER(apel)) LIKE ?) "
						+ "AND (teq.id_tipo = ? or 0=0) AND eq.nro_contrato like ? "
						+ "AND (eq.fecha_asignacion between ? AND ?) ORDER BY CONCAT(apel,' ',nom) ");

		query = getEntityManager().createNativeQuery(queryString.toString());
		query.setParameter(1, numCedula);
		query.setParameter(2, nombreEmp.toUpperCase());
		query.setParameter(3, nombreEmp.toUpperCase());
		query.setParameter(4, idTipoEquipo);
		query.setParameter(5, nroContrato);
		query.setParameter(6, fechaInicio);
		query.setParameter(7, fechaFin);

		List<?> listEquipos = query.getResultList();

		if (!listEquipos.isEmpty()) {
			for (Object list : listEquipos) {
				EquipoDTO dto = new EquipoDTO();
				Object[] fila = (Object[]) list;
				dto.setNombreCustodio(fila[0].toString());
				dto.setNombreTipo(fila[1].toString());
				dto.setEquipo(fila[2].toString());
				dto.setNroContrato(fila[3].toString());
				dto.setAnioAdquisicion(Integer.valueOf(fila[4].toString()));
				dto.setModelo(fila[5].toString());
				dto.setNumSerie(fila[6].toString());
				dto.setFechaAsignacion(fila[7].toString());
				dto.setCodBienes(fila[8].toString());
				dto.setIdEquipo(Integer.valueOf(fila[9].toString()));
				dto.setNumCedula(fila[10].toString());
				Integer idTipoEquipoBusqueda = Integer.valueOf(fila[11].toString());
				TipoEquipo tipoEquipo = (TipoEquipo) tipoEquipoDAO.getById(TipoEquipo.class, idTipoEquipoBusqueda);
				dto.setTipoEquipo(tipoEquipo);
				/** SE AGREGA VARIABLES AL REPORTE 13-02-2017 */
				dto.setNombreDepartamento(fila[12] == null ? "" : fila[12].toString());
				dto.setTipoPersona(fila[13] == null ? "" : fila[13].toString());
				dto.setTipoContrato(fila[14] == null ? "" : fila[14].toString());
				dto.setDedicacionCustodio(fila[15] == null ? "" : fila[15].toString());
				dto.setNombreFacultad(fila[16] == null ? "" : fila[16].toString());

				listEquiposDTO.add(dto);
			}
		}

		return listEquiposDTO;

	}

}
