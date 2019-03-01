package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.AnexoInforme;
import ec.edu.epn.proyectos.entities.InformeTecnico;

/**
 * Session Bean implementation class AnexoInformeDAOImplement
 */
@Stateless
@LocalBean
public class AnexoInformeDAOImplement extends DaoGenericoImplement<AnexoInforme> implements AnexoInformeDAO {

    /**
     * Default constructor. 
     */
    public AnexoInformeDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public List<AnexoInforme> findAnexoByInforme(Integer idinforme) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from AnexoInforme rec where rec.informeTecnico.id = ?1  order by rec.id");
		qUsuario.setParameter(1, idinforme);
		return qUsuario.getResultList();

	}
    

}
