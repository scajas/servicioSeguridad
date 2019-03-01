package ec.edu.epn.atencionmedica.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReporteMetaData extends util implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String fechaCorte;
	private String fechaInicio;

	private Date fechaCorteD;
	private Date fechaInicioD;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 2014/08/06
	DateFormat dateFormatS = new SimpleDateFormat("yyyy-MM-dd"); // 2014-08-06
	
//	DateFormat dateFormats = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 2014/08/06
//	// 15:59:48
//	dateFormats.format(fechaCorteD);
	

	private boolean flagMostrarReporte = false;
	private boolean flagReporteExportado = false;

	private String nombreReporte;
	private String nombreReporteFile;
	private String codigoReporte;
	private String plantillaReporte;
	
	//Tipos de plantillas existentes
	private static final String REPORTE_VERTICAL_VAR1L_VAR2M = "reporte1Va"; //L:Large M:Medium S:Small
	private static final String REPORTE_VERTICAL_VAR1L_VAR2S = "reporte1Vb";
	private static final String REPORTE_VERTICAL_VAR1M_VAR2S = "reporte1Vc";
	private static final String REPORTE_VERTICAL_VAR1M_VAR2M = "reporte1Vd";
	
	private static final String REPORTE_HORIZONTAL_VAR1L_VAR2M = "reporte1Ha"; //TODO no implementado
	private static final String REPORTE_HORIZONTAL_VAR1L_VAR2S = "reporte1Hb";
	private static final String REPORTE_HORIZONTAL_VAR1M_VAR2S = "reporte1Hc"; 
	private static final String REPORTE_HORIZONTAl_VAR1M_VAR2M = "reporte1Hd"; //TODO no implementado 
	
	private static final String REPORTE_LISTA_COL1L_COL2M = "reporte2LVa";
	private static final String REPORTE_LISTA_COL1L_COL2s = "reporte1Lb"; //TODO no implementado
	private static final String REPORTE_LISTA_COL1M_COL2s = "reporte1Lc"; //TODO no implementado
	
	public void setOrientacion(String codigoReporte, int columnas){
		switch (codigoReporte){
		case "11":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2M);
			break;
		case "10":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2M);
			break;
		case "12":
			if (columnas>10) //CUANDO HAY MUCHAS COLUMNAS PASA A SER UN REPORTE HORIZONTAL
				setPlantillaReporte(REPORTE_HORIZONTAL_VAR1L_VAR2S);
			else
				setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		case "3":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2M);
			break;
		case "4":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2S);
			break;
		case "5":
			if (columnas>10) //CUANDO HAY MUCHAS COLUMNAS PASA A SER UN REPORTE HORIZONTAL
				setPlantillaReporte(REPORTE_HORIZONTAL_VAR1M_VAR2S);
			else
				setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2S);
			break;
		case "6":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2M);
			break;
		case "7":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2M);
			break;
		case "15":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2M);
			break;
		case "16":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2M);
			break;
		case "50":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2M);
			break;
		case "51":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1M_VAR2M);
			break;
		case "17":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		case "18":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		case "20":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		case "21":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		case "22":
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		case "27":
			setPlantillaReporte(REPORTE_LISTA_COL1L_COL2M);
			break;
		case "28":
			setPlantillaReporte(REPORTE_LISTA_COL1L_COL2M);
			break;
		case "29":
			setPlantillaReporte(REPORTE_LISTA_COL1L_COL2M);
			break;
		case "30":
			setPlantillaReporte(REPORTE_LISTA_COL1L_COL2M);
			break;
		default:
			setPlantillaReporte(REPORTE_VERTICAL_VAR1L_VAR2S);
			break;
		}
	}
	
	public ReporteMetaData(Date fechaCorteD, Date fechaInicioD){
		try {

			if (fechaInicioD != null){
				this.fechaInicioD = fechaInicioD;
				this.fechaCorteD = fechaCorteD;
			}else{
				throw new Exception("Error en el formato de fecha") ;
			}
			
		} catch (Exception e) {
			System.out.println("Fechas en formato incorrecto");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			this.fechaCorteD = calendar.getTime();
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
			this.fechaInicioD = calendar.getTime();
		}
		this.fechaInicio = dateFormatS.format(this.fechaInicioD);
		this.fechaCorte = dateFormatS.format(this.fechaCorteD);
		System.out.println("Fechas del sistema establecidas");
		
	}
	
	public String getFechaCorte() {
		return fechaCorte;
	}
	public void setFechaCorte(String fechaCorte) {
		this.fechaCorte = fechaCorte;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaCorteD() {
		return fechaCorteD;
	}
	public void setFechaCorteD(Date fechaCorteD) {
		this.fechaCorteD = fechaCorteD;
		this.fechaCorte = dateFormatS.format(this.fechaCorteD);
	}
	public Date getFechaInicioD() {
		return fechaInicioD;
	}
	public void setFechaInicioD(Date fechaInicioD) {
		this.fechaInicioD = fechaInicioD;
		this.fechaInicio = dateFormatS.format(this.fechaInicioD);
	}

	public boolean isFlagMostrarReporte() {
		return flagMostrarReporte;
	}

	public void setFlagMostrarReporte(boolean flagMostrarReporte) {
		this.flagMostrarReporte = flagMostrarReporte;
	}

	public boolean isFlagReporteExportado() {
		return flagReporteExportado;
	}

	public void setFlagReporteExportado(boolean flagReporteExportado) {
		this.flagReporteExportado = flagReporteExportado;
	}

	public String getNombreReporte() {
		return nombreReporte;
	}

	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	public String getNombreReporteFile() {
		return nombreReporteFile;
	}

	public void setNombreReporteFile(String nombreReporteFile) {
		this.nombreReporteFile = nombreReporteFile;
	}

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	public String getPlantillaReporte() {
		return plantillaReporte;
	}

	public void setPlantillaReporte(String plantillaReporte) {
		this.plantillaReporte = plantillaReporte;
	}
}
