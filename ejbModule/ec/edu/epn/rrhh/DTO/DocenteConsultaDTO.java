package ec.edu.epn.rrhh.DTO;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import ec.edu.epn.rrhh.entities.Emp;

public class DocenteConsultaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8874718821598902077L;
	
	private Emp empleado;
	private DocenteDTO empleadoDto;
	private List<NombTempDTO> listNombramientos;
	private List<ContDTO> listContratos;
	private ArchivoWrapper archivo;
	private List<ArchivoWrapper> listArchivos;
	private InputStream foto;
	
	public DocenteConsultaDTO() {
		
	}
	
	public DocenteConsultaDTO(Emp empleado, List<NombTempDTO> listNombramientos, List<ContDTO> listContratos) {
		this.empleado = empleado;
		this.listNombramientos = listNombramientos;
		this.listContratos = listContratos;
	}
	public Emp getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Emp empleado) {
		this.empleado = empleado;
	}
	public List<NombTempDTO> getListNombramientos() {
		return listNombramientos;
	}
	public void setListNombramientos(List<NombTempDTO> listNombramientos) {
		this.listNombramientos = listNombramientos;
	}
	public List<ContDTO> getListContratos() {
		return listContratos;
	}
	public void setListContratos(List<ContDTO> listContratos) {
		this.listContratos = listContratos;
	}
	public DocenteDTO getEmpleadoDto() {
		return empleadoDto;
	}
	public void setEmpleadoDto(DocenteDTO empleadoDto) {
		this.empleadoDto = empleadoDto;
	}

	public ArchivoWrapper getArchivo() {
		return archivo;
	}

	public void setArchivo(ArchivoWrapper archivo) {
		this.archivo = archivo;
	}

	public List<ArchivoWrapper> getListArchivos() {
		return listArchivos;
	}

	public void setListArchivos(List<ArchivoWrapper> listArchivos) {
		this.listArchivos = listArchivos;
	}

	public InputStream getFoto() {
		return foto;
	}

	public void setFoto(InputStream foto) {
		this.foto = foto;
	}
	
	
}
