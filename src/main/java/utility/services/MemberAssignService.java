/**
 * 
 */
package utility.services;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.AssignedPlan;
import utility.model.District;
import utility.model.MembershipPlan;
import utility.bean.GenericEntityService;

/**
 * @author Raja
 *
 */
@Service
@Scope("prototype")
@Named
public class MemberAssignService extends GenericEntityService<AssignedPlan, Integer>{
	@Override
	protected Class<AssignedPlan> entityClass() {
 		return AssignedPlan.class;
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
				
			}
			return status;
	}
	
}
