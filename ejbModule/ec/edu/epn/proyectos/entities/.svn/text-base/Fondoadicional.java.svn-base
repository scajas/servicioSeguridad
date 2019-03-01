package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fondoadicional database table.
 * 
 */
@Entity
@Table(name="fondoadicional",catalog = "bddcorpepn", schema = "`Proyectos`")
public class Fondoadicional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;


	private String institucion;

	private double valor;

	private double valordolar;

	//bi-directional many-to-one association to Moneda
    @ManyToOne
	@JoinColumn(name="id_moneda")
	private Moneda moneda;
    
    @ManyToOne
   	@JoinColumn(name="id_proy")
   	private ProyectoP proyecto;
    
    public Fondoadicional() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValordolar() {
		return this.valordolar;
	}

	public void setValordolar(double valordolar) {
		this.valordolar = valordolar;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
}