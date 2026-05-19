package utility.action;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.InjectParam;

import utility.model.SuccesStory;
import utility.services.SuccesStoryService;
import utility.vo.BankDetailsVO;
import utility.vo.SuccesStoryVO;


/**
 * User: raja
 * Date: 01/01/2016
 */
@Path("/succestory")
public class SuccessStoryAction {

	@InjectParam
	SuccesStoryService succesStoryService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBankDetails(@PathParam("status") String status) {
		try{
			String query = "select * from successtory where status='"+status+"'" ;
			List<?> getDistrictList = succesStoryService.getQuery(query);
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
	public Response saveBankDetails(SuccesStoryVO SuccesStoryVO) {
		try{
			SuccesStory succesStory =  new SuccesStory();
			succesStory.setDescription(SuccesStoryVO.getDescription());
			succesStory.setImagepath(SuccesStoryVO.getImagepath());  
			succesStory.setName(SuccesStoryVO.getName());
			succesStory.setStatus("A");
			Integer succes_id = succesStoryService.save(succesStory);
			if(succes_id!=null){
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
 			
			int status =succesStoryService.getUpdate(query);
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
	@Path("/removeSuccesstory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeDistrict(SuccesStoryVO SuccesStoryVO) {
 		try{

			String query = "update SuccesStory set status='"+SuccesStoryVO.getStatus()+"' where successtoryid='"+SuccesStoryVO.getSuccesstoryid()+"'";
 			int success =succesStoryService.getUpdate(query);
 			if(success!=0){
 				
 				try {
  				/*	String queryval="select a.photo from expetation a where  a.personal_id="+param+"";
 					List<?> result = ls.getQuery(queryval);
 					Map map =(Map)result.get(0);
 					String photo = ""+map.get("photo");
 					*/
 					ResourceBundle bundle = ResourceBundle.getBundle("serversetup");
 	 				String dir = bundle.getString("serverpath");
  		            File file = new File(dir+SuccesStoryVO.getImagepath());
 		            if (file.delete()) {
 		                System.out.println(file.getName() + " is deleted!");
 		            } else {
 		                System.out.println("Sorry, unable to delete the file.");
 		            }
 		        } catch (Exception e) {
 		            e.printStackTrace();
 		        }
 				
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


