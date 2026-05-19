package utility.services;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.ASqure;

import utility.bean.GenericEntityService;

@Service
@Scope("prototype")
@Named
public class AqureService extends GenericEntityService<ASqure, Integer>{
	@Override
	protected Class<ASqure> entityClass() {
 		return ASqure.class;
	}
}
