package ec.edu.epn.atencionmedica.entities;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;

import ec.edu.epn.atencionmedica.util.util;


public class Reporte2 extends util implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7942000630493475461L;
	
	
	private int contador;
	private String var1;
	private String var2;
	private String var3;
	private String var4;
	private String var5;
	
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	public String getVar2() {
		return var2;
	}
	public void setVar2(String var2) {
		this.var2 = var2;
	}
	public String getVar3() {
		return var3;
	}
	public void setVar3(String var3) {
		this.var3 = var3;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public String getVar4() {
		return var4;
	}
	public void setVar4(String var4) {
		this.var4 = var4;
	}
	public String getVar5() {
		return var5;
	}
	public void setVar5(String var5) {
		this.var5 = var5;
	}
	
	public Reporte2 (){
	}
	

	// Constructor por defecto para la mayoría de reportes que no tienen tipos de dato Date
	public Reporte2 (int contador
			, String aux11, String aux12, String aux13, String aux14, String aux15
			, String aux21, String aux22, String aux23, String aux24, String aux25
			, String aux31, String aux32, String aux33, String aux34, String aux35
			, String aux41, String aux42, String aux43, String aux44, String aux45
			, String aux51, String aux52, String aux53, String aux54, String aux55) {
		
		
		this.contador = contador;
		this.var1 = (aux11.trim() + " "+ aux12.trim() + " "+ aux13.trim() + " "+ aux14.trim() + " "+ aux15.trim() ).trim().toUpperCase();
		this.var2 = (aux21.trim() + " "+ aux22.trim() + " "+ aux23.trim() + " "+ aux24.trim() + " "+ aux25.trim() ).trim().toUpperCase();
		this.var3 = (aux31.trim() + " "+ aux32.trim() + " "+ aux33.trim() + " "+ aux34.trim() + " "+ aux35.trim() ).trim().toUpperCase();
		this.var4 = (aux41.trim() + " "+ aux42.trim() + " "+ aux43.trim() + " "+ aux44.trim() + " "+ aux45.trim() ).trim().toUpperCase();
		this.var5 = (aux51.trim() + " "+ aux52.trim() + " "+ aux53.trim() + " "+ aux54.trim() + " "+ aux55.trim() ).trim().toUpperCase();
	}
	
	// Constructor sirve para los reportes de tipo Listas
	public Reporte2 (int contador1, int contador2
			, String aux11, String aux12, String aux13, String aux14, String aux15
			, String aux21, String aux22, String aux23, String aux24, String aux25
			, int aux31, int aux32, String aux33, String aux34, String aux35
			, int aux41, int aux42, String aux43, String aux44, String aux45
			, int aux51, int aux52, String aux53, String aux54, String aux55) {
		
		
		this.contador = (contador1 + contador2) ;
		this.var1 = (aux11.trim() + " "+ aux12.trim() + " "+ aux13.trim() + " "+ aux14.trim() + " "+ aux15.trim() ).trim().toUpperCase();
		this.var2 = (aux21.trim() + " "+ aux22.trim() + " "+ aux23.trim() + " "+ aux24.trim() + " "+ aux25.trim() ).trim().toUpperCase();
		this.var3 = ((aux31 + aux32) + " "+ aux33.trim() + " "+ aux34.trim() + " "+ aux35.trim() ).trim().toUpperCase();
		this.var4 = ((aux41 + aux42) + " "+ aux43.trim() + " "+ aux44.trim() + " "+ aux45.trim() ).trim().toUpperCase();
		this.var5 = ((aux51 + aux52) + " "+ aux53.trim() + " "+ aux54.trim() + " "+ aux55.trim() ).trim().toUpperCase();
	}

	// Constructor para reportes con Fechas
	public Reporte2 ( int contador, String operacion
			, String aux11, String aux12, String aux13, String aux14, String aux15
			, Date aux21, Date aux22, String aux23, String aux24, String aux25
			, String aux31, String aux32, String aux33, String aux34, String aux35
			, String aux41, String aux42, String aux43, String aux44, String aux45
			, String aux51, String aux52, String aux53, String aux54, String aux55) {
		

		Calendar cal=Calendar.getInstance();	//Date to Calendar
		
		switch (operacion) {
		case "año":
			cal.setTime(aux21);
			this.contador = contador ;
			this.var1 = (aux11.trim() + " "+ aux12.trim() + " "+ aux13.trim() + " "+ aux14.trim() + " "+ aux15.trim() ).trim().toUpperCase();
			this.var2 = cal.get(Calendar.YEAR) + "";
			this.var3 = (aux31.trim() + " "+ aux32.trim() + " "+ aux33.trim() + " "+ aux34.trim() + " "+ aux35.trim() ).trim().toUpperCase();
			this.var4 = (aux41.trim() + " "+ aux42.trim() + " "+ aux43.trim() + " "+ aux44.trim() + " "+ aux45.trim() ).trim().toUpperCase();
			this.var5 = (aux51.trim() + " "+ aux52.trim() + " "+ aux53.trim() + " "+ aux54.trim() + " "+ aux55.trim() ).trim().toUpperCase();
			break;
		case "mes":
			cal.setTime(aux21);
			int mes=cal.get(Calendar.MONTH) + 1; //Mes de la atención médica.
			
			
			if (mes == 1) this.var2 = "01";
			else if (mes == 2) this.var2 = "02";
			else if (mes == 3) this.var2 = "03";
			else if (mes == 4) this.var2 = "04";
			else if (mes == 5) this.var2 = "05";
			else if (mes == 6) this.var2 = "06";
			else if (mes == 7) this.var2 = "07";
			else if (mes == 8) this.var2 = "08";
			else if (mes == 9) this.var2 = "09";
			else if (mes == 10) this.var2 = "10";
			else if (mes == 11) this.var2 = "11";
			else if (mes == 12) this.var2 = "12";
			else this.var2 = "OTRO: " + mes;

			this.contador = contador ;
			this.var1 = (aux11.trim() + " "+ aux12.trim() + " "+ aux13.trim() + " "+ aux14.trim() + " "+ aux15.trim() ).trim().toUpperCase();
			
			this.var3 = (aux31.trim() + " "+ aux32.trim() + " "+ aux33.trim() + " "+ aux34.trim() + " "+ aux35.trim() ).trim().toUpperCase();
			this.var4 = (aux41.trim() + " "+ aux42.trim() + " "+ aux43.trim() + " "+ aux44.trim() + " "+ aux45.trim() ).trim().toUpperCase();
			this.var5 = (aux51.trim() + " "+ aux52.trim() + " "+ aux53.trim() + " "+ aux54.trim() + " "+ aux55.trim() ).trim().toUpperCase();
			break;
		case "edad":
			cal=Calendar.getInstance();		
			cal.setTime(aux22);
			
			int edad = Integer.parseInt(calcularEdadSoloAnio(cal, aux21));
			
			if (edad <= 10) this.var2 = "10-";
			else if (edad > 10 && edad <= 15 ) this.var2 = "11-15";
			else if (edad > 15 && edad <= 18 ) this.var2 = "16-18";
			else if (edad > 18 && edad <= 23 ) this.var2 = "19-23";
			else if (edad > 23 && edad <= 29 ) this.var2 = "24-29";
			else if (edad > 29 && edad <= 40 ) this.var2 = "30-40";
			else if (edad > 40 && edad <= 55 ) this.var2 = "41-55";
			else if (edad > 55 && edad <= 70 ) this.var2 = "56-70";
			else if (edad >= 71 ) this.var2 = "71+";
			else this.var2 = edad + "";

			this.contador = contador;
			this.var1 = (aux11.trim() + " "+ aux12.trim() + " "+ aux13.trim() + " "+ aux14.trim() + " "+ aux15.trim() ).trim().toUpperCase();
			
			this.var3 = (aux31.trim() + " "+ aux32.trim() + " "+ aux33.trim() + " "+ aux34.trim() + " "+ aux35.trim() ).trim().toUpperCase();
			this.var4 = (aux41.trim() + " "+ aux42.trim() + " "+ aux43.trim() + " "+ aux44.trim() + " "+ aux45.trim() ).trim().toUpperCase();
			this.var5 = (aux51.trim() + " "+ aux52.trim() + " "+ aux53.trim() + " "+ aux54.trim() + " "+ aux55.trim() ).trim().toUpperCase();
			break;
		default:
			break;
		}
	}
	

}
