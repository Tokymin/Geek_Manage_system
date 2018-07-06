package geek.toky.servlet;

import geek.toky.utils.C3P0Utils;
import geek.toky.utils.MD5;
import org.apache.commons.dbutils.QueryRunner;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("shaqingk");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		MD5 md5 = new MD5();
		String md5str=md5.getMD5ofStr(password);
		//把id和password放入数据库
		System.out.println(id+":"+username+":"+md5str);
		//存入account表
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		System.out.println("hehehe");
		//除了select用query方法，其余insert、delete、update都用update
		String sql="insert into account(id,username,password) values(?,?,?)";
		try {
			qr.update(sql,id,username,md5str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.print("<script>alert(\"注册成功!\");</script>");

		response.sendRedirect("login.html");
	}

}
