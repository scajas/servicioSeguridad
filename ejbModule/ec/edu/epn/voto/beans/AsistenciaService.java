package ec.edu.epn.voto.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;



import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Sesion;

@Local
public interface AsistenciaService {

	List<Asistencia> listaAsistencia();

	List<Asistencia> listaNoAsistencia();

	List<Asistencia> listaTodosAsistencia();

	List<Asistencia> listaAA1();

	void guardarAsistencia(Asistencia asistencia);

	int maxAssitencia();

	void actualizarAsistencia(Asistencia asistencia);

	List<Asistencia> listaAsistencia(String cedula);
	void eliminarAsistencia(Asistencia asistencia);

	List<Asistencia> constarAsisExiste(Integer id_sesion, Integer id_miembro);

	List<Asistencia> listaAsistenciaSesion(Date fechaActual, Integer Idconsejo,
			String estado);

	List<Sesion> listaSesionConsejo(int idconsejo);

}
