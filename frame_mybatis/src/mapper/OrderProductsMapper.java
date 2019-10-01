package mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import bean.OrderProducts;

public interface OrderProductsMapper {
	@Select(" select * from order_product_ where oid = #{oid}")
    @Results({ 
        @Result(property="product",
        		column="pid",
        		one=@One(select="mapper.ProductMapper.get")) 
    }) 
    public List<OrderProducts> listByOrder(int oid);
}
