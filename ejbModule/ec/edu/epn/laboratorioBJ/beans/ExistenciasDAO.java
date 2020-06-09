package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Caracteristica;
import ec.edu.epn.laboratorioBJ.entities.Concentracion;
import ec.edu.epn.laboratorioBJ.entities.Estadoproducto;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Grado;
import ec.edu.epn.laboratorioBJ.entities.Hidratacion;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.Posgiro;
import ec.edu.epn.laboratorioBJ.entities.Presentacion;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;
import ec.edu.epn.laboratorioBJ.entities.Pureza;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;
import ec.edu.epn.laboratorioBJ.entities.Tipoproducto;
import ec.edu.epn.laboratorioBJ.entities.Unidadmedida;
import ec.edu.epn.laboratorioBJ.entities.laboratory;

@Local
public interface ExistenciasDAO extends DaoGenerico<Existencia> {

	SaldoExistencia findSaldoById(String id);
	
	Movimientosinventario movimientoInvenBynombred(String id);
	
	/*reporte*/
	List<Movimientosinventario> getParametroFecha(String fechaInicio, String fechaFinal);

	List<ProductoLab> filtrarLista(String dato);

	String maxIdServ(int id);

	List<Movimientosinventario> listarMovimientoById(String idExistencia);

	List<Existencia> listarExistenciaById(int id);

	Presentacion reemplazarNullPresentacion();

	Estadoproducto reemplazarNullEstadoPro();

	Grado reemplazarNullGrado();

	Posgiro reemplazarNullPosgiro();

	Hidratacion reemplazarNullHidratacion();

	Caracteristica reemplazarNullCaracteristica();

	Concentracion reemplazarNullConcentracion();

	laboratory reemplazarNullBodega();

	Pureza reemplazarNullPureza();

	Hidratacion buscarHidratacionById(String id);

	Pureza buscarPurezaById(String id);

	Existencia buscarExistenciaById(String id);

	List<Existencia> getListExByTP(String id);

	Tipoproducto tempTipoPro();

	Unidadmedida tempUnidadMedida();

	List<Existencia> existenciasByParametros(String nombreTP, String caracteristica);

}
