package com.cssl.controller;

import com.cssl.pojo.BookManage;
import com.cssl.pojo.User;
import com.cssl.service.BookManageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.expression.Ids;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookManageController {

    @Autowired
    private BookManageService service;

    int num=1;
    PageInfo info =null;

    @RequestMapping("fy1.action")
    public String fy1(String fx, RedirectAttributes attr){
        if("firstPage".equals(fx)){
            //显示首页
            num=1;
        }else if ("prePage".equals(fx)) {
            //上一页
            num=info.getPrePage();
        }else if ("nextPage".equals(fx)) {
            //下一页
            num=info.getNextPage();
        }else if ("lastPage".equals(fx)) {
            //末页
            num=info.getPages();
        }
        return "redirect:list.action";
    }





    @RequestMapping("/list.action")
    public String selectBook(Integer pageIndex, Model model) throws JsonProcessingException {

/*        System.err.println("查询方法controller=========");
        System.out.println("BookManageController......getAll---分页");
        *//*
         * List<BookManage> list = service.selectBook();
         * System.out.println("list:"+list);
         *//*
        //return "forward: list.html";
        System.out.println(pageIndex);
        if (pageIndex == null) {
            pageIndex = 1;
        }*/

        info = service.selectBook(num, 5);
        /*
         * ObjectMapper mapper =new ObjectMapper(); String string
         * =mapper.writeValueAsString(info); System.out.println(string);
         * System.out.println(pageIndex);
         */
        model.addAttribute("pageInfo", info);
        System.out.println("!!!!!!!"+info);
        info.getList().forEach(i -> {
            System.out.println(i);
        });

        return "list";
    }

    @RequestMapping("/add.action")
    //@ResponseBody
    public String addBook(BookManage bm) {
        boolean b = service.addBook(bm);
        if (b) {
            System.out.println("添加成功");
            return "redirect:/list.action";
        }
        System.out.println("添加失败");
        return "redirect:/add.html";
    }

    @RequestMapping("del.action")
    public String delBook(Integer id) {
        boolean b = service.delBook(id);
        if (b) {
            System.out.println("删除成功");
            return "redirect:/list.action";
        }
        System.out.println("删除失败");
        return "redirect:/list.action";
    }

    int id1 ;
    @RequestMapping("selId.action")
    //@ResponseBody
    public String selId(Integer id,Model model) {
        BookManage bm = service.selById(id);
        //System.out.println(bm.getName());
        model.addAttribute("book",bm);
        id1=id;
        return "upd";
    }

    @RequestMapping("upd.action")
    public String updBook(BookManage bm) {
        System.err.println("bm"+bm);
        bm.setId(id1);
        boolean b = service.updBook(bm);
        if(b) {
            System.out.println("修改成功");
            num=1;
            return "redirect:/list.action";

        }
        System.out.println("修改失败");
        return "redirect:/selId.action";
    }

    @RequestMapping("login.action")
    public String loginBook(User u, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", u.getName());
        map.put("password", u.getPassword());
        System.out.println(u.getName() + "    " + u.getPassword());
        User user = service.loginBook(u);
        if (user == null) {
            return "redirect:/login.action";
        }
        session.setAttribute("user", user);
        return "redirect:/list.action";
    }

}
