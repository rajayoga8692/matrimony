package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "successtory")
public class SuccesStory {

    @Id
    @GeneratedValue
    private int succestoryid;

 	private String description;
	
	private String imagepath;
	  
	private String status;
	
	private String name;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImagepath() {
		return imagepath;
	}
	
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public int getSuccestoryid() {
		return succestoryid;
	}

	public void setSuccestoryid(int succestoryid) {
		this.succestoryid = succestoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
     

}
