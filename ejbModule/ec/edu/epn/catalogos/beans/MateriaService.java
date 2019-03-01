package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.Materia;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;



@Local
public interface MateriaService {

	List<Materia> findMateriaByParams(String codMateria, String nomMateria,
			String carrera);

	List<CargaAcademica> buscarCarga(String codigo, int idPedido);

	List<CargaAcademica> buscarCargaXPedido(Pedido pedido);

	List<CargaAcademica> listaCargaAcademcica();

	boolean verificarExistenciaMateriaEnPedido(String idcarrera,
			String idmateria, String paral, Pensum pensum);

	void guardarCargaAcademica(CargaAcademica cargaAcademica);

	void eliminarCargaAcademica(CargaAcademica cargaAcademica);

	void actualizarMateria(Materia materia);

	int consultarId();

	List<Materia> findAllMateria();

}
