package guru.springframework.jdbc.dao;

import org.springframework.stereotype.Component;

import guru.springframework.jdbc.domain.Author;
import guru.springframework.jdbc.repositories.AuthorRepository;
import jakarta.transaction.Transactional;

/**
 * Created by jt on 8/28/21.
 */
@Component
public class AuthorDaoImpl implements AuthorDao {
	private final AuthorRepository authorRepository;
	
	
    public AuthorDaoImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@Override
    public Author getById(Long id) {
        return authorRepository.getReferenceById(id);
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional // if we dont do @Transactional, then every call to the repository will be running in its own transaction. Here we would have 2 calls to the repository that need to be within the same transaction
    @Override
    public Author updateAuthor(Author author) {
    	
    	Author foundAuthor = authorRepository.getReferenceById(author.getId());
    	foundAuthor.setFirstName(author.getFirstName());
    	foundAuthor.setLastName(author.getLastName());
        return authorRepository.save(foundAuthor);
    }

    @Override
    public void deleteAuthorById(Long id) {
    		authorRepository.deleteById(id);
    }
}
