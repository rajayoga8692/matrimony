package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "membership_plan")
public class MembershipPlan {

    @Id
    @GeneratedValue
    private int planid;

    private String planname;
    
    private String contacts;
    
    private int amount;
    
    private String status;
    
    private String validitydays;


	public int getPlanid() {
		return planid;
	}

	public String getPlanname() {
		return planname;
	}

	

	public int getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getValiditydays() {
		return validitydays;
	}

	public void setValiditydays(String validitydays) {
		this.validitydays = validitydays;
	}
     
	
}
