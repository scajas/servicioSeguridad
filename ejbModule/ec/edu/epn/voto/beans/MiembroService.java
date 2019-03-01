package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.MiembroVoto;

@Local
public interface MiembroService {

	List<MiembroVoto> findConcejoXCIMiembro(String cedulaMiembro);

	List<MiembroVoto> findConcejo(String cedula);

	List<Integer> findidsConcejo(String cedulaMiembro);

	List<MiembroVoto> findMiembro();

	void guardarMiembro(MiembroVoto miembro);

	void eliminarMiembro(MiembroVoto miembro);

	void actualizarMiembro(MiembroVoto miembro);

	int maxMiembro();

	List<MiembroVoto> findMiembroExiste(String cedulaMiembro, Integer id_consejo);

	List<MiembroVoto> findMiembroPreside();

	List<Consejo> findAllConsejo();

	public List<MiembroVoto> findMiembroConsejo(Integer id_consejo);
	
	public void guardarAsistencia(Asistencia asis);
	
	public int maxAssitencia();

}
