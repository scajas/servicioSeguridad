package ec.edu.epn.seguridad.servicio.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import ec.edu.epn.jdbc.JDBCUtil;
import ec.edu.epn.seguridad.servicio.ServicioSeguridad;
import ec.edu.epn.seguridad.vo.AccesoUrl;
import ec.edu.epn.seguridad.vo.Aplicacion;
import ec.edu.epn.seguridad.vo.Autorizacion;
import ec.edu.epn.seguridad.vo.Menu;
import ec.edu.epn.seguridad.vo.Perfil;
import ec.edu.epn.seguridad.vo.Personal;
import ec.edu.epn.seguridad.vo.Unidad;
import ec.edu.epn.seguridad.vo.Usuario;

@Stateless
public class ServicioSeguridadBean implements ServicioSeguridad {
	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	DataSource ds;
	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	EntityManager em;

	public Usuario obtenerUsuario(String nombreUsuario) {
		Query q = em.createQuery("Select u from Usuario as u where u.nombreUsuario = ?1");
		q.setParameter(1, nombreUsuario);
		return (Usuario) q.getSingleResult();
	}


	@Override
	public List<Usuario> obtenerUsuarioxNombresCedula(String cedula, String nombres) {
		try {

			StringBuilder consulta = new StringBuilder("Select u from Usuario as u where u.id  > 0");

			if (!cedula.equals(""))
				consulta.append(" and u.cedula like ?1 ");

			if (!nombres.equals(""))
				consulta.append(" and u.nombreapellido like ?2 ");

			Query q = em.createQuery(consulta.toString());

			if (!cedula.equals(""))
				q.setParameter(1, cedula + "%");

			if (!nombres.equals(""))
				q.setParameter(2, "%" + nombres + "%");

			return q.getResultList();
		} catch (Exception e) {
			return null;
		}

	}

	public void guardarAplicacion(Aplicacion aplicacion) {
		em.persist(aplicacion);
	}

	public void actualizarAplicacion(Aplicacion aplicacion) {
		em.merge(aplicacion);
	}

	public void actualizarMenu(Menu menu) {
		em.merge(menu);
	}

	@SuppressWarnings("unchecked")
	public List<Aplicacion> consultarAplicaciones() {
		Query q = em.createQuery("Select a from Aplicacion as a");
		return q.getResultList();
	}

	public Usuario obtenerUsuarioXCedula(String cedula) {
		try {
			Query q = em.createQuery("Select u from Usuario as u where u.cedula = ?1");
			q.setParameter(1, cedula);
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Menu> obtenerMenusPorRol(String rol) {
		Query q = em.createQuery(
				"select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion where p.nombre=?1 and p.activo='SI' and m.activo='SI' order by COALESCE(m.menuPadre.id,0), m.orden");
		q.setParameter(1, rol);
		List<Autorizacion> resultado = q.getResultList();

		List<Menu> menus = new ArrayList<Menu>();
		for (Autorizacion a : resultado) {
			menus.add(a.getMenu());
			Menu m = a.getMenu();
			m.setPermisos(a.getPermisos());
			if (m.getUrl() != null) {
				if (m.getAplicacion() == null) {
					m.setUrlCompleto(m.getUrl());
				} else {
					m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
				}
			}
		}
		return menus;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> obtenerMenusPadre(String rol) {
		Query q = em.createQuery(
				"select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion where p.nombre=?1 and p.activo='SI' and m.activo='SI' and m.tipo='menu' and m.menuPadre=null order by COALESCE(m.menuPadre.id,0), m.orden");
		q.setParameter(1, rol);
		List<Autorizacion> resultado = q.getResultList();

		List<Menu> menus = new ArrayList<Menu>();
		for (Autorizacion a : resultado) {
			menus.add(a.getMenu());
			Menu m = a.getMenu();
			m.setPermisos(a.getPermisos());
			if (m.getUrl() != null) {
				if (m.getAplicacion() == null) {
					m.setUrlCompleto(m.getUrl());
				} else {
					m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
				}
			}
		}
		return menus;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> obtenerMenusHijo(String rol, long idMenuPadre, String opcion, String opcion2) {
		Query q = em.createQuery(
				"select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion "
						+ "where p.nombre=?1 and p.activo='SI' and m.activo='SI' and (m.tipo=?2 or m.tipo=?3)  "
						+ "and m.menuPadre.id=?4 order by COALESCE(m.menuPadre.id,0), m.orden");
		q.setParameter(1, rol);
		q.setParameter(2, opcion);
		q.setParameter(3, opcion2);
		q.setParameter(4, idMenuPadre);
		List<Autorizacion> resultado = q.getResultList();

		List<Menu> menus = new ArrayList<Menu>();
		for (Autorizacion a : resultado) {
			menus.add(a.getMenu());
			Menu m = a.getMenu();
			m.setPermisos(a.getPermisos());
			if (m.getUrl() != null) {
				if (m.getAplicacion() == null) {
					m.setUrlCompleto(m.getUrl());
				} else {
					m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
				}
			}
		}
		return menus;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> obtenerMenusPadreAplicacion(String rol, long idAplicativo) {
		Query q = em.createQuery(
				"select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion where p.nombre=?1 "
						+ " and p.activo='SI' and m.activo='SI' and m.tipo='menu' and m.menuPadre=null "
						+ " and m.aplicacion.id=?2 " + "order by COALESCE(m.menuPadre.id,0), m.orden");
		q.setParameter(1, rol);
		q.setParameter(2, idAplicativo);

		List<Autorizacion> resultado = q.getResultList();

		List<Menu> menus = new ArrayList<Menu>();
		for (Autorizacion a : resultado) {
			menus.add(a.getMenu());
			Menu m = a.getMenu();
			m.setPermisos(a.getPermisos());
			if (m.getUrl() != null) {
				if (m.getAplicacion() == null) {
					m.setUrlCompleto(m.getUrl());
				} else {
					m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
				}
			}
		}
		return menus;
	}

	@Override
	public int getMaxMenuOrdenByMenuPadreAndAplicacion(long idMenuPadre, long idAplicacion) {
		Query q = em.createQuery("select MAX(m.orden) from Menu as m where m.menuPadre.id=?1 and m.aplicacion.id=?2");
		q.setParameter(1, idMenuPadre);
		q.setParameter(2, idAplicacion);
		try {
			return (Integer) q.getSingleResult();
		} catch (Exception e) {
			System.out.println("Menu sin elementos");
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> obtenerMenuAplicacion(long idMenuPadre, String tipo) {
		Query q = null;
		try {
			q = em.createQuery("select m from Menu as m where m.menuPadre.id=?1 and m.tipo=?2");
			q.setParameter(1, idMenuPadre);
			q.setParameter(2, tipo);

		} catch (Exception e) {
			System.out.println("Menu sin elementos");
		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> obtenerPerfilesUsuario(String nombreUsuario) {
		Query q = em
				.createQuery("select p from Perfil as p, IN (p.usuarios) u where p.activo='SI' and u.nombreUsuario=?1");
		q.setParameter(1, nombreUsuario);
		return q.getResultList();
	}

	public boolean usuarioTienePerfil(String nombreUsuario, String nombrePerfil) {
		Query q = em.createQuery(
				"select p from Perfil as p, IN (p.usuarios) u where p.activo='SI' and p.nombre=?1 and u.nombreUsuario=?2");
		q.setParameter(1, nombrePerfil);
		q.setParameter(2, nombreUsuario);
		return q.getResultList().size() > 0;
	}

	public boolean validarUsuarioPassword(String cedula, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(
					"select clave = crypt(?,clave) from usuario where nombre_usuario=? and activo =? ;");
			ps.setString(1, password);
			ps.setString(2, cedula);
			ps.setString(3, "SI");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getBoolean(1) == true) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
	}

	public void actualizarPassword(String cedula, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement("update usuario set clave = crypt(?,gen_salt('md5')) where nombre_usuario=?;");
			ps.setString(1, password);
			ps.setString(2, cedula);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
	}

	// ********----
	@SuppressWarnings("unchecked")
	public List<Menu> consultarMenusPorAplicacion(String nomAplicacion) {
		Query q = em.createQuery("select m from Menu as m, IN (m.aplicacion) a  "
				+ "where m.activo='SI' and a.nombre=?1 and m.tipo='menu' ");
		q.setParameter(1, nomAplicacion);
		return q.getResultList();
	}

	public Aplicacion obtenerAplicacion(String nomAplicacion) {
		Query q = em.createQuery("select a from Aplicacion as a where a.nombre=?1");
		q.setParameter(1, nomAplicacion);
		return (Aplicacion) q.getSingleResult();
	}

	@Override
	public Aplicacion obtenerAplicacionXUrl(String url) {
		Query q = em.createQuery("select a from Aplicacion as a where a.url=?1");
		q.setParameter(1, url);
		return (Aplicacion) q.getSingleResult();
	}

	public Menu obtenerMenu(String nombreMenu) {
		Query q = em.createQuery("select DISTINCT m from Menu as m where m.nombre=?1");
		q.setParameter(1, nombreMenu);
		q.setMaxResults(1);
		return (Menu) q.getSingleResult();
	}

	public void guardarMenu(Menu m) {
		em.persist(m);
	}

	public long selectMaxIDMenu() {
		Query q = em.createQuery("select MAX(m.id) from Menu as m");
		return (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Menu> consultarOpcionesPorMenu(String aplicacion, String menuPadre) {
		Query q = em.createQuery(
				"select m from Menu as m where m.aplicacion.nombre=?1 and m.menuPadre.nombre=?2 and m.tipo='opcion'");
		q.setParameter(1, aplicacion);
		q.setParameter(2, menuPadre);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Menu> consultarMenusConIgualPadre(String aplicacion, String menuPadre) {
		Query q = em.createQuery(
				"select m from Menu as m where m.aplicacion.nombre=?1 and m.menuPadre.nombre=?2 and m.tipo='menu'");
		q.setParameter(1, aplicacion);
		q.setParameter(2, menuPadre);
		return q.getResultList();
	}
	
	 @SuppressWarnings("unchecked")
	    public List<Menu> obtenerMenusPorRolAplicativo(String rol, long idAplicativo) {
	    	Query q = em.createQuery("select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion " +
	    			" where p.nombre=?1 and p.activo='SI' and m.activo='SI' AND m.aplicacion.id=?2 " +
	    			" order by COALESCE(m.menuPadre.id,0), m.orden");
			q.setParameter(1, rol);
			q.setParameter(2, idAplicativo);
			List<Autorizacion> resultado = q.getResultList();
			
			List<Menu> menus = new ArrayList<Menu>();
			for (Autorizacion a : resultado) {
				menus.add(a.getMenu());
				Menu m = a.getMenu();
				m.setPermisos(a.getPermisos());
				if (m.getUrl()!=null){
					if(m.getAplicacion()==null){
						m.setUrlCompleto(m.getUrl());	
					}else {
				        m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
					}
				}
			}
			return menus;
	    }

	////// SAULO////////////////
	public void guardarPerfil(Perfil p) {
		em.persist(p);
	}

	//////////// SAULO/////////////
	public void actualizarPerfil(Perfil p) {
		em.merge(p);
	}

	public Perfil buscarPerfilPorNombre(String nombre) {
		Query q = em.createQuery("Select p from Perfil as p where p.nombre=?1");
		q.setParameter(1, nombre);
		return (Perfil) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> buscarPerfiles() {
		Query q = em.createQuery("Select p from Perfil as p");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Unidad> getListaUnidades() {
		Query q = em.createQuery("Select u from Unidad as u");
		return q.getResultList();
	}

	public Unidad buscarUnidadPorNombre(String nombreU) {
		Query q = em.createQuery("Select u from Unidad as u where u.nombreU=?1");
		q.setParameter(1, nombreU);
		return (Unidad) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Personal> getListaPersonal() {
		Query q = em.createQuery("Select per from Personal as per");
		return q.getResultList();
	}

	public Personal buscarPersonalPorNombre(String nombresPe) {
		Query q = em.createQuery("Select per from Personal as per where per.nombresPe=?1");
		q.setParameter(1, nombresPe);
		return (Personal) q.getSingleResult();
	}

	public void guardarUsuario(Usuario user) {
		em.persist(user);
	}

	public void actualizarUsuario(Usuario user) {
		em.merge(user);
	}

	public Usuario buscarUsuarioPorNombre(String nombre) {
		Query q = em.createQuery("Select user from Usuario as user where user.nombreUsuario=?1");
		q.setParameter(1, nombre);
		return (Usuario) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getListaUsuarios() {
		Query q = em.createQuery("Select user from Usuario as user");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getListaMenus() {
		Query q = em.createQuery("Select m from Menu as m");
		return q.getResultList();
	}

	public Menu obtenerMenuPorID(Long id) {
		Query q = em.createQuery("Select m from Menu as m where m.id=?1");
		q.setParameter(1, id);
		return (Menu) q.getSingleResult();
	}

	public Perfil buscarPerfilPorID(Long id) {
		Query q = em.createQuery("Select p from Perfil as p where p.id=?1");
		q.setParameter(1, id);
		return (Perfil) q.getSingleResult();
	}

	public void guardarAutorizacion(Autorizacion autorizacion) {
		em.persist(autorizacion);
	}

	public long selectMaxIDAutorizacion() {
		Query q = em.createQuery("select MAX(a.id) from Autorizacion as a");
		return (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Autorizacion> getListaAutorizaciones() {
		Query q = em.createQuery("Select a from Autorizacion as a");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Autorizacion> getListaAutorizacionesbyMenu(long idMenu) {
		Query q = em.createQuery("Select a from Autorizacion as a where a.menu.id = ?1");
		q.setParameter(1, idMenu);
		return q.getResultList();
	}

	public Autorizacion buscarAutorizacionPorID(Long id) {
		Query q = em.createQuery("Select a from Autorizacion as a where a.id=?1");
		q.setParameter(1, id);
		return (Autorizacion) q.getSingleResult();
	}

	public void actualizarAutorizacion(Autorizacion a) {
		em.merge(a);
	}

	public Personal buscarPersonalPorID(String id) {
		Query q = em.createQuery("Select per from Personal as per where per.id=?1");
		q.setParameter(1, id);
		return (Personal) q.getSingleResult();
	}

	public Unidad buscarUnidadPorID(int id) {
		Query q = em.createQuery("Select uni from Unidad as uni where uni.id=?1");
		q.setParameter(1, id);
		return (Unidad) q.getSingleResult();
	}
	
	public void guardaAccesoUrl(AccesoUrl accesoUrl) {
    	em.persist(accesoUrl);
    }

}
