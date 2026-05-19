package utility.action;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.InjectParam;

import utility.model.SubCaste;
import utility.services.SubCasteService;
import utility.vo.SubCasteVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/subcaste")
public class SubCasteAction {

	@InjectParam
	SubCasteService subCasteService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuList(@PathParam("status") String status) {
		try{
			String query = "select * from subcaste where status='"+status+"'" ;
			List<?> getSubcastelist = subCasteService.getQuery(query);
			if(getSubcastelist .size()!=0){
				return Response.status(Status.OK).entity(getSubcastelist ).build();	
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
	public Response saveSubcaste(SubCasteVO subCasteVO) {
		try{
			SubCaste subCaste =  new SubCaste();
			subCaste.setSubcastename(subCasteVO.getSubcastename());
			subCaste.setCasteid(1);
			subCaste.setStatus("A");
			Integer subCasteid = subCasteService.save(subCaste);
			if(subCasteid!=null){
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
	@Path("/updateSubcaste/{subcastename}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSubcaste(@PathParam("subcastename") String subcastename,@PathParam("id") String id) {
		try{

			String query = "update SubCaste set subcastename='"+subcastename+"' where subcasteid='"+id+"'" ;
			int success =subCasteService.getUpdate(query);

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
	@Path("/removeSubcaste/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSubcaste(@PathParam("status") String status,@PathParam("id") String id) {
		try{

			String query = "update SubCaste set status='"+status+"' where subcasteid='"+id+"'" ;
			int success =subCasteService.getUpdate(query);

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


