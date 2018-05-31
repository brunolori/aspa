package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.annotations.AppTransactional;
import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.OfficerDAO;
import com.lori.aspa.dao.RoleDAO;
import com.lori.aspa.dao.StructureDAO;
import com.lori.aspa.dao.UserDAO;
import com.lori.aspa.dao.sql.UserSQL;
import com.lori.aspa.dto.RoleDTO;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.entities.Officer;
import com.lori.aspa.entities.User;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.exceptions.EmptyFieldsException;
import com.lori.aspa.exceptions.EntityExistsException;
import com.lori.aspa.model.Principal;
import com.lori.aspa.model.UserTokenDTO;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.utils.StringUtil;

@Service
@AppTransactional
public class UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	StructureDAO structureDAO;
	@Autowired
	OfficerDAO officerDAO;
	@Autowired
	RoleDAO roleDAO;
	
	
	public UserDTO findUserById(Integer id) {
		return new Assembler().toDto(userDAO.findById(id));
	}

	public RoleDTO findRoleById(Integer id) {
		return new Assembler().toDto(userDAO.findRoleById(id));
	}

	public UserDTO findUserByUsername(String uname) {
		return new Assembler().toDto(userDAO.findByUsername(uname));
	}

	public List<RoleDTO> loadRoles() {

		return new Assembler().roleListToDto(userDAO.loadRoles());
	}
	
	public List<UserDTO> loadUsers() {
		return new Assembler().userListToDto(userDAO.loadUsers());
	}
	
	public List<UserDTO> queryUser(String query) {
		return new Assembler().userListToDto(userDAO.query(query));
	}
	

	public UserDTO create(UserDTO dto, String uname) throws AppException {

		User regUser = userDAO.findByUsername(uname);

		if (dto == null) {
			throw new EmptyFieldsException("Nuk ka të dhëna");
		}

		if (dto.getOfficer() == null || dto.getOfficer().getId() <= 0) {
			throw new EmptyFieldsException("Nuk ka të dhëna për oficerin");
		}
		
		if (!StringUtil.isValid(dto.getUsername())) {
			throw new EmptyFieldsException("Plotësoni 'Username'");
		}
		
		if(dto.getRoles() == null || dto.getRoles().isEmpty())
		{
			throw new EmptyFieldsException("Zgjidhni rolet'");
		}
		/*
		 * if(!StringUtil.isValid(dto.getSecret())) { throw new
		 * EmptyFieldsException("Plotësoni 'Fjalëkalimin'"); }
		 */

		List<User> users = userDAO.search(new UserSQL(dto.getUsername()));
		if (users != null && !users.isEmpty()) {
			throw new EntityExistsException("Ky përdorues ekziston në sistem");
		}

		Officer o = new Officer();
		o.setCreateTime(Calendar.getInstance().getTime());
		o.setCreateUser(regUser);
		o.setFunction(dto.getOfficer().getFunction());
		o.setGrade(dto.getOfficer().getGrade());
		o.setId(dto.getOfficer().getId());
		o.setName(dto.getOfficer().getName());
		o.setPosition(dto.getOfficer().getPosition());
		o.setStatus(IStatus.ACTIVE);
		o.setStructure(structureDAO.findById(dto.getOfficer().getStructureId()));
		o.setSurname(dto.getOfficer().getSurname());

		o = officerDAO.create(o);

		User u = new User();
		u.setUsername(dto.getUsername());
		u.setOfficer(o);
		u.setCreateTime(Calendar.getInstance().getTime());
		u.setCreateUser(regUser);
		u.setStatus(IStatus.ACTIVE);

		List<String> roles = new ArrayList<>();
		if (dto.getRoles() != null && !dto.getRoles().isEmpty()) {
			for (RoleDTO d : dto.getRoles()) {
				roles.add(d.getTag());
			}
		}

		u.setRoles(roleDAO.findByCode(roles));
		u = userDAO.create(u);
		return new Assembler().toDto(u);
	}

		

	public UserTokenDTO login(Principal princ) {
		User u = userDAO.findByUsername(princ.getUsername());

		if (u == null)
			return null;

		if (u.getStatus() != IStatus.ACTIVE) {
			return null;
		}
		if (!u.getSecret().equals(princ.getPassword())) {
			return null;
		}

		UserDTO user = new Assembler().toDto(u);

		UserTokenDTO ut = new UserTokenDTO();
		ut.setUser(user);
		ut.setToken(TokenUtil.generateToken(user));

		return ut;

	}


	
}
