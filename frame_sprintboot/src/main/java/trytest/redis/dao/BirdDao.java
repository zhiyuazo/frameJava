package trytest.redis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trytest.jpa.bean.Category;
import trytest.redis.bean.Bird;

public interface BirdDao extends JpaRepository<Bird, Integer>{
	//by default the parent interface JPArepo already has BASIC CRUD actions
	//[Integer] means the primary key of Category is [Integer]
	//self-define method no need SQL sentence, just based on the rules...
	
	public List<Bird>  findByName(String name);
		
	public List<Bird> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name,int id);

	
	
}
