package utility.vo;
 
 
public class BankDetailsVO {

    private int bankdetailsid;

    private String accountnumber;
    
    private String holdername;
    
    private String bankname;
    
    private String imagepath;
	 
    private String branchname;

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

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


     

}
