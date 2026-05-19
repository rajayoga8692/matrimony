package utility.services;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.bean.GenericEntityService;
import utility.model.RSqure;



@Service
@Scope("prototype")
@Named
public class RSqurService extends GenericEntityService<RSqure, Integer>{
	@Override
	protected Class<RSqure> entityClass() {
 		return RSqure.class;
	}
}
