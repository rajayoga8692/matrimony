package utility.vo;

import java.util.Date;
 

 
public class ViewedHistoryVO {
 
    private int viewedhistoryid;

    private int viewedmemberid;
    
    private int viewedby;
    
    private Date vieweddate;

    private String status;
    
    private String updatecount;


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

	public String getUpdatecount() {
		return updatecount;
	}

	public void setUpdatecount(String updatecount) {
		this.updatecount = updatecount;
	}


}
