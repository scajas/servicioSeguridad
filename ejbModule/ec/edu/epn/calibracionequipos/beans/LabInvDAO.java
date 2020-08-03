package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.LabLinInv;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface LabInvDAO extends DaoGenerico<LabLinInv> {

}
