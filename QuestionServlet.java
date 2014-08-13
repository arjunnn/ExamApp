package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.student.bean.StudentQuestionBean;
import exam.student.questionsdao.QuestionDaoImpl;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/QuestionsServlet")
public class QuestionsServlet extends HttpServlet {
	static int i=1;
	static int count1=0;
	static int count2=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        QuestionDaoImpl qd= (QuestionDaoImpl) ac.getBean("questionsbean");
	/*	String answer=request.getParameter("answer");
        if(answer==null)
        {
        	
        }
        else{
        	String correctanswer=request.getParameter("opt");
        	
        	if(answer.equals(correctanswer))
                 count1++;   		
        	
        	else count2++;
        }*/
		PrintWriter pw=response.getWriter();
       StudentQuestionBean sqb=qd.getQuestion(i);
       System.out.println("i="+i);
       if(sqb!=null){
		pw.println("<form action='http://localhost:4649/ExamApp/qs' method='post'>");
		pw.println(sqb.getQuestion());
		System.out.println(sqb.getQuestion());
		pw.println("<input type='radio' value='1' name='opt'> "+sqb.getOption1()+"</input>");
		pw.println("<input type='radio' value='2' name='opt'> "+sqb.getOption2()+"</input>");
		pw.println("<input type='radio' value='3' name='opt'> "+sqb.getOption3()+"</input>");
		pw.println("<input type='radio' value='4' name='opt'> "+sqb.getOption4()+"</input>");
		pw.println("<input type='hidden' value='"+sqb.getAnswer()+"' name='answer'>");
		pw.println("<input type='submit' value='next' name='result'>");
		
       pw.println("</form>");
       
       i++;
       }
       else{
    	   pw.println("<form action='' method='post'>");	
   		    pw.println("<input type='hidden' value='"+count1+"' name='correct'>");
   		 pw.println("<input type='hidden' value='"+count2+"' name='wrong'>");
		       		    
    	   pw.println("<input type='submit' value='show result'>");
       
       }
		
	}

}
