package Automoviles.autos.business;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import Automoviles.autos.model.Autos;
import jakarta.ejb.Local;
import jakarta.ws.rs.PathParam;

//@RegisterRestClient(baseUri = "http://localhost:8080/autos/rest")
@Local
public interface GestionAutoLocal {
	
	void guardar(Autos autos);
    void  actualizar(Autos autos);
    Autos getAuto(@PathParam("dni") int dni) throws Exception;
    List<Autos> getAutos();
    void borrar(int id);
	
}
