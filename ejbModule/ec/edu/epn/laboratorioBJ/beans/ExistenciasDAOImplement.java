package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Estado;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Bodega;
import ec.edu.epn.laboratorioBJ.entities.Caracteristica;
import ec.edu.epn.laboratorioBJ.entities.Concentracion;
import ec.edu.epn.laboratorioBJ.entities.Estadoproducto;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Grado;
import ec.edu.epn.laboratorioBJ.entities.Hidratacion;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;
import ec.edu.epn.laboratorioBJ.entities.Posgiro;
import ec.edu.epn.laboratorioBJ.entities.Presentacion;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;
import ec.edu.epn.laboratorioBJ.entities.Pureza;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;
import ec.edu.epn.laboratorioBJ.entities.Tipoproducto;
import ec.edu.epn.laboratorioBJ.entities.Unidadmedida;
import ec.edu.epn.laboratorioBJ.entities.laboratory;

/**
 * Session Bean implementation class ExistenciasDAOImplement
 */
@Stateless
@LocalBean
public class ExistenciasDAOImplement extends DaoGenericoImplement<Existencia> implements ExistenciasDAO {

	/**
	 * Default constructor.
	 */
	public ExistenciasDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	private String consulta;

	@Override
	public SaldoExistencia findSaldoById(String id) {
		StringBuilder querys = new StringBuilder("SELECT s FROM SaldoExistencia s where id_existencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			SaldoExistencia metodo = (SaldoExistencia) query.getSingleResult();
			return metodo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<ProductoLab> filtrarLista(String dato) {
		// Busqueda por nombre

		dato = dato.toUpperCase();

		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM ProductoLab p where UPPER (nombrePr) like UPPER ('%" + dato + "%')");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<ProductoLab> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public String maxIdServ(int id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(e.idExistencia) FROM Existencia e where idUnidad = ?1 ");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		String idExistencia = (String) query.getSingleResult();
		return idExistencia;
	}

	@Override
	public List<Movimientosinventario> listarMovimientoById(String idExistencia) {

		StringBuilder queryString = new StringBuilder(
				"SELECT m FROM Movimientosinventario m where m.idExistencia = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idExistencia);

		List<Movimientosinventario> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public List<Existencia> listarExistenciaById(int id) {

		StringBuilder queryString = new StringBuilder("SELECT e FROM Existencia e where e.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Existencia> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public Hidratacion buscarHidratacionById(String id) {
		int idh = Integer.parseInt(id);
		StringBuilder querys = new StringBuilder("SELECT h FROM Hidratacion h where h.idHidratacion = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, idh);
		query.setMaxResults(1);

		try {
			Hidratacion hidratacion = (Hidratacion) query.getSingleResult();
			return hidratacion;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Movimientosinventario movimientoInvenBynombred(String id) {

		StringBuilder querys = new StringBuilder("SELECT m FROM Movimientosinventario m where m.idExistencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Movimientosinventario movimientoInv = (Movimientosinventario) query.getSingleResult();
			return movimientoInv;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	@Override
	public Pureza buscarPurezaById(String id) {
		StringBuilder querys = new StringBuilder("SELECT p FROM Pureza p where p.idPureza = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Pureza pureza = (Pureza) query.getSingleResult();
			return pureza;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Existencia buscarExistenciaById(String id) {
		StringBuilder querys = new StringBuilder("SELECT e FROM Existencia e where e.idExistencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Existencia existencia = (Existencia) query.getSingleResult();
			return existencia;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	/** CONSULTAS PARA CAMPOS VACIOS EN COMBOS **/

	@Override
	public Presentacion reemplazarNullPresentacion() {
		StringBuilder querys = new StringBuilder("SELECT p FROM Presentacion p where p.idPresentacion = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Presentacion presentacion = (Presentacion) query.getSingleResult();
			return presentacion;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Estadoproducto reemplazarNullEstadoPro() {
		StringBuilder querys = new StringBuilder("SELECT e FROM Estadoproducto e where e.idEstadoprod = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Estadoproducto estadoproducto = (Estadoproducto) query.getSingleResult();
			return estadoproducto;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Grado reemplazarNullGrado() {
		StringBuilder querys = new StringBuilder("SELECT g FROM Grado g where idGrado = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Grado grado = (Grado) query.getSingleResult();
			return grado;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Posgiro reemplazarNullPosgiro() {
		StringBuilder querys = new StringBuilder("SELECT p FROM Posgiro p where p.idPosgiro = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Posgiro posgiro = (Posgiro) query.getSingleResult();
			return posgiro;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Tipoproducto tempTipoPro() {
		StringBuilder querys = new StringBuilder("SELECT p FROM Tipoproducto p where p.idTipoprod = '4'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Tipoproducto tipoproducto = (Tipoproducto) query.getSingleResult();
			return tipoproducto;
		} catch (NoResultException nre) {
			System.out.println("trae null");
			return null;
		} catch (NonUniqueResultException nure) {
			System.out.println("trae null");
			return null;
		}

	}

	@Override
	public Unidadmedida tempUnidadMedida() {
		StringBuilder querys = new StringBuilder("SELECT u FROM Unidadmedida u where u.idUmedida = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Unidadmedida unidadM = (Unidadmedida) query.getSingleResult();
			return unidadM;
		} catch (NoResultException nre) {
			System.out.println("trae null");
			return null;
		} catch (NonUniqueResultException nure) {
			System.out.println("trae null");
			return null;
		}

	}

	@Override
	public Hidratacion reemplazarNullHidratacion() {
		StringBuilder querys = new StringBuilder("SELECT h FROM Hidratacion h where h.idHidratacion = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Hidratacion hidratacion = (Hidratacion) query.getSingleResult();
			return hidratacion;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Caracteristica reemplazarNullCaracteristica() {
		StringBuilder querys = new StringBuilder("SELECT c FROM Caracteristica c where c.idCaracteristica = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Caracteristica caracteristica = (Caracteristica) query.getSingleResult();
			return caracteristica;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Concentracion reemplazarNullConcentracion() {
		StringBuilder querys = new StringBuilder("SELECT c FROM Concentracion c where c.idConcentracion = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Concentracion concentracion = (Concentracion) query.getSingleResult();
			return concentracion;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public laboratory reemplazarNullBodega() {
		StringBuilder querys = new StringBuilder("SELECT l FROM laboratory l where l.idBodega = '1'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			laboratory laboratory = (laboratory) query.getSingleResult();
			return laboratory;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Pureza reemplazarNullPureza() {
		StringBuilder querys = new StringBuilder("SELECT p FROM Pureza p where p.idPureza = '0'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Pureza pureza = (Pureza) query.getSingleResult();
			return pureza;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Movimientosinventario> getParametroFecha(String fechaInicio, String fechaFinal) {
		setConsulta(
				"SELECT (m) FROM Movimientosinventario m, Existencia e, ProductoLab p, Grado g, Tipoproducto tp, Tipordeninv toi"
						+ " WHERE m.idExistencia = e.idExistencia " + " AND e.producto.idProducto = p.idProducto"
						+ " AND e.grado.idGrado = g.idGrado" + " AND p.tipoproducto.idTipoprod = tp.idTipoprod"
						+ " AND m.fechaMi BETWEEN '" + fechaInicio + "' AND '" + fechaFinal + "'");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Movimientosinventario> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public List<Existencia> getListExByTP(String id) {

		// System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT e FROM Existencia e where e.idExistencia like '%" + id + "%' ORDER BY e.producto.nombrePr ASC");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Existencia> resultados = query.getResultList();

		System.out.println("Resultado: " + resultados.size());
		return resultados;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
