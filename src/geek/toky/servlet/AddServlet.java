package geek.toky.servlet;
import geek.toky.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private UserService userService =new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//获取参数
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String _class=request.getParameter("_class");
		String sex=request.getParameter("sex");
		String qq=request.getParameter("qq");
		String phone=request.getParameter("phone");
		String moredetail=request.getParameter("moredetail");
		//调用业务逻辑
		userService.addUser(id,name,_class,sex, qq,phone,moredetail);
		//跳转到主页

		response.getWriter().print("<script language='javascript'  charset=\"UTF-8\" > alert('注册成功');</script>");

		response.sendRedirect("manager.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
