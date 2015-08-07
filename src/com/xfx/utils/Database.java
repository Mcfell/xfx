package com.xfx.utils;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
 
//import org.apache.log4j.Logger;  
/**
 * MySQL数据库连接工具包
 * @author stando
 *
 */
public class Database {  

	   private static final String DRIVER = "com.mysql.jdbc.Driver";  

	   private static final String URL = "jdbc:mysql://localhost:3306/xfx";  

	   private static final String USERNAME = "root";  

	   private static final String PASSWORD = "admin";  

	   private Connection con = null;
	   
	   private PreparedStatement ps = null ;
	   
	   private ResultSet rs = null;
	   
	   private int resu = 0;
	   static {  
	       try {  
	           Class.forName(DRIVER);  
	       } catch (ClassNotFoundException e) {  
	           e.printStackTrace();  
	       }  
	   }  
   public Database(){
	   con = this.getConnection();
   }
   public Connection getConnection() {  
       Connection conn = null;  
       System.out.println("****连接数据库****");
       try{  
           conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);  
       }catch(SQLException e){  
           e.printStackTrace();  
           System.out.println("****连接数据库失败****");
       }  
       System.out.println("****连接数据库成功****");
       return conn;  
   }  
 /**
  * 关闭连接
  */
   public void closeAll() {  
       if(rs!=null){  
           try{  
               rs.close();  
               rs=null;  
           }catch(SQLException e){  
               e.printStackTrace();  
           }  
       }  
       if(ps!=null){  
           try{  
               ps.close();  
               ps=null;  
           }catch(SQLException e){  
               e.printStackTrace();   
           }  
       }  
       if(con!=null){  
           try{  
               con.close();  
               con=null;  
           }catch(SQLException e){  
               e.printStackTrace();  
           }  
       }  
   }
   
   public void ExcuteQuery(String condition){ //执行查询操作
	   try {
			 ps = con.prepareStatement(condition);
			 rs = ps.executeQuery();
			while (rs.next()) {
				rs.getFloat(3);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
   }
   
   /**  
    * @param sql数据库更新(增、删、改) 语句      
    * @param pras参数列表（可传，可不传，不传为NULL，以数组形式存在）  
    * 
    */  
   public void update(String sql,String... pras){   
       try {  
           ps=con.prepareStatement(sql);  
           for(int i=0;i<pras.length;i++){  
               ps.setString(i+1,pras[i]);  
           }  
           resu=ps.executeUpdate();  
       } catch (SQLException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       }
   }  
 
   /**  
    * @param sql数据库查询语句  
    * @param pras参数列表（可传，可不传，不传为NULL，以数组形式存在）  
    * @return 返回结果集  
    */  
   public ResultSet query(String sql,String... pras){  
       try {  
           ps=con.prepareStatement(sql);  
 
           if(pras!=null)  
               for(int i=0;i<pras.length;i++){  
                   ps.setString(i+1, pras[i]);  
               }  
           rs=ps.executeQuery();  
       } catch (SQLException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       } 
       return rs;  
   }  
   /**
    * 获取更新操作的影响条数
    * @return
    */
   public int getResu(){
	   return resu;
   }

}
  