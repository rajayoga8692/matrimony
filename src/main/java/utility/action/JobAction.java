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


import utility.model.Joblist;
import utility.services.JobService;
import utility.vo.JobVO;



@Path("/job")
public class JobAction {

	@InjectParam
	JobService jobService; 

	@GET	
	@Path("/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuList(@PathParam("status") String status) {
		try{
			String query = "select * from joblist where status='"+status+"'" ;
			List<?> getJobList = jobService.getQuery(query);
			if(getJobList.size()!=0){
				return Response.status(Status.OK).entity(getJobList).build();	
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
	public Response saveJob(JobVO jobVO) {
		try{
			Joblist job =  new Joblist();
			job.setJobname(jobVO.getJobname());
			job.setStatus("A");
			Integer jobid = jobService.save(job);
			if(jobid!=null){
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
	@Path("/updateJob/{jobname}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateJob(@PathParam("jobname") String jobname,@PathParam("id") String id) {
		
		System.out.println("Name"+jobname);
		System.out.println("is"+id);
		try{

			String query = "update Joblist set jobname='"+jobname+"' where jobid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int status =jobService.getUpdate(query);

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
	@Path("/removeJob/{status}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeJob(@PathParam("status") String status,@PathParam("id") String id) {
		
		System.out.println("Nmae"+status);
		System.out.println("is"+id);
		try{

			String query = "update Joblist set status='"+status+"' where jobid='"+id+"'";
			System.out.println("AAAAA"+query);
			
			int success =jobService.getUpdate(query);

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





