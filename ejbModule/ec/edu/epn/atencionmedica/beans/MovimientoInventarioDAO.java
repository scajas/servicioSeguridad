package ec.edu.epn.atencionmedica.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Movimientoinventario;

@Local
public interface MovimientoInventarioDAO {

	public boolean actualizarDespachoDeMovimiento(Movimientoinventario movimientoinventario);
	public boolean guardarMovimientoInventario(Movimientoinventario movimimientoInventario);
	
	public Movimientoinventario obtenerMovimientoInventario(Movimientoinventario movimiento);
	
	public int liberarMovimientosDeDespacho();
	public List<Movimientoinventario> obtenerListaDespachosPendientes();

	public List<Movimientoinventario> obtenerListaMovimientos(Date fechaInicial, Date fechaFinal);
	
	public List<Movimientoinventario> obtenerListaMovimientosInventario(Integer idAtencionMedico);
		

}
