package com.xfx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.UID;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.xfx.Entity.StudentInfo;
import com.xfx.Entity.TeacherInfo;
import com.xfx.utils.Database;
import com.xfx.utils.SDKTestSendTemplateSMS;
import com.xfx.Entity.dbEntity;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		System.out.println(act);
		JSONObject pushData = new JSONObject();
		if(act.equals("verify_phone")){
			String phone = request.getParameter("phone");
			dbEntity db = new dbEntity();
			if(!db.checkPhone(phone)){
				try {
					pushData.append("IsSuccess", true);
					pushData.append("Message", "�ֻ��ſ���ʹ��");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					pushData.append("IsSuccess", false);
					pushData.append("Message", "���ֻ��Ѵ��ڣ�");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out.println(pushData);
		}
		if(act.equals("verify_email")){
			String email = request.getParameter("email");
			dbEntity db = new dbEntity();
			if(!db.checkEmail(email)){
				try {
					pushData.append("IsSuccess", true);
					pushData.append("Message", "�������ʹ��");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					pushData.append("IsSuccess", false);
					pushData.append("Message", "�������Ѵ��ڣ�");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out.println(pushData);
		}
		/**
		 *��ȡ�����֤��
		 */
		
		if(act.equals("get_rand_code")){
			 int code = (int) (Math.random()*100000);
				try {
					pushData.append("IsSuccess", true);
					pushData.append("code", code);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			out.println(pushData.toString());
		}
		/**
		 * ������֤��
		 */
		if(act.equals("get_code")){
				HttpSession sess = request.getSession();
				int rcode = (int)(Math.random()*100000);
				String ccode = String.valueOf(rcode);
				sess.setAttribute("register_code", ccode);
				String phone = request.getParameter("phone");
				String forgot = request.getParameter("forgot");
				System.out.println(ccode);
				System.out.println(phone);
				System.out.println(forgot);
				boolean isSend = new SDKTestSendTemplateSMS().sendSMS(phone, ccode, "1", "1");;
				
				try {
					if(isSend){
					pushData.append("IsSuccess", true);
					pushData.append("Message", "��֤�뷢�ͳɹ�");
					}else{
					pushData.append("IsSuccess", false);
					pushData.append("Message", "��ʾͼ����֤");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			out.println(pushData.toString());
		}
		if(act.equals("verifyphoneimg")){
			HttpSession sess = request.getSession();
			String rand = (String) sess.getAttribute("rand");
			String code = request.getParameter("code");
			String phone = request.getParameter("phone");
			String forgot = request.getParameter("forgot");
			System.out.println(code);
			System.out.println(phone);
			System.out.println(forgot);
			try {
				if(rand.equals(code)){
				pushData.append("IsSuccess", true);
				pushData.append("Message", "ͼ����֤�ɹ�");
				}else{
				pushData.append("IsSuccess", false);
				pushData.append("Message", "ͼ����֤ʧ��");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(pushData.toString());
		}
		/**
		 * ע����ʦ
		 */
		if(act.equals("register_teacher")){
			HttpSession sess = request.getSession();
			String ccode =(String)sess.getAttribute("register_code");
			String code=request.getParameter("code").trim();
			if(ccode.equals(code)){

				String realname=request.getParameter("name").trim();
				String telephone=request.getParameter("phone").trim(); 
				String password=request.getParameter("password").trim();
				String id = "te-"+new UID().toString();
				dbEntity db = new dbEntity();
				String pars[]=new String[]{id,realname,telephone,password};
				if(!db.registerTeacher(pars)){
						try {
							pushData.append("IsSuccess", false);
							pushData.append("Message", "ע����ʦʧ�ܣ�");
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						try {
							pushData.append("IsSuccess", true);
							pushData.append("Message", "ע����ʦ�ɹ���");
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						TeacherInfo teaInf = new TeacherInfo();
						teaInf.setId(id);
						teaInf.setRealname(realname);
						teaInf.setTelephone(telephone);
						sess.setAttribute("teaInf", teaInf);//ע��ɹ����û���Ϣ��ʱ����session��
					}
				
			}else{
				try {
						pushData.append("IsSuccess", false);
						pushData.append("Message", "��֤���������");
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out.println(pushData.toString());
		}
		/**
		 * ע����ʦ��ϸ��Ϣ;
		 */
		if(act.equals("SaveTeacher_DetailInf")){ 
			String province=request.getParameter("province").trim();
			String city=request.getParameter("city").trim(); 
			String address=request.getParameter("address").trim();
			String school=request.getParameter("school").trim();
			String profession=request.getParameter("profession").trim();
			String selfimg=request.getParameter("selfimg").trim();
			String workimg=request.getParameter("workimg").trim();
			String introduction=request.getParameter("introduction").trim();
			String details=request.getParameter("details").trim();
			String bankaccount=request.getParameter("bankaccount").trim();
			String des_bank=request.getParameter("des_bank").trim();
			
			HttpSession sess = request.getSession();
			TeacherInfo teaInf =(TeacherInfo) sess.getAttribute("teaInf");
			
			String id = teaInf.getId();
			dbEntity db = new dbEntity();
			String pras[]=new String[]{province,city,address,school,profession,selfimg,workimg,introduction,details,bankaccount,des_bank,id};
			if(db.saveTeacherInf(pras)){
				try {
					pushData.append("IsSuccess", true);
					pushData.append("Message", "��Ϣ����ɹ�");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					pushData.append("IsSuccess", false);
					pushData.append("Message", "��Ϣ����ʧ�ܣ�");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out.println(pushData.toString());
		}
		
		/**
		 * ע��ѧԱ
		 */
		if(act.equals("register_student")){
			HttpSession sess = request.getSession();
			String ccode =(String)sess.getAttribute("register_code");
			String code=request.getParameter("code").trim();
			if(ccode.equals(code)){
			String realname=request.getParameter("name").trim();
			String telephone=request.getParameter("phone").trim(); 
			String password=request.getParameter("password").trim();
			String id = "st-"+new UID().toString();
			dbEntity db = new dbEntity();
			String pars[]=new String[]{id,realname,telephone,password};
			if(!db.registerStudent(pars)){
				try {
					pushData.append("IsSuccess", false);
					pushData.append("Message", "ע��ѧԱʧ�ܣ�");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					pushData.append("IsSuccess", true);
					pushData.append("Message", "ע��ѧԱ�ɹ���");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				StudentInfo stuInf = new StudentInfo();
				stuInf.setId(id);
				stuInf.setRealname(realname);
				stuInf.setTelephone(telephone);
				sess.setAttribute("userInf", stuInf);//ע��ɹ����û���Ϣ��ʱ����session��
			}
			}else{
				try {
					pushData.append("IsSuccess", false);
					pushData.append("Message", "��֤���������");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			out.println(pushData.toString());
		}
		System.out.println(pushData.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
