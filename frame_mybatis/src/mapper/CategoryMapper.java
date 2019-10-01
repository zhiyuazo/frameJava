package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import bean.Category;
import bean.Product;

public interface CategoryMapper {
	@Select("select * from category_")
	@Results({
			@Result(property="id" ,column="id"),
			@Result(property="name" ,column="name"),
			@Result(property="products" ,
					javaType=List.class,
					column="id" ,
					many=@Many(select = "mapper.ProductMapper.listByCategory"))
			}
	)
	public List<Category> list();
	
	
	@Select(" select * from category_ where id = #{id}")
	public Category get(int id);
}
