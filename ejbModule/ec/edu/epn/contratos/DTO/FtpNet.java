package ec.edu.epn.contratos.DTO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.edu.epn.contratos.beans.PedidoDAO;
import ec.edu.epn.contratos.beans.documentoDAO;
import ec.edu.epn.contratos.entities.Documento;
import ec.edu.epn.contratos.entities.Pedido;

public class FtpNet {

	/* VARIABLES DE SERVICIO */

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PedidoDAOImplement!ec.edu.epn.contratos.beans.PedidoDAO")
	private PedidoDAO pedidoI;
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/documentoDAOImplement!ec.edu.epn.contratos.beans.documentoDAO")
	private documentoDAO docI;
	/**************************/

	/* VARIABLES */
	private String destination = "/ws/";
	private String cedula = "";
	private InputStream stream = null;
	private String localPath = "";
	private String nombreArchivo = "";
	private FTPClient ftpClient;
	private String stylemsgDownload = "";
	private String msgDownload = "";
	private InputStream archivo = null;
	private String nombre = "";
	private StreamedContent StreamFile = null;

	@PostConstruct
	public void init() {

	}

	// CONSTRUCTOR
	public FtpNet() {
	}

	public FtpNet(String cedula) {
		this.cedula = cedula;
	}

	// Metod para vaerificar la conexion al servidor FTP
	public boolean conectarFTP() {
		ftpClient = new FTPClient();
		System.out.println("Metodo para Conexion al FTP");
		try {
			//ftpClient.connect(InetAddress.getByName("172.31.4.130"));
			//ftpClient.login("pca", "12345678");

			 ftpClient.connect(InetAddress.getByName("172.31.203.225"));
			 ftpClient.login("wilson", "wilson");
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.setFileTransferMode(FTPClient.STREAM_TRANSFER_MODE);
			int reply = ftpClient.getReplyCode();
			if (FTPReply.isPositiveCompletion(reply)) {
				System.out.println("Conectado Satisfactoriamente");
				return true;
			} else {
				System.out.println("Imposible conectarse al servidor");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// report maganoob

	// Metodo apra eliminar archivos del FTP
	public void eliminarArchivo(Documento documento) {
		conectarFTP();
		try {

			ftpClient.changeWorkingDirectory(documento.getPed().getNced() + "_cedula");

			String archivo = "";
			String[] nombreArchivo = documento.getPathDocumento().split("/");
			archivo = nombreArchivo[1];
			System.out.println("ARCHIVO SOLO EN EL FTP: " + archivo);
			if (ftpClient.deleteFile(archivo)) {
				System.out.println("Archivo eliminado desde el FTP");
			} else
				System.out.println("Archivo NO eliminado desde el FTP");

			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en descargarArch: " + e.getMessage());
		}
	}
	
	
	
	
	// ELIMINA LOS ARCHIVOS DE TITULACION FORMACION ACADEMICA
		public void eliminarArchivoDocente(String path) {
			conectarFTP();
			try {
				if(!path.equals("")){
					ftpClient.changeWorkingDirectory(cedula + "_cedula");

					String archivo = "";
					String[] nombreArchivo = path.split("/");
					archivo = nombreArchivo[1];					
					if (ftpClient.deleteFile(archivo)) {
						System.out.println("Archivo eliminado desde el FTP");
					} else
						System.out.println("Archivo NO eliminado desde el FTP");

					ftpClient.logout();
					ftpClient.disconnect();
				}

				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en descargarArch: " + e.getMessage());
			}
		}
	

	public boolean enviarDocumento() throws IOException {
		try {
			if (conectarFTP()) {
				String cedulaUsuario = this.cedula;
				String carpeta = cedulaUsuario + "_cedula";
				int creacion = (ftpClient.mkd(carpeta));
				ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.enterLocalPassiveMode();
				ftpClient.storeFile(getNombreArchivo(), archivo);
				ftpClient.logout();
				ftpClient.disconnect();
				return true;
			} else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Metodo para enviar el archivo al FTP
	public void enviarArchivoPedido() throws IOException {
		System.out.println("METODO para enviar archivos al FTP");
		try {
			BufferedInputStream buffIn = null;
			String cedulaUsuario = this.cedula;
			int id_evidencia = pedidoI.consultarId() - 1;
			String carpeta = cedulaUsuario + "_cedula";
			int creacion = (ftpClient.mkd(carpeta));

			ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			buffIn = new BufferedInputStream(new FileInputStream(getLocalPath()));
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(getNombreArchivo(), buffIn);
			System.out.println("archivo creado en carpeta existenete");

			id_evidencia = id_evidencia + 1;
			String url = cedulaUsuario + "_cedula/" + getNombreArchivo();

			Pedido ped = (Pedido) pedidoI.getById(Pedido.class, pedidoI.consultarId() - 1);
			ped.setPathArchivo(url);
			pedidoI.update(ped);

			Documento doc = new Documento();
			doc.setIdDocuemnto(docI.consultarId());
			doc.setPed(ped);
			doc.setPathDocumento(url);
			doc.setNombreDocumento(nombre);

			docI.save(doc);

			buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error en FTP enviarArchivo");
		}
	}

	// Metodo para enviar el archivo al FTP
	public void enviarArchivo() throws IOException {
		System.out.println("METODO para enviar archivos al FTP");
		try {
			// BufferedInputStream buffIn = null;
			String cedulaUsuario = this.cedula;
			int id_evidencia = pedidoI.consultarId() - 1;
			String carpeta = cedulaUsuario + "_cedula";
			int creacion = (ftpClient.mkd(carpeta));

			ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			// buffIn = archivo;
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(getNombreArchivo(), archivo);
			System.out.println("archivo creado en carpeta existenete");

			id_evidencia = id_evidencia + 1;
			String url = cedulaUsuario + "_cedula/" + getNombreArchivo();

			Pedido ped = (Pedido) pedidoI.getById(Pedido.class, pedidoI.consultarId() - 1);
			ped.setPathArchivo(url);
			pedidoI.update(ped);

			Documento doc = new Documento();
			doc.setIdDocuemnto(docI.consultarId());
			doc.setPed(ped);
			doc.setPathDocumento(url);
			doc.setNombreDocumento(nombre);

			docI.save(doc);

			// buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error en FTP enviarArchivo");
		}
	}

	// Metodo para enviar el archivo al FTP
	public void enviarArchivo1(Pedido pedido) throws IOException {
		System.out.println("METODO para enviar archivos al FTP");
		try {
			// BufferedInputStream buffIn = null;
			String cedulaUsuario = this.cedula;
			int id_evidencia = pedidoI.consultarId() - 1;
			String carpeta = cedulaUsuario + "_cedula";
			int creacion = (ftpClient.mkd(carpeta));

			ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			// buffIn = archivo;
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(getNombreArchivo(), archivo);
			System.out.println("archivo creado en carpeta existenete");

			id_evidencia = id_evidencia + 1;
			String url = cedulaUsuario + "_cedula/" + getNombreArchivo();

			Pedido ped = pedido;

			ped.setPathArchivo(url);
			pedidoI.update(ped);

			Documento doc = new Documento();
			doc.setIdDocuemnto(docI.consultarId());
			doc.setPed(ped);
			doc.setPathDocumento(url);
			doc.setNombreDocumento(nombre);

			docI.save(doc);

			// buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error en FTP enviarArchivo");
		}
	}

	public void enviar2Archivo(Pedido pedido) throws IOException {
		System.out.println("METODO para enviar archivos al FTP");
		try {
			BufferedInputStream buffIn = null;
			String cedulaUsuario = this.cedula;
			int id_evidencia = pedido.getIdPedido();
			String carpeta = cedulaUsuario + "_cedula";
			int creacion = (ftpClient.mkd(carpeta));

			ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			buffIn = new BufferedInputStream(new FileInputStream(getLocalPath()));
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(getNombreArchivo(), buffIn);
			System.out.println("archivo creado en carpeta existenete");

			id_evidencia = id_evidencia + 1;
			String url = cedulaUsuario + "_cedula/" + getNombreArchivo();

			Pedido ped = pedido;
			ped.setPathArchivo(url);
			pedidoI.update(ped);

			Documento doc = new Documento();
			doc.setIdDocuemnto(docI.consultarId());
			doc.setPed(ped);
			doc.setPathDocumento(url);

			docI.save(doc);

			buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error en FTP enviarArchivo");
		}
	}

	// METODO PARA DESCARGAR ARCHIVOS
	public void descargarArch2(Documento documento) {
		System.out.println("METODO para bajar archivos del FTP");
		String words[] = documento.getPathDocumento().split("/");
		String nombre = "";

		nombre = words[1];
		conectarFTP();
		try {
			FileOutputStream fout = null;
			ftpClient.changeWorkingDirectory(documento.getPed().getIdPedido() + "_cedula");
			stream = ftpClient.retrieveFileStream(ftpClient.printWorkingDirectory() + "/" + nombre);
			StreamFile = new DefaultStreamedContent(stream, "application/pdf", nombre);
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en descargarArch: " + e.getMessage());
		} finally {
		}
	}

	// METODO PARA DESCARGAR ARCHIVOS
	public void descargarArch(Documento documento) {
		System.out.println("METODO para bajar archivos del FTP");
		String words[] = documento.getPathDocumento().split("/");
		String nombre = "";

		nombre = words[1];
		conectarFTP();

		System.out.println("DIRECTORIOS: " + destination);
		File directorio = new File(destination);
		try {
			FileOutputStream fout = null;
			ftpClient.changeWorkingDirectory(documento.getPed().getIdPedido() + "_cedula");

			if (ftpClient.printWorkingDirectory().equals("/")) {
				ftpClient.changeWorkingDirectory(documento.getPed().getNced() + "_cedula");
			}

			stream = ftpClient.retrieveFileStream(ftpClient.printWorkingDirectory() + "/" + nombre);
			StreamFile = new DefaultStreamedContent(stream, "application/pdf", nombre);

			fout = new FileOutputStream(directorio + "/" + nombre);
			if (ftpClient.retrieveFile(nombre, fout)) {
				System.out.println("Descarga Completa desde FTP");
				InputStream stream = new FileInputStream(directorio + "/" + nombre);
				StreamFile = new DefaultStreamedContent(stream, "application/pdf", nombre);
			} else {
				System.out.println("error  en descargarArch");
			}
			fout.flush();
			fout.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en descargarArch: " + e.getMessage());
		} finally {
		}
	}

	// METODO PARA OBTENER LA LISTA DE NOMBRES DE LOS ARCHIVOS FTP
	public List<ArchivosCPA> getLista(Documento doc) {
		System.out.println("METODO para listar archivos del FTP");
		try {
			conectarFTP();
			ftpClient.changeWorkingDirectory("\\ " + doc.getPed().getNced() + "_cedula");
			String[] names = ftpClient.listNames();
			List<ArchivosCPA> listaArchivos = new ArrayList<ArchivosCPA>();
			for (String name : names) {
				ArchivosCPA acpa = new ArchivosCPA();
				acpa.setNombreArchivo(name);
				listaArchivos.add(acpa);
			}
			ftpClient.logout();
			ftpClient.disconnect();
			return listaArchivos;
		} catch (Exception e) {
			System.out.println("Error en listar archivos FTP: " + e.getStackTrace() + "\n" + e.getMessage());
			return null;
		}
	}

	public void enviarArchivoPedidoRob(Pedido ped) throws IOException {
		System.out.println("METODO para enviar archivos al FTP");
		try {

			// Ya pase por aqui
			BufferedInputStream buffIn = null;
			String cedulaUsuario = ped.getIdPedido().toString();
			int id_evidencia = ped.getIdPedido();
			String carpeta = cedulaUsuario + "_cedula";
			int creacion = (ftpClient.mkd(carpeta));

			ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			buffIn = new BufferedInputStream(new FileInputStream(getLocalPath()));
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(getNombreArchivo(), buffIn);
			System.out.println("archivo creado en carpeta existenete");

			id_evidencia = id_evidencia + 1;
			String url = cedulaUsuario + "_cedula/" + getNombreArchivo();

			ped.setPathArchivo(url);
			pedidoI.update(ped);

			// String pedido = ped.getIdPedido() + "-" + ped.getNced() + ".pdf";
			System.out.println("Path" + ped.getPathArchivo());
			List<Documento> listExiste = docI.listaDocumentosPedidoAFirmar(ped.getPathArchivo().trim());

			if (listExiste.size() > 0) {
				System.out.println("Encontredos" + listExiste.size());

				for (Documento doc : listExiste) {
					docI.delete(doc);

				}

			}

			System.out.println("Se genera el registro");
			Documento doc = new Documento();
			doc.setIdDocuemnto(docI.consultarId());
			doc.setPed(ped);
			doc.setPathDocumento(url);
			doc.setNombreDocumento(nombre);

			docI.save(doc);

			buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error en FTP enviarArchivo");
		}
	}

	public void enviarArchivoPedidoRobFirma(Pedido ped) throws IOException {
		System.out.println("METODO para enviar archivos al FTP");
		try {

			// Ya pase por aqui
			BufferedInputStream buffIn = null;
			String cedulaUsuario = ped.getIdPedido().toString();
			;
			int id_evidencia = ped.getIdPedido();
			String carpeta = cedulaUsuario + "_cedula";
			int creacion = (ftpClient.mkd(carpeta));

			ftpClient.changeWorkingDirectory("\\" + cedulaUsuario + "_cedula");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			buffIn = new BufferedInputStream(new FileInputStream(getLocalPath()));
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(getNombreArchivo(), buffIn);
			System.out.println("archivo creado en carpeta existenete");

			id_evidencia = id_evidencia + 1;
			String url = cedulaUsuario + "_cedula/" + getNombreArchivo();

			ped.setPathArchivo(url);
			pedidoI.update(ped);

			// String pedido = ped.getIdPedido() + "-" + ped.getNced() + ".pdf";
			System.out.println("Path" + ped.getPathArchivo());
			List<Documento> listExiste = docI.listaDocumentosPedidoAFirmados(ped.getPathArchivo().trim());

			if (listExiste.size() > 0) {
				System.out.println("Encontredos" + listExiste.size());

				for (Documento doc : listExiste) {
					docI.delete(doc);

				}

			}

			System.out.println("Se genera el registro");
			Documento doc = new Documento();
			doc.setIdDocuemnto(docI.consultarId());
			doc.setPed(ped);
			doc.setPathDocumento(url);
			doc.setNombreDocumento(nombre);

			docI.save(doc);

			buffIn.close();
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error en FTP enviarArchivo");
		}
	}

	// SETTERS Y GETTERS

	public StreamedContent getStreamFile() {
		return StreamFile;
	}

	public void setStreamFile(StreamedContent streamFile) {
		StreamFile = streamFile;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public InputStream getArchivo() {
		return archivo;
	}

	public void setArchivo(InputStream archivo) {
		this.archivo = archivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public String getMsgDownload() {
		return msgDownload;
	}

	public void setMsgDownload(String msgDownload) {
		this.msgDownload = msgDownload;
	}

	public String getStylemsgDownload() {
		return stylemsgDownload;
	}

	public void setStylemsgDownload(String stylemsgDownload) {
		this.stylemsgDownload = stylemsgDownload;
	}

}
