package utility.services;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.FamilyDetails;
import utility.bean.GenericEntityService;

@Service
@Scope("prototype")
@Named
public class FMDetailsServices extends GenericEntityService<FamilyDetails, Integer>{
	@Override
	protected Class<FamilyDetails> entityClass() {
 		return FamilyDetails.class;
	}
}
