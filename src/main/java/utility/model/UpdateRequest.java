package utility.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "update_request")
public class UpdateRequest {

    @Id  
    @GeneratedValue
    private int updaterequestid;

    private int requestby;
    
    private String comments;

    private String status;
    
	private Date requestdate;

	public int getUpdaterequestid() {
		return updaterequestid;
	}

	public void setUpdaterequestid(int updaterequestid) {
		this.updaterequestid = updaterequestid;
	}

	public int getRequestby() {
		return requestby;
	}

	public void setRequestby(int requestby) {
		this.requestby = requestby;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	/*CREATE TABLE `ighostel`.`update_request` (
			  `updaterequestid` INT NOT NULL AUTO_INCREMENT,
			  `requestby` INT NULL,
			  `comments` LONGTEXT NULL,
			  `status` VARCHAR(5) NULL,
			  `requestdate` DATETIME NULL,
			  PRIMARY KEY (`updaterequestid`));
*/
	 

  
}
