package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.HorarioEspacioOcupante;
import ec.edu.epn.infraestructura.entities.Ocupante;

@Local
public interface OcupanteDAO extends DaoGenerico<Ocupante> {
	public int maxOcupante();

	List<HorarioEspacioOcupante> buscarOcupanteXEspacio(String nombre,
			String apellido, String cedula);

	public Ocupante buscarEnEspacio(int idEspacio);
}
