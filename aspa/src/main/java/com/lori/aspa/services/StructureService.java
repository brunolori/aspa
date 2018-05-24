package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.annotations.AppTransactional;
import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.StructureDAO;
import com.lori.aspa.dao.UserDAO;
import com.lori.aspa.dto.StructureDTO;
import com.lori.aspa.entities.Structure;
import com.lori.aspa.entities.User;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.exceptions.EmptyFieldsException;

@Service
public class StructureService {

	@Autowired
	StructureDAO structureDAO;
	@Autowired 
	UserDAO userDAO;


	public StructureDTO findStructureById(Integer structureId) {
		return new Assembler().toDto(structureDAO.findById(structureId));
	}

	public List<StructureDTO> getStructureChilds(Integer structureId) {

		List<StructureDTO> strs = new ArrayList<>();

		List<StructureDTO> childs = new Assembler()
				.structureListToDto(structureDAO.search(null, structureId, IStatus.ACTIVE, null, null));
		if (childs != null && !childs.isEmpty()) {
			for (StructureDTO s : childs) {
				strs.add(s);
				strs.addAll(getStructureChilds(s.getId()));
			}

		}

		return strs;

	}
	
	
	public List<StructureDTO> loadStructures() {

		return new Assembler().structureListToDto(structureDAO.loadStructures());

	}
	
	@AppTransactional
	public StructureDTO registerStructure(StructureDTO dto, String uname) throws AppException {

		if(dto.getId() <= 0)
		{
			throw new EmptyFieldsException("Plotëso ID e RMIS");
		}
		if (dto.getName() == null) {

			throw new EmptyFieldsException("Emri strukturës i papërcaktuar ");
		}

		if (dto.getParentId() <= 0) {

			throw new EmptyFieldsException("Struktura prind e papërcaktuar");
		}


		User u = userDAO.findByUsername(uname);
		
		Structure str = new Structure();
		str.setId(dto.getId());
		str.setName(dto.getName());
		str.setParent(new Structure(dto.getParentId()));
		str.setStatus(IStatus.ACTIVE);
		str.setCreateTime(Calendar.getInstance().getTime());
		
		str.setCreateUser(u);

		str = structureDAO.create(str);

		return new Assembler().toDto(str);

	}

	@AppTransactional
	public StructureDTO modifyStructure(StructureDTO dto, String uname) throws AppException {

		
		if (dto.getName() == null) {

			throw new EmptyFieldsException("Emri strukturës i papërcaktuar ");
		}

		if (dto.getParentId() <= 0) {

			throw new EmptyFieldsException("Struktura prind e papërcaktuar");
		}

	    User user = userDAO.findByUsername(uname);
		Structure str = structureDAO.findById(dto.getId());
		str.setName(dto.getName());
		str.setParent(new Structure(dto.getId()));
		str.setUpdateTime(Calendar.getInstance().getTime());
		str.setUpdateUser(user);


		str = structureDAO.update(str);

		return new Assembler().toDto(str);

	}
	

	

}
