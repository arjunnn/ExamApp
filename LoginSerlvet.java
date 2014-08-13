package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.student.bean.StudentLoginBean;
import exam.student.logindao.StudentLoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
String u=request.getParameter("user");
String p=request.getParameter("pass");
ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
StudentLoginDaoImpl sl=(StudentLoginDaoImpl) ac.getBean("studentloginbean");
StudentLoginBean sb=new StudentLoginBean();
sb.setPassword(p);
sb.setUsername(u);
boolean t=sl.checkLogin(sb);
PrintWriter pw=response.getWriter();
if(t)
{
	//valid
	pw.println("WELCOME:"+u);
	RequestDispatcher rd=request.getRequestDispatcher("startexam.html");
rd.include(request,response);
}
else{
	//not valid
pw.println("INVALID USERNAME OR PASSWORD");
RequestDispatcher rd=request.getRequestDispatcher("login.html");
rd.include(request,response);

}
	}

	
	
	
	
	
	
	
}
