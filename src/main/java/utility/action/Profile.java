package utility.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import utility.model.Liked;
import utility.model.UpdateRequest;
import utility.services.LoginService;
import utility.services.UpdateRequestService;
import utility.util.AppConstants;
import utility.util.SmsUtil;
import utility.vo.LikedVO;
import utility.vo.SearchVO;
import utility.vo.UpdateRequestVO;

 import com.sun.jersey.api.core.InjectParam;

@Path("/profile")
public class Profile<E> {

	@InjectParam
	LoginService ls;
	
	@InjectParam
	UpdateRequestService us;
	
	@GET
	@Path("pending/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticate(@PathParam("param") String param){
		
		String query="";
		if(param.equals("count")){
			query="SELECT count(id) as pending,(select count(id) from personal where status = 'A') as approved ,"
					+ "(select count(id) from personal where status = 'D') as deapproved FROM personal where status ='P' " ;
		}else if(param.equals("P")){
			query="select id,registerid,registerno,name,gender,dateofbirth,education from personal where status='"+param+"' order by id desc";
		}else if(param.equals("D")){
			query="select id,registerid,registerno,name,gender,dateofbirth,education from personal where status='"+param+"' order by id desc";
		}else if(param.equals("A")){
			query="select a.id,a.registerid,a.registerno,a.name,a.gender,a.dateofbirth,a.education from personal a,login b where a.id=b.personal_id and  b.role!='admin' and a.status='"+param+"' order by a.id desc";
		}     
		
		List<?> result = ls.getQuery(query);
		 
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	
	
	@GET
	@Path("newpending/{param}/{pageno}/{itemperpage}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPending(@PathParam("param") String param,@PathParam("pageno") String pageno,@PathParam("itemperpage") String itemperpage){
		
		String query="";
		 
		int offset = 0;
		int row_count = 0;
		if (pageno != null && !pageno.equalsIgnoreCase("")) {
			offset = (Integer.parseInt(pageno) - 1) * AppConstants.OFFER_PAGE_COUNT;
			row_count = AppConstants.OFFER_PAGE_COUNT;
		}
		
		
	     query="select (select count(a.id) from personal a,login b where a.id=b.personal_id and  b.role!='admin' and a.status='A') as total_count,"
	     		+ "a.id,a.registerid,a.registerno,a.name,a.gender,a.dateofbirth,a.education from personal a,login b "
	     		+ "where a.id=b.personal_id and  b.role!='admin' and a.status='"+param+"' order by a.id desc limit "+offset+","+row_count+"";
		 
		List<?> result = ls.getQuery(query);
		 
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Path("userSearch/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response userSearch(@PathParam("param") String param){
		
		String query="";
		  
	     query="select (select count(a.id) from personal a,login b where concat(a.registerno,a.name,a.gender,a.education) LIKE ('%"+param+"%') and a.id=b.personal_id and  b.role!='admin' and a.status='A') as total_count,"
	     		+ "a.id,a.registerid,a.registerno,a.name,a.gender,a.dateofbirth,a.education from personal a,login b "
	     		+ "where concat(a.registerno,a.name,a.gender,a.education) LIKE ('%"+param+"%') and  a.id=b.personal_id and  b.role!='admin' and a.status='A' order by a.id desc";
		 
		List<?> result = ls.getQuery(query);
		 
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	
	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticate(){
		
		String query="";
 			query="select (select count(galleryid) from gallery where status='A' ) as vipprofilecount ,(SELECT count(updaterequestid) FROM update_request where status='P') as updaterequestcount , "
 					+ "(SELECT count(planid) FROM membership_plan where status='A') as plancount,"
 					+ " (SELECT count(subcasteid) FROM subcaste where status='A') as subcastecount,"
 					+ "(SELECT count(districtid) FROM district where status='A') as districtcount; " ;
		 
		List<?> result = ls.getQuery(query);
		  
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Path("recentprofile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recentProfile(){
		
		String query="";
 			query="select a.* ,b.photo from personal a,expetation b where a.id = b.personal_id and a.status='A' order by a.id desc limit 0,8" ;
		 
		List<?> result = ls.getQuery(query);
		  
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	@PUT
	@Path("update/{param}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("param") String param,@PathParam("status") String status){
		String query="";
		if(status.equals("A")){
			query="update utility.model.Personal set status='A' where id='"+param+"'";
		}else if(status.equals("D")){
			query="update utility.model.Personal set status='D' where id='"+param+"'";
		}else if(status.equals("T")){
			query="delete utility.model.Personal where id='"+param+"'";
			
			query="delete utility.model.Personal where id='"+param+"'";
			String familyquery="delete utility.model.FamilyDetails where personal_id='"+param+"'";
			String horoscopequery="delete utility.model.Horoscope where personal_id='"+param+"'";
			String contactQuery="delete utility.model.Contact where personal_id='"+param+"'";
			String rSqureuery="delete utility.model.RSqure where personal_id='"+param+"'";
			String loginqeuery="delete utility.model.Login where personal_id='"+param+"'";

			
			int result1 = ls.getUpdate(familyquery);
			int result2 = ls.getUpdate(horoscopequery);
			int result3 = ls.getUpdate(contactQuery);
			int result4 = ls.getUpdate(rSqureuery);
			int result5 = ls.getUpdate(loginqeuery);
			
 			//familydetails
			//expetation
			//contactdetails
			//horoscopedetails
			//login 
			//rkattam
			try {
				
				String queryval="select a.photo from expetation a where  a.personal_id="+param+"";
				List<?> result = ls.getQuery(queryval);
				Map map =(Map)result.get(0);
				String photo = ""+map.get("photo");
				
				ResourceBundle bundle = ResourceBundle.getBundle("serversetup");
 				String dir = bundle.getString("serverpath");
 				 System.out.println(dir+photo);
	            File file = new File(dir+photo);
	            if (file.delete()) {
	                System.out.println(file.getName() + " is deleted!");
	            } else {
	                System.out.println("Sorry, unable to delete the file.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}else{
			query="update utility.model.Personal set status='A',registerno='"+status+"' where id='"+param+"'";
		}
			
 		int result = ls.getUpdate(query);
		
		if(result !=0 )
			return Response.ok().status(Status.OK).entity(Status.ACCEPTED).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	
	@PUT
	@Path("updateReg/{param}/{status}/{mobile}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateReg(@PathParam("param") String param,@PathParam("status") String status,@PathParam("mobile")String mobileno){
		String query="";
		if(status.equals("A")){
			query="update utility.model.Personal set status='A',approvedDate=now() where id='"+param+"'";
		}else if(status.equals("D")){
			query="update utility.model.Personal set status='D' where id='"+param+"'";
		}else {
			query="update utility.model.Personal set status='A',registerno='"+status+"' where id='"+param+"'";
			String queryval="select b.username,b.password from personal a, login b where  a.id='"+param+"' and b.personal_id=a.id";
			List<?> result = ls.getQuery(queryval);
			Map map =(Map)result.get(0);
			String username = ""+map.get("username");
			String password = ""+map.get("password");
			SmsUtil.sendOTP(username,mobileno,password,status);
		}
		int result = ls.getUpdate(query);
		
		if(result !=0 )
			return Response.ok().status(Status.OK).entity(Status.ACCEPTED).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}  
	
	@GET
	@Path("moreinfo/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response moreInfo(@PathParam("param") String param){   
		List<?> result = ls.getQuery("select a.jobid,a.workingcity,a.physical,d.patham,a.time,j.subcastename,k.castename,a.vagaira,a.id as p_id,a.registerid,a.registerno,a.name,a.gender,a.dateofbirth,"
				+ "a.heightcm,a.heightft,a.complexion,a.jobtype,a.subcaste_id,a.country,a.jobsector,"+
									"a.educationlevel,a.education_id,a.education,a.residence,a.occupation,a.workingplace,a.monthlyincome, a.marriedstatus,a.status,"+

									"    b.id as fd_id,b.fathername,b.fatheroccupation ,b.mothername ,b.motheroccupation ,b.nativeplace ,b.assets,"+
									"b.brother ,b.marriedbrothers ,b.sister ,b.fatherplace,b.motherplace,b.marriedsister ,b.kulatheivam, b.birthplace, "+
									
									"c.id as c_id, c.addressone,c.addresstwo,c.city,c.contactno,c.mobileno,"+

									"d.id as h_id,d.star,d.rasi,d.lagnam,d.dhishaiiruphu,d.year_month_date,d.document,"+

									"e.id as a_id,e.a1,e.a2 ,e.a3 ,e.a4 ,e.a5 ,e.a6 ,e.a7 ,e.a8 ,e.a9 ,e.a10,e.a11,e.a12 ,"+
									
									"f.id as r_id,f.r1 ,f.r2,f.r3 ,f.r4 ,f.r5,f.r6,f.r7 ,f.r8,f.r9 ,f.r10 ,f.r11 ,f.r12 ,"+

									"g.id as ex_id, g.expectation,g.specialcase ,g.emailid,g.registeredby,g.photo,"+

									"h.id as l_id,h.username,h.password,h.createddate,"+
									" y.jobname "+
									" from personal a"+
									 " LEFT OUTER JOIN familydetails b ON b.personal_id = a.id"+ 
									" LEFT OUTER JOIN contactdetails c ON c.personal_id = a.id"+
									" LEFT OUTER JOIN horoscopedetails d ON d.personal_id = a.id"+ 
									" LEFT OUTER JOIN amsamkattam e ON e.personal_id = a.id"+
									" LEFT OUTER JOIN joblist y ON y.jobid=a.jobid "+
									" LEFT OUTER JOIN rkattam f ON f.personal_id = a.id"+
									" LEFT OUTER JOIN expetation g ON g.personal_id = a.id"+ 
									" LEFT OUTER JOIN login h ON h.personal_id = a.id LEFT OUTER JOIN subcaste j on j.subcasteid=a.subcaste_id LEFT OUTER JOIN caste k on k.casteid=j.casteid where a.id='"+param+"';");
				
		if(result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	
	
	
	
	
	
	
	
	@POST
	@Path("searchbyid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchbyid(SearchVO searchvo){
		List<?> result  = null;
		try{
		String searchQuery="";   
		if(!searchvo.getAgefrom().isEmpty() && !searchvo.getAgeto().isEmpty())
			searchQuery+="and DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(STR_TO_DATE(a.dateofbirth, '%d/%m/%Y' ), '%Y') between '"+searchvo.getAgefrom()+"' and '"+searchvo.getAgeto()+"'";
		
	      		    
		if(searchvo.getGender() != null && !searchvo.getGender().isEmpty())
			searchQuery+=" and a.gender='"+searchvo.getGender()+"'";
		
		if(searchvo.getStar() != null && !searchvo.getStar().isEmpty())
			searchQuery+=" and d.star='"+searchvo.getStar()+"'";
						
		if( searchvo.getRasi() !=null && !searchvo.getRasi().isEmpty() )
			searchQuery+=" and d.rasi='"+searchvo.getRasi()+"'";
		
		if(searchvo.getSubcaste()!=null && !searchvo.getSubcaste().isEmpty())
			searchQuery+=" and j.subcasteid='"+searchvo.getSubcaste()+"'";
		
		if( searchvo.getEducation() !=null && !searchvo.getEducation().isEmpty())
			searchQuery+=" and a.education_id='"+searchvo.getEducation()+"'";
		
		if( searchvo.getMerital()!=null && !searchvo.getMerital().isEmpty())
			searchQuery+=" and a.marriedstatus='"+searchvo.getMerital()+"'";  
		
		if(searchvo.getWplace()!=null && !searchvo.getWplace().isEmpty()) 
			searchQuery+=" and a.workingcity='"+searchvo.getWplace()+"'";
		
		if(searchvo.getIncome1()!=null && !searchvo.getIncome1().isEmpty())
			searchQuery+=" and CAST(a.monthlyincome AS UNSIGNED)  between '"+searchvo.getIncome1()+"'";
		
		if(searchvo.getIncome2()!=null && !searchvo.getIncome2().isEmpty())
			searchQuery+=" and '"+searchvo.getIncome2()+"'";
	 
		
		if(searchvo.getHeight1()!=null && !searchvo.getHeight1().isEmpty())
			searchQuery+=" and a.heightcm between '"+searchvo.getHeight1()+"'";
 			
 
		if(searchvo.getHeight2()!=null && !searchvo.getHeight2().isEmpty())
			searchQuery+=" and'"+searchvo.getHeight2()+"'";
		
		
		if(searchvo.getJobtype()!=null && !searchvo.getJobtype().isEmpty()) 
			searchQuery+=" and a.jobtype='"+searchvo.getJobtype()+"'";
		
		if(searchvo.getCountry()!=null && !searchvo.getCountry().isEmpty()) 
			searchQuery+=" and a.country='"+searchvo.getCountry()+"'";
		
		if(searchvo.getJobsector()!=null && !searchvo.getJobsector().isEmpty()) 
			searchQuery+=" and a.jobsector='"+searchvo.getJobsector()+"'";
	 
			
		
		if(searchvo.getMemberid()!=null && !searchvo.getMemberid().isEmpty()) 
			searchQuery+=" and a.registerno='"+searchvo.getMemberid()+"'";	
		
			     
 		  result = ls.getQuery("select  (case when k.idassigned_plan IS NULL then 0 else 1 end ) as paidstatus ,a.id as p_id,a.registerid,a.religion,j.subcastename,a.registerno,a.name,a.gender,a.dateofbirth,a.heightcm,a.heightft,a.complexion,a.subcaste_id,"+
									"a.educationlevel,a.education_id,z.residencename as residence,a.education,a.occupation,a.workingplace,a.monthlyincome, a.marriedstatus,a.status,a.jobtype,"+

									"    b.id as fd_id,b.fathername,b.fatheroccupation ,b.mothername ,b.motheroccupation ,b.nativeplace ,b.assets,"+
									"b.brother ,b.marriedbrothers ,b.sister ,b.marriedsister ,b.kulatheivam,b.birthplace, "+
									
									"c.id as c_id, c.addressone,c.addresstwo,c.city,c.contactno,c.mobileno,"+   

									"d.id as h_id,d.star,d.rasi,d.lagnam,d.dhishaiiruphu,d.year_month_date,d.document,"+

									"e.id as a_id,e.a1,e.a2 ,e.a3 ,e.a4 ,e.a5 ,e.a6 ,e.a7 ,e.a8 ,e.a9 ,e.a10,e.a11,e.a12 ,"+
									
									"f.id as r_id,f.r1 ,f.r2,f.r3 ,f.r4 ,f.r5,f.r6,f.r7 ,f.r8,f.r9 ,f.r10 ,f.r11 ,f.r12 ,"+

									"g.id as ex_id, g.expectation,g.specialcase ,g.emailid,g.registeredby,g.photo,"+

									"h.id as l_id,h.username,h.password,h.createddate"+
									" from personal a"+ 
									" left outer join assigned_plan k on a.id=k.personalid " +
									 " LEFT OUTER JOIN familydetails b ON b.personal_id = a.id"+ 
									" LEFT OUTER JOIN contactdetails c ON c.personal_id = a.id"+
									" LEFT OUTER JOIN horoscopedetails d ON d.personal_id = a.id"+
									" LEFT OUTER JOIN amsamkattam e ON e.personal_id = a.id"+
									" LEFT OUTER JOIN rkattam f ON f.personal_id = a.id"+
									" LEFT OUTER JOIN expetation g ON g.personal_id = a.id"+  
									" LEFT OUTER JOIN residence z ON z.residenceid=a.residence "+    
									" LEFT OUTER JOIN login h ON h.personal_id = a.id ,subcaste j  where a.status='A' and j.subcasteid=a.subcaste_id  "+searchQuery+" order by a.id desc");
				
		if(result!=null && result.size() !=0 ) {
			return Response.ok().status(Status.OK).entity(result).build();
		} else {
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
		}

		} catch (Exception e){        
			e.printStackTrace();
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();

		}
	}
	
	@POST
	@Path("search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(SearchVO searchvo){
		List<?> result  = null;
		try{
		String searchQuery="";   
		if(!searchvo.getAgefrom().isEmpty() && !searchvo.getAgeto().isEmpty())
			searchQuery+="and DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(STR_TO_DATE(a.dateofbirth, '%d/%m/%Y' ), '%Y') between '"+searchvo.getAgefrom()+"' and '"+searchvo.getAgeto()+"'";
		
	      		    
		if(searchvo.getGender() != null && !searchvo.getGender().isEmpty())
			searchQuery+=" and a.gender='"+searchvo.getGender()+"'";
		
		if(searchvo.getStar() != null && !searchvo.getStar().isEmpty())
			searchQuery+=" and d.star='"+searchvo.getStar()+"'";
						
		if( searchvo.getRasi() !=null && !searchvo.getRasi().isEmpty() )
			searchQuery+=" and d.rasi='"+searchvo.getRasi()+"'";
		
		if(searchvo.getSubcaste()!=null && !searchvo.getSubcaste().isEmpty())
			searchQuery+=" and j.subcasteid='"+searchvo.getSubcaste()+"'";
		
		if( searchvo.getEducation() !=null && !searchvo.getEducation().isEmpty())
			searchQuery+=" and a.education_id='"+searchvo.getEducation()+"'";
		
		if( searchvo.getMerital()!=null && !searchvo.getMerital().isEmpty())
			searchQuery+=" and a.marriedstatus='"+searchvo.getMerital()+"'";  
		
		if(searchvo.getWplace()!=null && !searchvo.getWplace().isEmpty()) 
			searchQuery+=" and a.workingcity='"+searchvo.getWplace()+"'";
		
		if(searchvo.getIncome1()!=null && !searchvo.getIncome1().isEmpty())
			searchQuery+=" and CAST(a.monthlyincome AS UNSIGNED)  between '"+searchvo.getIncome1()+"'";
		
		if(searchvo.getIncome2()!=null && !searchvo.getIncome2().isEmpty())
			searchQuery+=" and '"+searchvo.getIncome2()+"'";
		  
 		
		if(searchvo.getHeight1()!=null && !searchvo.getHeight1().isEmpty())
			searchQuery+=" and a.heightcm between '"+searchvo.getHeight1()+"'";
 			
 
		if(searchvo.getHeight2()!=null && !searchvo.getHeight2().isEmpty())
			searchQuery+=" and'"+searchvo.getHeight2()+"'";
		
		
		if(searchvo.getJobtype()!=null && !searchvo.getJobtype().isEmpty()) 
			searchQuery+=" and a.jobtype='"+searchvo.getJobtype()+"'";
		
		if(searchvo.getCountry()!=null && !searchvo.getCountry().isEmpty()) 
			searchQuery+=" and a.country='"+searchvo.getCountry()+"'";
		
		if(searchvo.getJobsector()!=null && !searchvo.getJobsector().isEmpty()) 
			searchQuery+=" and a.jobsector='"+searchvo.getJobsector()+"'";
		 
		
		if(searchvo.getMemberid()!=null && !searchvo.getMemberid().isEmpty()) 
			searchQuery+=" and a.registerno='"+searchvo.getMemberid()+"'";	
		
		if(searchvo.getResidence()!=null && !searchvo.getResidence().isEmpty()) 
			searchQuery+=" and a.residence='"+searchvo.getResidence()+"'";	 
		
  		  result = ls.getQuery("select  (SELECT count(likedid) FROM liked where likedto=a.id and status='A') as likedcount,(case when k.idassigned_plan IS NULL then 0 else 1 end ) as paidstatus ,a.id as p_id,a.registerid,a.religion,j.subcastename,a.registerno,a.name,a.gender,a.dateofbirth,a.heightcm,a.heightft,a.complexion,a.subcaste_id,"+
									"a.educationlevel,z.residencename as residence,a.education_id,a.education,a.occupation,a.workingplace,a.monthlyincome, a.marriedstatus,a.status,a.jobtype,"+

									"    b.id as fd_id,b.fathername,b.fatheroccupation ,b.mothername ,b.motheroccupation ,b.nativeplace ,b.assets,"+
									"b.brother ,b.marriedbrothers ,b.sister ,b.marriedsister ,b.kulatheivam,b.birthplace, "+
									
									"c.id as c_id, c.addressone,c.addresstwo,c.city,c.contactno,c.mobileno,"+   

									"d.id as h_id,d.star,d.rasi,d.lagnam,d.dhishaiiruphu,d.year_month_date,d.document,"+

									"e.id as a_id,e.a1,e.a2 ,e.a3 ,e.a4 ,e.a5 ,e.a6 ,e.a7 ,e.a8 ,e.a9 ,e.a10,e.a11,e.a12 ,"+
									
									"f.id as r_id,f.r1 ,f.r2,f.r3 ,f.r4 ,f.r5,f.r6,f.r7 ,f.r8,f.r9 ,f.r10 ,f.r11 ,f.r12 ,"+

									"g.id as ex_id, g.expectation,g.specialcase ,g.emailid,g.registeredby,g.photo,"+

									"h.id as l_id,h.username,h.password,h.createddate,"+
									" y.jobname "+
									" from personal a"+ 
									" left outer join assigned_plan k on a.id=k.personalid " +
									 " LEFT OUTER JOIN familydetails b ON b.personal_id = a.id"+ 
									" LEFT OUTER JOIN contactdetails c ON c.personal_id = a.id"+
									" LEFT OUTER JOIN horoscopedetails d ON d.personal_id = a.id"+
									" LEFT OUTER JOIN amsamkattam e ON e.personal_id = a.id"+
									" LEFT OUTER JOIN rkattam f ON f.personal_id = a.id"+
									" LEFT OUTER JOIN expetation g ON g.personal_id = a.id"+  
									" LEFT OUTER JOIN joblist y ON y.jobid=a.jobid "+
									" LEFT OUTER JOIN residence z ON z.residenceid=a.residence "+
									" LEFT OUTER JOIN country l ON l.countryid=a.country "+
 									" LEFT OUTER JOIN login h ON h.personal_id = a.id ,subcaste j  where a.status='A' and j.subcasteid=a.subcaste_id  "+searchQuery+" order by a.id desc");
				
		if(result!=null && result.size() !=0 ) {
			return Response.ok().status(Status.OK).entity(result).build();
		} else {
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
		}

		} catch (Exception e){        
			e.printStackTrace();
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();

		}
	}
	
	
	@POST
	@Path("searchByUserRecords")  
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchByUserRecords(SearchVO searchvo){
		List<?> result  = null;
		try{
		String searchQuery="";   
		if(searchvo.getAgefrom()!=null && searchvo.getAgeto()!=null && !searchvo.getAgefrom().isEmpty() && !searchvo.getAgeto().isEmpty())
			searchQuery+="and DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(STR_TO_DATE(a.dateofbirth, '%d/%m/%Y' ), '%Y') between '"+searchvo.getAgefrom()+"' and '"+searchvo.getAgeto()+"'";
		
	      		    
		if(searchvo.getGender() != null && !searchvo.getGender().isEmpty())
			searchQuery+=" and a.gender='"+searchvo.getGender()+"'";
		
		if(searchvo.getStar() != null && !searchvo.getStar().isEmpty())
			searchQuery+=" and d.star='"+searchvo.getStar()+"'";
						
		if( searchvo.getRasi() !=null && !searchvo.getRasi().isEmpty() )
			searchQuery+=" and d.rasi='"+searchvo.getRasi()+"'";
		
		if(searchvo.getSubcaste()!=null && !searchvo.getSubcaste().isEmpty())
			searchQuery+=" and j.subcasteid='"+searchvo.getSubcaste()+"'";
		
		if( searchvo.getEducation() !=null && !searchvo.getEducation().isEmpty())
			searchQuery+=" and a.education_id='"+searchvo.getEducation()+"'";
		
		if( searchvo.getMerital()!=null && !searchvo.getMerital().isEmpty())
			searchQuery+=" and a.marriedstatus='"+searchvo.getMerital()+"'";  
		
		if(searchvo.getWplace()!=null && !searchvo.getWplace().isEmpty()) 
			searchQuery+=" and a.workingcity='"+searchvo.getWplace()+"'";
		
		if(searchvo.getIncome1()!=null && !searchvo.getIncome1().isEmpty())
			searchQuery+=" and CAST(a.monthlyincome AS UNSIGNED)  between '"+searchvo.getIncome1()+"'";
		
		if(searchvo.getIncome2()!=null && !searchvo.getIncome2().isEmpty())
			searchQuery+=" and '"+searchvo.getIncome2()+"'";
		  
 		
		if(searchvo.getHeight1()!=null && !searchvo.getHeight1().isEmpty())
			searchQuery+=" and a.heightcm between '"+searchvo.getHeight1()+"'";
 			
 
		if(searchvo.getHeight2()!=null && !searchvo.getHeight2().isEmpty())
			searchQuery+=" and'"+searchvo.getHeight2()+"'";
		
		
		if(searchvo.getJobtype()!=null && !searchvo.getJobtype().isEmpty()) 
			searchQuery+=" and a.jobtype='"+searchvo.getJobtype()+"'";
		
		if(searchvo.getCountry()!=null && !searchvo.getCountry().isEmpty()) 
			searchQuery+=" and a.country='"+searchvo.getCountry()+"'";
		
		if(searchvo.getJobsector()!=null && !searchvo.getJobsector().isEmpty()) 
			searchQuery+=" and a.jobsector='"+searchvo.getJobsector()+"'";
		 
 		if(searchvo.getMemberid()!=null && !searchvo.getMemberid().isEmpty()) 
			searchQuery+=" and a.registerno='"+searchvo.getMemberid()+"'";	     
 		
 		if(searchvo.getResidence()!=null && !searchvo.getResidence().isEmpty()) 
			searchQuery+=" and a.residence='"+searchvo.getResidence()+"'";	     
 		  
		
  		  result = ls.getQuery("select  (case when (SELECT likedid FROM liked where likedby="+searchvo.getPid()+" and likedto=h.id and status='A') IS NULL then 0 else 1 end) as likedstatus, (SELECT count(likedid) FROM liked where likedto=a.id) as likedcount,(case when k.idassigned_plan IS NULL then 0 else 1 end ) as paidstatus ,a.id as p_id,a.registerid,a.religion,j.subcastename,a.registerno,a.name,a.gender,a.dateofbirth,a.heightcm,a.heightft,a.complexion,a.subcaste_id,"+
									"a.educationlevel,z.residencename as residence,a.education_id,a.education,a.occupation,a.workingplace,a.monthlyincome, a.marriedstatus,a.status,a.jobtype,"+

									"    b.id as fd_id,b.fathername,b.fatheroccupation ,b.mothername ,b.motheroccupation ,b.nativeplace ,b.assets,"+
									"b.brother ,b.marriedbrothers ,b.sister ,b.marriedsister ,b.kulatheivam,b.birthplace, "+
									
									"c.id as c_id, c.addressone,c.addresstwo,c.city,c.contactno,c.mobileno,"+   

									"d.id as h_id,d.star,d.rasi,d.lagnam,d.dhishaiiruphu,d.year_month_date,d.document,"+

									"e.id as a_id,e.a1,e.a2 ,e.a3 ,e.a4 ,e.a5 ,e.a6 ,e.a7 ,e.a8 ,e.a9 ,e.a10,e.a11,e.a12 ,"+
									
									"f.id as r_id,f.r1 ,f.r2,f.r3 ,f.r4 ,f.r5,f.r6,f.r7 ,f.r8,f.r9 ,f.r10 ,f.r11 ,f.r12 ,"+

									"g.id as ex_id, g.expectation,g.specialcase ,g.emailid,g.registeredby,g.photo,"+

									"h.id as l_id,h.username,h.password,h.createddate,"+
									" y.jobname "+
									" from personal a"+ 
									" left outer join assigned_plan k on a.id=k.personalid " +
									 " LEFT OUTER JOIN familydetails b ON b.personal_id = a.id"+ 
									" LEFT OUTER JOIN contactdetails c ON c.personal_id = a.id"+
									" LEFT OUTER JOIN horoscopedetails d ON d.personal_id = a.id"+
									" LEFT OUTER JOIN amsamkattam e ON e.personal_id = a.id"+
									" LEFT OUTER JOIN rkattam f ON f.personal_id = a.id"+
									" LEFT OUTER JOIN expetation g ON g.personal_id = a.id"+  
									" LEFT OUTER JOIN joblist y ON y.jobid=a.jobid "+
									" LEFT OUTER JOIN residence z ON z.residenceid=a.residence "+
									" LEFT OUTER JOIN country l ON l.countryid=a.country "+
 									" LEFT OUTER JOIN login h ON h.personal_id = a.id ,subcaste j  where a.status='A' and j.subcasteid=a.subcaste_id  "+searchQuery+"  order by a.id desc ");
				
		if(result!=null && result.size() !=0 ) {
			return Response.ok().status(Status.OK).entity(result).build();
		} else {
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
		}

		} catch (Exception e){        
			e.printStackTrace();
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();

		}
	}
	
	@POST
	@Path("viewprofile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewprofile(SearchVO searchvo){
		  
		String searchQuery="";   
			if(searchvo.getMemberid()!=null && !searchvo.getMemberid().isEmpty())
			searchQuery+=" a.registerno='"+searchvo.getMemberid()+"'";	
			     
		List<?> result = ls.getQuery("select a.id as p_id,a.registerid,a.religion,j.subcastename,a.registerno,a.name,a.gender,a.vagaira,a.physical,a.dateofbirth,a.heightcm,a.heightft,a.complexion,a.subcaste_id,"+
									"a.educationlevel,a.education_id,a.education,a.country,a.residence,a.jobsector,a.occupation,a.workingplace,a.monthlyincome, a.marriedstatus,a.status,  "+

									"b.id as fd_id,b.fathername,b.fatheroccupation ,b.mothername ,b.motheroccupation ,b.nativeplace ,b.assets, "+
									"b.brother ,b.marriedbrothers ,b.sister ,b.fatherplace,b.motherplace,b.marriedsister ,b.kulatheivam,b.birthplace, "+
									   
									"c.id as c_id, c.addressone,c.addresstwo,c.city,c.contactno,c.mobileno,"+

									"d.id as h_id,d.star,d.rasi,d.lagnam,d.dhishaiiruphu,d.year_month_date,d.document,d.patham,"+

									"e.id as a_id,e.a1,e.a2 ,e.a3 ,e.a4 ,e.a5 ,e.a6 ,e.a7 ,e.a8 ,e.a9 ,e.a10,e.a11,e.a12 ,"+
									
									"f.id as r_id,f.r1 ,f.r2,f.r3 ,f.r4 ,f.r5,f.r6,f.r7 ,f.r8,f.r9 ,f.r10 ,f.r11 ,f.r12 ,"+

									"g.id as ex_id, g.expectation,g.specialcase ,g.emailid,g.registeredby,g.photo,"+

									"h.id as l_id,h.username,h.password,h.createddate,"+
									" y.jobname "+
									" from personal a"+ 
									 " LEFT OUTER JOIN familydetails b ON b.personal_id = a.id"+ 
									" LEFT OUTER JOIN contactdetails c ON c.personal_id = a.id"+
									" LEFT OUTER JOIN horoscopedetails d ON d.personal_id = a.id"+  
									" LEFT OUTER JOIN amsamkattam e ON e.personal_id = a.id"+
									" LEFT OUTER JOIN rkattam f ON f.personal_id = a.id"+
									" LEFT OUTER JOIN expetation g ON g.personal_id = a.id"+  
									" LEFT OUTER JOIN joblist y ON y.jobid=a.jobid "+
									" LEFT OUTER JOIN login h ON h.personal_id = a.id LEFT OUTER JOIN subcaste j on j.subcasteid=a.subcaste_id where "+searchQuery);
				
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build();
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	 
	
	@GET
	@Path("paymenthistory/{param}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response paymenthistory(@PathParam("param") int param){
		List<?> result = ls.getQuery("SELECT b.planname,b.amount,b.contacts FROM assigned_plan a,membership_plan b where a.membership_plan_id=b.planid and a.status='A' and a.personalid='"+param+"';");
				
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build(); 
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Path("paymenthistorylist") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response paymenthistorylist(){ 
		List<?> result = ls.getQuery("SELECT c.registerid,c.religion,c.registerno,c.name,c.gender,b.planname,b.amount,b.contacts FROM assigned_plan a,membership_plan b,personal c where c.id=a.personalid and "
				+ "a.membership_plan_id=b.planid and a.status='A' ;");
				
		if(result!=null && result.size() !=0 )
			return Response.ok().status(Status.OK).entity(result).build(); 
		
		return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
	}
	
	
	
	
	@POST
	@Path("saveRequest") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRequest(UpdateRequestVO updateRequestVO) {
		try {
			/*String query = "select * from  updateRequest where likedby='" + likedVO.getLikedby() + "' and likedto='"+likedVO.getLikedto()+"'";
			List<?> getLikedList = likedService.getQuery(query);
			if (getLikedList.size() == 0) {*/
			
 				
				UpdateRequest UpdateRequest = new UpdateRequest();
				UpdateRequest.setComments(updateRequestVO.getComments());
				UpdateRequest.setRequestby(updateRequestVO.getRequestby());
				UpdateRequest.setStatus("P");
				UpdateRequest.setRequestdate(new Date());
				Integer likedid = us.save(UpdateRequest);
				if (likedid != null) {
					return Response.status(Status.OK).entity(Status.OK).build();
				} else {
					return Response.status(Status.OK).entity(Status.NO_CONTENT).build();
				}
			/*} else {
				return Response.status(Status.OK).entity(Status.FOUND).build();
 			}*/
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
	
	@POST
	@Path("getRequest") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRequest() {
		try {
			List<?> result = us.getQuery("select a.* ,b.photo from personal a,expetation b,update_request c where c.requestby=a.id and a.id = b.personal_id and a.status='A' and c.status='P' ;");
					
			if(result!=null && result.size() !=0 )
				return Response.ok().status(Status.OK).entity(result).build(); 
			
			return Response.ok().status(Status.OK).entity(Status.NOT_ACCEPTABLE).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.OK).entity(Status.INTERNAL_SERVER_ERROR).build();
		}
 	}
}
