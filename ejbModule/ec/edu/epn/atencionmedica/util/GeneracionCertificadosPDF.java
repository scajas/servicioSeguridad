package ec.edu.epn.atencionmedica.util;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Topografiacie;

public class GeneracionCertificadosPDF {
	
	
	
	
	
	private DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	private static final String LOCATE = "D:\\MedicoUtils\\";
	private static final String PLANTILLA_CERTIFICADO = "plantilla_certificado_medico.pdf";
	
	public String generarCertificadoMedico(Atencionmedica atencionmedica, Topografiacie topografiacie, String pathUlr){
		try {
			String fechaActual= formatoFecha.format(new Date());
			
			// DOCUMENTO TIPO A4
            Document document = new Document(PageSize.A4);
			
			String url= pathUlr + "/" + "certificado_medico_" + atencionmedica.getPaciente().getIdPaciente() + "-"
																					+ fechaActual + ".pdf";
			
			FileOutputStream outputStream = new FileOutputStream(new File(url));
			
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			
			 // SE ABRE EL ARCHIVO PARA CREAR
            document.open();
            // VARIABLE PARA OCUPAR OTRO PDF COMO PLANTILLA
            PdfContentByte cb = writer.getDirectContent();
            
            // CARGA DE LA PLANTILLA
            

            PdfReader reader = new PdfReader(LOCATE + PLANTILLA_CERTIFICADO);
            // GENERAMOS UNA PAGINA
            PdfImportedPage page = writer.getImportedPage(reader, 1);

            // PONEMOS LA PLANTILLA DENTRO DEL DOCUMENTO CREAR PARA TNENER LA PLANTILLA
            document.newPage();
            cb.addTemplate(page, 0, 0);
            
            
          
			
            
            // CREACION DE CONTENIDO CERTIFICADO
            PdfPTable datosFechaCertificado = new PdfPTable(1);
            datosFechaCertificado.setWidthPercentage(100);
            datosFechaCertificado.getDefaultCell().setBorder(0);
            
            datosFechaCertificado.addCell(this.createLabelCell2(
            		"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
					"Quito " + fechaActual +
					"\n\n\n\n\n\n\n"));
            
            
            document.add(datosFechaCertificado);
            
            
            // CREACION DE CONTENIDO CERTIFICADO
            PdfPTable datosTituloCertificado = new PdfPTable(1);
            datosTituloCertificado.setWidthPercentage(100);
            datosTituloCertificado.getDefaultCell().setBorder(0);
            
            datosTituloCertificado.addCell(this.createLabelCell3(            		
					"CERTIFICADO MEDICO" +
					"\n\n\n"));
            
            
            document.add(datosTituloCertificado);
            
            // CREACION DE CONTENIDO CERTIFICADO
            PdfPTable datosCertificado = new PdfPTable(1);
            datosCertificado.setWidthPercentage(100);
            datosCertificado.getDefaultCell().setBorder(0);     
            
            
            
            //NOMBRE DEL PACIENTE
            String nombrePaciente= (atencionmedica.getPaciente().getApellido1Pac()==null?"":atencionmedica.getPaciente().getApellido1Pac()) + " " + 
            				(atencionmedica.getPaciente().getApellido2Pac()==null?"":atencionmedica.getPaciente().getApellido2Pac()) + " " +
            				(atencionmedica.getPaciente().getNombre1Pac()==null?"":atencionmedica.getPaciente().getNombre1Pac()) + " " +
            				(atencionmedica.getPaciente().getNombre2Pac()==null?"":atencionmedica.getPaciente().getNombre2Pac());
            
            String diagnostico="";
          
            
            if(topografiacie!=null){
            	diagnostico= topografiacie.getNombreTop()==null?"":topografiacie.getNombreTop();
            }
            
            String reposo= "";
            
            if(atencionmedica.getReposoAtmDias()==null || atencionmedica.getReposoAtmDias()==0){
            	if(atencionmedica.getReposoAtm()==null || atencionmedica.getReposoAtm()==0){
            		reposo="";
            	}else{
            		reposo= atencionmedica.getReposoAtm() + " horas, Desde " + fechaActual + " Hasta " + fechaActual;
            	}
            }else{
            	  Calendar calendar = Calendar.getInstance();
            	  calendar.setTime(new Date());
            	  calendar.add(Calendar.DAY_OF_YEAR, atencionmedica.getReposoAtmDias());
            	  String fechaHasta= formatoFecha.format(calendar.getTime());
            	  reposo= atencionmedica.getReposoAtmDias() + " dias, Desde " + fechaActual + " Hasta " + fechaHasta;
            }            
            
            Paragraph p;
            p = new Paragraph(20, "Certifico que el (la) paciente " + nombrePaciente + ", con C.I.: " +
						atencionmedica.getPaciente().getIdentificacionPac() +		
						"\n\n" +		
						"Presenta: " + diagnostico +
						"\n\n" +
						"Por lo cual requiere tratamiento medico: " + atencionmedica.getTratamientoAtm() + ", con reposo de: " + reposo +
						"\n\n\n\n\n\n\n\n" +
						"Atentamente:");
            
            datosCertificado.addCell(this.createLabelCell(p));
            						
            			
            document.add(datosCertificado);
            
            document.close();
            writer.close();
            cb.closePath();
            reader.close();
            page.closePath();
            
            return url;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	   

   
    private PdfPCell createLabelCell(Paragraph p ) {      
        com.itextpdf.text.Font fuente = FontFactory.getFont(
                FontFactory.TIMES_ROMAN, 11);
       
        PdfPCell cell = new PdfPCell();
        p.setFont(fuente);
        cell.addElement(p);
       
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(0);
        cell.setPaddingLeft(60);
        cell.setPaddingRight(50);
        cell.setColspan(5);
        
        return cell;
    }


  
    private PdfPCell createLabelCell2(String text) {        
        com.itextpdf.text.Font fuente = FontFactory.getFont(
                FontFactory.TIMES_ROMAN, 12, Font.BOLD);

        
        PdfPCell cell = new PdfPCell(new Phrase(text, fuente));

        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(0);
        
        return cell;
    }

   
    private PdfPCell createLabelCell3(String text) {        
        com.itextpdf.text.Font fuente = FontFactory.getFont(
                FontFactory.TIMES_ROMAN, 12, Font.BOLD);
        
        PdfPCell cell = new PdfPCell(new Phrase(text, fuente));

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        return cell;
    }

   

    @SuppressWarnings("unused")
    private Image getBarcode(Document document, PdfWriter pdfWriter,
            String servicio, String codigoTransaccion) {
        PdfContentByte cimg = pdfWriter.getDirectContent();
        Barcode39 code39 = new Barcode39();

        code39.setCode(servicio + codigoTransaccion);
        code39.setCodeType(Barcode39.CODE128);
        code39.setTextAlignment(Element.ALIGN_CENTER);

        Image image = code39.createImageWithBarcode(cimg, null, null);
        java.awt.Image im = code39.createAwtImage(Color.BLACK, Color.WHITE);
        float scaler = ((document.getPageSize().getWidth()
                - document.leftMargin() - document.rightMargin() - 100) / image.getWidth()) * 75;
        image.scalePercent(scaler);
        image.setAlignment(Element.ALIGN_CENTER);

        return image;
    }
    
    
    public Image createBarcode39Extended(String myText, PdfWriter writer) {
    	PdfContentByte pdfContentByte = writer.getDirectContent();

        Barcode128 barcode128 = new Barcode128();
        barcode128.setCode(myText);
       barcode128.setCodeType(Barcode128.CODE128);
        Image code128Image = barcode128.createImageWithBarcode(pdfContentByte, null, null);
       code128Image.scalePercent(50);
        return code128Image;
    }
    
    
    public Image createBarcodeEAN(String myText, PdfWriter writer) {
    	PdfContentByte pdfContentByte = writer.getDirectContent();
    	BarcodeEAN barcodeEAN = new BarcodeEAN();
    	barcodeEAN.setCodeType(BarcodeEAN.EAN13);
    	barcodeEAN.setCode(myText);
    	Image codeEANImage = barcodeEAN.createImageWithBarcode(pdfContentByte, null, null);
    	codeEANImage.setAbsolutePosition(20, 20);
    	codeEANImage.scalePercent(10);
    	codeEANImage.scalePercent(30f);
    	
    	return codeEANImage;

    }
    
  
}


