package ec.edu.epn.generic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.ejb.EJBHome;
import javax.ejb.Local;

import ec.edu.epn.laboratorioBJ.entities.Servicio;


@Local
public interface DaoGenerico<E> extends EJBHome {

	public void save(E objeto) throws Exception;

	public void update(E objeto) throws Exception;

	public void delete(E objeto) throws Exception;

	public Object getById(Class<E> classe, Object pk) throws Exception;

	public List<E> getAll(Class<E> classe) throws Exception;
	
	public void cerrarConexion(Connection con, PreparedStatement ps) throws Exception;


	Connection conexionDocenteReporte();	


	Integer generarId(String entidad, String id);

	void eliminar(String entidad, String idCampo, Integer valor);




}
