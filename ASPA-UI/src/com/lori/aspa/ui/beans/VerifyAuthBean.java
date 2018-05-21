package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.models.ApprovalHistoryDTO;
import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.services.AuthService;
import com.lori.aspa.ui.services.UserService;
import com.lori.aspa.ui.utils.Messages;
import com.lori.aspa.ui.utils.StringUtil;
import com.lori.aspa.ui.utils.Util;


@ManagedBean
@ViewScoped
public class VerifyAuthBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean login;

	String token;
	Integer userId;

	AuthorizationDTO auth;
	List<ApprovalHistoryDTO> history;
	ApprovalHistoryDTO decider;
	UserDTO nextUser;

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

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

	public ApprovalHistoryDTO getDecider() {
		return decider;
	}

	public void setDecider(ApprovalHistoryDTO decider) {
		this.decider = decider;
	}

	public UserDTO getNextUser() {
		return nextUser;
	}

	public void setNextUser(UserDTO nextUser) {
		this.nextUser = nextUser;
	}

	
	
	
	@PostConstruct
	public void load() {
		String idString = Util.getParam("auth_id");
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();

		try {
			Integer id = Integer.valueOf(idString);
			this.auth = new AuthService().getAuthorizationById(id);
			if(auth==null)
			{
				Util.redirect("sec/verify_auth_list");
			}
			else
			{
				this.history = new AuthService().getAuthHistory(auth, token);
				this.decider = new ApprovalHistoryDTO();
				decider.setAuthorizationId(auth.getId());
				this.nextUser = null;
			}

		} catch (NumberFormatException ne) {
			Util.redirect("sec/verify_auth_list");
		}

	}

	public void decide() {
		if(!StringUtil.isValid(decider.getDecision()))
		{
			Messages.throwFacesMessage("Zgjidhni veprimin", 3);
			return;
		}
		
		if(nextUser != null)
		{
			decider.setNextUserId(nextUser.getId());
		}
		new AuthService().decide(decider, token);
		
		Util.redirect("sec/verify_auth_list");
		
	}
	
	
	public List<UserDTO> searchUser(String query)
	{
		return new UserService().queryUser(query);
	}

}
