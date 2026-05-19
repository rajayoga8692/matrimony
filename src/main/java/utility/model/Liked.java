package utility.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liked")
public class Liked {

    @Id  
    @GeneratedValue
    private int likedid;

    private int likedby;
    
    private int likedto;

    private String status;
    
	private Date likeddate;

	public int getLikedid() {
		return likedid;
	}

	public int getLikedby() {
		return likedby;
	}

	public int getLikedto() {
		return likedto;
	}

	public String getStatus() {
		return status;
	}

	 

	public void setLikedid(int likedid) {
		this.likedid = likedid;
	}

	public void setLikedby(int likedby) {
		this.likedby = likedby;
	}

	public void setLikedto(int likedto) {
		this.likedto = likedto;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLikeddate() {
		return likeddate;
	}

	public void setLikeddate(Date likeddate) {
		this.likeddate = likeddate;
	}
 

  
}
