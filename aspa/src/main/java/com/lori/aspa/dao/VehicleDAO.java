package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.VehicleSQL;
import com.lori.aspa.entities.Vehicle;
import com.lori.aspa.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class VehicleDAO {
	
	@PersistenceContext
	EntityManager em;
	
	  
	public Vehicle findById(Integer id) 
	{
		return em.find(Vehicle.class, id);
	}
	
	public Vehicle create(Vehicle vehicle)
	{
		em.persist(vehicle);
		em.flush();
		return vehicle;
	}
	
	public Vehicle update(Vehicle vehicle)
	{
		return em.merge(vehicle);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Vehicle> search(VehicleSQL criterias) 
	{
		
		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Vehicle v WHERE 1=1 ";
		String order = "ORDER BY v.plate";

		if (StringUtil.isValid(criterias.getPlate()))
		{
			sql += "AND UPPER(v.plate) LIKE :plate ";
			params.put("plate", criterias.getPlate());
		}
		
		if (StringUtil.isValid(criterias.getCarriage()))
		{
			sql += "AND UPPER(v.carriage) LIKE :carriage ";
			params.put("carriage", criterias.getCarriage());
		}
		
		if (StringUtil.isValid(criterias.getType()))
		{
			sql += "AND UPPER(v.type.tag) LIKE :type ";
			params.put("type", criterias.getType());
		}
		
		if (criterias.getStructureId() != null)
		{
			sql += "AND v.structure.id=:sid ";
			params.put("sid", criterias.getStructureId());
		}
		
	
		sql += order;

		Query q = em.createQuery(sql);

		Iterator it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}

		if (criterias.getFirstResult() != null)
		{
			q.setFirstResult(criterias.getFirstResult());
		}

		if (criterias.getMaxResult() != null) 
		{
			q.setMaxResults(criterias.getMaxResult());
		}

		return q.getResultList();

	}

}
