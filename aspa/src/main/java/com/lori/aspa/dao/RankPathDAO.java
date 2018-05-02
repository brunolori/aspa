package com.lori.aspa.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.dao.sql.RankPathSQL;
import com.lori.aspa.entities.RankPath;

@SuppressWarnings("unchecked")
@Repository
public class RankPathDAO {
  
	
	@PersistenceContext
	EntityManager em;
	
	
	public RankPath findById(Integer id)
	{
		return em.find(RankPath.class, id);
	}
	
	
	public RankPath create(RankPath rankPath)
	{
		em.persist(rankPath);
		em.flush();
        return rankPath;  
	}
	
	
	public RankPath update(RankPath rankPath)
	{
		return em.merge(rankPath);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List<RankPath> search(RankPathSQL criterias){
	HashMap<String, Object> params = new HashMap<>();

	String sql = "FROM RankPath r WHERE 1=1 ";
	String order = "ORDER BY r.id";

	
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
