/**
 * 
 */
package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.calibracionequipos.entidades.Laboratorioscalibracionequipo;
import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.Dependencia;

/**
 * @author Administrador
 * 
 */
@Stateless
public class LaboratoriosDAOImplement extends DaoGenericoImplement<Laboratorioscalibracionequipo>
		implements LaboratoriosDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager()
				.createQuery("SELECT MAX(labcal.idLaboratorio) FROM Laboratorioscalibracionequipo labcal");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		return idReq;

	}

	@Override
	public List<Laboratorioscalibracionequipo> findByParametros(FacultadCatalogos facultad, Dependencia departamento,
			Laboratorioscalibracionequipo laboratorio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT lab FROM Laboratorioscalibracionequipo lab where lab.idLaboratorio > 0");

		System.out.println("LABORATORIO: " + laboratorio.getCodigoLab() + "9999" + laboratorio.getNombreLab());
		if (facultad != null)
			if (!facultad.getIdFacultad().equals(""))
				queryString.append(" and lab.idFacultad = ?1");
		if (departamento != null)
			if (departamento.getCodDep() != null)
				queryString.append(" and lab.idDepartamento = ?2");
		if (laboratorio != null) {
			if (!laboratorio.getCodigoLab().equals(""))
				queryString.append(" and lab.codigoLab like ?3");
			if (!laboratorio.getNombreLab().equals(""))
				queryString.append(" and lab.nombreLab like ?4");
		}
		Query query = null;

		query = getEntityManager().createQuery(queryString.toString());

		if (facultad != null)
			if (!facultad.getIdFacultad().equals(""))
				query.setParameter(1, Integer.parseInt(facultad.getIdFacultad()));
		if (departamento != null)
			if (departamento.getCodDep() != null)
				query.setParameter(2, departamento.getCodDep());

		if (laboratorio != null) {
			if (!laboratorio.getCodigoLab().equals(""))
				query.setParameter(3, laboratorio.getCodigoLab());
			if (!laboratorio.getNombreLab().equals(""))
				query.setParameter(4, laboratorio.getNombreLab());
		}

		return query.getResultList();
	}
}
