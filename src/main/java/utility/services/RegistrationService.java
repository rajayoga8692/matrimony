/**
 * 
 */
package utility.services;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import utility.model.Personal;
import utility.bean.GenericEntityService;

/**
 * @author selvarajan_j
 *
 */
@Service
@Scope("prototype")
@Named
public class RegistrationService extends GenericEntityService<Personal, Integer>{
	@Override
	protected Class<Personal> entityClass() {
 		return Personal.class;
	}
}
