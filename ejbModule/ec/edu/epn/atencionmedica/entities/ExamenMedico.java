package ec.edu.epn.atencionmedica.entities;

public class ExamenMedico {
	
	private Integer codigoGrupoExamen;
	private String codigoSubGrupoExamen;
	private String nombreExamen;
		
	
	
	public ExamenMedico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamenMedico(Integer codigoGrupoExamen, String codigoSubGrupoExamen, String nombreExamen) {
		super();
		this.codigoGrupoExamen = codigoGrupoExamen;
		this.codigoSubGrupoExamen = codigoSubGrupoExamen;
		this.nombreExamen = nombreExamen;
	}
	public Integer getCodigoGrupoExamen() {
		return codigoGrupoExamen;
	}
	public void setCodigoGrupoExamen(Integer codigoGrupoExamen) {
		this.codigoGrupoExamen = codigoGrupoExamen;
	}
	
	public String getNombreExamen() {
		return nombreExamen;
	}
	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}
	public String getCodigoSubGrupoExamen() {
		return codigoSubGrupoExamen;
	}
	public void setCodigoSubGrupoExamen(String codigoSubGrupoExamen) {
		this.codigoSubGrupoExamen = codigoSubGrupoExamen;
	}

}
