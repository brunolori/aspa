package com.lori.aspa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lori.aspa.constants.IStatus;
import com.lori.aspa.entities.City;
import com.lori.aspa.entities.Region;
import com.lori.aspa.entities.VehicleType;

@SuppressWarnings("unchecked")
@Repository
public class HelperDAO {

	
	@PersistenceContext
	EntityManager em;
	
	
	
	public List<Region> loadRegions()
	{
		return em.createQuery("FROM Region r ORDER BY r.name").getResultList();
	}
	
	
	
	public List<City> loadCities(Integer regionId)
	{
		String sql = "FROM City c where 1=1 ";
		
		if(regionId != null) {
			sql+="AND c.region.id=:rid ";
		}
			
		sql+="ORDER BY c.name ";
		
		
		Query q = em.createQuery(sql);
		if(regionId != null) {
			q.setParameter("rid", regionId);
		}
		
		return q.getResultList();
	}
	
	public List<City> loadMunicipalities(Integer cityId)
	{
		String sql = "FROM Municipality m where 1=1 ";
		
		if(cityId != null) {
			sql+="AND m.city.id=:cid ";
		}
			
		sql+="ORDER BY m.name ";
		
		
		Query q = em.createQuery(sql);
		if(cityId != null) {
			q.setParameter("cid", cityId);
		}
		
		return q.getResultList();
	}
	
	public List<VehicleType> loadVehicleTypes()
	{
		return em.createQuery("FROM VehicleType t WHERE t.status=:ac").setParameter("ac", IStatus.ACTIVE)
				.getResultList();
	}
	
	
	
	
}
