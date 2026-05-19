package utility.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expetation")
public class Others implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String expectation;
	private String specialcase;
	private String emailid;
	private String registeredby;
	private String photo;
	private char status;
	private int personal_id;
	/**
	 * @return the expectation
	 */
	public String getExpectation() {
		return expectation;
	}
	/**
	 * @param expectation the expectation to set
	 */
	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}
	/**
	 * @return the specialcase
	 */
	public String getSpecialcase() {
		return specialcase;
	}
	/**
	 * @param specialcase the specialcase to set
	 */
	public void setSpecialcase(String specialcase) {
		this.specialcase = specialcase;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the registeredby
	 */
	public String getRegisteredby() {
		return registeredby;
	}
	/**
	 * @param registeredby the registeredby to set
	 */
	public void setRegisteredby(String registeredby) {
		this.registeredby = registeredby;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the staus
	 */
	public char getStatus() {
		return status;
	}
	/**
	 * @param staus the staus to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}
	/**
	 * @return the personal_id
	 */
	public long getPersonal_id() {
		return personal_id;
	}
	/**
	 * @param personal_id the personal_id to set
	 */
	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}
	
	
}
