package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.DocumentoGD;

@Local
public interface DocumentoDAOGD extends DaoGenerico<DocumentoGD>{

	List<DocumentoGD> buscarDocumentoExiste(Integer idPublic, Integer idEstado) throws Exception;

	int maxIdDocumento();

}
