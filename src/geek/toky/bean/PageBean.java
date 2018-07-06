package geek.toky.bean;

import java.util.List;

public class PageBean {
	//一页数据的大小
	private int pageSize;
	//页码
	private int pageNo;
	//页的总数
	private int pageSum;
	//这一页的每一个商品
	private List<User> users;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "PageBean [pageSize=" + pageSize + ", pageNo=" + pageNo + ", pageSum=" + pageSum + ", users="
				+ users + "]";
	}
	
}
