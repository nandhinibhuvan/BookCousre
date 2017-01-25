package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.train.ConnectionBook;
import com.revature.training.Book;

public class DAObook {
	JdbcTemplate  jdbctemplate=ConnectionBook.getJdbcTemplate();

	   public void addbook(Book book)
	   {
		   String sql="insert into book(id,name) values(?,?)";
		   Object[] params={book.getId(),book.getName()};
		   int rows=jdbctemplate.update(sql,params);
		   System.out.println("number of rows inserted"+rows);
		   
	   }

	        public void removebook(int id)
	{
		   String sql="delete from book where id=?";
		   int rows=jdbctemplate.update(sql,id);
		   System.out.println("number of rows deleted"+rows);
		   
	}
	        public void updatebook(Book book)
	        {
	        	   String sql="update  book SET name=? where id=?";
	        	   Object[] params={book.getName(),book.getId()};
	        	   int rows=jdbctemplate.update(sql,params);
	        	   System.out.println("number of rows updated"+rows);
	        	   
	        }
	        public List<Book> selectbook()
	        {
	        	   String sql="select id,name from book";
	        	   List<Book> list=jdbctemplate.query(sql,(rs,rowNO)->
	        			   {
	        	  Book book=new Book();
	        	  book.setId(rs.getInt("id"));
	        	  book.setName(rs.getString("name"));
	        			   return book;
	        					   }); 
	        	 return list;
	        	   
	        }
	        
	}


