package geek.toky.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geek.toky.bean.PageBean;
import geek.toky.service.UserService;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/page")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private UserService userService =new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pagesize=request.getParameter("pagesize");
		String pageno=request.getParameter("pageno");
		int pageSize=Integer.parseInt(pagesize);
		int pageNo=Integer.parseInt(pageno);
		PageBean pageBean= userService.getPage(pageSize, pageNo);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(JSONObject.fromObject(pageBean));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
