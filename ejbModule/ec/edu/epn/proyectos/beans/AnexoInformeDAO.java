package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.AnexoInforme;

@Local
public interface AnexoInformeDAO extends DaoGenerico<AnexoInforme>{

	List<AnexoInforme> findAnexoByInforme(Integer idinforme);

}
