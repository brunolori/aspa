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
import com.lori.aspa.entities.Officer;
import com.lori.aspa.entities.Vehicle;
import com.lori.aspa.utils.StringUtil;

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
		
		if (criterias.getFromDate() != null) {
            sql += "AND a.data>=:fromDate ";
            params.put("fromDate", criterias.getFromDate());
        }

        if (criterias.getToDate() != null) {
            sql += "AND a.data<=:toDate ";
            params.put("toDate", criterias.getToDate());
        }
        
        if (criterias.getStructureId() != null)
		{
			sql += "AND a.structure.id=:sid ";
			params.put("sid", criterias.getStructureId());
		}
		
        
        if (criterias.getUserId() != null)
		{
			sql += "AND a.user.id=:uid ";
			params.put("uid", criterias.getUserId());
		}
		
        if (criterias.getFromPlaceId() != null)
		{
			sql += "AND a.fromPlace.id=:fid ";
			params.put("fid", criterias.getFromPlaceId());
		}
		
        if (criterias.getToPlaceId() != null)
		{
			sql += "AND a.toPlace.id=:tid ";
			params.put("tid", criterias.getToPlaceId());
		}
		
        if (StringUtil.isValid(criterias.getApproved())) {
            sql += " AND a.approved=:app";
            params.put("app", criterias.getApproved());
        }
        
        if (StringUtil.isValid(criterias.getNotApproved())) {
            sql += " AND a.approved != :n_app";
            params.put("n_app", criterias.getNotApproved());
        }
        
        if(criterias.getOfficerId() != null)
		{
        	sql += " AND :off MEMBER OF a.officers ";
            params.put("off", new Officer(criterias.getOfficerId()));
		}
        
        if(criterias.getVehicleId() != null)
		{
        	sql += " AND :vcl MEMBER OF a.vehicles ";
            params.put("vcl", new Vehicle(criterias.getVehicleId()));
		}
                
        if (criterias.getRank() != null) {
            sql += " AND a.rank=:rank";
            params.put("rank", criterias.getRank());
        }
        
        if (criterias.getStatus() != null)
		{
			sql += "AND a.status=:st ";
			params.put("st", criterias.getStatus());
		}
        
        
        if (criterias.getMarkedForChange()!= null) {
            sql += " AND a.markedForChange=:mfc";
            params.put("mfc", criterias.getMarkedForChange());
        }
        
        if (criterias.getNextUserId() != null) {
            sql += " AND a.nextUser.id=:nextuid";
            params.put("nextuid", criterias.getNextUserId());
        }
        
		
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
