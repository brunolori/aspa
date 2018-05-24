package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.clients.ApiException;
import com.lori.aspa.ui.models.StructureDTO;
import com.lori.aspa.ui.services.StructureService;
import com.lori.aspa.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class StructureBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean login;

	String token;
	Integer userId;

	List<StructureDTO> structures;

	StructureDTO structure;
	StructureDTO selectedStructure;
	

	public List<StructureDTO> getStructures() {
		return structures;
	}

	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}

	public StructureDTO getStructure() {
		return structure;
	}

	public void setStructure(StructureDTO structure) {
		this.structure = structure;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public StructureDTO getSelectedStructure() {
		return selectedStructure;
	}

	public void setSelectedStructure(StructureDTO selectedStructure) {
		this.selectedStructure = selectedStructure;
	}

	@PostConstruct
	public void load() {
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();

		init();
	}

	private void init() {
		this.structure = new StructureDTO();
		this.selectedStructure = null;
		this.structures = new StructureService().loadStructures();

	}

	public void clear() {
		init();
	}

	public void onStructureSelected() {
		this.structure = selectedStructure;
	}
	

	public void register() {
		
		try {
			new StructureService().registerStructure(structure, token);
			Messages.throwFacesMessage("Struktura u regjistrua me sukses", 1);
		    init();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modify() {
		try {
			new StructureService().modifyStructure(structure, token);
			Messages.throwFacesMessage("Struktura u modifikua me sukses", 1);
		    init();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void delete() {}

}
