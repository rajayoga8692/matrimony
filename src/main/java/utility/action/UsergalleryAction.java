package utility.action;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import utility.helper.UserHelper;
import utility.services.GalleryService;
import utility.vo.GalleryVo;

import com.sun.jersey.api.core.InjectParam;


@Path("/galleryupload")
public class UsergalleryAction {
 
	@InjectParam
	UserHelper userhepler;
	
	@InjectParam
	GalleryVo galleryvo;
	
	@InjectParam
	FileUpload fileupload;
	
	@InjectParam
	GalleryService galleryservice;
	
	@POST
	@Path("/usergallery")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveGallery(GalleryVo galleryvo){
		try{
		int status=userhepler.saveGallery(galleryvo);
		if(status !=0)
			return Response.status(Status.OK).entity(Status.ACCEPTED).build();
		else
			return Response.status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET	
	@Path("/getGallery")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGallery() {    
		try{
			String query = "select a.galleryid,a.imagepath,b.name,b.registerno from gallery a ,personal b where a.personalid=b.id and a.status='A'" ;
			List<?> getList = galleryservice.getQuery(query);
			if(getList.size()!=0){
				return Response.status(Status.OK).entity(getList).build();	
			}else{
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
			}	
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@POST
	@Path("/deleteGallery/{status}/{id}")   
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGallery(@PathParam("status") String status,@PathParam("id") String id) {
 		try{
  
			String query = "update GalleryUpload set status='"+status+"' where galleryid='"+id+"'";
 			int success =galleryservice.getUpdate(query);
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
