package exam.student.questionsdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import exam.student.bean.StudentQuestionBean;

public class QuestionDaoImpl implements QuestionsDao{
    DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public StudentQuestionBean getQuestion(int i) {
		 StudentQuestionBean sq=new StudentQuestionBean();
		    
		try{
    	 Connection con=dataSource.getConnection();
    	 Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("select * from question where sno="+i);
   if(rs.next())
   {
	   sq.setQuestion(rs.getString(2));
	   sq.setOption1(rs.getString(3));
	   sq.setOption2(rs.getString(4));
	   sq.setOption3(rs.getString(5));
	   sq.setOption4(rs.getString(6));
	   sq.setAnswer(rs.getString(7));    
   }
   else
	   sq=null;
   
     }
     catch(Exception e){
    	 
     }
    return sq;
	}
	
	
	
	
	

}

//QuestionDaoImpl change to name
