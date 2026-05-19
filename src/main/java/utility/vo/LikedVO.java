package utility.vo;

import java.util.Date;

 
public class LikedVO {

   
    private int likedid;

    private int likedby;
    
    private int likedto;

    private String status;
    
	private Date createddate;

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

	public Date getCreateddate() {
		return createddate;
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

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	} 

  
}
