package trytest.restful.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trytest.jpa.bean.Category;
import trytest.restful.bean.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{
	//by default the parent interface JPArepo already has BASIC CRUD actions
	//[Integer] means the primary key of Category is [Integer]
	//self-define method no need SQL sentence, just based on the rules...
	
	public List<Student>  findByName(String name);
		
	public List<Student> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name,int id);
	
	
}
