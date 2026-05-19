package utility.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.InjectParam;

import utility.model.ViewedHistory;
import utility.services.MembershipPlanService;
import utility.services.ViewedHistoryService;
import utility.vo.ViewedHistoryVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/viewhistory")
public class ViewedHistoryAction {

	@InjectParam
	ViewedHistoryService viewedHistoryService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getViewedHistoryService(@PathParam("status") String status) {
		try{
			String query = "select * from viewedhistory where status='"+status+"'" ;
			List<?> getDistrictList = viewedHistoryService.getQuery(query);
			if(getDistrictList.size()!=0){
				return Response.status(Status.OK).entity(getDistrictList).build();	
			}else{
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
			}	
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@GET	
	@Path("/history/{pid}")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewedHistory(@PathParam("pid") String pid) {
		try{
			String query = "select c.photo,DATE_FORMAT(a.vieweddate, '%d/%m/%Y') as vieweddate ,b.dateofbirth,f.nativeplace,b.name,b.registerid,b.heightft,b.education,b.registerno,b.religion,b.marriedstatus,"
					+ "b.gender,b.complexion from viewedhistory a,personal b,expetation c,familydetails f where a.viewedmemberid=b.id and f.personal_id=b.id and  c.personal_id=b.id  and a.viewedby='"+pid+"'" ;
			List<?> getDistrictList = viewedHistoryService.getQuery(query);
			if( getDistrictList!=null && getDistrictList.size()!=0){
				return Response.status(Status.OK).entity(getDistrictList).build();	 
			}else{  
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();  
			}	
		}catch(Exception e){ 
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@GET	    
	@Path("/todayhistory")     
	@Produces(MediaType.APPLICATION_JSON)
	public Response todayHistory() { 
		try{
			String query = "select g.name as membername , g.registerno as memberid ,c.photo,DATE_FORMAT(a.vieweddate, '%d/%m/%Y %H:%m') as vieweddate ,h.addressone,h.contactno,b.dateofbirth,f.nativeplace,b.name,b.registerid,b.heightft,b.education,b.registerno,b.religion,b.marriedstatus,"
					+ "b.gender,b.complexion from viewedhistory a,personal b,expetation c,familydetails f,personal g,contactdetails h where h.personal_id= b.id and  a.viewedmemberid=b.id and g.id=a.viewedby and f.personal_id=b.id and  c.personal_id=b.id  and DATE_FORMAT(a.vieweddate, '%Y-%m-%d') =CURDATE()" ;
			List<?> getDistrictList = viewedHistoryService.getQuery(query);
			if( getDistrictList!=null && getDistrictList.size()!=0){
				return Response.status(Status.OK).entity(getDistrictList).build();	 
			}else{  
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();  
			}	
		}catch(Exception e){ 
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
 
	     
	@GET	    
	@Path("/memberIdHistory/{memberid}")     
	@Produces(MediaType.APPLICATION_JSON)
	public Response memberIdHistory(@PathParam("memberid") String memberid) { 
		try{
			String query = "select g.name as membername , g.registerno as memberid ,c.photo,DATE_FORMAT(a.vieweddate, '%d/%m/%Y %H:%m') as vieweddate ,h.addressone,h.contactno,b.dateofbirth,f.nativeplace,b.name,b.registerid,b.heightft,b.education,b.registerno,b.religion,b.marriedstatus,"
					+ "b.gender,b.complexion from viewedhistory a,personal b,expetation c,familydetails f,personal g, "
					+ "contactdetails h where h.personal_id= b.id and  a.viewedmemberid=b.id and g.id=a.viewedby and "
					+ "f.personal_id=b.id and  c.personal_id=b.id  and g.registerno = '"+memberid+"' " ;
			List<?> getDistrictList = viewedHistoryService.getQuery(query);
			if( getDistrictList!=null && getDistrictList.size()!=0){
				return Response.status(Status.OK).entity(getDistrictList).build();	 
			}else{  
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();    
			}	
		}catch(Exception e){ 
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@GET	
	@Path("/yourprofileHistory/{pid}")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response yourprofileHistory(@PathParam("pid") String pid) {
		try{
			String query = "select c.photo,DATE_FORMAT(a.vieweddate, '%d/%m/%Y') as vieweddate ,b.dateofbirth,f.nativeplace,b.name,b.registerid,b.heightft,b.education,b.registerno,b.religion,b.marriedstatus,"
					+ "b.gender,b.complexion from viewedhistory a,personal b,expetation c,familydetails f where a.viewedby=b.id and f.personal_id=b.id and  c.personal_id=b.id  and a.viewedmemberid='"+pid+"'" ;
			List<?> getDistrictList = viewedHistoryService.getQuery(query);
			if( getDistrictList!=null && getDistrictList.size()!=0){
				return Response.status(Status.OK).entity(getDistrictList).build();	 
			}else{  
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();  
			}	
		}catch(Exception e){ 
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@InjectParam
	MembershipPlanService membershipPlanService; 
	
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveViewedHistory(ViewedHistoryVO viewedHistoryVO) {
		try{
			HashMap map = new HashMap();
  			
			String query = "select viewedhistoryid from viewedhistory where viewedmemberid="+viewedHistoryVO.getViewedmemberid()+" and viewedby="+viewedHistoryVO.getViewedby()+" " ;
			List<?> getViewedList = viewedHistoryService.getQuery(query);
			String query2 = "select updatecount from assigned_plan where personalid="+viewedHistoryVO.getViewedby()+" " ;
			List<?> getViewedList1 = viewedHistoryService.getQuery(query2);
			Map map1 = (Map)getViewedList1.get(0);
			if(getViewedList!=null && getViewedList.size()!=0) {
					
					map.put("updatecount", Integer.parseInt(""+map1.get("updatecount")));
					map.put("message", "found");
 					return Response.status(Status.OK).entity(map).build();
 				} else {
				ViewedHistory viewedHistory =  new ViewedHistory();
				viewedHistory.setViewedmemberid(viewedHistoryVO.getViewedmemberid());
				viewedHistory.setViewedby(viewedHistoryVO.getViewedby());
				viewedHistory.setVieweddate(new Date()); 
	 			viewedHistory.setStatus("A");
				Integer viewedHistoryid = viewedHistoryService.save(viewedHistory);
				if(viewedHistoryid!=null){
					String query1 = "update AssignedPlan set updatecount='"+(Integer.parseInt(""+map1.get("updatecount"))-1)+"' where personalid='"+viewedHistoryVO.getViewedby()+"'" ;
					int success  = membershipPlanService.getUpdate(query1);
					map.put("updatecount", (Integer.parseInt(""+map1.get("updatecount"))-1));
					map.put("message", "success");
					return Response.status(Status.OK).entity(map).build();	
				}else{
					return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
				}
		 }
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}

	}
  
 
	 
	
}


