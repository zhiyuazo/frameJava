package trytest.json.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trytest.json.bean.Book;

public interface BookDao extends JpaRepository<Book, Integer>{
	//by default the parent interface JPArepo already has BASIC CRUD actions
	//[Integer] means the primary key of Category is [Integer]
	//self-define method no need SQL sentence, just based on the rules...
	
	public List<Book>  findByName(String name);
		
	public List<Book> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name,int id);
	
	
}
