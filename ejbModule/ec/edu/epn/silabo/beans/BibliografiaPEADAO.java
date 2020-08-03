package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Bibliografia;
import ec.edu.epn.silabo.entities.BibliografiaPea;

@Local
public interface BibliografiaPEADAO extends DaoGenerico<BibliografiaPea> {

	List<BibliografiaPea> consultarBilbiografia(Integer idpea, String tipo);

	List<BibliografiaPea> consultarBilbiografiaExiste(Integer idpea, String tipo, String titulo);

}
