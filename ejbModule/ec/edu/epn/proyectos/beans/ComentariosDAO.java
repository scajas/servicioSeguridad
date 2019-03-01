package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Comentario;

@Local
public interface ComentariosDAO extends DaoGenerico<Comentario>{

	List<Comentario> findComentarioByproyecto(String estado, Integer idproy, String cedula, String departamento,
			String tipo,String vips,Integer idpensum);

}
