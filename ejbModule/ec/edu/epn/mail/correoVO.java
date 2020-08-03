package ec.edu.epn.mail;

import java.util.List;

public class correoVO {

	private String id_mail;
	private String sender_user;
	private String sender_passw;
	private String sender_name;
	private String server_name;
	private String subjet;
	private String message;

	public void correoObtener(String from, List<String> to, String subject,String text) {
		try {			
			SendMail sendMail = new SendMail(from, to, subject, text);
			sendMail.send();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getId_mail() {
		return id_mail;
	}

	public void setId_mail(String idMail) {
		id_mail = idMail;
	}

	public String getSender_user() {
		return sender_user;
	}

	public void setSender_user(String senderUser) {
		sender_user = senderUser;
	}

	public String getSender_passw() {
		return sender_passw;
	}

	public void setSender_passw(String senderPassw) {
		sender_passw = senderPassw;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String senderName) {
		sender_name = senderName;
	}

	public String getSubjet() {
		return subjet;
	}

	public void setSubjet(String subjet) {
		this.subjet = subjet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getServer_name() {
		return server_name;
	}

	public void setServer_name(String serverName) {
		server_name = serverName;
	}

}
