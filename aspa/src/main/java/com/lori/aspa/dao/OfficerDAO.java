package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.entities.Officer;
import com.lori.aspa.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class OfficerDAO {

	@PersistenceContext
	EntityManager em;

	public Officer findById(Integer id) 
	{
		return em.find(Officer.class, id);
	}

	public Officer create(Officer officer) 
	{
		em.persist(officer);
		em.flush();
		return officer;
	}

	public Officer update(Officer officer) 
	{
		return em.merge(officer);
	}

	@SuppressWarnings("rawtypes")
	public List<Officer> search(Integer rimsId, String name, String surname, Integer status, Integer firstResult, Integer maxResult) 
	{
		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Officer o WHERE 1=1 ";
		String order = "ORDER BY o.officer.name";

		if (rimsId != null) 
		{
			sql += "AND o.id=:rid ";
			params.put("rid",rimsId);
		}
		
		if (status != null) 
		{
			sql += "AND o.status=:st ";
			params.put("st",status);
		}
		
		if (StringUtil.isValid(name)) 
		{
			sql += "AND UPPER(o.name) LIKE :name ";
			params.put("name", StringUtil.toUpper(name));
		}

		if (StringUtil.isValid(surname)) 
		{
			sql += "AND UPPER(o.surname) LIKE :name ";
			params.put("name", StringUtil.toUpper(surname));
		}

		sql += order;

		Query q = em.createQuery(sql);

		Iterator it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}
		
		if(firstResult != null)
		{
			q.setFirstResult(firstResult);
		}
		
		if(maxResult != null)
		{
			q.setMaxResults(maxResult);
		}

		return q.getResultList();

	}

}
