package com.xfx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import org.json.JSONException;
import org.json.JSONObject;

import com.xfx.Entity.TeacherInfo;
import com.xfx.Entity.dbEntity;
import com.xfx.Entity.userInfo;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		System.out.println("------>登录名："+username);
		JSONObject jo = new JSONObject();
		dbEntity db = new dbEntity();
		String pras[] = new String[]{username,password};
		if(db.userLogin(pras)){
			System.out.println("------>登录成功："+username);
			userInfo usInfo = new userInfo();
			usInfo.setPassword(password);
			usInfo.setTelephone(username);
			HttpSession sess = request.getSession();
			sess.setAttribute("usInf", usInfo);
			response.sendRedirect("tuan/cart.html");
			//request.getRequestDispatcher("tuan/cart.jsp").forward(request, response);
		}else{
			System.out.println("------>登录失败："+username);
			
		}
	    
	        
	}

}
