package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.movimientos.Dependencia;


@Stateless
public class DependenciaDAOImplement extends DaoGenericoImplement<Dependencia> implements DependenciaDAO {
	@Override
	public List<Dependencia> findDependenciaActivaByTipoEmpleado(String tipoEmpleado) {
		StringBuilder queryString = null;
		Query query = null;
		if (tipoEmpleado.compareTo("DOCENTE") == 0 || tipoEmpleado.compareTo("PARADOCENTE")==0 ) {
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 " 
					+ " and dep.tipo =?2 and trim(dep.nomDep) != 'DEPARTAMENTO POR REGISTRAR' ");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");
			//query.setParameter(2, "FACULTADES");
			query.setParameter(2, "DEP");
		}
		if(tipoEmpleado.compareTo("ADMINISTRATIVO")==0){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3) and dep.dependencia IS NOT NULL "
					+ " and trim(dep.nomDep) != 'DEPARTAMENTO POR REGISTRAR'");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
		}if(tipoEmpleado.compareTo("OLD")==0){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3 or dep.tipo = ?4) and dep.dependencia IS NOT NULL"
					+ " and trim(dep.nomDep) != 'DEPARTAMENTO POR REGISTRAR' ");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
			query.setParameter(4, "OLD");
		}if(tipoEmpleado.compareTo("SUB")==0 || tipoEmpleado.compareTo("APOYO DOC, INV, EXT")==0 ){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3 or dep.tipo = ?4) "
					+ "and dep.dependencia IS NOT NULL and trim(dep.nomDep) != 'DEPARTAMENTO POR REGISTRAR' ");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
			query.setParameter(4, "FAC");
		}
		if(tipoEmpleado.compareTo("ACT")==0 ){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3 or dep.tipo = ?4) "
					+ "and dep.dependencia IS NOT NULL ");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
			query.setParameter(4, "FAC");
		}
		
		

		List<Dependencia> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public List<Dependencia> findDependenciaId(String codDependencia) {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Dependencia fam where fam.codDep=?");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, codDependencia);
		List<Dependencia> resultado = query.getResultList();

		return resultado;

	}
	
	
	@Override
	public List<Dependencia> findDependenciaAcademica() {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Dependencia fam where "
				+ "(fam.nomDep like '%DEP%' or fam.nomDep like '%ESCUELA%') "
				+ "and fam.tipo='DEP' and fam.estado='ACTIVO'");

		Query query = getEntityManager().createQuery(queryString.toString());
		List<Dependencia> resultado = query.getResultList();

		return resultado;

	}
	
	@Override
	public List<Dependencia> findDependenciaActivaByTipoEmpleadoMigrado(String tipoEmpleado) {
		StringBuilder queryString = null;
		Query query = null;
		if (tipoEmpleado.compareTo("DOCENTE") == 0 || tipoEmpleado.compareTo("PARADOCENTE")==0 ) {
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 " 
					+ "and dep.tipo =?2 ");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");
			//query.setParameter(2, "FACULTADES");
			query.setParameter(2, "DEP");
		}
		if(tipoEmpleado.compareTo("ADMINISTRATIVO")==0){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3) and dep.dependencia IS NOT NULL");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
		}if(tipoEmpleado.compareTo("OLD")==0){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where dep.estado = ?1 and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3 or dep.tipo = ?4) and dep.dependencia IS NOT NULL");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
			query.setParameter(4, "OLD");
		}if(tipoEmpleado.compareTo("SUB")==0 || tipoEmpleado.compareTo("APOYO DOC, INV, EXT")==0 ){
			queryString = new StringBuilder(" Select dep from Dependencia dep "
					+ " where (dep.estado = ?1 or dep.estado='MIGRADO') and  " 
					+ " (dep.tipo =?2 or dep.tipo =?3 or dep.tipo = ?4) "
					+ "and dep.dependencia IS NOT NULL");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "ACTIVO");	
			query.setParameter(2, "DEP");
			query.setParameter(3, "ADM");
			query.setParameter(4, "FAC");
			
			
		}
		
		
		
		

		List<Dependencia> resultado = query.getResultList();

		return resultado;

	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dependencia> listarFacultades() throws NoResultException, Exception {
		List<Dependencia> retorno = null;
		try {
			StringBuilder queryFacultad = new StringBuilder();
			queryFacultad.append(" SELECT dep from Dependencia dep ");
			queryFacultad.append(" where dep.idFacultad is not null");
			queryFacultad.append(" and dep.tipo = 'FAC'");
			Query query = getEntityManager().createQuery(queryFacultad.toString());
			retorno = query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró facultades");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar las facultades");
		}
		return retorno;
	}
	
	
	/**
	 * Lista los departamentos por el id de facultad
	 * 
	 * @param idFacultad
	 *            - Integer con el id de la facultad a listar
	 * @return lista de departamentos por el id de facultad buscado
	 * @throws NoResultException
	 *             - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception
	 *             - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Dependencia> listaDepXfacultad(Integer idFacultad) throws NoResultException, Exception {
		List<Dependencia> retorno = null;
		try {
			StringBuilder queryFacultad = new StringBuilder();
			Dependencia dep = new Dependencia();
			dep.setCodDep("-99");
			if (!idFacultad.equals(Integer.valueOf("-99"))) {
				queryFacultad.append(" SELECT dep from Dependencia dep where dep.idFacultad = :idFacultad ");
				Query queryFac = getEntityManager().createQuery(queryFacultad.toString());
				queryFac.setParameter("idFacultad", idFacultad);
				dep = (Dependencia) queryFac.getSingleResult();
			}

			StringBuilder queryString = new StringBuilder();
			queryString.append(" SELECT dep from Dependencia dep ");
			if (!dep.getCodDep().equals("-99")) {
				queryString.append(" where dep.codDep like :idDep");
				queryString.append(" and dep.codDep <> :idDepNotIn");
				queryString.append(" and dep.tipo = :tipoDep");
			}

			Query query = getEntityManager().createQuery(queryString.toString());
			if (!dep.getCodDep().equals("-99")) {
				query.setParameter("idDep", "%" + dep.getCodDep() + "%");
				query.setParameter("idDepNotIn", dep.getCodDep());
				query.setParameter("tipoDep", "DEP");

			}
			retorno = query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró departamentos por la facultad buscada");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los departamentos");
		}
		return retorno;
	}
	
	
	@Override
	public List<Dependencia> getDependencias() {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Dependencia fam "
				+ "where fam.estado is not null and fam.tipo = 'DEP'");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		
		List<Dependencia> resultados = query.getResultList();
		
		
		return resultados;
	}
	
	@Override
	public List<Dependencia> getDependenciasAll() {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Dependencia fam ");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		
		List<Dependencia> resultados = query.getResultList();
		
		
		return resultados;
	}

	@Override
	public List<Dependencia> getDependenciasAdministrables() {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Dependencia fam "
				+ "where fam.estado is not null and (fam.tipo = 'FAC' or fam.tipo = 'DEP')");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		
		List<Dependencia> resultados = query.getResultList();
		
		
		return resultados;
	}

	@Override
	public String getMaxIdDependencia() {
		String sql = "select * from \"Rrhh\".dependencia where cod_dep = "
				+ "(Select max(cod_dep) from \"Rrhh\".dependencia where isnumeric(cod_dep) is true )";
		Query query = getEntityManager().createNativeQuery(sql, Dependencia.class);
		
		Dependencia dependencia = (Dependencia) query.getSingleResult();
		
		return dependencia.getCodDep();
	}
	
	//Nuevos métodos
	@Override
	public Dependencia getDependenciaByNombre(String nombreDependencia) {
		StringBuilder queryString;
		if(nombreDependencia.compareTo("ESCUELA POLITÉCNICA NACIONAL%")==0){
			queryString = new StringBuilder("SELECT fam FROM Dependencia fam "
					+ "where fam.nomDep like ?1");
		}else{
			queryString = new StringBuilder("SELECT fam FROM Dependencia fam "
					+ "where fam.estado is not null and fam.nomDep like ?1");
		}
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreDependencia);
		try{
			return (Dependencia) query.getSingleResult();
		}catch(NoResultException e){
			e.printStackTrace();
			return null;
		}catch(NonUniqueResultException e1){
			e1.printStackTrace();
			return (Dependencia) query.getResultList().get(0); 
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dependencia> listaDepXFacultad() {
		StringBuilder queryString = new StringBuilder(
				"SELECT e from Dependencia e where (e.nomDep LIKE 'DEPARTAMENTO%' OR e.nomDep LIKE '%INSTITUTO%') and e.estado = 'ACTIVO' and e.tipo = 'DEP' ");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	
}

