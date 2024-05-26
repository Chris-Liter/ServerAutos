package Automoviles.autos.dao;

import java.util.List;

import Automoviles.autos.model.Autos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
public class AutoDao {
	@PersistenceContext
	private EntityManager em;
	

    
	public void insert(Autos autos) {
		em.merge(autos);
	}
    
	public void update(Autos autos) {
		em.merge(autos);
	}
    
	public void remove(int codigo) {
		Autos autos = em.find(Autos.class, codigo);
		em.remove(autos);
	}
    
	public Autos read(String codigo) {
		Autos autos = em.find(Autos.class, codigo);
		return autos;
	}
    
	public List<Autos> getAll(){
		String jpql = "SELECT c FROM Autos c";
		Query q = em.createQuery(jpql, Autos.class);
		return q.getResultList();
	}
    
	public Autos getAutos(int cedula){
		String jpql = "SELECT c FROM Autos c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Autos.class);
		q.setParameter("codigo", cedula);
		List<Autos> clientes = q.getResultList();
		if(clientes.size()>0)
			return clientes.get(0);
		return null;
	}
}
