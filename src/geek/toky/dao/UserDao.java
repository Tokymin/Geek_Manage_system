package geek.toky.dao;

import java.sql.SQLException;
import java.util.List;

import geek.toky.bean.User;
import geek.toky.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UserDao {
	//增删查改
		public void insertToUser(String id,String name,String _class,String sex,String qq,String phone,String modetail) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		//除了select用query方法，其余insert、delete、update都用update
		String sql="insert into user(id,name,_class,sex,phone,qq,moredetail) values(?,?,?,?,?,?,?)";
		try {
			qr.update(sql,id,name,_class,sex,phone,qq,modetail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(String id) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="delete from user where id=?";
		try {
			qr.update(sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User selectUser(String id) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select id,name,_class,sex,phone,qq,moredetail from user where id=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateUser(String id,String name,String _class,String sex,String qq,String phone,String moredetail) {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="update user set name=?,_class=?,sex=?,qq=?,phone=?,moredetail=? where id=?";
		try {
//			qr.update(sql,name,num,price,category,id);
			qr.update(sql,name,_class,sex,qq,phone,moredetail,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查一页数据的方法
	//查询需要两个方法支持
	public long selectUserCount() {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select count(*) from user";
		try {
			return (long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//查这一页数据的每一个
	public List<User> selectPage(int pageSize,int pageNo){
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		//select * from tablename
		//where boolean1
		//group by columnname
		//having boolean1
		//order by columnname
		//limit ?,?
		//为啥要分页？
		//表的数据可能数十万条
		//一次性全查出来性能有问题。
		//所以我们想每一次只查询这个表数据的一部分。
		String sql="select id,name,_class,sex,qq,phone,moredetail from user limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class),(pageNo-1)*pageSize,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

	
	
}
