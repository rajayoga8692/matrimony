package utility.action;

import java.util.Date;
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

import utility.model.Country;
import utility.model.Liked;
import utility.services.CountryService;
import utility.services.LikedService;
import utility.vo.CountryVo;
import utility.vo.LikedVO;

@Path("/like")
public class LikedAction {

	@InjectParam
	LikedService likedService;

	@GET
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuList(@PathParam("status") String status) {
		try {
			String query = "select * from liked where status='" + status + "'";
			List<?> getCountryList = likedService.getQuery(query);
			if (getCountryList.size() != 0) {
				return Response.status(Status.OK).entity(getCountryList).build();
			} else {
				return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveLiked(LikedVO likedVO) {
		try {
			String query = "select * from  liked where likedby='" + likedVO.getLikedby() + "' and likedto='"+likedVO.getLikedto()+"'";
			List<?> getLikedList = likedService.getQuery(query);
			if (getLikedList.size() == 0) {
			
				Liked liked = new Liked();
				liked.setLikedby(likedVO.getLikedby());
	 			liked.setLikedto(likedVO.getLikedto());
				liked.setLikeddate(new Date());  
	 			liked.setStatus("A");  
				Integer likedid = likedService.save(liked);
				if (likedid != null) {
					return Response.status(Status.OK).entity(Status.OK).build();
				} else {
					return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
				}
			} else {
				return Response.status(Status.OK).entity(Status.FOUND).build();
 			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@GET	
	@Path("/history/{pid}")   
	@Produces(MediaType.APPLICATION_JSON)  
	public Response likedHistory(@PathParam("pid") String pid) {
		try{
			String query = "select c.photo,DATE_FORMAT(a.likeddate, '%d/%m/%Y') as vieweddate ,b.dateofbirth,f.nativeplace,b.name,b.registerid,b.heightft,b.education,b.registerno,b.religion,b.marriedstatus,"
					+ "b.gender,b.complexion from liked a,personal b,expetation c,familydetails f where a.likedto=b.id and f.personal_id=b.id and  c.personal_id=b.id  and a.likedby='"+pid+"'" ;
			List<?> getDistrictList = likedService.getQuery(query);
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
	@Path("/likedto/{pid}")   
	@Produces(MediaType.APPLICATION_JSON)  
	public Response likedto(@PathParam("pid") String pid) {
		try{
			String query = "select c.photo,DATE_FORMAT(a.likeddate, '%d/%m/%Y') as vieweddate ,b.dateofbirth,f.nativeplace,b.name,b.registerid,b.heightft,b.education,b.registerno,b.religion,b.marriedstatus,"
					+ "b.gender,b.complexion from liked a,personal b,expetation c,familydetails f where a.likedby=b.id and f.personal_id=b.id and  c.personal_id=b.id  and a.likedto='"+pid+"'" ;
			List<?> getDistrictList = likedService.getQuery(query);
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

}
