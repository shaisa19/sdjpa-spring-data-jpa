package guru.springframework.jdbc.dao;

import org.springframework.stereotype.Component;

import guru.springframework.jdbc.domain.Book;
import guru.springframework.jdbc.repositories.BookRepository;
import jakarta.transaction.Transactional;

@Component
public class BookDaoImpl implements BookDao {
	
	private final BookRepository bookRepository;
	

	public BookDaoImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book getById(Long id) {
		return bookRepository.getReferenceById(id);
	}

	@Override
	public Book findByTitle(String btitle) {
		return bookRepository.findByTitle(btitle);
	}

	@Override
	public Book saveNewBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	@Transactional
	public Book updateBook(Book book) {
		
		Book foudnBook = bookRepository.getReferenceById(book.getId());
		foudnBook.setIsbn(book.getIsbn());
		foudnBook.setTitle(book.getTitle());
		foudnBook.setPublisher(book.getPublisher());
		foudnBook.setAuthorId(book.getAuthorId());		
		return bookRepository.save(foudnBook);
	}

	@Override
	public void deleteBookById(Long id) {
		
		bookRepository.deleteById(id);
	}
	
	

	@Override
	public Book findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

}
