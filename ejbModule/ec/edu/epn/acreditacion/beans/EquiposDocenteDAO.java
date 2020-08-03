package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.DTO.EquipoDocenteDTO;

@Local
public interface EquiposDocenteDAO {

	List<EquipoDocenteDTO> reporteDocenteDistributivoDTO(String var01);

}
