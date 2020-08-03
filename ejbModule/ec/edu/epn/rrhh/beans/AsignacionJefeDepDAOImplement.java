package ec.edu.epn.rrhh.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.DTO.AsignacionJDepDTO;
import ec.edu.epn.rrhh.entities.AsignacionJefeDep;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.Dependencia;

@Stateless
public class AsignacionJefeDepDAOImplement extends DaoGenericoImplement<AsignacionJefeDep>
		implements AsignacionJefeDepDAO {

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/DependenciaDAOImplement!ec.edu.epn.rrhh.beans.DependenciaDAO")
	private DependenciaDAO dependenciaDAO;

	@Override
	public List<AsignacionJDepDTO> listaJefesDepXDependencia(String codDep, String estadoJD) throws Exception {

		try {

			List<AsignacionJDepDTO> listAsigJD = new ArrayList<AsignacionJDepDTO>();
			List<Emp> listEmp = new ArrayList<Emp>();

			StringBuilder queryString = new StringBuilder(
					"SELECT e FROM Emp e, AsignacionJefeDep a WHERE e.nced= a.nced AND e.codDepJefe= a.codDep AND a.estado like ?");
			if (codDep.equals("0")) {
				queryString.append(" AND a.codDep like ?  ");
			} else {
				queryString.append(" AND a.codDep = ?  ");
			}

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(1, estadoJD);
			if (codDep.equals("0")) {
				query.setParameter(2, "%%");
			} else {
				query.setParameter(2, codDep);
			}

			listEmp = query.getResultList();

			if (!listEmp.isEmpty()) {
				for (Emp emp : listEmp) {
					AsignacionJDepDTO dto = new AsignacionJDepDTO();
					Dependencia dep = new Dependencia();
					dep = (Dependencia) dependenciaDAO.getById(Dependencia.class, emp.getCodDepJefe());
					dto.setJefeDepartamento(emp.getApel() + " " + emp.getNom());
					dto.setNced(emp.getNced());
					if(dep!=null){
						dto.setDependencia(dep.getNomDep());
						dto.setCodDep(dep.getCodDep());
					}
						

					if (estadoJD.equals("V")) { /** VIGENTE */
						dto.setActivo(true);
					} else {
						dto.setActivo(false);
					}

					AsignacionJefeDep asignacionJefeDep = new AsignacionJefeDep();
					asignacionJefeDep = this.asignacionVigenteXDEP(emp.getCodDepJefe());
					if (asignacionJefeDep != null) {
						dto.setIdAsignacion(asignacionJefeDep.getIdAsignacionJefeDep());
						dto.setFechaHasta(asignacionJefeDep.getFechaHasta());
						dto.setFechaDesde(asignacionJefeDep.getFechaDesde());
						dto.setObservacion(asignacionJefeDep.getObservacion());
						dto.setEstado(asignacionJefeDep.getEstado().equals("V")?"VIGENTE": "NO VIGENTE");
					}

					listAsigJD.add(dto);

				}
			}
			
			return listAsigJD;

		} catch (Exception e) {
			return null;
		}

	}
	
	
	@Override
	public AsignacionJefeDep asignacionVigenteXDEP(String codDep) throws Exception {

		try {
			
			StringBuilder queryString = new StringBuilder(
					"SELECT a FROM AsignacionJefeDep a WHERE  a.codDep = ? AND a.estado = 'V'");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, codDep);

			return (AsignacionJefeDep) query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

}
