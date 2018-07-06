package geek.toky.servlet;

import geek.toky.bean.Account;
import geek.toky.bean.User;
import geek.toky.utils.C3P0Utils;
import geek.toky.utils.MD5;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login开始");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("id");
		String password = request.getParameter("password");
		MD5 md5 = new MD5();
		String md5str=md5.getMD5ofStr(password);
		try {
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());

			String sql="select id,username,password from account where id=?";
			Account account=qr.query(sql,new BeanHandler<Account>(Account.class),username);
			System.out.println(account);
			if(account!=null){
				System.out.println("id不为空");

				if(account.getPassword().equals(md5str)){
					response.getWriter().print("true");
//				修改session
				}else{
					System.out.println("密码错误");
					response.getWriter().print("false1");
				}
			}else{
				System.out.println("没有该用户");
				response.getWriter().print("false2");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
