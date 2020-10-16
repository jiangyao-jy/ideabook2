package com.cssl.serviceimpl;

import com.cssl.dao.BookManageDao;
import com.cssl.pojo.BookManage;
import com.cssl.pojo.User;
import com.cssl.service.BookManageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookManageServiceimpl implements BookManageService{

	@Autowired
	private BookManageDao bookManageDao;
	
	
	
	public BookManageServiceimpl() {
		super();
		System.out.println("业务逻辑层自己this："+this);
	}



	public void setBmdao(BookManageDao bookManageDao) {
		this.bookManageDao = bookManageDao;
		System.out.println("业务逻辑层中dao:"+this.bookManageDao);
	}
	
	
	
	//添加
	@Override
	public boolean addBook(BookManage bm) {
		if (bookManageDao.addBook(bm)>0) {
			return true;
		}
		return false;
	}
	//删除
	@Override
	public boolean delBook(Integer id) {
		if (bookManageDao.delBook(id)>0) {
			return true;
		}
		return false;
	}
	//修改
	@Override
	public boolean updBook(BookManage bm) {
		if (bookManageDao.updBook(bm)>0) {
			return true;
		}
		return false;
	}
	//查询
	@Override
	public PageInfo selectBook(int pageIndex, int pageSize) {
		System.out.println("BookManageServiceimpl......selectBook---分页");
		PageHelper.startPage(pageIndex, pageSize);
		List<BookManage> list=bookManageDao.selectBook();
		PageInfo info = new PageInfo<>(list);
		/*int pages=startPage.getPages();
		long endRow = startPage.getEndRow();
		long total = startPage.getTotal();
		System.out.println("记录数:"+total+"总页数"+pages+"结束行"+endRow);*/
		return info;
	}
	//按单个查询用做修改
	public BookManage selById(Integer id) {
		BookManage bm=bookManageDao.selById(id);
		return bm;
	}
	//添加一个登陆的方法，登陆成功后，才可以显示全部数据，未登录禁止添加删除修改数据，（重回登陆界面） ---使用拦截器
	@Override
	public User loginBook(User u) {
		User u2 = bookManageDao.loginBook(u);
		return u2;
	}

}
