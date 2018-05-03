package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.entities.Structure;
import com.lori.aspa.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class StructureDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	public Structure findById(Integer id) 
	{
		return em.find(Structure.class, id);
	}
	
	
	public Structure create(Structure structure)
	{
		em.persist(structure);
		em.flush();
		return structure;
	}
	
	
	public Structure update(Structure structure)
	{
		return em.merge(structure);		
	}
	
	
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Structure> search(String name, Integer parentId, Integer status, Integer firstResult, Integer maxResult) 
	{
		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Structure s WHERE 1=1 ";
		String order = "ORDER BY s.structure.name";

		if (StringUtil.isValid(name)) 
		{
			sql += "AND UPPER(s.name) LIKE :name ";
			params.put("name", StringUtil.toUpper(name));
		}

		if (parentId != null) 
		{
			sql += "AND s.parent.id=:pid ";
			params.put("pid", parentId);
		}

		if (status != null) 
		{
			sql += "AND s.status=:st ";
			params.put("st",status);
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
