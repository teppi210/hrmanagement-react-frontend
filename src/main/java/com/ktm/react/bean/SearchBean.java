package com.ktm.react.bean;

import org.springframework.http.codec.multipart.Part;

public class SearchBean {
	
	private int ncandidate_id=0;
	private String ncandidate_name="";
	private int ncandidate_age=0;
	private String ncandidate_emailid="";
	private String ncandidate_phoneno="";
	private String ncandidate_address="";
	private String ncandidate_qualification="";
	private String ncandidate_designation="";
	
	private String ncandidate_filepath="";
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	public SearchBean(int ncandidate_id, String ncandidate_name, int ncandidate_age, String ncandidate_emailid,
			String ncandidate_phoneno, String ncandidate_address, String ncandidate_qualification,
			String ncandidate_designation, String ncandidate_filepath, int created_by,
			String created_date, int modified_by, String modified_date) {
		super();
		this.ncandidate_id = ncandidate_id;
		this.ncandidate_name = ncandidate_name;
		this.ncandidate_age = ncandidate_age;
		this.ncandidate_emailid = ncandidate_emailid;
		this.ncandidate_phoneno = ncandidate_phoneno;
		this.ncandidate_address = ncandidate_address;
		this.ncandidate_qualification = ncandidate_qualification;
		this.ncandidate_designation = ncandidate_designation;
		
		this.ncandidate_filepath = ncandidate_filepath;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public int getNcandidate_id() {
		return ncandidate_id;
	}

	public void setNcandidate_id(int ncandidate_id) {
		this.ncandidate_id = ncandidate_id;
	}

	public String getNcandidate_name() {
		return ncandidate_name;
	}

	public void setNcandidate_name(String ncandidate_name) {
		this.ncandidate_name = ncandidate_name;
	}

	public int getNcandidate_age() {
		return ncandidate_age;
	}

	public void setNcandidate_age(int ncandidate_age) {
		this.ncandidate_age = ncandidate_age;
	}

	public String getNcandidate_emailid() {
		return ncandidate_emailid;
	}

	public void setNcandidate_emailid(String ncandidate_emailid) {
		this.ncandidate_emailid = ncandidate_emailid;
	}

	public String getNcandidate_phoneno() {
		return ncandidate_phoneno;
	}

	public void setNcandidate_phoneno(String ncandidate_phoneno) {
		this.ncandidate_phoneno = ncandidate_phoneno;
	}

	public String getNcandidate_address() {
		return ncandidate_address;
	}

	public void setNcandidate_address(String ncandidate_address) {
		this.ncandidate_address = ncandidate_address;
	}

	public String getNcandidate_qualification() {
		return ncandidate_qualification;
	}

	public void setNcandidate_qualification(String ncandidate_qualification) {
		this.ncandidate_qualification = ncandidate_qualification;
	}

	public String getNcandidate_designation() {
		return ncandidate_designation;
	}

	public void setNcandidate_designation(String ncandidate_designation) {
		this.ncandidate_designation = ncandidate_designation;
	}

	
	

	public String getNcandidate_filepath() {
		return ncandidate_filepath;
	}

	public void setNcandidate_filepath(String ncandidate_filepath) {
		this.ncandidate_filepath = ncandidate_filepath;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public int getModified_by() {
		return modified_by;
	}

	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "SearchBean [ncandidate_id=" + ncandidate_id + ", ncandidate_name=" + ncandidate_name
				+ ", ncandidate_age=" + ncandidate_age + ", ncandidate_emailid=" + ncandidate_emailid
				+ ", ncandidate_phoneno=" + ncandidate_phoneno + ", ncandidate_address=" + ncandidate_address
				+ ", ncandidate_qualification=" + ncandidate_qualification + ", ncandidate_designation="
				+ ncandidate_designation + ", ncandidate_filepath="
				+ ncandidate_filepath + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", modified_by=" + modified_by + ", modified_date=" + modified_date + "]";
	}
	
	
}
