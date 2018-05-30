package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.lori.aspa.ui.utils.DateUtil;

@RequestScoped
@ManagedBean
public class FormatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String formatDate(Date date)
	{
		Calendar dt = Calendar.getInstance();
		dt.setTime(date);
		
		if(date == null) return "";
		
		if(dt.get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR))
		{
			return "Sot";
		}
		
		if(dt.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR))
		{
			return dt.get(Calendar.DAY_OF_MONTH)+" "+DateUtil.numToMonth(dt.get(Calendar.MONTH));			
		}
		else
		{
			return dt.get(Calendar.DAY_OF_MONTH)+" "+DateUtil.numToMonth(dt.get(Calendar.MONTH))+" "+dt.get(Calendar.YEAR);
		}
		
		
	}
	
	
	
	
	

}
