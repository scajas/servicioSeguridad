package ec.edu.epn.silabo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.NombTemp;
import ec.edu.epn.silabo.dto.BibliografiaSilaboDTO;
import ec.edu.epn.silabo.entities.Silabo;

@Local
public interface SilaboDAO extends DaoGenerico<Silabo>{

	Silabo consultarSilabo(String nced, String codigo, Integer idPensum, String paralelo,  String codcarrera);

	int maxsilabo();

	List<Silabo> consultarSilaboMateria(String nced, String codigo);

	List<Silabo> listConsultarSilabo(String nced, String codigo, Integer idPensum, String paralelo, String codcarrera);

	List<Silabo> listConsultaFacultad();

	List<Silabo> listConsultaCarreraXFacultad(String facultad);

	ArrayList<BibliografiaSilaboDTO> findBibliog(String facultad, String carrera, int idPensum, String materia) throws Exception;

	List<Silabo> listConsultaMateriaXFacultad(String facultad);

	List<Silabo> listConsultaMateriaXCarrera(String codcarrera);

	List<Silabo> consultarSilaboPensum(Integer idpensum);

	List<Silabo> consultarSilaboPensumByEMp(Integer idpensum, String nced);

}


