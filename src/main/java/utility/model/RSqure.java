package utility.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rkattam")
public class RSqure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String r1;
	private String r2;
	private String r3;
	private String r4;
	private String r5;
	private String r6;
	private String r7;
	private String r8;
	private String r9;
	private String r10;
	private String r11;
	private String r12;
	private int  personal_id;
	/**
	 * @return the r1
	 */
	public String getR1() {
		return r1;
	}
	/**
	 * @param r1 the r1 to set
	 */
	public void setR1(String r1) {
		this.r1 = r1;
	}
	/**
	 * @return the r2
	 */
	public String getR2() {
		return r2;
	}
	/**
	 * @param r2 the r2 to set
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	/**
	 * @return the r3
	 */
	public String getR3() {
		return r3;
	}
	/**
	 * @param r3 the r3 to set
	 */
	public void setR3(String r3) {
		this.r3 = r3;
	}
	/**
	 * @return the r4
	 */
	public String getR4() {
		return r4;
	}
	/**
	 * @param r4 the r4 to set
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	/**
	 * @return the r5
	 */
	public String getR5() {
		return r5;
	}
	/**
	 * @param r5 the r5 to set
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	/**
	 * @return the r6
	 */
	public String getR6() {
		return r6;
	}
	/**
	 * @param r6 the r6 to set
	 */
	public void setR6(String r6) {
		this.r6 = r6;
	}
	/**
	 * @return the r7
	 */
	public String getR7() {
		return r7;
	}
	/**
	 * @param r7 the r7 to set
	 */
	public void setR7(String r7) {
		this.r7 = r7;
	}
	/**
	 * @return the r8
	 */
	public String getR8() {
		return r8;
	}
	/**
	 * @param r8 the r8 to set
	 */
	public void setR8(String r8) {
		this.r8 = r8;
	}
	/**
	 * @return the r9
	 */
	public String getR9() {
		return r9;
	}
	/**
	 * @param r9 the r9 to set
	 */
	public void setR9(String r9) {
		this.r9 = r9;
	}
	/**
	 * @return the r10
	 */
	public String getR10() {
		return r10;
	}
	/**
	 * @param r10 the r10 to set
	 */
	public void setR10(String r10) {
		this.r10 = r10;
	}
	/**
	 * @return the r11
	 */
	public String getR11() {
		return r11;
	}
	/**
	 * @param r11 the r11 to set
	 */
	public void setR11(String r11) {
		this.r11 = r11;
	}
	/**
	 * @return the r12
	 */
	public String getR12() {
		return r12;
	}
	/**
	 * @param r12 the r12 to set
	 */
	public void setR12(String r12) {
		this.r12 = r12;
	}
	/**
	 * @return the personal_id
	 */
	public long getPersonal_id() {
		return personal_id;
	}
	/**
	 * @param personal_id the personal_id to set
	 */
	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}
	

}
