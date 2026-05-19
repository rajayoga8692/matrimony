package utility.action;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Criteria;

import com.sun.jersey.api.core.InjectParam;

import utility.services.LoginService;
import utility.vo.LoginVO;

@Path("/authenticate")
public class Authenticate {

	
	@InjectParam
	LoginService ls;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticate(LoginVO lvo){
		List<?> result = ls.authenticate(lvo.getUsername(), lvo.getPwd());
		
 		if(result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	
	@POST
	@Path("/getUser/{userid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)   
	public Response getUser(@PathParam("userid") String userid){
		String query = "select e.photo,b.role,a.gender,a.name,a.id,a.registerid,a.registerno,c.membership_plan_id,d.contacts,c.updatecount,b.lastlogin,a.device_token from personal a "
				+ "left outer join assigned_plan c 	on a.id=c.personalid left outer join membership_plan d on "
				+ "d.planid=c.membership_plan_id left outer join expetation e on a.id=e.personal_id,login b where a.id=b.personal_id and a.id='"+userid+"'  and b.status ='A'";
  		
			List<?> result =ls.getQuery(query);
			if(result.size()!=0){
			return Response.status(Status.OK).entity(result).build();	
		}else{
			return Response.status(Status.OK).entity(Status.BAD_REQUEST).build();
		}	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response passwordCheck(LoginVO loginVo) {
		try{ 

			String query = "update Login set password='"+loginVo.getPwd()+"'  where personal_id='"+loginVo.getPersonal_id()+"'";
 			int status =ls.getUpdate(query);
 			if(status!=0){
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
	@Path("/updateDeviceToken")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDeviceToken(LoginVO loginVo) {
		try{ 

			String query = "update Personal set device_token='"+loginVo.getDevice_token()+"'  where id='"+loginVo.getPersonal_id()+"'";
 			int status =ls.getUpdate(query);
 			if(status!=0){
				return Response.status(Status.OK).entity(Status.OK).build();	
			}else{
				return Response.status(Status.OK).entity(Status.BAD_REQUEST).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
