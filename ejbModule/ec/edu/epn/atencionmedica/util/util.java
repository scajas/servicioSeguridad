package ec.edu.epn.atencionmedica.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class util {
	
	public DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
	public DateFormat format3=new SimpleDateFormat("HH:mm:ss");
	public DateFormat format4=new SimpleDateFormat("dd/MM/yyyy");
	
	
	/**
	 * Función que elimina acentos y caracteres especiales de
	 * una cadena de texto.
	 * @param input
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public String removerTildesYcaracteres(String input) {
	    // Cadena de caracteres original a sustituir.
	    String original = "áàäâªÁÀÂÄéèëêÉÈÊËíìïîÍÌÏÎóòöôÓÒÖÔúùüûÚÙÛÜnNçÇ\\¨º-~#@|!,·$%&/()?¡¿[^`]+}{¨´>< ;,:.";
	    // Cadena de caracteres ASCII que reemplazarï¿½n los originales.
	    String    ascii = "aaaaaAAAAeeeeEEEEiiiiIIIIooooOOOOuuuuUUUUnNcC                                     ";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	       
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	    return output;
	}
	
	public String calcularEdad4(Calendar fechaNac){
		StringBuffer edad = new StringBuffer("");
		Calendar today = new GregorianCalendar();
		Date currentDate = new Date(); // current date
		today.setTime(currentDate);
		
		int ae=0;
		int me=0;
		int de=0;
		
		int aa=today.get(Calendar.YEAR);
		int ma=today.get(Calendar.MONTH)+1;
		int da=today.get(Calendar.DATE);
		
		int an=fechaNac.get(Calendar.YEAR);
		int mn=fechaNac.get(Calendar.MONTH)+1;
		int dn=fechaNac.get(Calendar.DATE);
		
		int md=0;
		int cm= 0;
		boolean esBisiesto = true;
		
		Calendar c = Calendar.getInstance();
		c.set(an, mn, dn);
	
		cm=c.get(c.MONTH-1);
		
		//Es bisiesto
		if(aa%4 !=0)
			esBisiesto=false;
		
		//Máximo días mes
		if(cm%2 == 0 && cm!=2 )
			md=30;
		else if(cm==2 && esBisiesto)
			md=29;
		else if(cm==2 && !esBisiesto)
			md=28;
		else
			md=31;
			

		if(ma>mn){
			ae=aa-an;
			me=ma-mn;
			de=da-dn;
		}else if (ma==mn && da>=dn){
			ae=aa-an;
			me=ma;//-mn;
			de=da-dn;
		
		}else if (ma==mn && da<dn){
			ae=aa-an-1;
			me=ma;//-mn-1;
			de=da+(md-dn);
		}
		else if(ma<mn && da>=dn ){
			ae=aa-an-1;
			me=12-(mn-ma);
			de=da-dn;
		}else if(ma<mn && da<dn){
			ae=aa-an-1;
			me=12-(mn-ma)-1;
			de=da+(md-dn);
		}

		if (ae==1){
			edad.append(ae + " año ");
		}
		else if (ae>1){
			edad.append(ae + " años ");
		}
		if (me==1){
			edad.append(me + " mes ");
		}
		else if (me>1){
			edad.append(me + " meses ");
		}
		if (de==1){
			edad.append(de + " dia ");
		}
		else if (de>1){
			edad.append(de + " días ");
		}
		
		return edad.toString();
		//Thks Grace M. 31-03-2015
	}
	
	public String calcularEdadSoloAnio(Calendar fechaNac, Date fechaReferencia){
		StringBuffer edad = new StringBuffer("");
		Calendar today = new GregorianCalendar();
		Date currentDate = null == fechaReferencia ? new Date() : fechaReferencia; // current date
		today.setTime(currentDate);
		
		int ae=0;
		int me=0;
		int de=0;
		
		int aa=today.get(Calendar.YEAR);
		int ma=today.get(Calendar.MONTH)+1;
		int da=today.get(Calendar.DATE);
		
		int an=fechaNac.get(Calendar.YEAR);
		int mn=fechaNac.get(Calendar.MONTH)+1;
		int dn=fechaNac.get(Calendar.DATE);
		
		int md=0;
		int cm= 0;
		boolean esBisiesto = true;
		
		Calendar c = Calendar.getInstance();
		c.set(an, mn, dn);
	
		cm=c.get(c.MONTH-1);
		
		//Es bisiesto
		if(aa%4 !=0)
			esBisiesto=false;
		
		//Máximo días mes
		if(cm%2 == 0 && cm!=2 )
			md=30;
		else if(cm==2 && esBisiesto)
			md=29;
		else if(cm==2 && !esBisiesto)
			md=28;
		else
			md=31;
			

		if(ma>mn){
			ae=aa-an;
			me=ma-mn;
			de=da-dn;
		}else if (ma==mn && da>=dn){
			ae=aa-an;
			me=ma-mn;
			de=da-dn;
		
		}else if (ma==mn && da<dn){
			ae=aa-an-1;
			me=ma-mn-1;
			de=da+(md-dn);
		}
		else if(ma<mn && da>=dn ){
			ae=aa-an-1;
			me=12-(mn-ma);
			de=da-dn;
		}else if(ma<mn && da<dn){
			ae=aa-an-1;
			me=12-(mn-ma)-1;
			de=da+(md-dn);
		}

		if (ae==1){
			edad.append(ae + " año ");
		}
		else if (ae>1){
			edad.append(ae + " años ");
		}
		if (me==1){
			edad.append(me + " mes ");
		}
		else if (me>1){
			edad.append(me + " meses ");
		}
		if (de==1){
			edad.append(de + " dia ");
		}
		else if (de>1){
			edad.append(de + " días ");
		}
		
		return ae +"";
		//Thks Grace M. 31-03-2015
	}
	
	
	
}
