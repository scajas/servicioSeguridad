package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Servicio;
import ec.edu.epn.laboratorioBJ.entities.Tiposervicio;

@Local
public interface ServicioDAO extends DaoGenerico<Servicio> {

	List<Servicio> listaServicioUnidad(int id);

	String maxIdServ(int id);

	List<Servicio> listaServicioXTipo(int idTipo);

	List<Servicio> getparametrosTipoServicio(String tiposervicio, int idUnidad);

	List<LaboratorioLab> listaLaboratorioUnidad(int id);

	List<Servicio> listaServicioById(int id);

}
