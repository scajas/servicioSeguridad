package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.Vaca;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;
import ec.edu.epn.rrhh.movimientos.UsuarioRrhh;

@Stateless
public class VacaDAOImplement  extends DaoGenericoImplement<Vaca> implements VacaDAO{

	@Override
	public List<Vaca> findVacaByEmpleado(Emp emp) {
				StringBuilder queryString = new StringBuilder(
						"SELECT " + "fam FROM Vaca fam where " + "fam.emp.nced =?1");

				Query query = getEntityManager().createQuery(queryString.toString());

				query.setParameter(1, emp.getNced());
				List<Vaca> resultado = query.getResultList();

				return resultado;
	}
	
	
	@Override
	public Vaca getSaldo(String cedemp) {
		StringBuilder queryString = new StringBuilder("SELECT t FROM Vaca t where"
				+ " t.id=(Select max(ti.id) from Vaca ti where ti.emp.nced=:ced)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("ced", cedemp);
		Vaca result = (Vaca) query.getSingleResult();
		return result;
	}
	
	@Override
	public Integer getMaxID() {
		StringBuilder queryString = new StringBuilder("SELECT max(t.id) FROM Vaca t");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	}


}
