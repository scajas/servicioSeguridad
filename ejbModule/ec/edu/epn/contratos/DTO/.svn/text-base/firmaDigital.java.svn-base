package ec.edu.epn.contratos.DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ec.gov.informatica.firmadigital.FirmaDigital;

public class firmaDigital {

	private String tipo_certificado = "1";
	private String pathArchivo = "";
	private String claveToken = "";
	private String urlCertificado = "";

	public String getTipo_certificado() {
		return tipo_certificado;
	}

	public void setTipo_certificado(String tipo_certificado) {
		this.tipo_certificado = tipo_certificado;
	}

	public String getPathArchivo() {
		return pathArchivo;
	}

	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}

	public String getClaveToken() {
		return claveToken;
	}

	public void setClaveToken(String claveToken) {
		this.claveToken = claveToken;
	}

	public String getUrlCertificado() {
		return urlCertificado;
	}

	public void setUrlCertificado(String urlCertificado) {
		this.urlCertificado = urlCertificado;
	}

	private byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		is.close();
		return bytes;
	}

	private void writeToFile(String name, byte[] data) throws Exception {
		try {
			File someFile = new File(name);
			FileOutputStream fos = new FileOutputStream(someFile);
			fos.write(data);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void firmarDocumento() {
		try {			
			
			FirmaDigital firmaDigital = new FirmaDigital();	

			System.out.println("DATOS PARA LA FIRMA: " + pathArchivo);
			System.out.println("DATOS PARA LA FIRMA: " + claveToken);
			System.out.println("DATOS PARA LA FIRMA: " + urlCertificado);

			File file = new File(pathArchivo);
			byte[] data = getBytesFromFile(file);
			byte[] firmado = firmaDigital.firmar(data, claveToken,
					tipo_certificado, urlCertificado);
			if (firmado.length > 0) {
				writeToFile(file.getAbsolutePath() + ".p7m", firmado);
				final FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Firma De Archivos",
						"El archivo fue Firmado Electrónicamente deacuerdo a la “Ley No. 2002-67.- Ley de "
						+ "Comercio Electrónico, Firmas y Mensajes de Datos. Art. 14.- Efectos de la firma electrónica” ");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			final FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Firma De Archivos",
					"No se pudo firmar el archivo.!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

}
