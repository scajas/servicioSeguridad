package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.Tipocliente;

/**
 * Session Bean implementation class ClienteDAOImplement
 */
@Stateless
@LocalBean
public class ClienteDAOImplement extends DaoGenericoImplement<Cliente> implements ClienteDAO {

	/**
	 * Default constructor.
	 */
	public ClienteDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Tipocliente> listaClienteTC(Integer id) {
		StringBuilder queryString = new StringBuilder("SELECT c FROM Cliente c where c.tipocliente.idTipocliente =? 1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Tipocliente> resultados = query.getResultList();
		return resultados;
	}
	
	@Override
	public List<Cliente> ListCliente() {
		StringBuilder queryString = new StringBuilder("SELECT c FROM Cliente c ORDER BY c.nombreCl ASC ");
		Query query = getEntityManager().createQuery(queryString.toString());
	
		List<Cliente> resultados = query.getResultList();
		return resultados;
	}
}
