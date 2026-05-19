package utility.services;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.Contact;

import utility.bean.GenericEntityService;

@Service
@Scope("prototype")
@Named
public class ContactServices extends GenericEntityService<Contact, Integer>{
	@Override
	protected Class<Contact> entityClass() {
 		return Contact.class;
	}

}
