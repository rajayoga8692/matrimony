package utility.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactdetails")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String addressone;
	private String addresstwo;
	private String city;
	private String contactno;
	private String mobileno;
	private char status;
	private int personal_id;
	/**
	 * @return the addressone
	 */
	public String getAddressone() {
		return addressone;
	}
	/**
	 * @param addressone the addressone to set
	 */
	public void setAddressone(String addressone) {
		this.addressone = addressone;
	}
	/**
	 * @return the addresstwo
	 */
	public String getAddresstwo() {
		return addresstwo;
	}
	/**
	 * @param addresstwo the addresstwo to set
	 */
	public void setAddresstwo(String addresstwo) {
		this.addresstwo = addresstwo;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the contactno
	 */
	public String getContactno() {
		return contactno;
	}
	/**
	 * @param contactno the contactno to set
	 */
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
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
