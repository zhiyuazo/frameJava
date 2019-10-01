package trytest.mybatisxml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import trytest.mybatisxml.bean.Product;

@Mapper
public interface ProductMapper {
    List<Product> findAll();
}
