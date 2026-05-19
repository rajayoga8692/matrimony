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

import utility.model.BankDetails;
import utility.model.District;
import utility.services.BankDetailsService;
import utility.services.DistrictService;
import utility.vo.BankDetailsVO;
import utility.vo.DistrictVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/bankdetails")
public class BankDetailsAction {

	@InjectParam
	BankDetailsService bankDetailsService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBankDetails(@PathParam("status") String status) {
		try{
			String query = "select * from bankdetails where status='"+status+"'" ;
			List<?> getDistrictList = bankDetailsService.getQuery(query);
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
	public Response saveBankDetails(BankDetailsVO bankDetailsVO) {
		try{
			BankDetails bankDetails =  new BankDetails();
 			bankDetails.setAccountnumber(bankDetailsVO.getAccountnumber());
			bankDetails.setBranchcode(bankDetailsVO.getBranchcode());
			bankDetails.setBranchname(bankDetailsVO.getBranchname());
			bankDetails.setHoldername(bankDetailsVO.getHoldername());
			bankDetails.setIfsccode(bankDetailsVO.getIfsccode());
			bankDetails.setImagepath(bankDetailsVO.getImagepath());  
			bankDetails.setStatus("A");
			Integer districtid = bankDetailsService.save(bankDetails);
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
	@Path("/updateBankDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBankDetails(BankDetailsVO bankDetailsVO) {
		try{

			String query = "update BankDetails set accountnumber='"+bankDetailsVO.getAccountnumber()+"',holdername='"+bankDetailsVO.getHoldername()+"',branchname='"+bankDetailsVO.getBranchname()+"',"
					+ "branchcode='"+bankDetailsVO.getBranchcode()+"',ifsccode='"+bankDetailsVO.getIfsccode()+"',imagepath='"+bankDetailsVO.getImagepath()+"',bankname='"+bankDetailsVO.getBankname()+"'  where bankdetailsid='"+bankDetailsVO.getBankdetailsid()+"'";
 			
			int status =bankDetailsService.getUpdate(query);
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
	@Path("/removeBankDetails/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeDistrict(@PathParam("status") String status,@PathParam("id") String id) {
 		try{

			String query = "update BankDetails set status='"+status+"' where bankdetailsid='"+id+"'";
 			int success =bankDetailsService.getUpdate(query);
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


