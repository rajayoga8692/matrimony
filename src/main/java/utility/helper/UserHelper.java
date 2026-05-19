/**
 * 
 */
package utility.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
import com.sun.jersey.api.core.InjectParam;

import utility.action.FileUpload;
import utility.model.GalleryUpload;
import utility.model.Personal;
import utility.services.GalleryService;
import utility.vo.GalleryVo;

/**
 * @author selvarajan_j
 *
 */
public class UserHelper {

	/*@InjectParam
	UserService userService;
	int status=0;
	
	public int saveUser(UserVO userVo){
		status=0;
			User user=new User();
			user.setEmail(userVo.getEmail());
			user.setFirstname(userVo.getFirstname());
			user.setLastname(userVo.getLastname());
			user.setPwd(userVo.getPwd());
			user.setConfirmpwd(userVo.getConfirmpwd());
			user.setAvatar(userVo.getAvatar());
			user.setStatus('A');
			status=userService.save(user);
		return status;
	}
	
	public List<?> authenticate(String email,String password){
		
		List data= new ArrayList();
		data = userService.authenticate(email, password);
		System.out.println("data "+data.size());
		if(data.size() == 0){
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("status", "failed");
			data.add(hm);
		}
		
		System.out.println("result data users "+data);
		return data;
	}*/
	
	@InjectParam
	GalleryService galleryservice;
	
	private static final FileUpload fileupload = new FileUpload();

	
	public int saveGallery(GalleryVo galleryvo){
		int id=0;

		try{
 			
 			GalleryUpload imgupload = new GalleryUpload();
			imgupload.setImagepath(galleryvo.getImagepath());
			imgupload.setImagename(galleryvo.getImagename());
			imgupload.setPersonalid(Integer.parseInt(galleryvo.getPersonalid()));
			imgupload.setStatus("A");
			id = galleryservice.save(imgupload);   
			
			
			/*String imgArray[] = galleryvo.getImagepath().split(","); 
			System.out.println("Image path"+galleryvo.getImagepath());
			String imgname[] = galleryvo.getImagename().split(",");
			System.out.println("Image Name:"+galleryvo.getImagename());
			
			for(int i=0;i<imgArray.length;i++) {
				GalleryUpload imgupload = new GalleryUpload();
				imgupload.setImagepath(imgArray[i]);
				imgupload.setImagename(imgname[i]);
				imgupload.setStatus("A");
				id = galleryservice.save(galleryupload); 
			}*/
 		}
		catch(Exception e){
			e.printStackTrace();
 		}
		return id;
 		
	}
}
