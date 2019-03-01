package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.voto.entities.Consejo;

@Local
public interface ConsejoServices {
	List<Consejo> findAllConsejoConv();

}
