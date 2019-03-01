package ec.edu.epn.voto.beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import ec.edu.epn.voto.entities.ConvocatoriaVoto;
import ec.edu.epn.voto.entities.OrdenDia;
import ec.edu.epn.voto.entities.Sesion;

@Local
public interface OrdenDiaServices {
	
	List <OrdenDia> findOrdenByParam(ConvocatoriaVoto convocatoria);
	
	void guardarOrdenDiaConvocatoria(OrdenDia od);
	
	void updateOrdenDiaConvocatoria(OrdenDia od);
	
	void deleteOrdenDiaConvocatoria(OrdenDia od);

	void guardarSesionConvocatoria(Sesion sec);

	Sesion findSesion(Integer idConv);

	void updateOSesion(Sesion ses);
	

}
