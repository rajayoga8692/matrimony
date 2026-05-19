package utility.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assigned_plan")
public class AssignedPlan {

    @Id
    @GeneratedValue
    private int idassigned_plan;

    private int personalid;
    
    private int membership_plan_id;
    
    private Date subscripeddate;
    
    private Date expireddate;
    
    private int updatecount;

    private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdassigned_plan() {
		return idassigned_plan;
	}

	public void setIdassigned_plan(int idassigned_plan) {
		this.idassigned_plan = idassigned_plan;
	}

  
 	public int getPersonalid() {
		return personalid;
	}

	public void setPersonalid(int personalid) {
		this.personalid = personalid;
	}

	public int getMembership_plan_id() {
		return membership_plan_id;
	}

	public void setMembership_plan_id(int membership_plan_id) {
		this.membership_plan_id = membership_plan_id;
	}

	public Date getSubscripeddate() {
		return subscripeddate;
	}

	public void setSubscripeddate(Date subscripeddate) {
		this.subscripeddate = subscripeddate;
	}

	public int getUpdatecount() {
		return updatecount;
	}

	public void setUpdatecount(int updatecount) {
		this.updatecount = updatecount;
	}

	public Date getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}
     
}
