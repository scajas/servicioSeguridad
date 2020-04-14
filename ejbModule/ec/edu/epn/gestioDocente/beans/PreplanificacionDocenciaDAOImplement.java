/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.contratos.beans.PensumDAO;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;
import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.beans.DependenciaDAO;
import ec.edu.epn.rrhh.beans.EmpleadoDAO;
import ec.edu.epn.rrhh.movimientos.Dependencia;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PreplanificacionDocenciaDAOImplement extends DaoGenericoImplement<PreplanificacionDocencia>
		implements PreplanificacionDocenciaDAO {

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/DependenciaDAOImplement!ec.edu.epn.rrhh.beans.DependenciaDAO")
	private DependenciaDAO dependenciaDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PensumDAOImplement!ec.edu.epn.contratos.beans.PensumDAO")
	private PensumDAO pensumDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EstadoEvaluacionDAOImplement!ec.edu.epn.gestioDocente.beans.EstadoEvaluacionDAO")
	private EstadoEvaluacionDAO estadoEvaluacionDAO;

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EmpleadoDAOImplement!ec.edu.epn.rrhh.beans.EmpleadoDAO")
	private EmpleadoDAO empDAO;

	@Override
	public Long countPreplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado, String dep)
			throws Exception {
		Query q = null;
		if (nced.equals("")) {
			q = getEntityManager().createQuery(
					"SELECT count(p) FROM PreplanificacionDocencia p WHERE p.nced is null AND p.nombre like ? AND p.idPensum= ? AND p.estado like ? AND p.codDep = ?");

			q.setParameter(1, nombre);
			q.setParameter(2, idPensum);
			q.setParameter(3, estado);
			q.setParameter(4, dep);
		} else {
			q = getEntityManager().createQuery(
					"SELECT count(p) FROM PreplanificacionDocencia p WHERE p.nced=?  AND p.idPensum= ? AND p.estado like ? AND p.codDep = ?");

			q.setParameter(1, nced);
			q.setParameter(2, idPensum);
			q.setParameter(3, estado);
			q.setParameter(4, dep);
		}

		return (Long) q.getSingleResult();
	}

	@Override
	public PreplanificacionDocencia preplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado,
			String dep) throws Exception {

		Query q = null;
		if (nced == "" || nced == null) {
			q = getEntityManager().createQuery(
					"SELECT p FROM PreplanificacionDocencia p WHERE p.nced is null AND p.nombre like ? AND p.idPensum= ? AND p.estado like ? AND p.codDep = ?");

			q.setParameter(1, nombre);
			q.setParameter(2, idPensum);
			q.setParameter(3, estado);
			q.setParameter(4, dep);

		} else {
			q = getEntityManager().createQuery(
					"SELECT p FROM PreplanificacionDocencia p WHERE p.nced= ?  AND p.idPensum= ? AND p.estado like ? AND p.codDep like ?");

			q.setParameter(1, nced);
			q.setParameter(2, idPensum);
			q.setParameter(3, estado);
			q.setParameter(4, dep == "" ? "%%" : dep);
		}

		try {
			return (PreplanificacionDocencia) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocenteDTO> listaDocentePreplanifc(String nombre, Integer idPensum, List<DocenteDTO> listaDocente,
			String codDep) {

		List<PreplanificacionDocencia> listPreplanif = new ArrayList<PreplanificacionDocencia>();
		List<DocenteDTO> listaDocenteDTO = new ArrayList<DocenteDTO>();
		Query q = getEntityManager().createQuery(
				"SELECT p FROM PreplanificacionDocencia p WHERE  p.nombreAnterior like ? AND p.idPensum= ? AND p.codDep=? AND p.nced IS null ");

		q.setParameter(1, nombre);
		q.setParameter(2, idPensum);
		q.setParameter(3, codDep);

		try {

			for (DocenteDTO doc : listaDocente) {
				if (doc.getnCed() != null) {
					PreplanificacionDocencia preplanif = preplanifXPeriodo(doc.getnCed() == null ? "" : doc.getnCed(),
							"", idPensum, "%%", codDep);

					if (preplanif != null) {
						EstadoEvaluacion estadoEval = estadoEvaluacionDAO.estadoEvalXNombre(preplanif.getEstado());
						doc.setEstado(estadoEval.getDescripcion());
					}
				}

				listaDocenteDTO.add(doc);

			}

			listPreplanif = q.getResultList();
			if (!listPreplanif.isEmpty()) {
				for (PreplanificacionDocencia dto : listPreplanif) {
					DocenteDTO docente = new DocenteDTO();
					docente.setNombre(dto.getNombreAnterior());

					Pensum pensum = new Pensum();
					pensum = pensumDAO.obtenerPensumById(idPensum);
					docente.setPeriodo(pensum == null ? "" : pensum.getMeses());
					docente.setIdPeriodo(pensum.getIdPensum().toString());

					Dependencia dep = new Dependencia();
					dep = (Dependencia) dependenciaDAO.getById(Dependencia.class, dto.getCodDep());
					docente.setNomDepartamento(dep == null ? "" : dep.getNomDep());
					docente.setExistePeriodo(true);

					EstadoEvaluacion estadoEval = estadoEvaluacionDAO.estadoEvalXNombre(dto.getEstado());
					docente.setEstado(estadoEval.getDescripcion());

					listaDocenteDTO.add(docente);
				}
			}

			return listaDocenteDTO;
		} catch (Exception e) {
			return null;
		}

	}

	/*
	 * public List<PreplanificacionDocencia> listaDocentePreplanifc(Integer
	 * idPensum, Integer idFacultad) { try { Query q =
	 * getEntityManager().createQuery(
	 * "SELECT p FROM PreplanificacionDocencia p WHERE  p.idPensum = ? AND p.codDep in (select d.codDep from Dependencia d where d.idFacultad = ?) and p.nced is null"
	 * );
	 * 
	 * q.setParameter(1, idPensum); q.setParameter(2, idFacultad);
	 * 
	 * return q.getResultList(); } catch (Exception e) { return null; }
	 * 
	 * }
	 */

	public List<PreplanificacionDocencia> listaDocentePreplanifc(Integer idPensum, Integer idFacultad) {

		List<PreplanificacionDocencia> listSinCedula = new ArrayList<PreplanificacionDocencia>();
		List<PreplanificacionDocencia> listConCedula = new ArrayList<PreplanificacionDocencia>();
		List<PreplanificacionDocencia> listTotal = new ArrayList<PreplanificacionDocencia>();

		try {
			Query q = getEntityManager().createQuery(
					"SELECT p FROM PreplanificacionDocencia p WHERE  p.idPensum = ? AND p.codDep in (select d.codDep from Dependencia d where d.idFacultad = ?) and p.nced is null and p.estado = ?");

			q.setParameter(1, idPensum);
			q.setParameter(2, idFacultad);
			q.setParameter(3, "PREPLANIF");

			// return q.getResultList();

			try {
				listSinCedula = q.getResultList();
			} catch (Exception e) {
				listSinCedula = new ArrayList<PreplanificacionDocencia>();
			}

			List<Dependencia> listDep = new ArrayList<Dependencia>();

			listDep = this.listaDepXfacultad(idFacultad);

			if (!listDep.isEmpty()) {
				for (Dependencia dep : listDep) {
					List<DocenteDTO> listaDocenteAux = new ArrayList<DocenteDTO>();
					listaDocenteAux = empDAO.buscarEmpHistoriaLab("%%", idPensum, "%%", "%%", dep.getCodDep());
					if (!listaDocenteAux.isEmpty()) {
						for (DocenteDTO dto : listaDocenteAux) {
							PreplanificacionDocencia p = new PreplanificacionDocencia();
							p = this.preplanifXPeriodo(dto.getnCed(), "", idPensum, "PREPLANIF", "");
							if (p != null) {
								listConCedula.add(p);
							}
						}
					}
				}
			}

			if (!listSinCedula.isEmpty()) {
				for (PreplanificacionDocencia p : listSinCedula) {
					listTotal.add(p);
				}

			}

			if (!listConCedula.isEmpty()) {
				for (PreplanificacionDocencia p : listConCedula) {
					listTotal.add(p);
				}

			}

			return listTotal;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Long countPreplanifExiste(String nombre, Integer idPensum) throws Exception {

		Query q = getEntityManager().createQuery(
				"SELECT count(p) FROM PreplanificacionDocencia p WHERE  p.nombre like ? AND p.idPensum= ? AND p.nced IS null ");

		q.setParameter(1, nombre.trim());
		q.setParameter(2, idPensum);

		return (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocenteDTO> listaDocPreplanifRevision(List<DocenteDTO> listaDocente, String estado, Integer idPensum,
			String dep) {

		List<PreplanificacionDocencia> listPreplanif = new ArrayList<PreplanificacionDocencia>();
		List<DocenteDTO> listaDoc = new ArrayList<DocenteDTO>();
		Query q = getEntityManager().createQuery(
				"SELECT p FROM PreplanificacionDocencia p WHERE p.estado != ? AND p.idPensum=? AND p.codDep= ?");

		q.setParameter(1, estado);
		q.setParameter(2, idPensum);
		q.setParameter(3, dep);

		try {
			listPreplanif = q.getResultList();
			if (!listPreplanif.isEmpty()) {
				for (PreplanificacionDocencia pre : listPreplanif) {
					for (DocenteDTO dto : listaDocente) {
						if (pre.getNced() != null && dto.getnCed() != null && pre.getNced().trim().equals(dto.getnCed())
								&& pre.getIdPensum() == Integer.valueOf(dto.getIdPeriodo())) {
							EstadoEvaluacion estadoEval = estadoEvaluacionDAO.estadoEvalXNombre(pre.getEstado());
							dto.setEstado(estadoEval.getDescripcion());
							listaDoc.add(dto);
						} else if (pre.getNombreAnterior() != null && dto.getNombre() != null
								&& pre.getNombreAnterior().trim().equals(dto.getNombre())
								&& pre.getIdPensum() == Integer.valueOf(dto.getIdPeriodo())) {
							EstadoEvaluacion estadoEval = estadoEvaluacionDAO.estadoEvalXNombre(pre.getEstado());
							dto.setEstado(estadoEval.getDescripcion());
							listaDoc.add(dto);
						}
					}
				}
			}

			return listaDoc;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public PreplanificacionDocencia findByPedido(Integer idPedido) {
		try {

			Query q = getEntityManager()
					.createQuery("SELECT p FROM PreplanificacionDocencia p WHERE  p.pedido.idPedido = ?");

			q.setParameter(1, idPedido);

			return (PreplanificacionDocencia) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Dependencia dependenciaByNombre(String nombreDependencia) {
		StringBuilder queryString;

		queryString = new StringBuilder("SELECT dep FROM Dependencia dep "
				+ "where dep.estado is not null AND dep.estado= 'ACTIVO' and trim(dep.nomDep) like ?1");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreDependencia);
		try {
			return (Dependencia) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} catch (NonUniqueResultException e1) {
			e1.printStackTrace();
			return (Dependencia) query.getResultList().get(0);
		}

	}

	@Override
	public Pedido findPedidoPreplanif(String nced, Integer idPensum, Integer idEstado) {

		StringBuilder queryString = new StringBuilder(
				"SELECT MAX(ped) FROM Pedido ped WHERE TRIM(ped.nced)= ?1 AND ped.pensum.idPensum= ?2 AND ped.estado.idEstado= ?3 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, idPensum);
		query.setParameter(3, idEstado);
		try {

			return (Pedido) query.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} catch (NonUniqueResultException e1) {
			e1.printStackTrace();
			return (Pedido) query.getResultList().get(0);
		}

	}

	public List<Dependencia> listaDepXfacultad(Integer idFacultad) throws NoResultException, Exception {
		List<Dependencia> retorno = null;
		try {
			StringBuilder queryFacultad = new StringBuilder();
			queryFacultad.append(" SELECT dep from Dependencia dep where dep.idFacultad = :idFacultad AND dep.estado= 'ACTIVO' AND dep.tipo='DEP' ");
			Query queryFac = getEntityManager().createQuery(queryFacultad.toString());
			queryFac.setParameter("idFacultad", idFacultad);
			
			return queryFac.getResultList();
				
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} 
	}
}
