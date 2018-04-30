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
	public List<Structure> search(String name, String parent) 
	{
		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Structure s WHERE 1=1 ";
		String order = "ORDER BY s.structure.name";

		if (StringUtil.isValid(name)) 
		{
			sql += "AND UPPER(s.name) LIKE :name ";
			params.put("name", StringUtil.toUpper(name));
		}

		if (StringUtil.isValid(parent)) 
		{
			sql += "AND UPPER(s.parent) LIKE :parent ";
			params.put("parent", StringUtil.toUpper(parent));
		}

		sql += order;

		Query q = em.createQuery(sql);

		Iterator it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}

		return q.getResultList();

	}
	
}
