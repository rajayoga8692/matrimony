package utility.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="amsamkattam")
public class ASqure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String a5;
	private String a6;
	private String a7;
	private String a8;
	private String a9;
	private String a10;
	private String a11;
	private String a12;
	private int personal_id;
	
	/**
	 * @return the a1
	 */
	public String getA1() {
		return a1;
	}
	/**
	 * @param a1 the a1 to set
	 */
	public void setA1(String a1) {
		this.a1 = a1;
	}
	/**
	 * @return the a2
	 */
	public String getA2() {
		return a2;
	}
	/**
	 * @param a2 the a2 to set
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	/**
	 * @return the a3
	 */
	public String getA3() {
		return a3;
	}
	/**
	 * @param a3 the a3 to set
	 */
	public void setA3(String a3) {
		this.a3 = a3;
	}
	/**
	 * @return the a4
	 */
	public String getA4() {
		return a4;
	}
	/**
	 * @param a4 the a4 to set
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	/**
	 * @return the a5
	 */
	public String getA5() {
		return a5;
	}
	/**
	 * @param a5 the a5 to set
	 */
	public void setA5(String a5) {
		this.a5 = a5;
	}
	/**
	 * @return the a6
	 */
	public String getA6() {
		return a6;
	}
	/**
	 * @param a6 the a6 to set
	 */
	public void setA6(String a6) {
		this.a6 = a6;
	}
	/**
	 * @return the a7
	 */
	public String getA7() {
		return a7;
	}
	/**
	 * @param a7 the a7 to set
	 */
	public void setA7(String a7) {
		this.a7 = a7;
	}
	/**
	 * @return the a8
	 */
	public String getA8() {
		return a8;
	}
	/**
	 * @param a8 the a8 to set
	 */
	public void setA8(String a8) {
		this.a8 = a8;
	}
	/**
	 * @return the a9
	 */
	public String getA9() {
		return a9;
	}
	/**
	 * @param a9 the a9 to set
	 */
	public void setA9(String a9) {
		this.a9 = a9;
	}
	/**
	 * @return the a10
	 */
	public String getA10() {
		return a10;
	}
	/**
	 * @param a10 the a10 to set
	 */
	public void setA10(String a10) {
		this.a10 = a10;
	}
	/**
	 * @return the a11
	 */
	public String getA11() {
		return a11;
	}
	/**
	 * @param a11 the a11 to set
	 */
	public void setA11(String a11) {
		this.a11 = a11;
	}
	/**
	 * @return the a12
	 */
	public String getA12() {
		return a12;
	}
	/**
	 * @param a12 the a12 to set
	 */
	public void setA12(String a12) {
		this.a12 = a12;
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
