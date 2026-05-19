package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue
    private int districtid;

    private String districtname;
    
    private String status;
	 
	 
	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    

}
