package trytest.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trytest.jpa.bean.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	//by default the parent interface JPArepo already has BASIC CRUD actions
	//[Integer] means the primary key of Category is [Integer]
	//self-define method no need SQL sentence, just based on the rules...
	public List<Category>  findByName(String name);
	public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name,int id);
}
