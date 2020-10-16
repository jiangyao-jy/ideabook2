package com.cssl.service;

import com.cssl.pojo.BookManage;
import com.cssl.pojo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface BookManageService {
	//添加
	public boolean addBook(BookManage bm);
	//删除
	public boolean delBook(Integer id);
	//修改
	public boolean updBook(BookManage bm);
	//查询
	public PageInfo selectBook(int pageIndex, int pageSize);
	//按单个查询用做修改
	public BookManage selById(Integer id);
	//3.添加一个登陆的方法，登陆成功后，才可以显示全部数据，未登录禁止添加删除修改数据，（重回登陆界面） ---使用拦截器
    public User loginBook(User u);
}
