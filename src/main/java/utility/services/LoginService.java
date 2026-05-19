package utility.services;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.Login;

import utility.bean.GenericEntityService;

@Service
@Scope("prototype")
@Named
public class LoginService extends GenericEntityService<Login, Integer>{
	@Override
	protected Class<Login> entityClass() {
 		return Login.class;
	}
	
	/**
	 * 
	 * @param questionid
	 * @return List of Student answer status
	 */
	public List <?> authenticate(String username,String pwd){
		List<?> result = null;  
		try {
			/*result=getCurrentSession().createSQLQuery("select b.role,a.name,a.id,a.registerid from personal a,login b where a.id=b.personal_id and b.username='"+username+"' and b.password='"+pwd+"' and b.status ='A'")
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();*/     
			
			result=getCurrentSession().createSQLQuery("select DATE_FORMAT(c.expireddate,'%Y-%m-%d') as expireddate ,e.photo,b.role,a.name,a.gender,a.id,a.registerid,a.registerno,c.membership_plan_id,d.contacts,c.updatecount,b.lastlogin,a.device_token from personal a "
					+ "left outer join assigned_plan c 	on a.id=c.personalid left outer join membership_plan d on "
					+ "d.planid=c.membership_plan_id left outer join expetation e on a.id=e.personal_id,login b where a.id=b.personal_id and b.username='"+username+"' and b.password='"+pwd+"' and a.status ='A' ")
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();   
		   }catch (Exception e) {
				
		   }
		   return result; 
	}
	
	/**
	 * 
	 * @param questionid
	 * @return List of Student answer status
	 */
	public List <?> getQuery(String query){
		List<?> result = null;
		try {
			result=getCurrentSession().createSQLQuery(query)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
			}catch (Exception e) {
				System.out.println("Print ERROR "+e);
			}
			return result;
	}
	/**
	 *    
	 * @param questionid
	 * @return List of Student answer status
	 */
	public int getUpdate(String query){
		int status =0;
		try {
			status = getCurrentSession().createQuery(query).executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return status;
	}
	
	
}
