package com.cssl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//实体类
public class BookManage implements Serializable{
	private Integer id;
	private String name;
	private String author;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public BookManage(Integer id, String name, String author, Date time, Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.time = time;
		this.type = type;
	}
	public BookManage() {
		super();
	}
	@Override
	public String toString() {
		return "BookManage [id=" + id + ", name=" + name + ", author=" + author + ", time=" + time + ", type=" + type
				+ "]";
	}
	
	
	
}
