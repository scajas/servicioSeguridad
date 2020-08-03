package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.ConvOrganizacion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ConvOrgDAO extends DaoGenerico<ConvOrganizacion>{

	List<ConvOrganizacion> findConvOrg(int idOrg, String id_conv);

	List<ConvOrganizacion> findConvOrgSelect(String id_conv);

}
