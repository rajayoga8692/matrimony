package utility.action;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.api.core.InjectParam;

import utility.services.LoginService;

@Path("/dashboard")
public class DashboardAction {
	

	@InjectParam
	LoginService ls; 	

	@POST
	@Path("totalcount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recentProfile()
	{  
		
		String query="";  
			query="SELECT count(id) as totalcount,(SELECT count(id) FROM personal where status='A' and gender='ஆண்') as malecount ,(SELECT count(id) FROM personal where status='A' and gender='பெண் ') as femalecount  FROM personal where status='A';" ;
		   
		List<?> result = ls.getQuery(query);
		  
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
}