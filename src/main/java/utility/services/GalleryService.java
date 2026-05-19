package utility.services;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import utility.bean.GenericEntityService;
import utility.model.GalleryUpload;



@Service
@Scope("prototype")
@Named
public class GalleryService extends GenericEntityService<GalleryUpload, Integer>{
	@Override
	protected Class<GalleryUpload> entityClass()  {
 		return GalleryUpload.class;
	}

	/**
	 * 
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
