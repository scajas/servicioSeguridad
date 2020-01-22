package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.CargaPlanificacionDTO;
import ec.edu.epn.gestionDocente.entities.CargaAcademicaSae;

/**
 * Session Bean implementation class CargaAcademicaSaeDAOImplement
 */
@Stateless
@LocalBean
public class CargaAcademicaSaeDAOImplement extends DaoGenericoImplement<CargaAcademicaSae>
		implements CargaAcademicaSaeDAO {
	
	
	@Override
	public Long countCargAcadSaeXDocPeriodo(String nced, Integer idPensum)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(c) FROM CargaAcademicaSae c WHERE c.nced like ? AND c.idPensum= ? ");
		
		q.setParameter(1, "%" + nced + "%");
		q.setParameter(2, idPensum);
		return (Long) q.getSingleResult();
	}
	
	
	
	
	@Override
	public List<CargaAcademicaSae> listCargAcadSaeXDocPeriodo(String nced, Integer idPensum)
			throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT c FROM CargaAcademicaSae c WHERE c.nced=? AND c.idPensum= ? ORDER BY idCargaAcademica");
		
		q.setParameter(1, nced);
		q.setParameter(2, idPensum);
		return q.getResultList();
	}
	
	
	@Override
	public void cargaAcademicaSae(List<CargaPlanificacionDTO> listCarga, Integer idPensum, String nced)throws Exception {		
		
		if(!listCarga.isEmpty()){
			for(CargaPlanificacionDTO dto: listCarga){
				CargaAcademicaSae sae= new CargaAcademicaSae();			
				sae.setCapacidadAlumnosSae(dto.getCapacidadAlumnosSAE()==null?0:dto.getCapacidadAlumnosSAE());
				sae.setCodMateriaSae(dto.getCodMateriaSAE()==null?"":dto.getCodMateriaSAE());
				sae.setHorasModuloSae(dto.getHorasModuloSAE()==null?0:dto.getHorasModuloSAE());
				sae.setHorasTotalSemanaSae(dto.getHorasTotalSemanaSAE()==null?0:dto.getHorasTotalSemanaSAE());
				sae.setIdPensum(idPensum);
				sae.setNced(nced);
				sae.setNomParaleloSae(dto.getNomParaleloSAE()==null?"":dto.getNomParaleloSAE());
				sae.setNomCarreraSae(dto.getNomCarreraSAE()==null?"":dto.getNomCarreraSAE());
				sae.setNomMateriaSae(dto.getNomMateriaSAE()==null?"":dto.getNomMateriaSAE());
				sae.setNumAlumnosSae(dto.getNumAlumnosSAE()==null?0:dto.getNumAlumnosSAE());
				sae.setAula(dto.getAula()==null?"":dto.getAula());
				/*sae.setNivel(dto.getNivel());
				sae.setRegimen((dto.getRegimen()));*/
				super.save(sae);				
				
			}		
		}
	}
	
	
	
	@Override
	public void actualizarCargaAcademicaSae(List<CargaPlanificacionDTO> listCarga, List<CargaPlanificacionDTO> listCargaAux, List<CargaAcademicaSae> listCargaAcademica, Integer idPensum, String nced)throws Exception {		
		
		
		listCargaAux= new ArrayList<CargaPlanificacionDTO>();
		
		
		
		if(!listCarga.isEmpty() && !listCargaAcademica.isEmpty()){
			for(CargaPlanificacionDTO dto: listCarga){
				listCargaAux.add(dto);
			}
			for(CargaPlanificacionDTO dto: listCarga){
				for(CargaAcademicaSae carga: listCargaAcademica){
					if(dto.getNomMateriaSAE().trim().toLowerCase().equals(carga.getNomMateriaSae().trim().toLowerCase()) 
							&& dto.getNomParaleloSAE().trim().toLowerCase().equals(carga.getNomParaleloSae().trim().toLowerCase())
							&& dto.getCodMateriaSAE().trim().toLowerCase().equals(carga.getCodMateriaSae().trim().toLowerCase())
							&& dto.getAula().trim().equals(carga.getAula())){						
						carga.setHorasModuloSae(dto.getHorasModuloSAE()==null?0:dto.getHorasModuloSAE());
						carga.setHorasTotalSemanaSae(dto.getHorasTotalSemanaSAE()==null?0:dto.getHorasTotalSemanaSAE());
						carga.setNumAlumnosSae(dto.getNumAlumnosSAE()==null?0:dto.getNumAlumnosSAE());
						carga.setCodMateriaSae(dto.getCodMateriaSAE()==null?"":dto.getCodMateriaSAE());
						carga.setNomParaleloSae(dto.getNomParaleloSAE()==null?"":dto.getNomParaleloSAE());
						carga.setNomCarreraSae(dto.getNomCarreraSAE()==null?"":dto.getNomCarreraSAE());
						carga.setNomMateriaSae(dto.getNomMateriaSAE()==null?"":dto.getNomMateriaSAE());
						carga.setAula(dto.getAula()==null?"":dto.getAula());
						/*carga.setNivel(dto.getNivel());
						carga.setRegimen(dto.getRegimen());*/
						super.update(carga);
						listCargaAux.remove(dto);
					}
				}
			}
			
			
			if(!listCargaAux.isEmpty()){
				for(CargaPlanificacionDTO dto: listCargaAux){
					CargaAcademicaSae sae= new CargaAcademicaSae();			
					sae.setCapacidadAlumnosSae(dto.getCapacidadAlumnosSAE()==null?0:dto.getCapacidadAlumnosSAE());
					sae.setCodMateriaSae(dto.getCodMateriaSAE()==null?"":dto.getCodMateriaSAE());
					sae.setHorasModuloSae(dto.getHorasModuloSAE()==null?0:dto.getHorasModuloSAE());
					sae.setHorasTotalSemanaSae(dto.getHorasTotalSemanaSAE()==null?0:dto.getHorasTotalSemanaSAE());
					sae.setIdPensum(idPensum);
					sae.setNced(nced);					
					sae.setNomParaleloSae(dto.getNomParaleloSAE()==null?"":dto.getNomParaleloSAE());
					sae.setNomCarreraSae(dto.getNomCarreraSAE()==null?"":dto.getNomCarreraSAE());
					sae.setNomMateriaSae(dto.getNomMateriaSAE()==null?"":dto.getNomMateriaSAE());
					sae.setNumAlumnosSae(dto.getNumAlumnosSAE()==null?0:dto.getNumAlumnosSAE());		
					sae.setAula(dto.getAula()==null?"":dto.getAula());
					/*sae.setNivel(dto.getNivel());
					sae.setRegimen(dto.getRegimen());*/
					super.save(sae);				
					
				}
			}
		}
	}
	
	
	@Override
	public void actualizarNumEstudCargaAcademicaSae(List<CargaPlanificacionDTO> listCarga, List<CargaAcademicaSae> listCargaAcademica)throws Exception {		
		
		
		if(!listCarga.isEmpty() && !listCargaAcademica.isEmpty()){			
			for(CargaPlanificacionDTO dto: listCarga){
				for(CargaAcademicaSae carga: listCargaAcademica){
					if(dto.getNomMateriaSAE().trim().trim().toUpperCase().replace("Ñ", "N").replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U").toLowerCase()
								.equals(carga.getNomMateriaSae().trim().toUpperCase().replace("Ñ", "N").replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U").toLowerCase()) 
							&& dto.getNomParaleloSAE().trim().toLowerCase().equals(carga.getNomParaleloSae().trim().toLowerCase())
							&& dto.getCodMateriaSAE().trim().toLowerCase().equals(carga.getCodMateriaSae().trim().toLowerCase())
							&& dto.getAula().trim().replace("/", "").toUpperCase().equals(carga.getAula().trim().toUpperCase().replace("/", ""))){
						carga.setNumAlumnosSae(dto.getNumAlumnosSAE()==null?0:dto.getNumAlumnosSAE());
						
						super.update(carga);						
					}
				}
			}
			
			
			
		}
	}
	
	@Override
	public void actualizarCargaAcademicaSaeDelete(List<CargaPlanificacionDTO> listCarga, List<CargaAcademicaSae> listCargaAcademicaAUX, List<CargaAcademicaSae> listCargaAcademica, Integer idPensum, String nced)throws Exception {		
		
		
		listCargaAcademicaAUX= new ArrayList<CargaAcademicaSae>();
		
		
		
		if(!listCargaAcademica.isEmpty() && !listCarga.isEmpty()){
			for(CargaAcademicaSae dto: listCargaAcademica){
				listCargaAcademicaAUX.add(dto);
			}
			
			for(CargaAcademicaSae carga: listCargaAcademica){			
				for(CargaPlanificacionDTO dto: listCarga){
					if(dto.getNomMateriaSAE().trim().toLowerCase().equals(carga.getNomMateriaSae().trim().toLowerCase()) 
							&& dto.getNomParaleloSAE().trim().toLowerCase().equals(carga.getNomParaleloSae().trim().toLowerCase())
							&& dto.getCodMateriaSAE().trim().toLowerCase().equals(carga.getCodMateriaSae().trim().toLowerCase())
							&& dto.getAula().trim().equals(carga.getAula())){
						listCargaAcademicaAUX.remove(carga);
					}
				}
			}
			
			
			if(!listCargaAcademicaAUX.isEmpty()){
				for(CargaAcademicaSae dto: listCargaAcademicaAUX){									
					super.delete(dto);				
					
				}
			}
		}
	}
	
	
	
	@Override
	public void cargaAcademicaRemedialSae(List<CargaPlanificacionDTO> listCarga, Integer idPensum, String nced)throws Exception {		
		
		if(!listCarga.isEmpty()){
			for(CargaPlanificacionDTO dto: listCarga){
				CargaAcademicaSae sae= new CargaAcademicaSae();			
				sae.setCapacidadAlumnosSae(dto.getCapacidadAlumnosSAE()==null?0:dto.getCapacidadAlumnosSAE());
				sae.setCodMateriaSae(dto.getCodMateriaSAE()==null?"":dto.getCodMateriaSAE());
				sae.setHorasModuloSae(dto.getHorasRemdiales()==null?0:dto.getHorasRemdiales());
				sae.setHorasTotalSemanaSae(0);
				sae.setIdPensum(idPensum);
				sae.setNced(nced);
				sae.setNomParaleloSae(dto.getNomParaleloSAE()==null?"":dto.getNomParaleloSAE());
				sae.setNomCarreraSae(dto.getNomCarreraSAE()==null?"":dto.getNomCarreraSAE());
				sae.setNomMateriaSae(dto.getNomMateriaSAE()==null?"":dto.getNomMateriaSAE());
				sae.setNumAlumnosSae(dto.getNumAlumnosSAE()==null?0:dto.getNumAlumnosSAE());
				sae.setAula(dto.getAula()==null?"":dto.getAula());
				super.save(sae);				
				
			}		
		}
	}
	
}
