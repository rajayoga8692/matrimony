package utility.vo;

public class LoginVO {

	
	private String username;
	private String pwd;
	private int personal_id;
	private String device_token;

	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}
}
