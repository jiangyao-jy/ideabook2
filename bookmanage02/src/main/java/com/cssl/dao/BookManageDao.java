package com.cssl.dao;

import com.cssl.pojo.BookManage;
import com.cssl.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public interface BookManageDao  {
	//添加
	public Integer addBook(BookManage bm);
	//删除
	public Integer delBook(Integer id);
	//修改
	public Integer updBook(BookManage bm);
	//查询
	public List<BookManage> selectBook();
	//按单个查询用做修改
	public BookManage selById(Integer id);
	//3.添加一个登陆的方法，登陆成功后，才可以显示全部数据，未登录禁止添加删除修改数据，（重回登陆界面） ---使用拦截器
	public User loginBook(User u);
}
