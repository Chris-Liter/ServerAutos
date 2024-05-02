package Automoviles.autos.business;

import java.util.List;

import Automoviles.autos.model.Autos;
import jakarta.ejb.Remote;

@Remote
public interface GestionAutoRemoto {

	void guardar(Autos autos);
    void  actualizar(Autos autos);
    Autos getAuto(String dni) throws Exception;
    List<Autos> getAutos();
    void borrar(String id);
}
