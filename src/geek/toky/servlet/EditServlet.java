package geek.toky.servlet;

import geek.toky.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private UserService userService =new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取参数
		System.out.println("开始更改了");
		String id=request.getParameter("mody_id");
		String name=request.getParameter("mody_name");
		String _class=request.getParameter("mody__class");
		String sex=request.getParameter("mody_sex");
		String qq=request.getParameter("mody_qq");
		String phone=request.getParameter("mody_phone");
		String moredetail=request.getParameter("mody_moredetail");
		System.out.println("开始更改了2"+id+":"+name+":"+_class+":"+sex+":"+qq+":"+phone+":"+moredetail);
		userService.updateUser(id,name,_class,sex, qq,phone,moredetail);
		//跳转
		response.sendRedirect("manager.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
