package ec.edu.epn.atencionmedica.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.edu.epn.atencionmedica.dto.CertificadoMedicoDto;
import ec.edu.epn.atencionmedica.entities.Reporte2;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ConsultaReportesServiceBean
 */
@Stateless(mappedName = "ConsultaReportes") 
public class ConsultaReportesDAOImplement extends DaoGenericoImplement<Reporte2> implements ConsultaReportesDAO{

	private static final String TIPO_QUERY_NATIVE = "NATIVE";
	private static final String TIPO_QUERY_TYPED = "TYPED";
	private static final String TIPO_QUERY_NAMED = "NAMED";
	private static final String TIPO_QUERY_CON_RANGO = "TIPO_QUERY_CON_RANGO";
	private static final String TIPO_QUERY_SIN_RANGO = "TIPO_QUERY_SIN_RANGO";
	
	@Override
	public List<Reporte2> obtenerData(int reporte, Date fechaInicio, Date fechaCorteA) {
		
		List<Reporte2> dataSource = new ArrayList<Reporte2>();
		StringBuffer q = new StringBuffer("");
		String tipoQuery = "";
		String rangoQuery = "";
		String rangoNombreQuery = "";
		DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format3=new SimpleDateFormat("HH:mm:ss");
		DateFormat format4=new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaCorte;
		
		try {
			fechaCorte = format1.parse( format2.format(fechaCorteA) + " " + "23:59:59" );
			fechaInicio =  format1.parse( format2.format(fechaInicio) + " " + "00:00:00" );
		} catch (ParseException e1) {
			fechaCorte = new Date();
		}
		
//		 Coonstrucción del query
		switch (reporte) {
		
			// PACIENTES ATENDIDOS ( 5 ) - RANGO FECHA
			case 3://QUERY 3 --- SEGUN MEDICO POR TIPO DE PACIENTE
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 "); //CONTADOR				
				q.append(" , per.apellido1Prs || ' ' || COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , ' - ' "); q.append(" , ce.descripcionCat "); q.append(" , '' "); 	//var1
				q.append(" , cp.descripcionCat "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
				q.append(" ) ");
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" from Atencionmedica as a, Paciente as p, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				break;
				
			case 4: //------> SEGÙN MEDICO POR MESES
				
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 , 'mes' "); //CONTADOR
				q.append(" , per.apellido1Prs || ' ' || COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , ' - ' "); q.append(" , ce.descripcionCat "); q.append(" , '' "); 	//var1				
				q.append(" , a.fechahoraAtm "); q.append(" , a.fechahoraAtm "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
				q.append(" ) "); 
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" from Atencionmedica as a, Paciente as p, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				
				break;
			case 44: 
				
					 //------------------------------------------------------------------------------------------------------------->
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var1
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
					 //------------------------------------------------------------------------------------------------------------->
				
				break;
			case 5: //------> SEGÙN MEDICO POR AÑOS
				
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 , 'año' "); //CONTADOR
				q.append(" , per.apellido1Prs || ' ' || COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , ' - ' "); q.append(" , ce.descripcionCat "); q.append(" , '' "); 	//var1
				q.append(" , a.fechahoraAtm "); q.append(" , a.fechahoraAtm "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
				q.append(" ) "); 
				q.append(" from Atencionmedica as a, Paciente as p,  Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t*/, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;

				break;
			case 6: //------> SEGÚN MÉDICO POR ESPECIALIDAD*	
				
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 "); //CONTADOR
				q.append(" , per.apellido1Prs || ' ' || COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var1
				q.append(" , ce.descripcionCat "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
				q.append(" ) "); 
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" from Atencionmedica as a, Paciente as p, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				break;
			case 7: //------> SEGÚN MÉDICO POR TIPO DE ATENCIÓN MÉDICA*
				
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 "); //CONTADOR
				q.append(" , per.apellido1Prs || ' ' || COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , ' - ' "); q.append(" , ce.descripcionCat "); q.append(" , '' "); 	//var1
				q.append(" , ca.descripcionCat "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
				q.append(" ) "); 
				q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce, Catalogo as ca ");
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce, Catalogo as ca ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				q.append(" and ca.idCatalogo = a.catalogo.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				break;
			// CASOS ATENDIDOS ( 3 ) - RANGO FECHA
			case 10: //------> SEGÚN DIAGNÓSTICO POR SEXO
				//QUERY 10
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 "); //CONTADOR
				//q.append(" , tp.codigoTop "); q.append(" , tp.nombreTop "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var1
				q.append(" , a.topografiacie.codigoTop "); q.append(" , a.topografiacie.nombreTop "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var1
				q.append(" , p.sexoPac "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , ce.descripcionCat "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , per.apellido1Prs "); q.append(" , COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var5
				q.append(" ) "); 
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" from Atencionmedica as a, Paciente as p,  Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				break;
			case 11: //------> SEGÚN DIAGNÓSTICO POR TIPO DE PACIENTE
				//QUERY 11
				q.append("SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2(1 "); //CONTADOR
				//q.append(" , tp.codigoTop "); q.append(" , ' - ' ");	 q.append(" , tp.nombreTop "); q.append(" , '' "); q.append(" , '' "); //var1
				q.append(" , a.topografiacie.codigoTop "); q.append(" , ' - ' ");	 q.append(" , a.topografiacie.nombreTop "); q.append(" , '' "); q.append(" , '' "); //var1
				q.append(" , cp.descripcionCat "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var2
				q.append(" , ce.descripcionCat "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var3
				q.append(" , per.apellido1Prs "); q.append(" , COALESCE(per.nombre1Prs,'') "); q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 	//var4
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) ");
				q.append(" from Atencionmedica as a, Paciente as p, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				//q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as tp, Topografiacie as t, Catalogo as cp, PersonalAtencion as per, Catalogo as ce ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				q.append(" and per.catalogo2.idCatalogo = ce.idCatalogo ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				break;
			case 12: //------> SEGÚN DIAGNÓSTICO POR EDADES
				
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 1 , 'edad' "); //CONTADOR
				//q.append(" , tp.codigoTop "); q.append(" , ' - ' ");	 q.append(" , tp.nombreTop "); q.append(" , '' "); q.append(" , '' "); //var1
				q.append(" , a.topografiacie.codigoTop "); q.append(" , ' - ' ");	 q.append(" , a.topografiaci.nombreTop "); q.append(" , '' "); q.append(" , '' "); //var1
				q.append(" , a.fechahoraAtm "); q.append(" , p.fechanacPac ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from "); 
				q.append("    Atencionmedica as a, "); 
				q.append("    Paciente as p,  ");
				//q.append("    Topografiacie as tp,  ");
				//q.append("    Topografiacie as t,   ");
				q.append("    Catalogo as cp,   ");
				q.append("    PersonalAtencion as per  ");
				q.append(" where a.paciente.idPaciente = p.idPaciente ");
				q.append(" and cp.idCatalogo = p.catalogo.idCatalogo ");
				//q.append(" and a.topografiacie.idTopografia = t.idTopografia ");
				//q.append(" and tp.idTopografia = t.topografiacie.idTopografia");
				q.append(" and a.personal.idPersonal = per.idPersonal ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_CON_RANGO;
				break;
			// MOVIMIENTOS DE INVENTARIO ( 2 ) - RANGO FECHA
			case 15: //------> SEGUN MEDICAMENTO POR INGRESO (Movimientos)
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 1 "); // d.cantidadDet "); //CONTADOR
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , cm.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from "); 
				q.append("    Movimientoinventario m, "); 
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as cm,   ");
				q.append("    Detallemovimiento d ");
				q.append(" where m.catalogotipomovinventario.idCatalogo = cm.idCatalogo ");
				q.append(" and cm.operacionCat = 'INGRESO' ");
				q.append(" and i.idInsumomed = d.insumomedico.idInsumomed ");
				q.append(" and m.idMovimientoinv = d.movimientoinventario.idMovimientoinv ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				rangoNombreQuery = "m.fechahoraMov";
				
				 
				break;
			case 16: //------> SEGUN MEDICAMENTO POR EGRESO
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 1 "); // d.cantidadDet "); //CONTADOR
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , cm.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from "); 
				q.append("    Movimientoinventario m, "); 
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as cm,   ");
				q.append("    Detallemovimiento d ");
				q.append(" where m.catalogotipomovinventario.idCatalogo = cm.idCatalogo ");
				q.append(" and cm.operacionCat = 'EGRESO' ");
				q.append(" and i.idInsumomed = d.insumomedico.idInsumomed ");
				q.append(" and m.idMovimientoinv = d.movimientoinventario.idMovimientoinv ");
				q.append(" and m.catalogotipoestadomov.idCatalogo = 28 ");
				
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				rangoNombreQuery = "m.fechahoraMov";

				break;
			case 50: //------> Según insumos médicos por ingreso (Insumos méd.)
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( d.cantidadDet "); //CONTADOR
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , cm.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from "); 
				q.append("    Movimientoinventario m, "); 
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as cm,   ");
				q.append("    Detallemovimiento d ");
				q.append(" where m.catalogotipomovinventario.idCatalogo = cm.idCatalogo ");
				q.append(" and cm.operacionCat = 'INGRESO' ");
				q.append(" and i.idInsumomed = d.insumomedico.idInsumomed ");
				q.append(" and m.idMovimientoinv = d.movimientoinventario.idMovimientoinv ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				rangoNombreQuery = "m.fechahoraMov";
				
				break;
			case 51: //------> Según insumos médicos por egreso (Insumos méd.)
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( d.cantidadDet "); //CONTADOR
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , cm.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , '' "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from "); 
				q.append("    Movimientoinventario m, "); 
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as cm,   ");
				q.append("    Detallemovimiento d ");
				q.append(" where m.catalogotipomovinventario.idCatalogo = cm.idCatalogo ");
				q.append(" and cm.operacionCat = 'EGRESO' ");
				q.append(" and i.idInsumomed = d.insumomedico.idInsumomed ");
				q.append(" and m.idMovimientoinv = d.movimientoinventario.idMovimientoinv ");
				q.append(" and m.catalogotipoestadomov.idCatalogo = 28 ");
				
				//q.append(" and a.fechahoraAtm between :fechaInicio and :fechaCorte ");
				
				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				rangoNombreQuery = "m.fechahoraMov";
				
				break;
			// DESPACHOS DE MEDICACIÒN ( 5 ) - RANGO FECHA *
			case 17: //------> ENTREGADOS SEGUN MEDICAMENTO POR TIPO DE PACIENTE

				break;
			case 18: //------> SUMINISTRADOS SEGUN MEDICAMENTO POR TIPO DE PACIENTE

				break;
			case 20: //------> SEGÚN DESPACHO POR TIPO DE PACIENTE

				break;
			case 21: //------> SEGÚN ESPECIALIDAD POR TIPO DE PACIENTE

				break;
			case 22: //------> SEGÚN TIPO DE ATENCIÓN POR TIPO DE PACIENTE

				break;
			//MEDICAMENTOS ( 4 )
			case 25: //------> SEGÚN TIPO DE PRESENTACIÓN * 

				break;
			case 26: //------> SEGÚN TIPO DE MEDICAMENTO *

				break;
			case 27: //------> Todo (agrupado por tipo de presentación)
				
			
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 0, 0 "); //CONTADOR1, CONTADOR2 
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , c.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , i.cantidadactualIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , i.cantidadreordenIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , 0 "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from ");  
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as c,   ");
				q.append("    Catalogo as ct   ");
				q.append(" where i.catalogoTipoPresentacion.idCatalogo = c.idCatalogo ");
				q.append(" and ct.idCatalogo = i.catalogo.idCatalogo ");
				

				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				
				break;
			case 28: //------> Todo (agrupado por tipo de insumo médico)


				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 0, 0 "); //CONTADOR1, CONTADOR2 
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , ct.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , i.cantidadactualIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , i.cantidadreordenIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , 0 "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from ");  
				q.append("    Insumomedico as i,  ");
				//q.append("    Catalogo as c,   ");
				q.append("    Catalogo as ct   ");
				q.append(" where i.catalogoTipoPresentacion.idCatalogo = ct.idCatalogo ");
				//q.append(" and ct.idCatalogo = i.catalogo.idCatalogo ");
				

				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				
				break;
			case 29: //------> Bajo saldo de re-orden (agrupado por tipo de presentación)
				
				
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 0, 0 "); //CONTADOR1, CONTADOR2 
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , c.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , i.cantidadactualIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , i.cantidadreordenIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , 0 "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from ");  
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as c,   ");
				q.append("    Catalogo as ct   ");
				q.append(" where i.catalogoTipoPresentacion.idCatalogo = c.idCatalogo ");
				q.append(" and ct.idCatalogo = i.catalogo.idCatalogo ");
				q.append(" and i.cantidadactualIsm < i.cantidadreordenIsm ");
				

				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				
				break;
			case 30: //------> Bajo saldo de re-orden (agrupado por tipo de insumo médico)

				
				q.append(" SELECT NEW ec.edu.epn.atencionmedica.entities.Reporte2( 0, 0 "); //CONTADOR1, CONTADOR2 
				q.append(" , i.nombreIsm "); q.append(" , i.formafarmaceuticaIsm ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); 
				q.append(" , ct.descripcionCat "); q.append(" , '' ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var2
				q.append(" , i.cantidadactualIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var3
				q.append(" , i.cantidadreordenIsm "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var4
				q.append(" , 0 "); q.append(" , 0 ");	 q.append(" , '' "); q.append(" , '' "); q.append(" , '' "); //var5
				q.append(" ) "); 
				q.append("  from ");  
				q.append("    Insumomedico as i,  ");
				q.append("    Catalogo as c,   ");
				q.append("    Catalogo as ct   ");
				q.append(" where i.catalogoTipoPresentacion.idCatalogo = c.idCatalogo ");
				q.append(" and ct.idCatalogo = i.catalogo.idCatalogo ");
				q.append(" and i.cantidadactualIsm < i.cantidadreordenIsm ");
				

				tipoQuery = TIPO_QUERY_TYPED;
				rangoQuery = TIPO_QUERY_SIN_RANGO;
				break;
			//LISTAS*
			case 32: //------> INSUMOS MÉDICOS

				break;
			case 33: //------> PERSONAL MÉDICO
				
				break;
			case 34: //------> TIPOS DE INSUMO MÉDICO
				
				break;
			case 35: //------> TIPOS DE PRESENTACIÓN DE I.M.
				
				break;
			case 36: //------> TIPOS DE PACIENTES
				
				break;
			case 37: //------> TIPOS DE ATENCIÓN MÉDICA
				
				break;
			case 38: //------> PACIENTES
				
				break;
			case 39: //------> TIPOS DE MOVIMIENTOS DE INVENTARIO
				
				break;
				
			case 40: //------> TIPOS DE ESPECIALIDADES
				
				break;
			default:
				break;
		}
		
		try {
			
			if (tipoQuery.equals(TIPO_QUERY_TYPED)){
				
				TypedQuery<Reporte2> query = null;
				
				if (rangoQuery.equals(TIPO_QUERY_CON_RANGO)){
					q.append(" and a.fechahoraAtm between :fechaInicio and :fechaCorte ");
					query = getEntityManager().createQuery(q.toString(), Reporte2.class);
					query.setParameter("fechaInicio", fechaInicio);
					query.setParameter("fechaCorte", fechaCorte);
//					query.setParameter("fechaInicio", format1.format(fechaInicio));
//					query.setParameter("fechaCorte", format1.format(fechaCorte));
				}
				else{
					if (!rangoNombreQuery.equals(""))
					{
						q.append(" and " + rangoNombreQuery + " between :fechaInicio and :fechaCorte ");
						query = getEntityManager().createQuery(q.toString(), Reporte2.class);
						query.setParameter("fechaInicio", fechaInicio);
						query.setParameter("fechaCorte", fechaCorte);
					}
					else
					{
						query = getEntityManager().createQuery(q.toString(), Reporte2.class);
					}
				}
				dataSource = query.getResultList();
				
			}
			else if (tipoQuery.equals(TIPO_QUERY_NATIVE)){
				
				Query query = null; 
				
				if (rangoQuery.equals(TIPO_QUERY_CON_RANGO)){
					q.append(" and a.fechahoraAtm between :fechaInicio and :fechaCorte ");
					query = getEntityManager().createNativeQuery(q.toString());
					query.setParameter("fechaInicio", fechaInicio);
					query.setParameter("fechaCorte", fechaCorte);

				}
				else{
					if (!rangoNombreQuery.equals(""))
					{
						q.append(" and " + rangoNombreQuery + " between :fechaInicio and :fechaCorte ");
						query = getEntityManager().createQuery(q.toString(), Reporte2.class);
						query.setParameter("fechaInicio", fechaInicio);
						query.setParameter("fechaCorte", fechaCorte);
					}
					else
					{
						query = getEntityManager().createNativeQuery(q.toString());
					}
				}
				dataSource = query.getResultList();
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
			e.printStackTrace();
		}
		return dataSource;
	}

	@Override
	public List<CertificadoMedicoDto> obtenerDatosCertificadoMedico(Integer idAtencionMedica) {
		
		List<CertificadoMedicoDto> datos = new ArrayList<CertificadoMedicoDto>();
		StringBuffer q = new StringBuffer("");		
		TypedQuery<CertificadoMedicoDto> query = null;
		
		q.append(" SELECT NEW ec.edu.epn.atencionmedica.dto.CertificadoMedicoDto("); //CONTADOR1, CONTADOR2 
		q.append(" p.nombre1Pac ");q.append("|| ' ' ||");q.append("p.apellido1Pac");
		q.append(" , p.identificacionPac "); q.append(" , t.nombreTop "); q.append(" , t.codigoTop "); q.append(" , a.reposoAtm "); q.append(" , a.fechahorainicioAtm"); 	
		q.append(", per.apellido1Prs");q.append("|| ' ' ||");q.append(" per.nombre1Prs "); q.append(" , per.codigomspPrs "); q.append(" , per.identificacionPrs ");
		q.append(" )"); 
		q.append(" from Atencionmedica as a, Paciente as p, Topografiacie as t,PersonalAtencion as per ");
		q.append(" where a.paciente.idPaciente = p.idPaciente ");		
		q.append(" and a.topografiacie.idTopografia = t.idTopografia ");		
		q.append(" and a.personal.idPersonal = per.idPersonal ");		
		q.append(" and a.idAtencionmed = :idAtencionMedica");		
		query = getEntityManager().createQuery(q.toString(), CertificadoMedicoDto.class);		
		query.setParameter("idAtencionMedica", idAtencionMedica);
	
		datos =  query.getResultList();
		
		return datos;
	}

	@Override
	public List<CertificadoMedicoDto> obtenerDatosPedidoExamen(Integer idAtencionMedica) {
		List<CertificadoMedicoDto> datos = new ArrayList<CertificadoMedicoDto>();
		StringBuffer q = new StringBuffer("");		
		TypedQuery<CertificadoMedicoDto> query = null;
		
		q.append(" SELECT NEW ec.edu.epn.atencionmedica.dto.CertificadoMedicoDto("); //CONTADOR1, CONTADOR2 
		q.append(" p.identificacionPac "); q.append(" , p.numerohclPac ");
		q.append(" , p.apellido1Pac ");q.append("|| ' ' ||");q.append("p.apellido2Pac");
		q.append(" , p.nombre1Pac ");q.append("|| ' ' ||");q.append("p.nombre2Pac");
		q.append(" , a.fechahoraAtm"); q.append(" , esp.descripcionCat"); q.append(" , per.apellido1Prs");q.append("|| ' ' ||");q.append(" per.nombre1Prs "); 
		q.append(" , a.pedidosexamenesmedicosAtm ");q.append(" , a.examenesmedicosAtm ");
		q.append(" , per.codigomspPrs "); q.append(" , per.identificacionPrs ");
		q.append(" )"); 
		q.append(" from Atencionmedica as a, Paciente as p, Catalogo as esp,PersonalAtencion as per ");
		q.append(" where a.paciente.idPaciente = p.idPaciente ");					
		q.append(" and a.personal.idPersonal = per.idPersonal ");	
		q.append(" and esp.idCatalogo = per.catalogo2.idCatalogo ");
		q.append(" and a.idAtencionmed = :idAtencionMedica");		
		query = getEntityManager().createQuery(q.toString(), CertificadoMedicoDto.class);		
		query.setParameter("idAtencionMedica", idAtencionMedica);
	
		datos =  query.getResultList();
		
		return datos;
	}

	@Override
	public List<CertificadoMedicoDto> obtenerDatosPedidoEcografia(Integer idAtencionMedica) {
		List<CertificadoMedicoDto> datos = new ArrayList<CertificadoMedicoDto>();
		StringBuffer q = new StringBuffer("");		
		TypedQuery<CertificadoMedicoDto> query = null;
		
		q.append(" SELECT NEW ec.edu.epn.atencionmedica.dto.CertificadoMedicoDto("); //CONTADOR1, CONTADOR2 
		q.append(" p.identificacionPac "); q.append(" , p.numerohclPac ");
		q.append(" , p.apellido1Pac ");q.append("|| ' ' ||");q.append("p.apellido2Pac");
		q.append(" , p.nombre1Pac ");q.append("|| ' ' ||");q.append("p.nombre2Pac");
		q.append(" , a.fechahoraAtm"); q.append(" , esp.descripcionCat"); q.append(" , per.apellido1Prs");q.append("|| ' ' ||");q.append(" per.nombre1Prs "); 
		q.append(" , per.codigomspPrs ");q.append(" , a.motivoAtm ");q.append(" , t.codigoTop ");  
		q.append(" , a.examenfisicoAtm ");q.append(" , (SELECT codigoTop FROM Topografiacie WHERE idTopografia = a.idDiagDefinitivo) ");
		q.append(" , a.pedidosexamenesmedicosAtm ");q.append(" , a.examenesimagendescAtm ");
		q.append(" , t.nombreTop ");q.append(" , (SELECT nombreTop FROM Topografiacie WHERE idTopografia = a.idDiagDefinitivo) "); q.append(" , per.identificacionPrs ");
		q.append(" )"); 
		q.append(" from Atencionmedica as a, Paciente as p, Catalogo as esp,PersonalAtencion as per, Topografiacie as t ");
		q.append(" where a.paciente.idPaciente = p.idPaciente ");					
		q.append(" and a.personal.idPersonal = per.idPersonal ");	
		q.append(" and esp.idCatalogo = per.catalogo2.idCatalogo ");
		q.append(" and a.topografiacie.idTopografia = t.idTopografia ");		
		q.append(" and a.idAtencionmed = :idAtencionMedica");		
		query = getEntityManager().createQuery(q.toString(), CertificadoMedicoDto.class);		
		query.setParameter("idAtencionMedica", idAtencionMedica);
	
		datos =  query.getResultList();
		
		return datos;
	}
	
	

}
