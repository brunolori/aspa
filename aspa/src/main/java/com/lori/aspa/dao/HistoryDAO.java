package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.entities.ApprovalHistory;
import com.lori.aspa.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class HistoryDAO {

	
	@PersistenceContext
	EntityManager em;
	
	
	public ApprovalHistory create(ApprovalHistory history)
	{
		em.persist(history);
		em.flush();
		return history;
	}
	
	public ApprovalHistory update(ApprovalHistory history)
	{
		return em.merge(history);
	}
	
	@SuppressWarnings("rawtypes")
	public List<ApprovalHistory> search(Integer authId, Integer userId, String decision,Integer status, Integer firstResult, Integer maxResult)
	{
		String sql = "FROM ApprovalHistory ah WHERE 1=1 ";
		
		HashMap<String, Object> params = new HashMap<>();
		
		if (authId != null) 
		{
			sql += "AND ah.authorization.id=:aid ";
			params.put("aid", authId);
		}
		
		if (userId != null) 
		{
			sql += "AND ah.user.id=:uid ";
			params.put("uid", userId);
		}
		
		if(StringUtil.isValid(decision))
		{
			sql += "AND ah.decision=:de ";
			params.put("de", decision);
		}
		
		if (status != null) 
		{
			sql += "AND ah.status=:st ";
			params.put("st", status);
		}
		
		sql+="ORDER BY ah.id desc ";
	
		
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
