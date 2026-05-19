package utility.action;

import java.util.Date;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.RandomStringUtils;

import com.sun.jersey.api.core.InjectParam;

import net.sf.json.JSONException;
import utility.model.ASqure;
import utility.model.Contact;
import utility.model.FamilyDetails;
import utility.model.Horoscope;
import utility.model.Login;
import utility.model.Others;
import utility.model.Personal;
import utility.model.RSqure;
import utility.services.AqureService;
import utility.services.ContactServices;
import utility.services.FMDetailsServices;
import utility.services.HoroscopeService;
import utility.services.LoginService;
import utility.services.OtherService;
import utility.services.RSqurService;
import utility.services.RegistrationService;
import utility.util.Emailer;
import utility.vo.RegistrationVO;;

@Path("/registration")
public class Registration {

	
	ResourceBundle bundle = ResourceBundle.getBundle("serversetup");

	
	@InjectParam
	RegistrationService rs;
	@InjectParam
	FMDetailsServices fds;
	
	@InjectParam
	ContactServices cs;
	
	@InjectParam
	HoroscopeService hs;
	
	@InjectParam
	RSqurService rss;
	
	@InjectParam
	AqureService as;
	
	@InjectParam
	OtherService os;
	
	@InjectParam
	LoginService ls;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response userData(RegistrationVO regvo){
		 
		String regprefix =bundle.getString("regiternoprefix");

		
 		Personal personal = new Personal();  
 		personal.setName(regvo.getName());   
 		personal.setGender(regvo.getGender());    
		String dob[]=regvo.getDob().split(" ");
 		personal.setDateofbirth(dob[0]);
 		try{
		  personal.setTime(dob[1]+" "+dob[2]); 
 		}catch(ArrayIndexOutOfBoundsException e){
 			//personal.setTime("");
 		}
		personal.setReligion(regvo.getReligion());
		if(regvo.get_height()!=null && !regvo.get_height().isEmpty()) {
			String height[] = regvo.get_height().split("-");
			personal.setHeightcm(height[1].toString());
			personal.setHeightft(height[0].toString());
		}
		personal.setComplexion(regvo.getComplexion());
		personal.setSubcaste_id(Integer.parseInt(regvo.getSubcaste()));
		personal.setEducation_id(Integer.parseInt(regvo.getElevel()));
		personal.setEducationlevel(regvo.getElevel());

		personal.setEducation(regvo.getEducation());
		personal.setOccupation(regvo.getOccupation());
		personal.setWorkingplace(regvo.getWplace());
		personal.setMonthlyincome(regvo.getIncome());
		personal.setMarriedstatus(regvo.getMarital());
		personal.setStatus('P');
 		personal.setVagaira(regvo.getVagaira());   
 		personal.setPhysical(regvo.getPhysical());
 		personal.setJobtype(regvo.getJobtype());
 		personal.setJobsector(regvo.getJobsector());
 		personal.setCountry(Integer.parseInt(regvo.getCountry()));
 		personal.setRegisteredDate(new Date());
 		
 		if(regvo.getWorkingcity()!=null) {
 			personal.setWorkingcity(regvo.getWorkingcity());
 		}
 		
 		if(regvo.getJob()!=null) {
 			personal.setJobid(regvo.getJob());
 		}
 		 
		int ps_id = rs.save(personal);
		
 		String gen = "F";
		if (regvo.getGender().equals("ஆண்"))
			gen = "M";
			
		int result = ls.getUpdate("update utility.model.Personal set registerid='"+regprefix+"_"+gen+ps_id+"' where id='"+ps_id+"'");
		
		if(ps_id!=0){
		
			
					FamilyDetails fd = new FamilyDetails();
					
					fd.setFathername(regvo.getFname());
					fd.setFatheroccupation(regvo.getFoccupation());
					fd.setMothername(regvo.getMname());
					fd.setMotheroccupation(regvo.getMoccupation());
					fd.setNativeplace(regvo.getNplace());
					fd.setAssets(regvo.getAssets());
					fd.setBrother(Integer.parseInt(regvo.getBrothers()));
					fd.setMarriedbrothers(Integer.parseInt(regvo.getBromarried()));
					fd.setSister(Integer.parseInt(regvo.getSisters()));
					fd.setMarriedsister(Integer.parseInt(regvo.getSismarried()));
					fd.setKulatheivam(regvo.getKulateyivam());
					fd.setFatherplace(regvo.getFatherplace());
					fd.setMotherplace(regvo.getMotherplace());
					fd.setStatus('A');
					fd.setPersonal_id(ps_id);
					fd.setBirthplace(regvo.getBirthplace());
					
					int fd_id = fds.save(fd);
					
 					
					Contact cnt = new Contact();
					cnt.setAddressone(regvo.getAddressone());
					cnt.setAddresstwo(regvo.getAddresstwo());
					cnt.setCity(regvo.getCity());
					cnt.setContactno(regvo.getContactno());
					cnt.setMobileno(regvo.getMobile());
					cnt.setStatus('A');
					cnt.setPersonal_id(ps_id);
					int cs_id=cs.save(cnt);
 					
					Horoscope _hs = new Horoscope();
					_hs.setPersonal_id(ps_id);
					_hs.setStar(regvo.getStar());
					_hs.setRasi(regvo.getRasi());
					_hs.setLagnam(regvo.getLagnam());
					_hs.setDhishaiiruphu(regvo.getDi());
					_hs.setYear_month_date(regvo.getYear()+"/"+regvo.getMonth()+"/"+regvo.getDay());
					_hs.setDocument(regvo.getHscope());
					_hs.setPatham(regvo.getPatham());
					int hs_id = hs.save(_hs);
					
 					
					RSqure rs = new RSqure();
					rs.setR1(regvo.get_r1());
					rs.setR2(regvo.get_r2());
					rs.setR3(regvo.get_r3());
					rs.setR4(regvo.get_r4());
					rs.setR5(regvo.get_r5());
					rs.setR6(regvo.get_r6());
					rs.setR7(regvo.get_r7());
					rs.setR8(regvo.get_r8());
					rs.setR9(regvo.get_r9());
					rs.setR10(regvo.get_r10());
					rs.setR11(regvo.get_r11());
					rs.setR12(regvo.get_r12());
					rs.setPersonal_id(ps_id);
					int rss_id=rss.save(rs);
					
 					
					ASqure _as = new ASqure();
					_as.setA1(regvo.get_a1());
					_as.setA2(regvo.get_a2());
					_as.setA3(regvo.get_a3());
					_as.setA4(regvo.get_a4());
					_as.setA5(regvo.get_a5());
					_as.setA6(regvo.get_a6());
					_as.setA7(regvo.get_a7());
					_as.setA8(regvo.get_a8());
					_as.setA9(regvo.get_a9());
					_as.setA10(regvo.get_a10());
					_as.setA11(regvo.get_a11());
					_as.setA12(regvo.get_a12());
					_as.setPersonal_id(ps_id);
					
					int as_id=as.save(_as);
 					Others _os = new Others();
					_os.setExpectation(regvo.getExpetation());
					_os.setSpecialcase(regvo.getSpecialcase());
					_os.setEmailid(regvo.getEmailid());
					_os.setRegisteredby(regvo.getMatrimoneypf());
					_os.setStatus('A');
					_os.setPhoto(regvo.getPhoto());
					_os.setPersonal_id(ps_id);
					int os_id=os.save(_os);
 					
					Login lg= new Login();
					
					lg.setUsername(""+regprefix+"_"+gen+ps_id);
					String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$";
					String pwd = RandomStringUtils.random( 6, characters );

					lg.setPassword(pwd);
					lg.setCreateddate(new Date());
					lg.setRole("user");   
					lg.setPersonal_id(ps_id);
					lg.setStaus('A');
					int ls_id=ls.save(lg); 
					
 					if(ls_id!=0){
						if(regvo.getEmailid()!=null && !regvo.getEmailid().equalsIgnoreCase("")){
							Emailer.sendWelcomeEmail(regvo.getName(),regvo.getEmailid(),pwd,""+regprefix+"_"+gen+ps_id); 
						}
 					}
		}  
		
			
		
		return Response.ok().status(Status.OK).entity(Status.ACCEPTED).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	 public Response updateUserData(RegistrationVO regvo){
		try {
		String query="";
		
		
		String dob[]=regvo.getDob().split(" ");
		String time  ="";
		 try{
			    time =dob[1]+" "+dob[2];
	 		}catch(ArrayIndexOutOfBoundsException e){
	 			//personal.setTime("");
	 		}
		
		
		String gen = "F";
		if (regvo.getGender().equals("ஆண்"))
			gen = "M";
			     
 		
		
		query="update utility.model.ASqure set a1='"+regvo.get_a1()+"',a2='"+regvo.get_a2()+"' ,a3='"+regvo.get_a3()+"' ,a4='"+regvo.get_a4()+"' ,a5='"+regvo.get_a5()+"' " +
				",a6='"+regvo.get_a6()+"' ,a7='"+regvo.get_a7()+"' ,a8='"+regvo.get_a8()+"' ,a9='"+regvo.get_a9()+"' , a10='"+regvo.get_a10()+"',a11='"+regvo.get_a11()+"'," +
						"a12='"+regvo.get_a12()+"' where id ='"+regvo.getA_id()+"'";
		
		int result = ls.getUpdate(query);
		 
		
			query="update utility.model.RSqure set r1='"+regvo.get_r1()+"',r2='"+regvo.get_r2()+"' ,r3='"+regvo.get_r3()+"' ,r4='"+regvo.get_r4()+"' ,r5='"+regvo.get_r5()+"' " +
				",r6='"+regvo.get_r6()+"' ,r7='"+regvo.get_r7()+"' ,r8='"+regvo.get_r8()+"' ,r9='"+regvo.get_r9()+"' , r10='"+regvo.get_r10()+"',r11='"+regvo.get_r11()+"'," +
						"r12='"+regvo.get_r12()+"' where id ='"+regvo.getR_id()+"'";
		
			  result = ls.getUpdate(query);
		
		
		if(regvo.get_height()!=null && !regvo.get_height().isEmpty()) {
			String height[] = regvo.get_height().split("-");
			query="update utility.model.Personal set  registerno='"+regvo.getRegno()+"' ,name='"+regvo.getName()+"'," +
					"gender = '"+regvo.getGender()+"',dateofbirth='"+dob[0]+"',heightcm='"+height[1]+"',heightft='"+height[0]+"'," + 
					"complexion='"+regvo.getComplexion()+"',subcaste_id='"+regvo.getSubcaste()+"',education_id='"+regvo.getElevel()+"',educationlevel='"+regvo.getElevel()+"'," +
					"education='"+regvo.getEducation()+"',occupation='"+regvo.getOccupation()+"',workingplace='"+regvo.getWplace()+"', workingcity="+regvo.getWorkingcity()+", " +
					"monthlyincome='"+regvo.getIncome()+"',vagaira='"+regvo.getVagaira()+"' ,marriedstatus='"+regvo.getMarital()+"',status='A',time='"+dob[1]+" "+dob[2]+"' ,physical='"+regvo.getPhysical()+"', "
							+ "country="+regvo.getCountry()+" ,jobtype='"+regvo.getJobtype()+"',jobsector='"+regvo.getJobsector()+"',jobid='"+regvo.getJob()+"' ,residence='"+regvo.getResidence()+"'  where id ='"+regvo.getP_id()+"'";
		} else {
			query="update utility.model.Personal set  registerno='"+regvo.getRegno()+"' ,name='"+regvo.getName()+"'," +
					"gender = '"+regvo.getGender()+"',dateofbirth='"+dob[0]+"'," +
					"complexion='"+regvo.getComplexion()+"',subcaste_id='"+regvo.getSubcaste()+"',education_id='"+regvo.getElevel()+"',educationlevel='"+regvo.getElevel()+"'," +
					"education='"+regvo.getEducation()+"',occupation='"+regvo.getOccupation()+"',workingplace='"+regvo.getWplace()+"', workingcity="+regvo.getWorkingcity()+", " +
					"monthlyincome='"+regvo.getIncome()+"',vagaira='"+regvo.getVagaira()+"' ,marriedstatus='"+regvo.getMarital()+"',status='A',time='"+time+"' ,physical='"+regvo.getPhysical()+"' ,"
							+ " country="+regvo.getCountry()+" ,jobtype='"+regvo.getJobtype()+"',jobsector='"+regvo.getJobsector()+"' ,jobid='"+regvo.getJob()+"',residence='"+regvo.getResidence()+"'  where id ='"+regvo.getP_id()+"'";
		}
		
			
			  result = ls.getUpdate(query);       
			
					query="update utility.model.FamilyDetails set fathername='"+regvo.getFname()+"',fatheroccupation='"+regvo.getFoccupation()+"'," +
							"mothername='"+regvo.getMname()+"',motheroccupation='"+regvo.getMoccupation()+"',nativeplace='"+regvo.getNplace()+"'," +
						"assets='"+regvo.getAssets()+"',brother='"+regvo.getBrothers()+"',fatherplace='"+regvo.getFatherplace()+"',motherplace='"+regvo.getMotherplace()+"',marriedbrothers='"+regvo.getBromarried()+"'," +
						"sister='"+regvo.getSisters()+"',marriedsister='"+regvo.getSismarried()+"',kulatheivam='"+regvo.getKulateyivam()+"',birthplace='"+regvo.getBirthplace()+"' where id ='"+regvo.getFd_id()+"'";
					
			 result = ls.getUpdate(query);
			 
			 	query="update utility.model.Contact set addressone='"+regvo.getAddressone()+"',addresstwo='"+regvo.getAddresstwo()+"',city='"+regvo.getCity()+"'," +
			 			"contactno='"+regvo.getContactno()+"',mobileno='"+regvo.getMobile()+"' where id ='"+regvo.getC_id()+"'";
					
			 	result = ls.getUpdate(query);
			 	
			 	if(regvo.getHscope() != null){
				 	query="update utility.model.Horoscope set star='"+regvo.getStar()+"',rasi='"+regvo.getRasi()+"',lagnam='"+regvo.getLagnam()+"',dhishaiiruphu='"+regvo.getDi()+"'," +
							"year_month_date='"+regvo.getYear()+"/"+regvo.getMonth()+"/"+regvo.getDay()+"',document='"+regvo.getHscope()+"',patham='"+regvo.getPatham()+"' where id ='"+regvo.getH_id()+"'";
			 	}else{
			 		query="update utility.model.Horoscope set star='"+regvo.getStar()+"',rasi='"+regvo.getRasi()+"',lagnam='"+regvo.getLagnam()+"',dhishaiiruphu='"+regvo.getDi()+"'," +
							"year_month_date='"+regvo.getYear()+"/"+regvo.getMonth()+"/"+regvo.getDay()+"',patham='"+regvo.getPatham()+"' where id ='"+regvo.getH_id()+"'";
			 	}
				result = ls.getUpdate(query);
			 	       
				 
				
				

				if(regvo.getPhoto()!= null){
				 	query="update utility.model.Others set  expectation='"+regvo.getExpetation()+"',specialcase='"+regvo.getSpecialcase()+"' ,emailid='"+regvo.getEmailid()+"'" +
				 			",registeredby='"+regvo.getMatrimoneypf()+"',photo='"+regvo.getPhoto()+"' where id ='"+regvo.getEx_id()+"'";
				}else{
			 		query="update utility.model.Others set  expectation='"+regvo.getExpetation()+"',specialcase='"+regvo.getSpecialcase()+"' ,emailid='"+regvo.getEmailid()+"'" +
				 			",registeredby='"+regvo.getMatrimoneypf()+"' where id ='"+regvo.getEx_id()+"'";
				}
				result = ls.getUpdate(query);
				
				query="update utility.model.Login set username='"+regvo.getUsername()+"',password='"+regvo.getPassword()+"',createddate=CURRENT_TIMESTAMP() where id ='"+regvo.getL_id()+"'";
				
				result = ls.getUpdate(query);
				
				if(regvo.getUpdaterequest()==1){
					query="update utility.model.UpdateRequest set status='A' where requestby='"+regvo.getP_id()+"'";
				}
				result = ls.getUpdate(query);			 
		} catch (Exception e){
			e.printStackTrace();  
		}
		return Response.ok().status(Status.OK).entity(Status.ACCEPTED).build();
	}
	
	
	@POST
	@Path("/updateLastlogin/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateLastlogin(@PathParam("id") String id) {
 		try{

			String 	query="update utility.model.Login set lastlogin=CURRENT_TIMESTAMP() where personal_id ='"+id+"'";
  			int success =ls.getUpdate(query);
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



