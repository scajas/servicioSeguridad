package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Estudio;



@Local
public interface EstudioDAO extends DaoGenerico<Estudio> {
	int consultarIdEstudios();
	boolean validarEstudios(String titulo, String cedula, String nivel,
			String institucion);
	List<Estudio> listaEstudioXcedula(String cedula);
	List<Estudio> findEstudiosByParams(String nced);

}
