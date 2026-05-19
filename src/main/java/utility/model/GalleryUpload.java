package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gallery")
public class GalleryUpload {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int galleryid;
	
 	private String imagename;
	private String imagepath;
	private String status;
	private int personalid;

	public int getGalleryid() {
		return galleryid;
	}
	public void setGalleryid(int galleryid) {
		this.galleryid = galleryid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPersonalid() {
		return personalid;
	}
	public void setPersonalid(int personalid) {
		this.personalid = personalid;
	}
	
	
	
}

