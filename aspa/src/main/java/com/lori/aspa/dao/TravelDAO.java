package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.TravelSQL;
import com.lori.aspa.entities.Travel;


@SuppressWarnings("unchecked")
@Repository
public class TravelDAO {
	 
	@PersistenceContext
	EntityManager em;
	
	
	public Travel findById(Integer id)
	{
		return em.find(Travel.class, id);
		
	}
	
	public Travel create(Travel travel)
	{
		em.persist(travel);
		em.flush();
		return travel;
	}
	
	public Travel update(Travel travel)
	{
		return em.merge(travel);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Travel> search(TravelSQL criterias) 
	{

		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Travel t WHERE 1=1 ";
		String order = "ORDER BY t.id";



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
