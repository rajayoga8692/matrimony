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

import utility.model.ContactAddress;
import utility.model.District;
import utility.services.CAddressService;
import utility.services.DistrictService;
import utility.vo.ContactAddressVO;
import utility.vo.DistrictVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/caddress")
public class ContactAddressAction {

	@InjectParam
	CAddressService caddressService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContactAddress(@PathParam("status") String status) {
		try{
			String query = "select * from contactaddress where status='"+status+"'" ;
			List<?> getDistrictList = caddressService.getQuery(query);
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
	public Response saveContactAddress(ContactAddressVO ContactAddressVO) { 
		try{
			ContactAddress ContactAddress = new ContactAddress();
			ContactAddress.setName(ContactAddressVO.getName());
			ContactAddress.setAddress(ContactAddressVO.getAddress());
			ContactAddress.setCity(ContactAddressVO.getCity());
			ContactAddress.setEmailid(ContactAddressVO.getEmailid());
			ContactAddress.setPhoneno(ContactAddressVO.getPhoneno());
			ContactAddress.setPincode(ContactAddressVO.getPincode());
			ContactAddress.setStatus("A");
			Integer contactaddressid = caddressService.save(ContactAddress);
			if(contactaddressid!=null){
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
	@Path("/updateContact")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDistrict(ContactAddressVO ContactAddressVO) {
		
 		try{
 
			String query = "update ContactAddress set name='"+ContactAddressVO.getName()+"',address='"+ContactAddressVO.getAddress()+"',city='"+ContactAddressVO.getCity()+"' ,"
					+ "phoneno='"+ContactAddressVO.getPhoneno()+"',pincode='"+ContactAddressVO.getPincode()+"' , emailid='"+ContactAddressVO.getEmailid()+"' where contactaddressid='"+ContactAddressVO.getContactaddressid()+"'";
 			int status =caddressService.getUpdate(query);

 			
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
	@Path("/removeContact/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeDistrict(@PathParam("status") String status,@PathParam("id") String id) {
		 
		try{

			String query = "update ContactAddress set status='"+status+"' where contactaddressid='"+id+"'";
 			int success =caddressService.getUpdate(query);
  			
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


