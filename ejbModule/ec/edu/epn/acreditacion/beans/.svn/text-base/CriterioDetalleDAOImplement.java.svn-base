package ec.edu.epn.acreditacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.DTO.CriterioDetalleDTO;
import ec.edu.epn.acreditacion.entities.Criterio;
import ec.edu.epn.acreditacion.entities.CriterioDetalle;
import ec.edu.epn.acreditacion.entities.Evidencia;
import ec.edu.epn.acreditacion.entities.EvidenciaDetalle;
import ec.edu.epn.acreditacion.entities.Indicador;
import ec.edu.epn.acreditacion.entities.IndicadorDetalle;
import ec.edu.epn.acreditacion.entities.Subcriterio;
import ec.edu.epn.acreditacion.entities.SubcriterioDetalle;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class CriterioDAOImplement
 */
@Stateless
@LocalBean
public class CriterioDetalleDAOImplement extends DaoGenericoImplement<CriterioDetalle> implements CriterioDetalleDAO {

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/CriterioDAOImplement!ec.edu.epn.acreditacion.beans.CriterioDAO")
	private CriterioDAO criterioDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/SubcriterioDAOImplement!ec.edu.epn.acreditacion.beans.SubcriterioDAO")
	private SubcriterioDAO subcriterioDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/IndicadorDAOImplement!ec.edu.epn.acreditacion.beans.IndicadorDAO")
	private IndicadorDAO indicadorDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/SubCriterioDetalleDAOImplement!ec.edu.epn.acreditacion.beans.SubCriterioDetalleDAO")
	private SubCriterioDetalleDAO subCriterioDetalleDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/IndicadorDetalleDAOImplement!ec.edu.epn.acreditacion.beans.IndicadorDetalleDAO")
	private IndicadorDetalleDAO indicadorDetalleDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EvidenciaADAOImplement!ec.edu.epn.acreditacion.beans.EvidenciaADAO")
	private EvidenciaADAO evidenciaADAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EvidenciaDetalleDAOImplement!ec.edu.epn.acreditacion.beans.EvidenciaDetalleDAO")
	private EvidenciaDetalleDAO evidenciaDetalleDAO;

	@SuppressWarnings("unchecked")
	@Override
	public CriterioDetalleDTO criterioxIdCriterioCarrera(Integer idCriterio, String idCarrera) {
		Query query = null;
		List<CriterioDetalleDTO> criterioDetalleDTO = new ArrayList<CriterioDetalleDTO>();
		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT cd.id_criterio_detalle, cd.id_criterio, cd.id_carrera, cd.calificacion, c.nom_criterio, c.peso "
							+ "FROM \"Acreditacion\".criterio_detalle cd, \"Acreditacion\".criterio c "
							+ "WHERE cd.id_criterio= c.id_criterio " + "AND cd.id_carrera=? AND c.id_criterio=?;");
			query = getEntityManager().createNativeQuery(queryString.toString());
			query.setParameter(1, idCarrera);
			query.setParameter(2, idCriterio);

			List<?> listsDTOCriterio = query.getResultList();

			if (!listsDTOCriterio.isEmpty()) {
				for (Object list : listsDTOCriterio) {
					CriterioDetalleDTO dto = new CriterioDetalleDTO();
					Object[] fila = (Object[]) list;

					dto.setIdCriterioDetalle(Integer.valueOf(fila[0].toString()));
					dto.setIdCriterio(Integer.valueOf(fila[1].toString()));
					dto.setIdCarrera(Integer.valueOf(fila[2].toString()));
					dto.setCalificacion(Double.valueOf(fila[3].toString()));
					dto.setNombreCriterio(fila[4].toString());
					dto.setPeso(Double.valueOf(fila[5].toString()));

					criterioDetalleDTO.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return criterioDetalleDTO.get(0);
	}

	@Override
	public Long countCriterioDetalleXIdCarrera(String idCarrera, Integer idPensum) throws Exception {
		Query q = getEntityManager()
				.createQuery("SELECT count(cd) FROM CriterioDetalle cd WHERE cd.idCarrera like ? AND cd.idPensum=?");

		q.setParameter(1, idCarrera);
		q.setParameter(2, idPensum);
		return (Long) q.getSingleResult();
	}

	@Override
	public CriterioDetalle criterioDetalleXIdCarreraIdCriterio(Integer idCriterio, String idCarrera) throws Exception {
		Query q = getEntityManager()
				.createQuery("SELECT max(cd) FROM CriterioDetalle cd WHERE cd.idCarrera like ? AND cd.idCriterio = ?");

		q.setParameter(1, idCarrera);
		q.setParameter(2, idCriterio);
		return (CriterioDetalle) q.getSingleResult();
	}

	@Override
	public void generaAcreditacionXCarrera(String idCarrera, Integer idPensum) throws Exception {

		List<Criterio> listCriterios = new ArrayList<Criterio>();
		List<Subcriterio> listSubcriterios = new ArrayList<Subcriterio>();
		List<Indicador> listIndicador = new ArrayList<Indicador>();
		List<Evidencia> listEvidencia = new ArrayList<Evidencia>();

		listCriterios = criterioDAO.getAll(Criterio.class);

		if (!listCriterios.isEmpty()) {
			for (Criterio crit : listCriterios) {
				CriterioDetalle criterioDetalle = new CriterioDetalle();
				criterioDetalle.setIdCarrera(idCarrera);
				criterioDetalle.setIdCriterio(crit.getIdCriterio());
				criterioDetalle.setIdPensum(idPensum);
				super.save(criterioDetalle);

				listSubcriterios = subcriterioDAO.listSubCriterioxIdCriterio(crit.getIdCriterio());

				if (!listSubcriterios.isEmpty()) {
					for (Subcriterio subcriterio : listSubcriterios) {
						SubcriterioDetalle subcriterioDetalle = new SubcriterioDetalle();
						subcriterioDetalle.setCriterioDetalle(criterioDetalle);
						subcriterioDetalle.setIdSubcr(subcriterio.getIdSubcr());

						subCriterioDetalleDAO.save(subcriterioDetalle);

						listIndicador = indicadorDAO.listIndicadoresxIdSubCriterio(subcriterio.getIdSubcr());

						if (!listIndicador.isEmpty()) {
							for (Indicador indicador : listIndicador) {
								IndicadorDetalle indicadorDetalle = new IndicadorDetalle();
								indicadorDetalle.setIdCarrera(idCarrera);
								indicadorDetalle.setIdIndicador(indicador.getIdIndi());
								indicadorDetalle.setSubcriterioDetalle(subcriterioDetalle);
								indicadorDetalle.setCodInddet(indicador.getCodIndi());
								indicadorDetalle.setResultado("0");
								indicadorDetalleDAO.save(indicadorDetalle);

								listEvidencia = evidenciaADAO.listEvidenciasXSubCriterio(subcriterio.getIdSubcr(),
										indicador.getCodIndi());

								if (!listEvidencia.isEmpty()) {
									for (Evidencia evidencia : listEvidencia) {
										Long countEvidDetalle = evidenciaDetalleDAO.countEvidDetXPensumXCarrera(
												idCarrera, idPensum, evidencia.getIdEvid());
										if (countEvidDetalle == 0) {
											EvidenciaDetalle evidenciaDetalle = new EvidenciaDetalle();
											evidenciaDetalle.setIdCarrera(idCarrera);
											evidenciaDetalle.setEvidencia(evidencia);
											evidenciaDetalle.setIdPensum(idPensum);
											evidenciaDetalle.setEstado("ING");
											evidenciaDetalle.setExistencia("N");
											evidenciaDetalle.setCalificacion(0.0);
											evidenciaDetalleDAO.save(evidenciaDetalle);
										}

									}
								}
							}
						}
					}
				}

			}
		}

	}

	@Override
	public List<Criterio> listCriteriosbyCarreraPeriodo(String carrera, Integer periodo) throws Exception {
		Query q = getEntityManager().createQuery("select c from Criterio  c where c.idCriterio in "
				+ "(select cd.idCriterio from CriterioDetalle cd where cd.idPensum = ?1 and cd.idCarrera = ?2)");

		q.setParameter(1, periodo);
		q.setParameter(2, carrera);

		List<Criterio> listCriterios = q.getResultList();
		List<Subcriterio> listSubcriterios = new ArrayList<>();
		List<Indicador> listIndicadores = new ArrayList<>();
		List<Evidencia> listEvidencias = new ArrayList<>();

		for (int x = 0; x < listCriterios.size(); x++) {
			Criterio c = listCriterios.get(x);
			listSubcriterios = subcriterioDAO.listSubCriterioxIdCriterio(c.getIdCriterio());
			c.setSubcriterios(listSubcriterios);

			for (int y = 0; y < listSubcriterios.size(); y++) {
				Subcriterio s = listSubcriterios.get(y);
				listIndicadores = indicadorDAO.listIndicadoresxIdSubCriterio(s.getIdSubcr());
				s.setIndicadors(listIndicadores);

				for (int z = 0; z < listIndicadores.size(); z++) {
					Indicador i = listIndicadores.get(z);
					listEvidencias = evidenciaADAO.listEvidenciasXSubCriterio(s.getIdSubcr(), i.getCodIndi());
					s.setEvidencias(listEvidencias);
				}
			}
		}

		return listCriterios;
	}

	@Override
	public List<CriterioDetalle> listCriteriosbyCrierioCarreraPeriodo(Integer idCriterio, String carrera, Integer periodo)
			throws Exception {
		Query q = getEntityManager().createQuery(
				"SELECT cd FROM CriterioDetalle cd WHERE cd.idCriterio = ?1 and cd.idCarrera = ?2 AND cd.idPensum = ?3");

		q.setParameter(1, idCriterio);
		q.setParameter(2, carrera);
		q.setParameter(3, periodo);
		return q.getResultList();
	}

	@Override
	public List<CriterioDetalle> listCriteriosbyCarrera(String carrera) throws Exception {
		Query q = getEntityManager().createQuery(
				"SELECT cd FROM CriterioDetalle cd WHERE cd.idCarrera = ?1");

		q.setParameter(1, carrera);
		return q.getResultList();
	}

}
