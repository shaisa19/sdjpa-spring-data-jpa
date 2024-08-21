package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;

public interface BookDao {
	
	Book findByIsbn(String isbn);
	
	Book getById(Long id);
	
	Book findByTitle(String title);
	
	Book saveNewBook (Book book);
	
	Book updateBook (Book book);
	
	void deleteBookById (Long id);	

}
