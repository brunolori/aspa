package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.UserSQL;
import com.lori.aspa.entities.User;
import com.lori.aspa.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class UserDAO {
	
	
	@PersistenceContext
	EntityManager em;
	
	public User findById(Integer id)
	{
		return em.find(User.class, id);
	}
	
	public User create(User user)
	{
		em.persist(user);
		em.flush();
		return user;
	}
	
	public User update(User user)
	{
		return em.merge(user);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List<User> search(UserSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		
		String sql = "FROM User u WHERE 1=1 ";
		String order = "ORDER BY u.username";
		
		
		if(StringUtil.isValid(criterias.getUsername()))
		{
			sql += "AND UPPER(u.username) LIKE :uname ";
			params.put("uname", criterias.getSurname());
		}
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND UPPER(u.officer.name) LIKE :name ";
			params.put("name", criterias.getName());
		}
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND UPPER(u.officer.surname) LIKE :surname ";
			params.put("surname", criterias.getSurname());
		}
		
		if(criterias.getStatus() != null)
		{
			sql += "AND u.status=:st ";
			params.put("st", criterias.getStatus());
		}
		
		if(criterias.getStructureId() != null)
		{
			sql += "AND u.officer.structure.id=:sid ";
			params.put("sid", criterias.getStructureId());
		}
		
		
		
		sql += order;
		
		
		Query q = em.createQuery(sql);
		
		Iterator it = params.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}
		
		
		if(criterias.getFirstResult() != null)
		{
			q.setFirstResult(criterias.getFirstResult());
		}
		
		if(criterias.getMaxResult() != null)
		{
			q.setMaxResults(criterias.getMaxResult());
		}
		
		
		return q.getResultList();
		
	}
	
	
	

}