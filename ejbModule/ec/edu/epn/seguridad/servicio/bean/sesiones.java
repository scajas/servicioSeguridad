package ec.edu.epn.seguridad.servicio.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class sesiones implements HttpSessionListener {
	private static final Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		try {
			HttpSession session = event.getSession();
			
			sessions.put(session.getId(), session);
			
			//verTodasSesiones();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		try {
			sessions.remove(event.getSession().getId());
			event.getSession().invalidate();
			deleteAllSessions();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HttpSession find(String sessionId) {
		try {
			return sessions.get(sessionId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*public static void verTodasSesiones() {
		try {
			for (Entry<String, HttpSession> e : sessions.entrySet()) {
				System.out.println("SESSION:***\n[" + e.getKey() + "=" + e.getValue() + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	public static void deleteAllSessions() {
		try {
			for (Entry<String, HttpSession> e : sessions.entrySet()) {
				e.getValue().invalidate();
				sessions.remove(e.getKey());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
