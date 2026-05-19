package utility.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horoscopedetails")
public class Horoscope implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int personal_id;
	private String star;
	private String rasi;
	private String lagnam;
	private String dhishaiiruphu;
	private String patham;
 
	private String document;
	
	
	private String year_month_date;

	/**
	 * @return the personal_id
	 */
	public int getPersonal_id() {
		return personal_id;
	}

	/**
	 * @param personal_id the personal_id to set
	 */
	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	/**
	 * @return the star
	 */
	public String getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(String star) {
		this.star = star;
	}

	/**
	 * @return the rasi
	 */
	public String getRasi() {
		return rasi;
	}

	/**
	 * @param rasi the rasi to set
	 */
	public void setRasi(String rasi) {
		this.rasi = rasi;
	}

	/**
	 * @return the lagnam
	 */
	public String getLagnam() {
		return lagnam;
	}

	/**
	 * @param lagnam the lagnam to set
	 */
	public void setLagnam(String lagnam) {
		this.lagnam = lagnam;
	}

	/**
	 * @return the dhishaiiruphu
	 */
	public String getDhishaiiruphu() {
		return dhishaiiruphu;
	}

	/**
	 * @param dhishaiiruphu the dhishaiiruphu to set
	 */
	public void setDhishaiiruphu(String dhishaiiruphu) {
		this.dhishaiiruphu = dhishaiiruphu;
	}

	/**
	 * @return the year_month_date
	 */
	public String getYear_month_date() {
		return year_month_date;
	}

	/**
	 * @param year_month_date the year_month_date to set
	 */
	public void setYear_month_date(String year_month_date) {
		this.year_month_date = year_month_date;
	}

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	public String getPatham() {
		return patham;
	}

	public void setPatham(String patham) {
		this.patham = patham;
	}
}
