package utility.action;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.InjectParam;

import utility.model.Workplace;
import utility.services.WorkplaceService;
import utility.vo.WorkplaceVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/workplace")
public class WorkingPlaceAction {

	@InjectParam
	WorkplaceService workplaceService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuList(@PathParam("status") String status) {
		try{
			String query = "select * from workplace where status='"+status+"'" ;
			List<?> getWorkplaceList = workplaceService.getQuery(query);
			if(getWorkplaceList.size()!=0){
				return Response.status(Status.OK).entity(getWorkplaceList).build();	
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
	public Response saveDistrict(WorkplaceVO workplaceVO) {
		try{
			Workplace workplace =  new Workplace();
			workplace.setWorkplacename(workplaceVO.getWorkplacename());
			workplace.setStatus("A");
			Integer workplaceid = workplaceService.save(workplace);
			if(workplaceid!=null){
				return Response.status(Status.OK).entity(Status.OK).build();	
			}else{
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
			}	
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PUT
	@Path("/updateWorkplace/{workplacename}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateWorkplace(@PathParam("workplacename") String workplacename,@PathParam("id") String id) {
		
		System.out.println("Nmae"+workplacename);
		System.out.println("is"+id);
		try{

			String query = "update Workplace set workplacename='"+workplacename+"' where workplaceid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int status =workplaceService.getUpdate(query);

			System.out.println("AAAAA"+status);
			
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
	
	
	@PUT
	@Path("/removeWorkplace/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeWorkplace(@PathParam("status") String status,@PathParam("id") String id) {
		
		System.out.println("Nmae"+status);
		System.out.println("is"+id);
		try{

			String query = "update Workplace set status='"+status+"' where workplaceid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int success =workplaceService.getUpdate(query);

			System.out.println("AAAAA"+success);
			
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
	
	
	
	
	

}


