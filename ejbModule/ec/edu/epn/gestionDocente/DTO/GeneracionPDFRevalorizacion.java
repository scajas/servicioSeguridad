package ec.edu.epn.gestionDocente.DTO;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.resource.cci.Streamable;

import org.primefaces.model.StreamedContent;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.gestionDocente.entities.ActividadProyecto;
import ec.edu.epn.gestionDocente.entities.Capacitacion;
import ec.edu.epn.gestionDocente.entities.ExpProfesExt;
import ec.edu.epn.gestionDocente.entities.Infoactividad;
import ec.edu.epn.gestionDocente.entities.Patente;
import ec.edu.epn.gestionDocente.entities.Publicacione;
import ec.edu.epn.gestionDocente.entities.Recategorizacion;
import ec.edu.epn.gestionDocente.entities.Tesissaew;
import ec.edu.epn.gestionDocente.entities.TituloFormacionAcademica;
import ec.edu.epn.proyectos.DTO.EquipoProyectoDTO;
import ec.edu.epn.proyectos.beans.AutorProyectoDAO;
import ec.edu.epn.proyectos.entities.AutoresProducto;
import ec.edu.epn.proyectos.entities.Avanceestud;
import ec.edu.epn.proyectos.entities.CierrePeriodo;
import ec.edu.epn.proyectos.entities.Cronogramaavance;
import ec.edu.epn.proyectos.entities.Lineasproy;
import ec.edu.epn.proyectos.entities.Objetivoavance;
import ec.edu.epn.proyectos.entities.Producto;
import ec.edu.epn.proyectos.entities.ProyectoP;
import ec.edu.epn.proyectos.entities.Proyectocarrera;
import ec.edu.epn.proyectos.entities.Recursoavance;
import ec.edu.epn.proyectos.entities.RecursohPr;
import ec.edu.epn.publik.beans.UsuarioService;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.beans.DepDAO;
import ec.edu.epn.rrhh.beans.DepDAOImplement;
import ec.edu.epn.rrhh.entities.Dep;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.entities.Eventocapac;
import ec.edu.epn.rrhh.entities.Familiare;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;
import ec.edu.epn.seguridad.vo.Usuario;
import ec.edu.epn.silabo.entities.ActividadesVinculacion;
import ec.edu.epn.silabo.entities.Bibliografia;
import ec.edu.epn.silabo.entities.Capitulo;
import ec.edu.epn.silabo.entities.CronogramaDesarrollo;
import ec.edu.epn.silabo.entities.Evaluacion;
import ec.edu.epn.silabo.entities.MetodologiaDeEnsenanza;
import ec.edu.epn.silabo.entities.PiliticasDesarrollo;
import ec.edu.epn.silabo.entities.PracticasLaboratorio;
import ec.edu.epn.silabo.entities.Resultado;
import ec.edu.epn.silabo.entities.Silabo;
import ec.edu.epn.silabo.entities.Subcapitulo;
import ec.edu.epn.silabo.entities.UbicacionHorario;

@ManagedBean(name = "pdfrev")
@SessionScoped
public class GeneracionPDFRevalorizacion implements Serializable {

	/**
	 * 
	 */

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/UsuarioServiceBean!ec.edu.epn.publik.beans.UsuarioService")
	private UsuarioService usuarioI;

	@EJB
	private AutorProyectoDAO autoiresProductoI;

	private static final long serialVersionUID = 1503713234846805093L;

	public static final String INFORME_AVANCE = "IA";
	public static final String INFORME_PLANIFICACION = "IPL";

	public String generarPdfRevaloriza(DocenteDTO docSelect, Recategorizacion recategor, Emp emp,
			List<Tesissaew> tesissaew, List<Infoactividad> informes, List<NombramientoDTO> nom,
			List<TituloFormacionAcademica> titulosRevaloriza, List<Publicacione> indexadas, List<Publicacione> obras,
			List<Patente> patentes, List<ActividadProyecto> listaactividadPoryecto, List<ExpProfesExt> expExterna,
			String pathDocs, DocenteDTO docNuevoHL, List<HistoriaLaboral> historiaLaboral

	) {
		String url = "";
		try {

			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo
			FileOutputStream outputStream = new FileOutputStream(
					new File(pathDocs + "/" + "ActaRev" + docSelect.getnCed().trim() + ".pdf"));

			url = pathDocs + "/" + "ActaRev" + docSelect.getnCed().trim() + ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph p = new Paragraph();
			Image img = Image.getInstance(pathDocs + "/logo_epn.jpg");

			img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
			img.scaleToFit(75, 65);
			// Notice the image added directly to the Paragraph
			p.add(img);
			document.add(p);

			com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "ESCUELA POLITÉCNICA NACIONAL";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);

			String cabeceraTabla1 = "\nCampus José Rubén Orellana Ricaurte \n\n ";

			tituloTablaAcad.setFont(fuente);
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			tituloTablaAcad.add(cabeceraTabla);
			tituloTablaAcad.add(cabeceraTabla1);
			document.add(tituloTablaAcad);

			Paragraph tituloTablaAcad2 = new Paragraph();
			String cabeceraTabla2 = "\nEl consejo del " + docSelect.getNomDepartamento()
					+ " ha revisado la documentación presentada por el docente : " + docSelect.getNombre() + " "
					+ docSelect.getApel() + " , para el cargo de " + recategor.getCategoriasD().getNombreCat()
					+ " , constatando que el docente cuenta con los requisitos : " + " \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
			tituloTablaAcad2.setFont(fuente);
			tituloTablaAcad2.setAlignment(Element.ALIGN_JUSTIFIED);
			tituloTablaAcad2.add(cabeceraTabla2);
			document.add(tituloTablaAcad2);

			Paragraph tituloTablaAcad3 = new Paragraph();
			String cabeceraTabla3 = "\n DATOS PERSONALES \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tituloTablaAcad3.setFont(fuente);
			tituloTablaAcad3.setAlignment(Element.ALIGN_LEFT);
			tituloTablaAcad3.add(cabeceraTabla3);
			document.add(tituloTablaAcad3);

			PdfPTable datosPersonales = new PdfPTable(4);
			datosPersonales.setWidthPercentage(100);
			float[] columnWidths2 = new float[] { 50f, 50f, 50f, 50f };
			datosPersonales.setWidths(columnWidths2);
			datosPersonales.addCell(createLabelCell5("Cédula:"));
			datosPersonales.addCell(createLabelCell6(emp.getNced()));

			datosPersonales.addCell(createLabelCell5("Nombres :"));
			datosPersonales.addCell(createLabelCell6(emp.getApel() + " " + emp.getNom()));

			datosPersonales.addCell(createLabelCell5("Adscripción:"));
			datosPersonales.addCell(createLabelCell6(docNuevoHL.getNomDepartamento()));

			datosPersonales.addCell(createLabelCell5("Cargo:"));
			datosPersonales.addCell(createLabelCell6(docNuevoHL.getCargo()));

			datosPersonales.addCell(createLabelCell5("Fecha Ingreso EPN:"));
			datosPersonales.addCell(createLabelCell6(docSelect.getAuxFechaIngresoEPN()));

			datosPersonales.addCell(createLabelCell5("Fecha último puesto:"));
			datosPersonales.addCell(createLabelCell6(docNuevoHL.getFechaContrat()));

			datosPersonales.addCell(createLabelCell5("E-mail "));
			datosPersonales.addCell(createLabelCell6(emp.getEmail1()));

			document.add(datosPersonales);

			Paragraph datosContrato = new Paragraph();

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.ITALIC);

			datosContrato.add("\n");
			datosContrato.setFont(fuente);
			// datosContrato.add(datosCont);
			document.add(datosContrato);

			Paragraph direccion = new Paragraph();
			String direccios = "\n a)Tener al menos grado académico de maestría o su equivalente, reconocido e inscrito por la SENESCYT;\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			direccion.setFont(fuente);
			direccion.setAlignment(Element.ALIGN_JUSTIFIED);
			direccion.add(direccios);
			document.add(direccion);

			document.add(datosContrato);

			PdfPTable datosinstruccion = new PdfPTable(5);
			datosinstruccion.setWidthPercentage(100);

			datosinstruccion.addCell(createLabelCell("Universidad"));
			datosinstruccion.addCell(createLabelCell("Nivel"));
			datosinstruccion.addCell(createLabelCell("Título"));
			datosinstruccion.addCell(createLabelCell("Reg. Senescyt"));
			datosinstruccion.addCell(createLabelCell("F.reg"));

			for (TituloFormacionAcademica titulo : titulosRevaloriza) {
				datosinstruccion.addCell(createLabelCell4(titulo.getUniversidad().getNomUniversid()));
				datosinstruccion.addCell(createLabelCell4(titulo.getNivel().getNomNivel()));
				datosinstruccion.addCell(createLabelCell4(titulo.getNombreTitulo()));
				datosinstruccion.addCell(createLabelCell4(titulo.getRegSenescyt()));

				if (titulo.getFecRegSenescyt() == null) {
					datosinstruccion.addCell(createLabelCell4(" "));
				} else {
					datosinstruccion.addCell(createLabelCell4(titulo.getFecRegSenescyt().toString()));
				}

			}

			document.add(datosinstruccion);

			document.add(datosContrato);

			Paragraph publicaciones = new Paragraph();
			String pub = "\n b)Acreditar (dos, tres, cinco) publicaciones indexadas u obras de relevancia, (una, dos) de las cuales debe haber sido publicada en los ùltimos conco años.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			publicaciones.setFont(fuente);
			publicaciones.setAlignment(Element.ALIGN_JUSTIFIED);
			publicaciones.add(pub);
			document.add(publicaciones);

			document.add(datosContrato);

			Paragraph indexadasP = new Paragraph();
			String index = "\n Publicaciones indexadas \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			indexadasP.setFont(fuente);
			indexadasP.setAlignment(Element.ALIGN_LEFT);
			indexadasP.add(index);
			document.add(indexadasP);

			PdfPTable datospublicaciones = new PdfPTable(5);
			datospublicaciones.setWidthPercentage(100);
			float[] columnWidthsins8 = new float[] { 35f, 35f, 22f, 20f, 25f };
			datospublicaciones.setWidths(columnWidthsins8);

			datospublicaciones.addCell(createLabelCell("Tipo"));
			datospublicaciones.addCell(createLabelCell("Título"));
			datospublicaciones.addCell(createLabelCell("Catálogo"));
			datospublicaciones.addCell(createLabelCell("F. Publicación"));

			datospublicaciones.addCell(createLabelCell("URL"));

			for (Publicacione pu : indexadas) {
				datospublicaciones.addCell(createLabelCell4(pu.getTipoPublicacion().getNombreTipoPublic()));
				datospublicaciones.addCell(createLabelCell4(pu.getTituloPublic()));
				datospublicaciones.addCell(createLabelCell4(pu.getCatalogo()));
				datospublicaciones.addCell(createLabelCell4(pu.getFechaPublic()));

				datospublicaciones.addCell(createLabelCell4(pu.getEnlace()));
			}

			document.add(datospublicaciones);
			document.add(datosContrato);

			Paragraph obrasRel = new Paragraph();
			String ob = "\n Obras de relevancia \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			obrasRel.setFont(fuente);
			obrasRel.setAlignment(Element.ALIGN_LEFT);
			obrasRel.add(ob);
			document.add(obrasRel);

			document.add(datosContrato);

			PdfPTable datosObras = new PdfPTable(5);
			datosObras.setWidthPercentage(100);

			datosObras.setWidths(columnWidthsins8);

			datosObras.addCell(createLabelCell("Tipo"));
			datosObras.addCell(createLabelCell("Título"));

			datosObras.addCell(createLabelCell("F. Publicación"));
			datosObras.addCell(createLabelCell("País"));
			datosObras.addCell(createLabelCell("URL"));

			for (Publicacione pu : obras) {
				datosObras.addCell(createLabelCell4(pu.getTipoPublicacion().getNombreTipoPublic()));
				datosObras.addCell(createLabelCell4(pu.getTituloPublic()));

				datosObras.addCell(createLabelCell4(pu.getFechaPublic()));
				datosObras.addCell(createLabelCell4(pu.getPais()));
				datosObras.addCell(createLabelCell4(pu.getEnlace()));
			}

			document.add(datosObras);

			document.add(datosContrato);

			PdfPTable datosPatente = new PdfPTable(5);
			datosPatente.setWidthPercentage(100);

			datosPatente.setWidths(columnWidthsins8);

			datosPatente.addCell(createLabelCell("Nombre"));
			datosPatente.addCell(createLabelCell("Código IEPI"));

			datosPatente.addCell(createLabelCell("F. Publicación"));
			datosPatente.addCell(createLabelCell("Observación"));

			datosPatente.addCell(createLabelCell("URL"));

			for (Patente pat : patentes) {
				datosPatente.addCell(createLabelCell4(pat.getNombreP()));
				datosPatente.addCell(createLabelCell4(pat.getCodigoIepi()));
				datosPatente.addCell(createLabelCell4(pat.getFechaP().toString()));
				datosPatente.addCell(createLabelCell4(pat.getObservaciones()));

				datosPatente.addCell(createLabelCell4(pat.getUrl()));
			}

			document.add(datosPatente);
			document.add(datosContrato);

			Paragraph experiencia = new Paragraph();
			String exp = "\n c)Haber obtenido como mínimo el setenta y cinco por ciento del puntaje de la evaluación de desempeño en sus últimos dos periodos académicos, o en el último si la IES no hubiera realizado mas evaluaciones.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			experiencia.setFont(fuente);
			experiencia.setAlignment(Element.ALIGN_JUSTIFIED);
			experiencia.add(exp);
			document.add(experiencia);

			document.add(datosContrato);

			PdfPTable datosEval = new PdfPTable(3);
			datosEval.setWidthPercentage(100);
			float[] columnWidthsins1 = new float[] { 50f, 50f, 50f };
			datosEval.setWidths(columnWidthsins1);

			datosEval.addCell(createLabelCell("Punjate"));
			datosEval.addCell(createLabelCell("Fecha"));
			datosEval.addCell(createLabelCell("Observaciones"));

			for (Infoactividad inf : informes) {

				datosEval.addCell(createLabelCell4(inf.getNota().toString()));
				datosEval.addCell(createLabelCell4(inf.getFecha().toString()));
				datosEval.addCell(createLabelCell4(inf.getObservacion()));

			}

			document.add(datosEval);

			document.add(datosContrato);

			Paragraph proyectos = new Paragraph();
			String proy = "\n d)Haber dirigido una investigación de al menos 12 meses de duración, la cual deberá haber finalizado con la presentación y aporbación institucional de los resultads del respectivo proyecto, o haber dirigido (6, 8) tesis o trabajo de titulación de grado,(una, dos) de las cuales deben haberse dirigido en los últimos cinco años.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			proyectos.setFont(fuente);
			proyectos.setAlignment(Element.ALIGN_JUSTIFIED);
			proyectos.add(proy);
			document.add(proyectos);

			document.add(datosContrato);

			Paragraph pro = new Paragraph();
			String pr = "\n Proyectos de Investigación \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			pro.setFont(fuente);
			pro.setAlignment(Element.ALIGN_LEFT);
			pro.add(pr);
			document.add(pro);

			document.add(datosContrato);

			PdfPTable datosProy = new PdfPTable(4);
			datosProy.setWidthPercentage(100);
			float[] columnWidthsPr = new float[] { 70f, 50f, 50f, 50f };
			datosProy.setWidths(columnWidthsPr);

			datosProy.addCell(createLabelCell("Nombre Proyecto"));
			datosProy.addCell(createLabelCell("Rol"));
			datosProy.addCell(createLabelCell("Fecha Inicio"));
			datosProy.addCell(createLabelCell("Fecha Fin"));

			for (ActividadProyecto act : listaactividadPoryecto) {

				datosProy.addCell(createLabelCell4(act.getNomProyecto()));
				datosProy.addCell(createLabelCell4(act.getRolProyecto()));
				datosProy.addCell(createLabelCell4(act.getFechaInip().toString()));
				datosProy.addCell(createLabelCell4(act.getFechaFinp().toString()));

			}

			document.add(datosProy);

			document.add(datosContrato);

			Paragraph tesis = new Paragraph();
			String te = "\n Tesis o trabajos de titulación de grado \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			tesis.setFont(fuente);
			tesis.setAlignment(Element.ALIGN_LEFT);
			tesis.add(te);
			document.add(tesis);

			document.add(datosContrato);

			PdfPTable datosTesis = new PdfPTable(5);
			datosTesis.setWidthPercentage(100);

			datosTesis.setWidths(columnWidthsins8);

			datosTesis.addCell(createLabelCell("N° Tesis"));
			datosTesis.addCell(createLabelCell("Nombre"));
			datosTesis.addCell(createLabelCell("Nivel"));
			datosTesis.addCell(createLabelCell("Fecha Grado"));
			datosTesis.addCell(createLabelCell("Carrera"));

			for (Tesissaew tes : tesissaew) {

				datosTesis.addCell(createLabelCell4(tes.getIdtesis().toString()));
				datosTesis.addCell(createLabelCell4(tes.getTesis()));
				datosTesis.addCell(createLabelCell4(tes.getNivel()));
				datosTesis.addCell(createLabelCell4(tes.getDefensaoral()));
				datosTesis.addCell(createLabelCell4(tes.getCarrera()));

			}

			document.add(datosTesis);

			document.add(datosContrato);

			Paragraph experienciaDoc = new Paragraph();
			String ex = "\n e)Acreditar una experiencia no simultánea de al menos (diez, quince, veinte) años como profesor titular y no titular en la misma IES u otra.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			experienciaDoc.setFont(fuente);
			experienciaDoc.setAlignment(Element.ALIGN_JUSTIFIED);
			experienciaDoc.add(ex);
			document.add(experienciaDoc);

			document.add(datosContrato);

			Paragraph EPN = new Paragraph();
			String ep = "\n Experiencia EPN \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			EPN.setFont(fuente);
			EPN.setAlignment(Element.ALIGN_LEFT);
			EPN.add(ep);
			document.add(EPN);

			document.add(datosContrato);

			PdfPTable datosEPN = new PdfPTable(4);
			datosEPN.setWidthPercentage(100);

			datosEPN.setWidths(columnWidthsPr);

			datosEPN.addCell(createLabelCell("Cargo"));
			datosEPN.addCell(createLabelCell("Cateogría"));
			datosEPN.addCell(createLabelCell("F. Inicio"));
			datosEPN.addCell(createLabelCell("F. Fin"));

			for (HistoriaLaboral nomb : historiaLaboral) {

				if (nomb.getCargosm() == null) {
					datosEPN.addCell(createLabelCell4(""));
				}

				else {
					datosEPN.addCell(createLabelCell4(nomb.getCargosm().getNombreCargo()));
				}

				datosEPN.addCell(createLabelCell4(""));
				if (nomb.getFechaRige() == null) {
					datosEPN.addCell(createLabelCell4(""));
				} else {
					datosEPN.addCell(createLabelCell4(nomb.getFechaRige().toString()));
				}

				if (nomb.getFechaPrevistaFin() == null) {
					datosEPN.addCell(createLabelCell4(""));
				} else {
					datosEPN.addCell(createLabelCell4(nomb.getFechaPrevistaFin().toString()));
				}

			}

			document.add(datosEPN);

			document.add(datosContrato);

			Paragraph externa = new Paragraph();
			String exter = "\n Experiencia docente externa \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			externa.setFont(fuente);
			externa.setAlignment(Element.ALIGN_LEFT);
			externa.add(exter);
			document.add(externa);

			document.add(datosContrato);

			PdfPTable datosExpExt = new PdfPTable(5);
			datosExpExt.setWidthPercentage(100);

			datosExpExt.setWidths(columnWidthsins8);

			datosExpExt.addCell(createLabelCell("Cargo"));
			datosExpExt.addCell(createLabelCell("Área"));
			datosExpExt.addCell(createLabelCell("Institución"));
			datosExpExt.addCell(createLabelCell("F. Ingreso"));
			datosExpExt.addCell(createLabelCell("F. Salida"));

			for (ExpProfesExt expExt : expExterna) {

				datosExpExt.addCell(createLabelCell4(expExt.getCargoTrabajo()));
				datosExpExt.addCell(createLabelCell4(expExt.getAreaTrabajo()));
				datosExpExt.addCell(createLabelCell4(expExt.getLugarTrabajo()));
				datosExpExt.addCell(createLabelCell4(expExt.getFechaInicioTrabajo().toString()));
				datosExpExt.addCell(createLabelCell4(expExt.getFechaFinTrabajo().toString()));

			}

			document.add(datosExpExt);

			document.add(datosContrato);

			fechas(recategor.getFecha());

			Paragraph revalorizacion = new Paragraph();
			String rev = "\n En base a las evidencias presentadas, el CONSEJO DE FACULTAD sugiere la revalorización del docente como :  \n\n "
					+ recategor.getCategoriasD().getNombreCat() + ". El " + dia + " de " + mes + " del " + anioo;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			revalorizacion.setFont(fuente);
			revalorizacion.setAlignment(Element.ALIGN_JUSTIFIED);
			revalorizacion.add(rev);
			document.add(revalorizacion);

			document.add(datosContrato);

			document.add(datosContrato);
			document.add(datosContrato);
			document.add(datosContrato);

			PdfPTable firmas = new PdfPTable(4);
			firmas.setWidthPercentage(100);

			firmas.setWidths(columnWidths2);
			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(""));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(""));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(""));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			document.add(firmas);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfRecategoriza(DocenteDTO docSelect, Recategorizacion recategor, Emp emp,
			List<NombramientoDTO> nom, List<TituloFormacionAcademica> titulosRevaloriza, List<Publicacione> indexadas,
			List<Publicacione> obras, List<Patente> patentes, List<ActividadProyecto> listaactividadPoryecto,
			List<ExpProfesExt> expExterna, List<Capacitacion> capacitaciones, String pathDocs, DocenteDTO docHist,
			List<HistoriaLaboral> historias

	) {
		String url = "";
		try {

			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo
			FileOutputStream outputStream = new FileOutputStream(
					new File(pathDocs + "/" + "ActaRec" + docSelect.getnCed().trim() + ".pdf"));

			url = pathDocs + "/" + "ActaRec" + docSelect.getnCed().trim() + ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph p = new Paragraph();
			Image img = Image.getInstance(pathDocs + "/logo_epn.jpg");

			img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
			img.scaleToFit(75, 65);
			// Notice the image added directly to the Paragraph
			p.add(img);
			document.add(p);

			com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "ESCUELA POLITÉCNICA NACIONAL";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);

			String cabeceraTabla1 = "\nCampus José Rubén Orellana Ricaurte \n\n ";

			tituloTablaAcad.setFont(fuente);
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			tituloTablaAcad.add(cabeceraTabla);
			tituloTablaAcad.add(cabeceraTabla1);
			document.add(tituloTablaAcad);

			Paragraph tituloTablaAcad2 = new Paragraph();
			String cabeceraTabla2 = "\nEl consejo del " + docSelect.getNomDepartamento()
					+ " ha revisado la documentación presentada por el docente : " + docSelect.getNombre() + " "
					+ docSelect.getApel() + " , para el cargo de " + recategor.getCategoriasD().getNombreCat()
					+ " , constatando que el docente cuenta con los requisitos : " + " \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
			tituloTablaAcad2.setFont(fuente);
			tituloTablaAcad2.setAlignment(Element.ALIGN_JUSTIFIED);
			tituloTablaAcad2.add(cabeceraTabla2);
			document.add(tituloTablaAcad2);

			Paragraph tituloTablaAcad3 = new Paragraph();
			String cabeceraTabla3 = "\n DATOS PERSONALES \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tituloTablaAcad3.setFont(fuente);
			tituloTablaAcad3.setAlignment(Element.ALIGN_LEFT);
			tituloTablaAcad3.add(cabeceraTabla3);
			document.add(tituloTablaAcad3);

			PdfPTable datosPersonales = new PdfPTable(4);
			datosPersonales.setWidthPercentage(100);
			float[] columnWidths2 = new float[] { 50f, 50f, 50f, 50f };
			datosPersonales.setWidths(columnWidths2);
			datosPersonales.addCell(createLabelCell5("Cédula:"));
			datosPersonales.addCell(createLabelCell6(emp.getNced()));

			datosPersonales.addCell(createLabelCell5("Nombres :"));
			datosPersonales.addCell(createLabelCell6(emp.getApel() + " " + emp.getNom()));

			datosPersonales.addCell(createLabelCell5("Adscripción:"));
			datosPersonales.addCell(createLabelCell6(docHist.getNomDepartamento()));

			datosPersonales.addCell(createLabelCell5("Cargo:"));
			datosPersonales.addCell(createLabelCell6(docHist.getCargo()));

			datosPersonales.addCell(createLabelCell5("Fecha Ingreso EPN:"));
			datosPersonales.addCell(createLabelCell6(docSelect.getAuxFechaIngresoEPN()));

			datosPersonales.addCell(createLabelCell5("Fecha último puesto:"));
			datosPersonales.addCell(createLabelCell6(docHist.getFechaContrat()));

			datosPersonales.addCell(createLabelCell5("E-mail "));
			datosPersonales.addCell(createLabelCell6(emp.getEmail1()));

			document.add(datosPersonales);

			Paragraph datosContrato = new Paragraph();

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.ITALIC);

			datosContrato.add("\n");
			datosContrato.setFont(fuente);
			// datosContrato.add(datosCont);
			document.add(datosContrato);

			Paragraph personal = new Paragraph();
			String per = "\n a)	Ser personal académico titular auxiliar\n";
			String acrgo = docSelect.getCargo();
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			personal.setFont(fuente);
			personal.setAlignment(Element.ALIGN_JUSTIFIED);
			personal.add(per);
			personal.add(acrgo);
			document.add(personal);

			Paragraph direccion = new Paragraph();
			String direccios = "\n b)	Contar al menos grado académico de maestría o su equivalente registrado en el SENESCYT\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			direccion.setFont(fuente);
			direccion.setAlignment(Element.ALIGN_JUSTIFIED);
			direccion.add(direccios);
			document.add(direccion);

			document.add(datosContrato);

			PdfPTable datosinstruccion = new PdfPTable(5);
			datosinstruccion.setWidthPercentage(100);

			datosinstruccion.addCell(createLabelCell("Universidad"));
			datosinstruccion.addCell(createLabelCell("Nivel"));
			datosinstruccion.addCell(createLabelCell("Título"));
			datosinstruccion.addCell(createLabelCell("Reg. Senescyt"));
			datosinstruccion.addCell(createLabelCell("F.reg"));

			for (TituloFormacionAcademica titulo : titulosRevaloriza) {
				datosinstruccion.addCell(createLabelCell4(titulo.getUniversidad().getNomUniversid()));
				datosinstruccion.addCell(createLabelCell4(titulo.getNivel().getNomNivel()));
				datosinstruccion.addCell(createLabelCell4(titulo.getNombreTitulo()));
				datosinstruccion.addCell(createLabelCell4(titulo.getRegSenescyt()));

				if (titulo.getFecRegSenescyt() == null) {
					datosinstruccion.addCell(createLabelCell4(" "));
				} else {
					datosinstruccion.addCell(createLabelCell4(titulo.getFecRegSenescyt().toString()));
				}

			}

			document.add(datosinstruccion);

			Paragraph ingreso = new Paragraph();
			String ing = "\n c)	Haber ingresado mediante concurso público de méritos y oposición, a partir de la expedición de la LOES o bajo otra modalidad antes de la LOES\n";

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso.setFont(fuente);
			ingreso.setAlignment(Element.ALIGN_JUSTIFIED);
			ingreso.add(ing);

			document.add(ingreso);

			document.add(datosContrato);

			Paragraph EPN = new Paragraph();
			String ep = "\n Experiencia EPN \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			EPN.setFont(fuente);
			EPN.setAlignment(Element.ALIGN_LEFT);
			EPN.add(ep);
			document.add(EPN);

			document.add(datosContrato);

			PdfPTable datosEPN = new PdfPTable(4);
			datosEPN.setWidthPercentage(100);
			float[] columnWidthsPr = new float[] { 70f, 50f, 50f, 50f };
			datosEPN.setWidths(columnWidthsPr);

			datosEPN.addCell(createLabelCell("Cargo"));
			datosEPN.addCell(createLabelCell("Cateogría"));
			datosEPN.addCell(createLabelCell("F. Inicio"));
			datosEPN.addCell(createLabelCell("F. Fin"));

			for (HistoriaLaboral nomb : historias) {

				if (nomb.getCargosm() == null) {
					datosEPN.addCell(createLabelCell4(""));
				} else {
					datosEPN.addCell(createLabelCell4(nomb.getCargosm().getNombreCargo()));
				}
				datosEPN.addCell(createLabelCell4(""));
				if (nomb.getFechaRige() == null) {
					datosEPN.addCell(createLabelCell4(""));
				} else {
					datosEPN.addCell(createLabelCell4(nomb.getFechaRige().toString()));
				}

				if (nomb.getFechaPrevistaFin() == null) {
					datosEPN.addCell(createLabelCell4(""));
				} else {
					datosEPN.addCell(createLabelCell4(nomb.getFechaPrevistaFin().toString()));
				}

			}

			document.add(datosEPN);

			document.add(datosContrato);

			Paragraph publicaciones = new Paragraph();
			String pub = "\n d)	Haber creado o publicado (2, 3, 5) obras de relevancia o articulos indexados, uno de los cuales debe corresponder a los últimos cinco años.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			publicaciones.setFont(fuente);
			publicaciones.setAlignment(Element.ALIGN_JUSTIFIED);
			publicaciones.add(pub);
			document.add(publicaciones);

			document.add(datosContrato);

			Paragraph indexadasP = new Paragraph();
			String index = "\n Publicaciones indexadas \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			indexadasP.setFont(fuente);
			indexadasP.setAlignment(Element.ALIGN_LEFT);
			indexadasP.add(index);
			document.add(indexadasP);

			PdfPTable datospublicaciones = new PdfPTable(5);
			datospublicaciones.setWidthPercentage(100);
			float[] columnWidthsins8 = new float[] { 35f, 35f, 22f, 20f, 25f };
			datospublicaciones.setWidths(columnWidthsins8);

			datospublicaciones.addCell(createLabelCell("Tipo"));
			datospublicaciones.addCell(createLabelCell("Título"));
			datospublicaciones.addCell(createLabelCell("Catálogo"));
			datospublicaciones.addCell(createLabelCell("F. Publicación"));

			datospublicaciones.addCell(createLabelCell("URL"));

			for (Publicacione pu : indexadas) {
				datospublicaciones.addCell(createLabelCell4(pu.getTipoPublicacion().getNombreTipoPublic()));
				datospublicaciones.addCell(createLabelCell4(pu.getTituloPublic()));
				datospublicaciones.addCell(createLabelCell4(pu.getCatalogo()));
				datospublicaciones.addCell(createLabelCell4(pu.getFechaPublic()));

				datospublicaciones.addCell(createLabelCell4(pu.getEnlace()));
			}

			document.add(datospublicaciones);
			document.add(datosContrato);

			Paragraph obrasRel = new Paragraph();
			String ob = "\n Obras de relevancia \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			obrasRel.setFont(fuente);
			obrasRel.setAlignment(Element.ALIGN_LEFT);
			obrasRel.add(ob);
			document.add(obrasRel);

			document.add(datosContrato);

			PdfPTable datosObras = new PdfPTable(5);
			datosObras.setWidthPercentage(100);

			datosObras.setWidths(columnWidthsins8);

			datosObras.addCell(createLabelCell("Tipo"));
			datosObras.addCell(createLabelCell("Título"));

			datosObras.addCell(createLabelCell("F. Publicación"));
			datosObras.addCell(createLabelCell("País"));
			datosObras.addCell(createLabelCell("URL"));

			for (Publicacione pu : obras) {
				datosObras.addCell(createLabelCell4(pu.getTipoPublicacion().getNombreTipoPublic()));
				datosObras.addCell(createLabelCell4(pu.getTituloPublic()));

				datosObras.addCell(createLabelCell4(pu.getFechaPublic()));
				datosObras.addCell(createLabelCell4(pu.getPais()));
				datosObras.addCell(createLabelCell4(pu.getEnlace()));
			}

			document.add(datosObras);

			document.add(datosContrato);

			PdfPTable datosPatente = new PdfPTable(5);
			datosPatente.setWidthPercentage(100);

			datosPatente.setWidths(columnWidthsins8);

			datosPatente.addCell(createLabelCell("Nombre"));
			datosPatente.addCell(createLabelCell("Código IEPI"));

			datosPatente.addCell(createLabelCell("F. Publicación"));
			datosPatente.addCell(createLabelCell("Observación"));

			datosPatente.addCell(createLabelCell("URL"));

			for (Patente pat : patentes) {
				datosPatente.addCell(createLabelCell4(pat.getNombreP()));
				datosPatente.addCell(createLabelCell4(pat.getCodigoIepi()));
				datosPatente.addCell(createLabelCell4(pat.getFechaP().toString()));
				datosPatente.addCell(createLabelCell4(pat.getObservaciones()));

				datosPatente.addCell(createLabelCell4(pat.getUrl()));
			}

			document.add(datosPatente);
			document.add(datosContrato);

			Paragraph experienciaDoc = new Paragraph();
			String ex = "\n e)	Acreditar al menos tres años de experiencia académica en instituciones de educación superior o instituciones de investigación de reconocido prestigio\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			experienciaDoc.setFont(fuente);
			experienciaDoc.setAlignment(Element.ALIGN_JUSTIFIED);
			experienciaDoc.add(ex);
			document.add(experienciaDoc);

			document.add(datosContrato);

			document.add(datosEPN);

			document.add(datosContrato);

			Paragraph externa = new Paragraph();
			String exter = "\n Experiencia docente externa \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			externa.setFont(fuente);
			externa.setAlignment(Element.ALIGN_LEFT);
			externa.add(exter);
			document.add(externa);

			document.add(datosContrato);

			PdfPTable datosExpExt = new PdfPTable(5);
			datosExpExt.setWidthPercentage(100);

			datosExpExt.setWidths(columnWidthsins8);

			datosExpExt.addCell(createLabelCell("Cargo"));
			datosExpExt.addCell(createLabelCell("Área"));
			datosExpExt.addCell(createLabelCell("Institución"));
			datosExpExt.addCell(createLabelCell("F. Ingreso"));
			datosExpExt.addCell(createLabelCell("F. Salida"));

			for (ExpProfesExt expExt : expExterna) {

				datosExpExt.addCell(createLabelCell4(expExt.getCargoTrabajo()));
				datosExpExt.addCell(createLabelCell4(expExt.getAreaTrabajo()));
				datosExpExt.addCell(createLabelCell4(expExt.getLugarTrabajo()));
				datosExpExt.addCell(createLabelCell4(expExt.getFechaInicioTrabajo().toString()));
				datosExpExt.addCell(createLabelCell4(expExt.getFechaFinTrabajo().toString()));

			}

			document.add(datosExpExt);

			document.add(datosContrato);

			Paragraph proyectos = new Paragraph();
			String proy = "\n f)	Haber (participado, dirigido) en una investigación de al menos 12 meses de duración, la cual deberá haber finalizado con la presentación y aprobación institucional de los resultados del respectivo proyecto.\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			proyectos.setFont(fuente);
			proyectos.setAlignment(Element.ALIGN_JUSTIFIED);
			proyectos.add(proy);
			document.add(proyectos);

			document.add(datosContrato);

			Paragraph pro = new Paragraph();
			String pr = "\n Proyectos de Investigación \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			pro.setFont(fuente);
			pro.setAlignment(Element.ALIGN_LEFT);
			pro.add(pr);
			document.add(pro);

			document.add(datosContrato);

			PdfPTable datosProy = new PdfPTable(4);
			datosProy.setWidthPercentage(100);

			datosProy.setWidths(columnWidthsPr);

			datosProy.addCell(createLabelCell("Nombre Proyecto"));
			datosProy.addCell(createLabelCell("Rol"));
			datosProy.addCell(createLabelCell("Fecha Inicio"));
			datosProy.addCell(createLabelCell("Fecha Fin"));

			for (ActividadProyecto act : listaactividadPoryecto) {

				datosProy.addCell(createLabelCell4(act.getNomProyecto()));
				datosProy.addCell(createLabelCell4(act.getRolProyecto()));
				datosProy.addCell(createLabelCell4(act.getFechaInip().toString()));
				datosProy.addCell(createLabelCell4(act.getFechaFinp().toString()));

			}

			document.add(datosProy);

			document.add(datosContrato);
			Paragraph capcitacion = new Paragraph();
			String cp = "\n g)	Haber realizado (96, 128, 160) horas acumuladas de capacitación y actualización profesional, de las cuales noventa habrán sido en metodologías de aprendizaje e investigación, y el resto en el campo de conocimiento vinculado a sus actividades de docencia o investigación. (ref. RCEPI Art. 62 num. 2) \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			capcitacion.setFont(fuente);
			capcitacion.setAlignment(Element.ALIGN_LEFT);
			capcitacion.add(cp);
			document.add(capcitacion);

			document.add(datosContrato);

			PdfPTable datosCap = new PdfPTable(4);
			datosCap.setWidthPercentage(100);

			datosCap.setWidths(columnWidthsPr);

			datosCap.addCell(createLabelCell("Tema"));
			datosCap.addCell(createLabelCell("Lugar"));
			datosCap.addCell(createLabelCell("Categoría"));
			datosCap.addCell(createLabelCell("N° Horas"));

			int horascono = 0;
			int horasMetod = 0;

			for (Capacitacion cap : capacitaciones) {

				datosCap.addCell(createLabelCell4(cap.getNombreCapac()));
				datosCap.addCell(createLabelCell4(cap.getLugarCapac()));
				datosCap.addCell(createLabelCell4(cap.getCategoria()));
				datosCap.addCell(createLabelCell4(cap.getHorasCapac().toString()));

				if (cap.getCategoria().trim()
						.equals("CONOCIMIENTO VINCULADO A SUS ACTIVIDADES DE DOCENCIA O INVESTIGACIÓN")
						&& cap.getHorasCapac() != null)

				{

					horascono = horascono + cap.getHorasCapac();

				}

				if (cap.getCategoria().trim().equals("METODOLOGÍAS DE APRENDIZAJE E INVESTIGACIÓN")
						&& cap.getHorasCapac() != null)

				{

					horasMetod = horasMetod + cap.getHorasCapac();

				}

			}

			document.add(datosCap);

			document.add(datosContrato);

			Paragraph horas = new Paragraph();
			String horasmet = "\n Horas de capacitación en metodologías de aprendizaje e investigación: " + horasMetod
					+ "\n\n";
			String horascap = "\n Horas de capacitación en campo de conocimiento vinculado a sus actividades de docencia o investigación:  "
					+ horascono + "\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			horas.setFont(fuente);
			horas.setAlignment(Element.ALIGN_LEFT);
			horas.add(horasmet);
			horas.add(horascap);
			document.add(horas);

			document.add(datosContrato);

			fechas(recategor.getFecha());

			Paragraph revalorizacion = new Paragraph();
			String rev = "\n En base a las evidencias presentadas, el CONSEJO DE FACULTAD sugiere la recategorización del docente como : \n\n "
					+ recategor.getCategoriasD().getNombreCat() + ",   el " + dia + " de " + mes + " del " + anioo;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			revalorizacion.setFont(fuente);
			revalorizacion.setAlignment(Element.ALIGN_LEFT);
			revalorizacion.add(rev);
			document.add(revalorizacion);

			document.add(datosContrato);
			document.add(datosContrato);
			document.add(datosContrato);

			PdfPTable firmas = new PdfPTable(4);
			firmas.setWidthPercentage(100);

			firmas.setWidths(columnWidths2);
			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(""));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(""));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(""));

			firmas.addCell(createLabelCell5("______________________"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Nombre"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			firmas.addCell(createLabelCell5("Cargo"));
			firmas.addCell(createLabelCell6(" "));

			document.add(firmas);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfSilabo(DocenteDTO docSelect, Emp emp, String pathDocs, List<Resultado> resultados,
			List<Capitulo> capitulos, List<PracticasLaboratorio> practicas, List<Bibliografia> bibliografiaBasica,
			List<Bibliografia> bibliografiaComplementaria, List<MetodologiaDeEnsenanza> metodologias,
			List<Evaluacion> evaluaciones, List<ActividadesVinculacion> actividades,
			List<CronogramaDesarrollo> cronograma, List<UbicacionHorario> ubicaciones,
			List<PiliticasDesarrollo> politicas, Pensum pensumSelect, Silabo silaboselect) {
		String url = "";
		try {

			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo
			FileOutputStream outputStream = new FileOutputStream(new File(
					pathDocs + "/" + "Silabo" + docSelect.getnCed().trim() + silaboselect.getCodigo().trim() + ".pdf"));

			url = pathDocs + "/" + "Silabo" + docSelect.getnCed().trim() + silaboselect.getCodigo().trim() + ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph p = new Paragraph();
			Image img = Image.getInstance(pathDocs + "/logo_epn.jpg");

			img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
			img.scaleToFit(75, 65);
			// Notice the image added directly to the Paragraph
			p.add(img);
			document.add(p);

			com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "ESCUELA POLITÉCNICA NACIONAL";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);

			String cabeceraTabla1 = "\nSILABO \n\n ";

			tituloTablaAcad.setFont(fuente);
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			tituloTablaAcad.add(cabeceraTabla);
			tituloTablaAcad.add(cabeceraTabla1);
			document.add(tituloTablaAcad);

			PdfPTable datosPersonales = new PdfPTable(4);
			datosPersonales.setWidthPercentage(100);
			float[] columnWidths2 = new float[] { 50f, 70f, 30f, 30f };
			datosPersonales.setWidths(columnWidths2);
			datosPersonales.addCell(createLabelCell5("PERIODO ACTUAL:"));
			datosPersonales.addCell(createLabelCell6(pensumSelect.getMeses()));
			datosPersonales.addCell(createLabelCell5("Fecha :"));

			if (silaboselect.getFechaSilabo() == null) {
				datosPersonales.addCell(createLabelCell6(" "));
			} else {
				datosPersonales.addCell(createLabelCell6(silaboselect.getFechaSilabo().toString()));
			}
			datosPersonales.addCell(createLabelCell5("FACULTAD:"));
			datosPersonales.addCell(createLabelCell6(silaboselect.getFacultad()));

			datosPersonales.addCell(createLabelCell5(""));
			datosPersonales.addCell(createLabelCell6(""));

			datosPersonales.addCell(createLabelCell5("CARRERA"));
			datosPersonales.addCell(createLabelCell6(silaboselect.getCarrera()));
			datosPersonales.addCell(createLabelCell5(""));
			datosPersonales.addCell(createLabelCell6(""));
			document.add(datosPersonales);

			PdfPTable datosasignatura = new PdfPTable(2);
			datosasignatura.setWidthPercentage(100);
			float[] column = new float[] { 15f, 85f };
			datosasignatura.setWidths(column);
			datosasignatura.addCell(createLabelCell5("ASIGNATURA:"));
			datosasignatura.addCell(createLabelCell6(
					silaboselect.getCodigo() + "-" + silaboselect.getAsignatura() + "-" + silaboselect.getParalelo()));
			document.add(datosasignatura);

			Paragraph datosContrato = new Paragraph();
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.ITALIC);
			datosContrato.add("\n");
			datosContrato.setFont(fuente);
			// datosContrato.add(datosCont);
			document.add(datosContrato);
			Paragraph direccion = new Paragraph();
			String direccios = "\n INFORMACIÓN DEL DOCENTE";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			direccion.setFont(fuente);
			direccion.setAlignment(Element.ALIGN_JUSTIFIED);
			direccion.add(direccios);
			document.add(direccion);
			document.add(datosContrato);

			PdfPTable datosDdocente = new PdfPTable(2);
			datosDdocente.setWidthPercentage(100);
			float[] column1 = new float[] { 25f, 75f };
			datosDdocente.setWidths(column1);
			datosDdocente.addCell(createLabelCell3("Nombre"));
			datosDdocente.addCell(createLabelCell4(docSelect.getNombre() + " " + docSelect.getApel()));
			datosDdocente.addCell(createLabelCell3("Correo electrónico institucional"));
			datosDdocente.addCell(createLabelCell4(emp.getEmail1()));
			datosDdocente.addCell(createLabelCell3("Logros Académicos"));
			datosDdocente.addCell(createLabelCell4(silaboselect.getLogrosAcademicos()));
			datosDdocente.addCell(createLabelCell3("Logros Profesionales"));
			datosDdocente.addCell(createLabelCell4(silaboselect.getLogrosProfesionales()));
			document.add(datosDdocente);

			Paragraph curricular = new Paragraph();
			String infoC = "\n INFORMACIÓN CURRICULAR";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			curricular.setFont(fuente);
			curricular.setAlignment(Element.ALIGN_JUSTIFIED);
			curricular.add(infoC);
			document.add(curricular);
			document.add(datosContrato);

			PdfPTable datosCurricular = new PdfPTable(2);
			datosCurricular.setWidthPercentage(100);
			datosCurricular.addCell(createLabelCell3("EJE DE FORMACIÓN"));
			datosCurricular.addCell(createLabelCell4(silaboselect.getEje()));
			datosCurricular.addCell(createLabelCell3("Créditos / Horas Pensum"));
			datosCurricular.addCell(createLabelCell4(silaboselect.getCreditos()));
			datosCurricular.addCell(createLabelCell3("Tipo Materia"));
			datosCurricular.addCell(createLabelCell4(silaboselect.getTipoMateria()));
			datosCurricular.addCell(createLabelCell3("Categoría Materia"));
			datosCurricular.addCell(createLabelCell4(silaboselect.getCategoriaMateria()));
			datosCurricular.addCell(createLabelCell3("Asignatura Pre-Requisito"));
			datosCurricular
					.addCell(createLabelCell4(silaboselect.getPreReqNombre() + " " + silaboselect.getPreReqCodigo()));
			datosCurricular.addCell(createLabelCell3("Asignatura Co-Requisito"));
			datosCurricular.addCell(createLabelCell4(" "));
			document.add(datosCurricular);

			PdfPTable datosCurricular1 = new PdfPTable(4);
			datosCurricular1.setWidthPercentage(100);
			datosCurricular1.addCell(createLabelCell3("Horas semanales"));

			if (silaboselect.getHorSemTeoria() == null) {
				datosCurricular1.addCell(createLabelCell3("Teoría : " + "0"));

			} else {
				datosCurricular1.addCell(createLabelCell3("Teoría : " + silaboselect.getHorSemTeoria().toString()));
			}

			if (silaboselect.getHorSemPrac() == null) {
				datosCurricular1.addCell(createLabelCell3("Prácticas de laboratorio. Ejercicios : " + "0"));

			} else {
				datosCurricular1.addCell(createLabelCell3(
						"Prácticas de laboratorio. Ejercicios : " + silaboselect.getHorSemPrac().toString()));
			}

			if (silaboselect.getHorSemPrac() == null) {
				datosCurricular1.addCell(createLabelCell3("Actividades de Evaluación: " + "0"));

			} else {
				datosCurricular1.addCell(
						createLabelCell3("Actividades de Evaluación : " + silaboselect.getHorassemacti().toString()));
			}

			datosCurricular1.addCell(createLabelCell3("Total Horas/Semana/Semestre"));

			if (silaboselect.getTotalHorSema() == null) {
				datosCurricular1.addCell(createLabelCell3("Teoría : " + "0"));

			} else {
				datosCurricular1.addCell(createLabelCell3("Teoría : " + silaboselect.getTotalHorSema().toString()));
			}

			if (silaboselect.getToatlHorSemPract() == null) {
				datosCurricular1.addCell(createLabelCell3("Prácticas de laboratorio. Ejercicios : " + "0"));

			} else {
				datosCurricular1.addCell(createLabelCell3(
						"Prácticas de laboratorio. Ejercicios : " + silaboselect.getToatlHorSemPract().toString()));
			}

			if (silaboselect.getHorSemPrac() == null) {
				datosCurricular1.addCell(createLabelCell3("Actividades de Evaluación: " + "0"));

			} else {
				datosCurricular1.addCell(createLabelCell3(
						"Actividades de Evaluación : " + silaboselect.getToatlHorSemPract().toString()));
			}

			document.add(datosCurricular1);

			Paragraph resultadosA = new Paragraph();
			String resultA = "\n RESULTADOS DEL APRENDIZAJE DE LA ASIGNATURA (Acorde al PEA respectivo)";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			resultadosA.setFont(fuente);
			resultadosA.setAlignment(Element.ALIGN_JUSTIFIED);
			resultadosA.add(resultA);
			document.add(resultadosA);
			document.add(datosContrato);

			PdfPTable datosresultados = new PdfPTable(3);
			datosresultados.setWidthPercentage(100);
			float[] column2 = new float[] { 20f, 40f, 40f };
			datosresultados.setWidths(column2);

			datosresultados.addCell(createLabelCell("Tipo"));
			datosresultados.addCell(createLabelCell("Resultados del aprendizaje"));
			datosresultados.addCell(createLabelCell("Formas de evidenciar los Aprendizajes"));

			for (Resultado res : resultados) {
				datosresultados.addCell(createLabelCell4(res.getTipoBilbiografia()));
				datosresultados.addCell(createLabelCell4(res.getResultados()));
				datosresultados.addCell(createLabelCell4(res.getFormas()));

			}
			document.add(datosresultados);
			document.add(datosContrato);

			Paragraph publicaciones = new Paragraph();
			String pub = "\n CONTENIDO DE LA ASIGNATURA.\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			publicaciones.setFont(fuente);
			publicaciones.setAlignment(Element.ALIGN_JUSTIFIED);
			publicaciones.add(pub);
			document.add(publicaciones);
			document.add(datosContrato);

			PdfPTable datospublicaciones = new PdfPTable(3);
			datospublicaciones.setWidthPercentage(100);
			float[] columnWidthsins8 = new float[] { 10f, 45f, 45f };
			datospublicaciones.setWidths(columnWidthsins8);

			datospublicaciones.addCell(createLabelCell("Nro."));
			datospublicaciones.addCell(createLabelCell("Capítulo"));
			datospublicaciones.addCell(createLabelCell("Subcapítulo"));

			for (Capitulo cap : capitulos) {

				if (cap.getNumeroCap() == null) {

					datospublicaciones.addCell(createLabelCell4("0"));
				} else {
					datospublicaciones.addCell(createLabelCell4(cap.getNumeroCap().toString()));
				}

				datospublicaciones.addCell(createLabelCell4(cap.getNomCap()));

				if (cap.getSubcapitulos().size() > 0) {
					String sub = "";

					for (Subcapitulo subC : cap.getSubcapitulos()) {
						sub = sub + subC.getNombreCp() + "\n";

					}

					datospublicaciones.addCell(createLabelCell4(sub));

				}

				else {
					datospublicaciones.addCell(createLabelCell4(" "));

				}

			}

			document.add(datospublicaciones);

			document.add(datosContrato);
			Paragraph practica = new Paragraph();
			String ob = "\n PRÁCTICAS DE LABORATORIO/EJERCICIO \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			practica.setFont(fuente);
			practica.setAlignment(Element.ALIGN_LEFT);
			practica.add(ob);
			document.add(practica);
			document.add(datosContrato);

			PdfPTable datosObras = new PdfPTable(2);
			datosObras.setWidthPercentage(100);
			float[] column3 = new float[] { 30f, 70f };
			datosObras.setWidths(column3);

			datosObras.addCell(createLabelCell("Nombre"));
			datosObras.addCell(createLabelCell("Descripción"));

			for (PracticasLaboratorio pu : practicas) {
				datosObras.addCell(createLabelCell4(pu.getNombrePractica()));
				datosObras.addCell(createLabelCell4(pu.getDescPracticas()));
			}

			document.add(datosObras);

			document.add(datosContrato);

			document.add(datosContrato);
			Paragraph bilbio = new Paragraph();
			String b = "\n BIBLIOGRAFÍA BÁSICA \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			bilbio.setFont(fuente);
			bilbio.setAlignment(Element.ALIGN_LEFT);
			bilbio.add(b);
			document.add(bilbio);
			document.add(datosContrato);

			PdfPTable datosPatente = new PdfPTable(6);
			datosPatente.setWidthPercentage(100);

			datosPatente.addCell(createLabelCell("Título"));
			datosPatente.addCell(createLabelCell("Autor"));

			datosPatente.addCell(createLabelCell("Editorial"));
			datosPatente.addCell(createLabelCell("Año"));

			datosPatente.addCell(createLabelCell("ISBN"));
			datosPatente.addCell(createLabelCell("Edición"));

			for (Bibliografia bib : bibliografiaBasica) {
				datosPatente.addCell(createLabelCell4(bib.getTitulo()));
				datosPatente.addCell(createLabelCell4(bib.getAutor()));
				datosPatente.addCell(createLabelCell4(bib.getEditorial()));

				if (bib.getAno() == null) {
					datosPatente.addCell(createLabelCell4(""));
				}

				else {
					datosPatente.addCell(createLabelCell4(bib.getAno().toString()));
				}

				datosPatente.addCell(createLabelCell4(bib.getIsbn()));
				datosPatente.addCell(createLabelCell4(bib.getEdicion()));
			}

			document.add(datosPatente);
			document.add(datosContrato);

			Paragraph experiencia = new Paragraph();
			String exp = "\n BIBLIOGRAFÍA COMPLEMENTARIA \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			experiencia.setFont(fuente);
			experiencia.setAlignment(Element.ALIGN_JUSTIFIED);
			experiencia.add(exp);
			document.add(experiencia);

			document.add(datosContrato);

			PdfPTable datosPatente1 = new PdfPTable(6);
			datosPatente1.setWidthPercentage(100);
			datosPatente1.addCell(createLabelCell("Título"));
			datosPatente1.addCell(createLabelCell("Autor"));

			datosPatente1.addCell(createLabelCell("Editorial"));
			datosPatente1.addCell(createLabelCell("Año"));

			datosPatente1.addCell(createLabelCell("ISBN"));
			datosPatente1.addCell(createLabelCell("Edición"));

			for (Bibliografia bib : bibliografiaComplementaria) {
				datosPatente1.addCell(createLabelCell4(bib.getTitulo()));
				datosPatente1.addCell(createLabelCell4(bib.getAutor()));
				datosPatente1.addCell(createLabelCell4(bib.getEditorial()));

				if (bib.getAno() == null) {
					datosPatente1.addCell(createLabelCell4(""));
				}

				else {
					datosPatente1.addCell(createLabelCell4(bib.getAno().toString()));
				}

				datosPatente1.addCell(createLabelCell4(bib.getIsbn()));
				datosPatente1.addCell(createLabelCell4(bib.getEdicion()));
			}

			document.add(datosPatente1);
			document.add(datosContrato);

			Paragraph proyectos = new Paragraph();
			String proy = "\n METODOLOGÍA DE ENSEÑANZA-APRENDIZAJE\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			proyectos.setFont(fuente);
			proyectos.setAlignment(Element.ALIGN_JUSTIFIED);
			proyectos.add(proy);
			document.add(proyectos);

			document.add(datosContrato);

			PdfPTable datosProy = new PdfPTable(3);
			datosProy.setWidthPercentage(100);
			datosProy.addCell(createLabelCell("Método de enseñanza aprendizaje"));
			datosProy.addCell(createLabelCell("Recursos didácticos"));
			datosProy.addCell(createLabelCell("Escenarios de enseñanza-aprendizaje"));

			for (MetodologiaDeEnsenanza act : metodologias) {

				datosProy.addCell(createLabelCell4(act.getMetodoEnsenanza()));
				datosProy.addCell(createLabelCell4(act.getRecursos()));
				datosProy.addCell(createLabelCell4(act.getEscenarios()));

			}

			document.add(datosProy);

			document.add(datosContrato);

			Paragraph tesis = new Paragraph();
			String te = "\n EVALUACIÓN \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tesis.setFont(fuente);
			tesis.setAlignment(Element.ALIGN_LEFT);
			tesis.add(te);
			document.add(tesis);

			document.add(datosContrato);

			PdfPTable datosTesis = new PdfPTable(4);
			datosTesis.setWidthPercentage(100);
			float[] column4 = new float[] { 35f, 35f, 15f, 15f };
			datosTesis.setWidths(column4);
			datosTesis.addCell(createLabelCell("Elemento de evaluación"));
			datosTesis.addCell(createLabelCell("Descripción del elemto de evaluación"));
			datosTesis.addCell(createLabelCell("% Nota Bimestre I"));
			datosTesis.addCell(createLabelCell("% Nota Bimestre II"));

			for (Evaluacion tes : evaluaciones) {

				datosTesis.addCell(createLabelCell4(tes.getElemento()));
				datosTesis.addCell(createLabelCell4(tes.getDescEval()));
				if (tes.getPorcenNotaBim() == null) {
					datosTesis.addCell(createLabelCell4(""));
				} else {
					datosTesis.addCell(createLabelCell4(tes.getPorcenNotaBim().toString()));
				}

				if (tes.getPorcenNotaBim2() == null) {
					datosTesis.addCell(createLabelCell4(""));
				} else {
					datosTesis.addCell(createLabelCell4(tes.getPorcenNotaBim2().toString()));
				}
			}
			document.add(datosTesis);

			document.add(datosContrato);

			Paragraph experienciaDoc = new Paragraph();
			String ex = "\n ACTIVIDADES DE VINCULACIÓN CON LA COLECTIVIDAD\n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			experienciaDoc.setFont(fuente);
			experienciaDoc.setAlignment(Element.ALIGN_JUSTIFIED);
			experienciaDoc.add(ex);
			document.add(experienciaDoc);
			document.add(datosContrato);
			PdfPTable datosEPN = new PdfPTable(2);
			datosEPN.setWidthPercentage(100);
			float[] column5 = new float[] { 20f, 80f };
			datosEPN.setWidths(column5);
			datosEPN.addCell(createLabelCell("Actividad"));
			datosEPN.addCell(createLabelCell("Descripción"));
			for (ActividadesVinculacion nomb : actividades) {
				datosEPN.addCell(createLabelCell4(nomb.getActividad()));
				datosEPN.addCell(createLabelCell4(nomb.getDesAct()));
			}
			document.add(datosEPN);
			document.add(datosContrato);
			Paragraph externa = new Paragraph();
			String exter = "\n CRONOGRAMA DE DESARROLLO DEL CURSO \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			externa.setFont(fuente);
			externa.setAlignment(Element.ALIGN_LEFT);
			externa.add(exter);
			document.add(externa);

			document.add(datosContrato);

			PdfPTable datosExpExt = new PdfPTable(7);
			datosExpExt.setWidthPercentage(100);
			float[] column6 = new float[] { 5f, 8f, 8f, 8f, 31f, 20f, 20f };
			datosExpExt.setWidths(column6);

			datosExpExt.addCell(createLabelCell("Nro."));
			datosExpExt.addCell(createLabelCell("Fecha"));
			datosExpExt.addCell(createLabelCell("Hora1"));
			datosExpExt.addCell(createLabelCell("Hora2"));

			datosExpExt.addCell(createLabelCell("Capítulo/Subcapítulo"));
			datosExpExt.addCell(createLabelCell("Tema"));
			datosExpExt.addCell(createLabelCell("Detalle de actividades de aprendizaje y de evaluación"));

			for (CronogramaDesarrollo expExt : cronograma) {

				if (expExt.getNumCronograma() == null) {
					datosExpExt.addCell(createLabelCell4(""));
				} else {
					datosExpExt.addCell(createLabelCell4(expExt.getNumCronograma().toString()));

				}

				if (expExt.getFechaCrono() == null) {
					datosExpExt.addCell(createLabelCell4(""));

				} else {

					datosExpExt.addCell(createLabelCell4(expExt.getFechaCrono().toString()));

				}

				datosExpExt.addCell(createLabelCell4(expExt.getHora1()));
				datosExpExt.addCell(createLabelCell4(expExt.getHora2()));

				if (expExt.getCronoSubcapitulo().size() > 0) {
					String org = " ";

					System.out.println("Tamañ0" + expExt.getCronoSubcapitulo().size());

					for (int i = 0; i < expExt.getCronoSubcapitulo().size(); i++) {
						org += expExt.getCronoSubcapitulo().get(i).getSubcapitulo().getCapitulo().getNomCap() + " - "
								+ expExt.getCronoSubcapitulo().get(i).getSubcapitulo().getNombreCp() + "\n";

					}
					datosExpExt.addCell(createLabelCell4(org));
				} else {
					datosExpExt.addCell(createLabelCell4(" "));
				}

				datosExpExt.addCell(createLabelCell4(expExt.getTema()));
				datosExpExt.addCell(createLabelCell4(expExt.getDetalle()));

			}

			document.add(datosExpExt);

			Paragraph revalorizacion = new Paragraph();
			String rev = "\n UBICACIÓN Y HORARIOS DE USO DE AULAS Y LABORATORIOS ";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			revalorizacion.setFont(fuente);
			revalorizacion.setAlignment(Element.ALIGN_JUSTIFIED);
			revalorizacion.add(rev);
			document.add(revalorizacion);

			document.add(datosContrato);

			PdfPTable ubicacion = new PdfPTable(4);
			ubicacion.setWidthPercentage(100);

			ubicacion.addCell(createLabelCell("Horario"));
			ubicacion.addCell(createLabelCell("Aula"));
			ubicacion.addCell(createLabelCell("Ubicación"));
			ubicacion.addCell(createLabelCell("Función"));

			for (UbicacionHorario nomb : ubicaciones) {

				ubicacion.addCell(createLabelCell4(nomb.getHorario()));
				ubicacion.addCell(createLabelCell4(nomb.getAula()));
				ubicacion.addCell(createLabelCell4(nomb.getUbicacion()));
				ubicacion.addCell(createLabelCell4(nomb.getFuncion()));

			}
			document.add(ubicacion);

			document.add(datosContrato);

			Paragraph poli = new Paragraph();
			String pol = "\n POLÍTICAS DE DESARROLLO DEL CURSO";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			poli.setFont(fuente);
			poli.setAlignment(Element.ALIGN_JUSTIFIED);
			poli.add(pol);
			document.add(poli);

			document.add(datosContrato);

			PdfPTable polit = new PdfPTable(2);
			polit.setWidthPercentage(100);
			float[] column7 = new float[] { 20f, 80f };
			polit.setWidths(column7);

			polit.addCell(createLabelCell("Política"));
			polit.addCell(createLabelCell("Descripción"));

			for (PiliticasDesarrollo nomb : politicas) {
				polit.addCell(createLabelCell4(nomb.getPolitica()));
				polit.addCell(createLabelCell4(nomb.getDescPolitica()));
			}
			document.add(polit);

			document.add(datosContrato);

			Paragraph codigo = new Paragraph();
			String etica = "CÓDIGO DE ÉTICA EPN";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			codigo.setFont(fuente);
			codigo.setAlignment(Element.ALIGN_JUSTIFIED);
			codigo.add(etica);
			document.add(codigo);

			document.add(datosContrato);

			Paragraph horas = new Paragraph();
			String horasmet = "La tradición y el prestigio de la Politécnica exigen que el comportamiento de sus miembros se encuadre en el respeto mutuo, la honestidad, el apego a la verdad y el compromiso con la institución. "
					+ "\n";
			String horascap = "Con tal antecedente, el presente Código de Ética define la norma de conducta de los miembros de la Escuela Politécnica Nacional:"
					+ "";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			horas.setFont(fuente);
			horas.setAlignment(Element.ALIGN_JUSTIFIED);
			horas.add(horasmet);
			horas.add(horascap);
			document.add(horas);

			document.add(datosContrato);

			Paragraph respeto = new Paragraph();
			String res = "RESPETO HACIA SÍ MISMO Y HACIA LOS DEMÁS";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
			respeto.setFont(fuente);
			respeto.setAlignment(Element.ALIGN_JUSTIFIED);
			respeto.add(res);
			document.add(respeto);

			document.add(datosContrato);

			com.itextpdf.text.List resp = new com.itextpdf.text.List();

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

			ListItem itemPais0 = new ListItem("Fomentar la solidaridad entre los miembros de la comunidad. ", fuente);
			ListItem itemPais1 = new ListItem(
					"Comportarse de manera recta, que afirme la autoestima y contribuya al prestigio institucional, que sea ejemplo y referente para los demás.",
					fuente);
			ListItem itemPais2 = new ListItem(
					"Respetar a los demás y en particular la honra ajena y rechazar todo tipo de acusaciones o denuncias infundadas",
					fuente);
			ListItem itemPais3 = new ListItem("Respetar el pensamiento, visión y criterio ajenos.", fuente);
			ListItem itemPais4 = new ListItem("Excluir toda forma de violencia y actitudes discriminatorias.", fuente);
			ListItem itemPais5 = new ListItem("Apoyar un ambiente pluralista y respetuoso de las diferencias.", fuente);
			ListItem itemPais6 = new ListItem("Convertir la puntualidad en norma de conducta", fuente);
			ListItem itemPais7 = new ListItem(
					"Evitar el consumo de bebidas alcohólicas, tabaco, substancias psicotrópicas o estupefacientes.",
					fuente);

			resp.add(itemPais0);
			resp.add(itemPais1);
			resp.add(itemPais2);
			resp.add(itemPais3);
			resp.add(itemPais4);
			resp.add(itemPais5);
			resp.add(itemPais6);
			resp.add(itemPais7);

			document.add(resp);

			document.add(datosContrato);

			Paragraph honestidad = new Paragraph();
			String hon = "HONESTIDAD";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
			honestidad.setFont(fuente);
			honestidad.setAlignment(Element.ALIGN_JUSTIFIED);
			honestidad.add(hon);
			document.add(honestidad);

			document.add(datosContrato);
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

			com.itextpdf.text.List h = new com.itextpdf.text.List();

			ListItem h1 = new ListItem(
					"Hacer de la honestidad el principio básico de comportamiento en todos los actos. ", fuente);
			ListItem h2 = new ListItem("Actuar con justicia, probidad y diligencia.", fuente);
			ListItem h3 = new ListItem(
					"Actuar de acuerdo a la conciencia, sin que presiones o aspiraciones particulares vulneren los intereses institucionales. ",
					fuente);
			ListItem h4 = new ListItem(
					"Velar por el cumplimiento de las garantías, derechos y deberes de los miembros de la Comunidad Politécnica",
					fuente);
			ListItem h5 = new ListItem(
					"Tomar oportunamente las medidas correctivas necesarias para superar las irregularidades que pudieren ocurrir.",
					fuente);

			h.add(h1);
			h.add(h2);
			h.add(h3);
			h.add(h4);
			h.add(h5);

			document.add(h);

			document.add(datosContrato);

			Paragraph verdad = new Paragraph();
			String ver = "\n VERDAD  \n ";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
			verdad.setFont(fuente);
			verdad.setAlignment(Element.ALIGN_JUSTIFIED);
			verdad.add(ver);
			document.add(verdad);

			document.add(datosContrato);

			com.itextpdf.text.List v = new com.itextpdf.text.List();
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

			ListItem v1 = new ListItem(
					"Hacer una mística de la prosecución de la verdad, tanto en la actividad académica como en lo cotidiano.",
					fuente);
			ListItem v2 = new ListItem("Informar con transparencia y en forma completa.", fuente);
			ListItem v3 = new ListItem("Emitir mensajes con autenticidad, que no distorsionen eventos ni realidades",
					fuente);

			v.add(v1);
			v.add(v2);
			v.add(v3);

			document.add(v);

			document.add(datosContrato);

			Paragraph compromiso = new Paragraph();
			String com = "\n COMPROMISO CON LA INSTITUCIÓN  \n ";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
			compromiso.setFont(fuente);
			compromiso.setAlignment(Element.ALIGN_JUSTIFIED);
			compromiso.add(com);
			document.add(compromiso);

			document.add(datosContrato);

			com.itextpdf.text.List c = new com.itextpdf.text.List();
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

			ListItem c1 = new ListItem("Ser leal a la Politécnica y a los valores institucionales", fuente);
			ListItem c2 = new ListItem(
					"Cumplir las normas constitucionales, legales, estatutarias, reglamentarias y las resoluciones de la autoridad legítimamente designada.",
					fuente);
			ListItem c3 = new ListItem("Reconocer y aceptar las consecuencias de las decisiones.", fuente);
			ListItem c4 = new ListItem(
					"Participar activamente en la vida y en la dirección de la institución, de acuerdo a los mecanismos de participación, aportando proactivamente con iniciativas de mejoramiento institucional y mantenerse informado",
					fuente);
			ListItem c5 = new ListItem(
					"Emplear los recursos institucionales con austeridad, de acuerdo a los fines correspondientes. ",
					fuente);
			ListItem c6 = new ListItem(" Contribuir al ornato y limpieza de nuestra Casa de Estudios.", fuente);

			c.add(c1);
			c.add(c2);
			c.add(c3);
			c.add(c4);
			c.add(c5);
			c.add(c6);

			document.add(v);

			document.add(datosContrato);
			document.add(datosContrato);

			fechas(silaboselect.getFechaSilabo());

			PdfPTable firmas = new PdfPTable(4);
			firmas.setWidthPercentage(100);

			firmas.addCell(createLabelCell5("FECHA DE ELABORACIÓN"));
			firmas.addCell(createLabelCell6(dia + "/" + mes + "/" + anioo));

			firmas.addCell(createLabelCell5("FIRMA DEL DOCENTE"));
			firmas.addCell(createLabelCell6("_______________________"));

			document.add(firmas);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
		Image img = Image.getInstance(path);
		img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		if (path.contains("150")) {
			img.scaleToFit(70, 70);
		} else {

			img.scaleToFit(40, 40);
		}

		PdfPCell cell = new PdfPCell(img, false);
		cell.setBorder(Rectangle.NO_BORDER);
		return cell;
	}

	public static PdfPCell createImageCell1(String path) throws DocumentException, IOException {
		Image img = Image.getInstance(path);
		img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);

		img.scaleToFit(70, 70);

		PdfPCell cell = new PdfPCell(img, false);
		cell.setBorder(Rectangle.NO_BORDER);
		return cell;
	}

	public String generarPdfInvestifacionReporte(List<EquipoProyectoDTO> recursos, List<Lineasproy> lineas,
			ProyectoP proyecto, List<Objetivoavance> objetivos, CierrePeriodo cierre,
			List<Cronogramaavance> actividades, String pathDocs, RecursohPr director, Pensum periodo, String sigla,
			Emp jefeDep, Dep dep, String firmaJD, String firmaDr, List<Producto> presentaciones,
			List<Producto> pubRegionales, List<Producto> pubMemorias, List<Producto> pubReportTecnico,
			List<Producto> pubDifusion, List<Producto> tesisproyecto, List<Producto> pubProyM, List<Producto> pubPat,
			List<Producto> pubLib, List<Producto> pubCap, List<Producto> pubOtros, List<Producto> pubScopus,
			List<Proyectocarrera> carreras, List<EquipoProyectoDTO> estudiantes) {
		String url = "";
		try {

			System.out.println("Entro a crear archivo");
			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo

			FileOutputStream outputStream = new FileOutputStream(
					new File(pathDocs + "/" + proyecto.getCodigoPr().trim() + "-IA-" + periodo.getMeses() + ".pdf"));

			url = pathDocs + "/" + proyecto.getCodigoPr().trim() + "-IA-" + periodo.getMeses() + ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph datosContrato = new Paragraph();
			datosContrato.add("\n");

			PdfPTable cabecera = new PdfPTable(3);
			cabecera.setWidthPercentage(100);
			float[] columnWidthsCabecera = new float[] { 15f, 70f, 15f };
			cabecera.setWidths(columnWidthsCabecera);

			System.out.println("Se agrego la cabecera");

			cabecera.addCell(createImageCell(pathDocs + "/logo_epn.jpg"));
			cabecera.addCell(createLabelCabecera(
					"ESCUELA POLITECNICA NACIONAL\nVICERRECTORADO DE INVESTIGACIÓN, INNOVACIÓN Y VINCULACIÓN\nDIRECCIÓN DE INVESTIGACIÓN "));
			cabecera.addCell(createImageCell(pathDocs + "/150.png"));
			document.add(cabecera);

			com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 8, Font.BOLD);
			fuente.setSize(8);

			com.itextpdf.text.Font fuenteContenido = FontFactory.getFont("Arial", 8);
			fuenteContenido.setSize(8);

			com.itextpdf.text.Font fuenteLeyenda = FontFactory.getFont("Arial", 10, Font.BOLD);
			fuenteContenido.setSize(8);

			document.add(datosContrato);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "INFORME DE AVANCE DE PROYECTO DE INVESTIGACIÓN";
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			com.itextpdf.text.Font fuenteCabecera = FontFactory.getFont("Arial", 12, Font.BOLD);
			tituloTablaAcad.setFont(fuenteCabecera);

			tituloTablaAcad.add(cabeceraTabla);

			document.add(tituloTablaAcad);

			document.add(datosContrato);

			PdfPTable tablageneral = new PdfPTable(4);
			PdfPCell cell;
			tablageneral.setWidthPercentage(100);
			float[] columnWidthsdept = new float[] { 20f, 60f, 20f, 20f };
			tablageneral.setWidths(columnWidthsdept);
			cell = new PdfPCell(new Phrase("Departamento", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablageneral.addCell(cell);
			cell = new PdfPCell(new Phrase(dep.getNomDep() + "-" + dep.getSigla(), fuenteContenido));
			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Codigo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Periodo Académico", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			tablageneral.addCell(new Phrase(proyecto.getCodigoPr(), fuenteContenido));
			tablageneral.addCell(new Phrase(periodo.getMeses(), fuenteContenido));

			cell = new PdfPCell(new Phrase("Título del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getNombrePr(), fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Línea/s de investigación", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			String linea = "";
			for (Lineasproy lin : lineas) {
				linea += lin.getLineas().getNomLinin() + "  ";
			}
			cell = new PdfPCell(new Phrase(linea, fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablageneral.addCell(cell);

				String carrera = "";
				for (Proyectocarrera car : carreras) {
					carrera += car.getNombre() + "  ";
				}
				cell = new PdfPCell(new Phrase(carrera, fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase("Organización Colaboradora", fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase(proyecto.getBeneficiarioPr(), fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

			}

			document.add(tablageneral);

			////////////////////// tabla equipo del
			////////////////////// proyecto////////////////////////

			PdfPTable tablaLeyedanda = new PdfPTable(1);
			tablaLeyedanda.setWidthPercentage(100);
			float[] columnWidthLey = new float[] { 100f };
			tablaLeyedanda.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("A1. EQUIPO DE TRABAJO DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedanda.addCell(cell);
			document.add(tablaLeyedanda);
			
			PdfPTable tablaEquipoP = new PdfPTable(6);

			tablaEquipoP.setWidthPercentage(100);
			float[] columnWidthEqp = new float[] { 20f, 30f, 15f, 15f, 10f, 10f };
			tablaEquipoP.setWidths(columnWidthEqp);
			cell = new PdfPCell(new Phrase("Equipo de trabajo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Dpto.", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Cargo actual en la EPN", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Planificadas", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Reportadas", fuente));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			tablaEquipoP.addCell(cell);

			for (EquipoProyectoDTO rec : recursos) {
				cell = new PdfPCell(new Phrase(rec.getRol(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getNombres(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getDepar(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getCargo(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getHplanif().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getHreport().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);
			}

			document.add(tablaEquipoP);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				////////////////////// tabla equipo del
				////////////////////// proyecto////////////////////////

				PdfPTable tablaLeyedandaE = new PdfPTable(1);
				tablaLeyedandaE.setWidthPercentage(100);
				
				tablaLeyedandaE.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("A2. ESTUDIANTES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(83, 141, 213));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaE.addCell(cell);
				document.add(tablaLeyedandaE);
				
				PdfPTable tablaEstud = new PdfPTable(7);

				tablaEstud.setWidthPercentage(100);
				float[] columnWidthest1 = new float[] { 20f, 20f, 20f, 10f, 10f, 10f, 10f };
				tablaEstud.setWidths(columnWidthest1);

				cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Cédula.", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Vinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Desvinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Horas Pnalificadas\n" + periodo.getMeses(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Horas Repostadas\n" + periodo.getMeses(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEstud.addCell(cell);

				for (EquipoProyectoDTO avac : estudiantes) {
					cell = new PdfPCell(new Phrase(avac.getNombres(), fuente));

					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getCargo(), fuenteContenido));
					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getDepar(), fuenteContenido));
					tablaEstud.addCell(cell);

					if (avac.getFvincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(new Phrase(avac.getFvincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					if (avac.getFdesvincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(new Phrase(avac.getFdesvincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(avac.getHplanif().toString(), fuenteContenido));
					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getHreport().toString(), fuenteContenido));
					tablaEstud.addCell(cell);

				}

				document.add(tablaEstud);
			}

			PdfPTable tablaLeyedandaO = new PdfPTable(1);
			tablaLeyedandaO.setWidthPercentage(100);
			
			tablaLeyedandaO.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("B. OBJETIVOS DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaO.addCell(cell);
			document.add(tablaLeyedandaO);

			//////////////////// OBJETIVO GENERAL

			PdfPTable tablaObjGeneral = new PdfPTable(2);

			tablaObjGeneral.setWidthPercentage(100);
			float[] columnWidthObjG = new float[] { 30f, 70f };
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Objetivo General", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjGeneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getObjetivos(), fuenteContenido));

			tablaObjGeneral.addCell(cell);

			document.add(tablaObjGeneral);

			PdfPTable tablaObjEsp = new PdfPTable(4);

			tablaObjEsp.setWidthPercentage(100);
			float[] columnWidthObjEsp = new float[] { 5f, 40f, 45f, 10f };
			tablaObjEsp.setWidths(columnWidthObjEsp);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Objetivos Específicos", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Resultados Obtenidos", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("% Avance Acumulado al  \n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			for (int i = 0; i < objetivos.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getObjetivo().getDetalle(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getResultado(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getAvance().toString(), fuenteContenido));
				tablaObjEsp.addCell(cell);

			}

			document.add(tablaObjEsp);

			PdfPTable tablaObjGeneralPorcen = new PdfPTable(2);
			tablaObjGeneralPorcen.setWidthPercentage(100);
			tablaObjGeneral.setWidths(columnWidthObjG);
			cell = new PdfPCell(new Phrase("Porcentaje Total de Avance Acumulado del Proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjGeneralPorcen.addCell(cell);
			cell = new PdfPCell(new Phrase(cierre.getAvance().toString(), fuenteContenido));
			tablaObjGeneralPorcen.addCell(cell);
			document.add(tablaObjGeneralPorcen);

			///////// TABLA CRONOGRAMA///////////////////////////////

			PdfPTable tablaLeyedandaCrono = new PdfPTable(1);
			tablaLeyedandaCrono.setWidthPercentage(100);

			tablaLeyedandaCrono.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("C. CRONOGRAMA DE AVANCE DEL PROYECTO EN EL PERIODO " + cierre.getMeses(),
					fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaCrono.addCell(cell);
			document.add(tablaLeyedandaCrono);

			PdfPTable tablaActividades = new PdfPTable(8);

			tablaActividades.setWidthPercentage(100);
			float[] columnWidtAct = new float[] { 5f, 65f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaActividades.setWidths(columnWidtAct);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Actividades", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Meses", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setColspan(6);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("M1", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M2", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M3", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M4", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M5", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M6", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);

			for (int i = 0; i < actividades.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getCronograma().getNombreCr(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM12(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM34(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM56(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM78(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM910(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM1112(), fuenteContenido));
				tablaActividades.addCell(cell);

			}

			document.add(tablaActividades);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaComoCadena = sdf.format(new Date());

			///////// TABLA PRODUCTOS///////////////////////////////

			PdfPTable tablaLeyedandaProducto = new PdfPTable(1);
			tablaLeyedandaProducto.setWidthPercentage(100);
			tablaLeyedandaProducto.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase(
					"PRODUCTOS GENERADOS DURANTE EL PERIODO ACADÉMICO " + periodo.getMeses() + "\n", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaProducto.addCell(cell);
			document.add(tablaLeyedandaProducto);

			if (presentaciones.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoPUBLICACIONES = new PdfPTable(1);
				tablaLeyedandaProductoPUBLICACIONES.setWidthPercentage(100);
				tablaLeyedandaProductoPUBLICACIONES.setWidths(columnWidthLey);
				cell = new PdfPCell(
						new Phrase("A. PRESENTACIONES EN EVENTOS (NACIONALES O INTERNACIONALES)", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoPUBLICACIONES.addCell(cell);
				document.add(tablaLeyedandaProductoPUBLICACIONES);

				PdfPTable tablapUB = new PdfPTable(8);
				tablapUB.setWidthPercentage(100);
				float[] columnWidtpUB = new float[] { 5f, 15f, 15f, 15f, 15f, 15f, 10F, 10F };
				tablapUB.setWidths(columnWidtpUB);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);
				cell = new PdfPCell(new Phrase("Título", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Expositor", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("País", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Ciudad", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				for (int i = 0; i < presentaciones.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getTipopresentacion(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getTitulo(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getExpositor(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getEvento(), fuenteContenido));
					tablapUB.addCell(cell);
					cell = new PdfPCell(new Phrase(presentaciones.get(i).getLugar(), fuenteContenido));
					tablapUB.addCell(cell);
					cell = new PdfPCell(new Phrase(presentaciones.get(i).getCarrera(), fuenteContenido));
					tablapUB.addCell(cell);

					if (presentaciones.get(i).getAnio() != null && presentaciones.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(presentaciones.get(i).getMes().toString() + "-"
								+ presentaciones.get(i).getAnio().toString(), fuenteContenido));
						tablapUB.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapUB.addCell(cell);
					}

				}
				document.add(tablapUB);

			}

			if (pubScopus.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.1 PUBLICACIONES EN SCOPUS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(5);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 30f, 25f, 20f, 20f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubScopus.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubScopus.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubScopus.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubScopus.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubScopus.get(i).getFechapresenta() != null) {
						cell = new PdfPCell(
								new Phrase(sdf.format(pubScopus.get(i).getFechapresenta()), fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubScopus.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubRegionales.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.2 PUBLICACIONES REGIONALES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Indexación de la revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubRegionales.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubRegionales.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubRegionales.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubRegionales.get(i).getAnio() != null && pubRegionales.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(pubRegionales.get(i).getMes().toString() + "-"
								+ pubRegionales.get(i).getAnio().toString(), fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubMemorias.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.3 MEMORIAS DE EVENTOS ACADÉMICOS REGIONALES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(7);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 15f, 10f, 10f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del evento académico", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("País", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Ciudad", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubMemorias.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubMemorias.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubMemorias.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubMemorias.get(i).getAnio() != null && pubMemorias.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubMemorias.get(i).getMes().toString() + "-" + pubMemorias.get(i).getAnio().toString(),
								fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getLugar(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getExpositor(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubReportTecnico.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("C REPORTES TÉCNICOS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(5);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del artículo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Estado", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubReportTecnico.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getAutorexterno(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getEstado(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubDifusion.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("D. DIFUSIÓN A LA COMUNIDAD POLITÉCNICA", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la difusión", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Expositor", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubDifusion.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getEstado(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getExpositor(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubDifusion.get(i).getAnio() != null && pubDifusion.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubDifusion.get(i).getMes().toString() + "-" + pubDifusion.get(i).getAnio().toString(),
								fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

				}
				document.add(tablappON);

			}

			if (tesisproyecto.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(
						new Phrase("E. PROYECTO DE TITULACIÓN DE PREGRADO / TESIS DE POSGRADO", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(5);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 30f, 25f, 20f, 20f };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del proyecto de titulación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Estudiante(s)", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera/Programa", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Estado", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < tesisproyecto.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getEstuadiante(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getCarrera(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getEstado(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubProyM.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("F. PLANTEAMIENTO DE UN PROYECTO DE MAYOR ALCANCE", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(4);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 45f, 30f, 20f };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Título", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de proyecto de la EPN o Externo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Institución que financia", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubProyM.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getTipopresentacion(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getExpositor(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubPat.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("G. PATENTE", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(6);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 20f, 20f, 20f, 20, 15 };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Denominación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de activo intangible", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de ingreso a trámite", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de registro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Código SENADI", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubPat.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubPat.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubPat.get(i).getEvento(), fuenteContenido));
					tablapTES.addCell(cell);

					if (pubPat.get(i).getFechaingreso() != null) {
						cell = new PdfPCell(new Phrase(sdf.format(pubPat.get(i).getFechaingreso()), fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					if (pubPat.get(i).getFechapresenta() != null) {
						cell = new PdfPCell(new Phrase(sdf.format(pubPat.get(i).getFechapresenta()), fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubPat.get(i).getVolumen(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubLib.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("H.1 LIBROS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del libro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Link de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("ISBN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubLib.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubLib.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubLib.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubLib.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubLib.get(i).getAnio() != null && pubLib.get(i).getMes() != null) {
						cell = new PdfPCell(
								new Phrase(pubLib.get(i).getMes().toString() + "-" + pubLib.get(i).getAnio().toString(),
										fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubLib.get(i).getUrl(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubLib.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubCap.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("H.2 CAPÍTULO DE LIBRO", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(7);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 15f, 15f, 15f, 15f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del libro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del capítulo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Link de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("ISBN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubCap.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubCap.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubCap.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubCap.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);
					cell = new PdfPCell(new Phrase(pubCap.get(i).getCarrera(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubCap.get(i).getAnio() != null && pubCap.get(i).getMes() != null) {
						cell = new PdfPCell(
								new Phrase(pubCap.get(i).getMes().toString() + "-" + pubCap.get(i).getAnio().toString(),
										fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubCap.get(i).getUrl(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubCap.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubOtros.size() > 0) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);

				if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {
					cell = new PdfPCell(new Phrase("A. PRODUCTOS", fuenteLeyenda));
				}

				else {
					cell = new PdfPCell(new Phrase("I. OTROS", fuenteLeyenda));
				}

				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(5);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 20f, 20f, 20f, 35 };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del producto", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Responsable", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha ", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Observaciones", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubOtros.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getAutorexterno(), fuenteContenido));
					tablapTES.addCell(cell);

					if (pubOtros.get(i).getAnio() != null && pubOtros.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubOtros.get(i).getMes().toString() + "-" + pubOtros.get(i).getAnio().toString(),
								fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getEvento(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			PdfPTable tablaFirma = new PdfPTable(4);

			tablaFirma.setWidthPercentage(100);
			float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			tablaFirma.setWidths(columnWidtFir);

			cell = new PdfPCell(new Phrase("Firma del director del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (firmaDr == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathDocs + "/" + firmaDr);
			}

			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Firma del jefe de departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (firmaJD == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathDocs + "/" + firmaJD);
			}
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase(
					"Nombre del Director:" + director.getApellidoPersonalPr() + "-" + director.getNombrePersonalPr(),
					fuenteContenido));
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Nombre del Jefe Dept.: " + jefeDep.getApel() + " " + jefeDep.getNom(),
					fuenteContenido));

			tablaFirma.addCell(cell);

			document.add(tablaFirma);

			fechaComoCadena = "";
			String fechaComoCadena1 = "";

			if (cierre.getFechacierredocente() == null) {
				fechaComoCadena = "Sin envío JD.";

			} else {
				fechaComoCadena = sdf.format(cierre.getFechacierredocente());
			}

			if (cierre.getFechacierrejd() == null) {
				fechaComoCadena1 = "Sin envío DI.";

			} else {
				fechaComoCadena1 = sdf.format(cierre.getFechacierrejd());
			}

			Paragraph ingreso = new Paragraph();
			String ing = "\n Fecha envío Jefe Departamento: " + fechaComoCadena;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso.setFont(fuente);
			ingreso.setAlignment(Element.ALIGN_LEFT);
			ingreso.add(ing);

			document.add(ingreso);

			Paragraph ingreso2 = new Paragraph();
			String ing2 = "\n Fecha envío a la DIrección de Investigación: " + fechaComoCadena1;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso2.setFont(fuente);
			ingreso2.setAlignment(Element.ALIGN_LEFT);
			ingreso2.add(ing2);

			document.add(ingreso2);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			System.out.println("cerre el documento");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfInvestifacionReporteUpdate(List<EquipoProyectoDTO> recursos, List<Lineasproy> lineas,
			ProyectoP proyecto, List<Objetivoavance> objetivos, CierrePeriodo cierre,
			List<Cronogramaavance> actividades, String pathDocs, RecursohPr director, Pensum periodo, String sigla,
			Emp jefeDep, Dep dep, String firmaJD, String firmaDr, Integer idversion, List<Producto> presentaciones,
			List<Producto> pubRegionales, List<Producto> pubMemorias, List<Producto> pubReportTecnico,
			List<Producto> pubDifusion, List<Producto> tesisproyecto, List<Producto> pubProyM, List<Producto> pubPat,
			List<Producto> pubLib, List<Producto> pubCap, List<Producto> pubOtros, List<Producto> pubScopus) {
		String url = "";
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			System.out.println("Entro a crear archivo");
			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo

			FileOutputStream outputStream = new FileOutputStream(new File(pathDocs + "/" + proyecto.getCodigoPr().trim()
					+ "-" + periodo.getMeses() + "-" + sigla + idversion + "V2.pdf"));

			url = pathDocs + "/" + proyecto.getCodigoPr().trim() + "-" + periodo.getMeses() + "-" + sigla + idversion
					+ "V2.pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph datosContrato = new Paragraph();
			datosContrato.add("\n");

			PdfPTable cabecera = new PdfPTable(3);
			cabecera.setWidthPercentage(100);
			float[] columnWidthsCabecera = new float[] { 15f, 70f, 15f };
			cabecera.setWidths(columnWidthsCabecera);

			System.out.println("Se agrego la cabecera");

			cabecera.addCell(createImageCell(pathDocs + "/logo_epn.jpg"));
			cabecera.addCell(createLabelCabecera(
					"ESCUELA POLITECNICA NACIONAL\nVICERRECTORADO DE INVESTIGACIÓN, INNOVACIÓN Y VINCULACIÓN\nDIRECCIÓN DE INVESTIGACIÓN "));
			cabecera.addCell(createImageCell(pathDocs + "/150.png"));
			document.add(cabecera);

			com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 8, Font.BOLD);
			fuente.setSize(8);

			com.itextpdf.text.Font fuenteContenido = FontFactory.getFont("Arial", 8);
			fuenteContenido.setSize(8);

			com.itextpdf.text.Font fuenteLeyenda = FontFactory.getFont("Arial", 10, Font.BOLD);
			fuenteContenido.setSize(8);

			document.add(datosContrato);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "INFORME DE AVANCE DE PROYECTO DE INVESTIGACIÓN";
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			com.itextpdf.text.Font fuenteCabecera = FontFactory.getFont("Arial", 12, Font.BOLD);
			tituloTablaAcad.setFont(fuenteCabecera);

			tituloTablaAcad.add(cabeceraTabla);

			document.add(tituloTablaAcad);

			document.add(datosContrato);

			PdfPTable tablageneral = new PdfPTable(4);
			PdfPCell cell;
			tablageneral.setWidthPercentage(100);
			float[] columnWidthsdept = new float[] { 20f, 60f, 20f, 20f };
			tablageneral.setWidths(columnWidthsdept);
			cell = new PdfPCell(new Phrase("Departamento", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablageneral.addCell(cell);
			cell = new PdfPCell(new Phrase(dep.getNomDep() + "-" + dep.getSigla(), fuenteContenido));
			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Codigo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Periodo Académico", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			tablageneral.addCell(new Phrase(proyecto.getCodigoPr(), fuenteContenido));
			tablageneral.addCell(new Phrase(periodo.getMeses(), fuenteContenido));

			cell = new PdfPCell(new Phrase("Título del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getNombrePr(), fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Línea/s de investigación", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			String linea = "";
			for (Lineasproy lin : lineas) {
				linea += lin.getLineas().getNomLinin() + "  ";
			}
			cell = new PdfPCell(new Phrase(linea, fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);
			document.add(tablageneral);

			////////////////////// tabla equipo del
			////////////////////// proyecto////////////////////////

			PdfPTable tablaEquipoP = new PdfPTable(7);

			tablaEquipoP.setWidthPercentage(100);
			float[] columnWidthEqp = new float[] { 20f, 20f, 15f, 15f, 30f, 10f, 10f };
			tablaEquipoP.setWidths(columnWidthEqp);
			cell = new PdfPCell(new Phrase("Equipo de trabajo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Dpto.", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Cargo actual en la EPN", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Justificación", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Planificadas", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Reportadas", fuente));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			tablaEquipoP.addCell(cell);

			for (EquipoProyectoDTO rec : recursos) {
				cell = new PdfPCell(new Phrase(rec.getRol(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getNombres(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getDepar(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getCargo(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getJustificacion(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getHplanif().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getHreport().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

			}

			document.add(tablaEquipoP);

			PdfPTable tablaLeyedanda = new PdfPTable(1);
			tablaLeyedanda.setWidthPercentage(100);
			float[] columnWidthLey = new float[] { 100f };
			tablaLeyedanda.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("A. OBJETIVOS DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedanda.addCell(cell);
			document.add(tablaLeyedanda);

			//////////////////// OBJETIVO GENERAL

			PdfPTable tablaObjGeneral = new PdfPTable(2);

			tablaObjGeneral.setWidthPercentage(100);
			float[] columnWidthObjG = new float[] { 30f, 70f };
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Objetivo General", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjGeneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getObjetivos(), fuenteContenido));

			tablaObjGeneral.addCell(cell);

			document.add(tablaObjGeneral);

			PdfPTable tablaObjEsp = new PdfPTable(5);

			tablaObjEsp.setWidthPercentage(100);
			float[] columnWidthObjEsp = new float[] { 5f, 30f, 35f, 10f, 30f };
			tablaObjEsp.setWidths(columnWidthObjEsp);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Objetivos Específicos", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Resultados Obtenidos", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("% Avance Acumulado al  \n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Justificación", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			for (int i = 0; i < objetivos.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getObjetivo().getDetalle(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getResultado(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getAvance().toString(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getJustificacion(), fuenteContenido));
				tablaObjEsp.addCell(cell);

			}

			document.add(tablaObjEsp);

			PdfPTable tablaObjGeneralPorcen = new PdfPTable(2);
			tablaObjGeneralPorcen.setWidthPercentage(100);
			tablaObjGeneral.setWidths(columnWidthObjG);
			cell = new PdfPCell(new Phrase("Porcentaje Total de Avance Acumulado del Proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjGeneralPorcen.addCell(cell);
			cell = new PdfPCell(new Phrase(cierre.getAvance().toString(), fuenteContenido));
			tablaObjGeneralPorcen.addCell(cell);
			document.add(tablaObjGeneralPorcen);

			///////// TABLA CRONOGRAMA///////////////////////////////

			PdfPTable tablaLeyedandaCrono = new PdfPTable(1);
			tablaLeyedandaCrono.setWidthPercentage(100);

			tablaLeyedandaCrono.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("B. CRONOGRAMA DE AVANCE DEL PROYECTO EN EL PERIODO " + cierre.getMeses(),
					fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaCrono.addCell(cell);
			document.add(tablaLeyedandaCrono);

			PdfPTable tablaActividades = new PdfPTable(9);

			tablaActividades.setWidthPercentage(100);
			float[] columnWidtAct = new float[] { 5f, 55f, 25f, 5f, 5f, 5f, 5f, 5f, 10f };
			tablaActividades.setWidths(columnWidtAct);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Actividades", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Justificación", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Meses", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setColspan(6);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("M1", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M2", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M3", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M4", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M5", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M6", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);

			for (int i = 0; i < actividades.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getCronograma().getNombreCr(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getJustificacion(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM12(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM34(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM56(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM78(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM910(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM1112(), fuenteContenido));
				tablaActividades.addCell(cell);

			}

			document.add(tablaActividades);

			///////// TABLA PRODUCTOS///////////////////////////////

			PdfPTable tablaLeyedandaProducto = new PdfPTable(1);
			tablaLeyedandaProducto.setWidthPercentage(100);
			tablaLeyedandaProducto.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase(
					"PRODUCTOS GENERADOS DURANTE EL PERIODO ACADÉMICO " + periodo.getMeses() + "\n", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaProducto.addCell(cell);
			document.add(tablaLeyedandaProducto);

			if (presentaciones.size() > 0) {

				PdfPTable tablaLeyedandaProductoPUBLICACIONES = new PdfPTable(1);
				tablaLeyedandaProductoPUBLICACIONES.setWidthPercentage(100);
				tablaLeyedandaProductoPUBLICACIONES.setWidths(columnWidthLey);
				cell = new PdfPCell(
						new Phrase("A. PRESENTACIONES EN EVENTOS (NACIONALES O INTERNACIONALES)", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoPUBLICACIONES.addCell(cell);
				document.add(tablaLeyedandaProductoPUBLICACIONES);

				PdfPTable tablapUB = new PdfPTable(8);
				tablapUB.setWidthPercentage(100);
				float[] columnWidtpUB = new float[] { 5f, 15f, 15f, 15f, 15f, 15f, 10F, 10F };
				tablapUB.setWidths(columnWidtpUB);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);
				cell = new PdfPCell(new Phrase("Título", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Expositor", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("País", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Ciudad", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				for (int i = 0; i < presentaciones.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getTipopresentacion(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getTitulo(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getExpositor(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getEvento(), fuenteContenido));
					tablapUB.addCell(cell);
					cell = new PdfPCell(new Phrase(presentaciones.get(i).getLugar(), fuenteContenido));
					tablapUB.addCell(cell);
					cell = new PdfPCell(new Phrase(presentaciones.get(i).getCarrera(), fuenteContenido));
					tablapUB.addCell(cell);

					if (presentaciones.get(i).getAnio() != null && presentaciones.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(presentaciones.get(i).getMes().toString() + "-"
								+ presentaciones.get(i).getAnio().toString(), fuenteContenido));
						tablapUB.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapUB.addCell(cell);
					}

				}
				document.add(tablapUB);

			}

			if (pubScopus.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.1 PUBLICACIONES EN SCOPUS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(5);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 30f, 25f, 20f, 20f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubScopus.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubScopus.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubScopus.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubScopus.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubScopus.get(i).getFechapresenta() != null) {
						cell = new PdfPCell(
								new Phrase(sdf.format(pubScopus.get(i).getFechapresenta()), fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubScopus.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubRegionales.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.2 PUBLICACIONES REGIONALES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Indexación de la revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubRegionales.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubRegionales.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubRegionales.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubRegionales.get(i).getAnio() != null && pubRegionales.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(pubRegionales.get(i).getMes().toString() + "-"
								+ pubRegionales.get(i).getAnio().toString(), fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubMemorias.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.3 MEMORIAS DE EVENTOS ACADÉMICOS REGIONALES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(7);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 15f, 10f, 10f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del evento académico", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("País", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Ciudad", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubMemorias.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubMemorias.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubMemorias.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubMemorias.get(i).getAnio() != null && pubMemorias.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubMemorias.get(i).getMes().toString() + "-" + pubMemorias.get(i).getAnio().toString(),
								fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getLugar(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getExpositor(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubReportTecnico.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("C REPORTES TÉCNICOS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(5);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del artículo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Estado", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubReportTecnico.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getAutorexterno(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getEstado(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubDifusion.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("D. DIFUSIÓN A LA COMUNIDAD POLITÉCNICA", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la difusión", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Expositor", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubDifusion.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getEstado(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getExpositor(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubDifusion.get(i).getAnio() != null && pubDifusion.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubDifusion.get(i).getMes().toString() + "-" + pubDifusion.get(i).getAnio().toString(),
								fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

				}
				document.add(tablappON);

			}

			if (tesisproyecto.size() > 0) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(
						new Phrase("E. PROYECTO DE TITULACIÓN DE PREGRADO / TESIS DE POSGRADO", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(5);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 30f, 25f, 20f, 20f };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del proyecto de titulación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Estudiante(s)", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera/Programa", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Estado", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < tesisproyecto.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getEstuadiante(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getCarrera(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getEstado(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubProyM.size() > 0) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("F. PLANTEAMIENTO DE UN PROYECTO DE MAYOR ALCANCE", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(4);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 45f, 30f, 20f };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Título", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de proyecto de la EPN o Externo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Institución que financia", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubProyM.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getTipopresentacion(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getExpositor(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubPat.size() > 0) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("G. PATENTE", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(6);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 20f, 20f, 20f, 20, 15 };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Denominación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de activo intangible", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de ingreso a trámite", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de registro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Código SENADI", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubPat.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubPat.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubPat.get(i).getEvento(), fuenteContenido));
					tablapTES.addCell(cell);

					if (pubPat.get(i).getFechaingreso() != null) {
						cell = new PdfPCell(new Phrase(sdf.format(pubPat.get(i).getFechaingreso()), fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					if (pubPat.get(i).getFechapresenta() != null) {
						cell = new PdfPCell(new Phrase(sdf.format(pubPat.get(i).getFechapresenta()), fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubPat.get(i).getVolumen(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubLib.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("H.1 LIBROS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del libro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Link de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("ISBN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubLib.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubLib.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubLib.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubLib.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubLib.get(i).getAnio() != null && pubLib.get(i).getMes() != null) {
						cell = new PdfPCell(
								new Phrase(pubLib.get(i).getMes().toString() + "-" + pubLib.get(i).getAnio().toString(),
										fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubLib.get(i).getUrl(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubLib.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubCap.size() > 0) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("H.2 CAPÍTULO DE LIBRO", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(7);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 15f, 15f, 15f, 15f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del libro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del capítulo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Link de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("ISBN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubCap.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubCap.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubCap.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubCap.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);
					cell = new PdfPCell(new Phrase(pubCap.get(i).getCarrera(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubCap.get(i).getAnio() != null && pubCap.get(i).getMes() != null) {
						cell = new PdfPCell(
								new Phrase(pubCap.get(i).getMes().toString() + "-" + pubCap.get(i).getAnio().toString(),
										fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubCap.get(i).getUrl(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubCap.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubOtros.size() > 0) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("I. OTROS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(5);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 20f, 20f, 20f, 35 };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del producto", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Responsable", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha ", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Observaciones", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubOtros.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getAutorexterno(), fuenteContenido));
					tablapTES.addCell(cell);

					if (pubOtros.get(i).getAnio() != null && pubOtros.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubOtros.get(i).getMes().toString() + "-" + pubOtros.get(i).getAnio().toString(),
								fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getEvento(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			PdfPTable tablaFirma = new PdfPTable(4);

			tablaFirma.setWidthPercentage(100);
			float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			tablaFirma.setWidths(columnWidtFir);

			cell = new PdfPCell(new Phrase("Firma del director del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			tablaFirma.addCell(createImageCell1(pathDocs + "/" + firmaJD));

			cell = new PdfPCell(new Phrase("Firma del jefe de departamento", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			tablaFirma.addCell(createImageCell1(pathDocs + "/" + firmaDr));

			cell = new PdfPCell(new Phrase(
					"Nombre del Director:" + director.getApellidoPersonalPr() + " " + director.getNombrePersonalPr(),
					fuenteContenido));
			tablaFirma.addCell(cell);

			cell = new PdfPCell(
					new Phrase("Nombre del Jefe Dept.:" + jefeDep.getApel() + " " + jefeDep.getNom(), fuenteContenido));

			tablaFirma.addCell(cell);

			document.add(tablaFirma);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			System.out.println("cerre el documento");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfInvestifacionReporteVistaPrevia(List<EquipoProyectoDTO> recursos, List<Lineasproy> lineas,
			ProyectoP proyecto, List<Objetivoavance> objetivos, List<Cronogramaavance> actividades, String pathDocs,
			Emp autoridad, Pensum periodo, String sigla, String pathFirmaDir, String pathFirmaJefe, RecursohPr director,
			Dep dep, CierrePeriodo cierre, List<Producto> presentaciones, List<Producto> pubRegionales,
			List<Producto> pubMemorias, List<Producto> pubReportTecnico, List<Producto> pubDifusion,
			List<Producto> tesisproyecto, List<Producto> pubProyM, List<Producto> pubPat, List<Producto> pubLib,
			List<Producto> pubCap, List<Producto> pubOtros, List<Producto> pubScopus, List<Proyectocarrera> carreras,
			List<EquipoProyectoDTO> estudiantes) {
		String url = "";
		try {

			System.out.println("Entro a crear archivo");
			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo

			FileOutputStream outputStream = new FileOutputStream(new File(pathDocs + "/" + proyecto.getCodigoPr().trim()
					+ "-" + INFORME_AVANCE + "-" + periodo.getMeses() + ".pdf"));

			url = pathDocs + "/" + proyecto.getCodigoPr().trim() + "-" + INFORME_AVANCE + "-" + periodo.getMeses()
					+ ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			writer.setPageEvent(new WatermarkPageEvent());

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph datosContrato = new Paragraph();
			datosContrato.add("\n");

			PdfPTable cabecera = new PdfPTable(3);
			cabecera.setWidthPercentage(100);
			float[] columnWidthsCabecera = new float[] { 15f, 70f, 15f };
			cabecera.setWidths(columnWidthsCabecera);

			System.out.println("Se agrego la cabecera");

			cabecera.addCell(createImageCell(pathDocs + "/logo_epn.jpg"));
			cabecera.addCell(createLabelCabecera(
					"ESCUELA POLITECNICA NACIONAL\nVICERRECTORADO DE INVESTIGACIÓN, INNOVACIÓN Y VINCULACIÓN\nDIRECCIÓN DE INVESTIGACIÓN "));

			cabecera.addCell(createImageCell(pathDocs + "/150.png"));
			document.add(cabecera);

			com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 8, Font.BOLD);
			fuente.setSize(8);

			com.itextpdf.text.Font fuenteContenido = FontFactory.getFont("Arial", 8);
			fuenteContenido.setSize(8);

			com.itextpdf.text.Font fuenteLeyenda = FontFactory.getFont("Arial", 10, Font.BOLD);
			fuenteContenido.setSize(8);

			document.add(datosContrato);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "INFORME DE AVANCE DE PROYECTO DE INVESTIGACIÓN";
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			com.itextpdf.text.Font fuenteCabecera = FontFactory.getFont("Arial", 12, Font.BOLD);
			tituloTablaAcad.setFont(fuenteCabecera);

			tituloTablaAcad.add(cabeceraTabla);

			document.add(tituloTablaAcad);

			document.add(datosContrato);

			PdfPTable tablageneral = new PdfPTable(4);
			PdfPCell cell;
			tablageneral.setWidthPercentage(100);
			float[] columnWidthsdept = new float[] { 20f, 60f, 20f, 20f };
			tablageneral.setWidths(columnWidthsdept);
			cell = new PdfPCell(new Phrase("Departamento", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(dep.getNomDep(), fuenteContenido));

			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Codigo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Periodo Académico", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			tablageneral.addCell(new Phrase(proyecto.getCodigoPr(), fuenteContenido));
			tablageneral.addCell(new Phrase(periodo.getMeses(), fuenteContenido));

			cell = new PdfPCell(new Phrase("Título del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getNombrePr(), fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Línea/s de investigación", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablageneral.addCell(cell);

			String linea = "";
			for (Lineasproy lin : lineas) {
				linea += lin.getLineas().getNomLinin() + "  ";
			}
			cell = new PdfPCell(new Phrase(linea, fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablageneral.addCell(cell);

				String carrera = "";
				for (Proyectocarrera car : carreras) {
					carrera += car.getNombre() + "  ";
				}
				cell = new PdfPCell(new Phrase(carrera, fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase("Organización Colaboradora", fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase(proyecto.getBeneficiarioPr(), fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

			}

			document.add(tablageneral);

			////////////////////// tabla equipo del
			////////////////////// proyecto////////////////////////

			
			PdfPTable tablaLeyedanda = new PdfPTable(1);
			tablaLeyedanda.setWidthPercentage(100);
			float[] columnWidthLey = new float[] { 100f };
			tablaLeyedanda.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("A1. EQUIPO DE TRABAJO DEL PROEYCTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedanda.addCell(cell);
			document.add(tablaLeyedanda);
			
			
			PdfPTable tablaEquipoP = new PdfPTable(6);

			tablaEquipoP.setWidthPercentage(100);
			float[] columnWidthEqp = new float[] { 20f, 30f, 15f, 15f, 10f, 10f };
			tablaEquipoP.setWidths(columnWidthEqp);
			cell = new PdfPCell(new Phrase("Rol", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Dpto.", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Cargo actual en la EPN", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Planificadas", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Reportadas", fuente));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			tablaEquipoP.addCell(cell);

			for (EquipoProyectoDTO rec : recursos) {
				cell = new PdfPCell(new Phrase(rec.getRol(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getNombres(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getDepar(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getCargo(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getHplanif().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getHreport().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);
			}

			document.add(tablaEquipoP);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				////////////////////// tabla equipo del
				////////////////////// proyecto////////////////////////

				PdfPTable tablaLeyedandaES = new PdfPTable(1);
				tablaLeyedandaES.setWidthPercentage(100);
				
				tablaLeyedandaES.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("A2. ESTUDIANTES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(83, 141, 213));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaES.addCell(cell);
				document.add(tablaLeyedandaES);
				
				PdfPTable tablaEstud = new PdfPTable(7);

				tablaEstud.setWidthPercentage(100);
				float[] columnWidthest1 = new float[] { 20f, 20f, 20f, 10f, 10f, 10f, 10f };
				tablaEstud.setWidths(columnWidthest1);

				cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Cédula.", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Vinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Desvinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Horas Pnalificadas\n" + periodo.getMeses(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Horas Repostadas\n" + periodo.getMeses(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEstud.addCell(cell);

				for (EquipoProyectoDTO avac : estudiantes) {
					cell = new PdfPCell(new Phrase(avac.getNombres(), fuente));

					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getCargo(), fuenteContenido));
					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getDepar(), fuenteContenido));
					tablaEstud.addCell(cell);

					if (avac.getFvincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(new Phrase(avac.getFvincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					if (avac.getFdesvincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(new Phrase(avac.getFdesvincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(avac.getHplanif().toString(), fuenteContenido));
					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getHreport().toString(), fuenteContenido));
					tablaEstud.addCell(cell);

				}

				document.add(tablaEstud);
			}

			PdfPTable tablaLeyedandaoBJ = new PdfPTable(1);
			tablaLeyedandaoBJ.setWidthPercentage(100);
			
			tablaLeyedandaoBJ.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("B. OBJETIVOS DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaoBJ.addCell(cell);
			document.add(tablaLeyedandaoBJ);

			//////////////////// OBJETIVO GENERAL

			PdfPTable tablaObjGeneral = new PdfPTable(2);

			tablaObjGeneral.setWidthPercentage(100);
			float[] columnWidthObjG = new float[] { 30f, 70f };
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Objetivo General", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjGeneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getObjetivos(), fuenteContenido));

			tablaObjGeneral.addCell(cell);

			document.add(tablaObjGeneral);

			PdfPTable tablaObjEsp = new PdfPTable(4);

			tablaObjEsp.setWidthPercentage(100);
			float[] columnWidthObjEsp = new float[] { 5f, 40f, 45f, 10f };
			tablaObjEsp.setWidths(columnWidthObjEsp);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Objetivos Específicos", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Resultados Obtenidos", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("% Avance Acumulado al  \n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjEsp.addCell(cell);

			for (int i = 0; i < objetivos.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getObjetivo().getDetalle(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getResultado(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getAvance().toString(), fuenteContenido));
				tablaObjEsp.addCell(cell);

			}

			document.add(tablaObjEsp);

			PdfPTable tablaObjGeneralPorcen = new PdfPTable(2);
			tablaObjGeneralPorcen.setWidthPercentage(100);
			tablaObjGeneral.setWidths(columnWidthObjG);
			cell = new PdfPCell(new Phrase("Porcentaje Total de Avance Acumulado del Proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaObjGeneralPorcen.addCell(cell);

			if (cierre.getAvance() == null) {
				cell = new PdfPCell(new Phrase("0", fuenteContenido));
			} else {
				cell = new PdfPCell(new Phrase(cierre.getAvance().toString(), fuenteContenido));
			}

			tablaObjGeneralPorcen.addCell(cell);
			document.add(tablaObjGeneralPorcen);

			///////// TABLA CRONOGRAMA///////////////////////////////

			PdfPTable tablaLeyedandaCrono = new PdfPTable(1);
			tablaLeyedandaCrono.setWidthPercentage(100);

			tablaLeyedandaCrono.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("C. CRONOGRAMA DE AVANCE DEL PROYECTO EN EL PERIODO " + periodo.getMeses(),
					fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(83, 141, 213));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaCrono.addCell(cell);
			document.add(tablaLeyedandaCrono);

			PdfPTable tablaActividades = new PdfPTable(8);

			tablaActividades.setWidthPercentage(100);
			float[] columnWidtAct = new float[] { 5f, 65f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaActividades.setWidths(columnWidtAct);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Actividades", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Meses", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setColspan(6);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("M1", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M2", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M3", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M4", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M5", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M6", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaActividades.addCell(cell);

			for (int i = 0; i < actividades.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getCronograma().getNombreCr(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM12(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM34(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM56(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM78(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM910(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM1112(), fuenteContenido));
				tablaActividades.addCell(cell);

			}

			document.add(tablaActividades);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			///////// TABLA PRODUCTOS///////////////////////////////

			PdfPTable tablaLeyedandaProducto = new PdfPTable(1);
			tablaLeyedandaProducto.setWidthPercentage(100);
			tablaLeyedandaProducto.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase(
					"PRODUCTOS GENERADOS DURANTE EL PERIODO ACADÉMICO " + periodo.getMeses() + "\n", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(250, 191, 143));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaProducto.addCell(cell);
			document.add(tablaLeyedandaProducto);

			if (presentaciones.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoPUBLICACIONES = new PdfPTable(1);
				tablaLeyedandaProductoPUBLICACIONES.setWidthPercentage(100);
				tablaLeyedandaProductoPUBLICACIONES.setWidths(columnWidthLey);
				cell = new PdfPCell(
						new Phrase("A. PRESENTACIONES EN EVENTOS (NACIONALES O INTERNACIONALES)", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoPUBLICACIONES.addCell(cell);
				document.add(tablaLeyedandaProductoPUBLICACIONES);

				PdfPTable tablapUB = new PdfPTable(8);
				tablapUB.setWidthPercentage(100);
				float[] columnWidtpUB = new float[] { 5f, 15f, 15f, 15f, 15f, 15f, 10F, 10F };
				tablapUB.setWidths(columnWidtpUB);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);
				cell = new PdfPCell(new Phrase("Título", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Expositor", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("País", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Ciudad", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapUB.addCell(cell);

				for (int i = 0; i < presentaciones.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getTipopresentacion(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getTitulo(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getExpositor(), fuenteContenido));
					tablapUB.addCell(cell);

					cell = new PdfPCell(new Phrase(presentaciones.get(i).getEvento(), fuenteContenido));
					tablapUB.addCell(cell);
					cell = new PdfPCell(new Phrase(presentaciones.get(i).getLugar(), fuenteContenido));
					tablapUB.addCell(cell);
					cell = new PdfPCell(new Phrase(presentaciones.get(i).getCarrera(), fuenteContenido));
					tablapUB.addCell(cell);

					if (presentaciones.get(i).getAnio() != null && presentaciones.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(presentaciones.get(i).getMes().toString() + "-"
								+ presentaciones.get(i).getAnio().toString(), fuenteContenido));
						tablapUB.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapUB.addCell(cell);
					}

				}
				document.add(tablapUB);

			}

			if (pubScopus.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.1 PUBLICACIONES EN SCOPUS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(5);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 30f, 25f, 20f, 20f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubScopus.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubScopus.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubScopus.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubScopus.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubScopus.get(i).getFechapresenta() != null) {
						cell = new PdfPCell(
								new Phrase(sdf.format(pubScopus.get(i).getFechapresenta()), fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubScopus.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubRegionales.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.2 PUBLICACIONES REGIONALES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Indexación de la revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubRegionales.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubRegionales.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubRegionales.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubRegionales.get(i).getAnio() != null && pubRegionales.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(pubRegionales.get(i).getMes().toString() + "-"
								+ pubRegionales.get(i).getAnio().toString(), fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubRegionales.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubMemorias.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("B.3 MEMORIAS DE EVENTOS ACADÉMICOS REGIONALES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(7);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 15f, 10f, 10f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del evento académico", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("País", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Ciudad", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubMemorias.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubMemorias.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubMemorias.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubMemorias.get(i).getAnio() != null && pubMemorias.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubMemorias.get(i).getMes().toString() + "-" + pubMemorias.get(i).getAnio().toString(),
								fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getLugar(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubMemorias.get(i).getExpositor(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubReportTecnico.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("C REPORTES TÉCNICOS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(5);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del artículo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Estado", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Revista", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubReportTecnico.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getAutorexterno(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getEstado(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubReportTecnico.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubDifusion.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("D. DIFUSIÓN A LA COMUNIDAD POLITÉCNICA", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título de la difusión", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Expositor", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del evento", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de presentación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubDifusion.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getEstado(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getExpositor(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubDifusion.get(i).getEvento(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubDifusion.get(i).getAnio() != null && pubDifusion.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubDifusion.get(i).getMes().toString() + "-" + pubDifusion.get(i).getAnio().toString(),
								fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

				}
				document.add(tablappON);

			}

			if (tesisproyecto.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(
						new Phrase("E. PROYECTO DE TITULACIÓN DE PREGRADO / TESIS DE POSGRADO", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(5);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 30f, 25f, 20f, 20f };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del proyecto de titulación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Estudiante(s)", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera/Programa", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Estado", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < tesisproyecto.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getEstuadiante(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getCarrera(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(tesisproyecto.get(i).getEstado(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubProyM.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("F. PLANTEAMIENTO DE UN PROYECTO DE MAYOR ALCANCE", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(4);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 45f, 30f, 20f };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Título", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de proyecto de la EPN o Externo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Institución que financia", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubProyM.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getTipopresentacion(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubProyM.get(i).getExpositor(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubPat.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("G. PATENTE", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(6);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 20f, 20f, 20f, 20, 15 };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Denominación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Tipo de activo intangible", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de ingreso a trámite", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de registro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Código SENADI", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubPat.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubPat.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubPat.get(i).getEvento(), fuenteContenido));
					tablapTES.addCell(cell);

					if (pubPat.get(i).getFechaingreso() != null) {
						cell = new PdfPCell(new Phrase(sdf.format(pubPat.get(i).getFechaingreso()), fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					if (pubPat.get(i).getFechapresenta() != null) {
						cell = new PdfPCell(new Phrase(sdf.format(pubPat.get(i).getFechapresenta()), fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubPat.get(i).getVolumen(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			if (pubLib.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("H.1 LIBROS", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(6);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 20f, 20f, 20f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del libro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Link de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("ISBN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubLib.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubLib.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubLib.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubLib.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubLib.get(i).getAnio() != null && pubLib.get(i).getMes() != null) {
						cell = new PdfPCell(
								new Phrase(pubLib.get(i).getMes().toString() + "-" + pubLib.get(i).getAnio().toString(),
										fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubLib.get(i).getUrl(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubLib.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubCap.size() > 0 && proyecto.getTipoProyecto().getIdTipoProy() != 4) {
				PdfPTable tablaLeyedandaProductopON = new PdfPTable(1);
				tablaLeyedandaProductopON.setWidthPercentage(100);
				tablaLeyedandaProductopON.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("H.2 CAPÍTULO DE LIBRO", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductopON.addCell(cell);
				document.add(tablaLeyedandaProductopON);

				PdfPTable tablappON = new PdfPTable(7);
				tablappON.setWidthPercentage(100);
				float[] columnWidtppON = new float[] { 5f, 20f, 15f, 15f, 15f, 15f, 15f };
				tablappON.setWidths(columnWidtppON);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Autores con filiación EPN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del libro", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Título del capítulo", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha de publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("Link de la publicación", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				cell = new PdfPCell(new Phrase("ISBN", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablappON.addCell(cell);

				for (int i = 0; i < pubCap.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablappON.addCell(cell);

					if (pubCap.get(i).getAutores().size() > 0) {
						String nomnbres = "";
						for (AutoresProducto au : pubCap.get(i).getAutores()) {
							nomnbres = nomnbres + au.getNombres() + "\n";
						}

						cell = new PdfPCell(new Phrase(nomnbres, fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);

					}

					cell = new PdfPCell(new Phrase(pubCap.get(i).getTitulo(), fuenteContenido));
					tablappON.addCell(cell);
					cell = new PdfPCell(new Phrase(pubCap.get(i).getCarrera(), fuenteContenido));
					tablappON.addCell(cell);

					if (pubCap.get(i).getAnio() != null && pubCap.get(i).getMes() != null) {
						cell = new PdfPCell(
								new Phrase(pubCap.get(i).getMes().toString() + "-" + pubCap.get(i).getAnio().toString(),
										fuenteContenido));
						tablappON.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablappON.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubCap.get(i).getUrl(), fuenteContenido));
					tablappON.addCell(cell);

					cell = new PdfPCell(new Phrase(pubCap.get(i).getCatalogo(), fuenteContenido));
					tablappON.addCell(cell);

				}
				document.add(tablappON);

			}

			if (pubOtros.size() > 0) {

				PdfPTable tablaLeyedandaProductoTESIS = new PdfPTable(1);
				tablaLeyedandaProductoTESIS.setWidthPercentage(100);
				tablaLeyedandaProductoTESIS.setWidths(columnWidthLey);

				if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {
					cell = new PdfPCell(new Phrase("A. PRODUCTOS", fuenteLeyenda));
				} else {
					cell = new PdfPCell(new Phrase("I. OTROS", fuenteLeyenda));

				}

				cell.setBackgroundColor(new BaseColor(250, 191, 143));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaProductoTESIS.addCell(cell);
				document.add(tablaLeyedandaProductoTESIS);

				PdfPTable tablapTES = new PdfPTable(5);
				tablapTES.setWidthPercentage(100);
				float[] columnWidtptES = new float[] { 5f, 20f, 20f, 20f, 35 };
				tablapTES.setWidths(columnWidtptES);

				cell = new PdfPCell(new Phrase("N°", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Nombre del producto", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Responsable", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Fecha ", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				cell = new PdfPCell(new Phrase("Observaciones", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablapTES.addCell(cell);

				for (int i = 0; i < pubOtros.size(); i++) {
					Integer numeral = i + 1;

					cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getTitulo(), fuenteContenido));
					tablapTES.addCell(cell);

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getAutorexterno(), fuenteContenido));
					tablapTES.addCell(cell);

					if (pubOtros.get(i).getAnio() != null && pubOtros.get(i).getMes() != null) {
						cell = new PdfPCell(new Phrase(
								pubOtros.get(i).getMes().toString() + "-" + pubOtros.get(i).getAnio().toString(),
								fuenteContenido));
						tablapTES.addCell(cell);
					}

					else {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablapTES.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(pubOtros.get(i).getEvento(), fuenteContenido));
					tablapTES.addCell(cell);

				}
				document.add(tablapTES);
			}

			PdfPTable tablaFirma = new PdfPTable(4);

			tablaFirma.setWidthPercentage(100);
			float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			tablaFirma.setWidths(columnWidtFir);

			cell = new PdfPCell(new Phrase("Firma del director del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (pathFirmaDir == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathFirmaDir);
			}
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Firma del jefe de departamento", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (pathFirmaJefe == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathFirmaJefe);
			}
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase(
					"Nombre del Director: " + director.getApellidoPersonalPr() + " " + director.getNombrePersonalPr(),
					fuenteContenido));
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Nombre del Jefe Dept.: " + autoridad.getApel() + " " + autoridad.getNom(),
					fuenteContenido));

			tablaFirma.addCell(cell);

			document.add(tablaFirma);

			document.add(datosContrato);

			String fechaComoCadena = "";
			String fechaComoCadena1 = "";

			if (cierre.getFechacierredocente() == null) {
				fechaComoCadena = "Sin envío JD.";

			} else {
				fechaComoCadena = sdf.format(cierre.getFechacierredocente());
			}

			if (cierre.getFechacierrejd() == null) {
				fechaComoCadena1 = "Sin envío DI.";

			} else {
				fechaComoCadena1 = sdf.format(cierre.getFechacierrejd());
			}

			Paragraph ingreso = new Paragraph();
			String ing = "\n Fecha envío Jefe Departamento: " + fechaComoCadena;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso.setFont(fuente);
			ingreso.setAlignment(Element.ALIGN_LEFT);
			ingreso.add(ing);

			document.add(ingreso);

			Paragraph ingreso2 = new Paragraph();
			String ing2 = "\n Fecha envío a la DIrección de Investigación: " + fechaComoCadena1;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso2.setFont(fuente);
			ingreso2.setAlignment(Element.ALIGN_LEFT);
			ingreso2.add(ing2);

			document.add(ingreso2);

			document.close();

			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			System.out.println("cerre el documento");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfInvestifacionReportePlanicacion(List<Recursoavance> recursos, List<Lineasproy> lineas,
			ProyectoP proyecto, List<Objetivoavance> objetivos, CierrePeriodo cierre,
			List<Cronogramaavance> actividades, String pathDocs, RecursohPr director, Pensum periodo, String sigla,
			Emp empleado, Dep dep, String pathfirmaJD, String pathfirmaDr, List<Proyectocarrera> carreras,
			List<Avanceestud> avanceEstud) {
		String url = "";
		try {

			System.out.println("Entro a crear archivo");
			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo

			FileOutputStream outputStream = new FileOutputStream(
					new File(pathDocs + "/" + proyecto.getCodigoPr().trim() + "-IPL-" + periodo.getMeses() + ".pdf"));

			url = pathDocs + "/" + proyecto.getCodigoPr().trim() + "-IPL-" + periodo.getMeses() + ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph datosContrato = new Paragraph();
			datosContrato.add("\n");

			PdfPTable cabecera = new PdfPTable(3);
			cabecera.setWidthPercentage(100);
			float[] columnWidthsCabecera = new float[] { 15f, 70f, 15f };
			cabecera.setWidths(columnWidthsCabecera);

			System.out.println("Se agrego la cabecera");

			cabecera.addCell(createImageCell(pathDocs + "/logo_epn.jpg"));
			cabecera.addCell(createLabelCabecera(
					"ESCUELA POLITECNICA NACIONAL\nVICERRECTORADO DE INVESTIGACIÓN, INNOVACIÓN Y VINCULACIÓN\nDIRECCIÓN DE INVESTIGACIÓN "));

			cabecera.addCell(createImageCell(pathDocs + "/150.png"));
			document.add(cabecera);

			com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 8, Font.BOLD);
			fuente.setSize(8);

			com.itextpdf.text.Font fuenteContenido = FontFactory.getFont("Arial", 8);
			fuenteContenido.setSize(8);

			com.itextpdf.text.Font fuenteLeyenda = FontFactory.getFont("Arial", 10, Font.BOLD);
			fuenteContenido.setSize(8);

			document.add(datosContrato);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "INFORME DE PLANIFICACIÓN DE PROYECTO DE INVESTIGACIÓN";
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			com.itextpdf.text.Font fuenteCabecera = FontFactory.getFont("Arial", 12, Font.BOLD);
			tituloTablaAcad.setFont(fuenteCabecera);

			tituloTablaAcad.add(cabeceraTabla);

			document.add(tituloTablaAcad);

			document.add(datosContrato);

			PdfPTable tablageneral = new PdfPTable(4);
			PdfPCell cell;
			tablageneral.setWidthPercentage(100);
			float[] columnWidthsdept = new float[] { 20f, 60f, 20f, 20f };
			tablageneral.setWidths(columnWidthsdept);
			cell = new PdfPCell(new Phrase("Departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablageneral.addCell(cell);
			cell = new PdfPCell(new Phrase(dep.getNomDep() + " " + dep.getSigla(), fuenteContenido));
			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Codigo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Periodo Académico", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			tablageneral.addCell(new Phrase(proyecto.getCodigoPr(), fuenteContenido));
			tablageneral.addCell(new Phrase(periodo.getMeses(), fuenteContenido));

			cell = new PdfPCell(new Phrase("Título del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getNombrePr(), fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Línea/s de investigación", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			String linea = "";
			for (Lineasproy lin : lineas) {
				linea += lin.getLineas().getNomLinin() + "  ";
			}
			cell = new PdfPCell(new Phrase(linea, fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablageneral.addCell(cell);

				String carrera = "";
				for (Proyectocarrera car : carreras) {
					carrera += car.getNombre() + "  ";
				}
				cell = new PdfPCell(new Phrase(carrera, fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase("Organización Colaboradora", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase(proyecto.getBeneficiarioPr(), fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

			}

			document.add(tablageneral);

			////////////////////// tabla equipo del
			////////////////////// proyecto////////////////////////

			PdfPTable tablaLeyedanda = new PdfPTable(1);
			tablaLeyedanda.setWidthPercentage(100);
			float[] columnWidthLey = new float[] { 100f };
			tablaLeyedanda.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("A1. EQUIPO DE TRABAJO DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedanda.addCell(cell);
			document.add(tablaLeyedanda);
			
			PdfPTable tablaEquipoP = new PdfPTable(5);

			tablaEquipoP.setWidthPercentage(100);
			float[] columnWidthEqp = new float[] { 20f, 30f, 25f, 15f, 10f };
			tablaEquipoP.setWidths(columnWidthEqp);
			cell = new PdfPCell(new Phrase("Rol", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Dpto.", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Cargo actual en la EPN", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Planificadas", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			for (Recursoavance rec : recursos) {
				cell = new PdfPCell(new Phrase(rec.getRecurso().getRolProyecto().getRolProy(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(
						rec.getRecurso().getApellidoPersonalPr() + " " + rec.getRecurso().getNombrePersonalPr(),
						fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getRecurso().getDpto(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getRecurso().getCargo(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getValor().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

			}

			document.add(tablaEquipoP);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				PdfPTable tablaLeyedandaE = new PdfPTable(1);
				tablaLeyedandaE.setWidthPercentage(100);
				
				tablaLeyedandaE.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("A2. ESTUDIANTES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(226, 107, 10));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedandaE.addCell(cell);
				document.add(tablaLeyedandaE);
				
				////////////////////// tabla equipo del
				////////////////////// proyecto////////////////////////

				PdfPTable tablaEstud = new PdfPTable(6);

				tablaEstud.setWidthPercentage(100);
				float[] columnWidthest = new float[] { 20f, 20f, 25f, 15f, 10f, 10f };
				tablaEstud.setWidths(columnWidthest);

				cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Cédula.", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Vinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Desvinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Horas Dedicación", fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEstud.addCell(cell);

				for (Avanceestud avac : avanceEstud) {
					cell = new PdfPCell(new Phrase(avac.getEstudiante().getNombre(), fuente));

					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getEstudiante().getCedula(), fuenteContenido));
					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getEstudiante().getCarrera(), fuenteContenido));
					tablaEstud.addCell(cell);

					if (avac.getEstudiante().getFechaVincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(
								new Phrase(avac.getEstudiante().getFechaVincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					if (avac.getEstudiante().getFechaDesvincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(
								new Phrase(avac.getEstudiante().getFechaDesvincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(avac.getAvance().toString(), fuenteContenido));
					tablaEstud.addCell(cell);

				}

				document.add(tablaEstud);
			}

			PdfPTable tablaLeyedandaO = new PdfPTable(1);
			tablaLeyedandaO.setWidthPercentage(100);
			
			tablaLeyedandaO.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("B. OBJETIVOS DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaO.addCell(cell);
			document.add(tablaLeyedandaO);

			//////////////////// OBJETIVO GENERAL

			PdfPTable tablaObjGeneral = new PdfPTable(2);

			tablaObjGeneral.setWidthPercentage(100);
			float[] columnWidthObjG = new float[] { 30f, 70f };
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Objetivo General", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjGeneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getObjetivos(), fuenteContenido));

			tablaObjGeneral.addCell(cell);

			document.add(tablaObjGeneral);

			PdfPTable tablaObjEsp = new PdfPTable(4);

			tablaObjEsp.setWidthPercentage(100);
			float[] columnWidthObjEsp = new float[] { 5f, 40f, 45f, 10f };
			tablaObjEsp.setWidths(columnWidthObjEsp);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Objetivos Específicos", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Resultados Obtenidos", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("% Avance Acumulado al  \n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			for (int i = 0; i < objetivos.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getObjetivo().getDetalle(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getResultado(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getAvance().toString(), fuenteContenido));
				tablaObjEsp.addCell(cell);

			}

			document.add(tablaObjEsp);

			PdfPTable tablaObjGeneralPorcen = new PdfPTable(2);
			tablaObjGeneralPorcen.setWidthPercentage(100);
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Porcentaje Total de Avance Acumulado del Proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjGeneralPorcen.addCell(cell);
			cell = new PdfPCell(new Phrase(cierre.getAvance().toString(), fuenteContenido));
			tablaObjGeneralPorcen.addCell(cell);
			document.add(tablaObjGeneralPorcen);

			///////// TABLA CRONOGRAMA///////////////////////////////

			PdfPTable tablaLeyedandaCrono = new PdfPTable(1);
			tablaLeyedandaCrono.setWidthPercentage(100);

			tablaLeyedandaCrono.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("C. CRONOGRAMA DE AVANCE DEL PROYECTO EN EL PERIODO " + cierre.getMeses(),
					fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaCrono.addCell(cell);
			document.add(tablaLeyedandaCrono);

			PdfPTable tablaActividades = new PdfPTable(8);

			tablaActividades.setWidthPercentage(100);
			float[] columnWidtAct = new float[] { 5f, 65f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaActividades.setWidths(columnWidtAct);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Actividades", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Meses", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setColspan(6);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("M1", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M2", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M3", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M4", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M5", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M6", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);

			for (int i = 0; i < actividades.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getCronograma().getNombreCr(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM12(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM34(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM56(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM78(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM910(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM1112(), fuenteContenido));
				tablaActividades.addCell(cell);

			}

			document.add(tablaActividades);

			// PdfPTable tablaFirma = new PdfPTable(4);
			//
			// tablaFirma.setWidthPercentage(100);
			// float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			// tablaFirma.setWidths(columnWidtFir);
			//
			// cell = new PdfPCell(new Phrase("Firma del director del proyecto",
			// fuente));
			// cell.setBackgroundColor(new BaseColor(252, 213, 180));
			// cell.setRowspan(2);
			// tablaFirma.addCell(cell);
			//
			// tablaFirma.addCell(createImageCell1(pathDocs + "/" +
			// pathfirmaJD));
			//
			// cell = new PdfPCell(new Phrase("Firma del jefe de departamento",
			// fuente));
			// cell.setBackgroundColor(new BaseColor(252, 213, 180));
			// cell.setRowspan(2);
			// tablaFirma.addCell(cell);
			//
			// tablaFirma.addCell(createImageCell1(pathDocs + "/" +
			// pathfirmaDr));
			//
			// cell = new PdfPCell(new Phrase(
			// "Nombre del Director:" + director.getApellidoPersonalPr() + " " +
			// director.getNombrePersonalPr(),
			// fuenteContenido));
			// tablaFirma.addCell(cell);
			//
			// cell = new PdfPCell(new Phrase("Nombre del Jefe Dept.:" +
			// empleado.getApel() + " " + empleado.getNom(),
			// fuenteContenido));
			//
			// tablaFirma.addCell(cell);
			//
			// document.add(tablaFirma);

			PdfPTable tablaFirma = new PdfPTable(4);

			tablaFirma.setWidthPercentage(100);
			float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			tablaFirma.setWidths(columnWidtFir);

			cell = new PdfPCell(new Phrase("Firma del director del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (pathfirmaDr == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathDocs + "/" + pathfirmaDr);
			}

			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Firma del jefe de departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (pathfirmaJD == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathDocs + "/" + pathfirmaJD);
			}
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase(
					"Nombre del Director:" + director.getApellidoPersonalPr() + "-" + director.getNombrePersonalPr(),
					fuenteContenido));
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Nombre del Jefe Dept.: " + empleado.getApel() + " " + empleado.getNom(),
					fuenteContenido));

			tablaFirma.addCell(cell);

			document.add(tablaFirma);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			String fechaComoCadena = "";
			String fechaComoCadena1 = "";

			if (cierre.getFechacierredocente() == null) {
				fechaComoCadena = "Sin envío JD.";

			} else {
				fechaComoCadena = sdf.format(cierre.getFechacierredocente());
			}

			if (cierre.getFechacierrejd() == null) {
				fechaComoCadena1 = "Sin envío DI.";

			} else {
				fechaComoCadena1 = sdf.format(cierre.getFechacierrejd());
			}

			Paragraph ingreso = new Paragraph();
			String ing = "\n Fecha envío Jefe Departamento: " + fechaComoCadena;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso.setFont(fuente);
			ingreso.setAlignment(Element.ALIGN_LEFT);
			ingreso.add(ing);

			document.add(ingreso);

			Paragraph ingreso2 = new Paragraph();
			String ing2 = "\n Fecha envío a la DIrección de Investigación: " + fechaComoCadena1;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso2.setFont(fuente);
			ingreso2.setAlignment(Element.ALIGN_LEFT);
			ingreso2.add(ing2);

			document.add(ingreso2);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			System.out.println("cerre el documento");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfInvestifacionReportePlanicacionupdate(List<Recursoavance> recursos, List<Lineasproy> lineas,
			ProyectoP proyecto, List<Objetivoavance> objetivos, CierrePeriodo cierre,
			List<Cronogramaavance> actividades, String pathDocs, RecursohPr director, Pensum periodo, String sigla,
			Emp empleado, Dep dep, String pathfirmaJD, String pathfirmaDr, Integer idversion) {
		String url = "";
		try {

			System.out.println("Entro a crear archivo");
			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo

			FileOutputStream outputStream = new FileOutputStream(new File(pathDocs + "/" + "Proyecto" + "-"
					+ director.getNced().trim() + "-" + periodo.getMeses() + "-" + sigla + idversion + "V2.pdf"));

			url = pathDocs + "/" + "Proyecto" + "-" + director.getNced().trim() + "-" + periodo.getMeses() + "-" + sigla
					+ idversion + "V2.pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph datosContrato = new Paragraph();
			datosContrato.add("\n");

			PdfPTable cabecera = new PdfPTable(3);
			cabecera.setWidthPercentage(100);
			float[] columnWidthsCabecera = new float[] { 15f, 70f, 15f };
			cabecera.setWidths(columnWidthsCabecera);

			System.out.println("Se agrego la cabecera");

			cabecera.addCell(createImageCell(pathDocs + "/logo_epn.jpg"));
			cabecera.addCell(createLabelCabecera(
					"ESCUELA POLITECNICA NACIONAL\nVICERRECTORADO DE INVESTIGACIÓN, INNOVACIÓN Y VINCULACIÓN\nDIRECCIÓN DE INVESTIGACIÓN "));
			cabecera.addCell(createImageCell(pathDocs + "//150.png"));
			document.add(cabecera);

			com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 8, Font.BOLD);
			fuente.setSize(8);

			com.itextpdf.text.Font fuenteContenido = FontFactory.getFont("Arial", 8);
			fuenteContenido.setSize(8);

			com.itextpdf.text.Font fuenteLeyenda = FontFactory.getFont("Arial", 10, Font.BOLD);
			fuenteContenido.setSize(8);

			document.add(datosContrato);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "INFORME DE PLANIFICACIÓN DE PROYECTO DE INVESTIGACIÓN";
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			com.itextpdf.text.Font fuenteCabecera = FontFactory.getFont("Arial", 12, Font.BOLD);
			tituloTablaAcad.setFont(fuenteCabecera);

			tituloTablaAcad.add(cabeceraTabla);

			document.add(tituloTablaAcad);

			document.add(datosContrato);

			PdfPTable tablageneral = new PdfPTable(4);
			PdfPCell cell;
			tablageneral.setWidthPercentage(100);
			float[] columnWidthsdept = new float[] { 20f, 60f, 20f, 20f };
			tablageneral.setWidths(columnWidthsdept);
			cell = new PdfPCell(new Phrase("Departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablageneral.addCell(cell);
			cell = new PdfPCell(new Phrase(dep.getNomDep() + " " + dep.getSigla(), fuenteContenido));
			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Codigo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Periodo Académico", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			tablageneral.addCell(new Phrase(proyecto.getCodigoPr(), fuenteContenido));
			tablageneral.addCell(new Phrase(periodo.getMeses(), fuenteContenido));

			cell = new PdfPCell(new Phrase("Título del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getNombrePr(), fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Línea/s de investigación", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			String linea = "";
			for (Lineasproy lin : lineas) {
				linea += lin.getLineas().getNomLinin() + "  ";
			}
			cell = new PdfPCell(new Phrase(linea, fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);
			document.add(tablageneral);

			////////////////////// tabla equipo del
			////////////////////// proyecto////////////////////////

			PdfPTable tablaEquipoP = new PdfPTable(6);

			tablaEquipoP.setWidthPercentage(100);
			float[] columnWidthEqp = new float[] { 20f, 20f, 25f, 25f, 30f, 15f };
			tablaEquipoP.setWidths(columnWidthEqp);
			cell = new PdfPCell(new Phrase("Equipo de trabajo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Dpto.", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Cargo actual en la EPN", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);
			cell = new PdfPCell(new Phrase("Justificación", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Planificadas", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			for (Recursoavance rec : recursos) {
				cell = new PdfPCell(new Phrase(rec.getRecurso().getRolProyecto().getRolProy(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(
						rec.getRecurso().getApellidoPersonalPr() + " " + rec.getRecurso().getNombrePersonalPr(),
						fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getRecurso().getDpto(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getRecurso().getCargo(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getJustificacion(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getValor().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

			}

			document.add(tablaEquipoP);

			PdfPTable tablaLeyedanda = new PdfPTable(1);
			tablaLeyedanda.setWidthPercentage(100);
			float[] columnWidthLey = new float[] { 100f };
			tablaLeyedanda.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("A. OBJETIVOS DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedanda.addCell(cell);
			document.add(tablaLeyedanda);

			//////////////////// OBJETIVO GENERAL

			PdfPTable tablaObjGeneral = new PdfPTable(2);

			tablaObjGeneral.setWidthPercentage(100);
			float[] columnWidthObjG = new float[] { 30f, 70f };
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Objetivo General", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjGeneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getObjetivos(), fuenteContenido));

			tablaObjGeneral.addCell(cell);

			document.add(tablaObjGeneral);

			PdfPTable tablaObjEsp = new PdfPTable(5);

			tablaObjEsp.setWidthPercentage(100);
			float[] columnWidthObjEsp = new float[] { 5f, 40f, 45f, 10f, 30f };
			tablaObjEsp.setWidths(columnWidthObjEsp);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Objetivos Específicos", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Resultados Obtenidos", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("% cumplimiento al \n" + cierre.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Justificación", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			for (int i = 0; i < objetivos.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getObjetivo().getDetalle(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getResultado(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getAvance().toString(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getJustificacion(), fuenteContenido));
				tablaObjEsp.addCell(cell);

			}

			document.add(tablaObjEsp);

			PdfPTable tablaObjGeneralPorcen = new PdfPTable(2);
			tablaObjGeneralPorcen.setWidthPercentage(100);
			tablaObjGeneral.setWidths(columnWidthObjG);
			cell = new PdfPCell(new Phrase("Porcentaje Total de Avance Acumulado del Proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjGeneralPorcen.addCell(cell);
			cell = new PdfPCell(new Phrase(cierre.getAvance().toString(), fuenteContenido));
			tablaObjGeneralPorcen.addCell(cell);
			document.add(tablaObjGeneralPorcen);

			///////// TABLA CRONOGRAMA///////////////////////////////

			PdfPTable tablaLeyedandaCrono = new PdfPTable(1);
			tablaLeyedandaCrono.setWidthPercentage(100);

			tablaLeyedandaCrono.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("B. CRONOGRAMA DE AVANCE DEL PROYECTO EN EL PERIODO " + cierre.getMeses(),
					fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaCrono.addCell(cell);
			document.add(tablaLeyedandaCrono);

			PdfPTable tablaActividades = new PdfPTable(9);

			tablaActividades.setWidthPercentage(100);
			float[] columnWidtAct = new float[] { 5f, 55f, 30f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaActividades.setWidths(columnWidtAct);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Actividades", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Justificación", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Meses", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setColspan(6);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("M1", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M2", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M3", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M4", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M5", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M6", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);

			for (int i = 0; i < actividades.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getCronograma().getNombreCr(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getJustificacion(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM12(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM34(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM56(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM78(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM910(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM1112(), fuenteContenido));
				tablaActividades.addCell(cell);

			}

			document.add(tablaActividades);

			PdfPTable tablaFirma = new PdfPTable(4);

			tablaFirma.setWidthPercentage(100);
			float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			tablaFirma.setWidths(columnWidtFir);

			cell = new PdfPCell(new Phrase("Firma del director del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			tablaFirma.addCell(createImageCell1(pathDocs + "/" + pathfirmaDr));

			cell = new PdfPCell(new Phrase("Firma del jefe de departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			tablaFirma.addCell(createImageCell1(pathDocs + "/" + pathfirmaJD));

			cell = new PdfPCell(new Phrase(
					"Nombre del Director:" + director.getApellidoPersonalPr() + " " + director.getNombrePersonalPr(),
					fuenteContenido));
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Nombre del Jefe Dept.:" + empleado.getApel() + " " + empleado.getNom(),
					fuenteContenido));

			tablaFirma.addCell(cell);

			document.add(tablaFirma);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			System.out.println("cerre el documento");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String generarPdfInvestifacionReportePlanicacionPreview(List<Recursoavance> recursos,
			List<Lineasproy> lineas, ProyectoP proyecto, List<Objetivoavance> objetivos,
			List<Cronogramaavance> actividades, String pathDocs, Emp autoridad, Pensum periodo, String sigla,
			String pathFirmaDir, String pathFirmaJefe, RecursohPr director, Dep dep, CierrePeriodo cierre,
			List<Proyectocarrera> carreras, List<Avanceestud> avanceEstud) {
		String url = "";
		try {

			System.out.println("Entro a crear archivo");
			// Creacion de un nuevo documento

			Document document = new Document(PageSize.A4);

			// Creacion del archivo

			FileOutputStream outputStream = new FileOutputStream(new File(pathDocs + "/" + proyecto.getCodigoPr().trim()
					+ "-" + INFORME_PLANIFICACION + "-" + periodo.getMeses() + ".pdf"));

			url = pathDocs + "/" + proyecto.getCodigoPr().trim() + "-" + INFORME_PLANIFICACION + "-"
					+ periodo.getMeses() + ".pdf";

			System.out.println("URL" + url);

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			writer.setPageEvent(new WatermarkPageEvent());
			// Se abre el archivo para crear
			document.open();
			// Variable para ocupar otro pdf como plantilla
			PdfContentByte cb = writer.getDirectContent();
			// Carga la plantilla

			String path = pathDocs + "/Plantilla.pdf";

			PdfReader reader = new PdfReader(path);

			PdfImportedPage page = writer.getImportedPage(reader, 1);

			document.newPage();
			cb.addTemplate(page, 0, 0);

			Paragraph datosContrato = new Paragraph();
			datosContrato.add("\n");

			PdfPTable cabecera = new PdfPTable(3);
			cabecera.setWidthPercentage(100);
			float[] columnWidthsCabecera = new float[] { 15f, 70f, 15f };
			cabecera.setWidths(columnWidthsCabecera);

			System.out.println("Se agrego la cabecera");

			cabecera.addCell(createImageCell(pathDocs + "/logo_epn.jpg"));
			cabecera.addCell(createLabelCabecera(
					"ESCUELA POLITECNICA NACIONAL\nVICERRECTORADO DE INVESTIGACIÓN, INNOVACIÓN Y VINCULACIÓN\nDIRECCIÓN DE INVESTIGACIÓN "));
			cabecera.addCell(createImageCell(pathDocs + "//150.png"));
			document.add(cabecera);

			com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 8, Font.BOLD);
			fuente.setSize(8);

			com.itextpdf.text.Font fuenteContenido = FontFactory.getFont("Arial", 8);
			fuenteContenido.setSize(8);

			com.itextpdf.text.Font fuenteLeyenda = FontFactory.getFont("Arial", 10, Font.BOLD);
			fuenteContenido.setSize(8);

			document.add(datosContrato);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "INFORME DE PLANIFICACIÓN DE PROYECTO DE INVESTIGACIÓN";
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			com.itextpdf.text.Font fuenteCabecera = FontFactory.getFont("Arial", 12, Font.BOLD);
			tituloTablaAcad.setFont(fuenteCabecera);

			tituloTablaAcad.add(cabeceraTabla);

			document.add(tituloTablaAcad);

			document.add(datosContrato);

			PdfPTable tablageneral = new PdfPTable(4);
			PdfPCell cell;
			tablageneral.setWidthPercentage(100);
			float[] columnWidthsdept = new float[] { 20f, 60f, 20f, 20f };
			tablageneral.setWidths(columnWidthsdept);
			cell = new PdfPCell(new Phrase("Departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(dep.getNomDep(), fuenteContenido));

			cell.setRowspan(2);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Codigo del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Periodo Académico", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			tablageneral.addCell(new Phrase(proyecto.getCodigoPr(), fuenteContenido));
			tablageneral.addCell(new Phrase(periodo.getMeses(), fuenteContenido));

			cell = new PdfPCell(new Phrase("Título del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getNombrePr(), fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			cell = new PdfPCell(new Phrase("Línea/s de investigación", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablageneral.addCell(cell);

			String linea = "";
			for (Lineasproy lin : lineas) {
				linea += lin.getLineas().getNomLinin() + "  ";
			}
			cell = new PdfPCell(new Phrase(linea, fuenteContenido));
			cell.setColspan(3);
			tablageneral.addCell(cell);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablageneral.addCell(cell);

				String carrera = "";
				for (Proyectocarrera car : carreras) {
					carrera += car.getNombre() + "  ";
				}
				cell = new PdfPCell(new Phrase(carrera, fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase("Organización Colaboradora", fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablageneral.addCell(cell);

				cell = new PdfPCell(new Phrase(proyecto.getBeneficiarioPr(), fuenteContenido));
				cell.setColspan(3);
				tablageneral.addCell(cell);

			}

			document.add(tablageneral);

			////////////////////// tabla equipo del
			////////////////////// proyecto////////////////////////

			
			PdfPTable tablaLeyedandaE = new PdfPTable(1);
			tablaLeyedandaE.setWidthPercentage(100);
			float[] columnWidthLey = new float[] { 100f };
			tablaLeyedandaE.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("A1. EQUIPO DE TRABAJO DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaE.addCell(cell);
			document.add(tablaLeyedandaE);
			PdfPTable tablaEquipoP = new PdfPTable(5);

			tablaEquipoP.setWidthPercentage(100);
			float[] columnWidthEqp = new float[] { 20f, 30f, 25f, 15f, 10f };
			tablaEquipoP.setWidths(columnWidthEqp);
			cell = new PdfPCell(new Phrase("Rol", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Dpto.", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Cargo actual en la EPN", fuente));
			cell.setBackgroundColor(new BaseColor(217, 217, 217));
			cell.setRowspan(2);
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Planificadas", fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			cell = new PdfPCell(new Phrase("Horas Semestre\n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(197, 217, 241));
			tablaEquipoP.addCell(cell);

			for (Recursoavance rec : recursos) {
				cell = new PdfPCell(new Phrase(rec.getRecurso().getRolProyecto().getRolProy(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(
						rec.getRecurso().getApellidoPersonalPr() + " " + rec.getRecurso().getNombrePersonalPr(),
						fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getRecurso().getDpto(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getRecurso().getCargo(), fuenteContenido));
				tablaEquipoP.addCell(cell);

				cell = new PdfPCell(new Phrase(rec.getValor().toString(), fuenteContenido));
				tablaEquipoP.addCell(cell);

			}

			document.add(tablaEquipoP);

			if (proyecto.getTipoProyecto().getIdTipoProy() == 4) {

				////////////////////// tabla equipo del
				////////////////////// proyecto////////////////////////

				PdfPTable tablaLeyedanda = new PdfPTable(1);
				tablaLeyedanda.setWidthPercentage(100);
				
				tablaLeyedanda.setWidths(columnWidthLey);
				cell = new PdfPCell(new Phrase("A2. ESTUDIANTES", fuenteLeyenda));
				cell.setBackgroundColor(new BaseColor(226, 107, 10));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tablaLeyedanda.addCell(cell);
				document.add(tablaLeyedanda);
				
				
				PdfPTable tablaEstud = new PdfPTable(6);

				tablaEstud.setWidthPercentage(100);
				float[] columnWidthest = new float[] { 20f, 20f, 25f, 15f, 10f, 10f };
				tablaEstud.setWidths(columnWidthest);

				cell = new PdfPCell(new Phrase("Apellidos y Nombres", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Cédula.", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Carrera", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));

				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Vinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("F. Desvinculación", fuente));
				cell.setBackgroundColor(new BaseColor(217, 217, 217));
				tablaEstud.addCell(cell);

				cell = new PdfPCell(new Phrase("Horas Dedicación", fuente));
				cell.setBackgroundColor(new BaseColor(197, 217, 241));
				tablaEstud.addCell(cell);

				for (Avanceestud avac : avanceEstud) {
					cell = new PdfPCell(new Phrase(avac.getEstudiante().getNombre(), fuente));

					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getEstudiante().getCedula(), fuenteContenido));
					tablaEstud.addCell(cell);

					cell = new PdfPCell(new Phrase(avac.getEstudiante().getCarrera(), fuenteContenido));
					tablaEstud.addCell(cell);

					if (avac.getEstudiante().getFechaVincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(
								new Phrase(avac.getEstudiante().getFechaVincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					if (avac.getEstudiante().getFechaDesvincula() == null) {
						cell = new PdfPCell(new Phrase("", fuenteContenido));
						tablaEstud.addCell(cell);
					}

					else {

						cell = new PdfPCell(
								new Phrase(avac.getEstudiante().getFechaDesvincula().toString(), fuenteContenido));
						tablaEstud.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(avac.getAvance().toString(), fuenteContenido));
					tablaEstud.addCell(cell);

				}

				document.add(tablaEstud);
			}

			PdfPTable tablaLeyedanda = new PdfPTable(1);
			tablaLeyedanda.setWidthPercentage(100);
			
			tablaLeyedanda.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("B. OBJETIVOS DEL PROYECTO", fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedanda.addCell(cell);
			document.add(tablaLeyedanda);

			//////////////////// OBJETIVO GENERAL

			PdfPTable tablaObjGeneral = new PdfPTable(2);

			tablaObjGeneral.setWidthPercentage(100);
			float[] columnWidthObjG = new float[] { 30f, 70f };
			tablaObjGeneral.setWidths(columnWidthObjG);

			cell = new PdfPCell(new Phrase("Objetivo General", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjGeneral.addCell(cell);

			cell = new PdfPCell(new Phrase(proyecto.getObjetivos(), fuenteContenido));

			tablaObjGeneral.addCell(cell);

			document.add(tablaObjGeneral);

			PdfPTable tablaObjEsp = new PdfPTable(4);

			tablaObjEsp.setWidthPercentage(100);
			float[] columnWidthObjEsp = new float[] { 5f, 40f, 45f, 10f };
			tablaObjEsp.setWidths(columnWidthObjEsp);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Objetivos Específicos", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("Resultados Obtenidos", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			cell = new PdfPCell(new Phrase("% cumplimiento al \n" + periodo.getMeses(), fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjEsp.addCell(cell);

			for (int i = 0; i < objetivos.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getObjetivo().getDetalle(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getResultado(), fuenteContenido));
				tablaObjEsp.addCell(cell);

				cell = new PdfPCell(new Phrase(objetivos.get(i).getAvance().toString(), fuenteContenido));
				tablaObjEsp.addCell(cell);

			}

			document.add(tablaObjEsp);

			PdfPTable tablaObjGeneralPorcen = new PdfPTable(2);
			tablaObjGeneralPorcen.setWidthPercentage(100);
			tablaObjGeneral.setWidths(columnWidthObjG);
			cell = new PdfPCell(new Phrase("Porcentaje Total de Avance Acumulado del Proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaObjGeneralPorcen.addCell(cell);
			cell = new PdfPCell(new Phrase(cierre.getAvance().toString(), fuenteContenido));
			tablaObjGeneralPorcen.addCell(cell);
			document.add(tablaObjGeneralPorcen);

			///////// TABLA CRONOGRAMA///////////////////////////////

			PdfPTable tablaLeyedandaCrono = new PdfPTable(1);
			tablaLeyedandaCrono.setWidthPercentage(100);

			tablaLeyedandaCrono.setWidths(columnWidthLey);
			cell = new PdfPCell(new Phrase("C. CRONOGRAMA DE AVANCE DEL PROYECTO EN EL PERIODO " + periodo.getMeses(),
					fuenteLeyenda));
			cell.setBackgroundColor(new BaseColor(226, 107, 10));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tablaLeyedandaCrono.addCell(cell);
			document.add(tablaLeyedandaCrono);

			PdfPTable tablaActividades = new PdfPTable(8);

			tablaActividades.setWidthPercentage(100);
			float[] columnWidtAct = new float[] { 5f, 65f, 5f, 5f, 5f, 5f, 5f, 5f };
			tablaActividades.setWidths(columnWidtAct);

			cell = new PdfPCell(new Phrase("N°", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Actividades", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("Meses", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setColspan(6);
			tablaActividades.addCell(cell);

			cell = new PdfPCell(new Phrase("M1", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M2", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M3", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M4", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M5", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);
			cell = new PdfPCell(new Phrase("M6", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			tablaActividades.addCell(cell);

			for (int i = 0; i < actividades.size(); i++) {
				Integer numeral = i + 1;

				cell = new PdfPCell(new Phrase(numeral.toString(), fuente));
				cell.setBackgroundColor(new BaseColor(252, 213, 180));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getCronograma().getNombreCr(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM12(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM34(), fuenteContenido));
				tablaActividades.addCell(cell);

				cell = new PdfPCell(new Phrase(actividades.get(i).getM56(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM78(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM910(), fuenteContenido));
				tablaActividades.addCell(cell);
				cell = new PdfPCell(new Phrase(actividades.get(i).getM1112(), fuenteContenido));
				tablaActividades.addCell(cell);

			}

			document.add(tablaActividades);

			PdfPTable tablaFirma = new PdfPTable(4);

			tablaFirma.setWidthPercentage(100);
			float[] columnWidtFir = new float[] { 15f, 35f, 15f, 35f };
			tablaFirma.setWidths(columnWidtFir);

			cell = new PdfPCell(new Phrase("Firma del director del proyecto", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (pathFirmaDir == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathFirmaDir);
			}

			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Firma del jefe de departamento", fuente));
			cell.setBackgroundColor(new BaseColor(252, 213, 180));
			cell.setRowspan(2);
			tablaFirma.addCell(cell);

			if (pathFirmaJefe == null) {
				cell = new PdfPCell(new Phrase("", fuenteContenido));
				cell.setFixedHeight(40f);
			} else {
				cell = createImageCell1(pathFirmaJefe);
			}
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase(
					"Nombre del Director:" + director.getApellidoPersonalPr() + "-" + director.getNombrePersonalPr(),
					fuenteContenido));
			tablaFirma.addCell(cell);

			cell = new PdfPCell(new Phrase("Nombre del Jefe Dept.: " + autoridad.getApel() + " " + autoridad.getNom(),
					fuenteContenido));

			tablaFirma.addCell(cell);

			document.add(tablaFirma);

			document.add(datosContrato);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			String fechaComoCadena = "";
			String fechaComoCadena1 = "";

			if (cierre.getFechacierredocente() == null) {
				fechaComoCadena = "Sin envío JD.";

			} else {
				fechaComoCadena = sdf.format(cierre.getFechacierredocente());
			}

			if (cierre.getFechacierrejd() == null) {
				fechaComoCadena1 = "Sin envío DI.";

			} else {
				fechaComoCadena1 = sdf.format(cierre.getFechacierrejd());
			}

			Paragraph ingreso = new Paragraph();
			String ing = "\n Fecha envío Jefe Departamento: " + fechaComoCadena;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso.setFont(fuente);
			ingreso.setAlignment(Element.ALIGN_LEFT);
			ingreso.add(ing);

			document.add(ingreso);

			Paragraph ingreso2 = new Paragraph();
			String ing2 = "\n Fecha envío a la DIrección de Investigación: " + fechaComoCadena1;
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			ingreso2.setFont(fuente);
			ingreso2.setAlignment(Element.ALIGN_LEFT);
			ingreso2.add(ing2);

			document.add(ingreso2);

			document.close();

			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			System.out.println("cerre el documento");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private static DecimalFormat df2 = new DecimalFormat(".##");

	public String generarPDFConsultaDocente(Emp empleado, List<Familiare> famileiares,
			List<TituloFormacionAcademica> instruccion, List<Eventocapac> capac, List<Publicacione> publicacionesReport,
			String foto, String pathDocs) {
		String url = "";
		try {
			Document document = new Document(PageSize.A4);

			FileOutputStream outputStream = new FileOutputStream(
					new File(pathDocs + "/" + empleado.getNced().trim() + ".pdf"));
			url = pathDocs + "/" + empleado.getNced().trim() + ".pdf";
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			String path = pathDocs + "/Plantilla.pdf";
			PdfReader reader = new PdfReader(path);
			PdfImportedPage page = writer.getImportedPage(reader, 1);
			document.newPage();
			cb.addTemplate(page, 0, 0);
			Paragraph p = new Paragraph();
			Image img = Image.getInstance(pathDocs + "/logo_epn.jpg");
			img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
			img.scaleToFit(75, 65);
			p.add(img);
			document.add(p);
			com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
			Paragraph tituloTablaAcad = new Paragraph();
			String cabeceraTabla = "ESCUELA POLITÉCNICA NACIONAL";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);

			String cabeceraTabla1 = "\nCampus José Rubén Orellana Ricaurte \n\n ";

			tituloTablaAcad.setFont(fuente);
			tituloTablaAcad.setAlignment(Element.ALIGN_CENTER);
			tituloTablaAcad.add(cabeceraTabla);
			tituloTablaAcad.add(cabeceraTabla1);
			document.add(tituloTablaAcad);

			Paragraph pfoto = new Paragraph();

			System.out.println("imagen" + foto);
			Image imgemp = Image.getInstance(foto);

			imgemp.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
			imgemp.setBorder(5);
			imgemp.scaleToFit(110, 120);

			pfoto.add(imgemp);
			document.add(pfoto);

			Paragraph tituloTablaAcad2 = new Paragraph();
			String cabeceraTabla2 = "\nINFORMACIÓN PERSONAL \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			tituloTablaAcad2.setFont(fuente);
			tituloTablaAcad2.setAlignment(Element.ALIGN_CENTER);
			tituloTablaAcad2.add(cabeceraTabla2);
			document.add(tituloTablaAcad2);

			PdfPTable datosPersonales = new PdfPTable(4);
			datosPersonales.setWidthPercentage(100);
			float[] columnWidths2 = new float[] { 50f, 50f, 50f, 50f };
			datosPersonales.setWidths(columnWidths2);

			datosPersonales.addCell(createLabelCell5("Apellidos:"));
			datosPersonales.addCell(createLabelCell6(empleado.getApel()));
			datosPersonales.addCell(createLabelCell5("Nombres:"));
			datosPersonales.addCell(createLabelCell6(empleado.getNom()));
			datosPersonales.addCell(createLabelCell5("Libreta militar:"));
			datosPersonales.addCell(createLabelCell6(empleado.getNcedm()));
			datosPersonales.addCell(createLabelCell5(""));
			datosPersonales.addCell(createLabelCell5(""));
			datosPersonales.addCell(createLabelCell5("Nacionalidad:"));
			datosPersonales.addCell(createLabelCell6(empleado.getLnac()));
			datosPersonales.addCell(createLabelCell5("Años Residencia (Ecuador):"));
			datosPersonales.addCell(createLabelCell6(empleado.getResidencia().toString()));
			datosPersonales.addCell(createLabelCell5("País:"));
			datosPersonales.addCell(createLabelCell6(empleado.getPais()));
			datosPersonales.addCell(createLabelCell5("Provincia:"));
			datosPersonales.addCell(createLabelCell6(empleado.getProvincia()));
			datosPersonales.addCell(createLabelCell5("Fecha de Nacimiento:"));
			datosPersonales.addCell(createLabelCell6(empleado.getFnac().toString()));
			datosPersonales.addCell(createLabelCell5("Género:"));
			datosPersonales.addCell(createLabelCell6(empleado.getGenero().getDescSexo()));
			datosPersonales.addCell(createLabelCell5("Tipo de sangre:"));
			datosPersonales.addCell(createLabelCell6(empleado.getTipsan()));
			datosPersonales.addCell(createLabelCell5("Estado Civil:"));
			datosPersonales.addCell(createLabelCell6(empleado.getEcivil().getDescEcivil()));
			datosPersonales.addCell(createLabelCell5("Discapacidad:"));
			datosPersonales.addCell(createLabelCell6(empleado.getDiscapacidad()));
			datosPersonales.addCell(createLabelCell5("Número de Carné CONADIS:"));
			datosPersonales.addCell(createLabelCell6(empleado.getNrocarnetconadis()));
			datosPersonales.addCell(createLabelCell5("Tipo de Discapacidad:"));
			datosPersonales.addCell(createLabelCell6(empleado.getTipodiscap()));
			datosPersonales.addCell(createLabelCell5("% Discapacidad:"));
			datosPersonales.addCell(createLabelCell6(empleado.getPorcendiscap()));
			datosPersonales.addCell(createLabelCell5("Identificación Étnica:"));
			datosPersonales.addCell(createLabelCell6(empleado.getEtnia()));

			datosPersonales.addCell(createLabelCell5("Nacionalidad Indígena:"));
			datosPersonales.addCell(createLabelCell6(empleado.getEtindigena()));
			datosPersonales.addCell(createLabelCell5("Enfermedad Catastrófica:"));
			datosPersonales.addCell(createLabelCell6(empleado.getEnfermedades()));
			datosPersonales.addCell(createLabelCell5("Visa:"));
			datosPersonales.addCell(createLabelCell6(empleado.getVisa()));
			datosPersonales.addCell(createLabelCell5("Fecha de Caducidad:"));

			if (empleado.getFechaexpira() == null) {
				datosPersonales.addCell(createLabelCell6(""));
			} else {
				datosPersonales.addCell(createLabelCell6(empleado.getFechaexpira().toString()));
			}

			document.add(datosPersonales);

			Paragraph datosContrato = new Paragraph();

			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.ITALIC);

			datosContrato.add("\n");
			datosContrato.setFont(fuente);
			// datosContrato.add(datosCont);
			document.add(datosContrato);

			Paragraph direccion = new Paragraph();
			String direccios = "\nDIRECCIÓN DOMICILIARIA \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			direccion.setFont(fuente);
			direccion.setAlignment(Element.ALIGN_CENTER);
			direccion.add(direccios);
			document.add(direccion);

			PdfPTable datosDireccion = new PdfPTable(4);
			datosDireccion.setWidthPercentage(100);
			float[] columnWidths3 = new float[] { 50f, 50f, 50f, 50f };
			datosDireccion.setWidths(columnWidths3);

			datosDireccion.addCell(createLabelCell5("Parroquia:"));
			datosDireccion.addCell(createLabelCell6(empleado.getParroquiaDom()));
			datosDireccion.addCell(createLabelCell5(""));
			datosDireccion.addCell(createLabelCell5(""));
			datosDireccion.addCell(createLabelCell5("Calle Principal:"));
			datosDireccion.addCell(createLabelCell6(empleado.getCallePrincipal()));
			datosDireccion.addCell(createLabelCell5("Calle Secundaria:"));
			datosDireccion.addCell(createLabelCell6(empleado.getCalleSecundaria()));
			datosDireccion.addCell(createLabelCell5("Número:"));
			datosDireccion.addCell(createLabelCell6(empleado.getNrocasa()));
			datosDireccion.addCell(createLabelCell5("Referencia:"));
			datosDireccion.addCell(createLabelCell6(empleado.getReferenciaDom()));
			datosDireccion.addCell(createLabelCell5("Teléfono Domicilio:"));
			datosDireccion.addCell(createLabelCell6(empleado.getTelf()));
			datosDireccion.addCell(createLabelCell5("Teléfono Celular:"));
			datosDireccion.addCell(createLabelCell6(empleado.getTelefcel()));
			datosDireccion.addCell(createLabelCell5("Teléfono trabajo:"));
			datosDireccion.addCell(createLabelCell6(empleado.getTelf1()));
			datosDireccion.addCell(createLabelCell5("Extensión:"));
			datosDireccion.addCell(createLabelCell6(empleado.getExt()));
			datosDireccion.addCell(createLabelCell5("Correo Institucional:"));
			datosDireccion.addCell(createLabelCell6(empleado.getEmail1()));
			datosDireccion.addCell(createLabelCell5("Correo Personal:"));
			datosDireccion.addCell(createLabelCell6(empleado.getEmail2()));

			document.add(datosDireccion);

			document.add(datosContrato);

			Paragraph contacto = new Paragraph();
			String contactoE = "\nINFORMACIÓN CONTACTO DE EMERGENCIA \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			contacto.setFont(fuente);
			contacto.setAlignment(Element.ALIGN_CENTER);
			contacto.add(contactoE);
			document.add(contacto);

			PdfPTable datosContacto = new PdfPTable(4);
			datosContacto.setWidthPercentage(100);

			datosContacto.setWidths(columnWidths3);

			datosContacto.addCell(createLabelCell5("Apellidos:"));
			datosContacto.addCell(createLabelCell6(empleado.getApelCon()));
			datosContacto.addCell(createLabelCell5("Nombres:"));
			datosContacto.addCell(createLabelCell6(empleado.getNomCon()));
			datosContacto.addCell(createLabelCell5("Parentesco:"));
			datosContacto.addCell(createLabelCell6(empleado.getParContacto()));
			datosContacto.addCell(createLabelCell5(""));
			datosContacto.addCell(createLabelCell6(""));
			datosContacto.addCell(createLabelCell5("Teléfono Contacto:"));
			datosContacto.addCell(createLabelCell6(empleado.getTelfContacto()));
			datosContacto.addCell(createLabelCell5("Teléfono Celular:"));
			datosContacto.addCell(createLabelCell6(empleado.getCelContacto()));

			document.add(datosContacto);

			document.add(datosContrato);

			document.add(datosContrato);
			document.add(datosContrato);
			document.add(datosContrato);

			Paragraph fam = new Paragraph();
			String familiares = "\nFAMILIARES \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			fam.setFont(fuente);
			fam.setAlignment(Element.ALIGN_CENTER);
			fam.add(familiares);
			document.add(fam);

			PdfPTable datosfamiliares = new PdfPTable(6);
			datosfamiliares.setWidthPercentage(100);
			float[] columnWidths = new float[] { 35f, 35f, 22f, 20f, 25f, 20f };
			datosfamiliares.setWidths(columnWidths);

			datosfamiliares.addCell(createLabelCell("Nombres"));
			datosfamiliares.addCell(createLabelCell("Apellidos"));
			datosfamiliares.addCell(createLabelCell("Cédula"));
			datosfamiliares.addCell(createLabelCell("Parentesco"));
			datosfamiliares.addCell(createLabelCell("Discapacidad"));
			datosfamiliares.addCell(createLabelCell("Tipo Discap."));

			for (Familiare familia : famileiares) {
				datosfamiliares.addCell(createLabelCell4(familia.getNomFamiliar()));
				datosfamiliares.addCell(createLabelCell4(familia.getApelFam()));
				datosfamiliares.addCell(createLabelCell4(familia.getNrodocumento()));
				datosfamiliares.addCell(createLabelCell4(familia.getRelacion()));
				datosfamiliares.addCell(createLabelCell4(familia.getDiscapacidad()));
				datosfamiliares.addCell(createLabelCell4(familia.getTipodis()));
			}

			document.add(datosfamiliares);

			document.add(datosContrato);

			Paragraph FOR = new Paragraph();
			String formacion = "\nFORMACIÓN PROFESIONAL \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			FOR.setFont(fuente);
			FOR.setAlignment(Element.ALIGN_CENTER);
			FOR.add(formacion);
			document.add(FOR);

			PdfPTable datosinstruccion = new PdfPTable(5);
			datosinstruccion.setWidthPercentage(100);
			datosinstruccion.addCell(createLabelCell("Institución"));
			datosinstruccion.addCell(createLabelCell("Nivel Instruccíon"));
			datosinstruccion.addCell(createLabelCell("Título"));
			datosinstruccion.addCell(createLabelCell("Fecha"));
			datosinstruccion.addCell(createLabelCell("# Senecyt"));

			for (TituloFormacionAcademica ins : instruccion) {
				datosinstruccion.addCell(createLabelCell4(ins.getUniversidad().getNomUniversid()));
				datosinstruccion.addCell(createLabelCell4(ins.getNivel().getNomNivel()));
				datosinstruccion.addCell(createLabelCell4(ins.getNombreTitulo()));
				datosinstruccion.addCell(createLabelCell4(ins.getFecRegSenescyt().toString()));
				datosinstruccion.addCell(createLabelCell4(ins.getRegSenescyt()));
			}

			document.add(datosinstruccion);

			document.add(datosContrato);

			Paragraph cap = new Paragraph();
			String capacitacion = "\nCAPACITACIONES \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			cap.setFont(fuente);
			cap.setAlignment(Element.ALIGN_CENTER);
			cap.add(capacitacion);
			document.add(cap);

			PdfPTable datosCapacitaciones = new PdfPTable(7);
			datosCapacitaciones.setWidthPercentage(100);
			float[] columnWidthsins7 = new float[] { 35f, 35f, 22f, 20f, 25f, 25f, 25f };
			datosCapacitaciones.setWidths(columnWidthsins7);

			datosCapacitaciones.addCell(createLabelCell("Evento"));
			datosCapacitaciones.addCell(createLabelCell("País"));
			datosCapacitaciones.addCell(createLabelCell("Institución"));
			datosCapacitaciones.addCell(createLabelCell("Tipo Certificado"));
			datosCapacitaciones.addCell(createLabelCell("Fecha Inicio"));
			datosCapacitaciones.addCell(createLabelCell("Fecha Fin"));
			datosCapacitaciones.addCell(createLabelCell("Duracion (Horas)"));

			for (Eventocapac capacitaciones : capac) {
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getNombre()));
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getNomPais()));
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getLugar()));
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getTipocertificado()));
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getFechadesde().toString()));
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getFechahasta().toString()));
				datosCapacitaciones.addCell(createLabelCell4(capacitaciones.getDuracion()));
			}

			document.add(datosCapacitaciones);

			document.add(datosContrato);

			Paragraph pub = new Paragraph();
			String publicaion = "\n PUBLICACIONES Y OTRAS PARTICIPACIONES  \n\n";
			fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
			pub.setFont(fuente);
			pub.setAlignment(Element.ALIGN_CENTER);
			pub.add(publicaion);
			document.add(pub);

			PdfPTable datospublicaciones = new PdfPTable(5);
			datospublicaciones.setWidthPercentage(100);
			float[] columnWidthsins8 = new float[] { 35f, 35f, 22f, 20f, 25f };
			datospublicaciones.setWidths(columnWidthsins8);

			datospublicaciones.addCell(createLabelCell("Evento"));
			datospublicaciones.addCell(createLabelCell("Lugar"));
			datospublicaciones.addCell(createLabelCell("Tipo"));
			datospublicaciones.addCell(createLabelCell("Publicación-Participación"));
			datospublicaciones.addCell(createLabelCell("Fecha"));

			for (Publicacione publiciones : publicacionesReport) {
				datospublicaciones.addCell(createLabelCell4(publiciones.getTipoActividad()));
				datospublicaciones.addCell(createLabelCell4(publiciones.getMedio()));
				datospublicaciones.addCell(createLabelCell4(publiciones.getTipoPublicacion().getNombreTipoPublic()));
				datospublicaciones.addCell(createLabelCell4(publiciones.getTituloPublic()));
				datospublicaciones.addCell(createLabelCell4(publiciones.getFechaPublic()));
			}

			document.add(datospublicaciones);

			document.close();
			writer.close();

			cb.closePath();
			reader.close();
			page.closePath();

			return url;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	private String anioo;
	private String mes;
	private String dia;

	public void fechas(Date fechaHoy) {

		DateFormat fechaActualAdj1 = new SimpleDateFormat("yyyy/MM/dd");
		String convertido = fechaActualAdj1.format(fechaHoy);
		anioo = convertido.substring(0, 4);
		System.out.println("AÑOOOO" + anioo);
		mes = convertido.substring(5, 7);
		System.out.println("MESSS*-*-*-" + mes);

		dia = convertido.substring(8, 10);
		System.out.println("DIA" + dia);
		if (mes.equals("01")) {
			mes = "Enero";
		} else if (mes.equals("02")) {
			mes = "Febrero";
		} else if (mes.equals("03")) {
			mes = "Marzo";
		} else if (mes.equals("04")) {
			mes = "Abril";
		} else if (mes.equals("05")) {
			mes = "Mayo";
		} else if (mes.equals("06")) {
			mes = "Junio";
		} else if (mes.equals("07")) {
			mes = "Julio";
		} else if (mes.equals("08")) {
			mes = "Agosto";
		} else if (mes.equals("09")) {
			mes = "Septiembre";
		} else if (mes.equals("10")) {
			mes = "Octubre";
		} else if (mes.equals("11")) {
			mes = "Noviembre";
		} else if (mes.equals("12")) {
			mes = "Diciembre";
		}

	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));

		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);

		// set style

		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell1(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.BOLD);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);

		// set style

		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell2(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.BOLD);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));

		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(new BaseColor(0, 121, 182));

		// set style
		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell3(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));

		cell.setHorizontalAlignment(Element.ALIGN_LEFT);

		// set style

		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell4(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));

		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

		// set style

		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCabecera(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont("Arial", 10, Font.BOLD);
		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// set style
		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell5(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));
		cell.setBorder(Rectangle.NO_BORDER);

		cell.setHorizontalAlignment(Element.ALIGN_LEFT);

		// set style

		return cell;
	}

	@SuppressWarnings("unused")
	private static PdfPCell createLabelCell6(String text) {
		// font
		com.itextpdf.text.Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

		// create cell
		PdfPCell cell = new PdfPCell(new Phrase(text, fuente));
		cell.setBorder(Rectangle.NO_BORDER);
		// cell.setCellEvent(new SpecialRoundedCell());
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);

		// set style

		return cell;
	}

	public String getAnioo() {
		return anioo;
	}

	public void setAnioo(String anioo) {
		this.anioo = anioo;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}

class SpecialRoundedCell implements PdfPCellEvent {
	public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
		PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
		float llx = position.getLeft() + 2;
		float lly = position.getBottom() + 2;
		float urx = position.getRight() - 2;
		float ury = position.getTop() - 2;
		float r = 4;
		float b = 0.4477f;
		canvas.moveTo(llx, lly);
		canvas.lineTo(urx, lly);
		canvas.lineTo(urx, ury - r);
		canvas.curveTo(urx, ury - r * b, urx - r * b, ury, urx - r, ury);
		canvas.lineTo(llx + r, ury);
		canvas.curveTo(llx + r * b, ury, llx, ury - r * b, llx, ury - r);
		canvas.lineTo(llx, lly);
		canvas.stroke();
	}

}
