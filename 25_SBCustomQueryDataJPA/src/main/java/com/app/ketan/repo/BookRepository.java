package com.app.ketan.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ketan.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
	//SQL: select * from where author = ?
	List<Book> findByAuthor(String author);
	//List<Book> findByauthor(String author);
	//List<Book> findByauthorIs(String author);
	List<Book> findByAuthorEquals(String Author);
	
	//SQL: select * from book where bookType = ?
	//invalid :findBybtype , findbybooktype, findbookbytype
	//valid: findBybookType , findByBookType.
	
	List<Book> findByBookType(String bookType);
	
//findBy -->SELECT + where = !=, > < null, not null, and or...
	//SQL: select * from book where book_cost=? 
	List<Book> findByBookCostLessThanEqual(double bookCost);
	
	//select * from Book where book_id != ?
	List<Book> findByBookIdNot(Integer bookId);
	
	//SQL: select * from Book where cost = ?
	List<Book> findByBookCostEquals(double bookCost);
	
	//SQL: select * from book where cost >= ?
	List<Book> findByBookCostGreaterThan(double bookCost);
	
	//SQL: select * from book where cost >= ?
	List<Book> findByBookCostGreaterThanEqual(double bookCost);
	
	//SQL: select * from Book where author is null;
	List<Book> findByAuthorIsNull();
	
	//SQL: select * from Book author is not null
	List<Book> findByAuthorIsNotNull();
	
	
//--------Like Operator--------------//
	
	//SQL: select * from Book where author like ?
	List<Book> findByAuthorLike(String expression);
	
	//SQL: select * from book where author like ? order by bookname desc;
	List<Book> findByAuthorLikeOrderByBookNameDesc(String expression);
	
	//SQL: select * from book where author not like ?
	List<Book> findByAuthorNotLike(String expression);

	//SQL: select * from book where author like 'input%'
	List<Book> findByAuthorStartingWith(String input);
	
 	//SQL: select * from book where author like '%input';
	List<Book> findByAuthorEndingWith(String input);
	
	//SQL: select * from book where author like '%input%'
	List<Book> findByAuthorContaining(String expression);
	
	//SQL: select * from book where bid between x and y;
	List<Book> findByBookIdBetween(Integer id1, Integer id2);
	
//--------- AND / OR --------------------//
	
	//SQL: select * from book where bid <= ? or btype like ?
	List<Book> findByBookIdLessThanEqualOrBookTypeLike(Integer id, String bookType);
	
	//SQL select * from book where bcost != ? and author not like
	List<Book> findByBookCostNotAndAuthorNotLike(double bookCost, String author);
	
//----------- Single Row------------------//
	Optional<Book> findByBookIdIs(Integer id);
	
	
}
