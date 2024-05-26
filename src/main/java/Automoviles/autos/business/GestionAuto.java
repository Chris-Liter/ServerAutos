package Automoviles.autos.business;

import java.util.List;

import Automoviles.autos.dao.AutoDao;
import Automoviles.autos.model.Autos;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Stateless
public class GestionAuto{
// implements GestionAutoLocal, GestionAutoRemoto
	
	
	@Inject
	private AutoDao dao;

	

	//@Override
	public void guardar(Autos autos) {
		dao.insert(autos);
	}
	///@Override
	public void actualizar(Autos autos) {
		Autos aut = dao.getAutos(autos.getCodigo());
		if(aut != null) {
			dao.update(autos);
		}
	}
	//@Override
	public Autos getAuto(int dni) throws Exception {
		Autos aut = dao.getAutos(dni);
		if(aut != null) {
			return aut;
		}else {
			return null;
		}
	}
	//@Override
	public List<Autos> getAutos() {
		return dao.getAll();
	}
	//@Override
	public void borrar(int id) {
		try {
			Autos out = dao.getAutos(id);
			if(out !=null) {
				dao.remove(out.getCodigo());
			}else {
				System.out.println("No existe");
			}
		}catch(Exception s) {
			s.printStackTrace();
		}
	}

}
