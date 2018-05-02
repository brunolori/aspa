package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.AuthorizationSQL;
import com.lori.aspa.entities.Authorization;

@SuppressWarnings("unchecked")
@Repository
public class AuthorizationDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public Authorization findById(Integer id) 
	{
		return em.find(Authorization.class, id);
	}
	
	public Authorization create(Authorization authorization)
	{
		em.persist(authorization);
		em.flush();
		return authorization;
	}
	
	public Authorization update(Authorization authorization)
	{
		return em.merge(authorization);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Authorization> search(AuthorizationSQL criterias)
	{
		String sql = "FROM Authorization a WHERE 1=1 ";
		       sql+="ORDER BY a.id ";
		
		HashMap<String, Object> params = new HashMap<>();
		
		
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
