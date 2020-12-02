 package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegisterServlet
 */
//@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userID = request.getParameter("userID");
		String userPW1 = request.getParameter("userPW1");
		String userPW2 = request.getParameter("userPW2");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		if(userID == null || userID.equals("") || userPW1 == null || userPW1.equals("") || userPW2 == null || userPW2.equals("") ||
		   userName == null || userName.equals("") || userAge == null || userAge.equals("") ||
		   userGender == null || userGender.equals("") || userEmail == null || userEmail.equals("")) {
			request.getSession().setAttribute("messageType", "오류메세지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요");
			response.sendRedirect("index.jsp");
			return;
		}
		if(!userPW1.equals(userPW2)) {
					request.getSession().setAttribute("messageType", "오류메세지");
					request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다");
					response.sendRedirect("index.jsp");
					return;
				}
		
		int result = new UserDAO().register(userID, userPW1, userName, userAge, userGender, userEmail);
		if(result == 1) {
			request.getSession().setAttribute("messageType", "성공메세지");
			request.getSession().setAttribute("messageContent", "회원 가입에 성공 했습니다");
			response.sendRedirect("index.jsp");
			return;
		} else {
			request.getSession().setAttribute("messageType", "오류메세지");
			request.getSession().setAttribute("messageContent", "회원 가입에 실패 했습니다");
			response.sendRedirect("index.jsp");
			return;
		}
				
	}

}
