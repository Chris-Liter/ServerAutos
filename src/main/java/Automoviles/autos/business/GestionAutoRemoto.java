package Automoviles.autos.business;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

//import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import Automoviles.autos.model.Autos;
import jakarta.ejb.Remote;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

//@RegisterRestClient(baseUri = "http://localhost:8080/autos/rest")
@Remote
public interface GestionAutoRemoto {

	void guardar(Autos autos);
    void  actualizar(Autos autos);
    Autos getAuto(@PathParam("dni") int dni) throws Exception;
    List<Autos> getAutos();
    void borrar(int id);
}
