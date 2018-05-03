package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.OfficerSQL;
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
	public List<Officer> search(OfficerSQL criterias) 
	{
		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Officer o WHERE 1=1 ";
		String order = "ORDER BY o.name,o.surname";

		if (criterias.getRimsId() != null) 
		{
			sql += "AND o.id=:rid ";
			params.put("rid",criterias.getRimsId());
		}
		
		if (criterias.getStatus() != null)
		{
			sql += "AND o.status=:st ";
			params.put("st", criterias.getStatus());
		}
		
		if(criterias.getStructuresIdList() != null && !criterias.getStructuresIdList().isEmpty()) {
			sql += "AND o.structure.id in :str ";
			params.put("str",criterias.getStructuresIdList());
			order = "ORDER BY o.structure,o.name,o.surname ";
		}
		
		if (StringUtil.isValid(criterias.getName())) 
		{
			sql += "AND UPPER(o.name) LIKE :name ";
			params.put("name", StringUtil.toUpper(criterias.getName()));
		}

		if (StringUtil.isValid(criterias.getSurname())) 
		{
			sql += "AND UPPER(o.surname) LIKE :name ";
			params.put("name", StringUtil.toUpper(criterias.getSurname()));
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
