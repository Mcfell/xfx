package com.xfx.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.xfx.utils.*;
public class dbEntity {
	private Database db;
	public dbEntity(){
		 db= new Database();
	}
	
	public int dbResu(){
		return db.getResu();
	}
	/**
	 * ��ѯ�ֻ����Ƿ����
	 * @param checkConditon
	 * @param pras
	 * @return
	 */
	public boolean checkPhone(String... pras){
		 String checkConditon = "SELECT TELEPHONE FROM ((SELECT TELEPHONE FROM teacher) UNION (SELECT TELEPHONE FROM student)) AS NEWPHONE WHERE TELEPHONE = ? ";
		 try {
	        	ResultSet rs =db.query(checkConditon, pras);
				if(rs.next()) { //����ֻ�����
					return true;
				}
				else {
					 return false;
				}
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				db.closeAll();
			}
	}
	public boolean checkEmail(String... pras){
		 String checkConditon = "SELECT EMAIL FROM ((SELECT EMAIL FROM teacher) UNION (SELECT EMAIL FROM student)) AS NEWEMAIL WHERE EMAIL = ? ";
		 try {
	        	ResultSet rs =db.query(checkConditon, pras);
				if(rs.next()) { //����������
					return true;
				}
				else {
					 return false;
				}
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				db.closeAll();
			}
	}
	/**
	 * ��ʦע��
	 * @param pras
	 * @return
	 */
	public boolean registerTeacher(String...pras){
		String checkConditon = "INSERT INTO teacher (TID,REALNAME,TELEPHONE,PASSWORD) VALUES(?,?,?,?)";
		db.update(checkConditon, pras);
		if(this.dbResu()!=0) { //���ע��ɹ�
			db.closeAll();
	    	return true;
		}
		else {
			db.closeAll();
			 return false;
		}
	}
	/**
	 * ѧ��ע��
	 * @param pras
	 * @return
	 */
	public boolean registerStudent(String...pras){
		String checkConditon = "INSERT INTO student (SID,USERNAME,TELEPHONE,PASSWORD) VALUES(?,?,?,?)";
		db.update(checkConditon, pras);
		if(this.dbResu()!=0) { //���ע��ɹ�
			db.closeAll();
			return true;
		}
		else {
			db.closeAll();
			 return false;
		}
	}
	
	/**
	 * ��ʦ��ϸ��Ϣע��
	 * @param pras
	 * @return
	 */
	public boolean saveTeacherInf(String...pras){
		String checkConditon = "UPDATE teacher set PROVINCE=?,CITY=?,ADDRESS=?,SCHOOL=?,PROFESSION=?,PHOTO1=?,PHOTO2=?,INTRODUCTION=?,DETAILS=?,BANKACCOUTNT=?,DES_BANK=? where TID = ?";
		db.update(checkConditon, pras);
		if(this.dbResu()!=0) { //���ע��ɹ�
			db.closeAll();
			return true;
		}
		else {
			 db.closeAll();
			 return false;
		}
	}
	/**
	 * ��Ա��¼
	 */	
	public Boolean userLogin(String...pras){
		String checkConditon = "SELECT TELEPHONE,PASSWORD FROM ((SELECT TELEPHONE,PASSWORD FROM teacher) UNION (SELECT TELEPHONE,PASSWORD FROM student)) AS NEWUSER WHERE TELEPHONE = ? AND PASSWORD = ?";
		 try {
	        	ResultSet rs =db.query(checkConditon, pras);
				if(rs.next()) { //����������
					return true;
				}
				else {
					 return false;
				}
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				db.closeAll();
			}
	}
	/**
	 * 查询所有老师简要信息
	 * @param pras
	 */
	public List<TeacherInfo> checkAllTeacherInfo(String...pras){
		String checkConditon = "SELECT * from teacher";
		 try {
	        	ResultSet rs =db.query(checkConditon, pras);
	        	List <TeacherInfo>teacher = new ArrayList<TeacherInfo>();
				while(rs.next()) { //����������
					TeacherInfo teaInfo = new TeacherInfo();
					teaInfo.setId(rs.getString(1));//ID
					teaInfo.setRealname(rs.getString(2));//姓名
					teaInfo.setEmail(rs.getString(4));
					teaInfo.setTelephone(rs.getString(5));
					teaInfo.setProvince(rs.getString(6));
					teaInfo.setCity(rs.getString(7));
					teaInfo.setAddress(rs.getString(8));
					teaInfo.setProfession(rs.getString(11));
					teaInfo.setPhoto1(rs.getString(12));
					teaInfo.setPhoto2(rs.getString(13));
					teaInfo.setIntroduction(rs.getString(14));
					teaInfo.setDetails(rs.getString(15));
					teaInfo.setSchool(rs.getString(24));
					teacher.add(teaInfo);
	        	}
				if(!teacher.isEmpty()){
					 return teacher;
				}else return null;
			   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				db.closeAll();
			}
	}
	/**
	 * 通过id查询老师详细信息
	 * @param pras id
	 * @return TeacherInfo
	 */
	public TeacherInfo checkTeacherInfoById(String...pras){
		String checkConditon = "SELECT * from teacher where TID = ?";
		 try {
	        	ResultSet rs =db.query(checkConditon, pras);
				if(rs.next()) {
					TeacherInfo teaInfo = new TeacherInfo();
					teaInfo.setId(rs.getString(1));//ID
					teaInfo.setRealname(rs.getString(2));//姓名
					teaInfo.setEmail(rs.getString(4));
					teaInfo.setTelephone(rs.getString(5));
					teaInfo.setProvince(rs.getString(6));
					teaInfo.setCity(rs.getString(7));
					teaInfo.setAddress(rs.getString(8));
					teaInfo.setProfession(rs.getString(11));
					teaInfo.setPhoto1(rs.getString(12));
					teaInfo.setPhoto2(rs.getString(13));
					teaInfo.setIntroduction(rs.getString(14));
					teaInfo.setDetails(rs.getString(15));
					teaInfo.setSchool(rs.getString(24));
					return teaInfo;
	        	}else return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				db.closeAll();
			}
	}
	
}
