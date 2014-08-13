package exam.student.logindao;

import java.sql.*;

import javax.sql.DataSource;

import exam.student.bean.StudentLoginBean;

public class StudentLoginDaoImpl implements StudentLoginDao{
 DataSource dataSource;
 public void setDataSource(DataSource dataSource){
	 this.dataSource=dataSource;
 }
	@Override
	public boolean checkLogin(StudentLoginBean s) {
 try{
	 Connection con=dataSource.getConnection();
	 Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from student where username='"+s.getUsername()+"' and password='"+s.getPassword()+"'");
  if(rs.next())
	  return true;
  else return false;
 }
 catch(Exception e){
	 System.out.println(e.getMessage());
 }
  return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
