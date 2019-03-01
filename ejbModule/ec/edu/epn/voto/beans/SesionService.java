package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Local;


import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Sesion;

@Local
public interface SesionService {

	Sesion listaSesionAsistencia(int id_concejo);

	List<Sesion> listaSesiones();

	List<Sesion> listaSesionescedula(int id_concejo);

	Integer findIDConcejoSesionXIDSesion(int idSesion);

}
