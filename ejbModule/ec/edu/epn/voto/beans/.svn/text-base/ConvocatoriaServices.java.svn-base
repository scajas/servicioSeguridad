package ec.edu.epn.voto.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.ConvocatoriaVoto;
import ec.edu.epn.voto.entities.OrdenDia;

@Remote
public interface ConvocatoriaServices {

	List<ConvocatoriaVoto> findConvocatoriaByParams(int idConsejo, Date fechaConv);

	List<OrdenDia> getListaOrdenDiaConv(ConvocatoriaVoto conv);

	List<ConvocatoriaVoto> findAllConvocatorias();

	List<OrdenDia> findOrdenDiaByParams(int idConv);
	
	List<Consejo> findAllConsejo();
	
	void insertConvocatoria(ConvocatoriaVoto conv);
	
	void updateConvocatoria(ConvocatoriaVoto conv);
	
	void deleteConvocatoria(ConvocatoriaVoto conv);

}
