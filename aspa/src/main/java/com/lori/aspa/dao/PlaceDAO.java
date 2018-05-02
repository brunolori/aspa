package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.PlaceSQL;
import com.lori.aspa.entities.Place;
import com.lori.aspa.utils.StringUtil;


@SuppressWarnings("unchecked")
@Repository
public class PlaceDAO {
	 
	
	@PersistenceContext
	EntityManager em;
	
	
	public Place findById(Integer id) 
	{
		return em.find(Place.class, id);
	}
	
	public Place create(Place place)
	{
		em.persist(place);
		em.flush();
		return place;
	}
	
	public Place update(Place place)
	{
		return em.merge(place);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Place> search(PlaceSQL criterias) 
	{

		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Place p WHERE 1=1 ";
		String order = "ORDER BY p.name";

		if (StringUtil.isValid(criterias.getName()))
		{
			sql += "AND UPPER(p.getName) LIKE :name ";
			params.put("name", criterias.getName());
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
