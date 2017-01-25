package com.revature.dao;

import java.util.List;

import com.revature.training.Book;

public class TestDAObook {

	public static void main(String[] args) {
		Book book=new Book();
		book.setId(3);
        book.setName("ds");
        DAObook bookdao=new DAObook();
       // bookdao.addbook(book);
//        bookdao.remove(2);
     //  bookdao.update(book);
  List<Book> list=bookdao.selectbook();
  for(Book b:list)
  {
	  System.out.println(b);
  }

	}

}
