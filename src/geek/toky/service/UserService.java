package geek.toky.service;

import geek.toky.bean.PageBean;
import geek.toky.bean.User;
import geek.toky.dao.UserDao;

import java.util.List;



public class UserService {
	private UserDao userDao=new UserDao();
	
	//为查询一页数据提供业务逻辑
	public PageBean getPage(int pageSize, int pageNo) {
		
		List<User> users= userDao.selectPage(pageSize, pageNo);
		System.out.println(users.get(1).get_class()+users.get(1).getId());
		long count= userDao.selectUserCount();
		//如果一共count条数据，每一页数据有pageSize个，问，一共有多少页。
		//count/pageSize页。
		long pageSum=count/pageSize+(count%pageSize==0?0:1);
		PageBean pageBean=new PageBean();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setPageSum((int) pageSum);

		pageBean.setUsers(users);
		return pageBean;
		
	}
	public void addUser(String id,String name,String _class,String sex,String qq,String phone,String moredetail) {
		userDao.insertToUser(id,name, _class, sex,qq,phone,moredetail);
	}
	public void delUser(String id) {
		userDao.deleteUser(id);
	}
	public void updateUser(String id,String name,String _class,String sex,String qq,String phone,String modetail) {
		userDao.updateUser(id, name, _class, sex, qq, phone,modetail);
	}
	public User selectUser(String id) {
		return userDao.selectUser(id);
	}
	
}
