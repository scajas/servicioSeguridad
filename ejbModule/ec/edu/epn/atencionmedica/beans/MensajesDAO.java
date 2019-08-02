package ec.edu.epn.atencionmedica.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Agendarcita;
import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Mensaje;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

@Local
public interface MensajesDAO extends DaoGenerico<Mensaje>{
	
	public List<Mensaje> consultarMensajeActivoTipo(String tipo);


}
