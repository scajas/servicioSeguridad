/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Aper;

/**
 * @author Administrador
 * 
 */
@Stateless
public class AperDAOImplement extends DaoGenericoImplement<Aper> implements AperDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Aper> listAperxNCed(String nced) {
		Query q = getEntityManager()
				.createQuery("Select a from Aper a where a.emp.nced like ?1 order by frigeAper DESC");
		q.setParameter(1, nced);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aper> listAperxNCedBytipo(String nced) {

		List<String> tipo = new ArrayList<String>();
		String tipo1 = "D";
		String tipo2 = "DC";
		String tipo3 = "DF";
		String tipo4 = "E";
		String tipo5 = "SB";
		String tipo6 = "PS";
		
		tipo.add(tipo1);
		tipo.add(tipo2);
		tipo.add(tipo3);
		tipo.add(tipo4);
		tipo.add(tipo5);
		tipo.add(tipo6);

		Query q = getEntityManager()
				.createQuery("Select a from Aper a where a.emp.nced like :cedula and a.taperBean.taper IN:tipo  order by frigeAper DESC");
		q.setParameter("cedula", nced);
		q.setParameter("tipo", tipo);
		return q.getResultList();
	}

	
	@Override
	public List<Aper> listaAperbyCedula(String cedula) {
		StringBuilder queryString = new StringBuilder(
				"SELECT aper FROM Aper aper where aper.emp.nced like ?0 order by aper.fecSis desc ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%" + cedula + "%");
		return query.getResultList();
	}
	
}
