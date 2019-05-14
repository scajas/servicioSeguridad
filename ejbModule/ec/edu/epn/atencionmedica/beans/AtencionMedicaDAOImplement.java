package ec.edu.epn.atencionmedica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless(mappedName="AtencionMedicaDAOImplement")
public class AtencionMedicaDAOImplement extends DaoGenericoImplement<Atencionmedica> implements AtencionMedicaDAO {
	
	//variables
	public Query query = null;
	public String q ="";
	public StringBuilder queryString = null;

	@Override
	public boolean guardarAtencion(Atencionmedica atencionmedica) {
		try {
			// TODO Auto-generated method stub
			getEntityManager().persist(atencionmedica);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR: atencion medica ----Service Bean ------------");
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Atencionmedica> obtenerListaAtenciones(String criterio) {
		// TODO Auto-generated method stub
		List<Atencionmedica> listaAtencionesEncontradas = new ArrayList<Atencionmedica>();
		
		if (!criterio.isEmpty() && !criterio.equals("")
				&& !criterio.equals(" ") && !criterio.equals("0")) {
			
			q = "SELECT ins FROM Atencionmedica ins "
					+ " WHERE ins.paciente.idPaciente = ?0 AND esprocedenfermeriaAtm = false"
					+ " order by ins.fechahoraAtm desc ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, Integer.parseInt(criterio));

			listaAtencionesEncontradas = query.getResultList();
		}
		return listaAtencionesEncontradas;
	}

	@Override
	public Atencionmedica obtenerAtencionMedica(Atencionmedica atencion) {
		// TODO Auto-generated method stub		
		List<Atencionmedica> listaAtencionesEncontradas = new ArrayList<Atencionmedica>();
		//obtener la atencion mèdica por id de atencion medica
		if (atencion.getIdAtencionmed()!=0)
		{	
			q = "SELECT c FROM Atencionmedica c WHERE c.idAtencionmed = ?0 ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, atencion.getIdAtencionmed());
			listaAtencionesEncontradas = query.getResultList();
			
		}
		else
		if (atencion.getCatalogo().getIdCatalogo()>0 && atencion.getPersonal().getIdPersonal()>0 && atencion.getPaciente().getIdPaciente()>0 && atencion.getTopografiacie().getIdTopografia()>0)
		{
			q = "SELECT c FROM Atencionmedica c"
					+ " WHERE c.catalogo.idCatalogo = ?0 "
					+ " AND c.paciente.idPaciente = ?1 "
					+ " AND c.personal.idPersonal = ?2 "
					+ " AND c.topografiacie.idTopografia = ?3 "
					+ " order by c.idAtencionmed desc ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, atencion.getCatalogo().getIdCatalogo());
			query.setParameter(1, atencion.getPaciente().getIdPaciente());
			query.setParameter(2, atencion.getPersonal().getIdPersonal());
			query.setParameter(3, atencion.getTopografiacie().getIdTopografia());					
		
			listaAtencionesEncontradas = query.getResultList();
			
		}
		return listaAtencionesEncontradas.get(0);		
	}

	public Integer countMovientos(Integer idAtencion) throws Exception{
		
		q = "SELECT COUNT(m) FROM  Movimientoinventario m WHERE m.atencionmedica.idAtencionmed =?0";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, idAtencion);
				
		return Integer.parseInt(query.getResultList().get(0).toString());
				
	}

	@Override
	public Atencionmedica obtenerAtencionMedicaPorPaciente(Integer idAtencion, Integer idPaciente) {
		
		List<Atencionmedica> listaAtencionMedica = new ArrayList<Atencionmedica>();
		q = "SELECT a FROM  Atencionmedica a WHERE a.idAtencionmed =?0 AND a.paciente.idPaciente = ?1";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, idAtencion);
		query.setParameter(1, idPaciente);
		 
		listaAtencionMedica = query.getResultList();
		
		return listaAtencionMedica.get(0);
	}

	@Override
	public Atencionmedica obtenerUltimaAtencionMedicaPorPaciente(Integer idPaciente) {
		List<Atencionmedica> listaAtencionesSignosVitales = new ArrayList<Atencionmedica>();
		
		q = "SELECT am FROM Atencionmedica am "
					+ " WHERE am.paciente.idPaciente = ?0 "
					+ " AND cast(am.fechahoraAtm as date) = (SELECT cast(MAX(a.fechahoraAtm) as date) FROM Atencionmedica a )"
					+ " AND CAST(am.fechahoraAtm as date) >= CAST(now() as date)"
					+ " order by am.fechahoraAtm desc ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, idPaciente);

			listaAtencionesSignosVitales = query.getResultList();
			
			if(!listaAtencionesSignosVitales.isEmpty()){
				return listaAtencionesSignosVitales.get(0);
			}
			else{
				return null;
			}
	}
	
	
	
	

	@Override
	public List<Atencionmedica> obtenerListaProcedimientos(String criterio) {

		List<Atencionmedica> listaAtencionesEncontradas = new ArrayList<Atencionmedica>();
		
		if (!criterio.isEmpty() && !criterio.equals("")
				&& !criterio.equals(" ") && !criterio.equals("0")) {
			
			q = "SELECT ins FROM Atencionmedica ins "
					+ " WHERE ins.paciente.idPaciente = ?0 AND esprocedenfermeriaAtm = true"
					+ " order by ins.fechahoraAtm desc ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, Integer.parseInt(criterio));

			listaAtencionesEncontradas = query.getResultList();
		}
		return listaAtencionesEncontradas;
	}
	
	
	
	@Override
	public Atencionmedica obtenerAtencionMedicaPaciente(Integer idPaciente) {
		List<Atencionmedica> listaAtencionesSignosVitales = new ArrayList<Atencionmedica>();
		
		q = "SELECT am FROM Atencionmedica am "
					+ " WHERE am.paciente.idPaciente = ?0 ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, idPaciente);

			listaAtencionesSignosVitales = query.getResultList();
			
			if(!listaAtencionesSignosVitales.isEmpty()){
				return listaAtencionesSignosVitales.get(0);
			}
			else{
				return null;
			}
	}

}
