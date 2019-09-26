package ec.edu.epn.conexion.SQLServer;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.gestionDocente.DTO.CargaAcademicaPreplanifDTO;
import ec.edu.epn.gestionDocente.DTO.CargaPlanificacionDTO;
import ec.edu.epn.gestionDocente.DTO.TesisDocenteDTO;

public class procedimientosAlmacenadosEval {

	private Pensum pensumVigente;

	public procedimientosAlmacenadosEval() {
	}

	public procedimientosAlmacenadosEval(Pensum pensumVigente) {
		try {
			this.pensumVigente = pensumVigente;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CargaPlanificacionDTO> obtenerCargaAcademicaPlanificacion(String cedula, String añoPensum,
			String numeroPensum) {
		java.sql.ResultSet result = null;
		try {
			conexionSQL sql = new conexionSQL();
			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontparalca (?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, cedula);
			cst.setString(3, "");
			cst.setString(4, "");

			cst.setString(5, añoPensum);
			cst.setString(6, numeroPensum);

			result = cst.executeQuery();
			List<CargaPlanificacionDTO> listaCargaPlanif = new ArrayList<CargaPlanificacionDTO>();
			while (result.next()) {
				CargaPlanificacionDTO carga = new CargaPlanificacionDTO();
				carga.setCodMateriaSAE(result.getString(1));
				carga.setNomMateriaSAE(result.getString(2));
				carga.setNomParaleloSAE(result.getString(3));
				carga.setHorasTotalSemanaSAE(Integer.parseInt(result.getString(4) == null ? "0" : result.getString(4)));
				carga.setHorasModuloSAE(Integer.parseInt(result.getString(5) == null ? "0" : result.getString(5)));
				carga.setNomCarreraSAE(result.getString(17));
				carga.setNumAlumnosSAE(Integer.parseInt(result.getString(19)));
				carga.setAula(result.getString(6));

				if (result.getString(20) == null || result.getString(20).equals("null")
						|| result.getString(20).equals("")) {
					carga.setCapacidadAlumnosSAE(0);
				} else {
					carga.setCapacidadAlumnosSAE(Integer.parseInt(result.getString(20)));
				}
				
				carga.setValHetero(0.0);
				
				/*SE AGREGA NUEVOS CAMPOS PARA EL CALCULO DE LAS HORAS SEMANA EN CARGA ACADÃ‰MICA PARA PLANIFICACIÃ“N DOCENTE 12-11-2018*/
				
				/*if(result.getString(21)!=null){
					carga.setRegimen(result.getString(21));
				}else {
					carga.setRegimen("H");
				}
				
				if(result.getString(22)!=null){
					carga.setNivel(result.getString(22));
				}else{
					carga.setRegimen("INGENIERIA");
				}*/
				
				listaCargaPlanif.add(carga);
			}
			result.close();
			sql.closeConnection();
			return listaCargaPlanif;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	/**********************************************************************
	 * DEVUELVE TODAS LAS ACTIVIDADES DE DOCENCIA DE TODOS LOS PERIODOS POR
	 * NUMERO DE CEDULA DEL DOCENTE Y NIVEL (POSGRADO, PREGRADO)
	 ****************************************/
	@SuppressWarnings("finally")
	public List<TesisDocenteDTO> spTesisProyectosXTipo(String nced, String tipo, String anio, String numero) {
		List<TesisDocenteDTO> listTesisDocente = new ArrayList<TesisDocenteDTO>();
		conexionSQL sql = new conexionSQL();
		try {
			java.sql.ResultSet result = null;

			sql.getConnection();
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saetesisprofdepar (?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// PARAMETROS
			cst.setString(1, "TM");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, nced);
			cst.setString(11, "");
			cst.setString(12, "");
			cst.setString(13, tipo);

			result = cst.executeQuery();
			while (result.next()) {
				
				TesisDocenteDTO tesis = new TesisDocenteDTO();
				if(anio.equals(result.getString(6)) && numero.equals(result.getString(7))){
				
					tesis.setNroTesis(result.getString(1));
					tesis.setTema(result.getString(2));
					tesis.setTipoTesis(result.getString(3));
					tesis.setEstudiante(result.getString(4));
					tesis.setFechaGradoOral(result.getString(5));
					tesis.setPeriodo(result.getString(6) + "-" + result.getString(7));
					tesis.setCarrera(result.getString(8));
					tesis.setFacultad(result.getString(10));
					listTesisDocente.add(tesis);
				}

			}

			sql.closeConnection();
		} catch (Exception e) {

			sql.closeConnection();

			listTesisDocente = new ArrayList<TesisDocenteDTO>();

		}

		finally {
			sql.closeConnection();
			return listTesisDocente;

		}

	}
	
	
	@SuppressWarnings("finally")
	public List<CargaAcademicaPreplanifDTO> listCargaMatPreplanif(){
		
		List<CargaAcademicaPreplanifDTO> listMaterias= new ArrayList<CargaAcademicaPreplanifDTO>();
		
		conexionSQL sql = new conexionSQL();
		Calendar cal= Calendar.getInstance();
		int year= cal.get(Calendar.YEAR);
		try {
			java.sql.ResultSet result = null;
			sql.getConnection();
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparal (?,?,?,?,?,?,?)}");
			
			

			// PARAMETROS
			cst.setString(1, "PR");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setInt(7, year);
			
			result = cst.executeQuery();
			while (result.next()) {
				CargaAcademicaPreplanifDTO dto= new CargaAcademicaPreplanifDTO("", "", 0, 0, "", "", "", "");
				dto.setCodMateria(result.getString(1));
				dto.setNomMateria(result.getString(2));
				dto.setNomMateriaComp(result.getString(3));
				dto.setHorasTotalSemana(result.getString(4).equals("")?0: ((int) result.getDouble(4)));
				dto.setHorasModulo(result.getString(5).equals("")?0: ((int) result.getDouble(5)));
				listMaterias.add(dto);				
				
			}
			
		} catch (Exception e) {

			sql.closeConnection();
			listMaterias = new ArrayList<CargaAcademicaPreplanifDTO>();
		}

		finally {
			sql.closeConnection();
			return listMaterias;

		}
		
	}
	

	/**
	 * @return the pensumVigente
	 */
	public Pensum getPensumVigente() {
		return pensumVigente;
	}

	/**
	 * @param pensumVigente the pensumVigente to set
	 */
	public void setPensumVigente(Pensum pensumVigente) {
		this.pensumVigente = pensumVigente;
	}	
	

}