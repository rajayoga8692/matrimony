package utility.vo;



public class MembershipPlanVO {


    private int planid;
    private String planname;
    private int amount;
    private String contacts;
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
	public String getContacts() {
		return contacts;
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
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getValiditydays() {
		return validitydays;
	}
	public void setValiditydays(String validitydays) {
		this.validitydays = validitydays;
	}
    
 
}
