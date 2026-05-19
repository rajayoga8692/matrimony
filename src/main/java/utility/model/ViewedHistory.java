package utility.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viewedhistory")
public class ViewedHistory {

    @Id
    @GeneratedValue
    private int viewedhistoryid;

    private int viewedmemberid;
    
    private int viewedby;
    
    private Date vieweddate;

    private String status;

	public int getViewedhistoryid() {
		return viewedhistoryid;
	}

	public int getViewedmemberid() {
		return viewedmemberid;
	}

	public int getViewedby() {
		return viewedby;
	}

	public Date getVieweddate() {
		return vieweddate;
	}

	public String getStatus() {
		return status;
	}

	public void setViewedhistoryid(int viewedhistoryid) {
		this.viewedhistoryid = viewedhistoryid;
	}

	public void setViewedmemberid(int viewedmemberid) {
		this.viewedmemberid = viewedmemberid;
	}

	public void setViewedby(int viewedby) {
		this.viewedby = viewedby;
	}

	public void setVieweddate(Date vieweddate) {
		this.vieweddate = vieweddate;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
