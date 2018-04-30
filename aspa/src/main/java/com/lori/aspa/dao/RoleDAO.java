package com.lori.aspa.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lori.aspa.constants.IStatus;
import com.lori.aspa.entities.Role;


@SuppressWarnings("unchecked")
@Repository
public class RoleDAO {
	
	@PersistenceContext
	EntityManager em;
	
	
	public List<Role> findByCode(List<String> codes)
	{
		return em.createQuery("FROM Role r where r.status=:st and r.tag IN :tg")
				.setMaxResults(1).setParameter("st", IStatus.ACTIVE)
				.setParameter("tg", codes)
				.getResultList();
		
	}
	
	public Role create(Role role) 
	{
		em.persist(role);
		em.flush();
		return role;
	}
	
	public Role update(Role role)
	{
		return em.merge(role);
	}
}
