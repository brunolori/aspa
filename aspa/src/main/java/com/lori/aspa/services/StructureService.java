package com.lori.aspa.services;

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

		Structure str = structureDAO.findById(structureId);

		List<Structure> list = structureDAO.listChilds(str.getCode());

		list.remove(str);

		return new Assembler().structureListToDto(list);

	}

	public List<StructureDTO> getStructureChilds(String code) {

		List<Structure> list = structureDAO.listChilds(code);
		for (Structure s : list) {
			if (s.getCode().equals(code)) {
				list.remove(s);
				break;
			}
		}

		return new Assembler().structureListToDto(list);

	}

	public List<StructureDTO> loadStructures() {

		return new Assembler().structureListToDto(structureDAO.loadStructures());

	}

	@AppTransactional
	public StructureDTO registerStructure(StructureDTO dto, String uname) throws AppException {

		if (dto.getId() <= 0) {
			throw new EmptyFieldsException("Plotëso ID e RMIS");
		}
		if (dto.getName() == null) {

			throw new EmptyFieldsException("Emri strukturës i papërcaktuar ");
		}

		if (dto.getParentId() <= 0) {

			throw new EmptyFieldsException("Struktura prind e papërcaktuar");
		}

		StructureDTO parent = findStructureById(dto.getParentId());
		String code = parent.getCode() + "[" + dto.getId() + "]";
		User u = userDAO.findByUsername(uname);

		Structure str = new Structure();
		str.setId(dto.getId());
		str.setName(dto.getName());
		str.setParent(new Structure(dto.getParentId()));
		str.setStatus(IStatus.ACTIVE);
		str.setCreateTime(Calendar.getInstance().getTime());
		str.setCode(code);
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

		StructureDTO parent = findStructureById(dto.getParentId());
		String code = parent.getCode() + "[" + dto.getId() + "]";

		User user = userDAO.findByUsername(uname);
		Structure str = structureDAO.findById(dto.getId());
		boolean updateChilds = !str.getCode().equals(code);

		str.setName(dto.getName());
		str.setCode(code);
		str.setParent(new Structure(dto.getParentId()));
		str.setUpdateTime(Calendar.getInstance().getTime());
		str.setUpdateUser(user);
		str = structureDAO.update(str);

		if (updateChilds) {
			List<StructureDTO> childs = getStructureChilds(dto.getCode());

			if (childs != null) {
				for (StructureDTO s : childs) {
					updateCode(s, code);
				}
			}
		}

		return new Assembler().toDto(str);

	}

	private void updateCode(StructureDTO dto, String parentNewCode) {

		Structure s = structureDAO.findById(dto.getId());
		String newCode = parentNewCode + "[" + s.getId() + "]";
		s.setCode(newCode);
		s = structureDAO.update(s);
		List<StructureDTO> childs = getStructureChilds(s.getId());
		if (childs != null) {
			for (StructureDTO c : childs) {
				updateCode(c, newCode);
			}
		}

	}

	public StructureDTO delete(StructureDTO dto) {
		Structure str = structureDAO.findById(dto.getId());
		str.setStatus(IStatus.NOT_ACTIVE);
		return new Assembler().toDto(structureDAO.update(str));
	}

}
