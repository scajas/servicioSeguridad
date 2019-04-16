package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.Local;

import ec.edu.epn.laboratorioBJ.entities.laboratory;

import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface LaboratoryDAO extends DaoGenerico<laboratory> {

}
