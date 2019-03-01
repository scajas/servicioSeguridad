package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Vehiculo;

@Local
public interface VehiculoDAO extends DaoGenerico<Vehiculo> {

	int consultarIdVehiculo();

	List<Vehiculo> findVehiculo(String nced, String placa);

	List<Vehiculo> findVehiculo1(String nced);

	List<Vehiculo> findVehiculo2(String nced);

	List<Vehiculo> findVehiculo3(String nced, String placa);

}
