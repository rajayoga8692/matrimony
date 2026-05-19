package utility.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankdetails")
public class BankDetails {

    @Id
    @GeneratedValue
    private int bankdetailsid;

    private String accountnumber;
    
    private String holdername;
	 
    private String branchname;
    
    private String bankname;
    
    private String imagepath; 

    private String branchcode;
    
    private String ifsccode;

    private String status;

	public int getBankdetailsid() {
		return bankdetailsid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public String getHoldername() {
		return holdername;
	}

	public String getBranchname() {
		return branchname;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public String getStatus() {
		return status;
	}

	public void setBankdetailsid(int bankdetailsid) {
		this.bankdetailsid = bankdetailsid;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankname() {
		return bankname;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


     

}
