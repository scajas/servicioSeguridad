package ec.edu.epn.voto.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;


import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.MiembroVoto;
import ec.edu.epn.voto.entities.Mocion;
import ec.edu.epn.voto.entities.OrdenDia;
import ec.edu.epn.voto.entities.ParametroVoto;
import ec.edu.epn.voto.entities.PerfilConsejo;
import ec.edu.epn.voto.entities.RegVotacion;
import ec.edu.epn.voto.entities.Resolucion;
import ec.edu.epn.voto.entities.Votacion;

@Local
public interface MocionService1 {

	List<OrdenDia> findOrdenDia(Date fecha);

	List<Mocion> findocion(Integer idOrden);

	List<MiembroVoto> findMiembros(String cedula, String nombre, String apellido);

	int consultarIdMocion();

	void insertarMocion(Mocion moc) throws Exception;

	void updateMOcion(Mocion moc) throws Exception;

	void eliminarMocion(Mocion moc) throws Exception;

	int consultarIdVoto();

	void insertarVoto(Votacion vot) throws Exception;

	MiembroVoto findMiembro(String cedula);

	List<Votacion> findVoto(Integer idOrden, String cedula);

	List<Votacion> findVotoS(Integer idmoion);

	Double constarVotos(String voto, Integer idmocion);

	Long constarAsistentes(Date fechaActual, Integer Idconsejo, String estado);



	void insertarregVot(RegVotacion reg) throws Exception;

	void updateRegVot(RegVotacion reg) throws Exception;

	int consultarIdRegVot();

	RegVotacion findRegVotracion(Integer idMocion);

	List<RegVotacion> findRegExiste(Integer idmoion);

	ParametroVoto findParametroConsejo(Integer idconsejo);

	void updateparam(ParametroVoto param) throws Exception;

	void insertResolucion(Resolucion resol) throws Exception;

	List<Votacion> verVotaciones(String voto, Integer idmocion);

	List<Asistencia> verAsistentes(Integer Idconsejo, String estado,
			Integer idsesion);

	Resolucion findresolucionByMocion(Integer idMocion);

	Long constarAsistentesVotacion(Date fechaActual, Integer Idconsejo,
			String estado);

	PerfilConsejo findPerfilConsejo(Integer idperfil);

	List<OrdenDia> findOrdenDiaByConsejo(Date fecha, int idconsejo);

	

	Consejo Consejo(int idconsejo);

	List<MiembroVoto> findMiembrosConsejo(String cedula, String nombre,
			String apellido, int idconsejo);

	MiembroVoto findMiembroConsejo(String cedula, int idconsejo);


}
