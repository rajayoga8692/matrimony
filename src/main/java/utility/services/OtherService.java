package utility.services;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.Others;

import utility.bean.GenericEntityService;

@Service
@Scope("prototype")
@Named
public class OtherService extends GenericEntityService<Others, Integer>{
	@Override
	protected Class<Others> entityClass() {
 		return Others.class;
	}
}
