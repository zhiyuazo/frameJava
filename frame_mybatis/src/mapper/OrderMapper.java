package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import bean.Order;

public interface OrderMapper {
	   @Select("select * from order_")
	   @Results({
	            @Result(property = "id", column = "id"),
	            @Result(property = "orderproducts", 
	            		javaType = List.class, 
	            		column = "id", 
	                    many = @Many(select = "mapper.OrderProductsMapper.listByOrder"))
	            })      
	   public List<Order> list();
}
