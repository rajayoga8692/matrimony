package utility.action;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.api.core.InjectParam;

import utility.services.LoginService;

@Path("/salesreport")
public class SalesReportAction {

	
	@InjectParam
	LoginService ls;

	@POST
	@Path("currentMonthReport") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response paymenthistorylist(){ 
		List<?> result = ls.getQuery(" SELECT c.registerid,c.religion,c.registerno,c.name,c.gender,b.planname,b.amount,b.contacts FROM assigned_plan a,membership_plan b,personal c ,login l where c.id=a.personalid and c.id=l.personal_id and a.membership_plan_id=b.planid and a.status='A' and MONTH(l.createddate) = MONTH(CURRENT_DATE()) AND YEAR(l.createddate) = YEAR(CURRENT_DATE());");
				
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build(); 
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	@POST 
	@Path("getReport/{startdate}/{enddate}") 
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getReport(@PathParam("startdate")String startdate,@PathParam("enddate")String enddate){ 
		List<?> result = ls.getQuery(" SELECT c.registerid,c.religion,c.registerno,c.name,c.gender,b.planname,b.amount,b.contacts FROM assigned_plan a,membership_plan b,"
				+ "personal c ,login l where c.id=a.personalid and c.id=l.personal_id and a.membership_plan_id=b.planid and a.status='A' and "
				+ " (l.createddate between '"+startdate+" 00:00:00' and '"+enddate+" 23:59:00');"); 
				
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build(); 
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}

}