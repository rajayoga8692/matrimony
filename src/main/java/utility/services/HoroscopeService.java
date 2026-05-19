package utility.services;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.model.Horoscope;

import utility.bean.GenericEntityService;

@Service
@Scope("prototype")
@Named
public class HoroscopeService extends GenericEntityService<Horoscope, Integer>{
	@Override
	protected Class<Horoscope> entityClass() {
 		return Horoscope.class;
	}
}
