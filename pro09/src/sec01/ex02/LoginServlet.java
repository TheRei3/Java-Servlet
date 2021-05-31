package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login1")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data= "안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data += "<html><body>" ;
		data += "아이디 : "+user_id +"<br>";
		data += "비밀번호 : "+user_pw +"<br>";
		data += "주소 : "+user_address +"<br>";
		data += "이메일 : "+user_email +"<br>";
		data += "휴대전화 : "+user_hp +"<br>";
		out.print(data);
		
		user_address=URLEncoder.encode(user_address,"utf-8");
		out.print("<a href='/pro09/second?user_id="+user_id+"&user_pw="+
					user_pw+"&user_address="+user_address+"'>두번째 서블릿으로 보내기</a>");
		data += "</body></html>" ;
	}
	
	@Override
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}

}
