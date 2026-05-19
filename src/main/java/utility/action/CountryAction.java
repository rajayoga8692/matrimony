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

import utility.model.Country;
import utility.model.District;
import utility.services.CountryService;
import utility.services.DistrictService;
import utility.vo.CountryVo;
import utility.vo.DistrictVO;



	@Path("/country")
	public class CountryAction {

		@InjectParam
		CountryService countryService; 

		@GET	
		@Path("/{status}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getMenuList(@PathParam("status") String status) {
			try{
				String query = "select * from country where status='"+status+"'" ;
				List<?> getCountryList = countryService.getQuery(query);
				if(getCountryList.size()!=0){
					return Response.status(Status.OK).entity(getCountryList).build();	
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
		public Response saveCountry(CountryVo countryVo) {
			try{
				Country country =  new Country();
				country.setCountryname(countryVo.getCountryname());
				country.setStatus("A");
				Integer countryid = countryService.save(country);
				if(countryid!=null){
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
		@Path("/updateCountry/{countryname}/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateCountry(@PathParam("countryname") String countryname,@PathParam("id") String id) {
			
			try{

				String query = "update Country set countryname='"+countryname+"' where countryid='"+id+"'";
				
				int status =countryService.getUpdate(query);

				
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
		@Path("/removeCountry/{status}/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response removeCountry(@PathParam("status") String status,@PathParam("id") String id) {
			
			try{

				String query = "update Country set status='"+status+"' where countryid='"+id+"'";
				
				int success =countryService.getUpdate(query);
				
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



