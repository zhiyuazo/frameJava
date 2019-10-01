package trytest.thymeleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import trytest.thymeleaf.bean.Car;

@Mapper
public interface CarMapper {
	public int add(Car car);
    
    public void delete(int id);
         
    public Car get(int id);
       
    public int update(Car car); 
         
    public List<Car> list();
}
