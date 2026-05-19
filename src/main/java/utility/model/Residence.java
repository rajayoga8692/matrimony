package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "residence")
public class Residence {

    @Id
    @GeneratedValue
    private int residenceid;

    public int getResidenceid() {
		return residenceid;
	}

	public void setResidenceid(int residenceid) {
		this.residenceid = residenceid;
	}

	public String getResidencename() {
		return residencename;
	}

	public void setResidencename(String residencename) {
		this.residencename = residencename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String residencename;
    
    private String status;
	 
	 
	

}

