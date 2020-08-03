package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.beans.PensumDAO;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CorteEvaluacionDocente;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.beans.EmpleadoDAO;

/**
 * Session Bean implementation class CorteEvaluacionDAOImplement
 */
@Stateless
@LocalBean
public class CorteEvaluacionDocenteDAOImplement extends DaoGenericoImplement<CorteEvaluacionDocente> implements CorteEvaluacionDocenteDAO {

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PensumDAOImplement!ec.edu.epn.contratos.beans.PensumDAO")
	private PensumDAO pensumDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EmpleadoDAOImplement!ec.edu.epn.rrhh.beans.EmpleadoDAO")
	private EmpleadoDAO empleadoI;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pensum> listaPensumEval(Integer idPensum) {
		Query q = getEntityManager().createQuery("SELECT pen FROM Pensum pen WHERE idPensum>= ? ORDER BY pen.idPensum ASC");
		q.setParameter(1,idPensum);

		return q.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pensum> listaPensumXCorteEval(String nced, String estado, Date fechaCierre) {
		
		CorteEvaluacionDocente cortePensum = new CorteEvaluacionDocente();
		List<Pensum> listaPensumEval = new ArrayList<Pensum>();
		List<Pensum> listaPensum = new ArrayList<Pensum>();
		Pensum p= new Pensum();	
		DocenteDTO docenteDTO= new DocenteDTO();
		
		try {
			
			listaPensumEval= this.listaPensumEval(17);
			
			if(!listaPensumEval.isEmpty()){
				for(Pensum pen: listaPensumEval){
					Query query = null;
					query = getEntityManager().createNativeQuery("SELECT  * FROM \"Rrhh\".bi_reportecargodeprrhh(?,?,?,?,?);");
					
					query.setParameter(1, pen.getIdPensum());
					query.setParameter(2, "%" + nced.trim() + "%");
					query.setParameter(3, "%%");
					query.setParameter(4, "%%");
					query.setParameter(5, "%%");
					
					List<?> lists = query.getResultList();
					
					if (!lists.isEmpty()) {
						for (Object list : lists) {
							docenteDTO = new DocenteDTO();
							Object[] col = (Object[]) list;
							
							if (col[0] != null && col[0].toString().length() != 0)
								docenteDTO.setnCed(col[0]==null? "" : col[0].toString());
							
							if (col[9] != null && col[9].toString().length() != 0)
								docenteDTO.setIdDepartamento(col[9]==null? "" : col[9].toString());
						}
					}else{
						docenteDTO= new DocenteDTO();
						docenteDTO.setnCed(null);
					}
					
					
					if(docenteDTO.getnCed()!=null){
						
						cortePensum= new CorteEvaluacionDocente();

						 cortePensum=  this.corteEvalXPensumDoc(pen.getIdPensum(), docenteDTO.getnCed(), estado, docenteDTO.getIdDepartamento());
						
						if(cortePensum!=null){							
							p= new Pensum();
							p= pensumDAO.obtenerPensumById(cortePensum.getIdPensum());
							listaPensum.add(p);
							
						}
					}
					 
				}
			}
			
			
			return listaPensum;
		} catch (Exception e) {
			listaPensum = new ArrayList<Pensum>();
			return listaPensum;
		}
		
		
	}
	
	
	@Override
	public CorteEvaluacionDocente corteEvalXPensumDoc(Integer idPensum, String nced, String estadoEval, String dep){		
		try {
			CorteEvaluacionDocente corte= new CorteEvaluacionDocente();
			CorteEvaluacionDocente corteXDepartamento= new CorteEvaluacionDocente();
			CorteEvaluacionDocente corteDoc= new CorteEvaluacionDocente();
			
			
			corteXDepartamento= this.corteEvalXDepPensum(idPensum, dep, estadoEval, "DEP");
			
			Date fechaActual= new Date();
			StringBuilder sbQuery = new StringBuilder();
			sbQuery.append(" SELECT MAX(c) FROM CorteEvaluacionDocente c WHERE c.idPensum = ? AND c.nced= ? AND c.estadoEval= ? AND c.fechaCierre>= ?");
		
			Query q = getEntityManager().createQuery(sbQuery.toString());
			q.setParameter(1, idPensum);
			q.setParameter(2, nced);
			q.setParameter(3, estadoEval);
			q.setParameter(4, fechaActual);
			
			
			
			try {
				corte= (CorteEvaluacionDocente) q.getSingleResult();
			} catch (Exception e) {
				corte= null;
			}
			
			if(corte== null && corteXDepartamento!=null){
				corteDoc= corteXDepartamento;
			}
			
			if(corteXDepartamento==null && corte!=null){
				corteDoc= corte;				
			}
			
			if(corte== null && corteXDepartamento==null){
				corteDoc= null;
			}
			
			if(corte!= null && corteXDepartamento!=null){
				if(corte.getFechaCierre().compareTo(corteXDepartamento.getFechaCierre())<1){
					corteDoc= corteXDepartamento;
				}else if(corte.getFechaCierre().compareTo(corteXDepartamento.getFechaCierre())>=1){
					corteDoc= corte;
				}else if(corte.getFechaCierre().compareTo(corteXDepartamento.getFechaCierre())==0){
					corteDoc= corteXDepartamento;
				}else if(corte.getFechaCierre().compareTo(corteXDepartamento.getFechaCierre())==1){
					corteDoc= corteXDepartamento;
				}
			}
			
			
			return corteDoc;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	@Override
	public CorteEvaluacionDocente corteEvalXDepPensum(Integer idPensum, String dep, String estadoEval, String opcion){		
		try {
			CorteEvaluacionDocente corte= new CorteEvaluacionDocente();
			Date fechaActual= new Date();
			StringBuilder sbQuery = new StringBuilder();
			sbQuery.append(" SELECT MAX(c) FROM CorteEvaluacionDocente c WHERE c.idPensum = ? AND c.codDep= ? AND c.estadoEval= ? AND c.opcion= ? AND c.fechaCierre >? ");
		
			Query q = getEntityManager().createQuery(sbQuery.toString());
			q.setParameter(1, idPensum);
			q.setParameter(2, dep);
			q.setParameter(3, estadoEval);
			q.setParameter(4, opcion);
			q.setParameter(5, fechaActual);
			
			
			corte= (CorteEvaluacionDocente) q.getSingleResult();
			
			return corte;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@Override
	public CorteEvaluacionDocente corteEvaluacionDocenteXPensum(Integer idPensum){		
		try {
			CorteEvaluacionDocente corte= new CorteEvaluacionDocente();
			
			StringBuilder sbQuery = new StringBuilder();
			sbQuery.append(" SELECT c FROM CorteEvaluacionDocente c WHERE c.idPensum = ?");
		
			Query q = getEntityManager().createQuery(sbQuery.toString());
			q.setParameter(1, idPensum);
			
			corte= (CorteEvaluacionDocente) q.getSingleResult();
			
			return corte;
			
		} catch (Exception e) {
			return null;
		}
		
	}
}


