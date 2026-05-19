package utility.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="familydetails")
public class FamilyDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String fathername;
	private String fatheroccupation;
	private String mothername;
	private String motheroccupation;
	private String nativeplace;
	private String assets;
	private int brother;
	private int marriedbrothers;
	private int sister;
	private int marriedsister;
	private String kulatheivam;
	private char status;
	private String motherplace;
	private String fatherplace;
	private String birthplace;
	
	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getFatherplace() {
		return fatherplace;
	}

	public void setFatherplace(String fatherplace) {
		this.fatherplace = fatherplace;
	}

	public String getMotherplace() {
		return motherplace;
	}

	public void setMotherplace(String motherplace) {
		this.motherplace = motherplace;
	}


	private int personal_id;

	/**
	 * @return the fathername
	 */
	public String getFathername() {
		return fathername;
	}

	/**
	 * @param fathername the fathername to set
	 */
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	/**
	 * @return the fatheroccupation
	 */
	public String getFatheroccupation() {
		return fatheroccupation;
	}

	/**
	 * @param fatheroccupation the fatheroccupation to set
	 */
	public void setFatheroccupation(String fatheroccupation) {
		this.fatheroccupation = fatheroccupation;
	}

	/**
	 * @return the mothername
	 */
	public String getMothername() {
		return mothername;
	}

	/**
	 * @param mothername the mothername to set
	 */
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	/**
	 * @return the motheroccupation
	 */
	public String getMotheroccupation() {
		return motheroccupation;
	}

	/**
	 * @param motheroccupation the motheroccupation to set
	 */
	public void setMotheroccupation(String motheroccupation) {
		this.motheroccupation = motheroccupation;
	}

	/**
	 * @return the nativeplace
	 */
	public String getNativeplace() {
		return nativeplace;
	}

	/**
	 * @param nativeplace the nativeplace to set
	 */
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	/**
	 * @return the assets
	 */
	public String getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(String assets) {
		this.assets = assets;
	}

	/**
	 * @return the brother
	 */
	public int getBrother() {
		return brother;
	}

	/**
	 * @param brother the brother to set
	 */
	public void setBrother(int brother) {
		this.brother = brother;
	}

	/**
	 * @return the marriedbrothers
	 */
	public int getMarriedbrothers() {
		return marriedbrothers;
	}

	/**
	 * @param marriedbrothers the marriedbrothers to set
	 */
	public void setMarriedbrothers(int marriedbrothers) {
		this.marriedbrothers = marriedbrothers;
	}

	/**
	 * @return the sister
	 */
	public int getSister() {
		return sister;
	}

	/**
	 * @param sister the sister to set
	 */
	public void setSister(int sister) {
		this.sister = sister;
	}

	/**
	 * @return the marriedsister
	 */
	public int getMarriedsister() {
		return marriedsister;
	}

	/**
	 * @param marriedsister the marriedsister to set
	 */
	public void setMarriedsister(int marriedsister) {
		this.marriedsister = marriedsister;
	}

	/**
	 * @return the kulatheivam
	 */
	public String getKulatheivam() {
		return kulatheivam;
	}

	/**
	 * @param kulatheivam the kulatheivam to set
	 */
	public void setKulatheivam(String kulatheivam) {
		this.kulatheivam = kulatheivam;
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
