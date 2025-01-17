package ec.edu.epn.mail;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	private static final String SMTP_HOST_IP = "172.31.10.35";
	private static final String SMTP_HOST_PORT = "25";
	private static final String SMTP_AUTH_USER = "contratos.docentes";
	private static final String SMTP_AUTH_PWD = "LcCDtp2016**";
	private String from;
	private List<String> to;
	private String subject;
	private String text;

	public SendMail(String from, List<String> to, String subject, String text) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public void send() throws MessagingException {
		Properties props = new Properties();
		boolean debug = true;

		/**SETEANDO LOS PARAMETROS DEL MAIL SERVER*/
		props.put("mail.smtp.host", SMTP_HOST_IP);
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.port", SMTP_HOST_PORT);

		/**OBTENIENDO UNA SESI�N CON EL SERVIDOR*/
		//Authenticator auth = new SMTPAuthenticator();
		Session mailSession = Session.getInstance(props);
		mailSession.setDebug(debug);
		/**INICIANDO EL MENSAJE*/
		Message simpleMessage = new MimeMessage(mailSession);
		/**SETEANDO LAS DIRECCIONES DE ORIGEN FROM */
		InternetAddress addressFrom = new InternetAddress(from);
		simpleMessage.setFrom(addressFrom);
		/**SETEANDO LAS DIRECCIONES DE DESTINO */
		InternetAddress[] addressTo = new InternetAddress[to.size()];
		for (int i = 0; i < to.size(); i++) {
			addressTo[i] = new InternetAddress(to.get(i));
		}
		simpleMessage.setRecipients(Message.RecipientType.TO, addressTo);

		/**SETEANDO EL ASUNTO (SUBJECT) Y EL TIPO DE CONTENIDO (CONTENT TYPE)*/
		simpleMessage.setSubject(subject);
		simpleMessage.setContent(text, "text/plain");
		Transport.send(simpleMessage);
	}

	/** */
	private class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}

	/** SET AND GETS */
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
