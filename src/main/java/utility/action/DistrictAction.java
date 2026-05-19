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

import utility.model.District;
import utility.services.DistrictService;
import utility.vo.DistrictVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/district")
public class DistrictAction {

	@InjectParam
	DistrictService districtService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuList(@PathParam("status") String status) {
		try{
			String query = "select * from district where status='"+status+"'" ;
			List<?> getDistrictList = districtService.getQuery(query);
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
 
	
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveDistrict(DistrictVO districtVO) {
		try{
			District district =  new District();
			district.setDistrictname(districtVO.getDistrictname());
			district.setStatus("A");
			Integer districtid = districtService.save(district);
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

	@PUT
	@Path("/updateDistrict/{districtname}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDistrict(@PathParam("districtname") String districtname,@PathParam("id") String id) {
		
		System.out.println("Nmae"+districtname);
		System.out.println("is"+id);
		try{

			String query = "update District set districtname='"+districtname+"' where districtid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int status =districtService.getUpdate(query);

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
	@Path("/removeDistrict/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeDistrict(@PathParam("status") String status,@PathParam("id") String id) {
		
		System.out.println("Nmae"+status);
		System.out.println("is"+id);
		try{

			String query = "update District set status='"+status+"' where districtid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int success =districtService.getUpdate(query);

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


