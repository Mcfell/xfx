package com.xfx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.xfx.Entity.TeacherInfo;
import com.xfx.Entity.dbEntity;

/**
 * Servlet implementation class showTeacherInf
 */
@WebServlet("/showTeacherInf")
public class showTeacherInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showTeacherInf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		if(act.equals("showAllTeacher")){
			dbEntity db2 = new dbEntity();
			List<TeacherInfo> teacher = db2.checkAllTeacherInfo();
			Iterator tea = teacher.iterator();
			JSONArray ja = new JSONArray();
			int i=0;
			while(tea.hasNext()){
				JSONObject jo = new JSONObject();
				TeacherInfo teaInf = (TeacherInfo)tea.next();
				try {
					jo.append("id", teaInf.getId());
					jo.append("realName",teaInf.getRealname());
					jo.append("school",teaInf.getSchool());
					jo.append("profession",teaInf.getProfession());
					jo.append("address",teaInf.getAddress());
					jo.append("introduction", teaInf.getIntroduction());	
					jo.append("details",teaInf.getDetails());
					jo.append("curriculums",teaInf.getCurriculums());
					//jo.append("curriculums","中学数学，小学数学");
					jo.append("city",teaInf.getCity());
					jo.append("photo1",teaInf.getPhoto1());
					jo.append("photo2",teaInf.getPhoto2());
					ja.put(jo);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(ja.toString());
			out.println(ja);
		}
		if(act.equals("showTeaById")){
			String id =request.getParameter("id").trim();
			System.out.println(id);
			dbEntity db = new dbEntity();
			TeacherInfo teaInf = db.checkTeacherInfoById(id);
			JSONObject jo = new JSONObject();
			if(teaInf!= null){
				try {
					jo.append("id", teaInf.getId());
					jo.append("realName",teaInf.getRealname());
					jo.append("school",teaInf.getSchool());
					jo.append("profession",teaInf.getProfession());
					jo.append("address",teaInf.getAddress());
					jo.append("introduction", teaInf.getIntroduction());	
					jo.append("details",teaInf.getDetails());
					//jo.append("curriculums",teaInf.getCurriculums());
					jo.append("curriculums","中学物理");
					jo.append("city",teaInf.getCity());
					jo.append("photo1",teaInf.getPhoto1());
					jo.append("photo2",teaInf.getPhoto2());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println(jo.toString());
			out.println(jo);
		}
		out.flush();
		out.close();
	}

	private String encodeURI(String trim) {
		// TODO Auto-generated method stub
		return null;
	}

}
