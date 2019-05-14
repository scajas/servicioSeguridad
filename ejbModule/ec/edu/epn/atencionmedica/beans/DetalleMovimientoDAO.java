package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;
import ec.edu.epn.atencionmedica.entities.Detallemovimiento;

@Local
public interface DetalleMovimientoDAO {
	
	public List<Detallemovimiento> obtenerListaDetalleMovimientos(String criterio);
	public Detallemovimiento obtenerDetallemovimiento(String criterio);
	public Integer obtenerCantidadComprometidaInsumo(String criterio);

}
