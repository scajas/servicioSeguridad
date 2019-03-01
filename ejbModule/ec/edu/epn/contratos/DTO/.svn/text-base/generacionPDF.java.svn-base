package ec.edu.epn.contratos.DTO;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.conexion.SQLServer.procedimientosAlmacenados;
import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.contratos.entities.Documento;
import ec.edu.epn.contratos.entities.Pedido;

public class generacionPDF {

	private String destination = "/ws/";

	public void generarPDFFimrado(Pedido pedido, Documento documento, String pathPedidoTemplate) {
		try {
			Document document = new Document(PageSize.A4);
			FileOutputStream outputStream = new FileOutputStream(
					new File(destination + pedido.getIdPedido() + "-" + pedido.getNced() + "[Firmado].pdf"));
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte cb = writer.getDirectContent();

			PdfReader reader = new PdfReader(pathPedidoTemplate);
			int n = reader.getNumberOfPages();

			for (int pag = 1; pag <= n; pag++) {

				PdfImportedPage page = writer.getImportedPage(reader, pag);
				cb.addTemplate(page, 0.0F, 0.0F);

				BaseFont helvetica = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.WINANSI,
						BaseFont.NOT_EMBEDDED);

				float fontSize = 12; /* Tamaño de fuente */
				Long x = new Long(245); /* Posición en el eje X */
				Long y = new Long(45); /* Posición en el eje Y */
				String valor = "Documento Firmado Electrónicamente.";

				cb.beginText();
				cb.setColorFill(BaseColor.BLUE);
				cb.setFontAndSize(helvetica, fontSize);
				cb.setTextMatrix(x, y);
				cb.showText(valor);		
				cb.endText();

				cb.stroke();
				document.newPage();
			}
			document.close();
			writer.close();

			cb.closePath();
			reader.close();

			File file = new File(destination + pedido.getIdPedido() + "-" + pedido.getNced() + "[Firmado].pdf");

			InputStream inputstream = new FileInputStream(file);
			int data = inputstream.read();
			while (data != -1) {
				data = inputstream.read();
			}
			inputstream.close();
			enviarFtpPedidorobertoFirma(file.getName(), inputstream, "Pedido Firmado", pedido);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarFtpPedidorobertoFirma(String fileName, InputStream in, String nombre, Pedido ped) {
		try {

			// ya paee por aqui
			System.out.println("Detino de Archivo en servidor: " + destination + fileName);

			Pedido p = ped;

			System.out.println("*************************Empleado:************************* " + p.getNced());
			FtpNet ftp = new FtpNet(p.getNced());
			ftp.setNombreArchivo(fileName);
			ftp.setLocalPath(destination + fileName);
			ftp.setNombre(nombre);
			if (ftp.conectarFTP()) {
				ftp.enviarArchivoPedidoRobFirma(ped);
			} else
				System.out.println("Error al conectar al FTP");

			File f = new File(destination + fileName);
			if (f.exists()) {
				f.delete();
			}

		} catch (Exception e) {
			System.out.println("Error en enviarFtp");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void generarPDFContratoPedido(Pedido pedido, List<CargaAcademica> listaCargaAcademica,
			List<Actividades> listaActividades, List<Documento> listaDocumento, FacultadCatalogos facu) {
		try {
			// Establece el documento tipo A4
			Document document = new Document(PageSize.A4);
			// Establece el archivo a ser creado
			FileOutputStream outputStream = new FileOutputStream(
					new File(destination + pedido.getIdPedido() + "-" + pedido.getNced() + ".pdf"));

			System.out.println(destination + pedido.getIdPedido() + "-" + pedido.getNced() + ".pdf");
			// Creamos una instancia para trabajar sobre el archivo a crear
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = destination + "Plantilla.pdf";
			System.out.println("prueba del path a leer la plantilla" + path);
			PdfReader reader = new PdfReader(path);
			// Generamos una pagina
			PdfImportedPage page = writer.getImportedPage(reader, 1);

			// Ponemos la plantilla dentro del documentoa crear para que tenga
			// la plantilla
			document.newPage();
			cb.addTemplate(page, 0, 0);

			// Creacion de Contenido
			Paragraph datosPersonales = new Paragraph();

			// Datos Personales

			String infoFacu = "\n\n\n\n\n\n\n\nFacultad: " + facu.getNomFacultad();

			com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			datosPersonales.setFont(fuente);
			datosPersonales.add(infoFacu);

			String datosPer = "\n\nNúmero de Pedido: " + pedido.getIdPedido() + "\nFecha de Pedido: "
					+ pedido.getFechaPedido() + "\n\nDatos Personales.\n\n";

			// String datosPer = "\n\nDatos Personales.\n\n";

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			datosPersonales.setFont(fuente);
			datosPersonales.add(datosPer);
			datosPer = "Nombre: " + pedido.getNombresDocente() + "\nNacionalidad: " + pedido.getNacionalidadDocente()
					+ "\nE-mail:" + pedido.getEmailDocente() + "\nTelf. Casa: " + pedido.getTelefonoDocente()
					+ "\nTelf. Cel.: " + pedido.getCelularDocente();
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC);
			datosPersonales.setFont(fuente);
			datosPersonales.add(datosPer);
			document.add(datosPersonales);

			// Datos de Contrato
			Paragraph datosContrato = new Paragraph();
			// com.itextpdf.text.Font fuente = FontFactory.getFont(
			// FontFactory.TIMES_ROMAN, 18, Font.BOLD);
			// datosContrato.setFont(fuente);

			String datosCont = "\nInformación del Contrato.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			datosContrato.setFont(fuente);
			datosContrato.add(datosCont);

			procedimientosAlmacenados sp = new procedimientosAlmacenados();
			List<List<String>> lista = new ArrayList<List<String>>();
			if (pedido.getTipoDocente().equals("Pregrado")) {
				datosCont = "Período del Contrato\nInicia: " + pedido.getFechaInicio() + " Finaliza: "
						+ pedido.getFechaFin();

			} else if (pedido.getTipoDocente().equals("Postgrado")) {
				{
					datosCont = "Período del Contrato\nFecha     Hora Inicio      Hora Fin";

					for (CargaAcademica carga : listaCargaAcademica) {
						if (!carga.getMarcaVarFechas().equals("")) {
							datosCont = "Período del Contrato\nFecha     Hora Inicio      Hora Fin";
							lista = sp.pa_saedathorarf(carga.getIdCarreraSaew(), carga.getCodmatsaew(),
									carga.getParalelo());

							for (List<String> s : lista) {
								datosCont += "\n" + s.get(2) + "    " + s.get(0) + "    " + s.get(1);
							}
							// datosCont += "\n";
						} else {
							datosCont = "Período del Contrato";
							datosCont += "\nInicia: " + carga.getFechaInicio() + "\nFinaliza: " + carga.getFechaFin();
						}
					}

				}
			}
			datosCont += "\nTipo de Docente: " + pedido.getTipoDocente() + "\nSemestre: " + pedido.getSemestre()
					+ "\nRelación de Dependencia y/o Contractual: " + pedido.getTipoContrato().getNombreTcont()
					+ "\nOcasionales o Civil: " + pedido.getRelacionActual() + " \nDedicación: "
					+ pedido.getDedicacion();

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC);
			datosContrato.setFont(fuente);
			datosContrato.add(datosCont);
			document.add(datosContrato);

			// Carga Academica en tabla
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "\nCarga Académica.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tituloTablaAcad.setFont(fuente);
			tituloTablaAcad.add(cabeceraTabla);
			document.add(tituloTablaAcad);

			PdfPTable cargaAcademica = new PdfPTable(6);

			cargaAcademica.addCell("CÓDIGO");
			cargaAcademica.addCell("ASIGNATURA");
			cargaAcademica.addCell("CARRERA");

			cargaAcademica.addCell("GR./PARAL.");
			cargaAcademica.addCell("HORAS SEMANA");
			cargaAcademica.addCell("HORAS MÓDULO");

			int totalHS = 0;
			int totalHM = 0;
			for (CargaAcademica carga : listaCargaAcademica) {
				cargaAcademica.addCell(carga.getCodmatsaew());
				cargaAcademica.addCell(carga.getNommatsaew());
				cargaAcademica.addCell(carga.getNomcarrerasaew());
				cargaAcademica.addCell(carga.getParalelo());
				cargaAcademica.addCell(carga.getNumHorasSemana().toString());
				cargaAcademica.addCell(carga.getNumHorasModulo().toString());
				totalHM = totalHM + carga.getNumHorasModulo();
				totalHS = totalHS + carga.getNumHorasSemana();
			}
			cargaAcademica.addCell("");
			cargaAcademica.addCell("");
			cargaAcademica.addCell("");
			cargaAcademica.addCell("TOTAL: ");
			cargaAcademica.addCell(Integer.toString(totalHS));
			cargaAcademica.addCell(Integer.toString(totalHM));
			document.add(cargaAcademica);

			// Otras Actividades en tabla
			Paragraph tituloTablaAct = new Paragraph();
			String cabeceraTablaAct = "\nOtras Actividades Académicas.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tituloTablaAct.setFont(fuente);
			tituloTablaAct.add(cabeceraTablaAct);
			document.add(tituloTablaAct);
			PdfPTable otrasActAcadem = new PdfPTable(3);

			otrasActAcadem.addCell("ACTIVIDAD");
			otrasActAcadem.addCell("HORAS SEMANA");
			otrasActAcadem.addCell("CARRERA");

			int totalHSA = 0;
			for (Actividades acti : listaActividades) {
				otrasActAcadem.addCell(acti.getNombreActividad());
				otrasActAcadem.addCell(acti.getNumHorasSemana().toString());
				otrasActAcadem.addCell(acti.getCarrera());
				totalHSA = totalHSA + acti.getNumHorasSemana();
			}
			otrasActAcadem.addCell("TOTAL");
			otrasActAcadem.addCell(Integer.toString(totalHSA));
			otrasActAcadem.addCell("");
			document.add(otrasActAcadem);

			// DOCUMENTOS CARGADOS EN TABLA
			Paragraph tituloTablaDoc = new Paragraph();
			String cabeceraTablaDocs = "\nDocumentos Cargados.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tituloTablaDoc.setFont(fuente);
			tituloTablaDoc.add(cabeceraTablaDocs);
			document.add(tituloTablaDoc);
			PdfPTable docs = new PdfPTable(1);

			docs.addCell("DOCUMENTO");

			for (Documento docuemnto : listaDocumento) {
				docs.addCell(docuemnto.getPathDocumento());
			}
			document.add(docs);

			// Si desea crear una celda de mas de una columna
			// Cree un objecto Cell y cambie su propiedad span
			//
			// PdfPCell celdaFinal = new PdfPCell(new Paragraph(
			// "Final de la tabla"));
			//
			// // Indicamos cuantas columnas ocupa la celda
			// celdaFinal.setColspan(3);
			// cargaAcademica.addCell(celdaFinal);

			// Agregamos la tabla al documento

			document.add(new Paragraph("\n\n" + new Date()));

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
