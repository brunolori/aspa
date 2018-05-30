package com.lori.aspa.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.constants.IDecision;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.model.ValuePair;
import com.lori.aspa.utils.StringUtil;

@Repository
@SuppressWarnings("unchecked")
public class StatisticDAO {

	@PersistenceContext
	EntityManager em;

	
	@SuppressWarnings("rawtypes")
	public long countAllAuths(Date fromDate, Date toDate, String decision, List<Integer> structureIds) {

		System.out.println(fromDate);
		System.out.println(toDate);
		System.out.println(decision);
		System.out.println(structureIds);
		
		
		HashMap<String, Object> params = new HashMap<>();

		String sql = "Select count(a) FROM Authorization a WHERE a.status=:st";

		
		if (fromDate != null) {
			sql += " AND a.createTime>=:fromDate";
			params.put("fromDate", fromDate);
		}
		
		if (toDate != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(toDate);
			c.add(Calendar.DATE, 1);
			toDate = c.getTime();
			System.err.println(toDate);
			sql += " AND a.createTime<=:toDate";
			params.put("toDate", toDate);
		}

		 if (StringUtil.isValid(decision)) {
	            sql += " AND a.decision=:dcs";
	            params.put("dcs", decision);
	        }
		
		 if(structureIds != null && !structureIds.isEmpty()) 
		{
				sql += " AND a.structure.id in :strIds";
				params.put("strIds", structureIds);
		}

		Query q = em.createQuery(sql).setParameter("st", IStatus.ACTIVE);

		Iterator it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}

		return (Long) q.getSingleResult();

	}
	
	
	public long countActiveServices(List<Integer> structureIds)
	{
		Calendar c = Calendar.getInstance();
		Date today = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date next = c.getTime();
		
		return (Long)em.createQuery("SELECT count(a) FROM Authorization a WHERE a.status=:st AND a.fromDate>=:from and a.toDate<=:to and a.structure.id in :str")
				.setParameter("st", IStatus.ACTIVE).setParameter("from", today).setParameter("to", next)
				.setParameter("str", structureIds)
				.getSingleResult();
	}
	
	public long countOfficersInService(List<Integer> structureIds)
	{
		Calendar c = Calendar.getInstance();
		Date today = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date next = c.getTime();
		return (Long)em.createQuery("SELECT count(o) FROM Authorization a JOIN a.officers o WHERE a.status=:st AND a.fromDate>=:from and a.toDate<=:to and a.structure.id in :str")
				.setParameter("st", IStatus.ACTIVE).setParameter("from", today).setParameter("to", next)
				.setParameter("str", structureIds)
				.getSingleResult();
	}
	
	public long countVehiclesInService(List<Integer> structureIds)
	{
		Calendar c = Calendar.getInstance();
		Date today = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date next = c.getTime();
		return (Long)em.createQuery("SELECT count(v) FROM Authorization a JOIN a.vehicles v WHERE a.status=:st AND a.fromDate>=:from and a.toDate<=:to and a.structure.id in :str")
				.setParameter("st", IStatus.ACTIVE).setParameter("from", today).setParameter("to", next)
				.setParameter("str", structureIds)
				.getSingleResult();
	}
	
	
	public List<ValuePair> getOfficersInServiceByDate(Date fromDate, Date toDate,List<Integer> structureIds)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(toDate);
		c.add(Calendar.DATE, 1);
		toDate = c.getTime();
		
		return em.createQuery("SELECT new com.lori.aspa.model.ValuePair(a.fromDate,count(o)) FROM Authorization a JOIN a.officers o "
				+ "WHERE a.status=:st AND a.decision=:dcs AND a.fromDate>=:from and a.toDate<=:to AND a.structure.id IN :str "
				+ "GROUP BY a.fromDate order by a.fromDate")
				.setParameter("st", IStatus.ACTIVE).setParameter("dcs", IDecision.ACCEPT)
				.setParameter("from", fromDate).setParameter("to", toDate)
				.setParameter("str", structureIds)
				.getResultList();
	}
	
	public List<ValuePair> countAuthorizationsByMonth(Integer year, List<Integer> structureIds)
	{
		
		Calendar c = Calendar.getInstance();
		c.set(year, Calendar.JANUARY, 1);
		Date from = c.getTime();
		c.set(year+1, Calendar.JANUARY, 1);
		Date to = c.getTime();
		
		
		return em.createQuery("SELECT new com.lori.aspa.model.ValuePair(MONTH(a.createTime),count(a)) FROM Authorization a "
				+ "WHERE a.status=:st AND a.decision=:dcs AND a.fromDate>=:from and a.toDate<=:to AND a.structure.id IN :str "
				+ "GROUP BY MONTH(a.createTime) order by MONTH(a.createTime)")
				.setParameter("st", IStatus.ACTIVE).setParameter("dcs", IDecision.ACCEPT)
				.setParameter("from", from).setParameter("to", to)
				.setParameter("str", structureIds)
				.getResultList();
	}
	
	
	

}
