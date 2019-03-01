package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.voto.entities.Consejo;

@Local
public interface ConsejoService {

	List<Consejo> listaConsejo();

	void eliminarConsejo(int idConsejo);

	void actualizarConsejo(Consejo consejo);

	void guardarNUevoConsejo(Consejo consejo);

	int maxConsejo();

}
