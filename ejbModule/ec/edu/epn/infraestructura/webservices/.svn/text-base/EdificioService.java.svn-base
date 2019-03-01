package ec.edu.epn.infraestructura.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.epn.infraestructura.beans.EdificioDAOImplement;
import ec.edu.epn.infraestructura.entities.EdificioInfra;

@Stateless
@Path("edificio")

public class EdificioService extends EdificioDAOImplement {

	@GET
    @Produces({"application/xml", "application/json"})
    public List<EdificioInfra> findAll() {
       return super.listarEdificio();
    }

}
