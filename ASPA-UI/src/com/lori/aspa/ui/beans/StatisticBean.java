package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.lori.aspa.ui.constants.IDecision;
import com.lori.aspa.ui.models.OfficerCount;
import com.lori.aspa.ui.models.StructureDTO;
import com.lori.aspa.ui.models.ValuePair;
import com.lori.aspa.ui.services.StatisticService;
import com.lori.aspa.ui.services.StructureService;
import com.lori.aspa.ui.utils.DateUtil;


@ManagedBean
@ViewScoped
public class StatisticBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	String token;
	Integer userId;
	
	
	Date fromDate;
	Date toDate;
	Integer structureId;
	List<Integer> years;
	Integer year;
	List<StructureDTO> structures;
	
	BarChartModel officersModel;
	BarChartModel authsModel;
	
	List<OfficerCount> officersByService;
	
	long totalAuthNr;
	long inProcessAuthNr;
	long approvedAuthNr;
	long deniedAuthNr;
	long activeAuthNr;
	long totalOffNr;
	long totalVehicleNr;
	
	



	public LoginBean getLogin() {
		return login;
	}
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public List<StructureDTO> getStructures() {
		return structures;
	}

	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}

	public long getTotalAuthNr() {
		return totalAuthNr;
	}

	public void setTotalAuthNr(long totalAuthNr) {
		this.totalAuthNr = totalAuthNr;
	}

	public long getInProcessAuthNr() {
		return inProcessAuthNr;
	}

	public void setInProcessAuthNr(long inProcessAuthNr) {
		this.inProcessAuthNr = inProcessAuthNr;
	}

	public long getApprovedAuthNr() {
		return approvedAuthNr;
	}

	public void setApprovedAuthNr(long approvedAuthNr) {
		this.approvedAuthNr = approvedAuthNr;
	}

	public long getDeniedAuthNr() {
		return deniedAuthNr;
	}
	public void setDeniedAuthNr(long deniedAuthNr) {
		this.deniedAuthNr = deniedAuthNr;
	}
	public long getActiveAuthNr() {
		return activeAuthNr;
	}

	public void setActiveAuthNr(long activeAuthNr) {
		this.activeAuthNr = activeAuthNr;
	}

	public long getTotalOffNr() {
		return totalOffNr;
	}

	public void setTotalOffNr(long totalOffNr) {
		this.totalOffNr = totalOffNr;
	}

	public long getTotalVehicleNr() {
		return totalVehicleNr;
	}

	public void setTotalVehicleNr(long totalVehicleNr) {
		this.totalVehicleNr = totalVehicleNr;
	}

	public Integer getStructureId() {
		return structureId;
	}
	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public List<Integer> getYears() {
		return years;
	}
	public void setYears(List<Integer> years) {
		this.years = years;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public BarChartModel getOfficersModel() {
		return officersModel;
	}
	public void setOfficersModel(BarChartModel officersModel) {
		this.officersModel = officersModel;
	}
	public BarChartModel getAuthsModel() {
		return authsModel;
	}
	public void setAuthsModel(BarChartModel authsModel) {
		this.authsModel = authsModel;
	}

	public List<OfficerCount> getOfficersByService() {
		return officersByService;
	}
	public void setOfficersByService(List<OfficerCount> officersByService) {
		this.officersByService = officersByService;
	}
	
	
	@PostConstruct
	public void load()
	{
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();
		init();
	}
	
	
	public void init() {
		this.fromDate = DateUtil.getFirstMonthDate(Calendar.getInstance().get(Calendar.MONTH) + 1);
		this.toDate = new Date();
		this.structures = new StructureService().getUserStructures(token);
		this.years = new ArrayList<>();
		years.add(2018);
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		onChange();
		
	}
	

	
	public void onChange() {
	
		StatisticService service = new StatisticService();
		this.totalAuthNr = service.countAllAuths(fromDate, toDate, null, structureId, token);
		this.inProcessAuthNr = service.countAllAuths(fromDate, toDate, IDecision.IN_PROCESS, structureId, token);
		long returned = service.countAllAuths(fromDate, toDate, IDecision.RETURNED, structureId, token);
		inProcessAuthNr += returned;
		this.approvedAuthNr = service.countAllAuths(fromDate, toDate, IDecision.ACCEPT, structureId, token);
		this.deniedAuthNr = service.countAllAuths(fromDate, toDate, IDecision.DENY, structureId, token);
		this.activeAuthNr = service.countActiveServices(structureId, token);
		this.totalOffNr = service.countOfficersInService(structureId, token);
		this.totalVehicleNr = service.countVehiclesInService(structureId, token);
		this.officersByService = service.getOfficersByServiceNo(fromDate, toDate, structureId, token);
		createOfficerModel();
		createAuthsModel();

	}
	
	
	public void createOfficerModel()
	{
		
		int max = 1;
		StatisticService service = new StatisticService();
		
		officersModel = new BarChartModel();
		officersModel.setExtender("skinBar");

		
		ChartSeries officers = new ChartSeries();
        officers.setLabel("Punonjesit");
        
        List<ValuePair> pairs = service.getOfficersInServiceByDate(fromDate, toDate, structureId, token);
        
        if(pairs != null)
        {
        	for(ValuePair p : pairs)
        	{
        		officers.set(p.getKey(), (Integer)p.getValue());
        	}
        	max = pairs.size();
        }else
        {
        	officers.set("Nuk ka data te vlefshme", 0);
        }

 
        officersModel.addSeries(officers);
        
		officersModel.setTitle("Punonjesit me sherbim");
		officersModel.setLegendPosition("ne");
         
		Axis xAxis = officersModel.getAxis(AxisType.X);
        xAxis.setLabel("Data");
         
        Axis yAxis = officersModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nr Punonjesve");
        yAxis.setMin(0);
        yAxis.setMax(max+5);
	}
	
	
	public void createAuthsModel()
	{
		int max = 1;
		StatisticService service = new StatisticService();
		
		authsModel = new BarChartModel();
		authsModel.setExtender("skinBar");
		
		ChartSeries auths = new ChartSeries();
        auths.setLabel("Autorizimet sipas muajve");
        
        List<ValuePair> pairs = service.countAuthorizationsByMonth(year, structureId, token);
        
        if(pairs != null)
        {
        	for(ValuePair p : pairs)
        	{
        		auths.set(p.getKey(), (Integer)p.getValue());
        	}
        	max = pairs.size();
        }else
        {
        	auths.set("Nuk ka data te vlefshme", 0);
        }

 
        authsModel.addSeries(auths);
        
        authsModel.setTitle("Autorizimet");
        authsModel.setLegendPosition("ne");
         
		Axis xAxis = authsModel.getAxis(AxisType.X);
        xAxis.setLabel("Muaji");
         
        Axis yAxis = authsModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nr Autorizimeve");
        yAxis.setMin(0);
        yAxis.setMax(max+5);
	}
	
	

}
