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

import utility.model.Residence;
import utility.services.ResidenceService;
import utility.vo.ResidenceVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/residence")
public class ResidenceAction {

	@InjectParam
 ResidenceService residenceService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuList(@PathParam("status") String status) {
		try{
			String query = "select * from residence where status='"+status+"'" ;
			List<?> getResidenceList =residenceService.getQuery(query);
			if(getResidenceList.size()!=0){
				return Response.status(Status.OK).entity(getResidenceList).build();	
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
	public Response saveResidence(ResidenceVO residenceVO) {
		try{
			Residence residence =  new Residence();
			residence.setResidencename(residenceVO.getResidencename());
			residence.setStatus("A");
			Integer residenceid = residenceService.save(residence);
			if(residenceid!=null){
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
	@Path("/updateResidence/{residencename}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateResidence(@PathParam("residencename") String residencename,@PathParam("id") String id) {
		
		System.out.println("Nmae"+residencename);
		System.out.println("is"+id);
		try{

			String query = "update Residence set residencename='"+residencename+"' where residenceid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int status =residenceService.getUpdate(query);

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
	@Path("/removeResidence/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeResidence(@PathParam("status") String status,@PathParam("id") String id) {
		
		System.out.println("Nmae"+status);
		System.out.println("is"+id);
		try{

			String query = "update Residence set status='"+status+"' where residenceid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int success =residenceService.getUpdate(query);

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


