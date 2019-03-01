package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurante", catalog = "`bddcorpepn`", schema = "`Rrhh`")
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_restaurante")
	private Integer idRestaurante;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "menu")
	private String menu;

	@Column(name = "menu_especial")
	private String menuEspecial;

	@Column(name = "fecha_ingreso_menu")
	private Date fechaIngresoMenu;

	private String direccion;

	private String horario;

	/**
	 * @return the idRestaurante
	 */
	public Integer getIdRestaurante() {
		return idRestaurante;
	}

	/**
	 * @param idRestaurante
	 *            the idRestaurante to set
	 */
	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * @return the menuEspecial
	 */
	public String getMenuEspecial() {
		return menuEspecial;
	}

	/**
	 * @param menuEspecial
	 *            the menuEspecial to set
	 */
	public void setMenuEspecial(String menuEspecial) {
		this.menuEspecial = menuEspecial;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario
	 *            the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the fechaIngresoMenu
	 */
	public Date getFechaIngresoMenu() {
		return fechaIngresoMenu;
	}

	/**
	 * @param fechaIngresoMenu
	 *            the fechaIngresoMenu to set
	 */
	public void setFechaIngresoMenu(Date fechaIngresoMenu) {
		this.fechaIngresoMenu = fechaIngresoMenu;
	}

}
