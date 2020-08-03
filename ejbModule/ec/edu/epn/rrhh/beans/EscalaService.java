package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Escala;



@Local
public interface EscalaService  {
	List<Escala> listaEscalas();
	
	double rmuAsistCatedra();
	


}
