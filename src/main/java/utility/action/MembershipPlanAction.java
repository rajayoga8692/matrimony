package utility.action;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.time.DateUtils;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.InjectParam;

import utility.model.AssignedPlan;
import utility.model.MembershipPlan;
import utility.services.MemberAssignService;
import utility.services.MembershipPlanService;
import utility.vo.MembershipPlanVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/plan")
public class MembershipPlanAction {

	@InjectParam
	MembershipPlanService membershipPlanService; 
	
	@InjectParam
	MemberAssignService memberAssignService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlanList(@PathParam("status") String status) {
		try{
			String query = "select * from membership_plan where status='"+status+"'" ;
			List<?> getDistrictList = membershipPlanService.getQuery(query);
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
	@Path("/vipsearch/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVip(@PathParam("id") String id) {
		try{
			String query = "select a.*,b.imagepath from personal a left outer join gallery b on a.id=b.personalid where registerno='"+id+"'" ;
			List<?> getVipList = membershipPlanService.getQuery(query);
			if(getVipList.size()!=0){
				return Response.status(Status.OK).entity(getVipList).build();	
			}else{
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
			}	
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePlan(MembershipPlanVO membershipPlanVO) {
		try{
			MembershipPlan MembershipPlan =  new MembershipPlan();
			MembershipPlan.setPlanname(membershipPlanVO.getPlanname());
			MembershipPlan.setStatus("A");
			MembershipPlan.setContacts(membershipPlanVO.getContacts());
			MembershipPlan.setAmount(membershipPlanVO.getAmount());
			MembershipPlan.setValiditydays(membershipPlanVO.getValiditydays());
			Integer districtid = membershipPlanService.save(MembershipPlan);
			if(districtid!=null){
				return Response.status(Status.OK).entity(Status.OK).build();	
			}else{
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
			}	
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	@POST
	@Path("/updatePlan")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMemberplan(MembershipPlanVO membershipPlanVO) {
		try{

			String query = "update MembershipPlan set planname='"+membershipPlanVO.getPlanname()+"' , contacts='"+membershipPlanVO.getContacts()+"'"
					+ " ,amount ='"+membershipPlanVO.getAmount()+"' ,validitydays='"+membershipPlanVO.getValiditydays()+"' where planid='"+membershipPlanVO.getPlanid()+"'" ;
			int success =membershipPlanService.getUpdate(query);

			if(success!=0){
				return Response.status(Status.OK).entity(Status.OK).build();	
			}else{
				return Response.status(Status.OK).entity(Status.BAD_REQUEST).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Path("/removeMemberplan/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSubcaste(@PathParam("status") String status,@PathParam("id") String id) {
		try{

			String query = "update MembershipPlan set status='"+status+"' where planid='"+id+"'" ;
			int success =membershipPlanService.getUpdate(query);

			if(success!=0){
				return Response.status(Status.OK).entity(Status.OK).build();	
			}else{
				return Response.status(Status.OK).entity(Status.BAD_REQUEST).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GET
	@Path("/all/getPlans")
	@Produces(MediaType.APPLICATION_JSON)
	public Response planDetails(){
		
		String query="SELECT * FROM membership_plan where status ='A' or status='F'";
		
		
		List<?> result = membershipPlanService.getQuery(query);
		 
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}

	   
	@GET
	@Path("planname/{memberid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@PathParam("memberid") String memberid){
		
			List<?> result = membershipPlanService.getQuery("select a.expireddate,a.idassigned_plan,a.subscripeddate,a.updatecount,b.planname,b.contacts,b.amount,b.validitydays"
					+ " from assigned_plan a , membership_plan b where a.personalid='"+memberid+"' and b.planid=a.membership_plan_id");

			if(result.size() !=0 )   
			return Response.ok().status(Status.OK).entity(result).build();  
			
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	  
	@GET
	@Path("subscript/{planid}/{memberid}/{process}/{idassigned_plan}/{contacts}/{validitydays}/{status}/{vdays}/{econtacts}/{vtype}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@PathParam("planid") String planid,@PathParam("memberid") String memberid,@PathParam("process") String process,
			@PathParam("idassigned_plan") String idassigned_plan,@PathParam("contacts")String contacts,@PathParam("validitydays")String validitydays,
			@PathParam("status")String status,@PathParam("vdays")String vdays,@PathParam("econtacts")String econtacts,@PathParam("vtype")String vtype){
		try{
		String query = "";
		int success=0;
 		if (process.equals("update")){
 			
 			if(status.equals("A")){ 
 				Date expireddate = DateUtils.addMonths(new Date(), Integer.parseInt(validitydays));
 				java.text.SimpleDateFormat sdf = 
 					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

 					String currentTime = sdf.format(expireddate);
 					  
				 query = "update AssignedPlan set membership_plan_id='"+planid+"', updatecount='"+contacts+"' , subscripeddate=now(),expireddate='"+currentTime+"' where idassigned_plan='"+idassigned_plan+"'" ;
				 success  = membershipPlanService.getUpdate(query);
 			}else if (status.equals("F")){
 				int sum = Integer.parseInt(contacts)+Integer.parseInt(econtacts);
 				Date expireddate = null;
 				String currentTime =null;
 				if(vtype.equals("d")) {   
 					 expireddate = DateUtils.addDays(new Date(), Integer.parseInt(vdays));
  	 				java.text.SimpleDateFormat sdf = 
  	 					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 					  currentTime = sdf.format(expireddate);

 				} else if(vtype.equals("m")){
 					
 	 				  expireddate = DateUtils.addMonths(new Date(), Integer.parseInt(vdays)); 
 	 				java.text.SimpleDateFormat sdf = 
 	 					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

 	 					  currentTime = sdf.format(expireddate);
 				}  

 				query = "update AssignedPlan set membership_plan_id='"+planid+"', updatecount='"+sum+"' , expireddate='"+currentTime+"'  where idassigned_plan='"+idassigned_plan+"'" ;
				success  = membershipPlanService.getUpdate(query);   
 			} 
		}else{
				AssignedPlan assignedPlan =  new AssignedPlan();
				assignedPlan.setPersonalid(Integer.parseInt(memberid)); 
				assignedPlan.setMembership_plan_id(Integer.parseInt(planid));
				assignedPlan.setStatus("A");
				assignedPlan.setSubscripeddate(new Date());
 				Date expireddate = DateUtils.addMonths(new Date(), Integer.parseInt(validitydays));
 				assignedPlan.setExpireddate(expireddate);
 				if(status.equals("A")){ 
 					assignedPlan.setUpdatecount(Integer.parseInt(contacts));
 				} else if(status.equals("F")){
 					assignedPlan.setUpdatecount(Integer.parseInt(econtacts));
 				}
				success = memberAssignService.save(assignedPlan);    
			}  
			

			if(success != 0 )
				return Response.ok().status(Status.OK).entity(Status.ACCEPTED).build();
			else
				return Response.ok().status(Status.OK).entity(Status.CONFLICT).build();
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok().status(Status.OK).entity(Status.BAD_GATEWAY).build();
		}
	}
		
}

	
	/*@POST
	@Path("/removeSubcaste/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSubcaste(@PathParam("status") String status,@PathParam("id") String id) {
		try{

			String query = "update SubCaste set status='"+status+"' where subcasteid='"+id+"'" ;
			
			String query = "update membership_plan set planname='"+membershipPlanVO.getPlanname()+"' , contacts='"+membershipPlanVO.getContacts()+"'"
					+ " ,amount ='"+membershipPlanVO.getAmount()+"'  where planid='"+membershipPlanVO.getPlanid()+"'" ;
			
			
			int success =membershipPlanService.getUpdate(query);

			if(success!=0){
				return Response.status(Status.OK).entity(Status.OK).build();	
			}else{
				return Response.status(Status.OK).entity(Status.BAD_REQUEST).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}*/


