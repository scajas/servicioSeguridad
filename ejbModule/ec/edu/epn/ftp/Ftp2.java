package ec.edu.epn.ftp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class Ftp2 {

	private String carpeta = "";
	private String url = "";
	private String host = "";
	private String nombreArchivo;
	private FTPClient ftpClient;
	private InputStream archivo = null;
	private Properties propiedades = new Properties();
	private InputStream stream = null;
	private StreamedContent StreamFile = null;

	public StreamedContent getStreamFile() {
		return StreamFile;
	}

	public void setStreamFile(StreamedContent streamFile) {
		StreamFile = streamFile;
	}

	public Ftp2() {
		propiedades = new Properties();
		try {
			propiedades.load(this.getClass().getClassLoader().getResourceAsStream("datosFTPFotos.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean conectarFTP(String user, String pass) {
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(InetAddress.getByName(host));
			ftpClient.login(user, pass);
			int reply = ftpClient.getReplyCode();
			if (FTPReply.isPositiveCompletion(reply)) {
				// Conectado Satisfactoriamente
				return true;
			} else {
				// Imposible conectarse al servidor
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setearStreamContentFromFtp(String pathArchivo) throws Exception {
		String partes[] = pathArchivo.split("/");
		String nombre = "";

		nombre = partes[4];
		host = propiedades.getProperty("ipProduccion");
		conectarFTP(propiedades.getProperty("userProduccion"), propiedades.getProperty("passProduccion"));

		// conectarFTP("wilson", "wilson", "localhost");

		System.out
				.println(pathArchivo + "**" + ftpClient.printWorkingDirectory() + "**" + partes[3] + "***" + partes[4]);

		try {
			FileOutputStream fout = null;
			if (ftpClient.printWorkingDirectory().equals("/")) {
				ftpClient.changeWorkingDirectory(partes[3]);

			}

			System.out.println(
					pathArchivo + "**" + ftpClient.printWorkingDirectory() + "**" + partes[3] + "***" + partes[4]);

			/** PARA VER IMAGENES EN LINUX **/
			/*
			 * fout = new FileOutputStream("/home/archivos/"+nombre); if
			 * (ftpClient.retrieveFile(nombre, fout)) {
			 * System.out.println("Descarga Completa desde FTP"); InputStream
			 * stream = new FileInputStream("/home/archivos/"+nombre);
			 * StreamFile = new DefaultStreamedContent(stream, "image/jpeg",
			 * nombre); } else { StreamFile = new DefaultStreamedContent(stream,
			 * "image/jpeg", nombre); } /*
			 * 
			 * /**PARA VER IMAGENES EN WINDOWS
			 */
			fout = new FileOutputStream(nombre);
			if (ftpClient.retrieveFile(nombre, fout)) {
				stream = new FileInputStream(nombre);
				System.out.println("Descarga ok ");
				StreamFile = new DefaultStreamedContent(stream, "image/jpeg", nombre);
			} else {
				System.out.println("Descarga no ok ");
				StreamFile = new DefaultStreamedContent(stream, "image/jpeg", nombre);
			}

			fout.flush();
			fout.close();
			ftpClient.disconnect();

		} catch (Exception e) {
			System.out.println("Error en setear archivo: " + e.getMessage());
		} finally {
		}
	}

	public void enviarArchivo() throws IOException {
		try {
			String carpeta = this.carpeta;
			int creacion = (ftpClient.mkd(carpeta));
			ftpClient.changeWorkingDirectory("\\" + carpeta);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.storeFile(nombreArchivo, archivo);
			url = carpeta + "/" + nombreArchivo;
			System.out.println("PATH DE ARHIVO EN SERVIDOR FILEZILLA: " + url);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String consultarArchivo() throws IOException {
		try {
			String carpeta = this.carpeta;
			ftpClient.changeWorkingDirectory("\\" + carpeta);
			String[] lista = ftpClient.listNames();
			url = "ftp://" + host + "//" + carpeta + "//foto.jpg";

			for (int i = 0; i < lista.length; i++) {
				if (lista[i].equals(nombreArchivo + ".pdf")) {
					url = "ftp://" + host + "/" + carpeta + "/" + nombreArchivo + ".pdf";
					break;
				}
			}
			cerrarConexion();
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			cerrarConexion();
			return "";
		}

	}

	/* SETTERS Y GETTERS */
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	public InputStream getArchivo() {
		return archivo;
	}

	public void setArchivo(InputStream archivo) {
		this.archivo = archivo;
	}

}
