package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "subcaste")
public class SubCaste {

    @Id
    @GeneratedValue
    private int subcasteid;

    private String subcastename;
    
    private int casteid;
    
    private String status;

	public int getSubcasteid() {
		return subcasteid;
	}

	public void setSubcasteid(int subcasteid) {
		this.subcasteid = subcasteid;
	}

	public String getSubcastename() {
		return subcastename;
	}

	public void setSubcastename(String subcastename) {
		this.subcastename = subcastename;
	}

	public int getCasteid() {
		return casteid;
	}

	public void setCasteid(int casteid) {
		this.casteid = casteid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
    

}
