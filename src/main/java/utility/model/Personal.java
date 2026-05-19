package utility.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="personal")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String registerid;
	private String registerno;
	private String name;
	private String gender;
	private String dateofbirth;
	
	private String heightcm;
	private String heightft;
	
	private String complexion;
	private int subcaste_id;
	
	private String educationlevel;
	
	private int education_id;
	private String education;
	private String occupation;
	private String workingplace;
	private String monthlyincome;
	private String marriedstatus;
	private char status;
	private String religion;
	private String vagaira;
	private String time;
	private String physical;
    
	private String jobtype;
	private String jobsector;
	private int country;
	private int workingcity;
 	private int jobid;
 	private Date registeredDate;
 	private Date approvedDate;
 	private String device_token;

	
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		 this.device_token = device_token;
	}
	
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public String getJobsector() {
		return jobsector;
	}
	public void setJobsector(String jobsector) {
		this.jobsector = jobsector;
	}
	/**
	 * @return the registerid
	 */
	public String getRegisterid() {
		return registerid;
	}
	/**
	 * @param registerid the registerid to set
	 */
	public void setRegisterid(String registerid) {
		this.registerid = registerid;
	}
	/**
	 * @return the registerno
	 */
	public String getRegisterno() {
		return registerno;
	}
	/**
	 * @param registerno the registerno to set
	 */
	public void setRegisterno(String registerno) {
		this.registerno = registerno;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dateofbirth
	 */
	public String getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth the dateofbirth to set
	 */
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return the heightcm
	 */
	public String getHeightcm() {
		return heightcm;
	}
	/**
	 * @param heightcm the heightcm to set
	 */
	public void setHeightcm(String heightcm) {
		this.heightcm = heightcm;
	}
	/**
	 * @return the heightft
	 */
	public String getHeightft() {
		return heightft;
	}
	/**
	 * @param heightft the heightft to set
	 */
	public void setHeightft(String heightft) {
		this.heightft = heightft;
	}
	/**
	 * @return the complexion
	 */
	public String getComplexion() {
		return complexion;
	}
	/**
	 * @param complexion the complexion to set
	 */
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	/**
	 * @return the subcaste_id
	 */
	public int getSubcaste_id() {
		return subcaste_id;
	}
	/**
	 * @param subcaste_id the subcaste_id to set
	 */
	public void setSubcaste_id(int subcaste_id) {
		this.subcaste_id = subcaste_id;
	}
	/**
	 * @return the educationlevel
	 */
	public String getEducationlevel() {
		return educationlevel;
	}
	/**
	 * @param educationlevel the educationlevel to set
	 */
	public void setEducationlevel(String educationlevel) {
		this.educationlevel = educationlevel;
	}
	/**
	 * @return the education_id
	 */
	public int getEducation_id() {
		return education_id;
	}
	/**
	 * @param education_id the education_id to set
	 */
	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * @return the workingplace
	 */
	public String getWorkingplace() {
		return workingplace;
	}
	/**
	 * @param workingplace the workingplace to set
	 */
	public void setWorkingplace(String workingplace) {
		this.workingplace = workingplace;
	}
	/**
	 * @return the monthlyincome
	 */
	public String getMonthlyincome() {
		return monthlyincome;
	}
	/**
	 * @param monthlyincome the monthlyincome to set
	 */
	public void setMonthlyincome(String monthlyincome) {
		this.monthlyincome = monthlyincome;
	}
	/**
	 * @return the marriedstatus
	 */
	public String getMarriedstatus() {
		return marriedstatus;
	}
	/**
	 * @param marriedstatus the marriedstatus to set
	 */
	public void setMarriedstatus(String marriedstatus) {
		this.marriedstatus = marriedstatus;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getVagaira() {
		return vagaira;
	}
	public void setVagaira(String vagaira) {
		this.vagaira = vagaira;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhysical() {
		return physical;
	}
	public void setPhysical(String physical) {
		this.physical = physical;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public int getWorkingcity() {
		return workingcity;
	}
	public void setWorkingcity(int workingcity) {
		this.workingcity = workingcity;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
}
