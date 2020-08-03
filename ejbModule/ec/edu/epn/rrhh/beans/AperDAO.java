package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Aper;



@Local
public interface AperDAO extends DaoGenerico<Aper> {

	List<Aper> listAperxNCed(String nced);

	List<Aper> listAperxNCedBytipo(String nced);

	List<Aper> listaAperbyCedula(String cedula);


}
