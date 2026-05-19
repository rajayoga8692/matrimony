package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "workplace")
public class Workplace {

    @Id
    @GeneratedValue
    private int workplaceid;

    public int getWorkplaceid() {
		return workplaceid;
	}

	public void setWorkplaceid(int workplaceid) {
		this.workplaceid = workplaceid;
	}

	public String getWorkplacename() {
		return workplacename;
	}

	public void setWorkplacename(String workplacename) {
		this.workplacename = workplacename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String workplacename;
    
    private String status;
}
