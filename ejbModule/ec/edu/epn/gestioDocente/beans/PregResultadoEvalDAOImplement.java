/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.catalogos.entities.PreguntasEvaluacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.CoEvaluacionResultadoDTO;
import ec.edu.epn.gestionDocente.DTO.PreguntasEvaluacionDTO;
import ec.edu.epn.gestionDocente.entities.PregResultadoEval;


/**
 * @author Administrador
 * 
 */
@Stateless
public class PregResultadoEvalDAOImplement extends
		DaoGenericoImplement<PregResultadoEval> implements PregResultadoEvalDAO {
	
	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	private DataSource dataSource;
	
		@Override
		public Long countPregResultadoEvalDocente(Integer idResultadoEval)
				throws Exception {
			Query q = getEntityManager()
					.createQuery(
							"SELECT count(p) FROM PregResultadoEval p WHERE p.resultadoEval.idResultadoEval = ?");
	
			q.setParameter(1, idResultadoEval);			
			return (Long) q.getSingleResult();
		}
		
		
		@Override
		public PregResultadoEval valPregResEvalXIdPreg(Integer idResultadoEval, Integer idPreguntasEval)
				throws Exception {
			Query q = getEntityManager()
					.createQuery(
							"SELECT p FROM PregResultadoEval p WHERE p.resultadoEval.idResultadoEval = ? AND p.idPreguntasEval=?");
	
			q.setParameter(1, idResultadoEval);			
			q.setParameter(2, idPreguntasEval);
			return (PregResultadoEval) q.getSingleResult();
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<PreguntasEvaluacionDTO> listPregResultadoEvaluacion(String tipo, String seleccion, Integer idResultadoEval) throws Exception{
			List<PreguntasEvaluacion> listPreguntEval= new ArrayList<PreguntasEvaluacion>();
			List<PreguntasEvaluacionDTO> listPreguntEvalDTO= new ArrayList<PreguntasEvaluacionDTO>();
			List<String> opciones;
			
			
			/*Query q = getEntityManager().createQuery(
					"SELECT p FROM PregResultadoEval pr, PreguntasEvaluacion p WHERE p.idPreguntasEval= pr.idPreguntasEval AND  p.tipo = ? AND p.asignacion=?");*/
			Query q = getEntityManager().createQuery(
					"SELECT p FROM PreguntasEvaluacion p WHERE p.tipo = ? AND p.asignacion=? ORDER BY p.orden");
			
			q.setParameter(1, tipo);
			q.setParameter(2, seleccion);
			
			listPreguntEval= q.getResultList();		
			
			if(listPreguntEval!=null){
				for (PreguntasEvaluacion preg: listPreguntEval){
					PreguntasEvaluacionDTO dto= new PreguntasEvaluacionDTO();
					PregResultadoEval pregResultadoEval= new PregResultadoEval();
					pregResultadoEval= this.valPregResEvalXIdPreg(idResultadoEval, preg.getIdPreguntasEval());
					if(pregResultadoEval!=null ){
						
						if(preg.getAsignacion().equals("SELECCION")){
							dto.setSeleccion(String.valueOf(pregResultadoEval.getValor().intValue()/20));
						}else{
							dto.setSeleccion(String.valueOf(pregResultadoEval.getValor()));
						}
												
						
						if(pregResultadoEval.getValor2()!=null /*&& pregResultadoEval.getValor2()!=0.0*/){
							dto.setSeleccion2(String.valueOf(pregResultadoEval.getValor2()));
						}
						
						
						if(preg.getAsignacion().equals("HORAS")){
							Double valor= Double.valueOf(dto.getSeleccion()==null?"0.0":dto.getSeleccion());
							Double valor2= Double.valueOf(dto.getSeleccion2()==null?"0.0":dto.getSeleccion2());			
							dto.setTotalPonderado(valor * 16 + valor2 * 8);
						}
					}
					dto.setIdPreguntasEval(preg.getIdPreguntasEval());
					dto.setAsignacion(preg.getAsignacion());
					dto.setDetalle(preg.getDetalle());
					dto.setTipo(preg.getTipo());
					dto.setOrden(preg.getOrden());
					
					opciones = new ArrayList<String>();
					opciones.add("1");
					opciones.add("2");
					opciones.add("3");
					opciones.add("4");
					opciones.add("5");				
					
					dto.setOpciones(opciones);	
					
								
					listPreguntEvalDTO.add(dto);
				}
			}else{
				listPreguntEvalDTO=null;
			}
			
			return  listPreguntEvalDTO;
		}
		
		@Override
		public ArrayList<CoEvaluacionResultadoDTO> coEvalDocentePeriodo(String nced, Integer idPensum) throws SQLException {

			Connection con = null;
			PreparedStatement ps = null;
			try {
				con =  dataSource.getConnection();
				String qry = "SELECT pe.detalle, pre.valor, pre.valor_2 "+
								"FROM \"Catalogos\".preguntas_evaluacion pe, \"GestionDocente\".preg_resultado_eval pre, \"GestionDocente\".resultado_eval re "+
								"WHERE pe.id_preguntas_eval= pre.id_preguntas_eval "+
								"AND pre.id_resultado_eval= re.id_resultado_eval "+
								"AND pe.tipo= 'COEV' "+
								"AND pe.asignacion ='HORAS' "+
								"AND re.nced LIKE  ? "+
								"AND re.id_pensum =? ORDER BY pe.orden";

					ps = con.prepareStatement(qry);
					ps.setString(1,  nced + "%");
					ps.setInt(2, idPensum);
					

					ResultSet rs = ps.executeQuery();

					ArrayList<CoEvaluacionResultadoDTO> listaCoEvDocente = new ArrayList<CoEvaluacionResultadoDTO>();
					Double ponderado= 0.0;
					while (rs.next()) {
						CoEvaluacionResultadoDTO dto = new CoEvaluacionResultadoDTO();
						
						dto.setDetalle(rs.getString(1));
						ponderado= rs.getDouble(2) * 16 + rs.getDouble(3) * 8;						
						dto.setValorHoras(ponderado);
						//dto.setValorDedicacion((ponderado *100) /960);
						
						listaCoEvDocente.add(dto);						
					}

					ps.close();
					con.close();

					return listaCoEvDocente;				

			} catch (SQLException e) {
				e.printStackTrace();			
				return null;
			} finally {
				ps.close();
				con.close();
			}
		}
		
	}
