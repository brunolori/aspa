package com.lori.aspa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.annotations.AppTransactional;
import com.lori.aspa.dao.AuthorizationDAO;

@Service
@AppTransactional
public class AuthorizationService {
	
	
	@Autowired
	AuthorizationDAO authorizationDAO;
	
	

}
