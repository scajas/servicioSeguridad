package ec.edu.epn.rrhh.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.Nominacion;
import ec.edu.epn.rrhh.movimientos.NominacionCatalogo;

@Stateless
public class NominacionCatalogoDAOImplement extends DaoGenericoImplement<NominacionCatalogo> implements NominacionCatalogoDAO{

	@Override
	public List<NominacionCatalogo> findActive() {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM NominacionCatalogo fam where " + "fam.estado ='activo' ");

		Query query = getEntityManager().createQuery(queryString.toString());
		List<NominacionCatalogo> resultado = query.getResultList();

		return resultado;
	}

	
	
}
