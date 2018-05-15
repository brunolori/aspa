

package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.models.ApprovalHistoryDTO;
import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.services.AuthService;
import com.lori.aspa.ui.utils.Util;

@ManagedBean
@ViewScoped
public class ViewAuthBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	AuthorizationDTO auth;
	List<ApprovalHistoryDTO> history;


	
	public AuthorizationDTO getAuth() {
		return auth;
	}
	public void setAuth(AuthorizationDTO auth) {
		this.auth = auth;
	}
	public List<ApprovalHistoryDTO> getHistory() {
		return history;
	}
	public void setHistory(List<ApprovalHistoryDTO> history) {
		this.history = history;
	}
	
	
	
	
	@PostConstruct
	public void load()
	{
		String idStr = Util.getParam("auth_id");
		try {
		   Integer id = Integer.valueOf(idStr);
		   this.auth = new AuthService().getAuthorizationById(id, null);
		}catch(NumberFormatException ne) {
			Util.redirect("sec/my_auth_dashboard");
		}
		
	}
	
	
	
	public String delete()
	{
		new AuthService().deleteAuthorization(auth, null);
		
		return "my_auth_dashboard";
	}
	
	
	
	
}
