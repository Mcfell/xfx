package com.xfx.Entity;

public class TeacherInfo extends userInfo {
	private String status = null;
	private int level ;
	private String profession;
	private String school;
	private String photo1 ;
	private String photo2 ;
	
	private String introduction ;
	private String details;
	private String curriculums;
	private int best_nums;
	private int normal_nums;
	private int bad_nums;
	private int all_nums;
	private String bankaccount;
	private String des_bank;
	private String thru_time;
	
	public String getCurriculums() {
		return curriculums;
	}
	public void setCurriculums(String curriculums) {
		this.curriculums = curriculums;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getBest_nums() {
		return best_nums;
	}
	public void setBest_nums(int best_nums) {
		this.best_nums = best_nums;
	}
	public int getNormal_nums() {
		return normal_nums;
	}
	public void setNormal_nums(int normal_nums) {
		this.normal_nums = normal_nums;
	}
	public int getBad_nums() {
		return bad_nums;
	}
	public void setBad_nums(int bad_nums) {
		this.bad_nums = bad_nums;
	}
	public int getAll_nums() {
		return all_nums;
	}
	public void setAll_nums(int all_nums) {
		this.all_nums = all_nums;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	public String getDes_bank() {
		return des_bank;
	}
	public void setDes_bank(String des_bank) {
		this.des_bank = des_bank;
	}
	public String getThru_time() {
		return thru_time;
	}
	public void setThru_time(String thru_time) {
		this.thru_time = thru_time;
	}
	
	
}
